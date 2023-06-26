package CinemaToten;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//Classe reservar que implementa metodos declarados na interface I_Arquivo
public class Reservar implements I_Arquivo {
	private final String NOME_ARQUIVO;

	public Reservar(String NOME_ARQUIVO) {
		this.NOME_ARQUIVO = NOME_ARQUIVO;
	}

	public boolean reservarAssento(String posAssento, Sessao sessao) throws IOException{ //true se disponivel
		//verificar se um assento esta ocupado quando for selecionado no mapa de assentos

		String chave = sessao.getFilme().getTitulo() + "," + sessao.getData() + "," + sessao.getHorario() + "," + posAssento;
		if (verificarDadoExistente(chave)) { //assento indisponível
			return false;
		}
		return true; //assento disponível
	}

	public double comprarAssentos(int qntMeias, int qntInteiras,String nome,ArrayList <String> posicoesAssento, Sessao sessao) throws Exception{ //true se comprado
		//verificar se um assento esta ocupado quando o usuario for comprar
		//throws exception se tiver acabado de ser comprado por alguem!
		
		//gravar no arquivo se estiver disponivel
		ArrayList<Ingresso> listaIngressos= new ArrayList<>();
		double precoFinal = 0;
		
		//Antes de gravar no arquivo, verifica-se se todos os assentos estão disponíveis
		for (String posAssento : posicoesAssento) { 
			String chave = sessao.getFilme().getTitulo() + "," + sessao.getData() + "," + sessao.getHorario() + "," + posAssento;			
			if (verificarDadoExistente(chave)) {
				throw new Exception("O assento foi comprado por outro usuário."); 
			}
		}		
		//se estiverem todos disponíveis, se realiza a compra de cada um
		for (String posAssento : posicoesAssento) { 
			String chave = sessao.getFilme().getTitulo() + "," + sessao.getData() + "," + sessao.getHorario() + "," + posAssento;			
			// Adiciona o dado ao arquivo CSV
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
				this.gravarArquivo(chave);
				if (qntMeias > 0) {
					IngressoMeia meia = new IngressoMeia(posAssento,nome,0.5,sessao);
					listaIngressos.add(meia);
					precoFinal += meia.getPreco();
					qntMeias--;
				}
				else if (qntInteiras > 0) {
					IngressoInteira inteira = new IngressoInteira(posAssento,nome,sessao);
					listaIngressos.add(inteira);
					precoFinal += inteira.getPreco();
					qntInteiras--;
				}
			}
		}
		
		//Cria um arquivo imagem contendo os dados dos  ingressos e valor total pago 
		Recibo recibo = new Recibo(precoFinal, sessao.getData(), sessao.getHorario(), sessao.getFilme().getTitulo(), nome,posicoesAssento);
		String nomeArquivo = recibo.toImg();	
		try {
		    String os = System.getProperty("os.name").toLowerCase();
		    ProcessBuilder pb;

		    if (os.contains("win")) {
		        pb = new ProcessBuilder("explorer", nomeArquivo);
		    } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
		        pb = new ProcessBuilder("xdg-open", nomeArquivo);
		    } else {
		        throw new UnsupportedOperationException("Sistema operacional não suportado.");
		    }

		    pb.start();
		} catch (IOException e) {
		    System.out.println("Erro ao abrir a imagem: " + e.getMessage());
		}
		return precoFinal;
	}

	//Metodo que verifica se o dado (assento) ja existe no arquivo, se existir o assento esta ocupado
	public boolean verificarDadoExistente(String dado) throws IOException {
		return Files.lines(Paths.get(NOME_ARQUIVO)).anyMatch(line -> line.equals(dado));
	}

	//Metodo que grava o conteudo(posicao do assento e dados do filme) no arquivo especificado
	@Override
	public boolean gravarArquivo(String conteudo) throws IOException {
		try {
			//salva o conteudo em um arquivo de nome especificado previamente
			FileWriter escritor = new FileWriter(NOME_ARQUIVO, true);
			escritor.write(conteudo + "\n");
			escritor.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Metodo que le o arquivo especificado 
	@Override
	public String lerArquivo() throws IOException {
		try {
			//Busca um arquivo com nome especificado e le seu conteudo
			return new String(Files.readAllBytes(Paths.get(NOME_ARQUIVO)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}






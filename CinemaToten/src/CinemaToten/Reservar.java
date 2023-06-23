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

	public void comprarAssentos(ArrayList <String> posicoesAssento, Sessao sessao) throws Exception{ //true se comprado
		//verificar se um assento esta ocupado quando o usuario for comprar
		//throws exception se tiver acabado de ser comprado por alguem!
		//gravar no arquivo se estiver disponivel

		//antes de gravar no arquivo, verifica-se se todos os assentos estão disponíveis
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
			}
		}
	}

	public boolean verificarDadoExistente(String dado) throws IOException {
		return Files.lines(Paths.get(NOME_ARQUIVO)).anyMatch(line -> line.equals(dado));
	}

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






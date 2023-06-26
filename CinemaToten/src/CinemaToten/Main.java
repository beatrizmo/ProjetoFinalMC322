package CinemaToten;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MainTeste {
	
	public static void createCSVFile() {
		
		String fileName = "AssentosReservados.csv";

		//Cria objeto do tipo file chamado "AssentosReservados.csv"
		File file = new File(fileName);

		// Verifica se o arquivo já existe
		if (!file.exists()) {
			try {
				// Cria o arquivo se ele não existir
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Lista todas os filmes ja instanciadas e que estao na lista de filmes
	public static void listarFilmes(ArrayList<Filme> listaFilmes) {
		
		System.out.println("----- Lista de filmes disponíveis -----");
		
		for (Filme filme : listaFilmes) {
			System.out.println(listaFilmes.indexOf(filme)+1 + ". " + filme.getTitulo());
		}
	}

	//Lista todas as sessoes ja instanciadas e que estao na lista de sessoes
	public static void listarSessoes(ArrayList<Sessao> listaSessoes, Filme filme) {
		
		System.out.println("----- Lista de sessões disponíveis -----");
		
		for (Sessao sessao : listaSessoes) {
			System.out.println(listaSessoes.indexOf(sessao)+1 + ". " + sessao.getData() +" - "+ sessao.getHorario());
		}
	}

	
	//Exibe os filmes disponiveis para a selecao e encaminha para a escolha de sessao
	public static void escolherFilme(Scanner scanner, ArrayList<Filme> listaFilmes,ArrayList<Sessao> listaSessoes, Reservar reserva) throws IOException {
		int filmeIndex;
		boolean filmeValido = false;
		Filme filmeEscolhido = null;
		new Entrada(listaSessoes);
		
		listarFilmes(listaFilmes);
		System.out.println("0. Voltar para o menu inicial");

		do {
			System.out.print("Escolher um filme: ");
			filmeIndex = scanner.nextInt();

			if (filmeIndex == 0) {
				return;
			}

			for (Filme filme : listaFilmes) {
				if (listaFilmes.indexOf(filme) == filmeIndex-1) {
					filmeValido = true;
					filmeEscolhido = filme;
					break;
				}
			}

			if (!filmeValido) {
				System.out.println("Escolha inválida. Tente novamente.");
			}
		} while (!filmeValido);

		escolherSessao(scanner, listaSessoes, filmeEscolhido, reserva);
	}
	
	//Escolher sessao com base no filme selecionado
	public static void escolherSessao(Scanner scanner, ArrayList<Sessao> listaSessoes, Filme filme, Reservar reserva) throws IOException {
		int escolha;
		
		ArrayList<Sessao> sessoesDisp = new ArrayList<>();
		
		//Procura todas as sessoes disponiveis para aquele filme
		for (Sessao sessao : listaSessoes) {
			if (sessao.getFilme().equals(filme))
				sessoesDisp.add(sessao);
		}
		do {
			listarSessoes(sessoesDisp, filme);
			System.out.println("0. Voltar para menu inicial");

			System.out.print("Escolha uma sessão disponível: ");
			escolha = scanner.nextInt();

			if (escolha == 0) {
				return;
			}
		} while (escolha < 0 || escolha > sessoesDisp.size());

		// Processar a sessão escolhida
		System.out.println("Você selecionou a sessão: " + sessoesDisp.get(escolha - 1));
		escolherAssentos(scanner, sessoesDisp.get(escolha-1), reserva);
	}
	
	//Escolhe um assento para uma sessao passada como parametro
	public static void escolherAssentos(Scanner scanner, Sessao sessao, Reservar reserva) throws IOException {
		
		System.out.print("Digite o numero de ingressos meia-entrada você quer comprar: ");
		int qntMeias = scanner.nextInt();
		
		System.out.print("Digite o numero de ingressos inteira você quer comprar: ");
		int qntInteiras = scanner.nextInt();
		int qntAssentos = qntMeias + qntInteiras;
		
	    ArrayList<String> listaAssentos = new ArrayList<>();
	    scanner.nextLine(); //consumindo a quebra de linha
	    
	    for (int i = 0; i < qntAssentos; i++) {
	        System.out.print("Digite qual o assento nº " + (i + 1) + ": ");
	        
	        String numAssento = scanner.nextLine();

	        // Encontre o assento escolhido na lista de assentos
	        Assento AssentoSelec = null;
	        for (Assento assento : sessao.getListaAssentos()) {
	            if (assento.getPosAssento().equals(numAssento)) {
	            	AssentoSelec = assento;
	                break;
	            }
	        }

	        if (AssentoSelec != null && reserva.reservarAssento(AssentoSelec.getPosAssento(), sessao)) {
	            System.out.println("Assento " + numAssento + " foi reservado.");
	            listaAssentos.add(AssentoSelec.getPosAssento());
	        } else {
	            System.out.println("Assento " + numAssento + " não está disponível.");
	            i--; // Tentar nova seleção.
	        }
	    }
	    realizarCompra(qntMeias, qntInteiras, scanner, reserva, listaAssentos, sessao);
	}

	
	
	//Apos escolhido a sessao e o assento é feito a compra
	
	public static void realizarCompra(int qntMeias, int qntInteiras, Scanner scanner, Reservar reserva, ArrayList<String> listaAssentos, Sessao sessao) {
		
		System.out.print("Deseja finalizar a compra? (S/N): ");
	    String finalizar = scanner.nextLine();
	    System.out.print("Digite o nome do comprador: ");
	    String nome = scanner.nextLine();

	    if (finalizar.equalsIgnoreCase("S")) {
	    	try {
				double precoFinal = reserva.comprarAssentos(qntMeias, qntInteiras, nome, listaAssentos, sessao);
				System.out.println("Compra realizada com sucesso! Valor: " + precoFinal);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	    else {
	    	System.out.println("Compra cancelada.");
	    }
	}

	//Menu de selecao exibido ao executar o programa
	public static void mostrarMenu(ArrayList<Sessao> listaSessoes, ArrayList<Filme> listaFilmes, Reservar reserva) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int escolha;

		do {
			System.out.println("\n----- Menu -----");
			System.out.println("1. Escolher um filme");
			System.out.println("2. Sair");

			System.out.print("Entre com sua escolha: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				escolherFilme(scanner, listaFilmes, listaSessoes, reserva);
				break;
			case 2:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Escolha invalida. Tente novamente.");
			}
		} while (escolha != 2);

		scanner.close();
	}

	public static void main(String[] args) throws CsvValidationException {
		
		createCSVFile();
		
		// Instancia lista de filmes
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		String caminhoArquivo = "ListaFilmes.csv";
		try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
			String[] linha;
			boolean primeiraLinha = true;
			while ((linha = reader.readNext()) != null) {

				if (primeiraLinha) {
					primeiraLinha = false;
					continue; // Ignora a primeira linha do arquivo, que contem titulos 
				}

				// Verifica se a linha possui todos os campos necessários
				if (linha.length >= 3) {
					String titulo = linha[0];
					String sinopse = linha[1];
					String duracao = linha[2];

					//Instancia um objeto do tipo filme para cada filme da lista de filmes
					Filme filme = new Filme(titulo, sinopse, duracao);
					listaFilmes.add(filme);
					//System.out.println(filme.toString());

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Cria uma lista com as datas em que os filmes serão exibidos
		ArrayList<String> listaDatas = new ArrayList<>();
		listaDatas.add("28/06");
		listaDatas.add("29/06");
		listaDatas.add("30/06");
		
		//Cria uma lista com os horarios que os filmes serao exibidos
		ArrayList<String> listaHorarios = new ArrayList<>();
		listaHorarios.add("14h");
		listaHorarios.add("16h");
		listaHorarios.add("18h");
		
		ArrayList<Sessao> listaSessoes = new ArrayList<>();
		//Para cada data da listaDatas é criado uma sessao em cada um dos horarios
		for (int i=0; i< listaFilmes.size(); i++) {
			for (int j=0; j < listaDatas.size(); j++) {
				for (int k=0; k < listaHorarios.size(); k++) {
					Sessao sessao = new Sessao(listaFilmes.get(i), 6,5, listaHorarios.get(k), listaDatas.get(j));
					listaSessoes.add(sessao);
				}
			}
		}

		
		Reservar reserva = new Reservar("AssentosReservados.csv");
		try {
			mostrarMenu(listaSessoes, listaFilmes, reserva);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}



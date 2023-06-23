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

		//cria objeto do tipo file chamado "AssentosReservados.csv"
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

	public static void listarSessoes(ArrayList<Sessao> listaSessoes, Filme filme) {
		System.out.println("----- Lista de sessões disponíveis -----");
		for (Sessao sessao : listaSessoes) {
			System.out.println(listaSessoes.indexOf(sessao)+1 + ". " + sessao.getData() +" - "+ sessao.getHorario());
		}
	}

	public static void listarFilmes(ArrayList<Filme> listaFilmes) {
		System.out.println("----- Lista de filmes disponíveis -----");
		for (Filme filme : listaFilmes) {
			System.out.println(listaFilmes.indexOf(filme)+1 + ". " + filme.getTitulo());
		}
	}

	public static void escolherSessao(Scanner scanner, ArrayList<Sessao> listaSessoes, Filme filme) {
		int escolha;
		ArrayList<Sessao> sessoesDisp = new ArrayList<>();
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
	}

	public static void escolherFilme(Scanner scanner, ArrayList<Filme> listaFilmes,ArrayList<Sessao> listaSessoes) {
		int filmeIndex;
		boolean filmeValido = false;
		Filme filmeEscolhido = null;

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

		escolherSessao(scanner, listaSessoes, filmeEscolhido);
	}

	public static void mostrarMenu(ArrayList<Sessao> listaSessoes, ArrayList<Filme> listaFilmes) {
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
				escolherFilme(scanner, listaFilmes, listaSessoes);
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

		//Reservar reserva = new Reservar("AssentosReservados.csv");
		mostrarMenu(listaSessoes, listaFilmes);

	}


}



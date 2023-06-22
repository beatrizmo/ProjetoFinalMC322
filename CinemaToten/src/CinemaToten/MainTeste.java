package CinemaToten;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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


	public static void main(String[] args) throws CsvValidationException {

		createCSVFile();		

		// Instancia lista de filmes
		ArrayList<Filme> listaFilmes = new ArrayList<>();

		String caminhoArquivo = "ListaFilmes.csv";

		try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
			String[] linha;
			while ((linha = reader.readNext()) != null) {
				// Verifica se a linha possui todos os campos necessários
				if (linha.length >= 3) {
					String titulo = linha[0];
					String sinopse = linha[1];
					String duracao = linha[2];
					
					//Instancia um objeto do tipo filme para cada filme da lista de filmes
					Filme filme = new Filme(titulo, sinopse, duracao);
					listaFilmes.add(filme);
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
		//listaDatas.add("01/07");
		//listaDatas.add("02/07");


		//Cria uma lista com os horarios que os filmes serao exibidos
		ArrayList<String> listaHorarios = new ArrayList<>();
		listaHorarios.add("14h");
		listaHorarios.add("16h");
		listaHorarios.add("18h");
		//listaHorarios.add("20h");

		ArrayList<Sessao> listaSessoes = new ArrayList<>();

		//Para cada data da listaDatas e criado uma sessao
		for (int i=0; i< listaDatas.size(); i++) {
			Sessao sessao = new Sessao(listaFilmes.get(i), 6,5, listaHorarios.get(i), listaDatas.get(i));
			listaSessoes.add(sessao);
		}

		Reservar reserva = new Reservar("AssentosReservados.csv");

		//Para cada data da listaDatas e criado uma sessao
		for (Sessao sessao : listaSessoes) {
			String key = sessao.getFilme().getTitulo() + "," + sessao.getData() + "," 
					+ sessao.getHorario() + "," + sessao.getListaAssentos().get(0).getPosAssento();
			try {
				if (reserva.reservarAssento("A1", sessao)) {
					System.out.println(key + " reservado");
					try {
						reserva.comprarAssento("A1", sessao);
						System.out.println(key + " Assento comprado");

					}
					catch (Exception e1){
						System.out.println(e1.getMessage());
					}
				}
				else {
					System.out.println("Assento ja reservado, não é possivel selecioná-lo");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};

		}
	}

}

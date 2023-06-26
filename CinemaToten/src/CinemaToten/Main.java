package CinemaToten;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

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

	public static ArrayList<Sessao> criarSessoes(ArrayList<Filme> listaFilmes) {
		ArrayList<String> listaDatas = new ArrayList<>();
		ArrayList<String> listaHorarios = new ArrayList<>();
		//Cria uma lista com as datas em que os filmes serão exibidos
		listaDatas.add("28/06");
		listaDatas.add("29/06");
		listaDatas.add("30/06");
		//Cria uma lista com os horarios que os filmes serao exibidos
		listaHorarios.add("14h");
		listaHorarios.add("16h");
		listaHorarios.add("18h");
		//Para cada data da listaDatas é criado uma sessao em cada um dos horarios
		ArrayList<Sessao> listaSessoes = new ArrayList<>();
		for (int i=0; i< listaFilmes.size(); i++) {
			for (int j=0; j < listaDatas.size(); j++) {
				for (int k=0; k < listaHorarios.size(); k++) {
					Sessao sessao = new Sessao(listaFilmes.get(i), 6,5, listaHorarios.get(k), listaDatas.get(j));
					listaSessoes.add(sessao);
				}
			}
		}
		return listaSessoes;

	}

	public static ArrayList<Filme> criarCatalogo(String caminhoArquivo) throws CsvValidationException{
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		
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
		return listaFilmes;
	}
	
	public static void main(String[] args){
		//criacao do arquivo que guarda a disponibilidade dos assentos
		createCSVFile();
		// Instancia lista de filmes
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		String caminhoArquivo = "ListaFilmes.csv";
		try {
			listaFilmes = criarCatalogo(caminhoArquivo);
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//criacao das sessoes
		ArrayList<Sessao> listaSessoes = new ArrayList<>();
		listaSessoes = criarSessoes(listaFilmes);
		new Entrada(listaSessoes);

	}


}



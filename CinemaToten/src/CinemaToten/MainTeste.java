package CinemaToten;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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


	public static void main(String[] args) {
		
		createCSVFile();		
		//Instancia 3 objetos do tipo filme e adiciona na listaFilmes
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		Filme filme1 = new Filme("Lady Bird", "sinopse", "duracao");
		Filme filme2 = new Filme("Meninas Malvadas", "sinopse", "duracao");
		Filme filme3 = new Filme("Indiana Jones", "sinopse", "duracao");
		listaFilmes.add(filme1);
		listaFilmes.add(filme2);
		listaFilmes.add(filme3);

		//Cria uma lista com as datas em que os filmes serão exibidos
		ArrayList<String> listaDatas = new ArrayList<>();
		listaDatas.add("01/04");
		listaDatas.add("02/04");
		listaDatas.add("03/04");

		//Cria uma lista com os horarios que os filmes serao exibidos
		ArrayList<String> listaHorarios = new ArrayList<>();
		listaHorarios.add("12h");
		listaHorarios.add("18h");
		listaHorarios.add("21h");

		ArrayList<Sessao> listaSessoes = new ArrayList<>();	
		
		//Para cada data da listaDatas e criado uma sessao
		for (int i=0; i< listaDatas.size(); i++) {
			Sessao sessao = new Sessao(listaFilmes.get(i), 6,5, listaHorarios.get(i), listaDatas.get(i));
			listaSessoes.add(sessao);
		}

		Reservar reserva = new Reservar("AssentosReservados.csv");
		
		//Para cada sessao na listaSessoes é feito uma reserva escrevendo no arquivo
		for (Sessao sessao : listaSessoes) {
			String key = sessao.getFilme().getTitulo() + "," + sessao.getData() + "," 
		+ sessao.getHorario() + "," + sessao.getListaAssentos().get(0).getPosAssento();
			try {
				reserva.gravarArquivo(key);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

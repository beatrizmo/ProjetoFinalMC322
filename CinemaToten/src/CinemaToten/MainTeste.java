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
		
		String sinopseLadyBird = "Em Lady Bird - A Hora de Voar, Christine McPherson (Saoirse Ronan) está "
				+ "no último ano do ensino médio e o que mais deseja é ir fazer faculdade longe de "
				+ "Sacramento, Califórnia, ideia firmemente rejeitada por sua mãe (Laurie Metcalf)."
				+ " Lady Bird, como a garota de forte personalidade exige ser chamada, não se dá por"
				+ " vencida e leva o plano de ir embora adiante mesmo assim. "
				+ "Enquanto sua hora não chega, no entanto, ela se divide entre as obrigações"
				+ " estudantis no colégio católico, o primeiro namoro, típicos rituais de passagem"
				+ " para a vida adulta e inúmeros desentendimentos com a progenitora.";
		
		String sinopseMeninasMalvadas = "Cady Heron (Lindsay Lohan) é uma garota que cresceu na "
				+ "África e sempre estudou em casa, nunca tendo ido a uma escola."
				+ " Após retornar aos Estados Unidos com seus pais, ela se prepara para iniciar "
				+ "sua vida de estudante, se matriculando em uma escola pública. "
				+ "Logo Cady percebe como a língua venenosa de suas novas colegas pode "
				+ "prejudicar sua vida e, para piorar ainda mais sua situação, "
				+ "Cady se apaixona pelo garoto errado.";
		
		String sinopseIndianaJones = "Nos anos 60, no auge da Guerra Fria, o arqueólogo Indiana Jones "
				+ "(Harrison Ford) está prestes a se aposentar. No entanto, sua afilhada Helena "
				+ "(Phoebe Waller-Bridge) aparece o convidando para partir em uma aventura em busca de"
				+ " uma relíquia perdida que pode mudar o mundo.";
		
		Filme filme1 = new Filme("Lady Bird", sinopseLadyBird , "1h35min");
		Filme filme2 = new Filme("Meninas Malvadas", sinopseMeninasMalvadas, "1h37min");
		Filme filme3 = new Filme("Indiana Jones e a Reliquia do Destino", sinopseIndianaJones, "2h22min");
		
		listaFilmes.add(filme1);
		listaFilmes.add(filme2);
		listaFilmes.add(filme3);

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

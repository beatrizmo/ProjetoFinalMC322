package CinemaToten;

import java.util.ArrayList;

//Classe que auxilia na geração de lista necessarias uteis 
public class Listas {
	ArrayList<Sessao> listaSessoes;
	public Listas(ArrayList<Sessao> listaSessoes) {
		this.listaSessoes = listaSessoes;
	}
	
	// Metodo que verifica se o filme de uma  sessao esta na lista de filmes, se não tiver adiciona
	public ArrayList<Filme> getFilmes(){
		ArrayList<Filme> filmes = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!filmes.contains(sessao.getFilme())) {
				filmes.add(sessao.getFilme());
			}
		}
		return filmes;
	}
	
	// Metodo que verifica se o horario de uma  sessao esta na lista de horarios, se não tiver adiciona
	public ArrayList<String> getHorarios(){
		ArrayList<String> horarios = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!horarios.contains(sessao.getHorario())) {
				horarios.add(sessao.getHorario());
			}
		}
		return horarios;
	}
	
	// Metodo que verifica se as datas de uma  sessao esta na lista de datas, se não tiver adiciona
	public ArrayList<String> getDatas(){
		ArrayList<String> datas = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!datas.contains(sessao.getData())) {
				datas.add(sessao.getData());
			}
		}
		return datas;
	}
	
	//Metodo que retorna um objeto do tipo sessao com base no filme,dia e horario fornecidos
	public Sessao selecionada(Filme filme, String dia, String horario){
		Sessao selecionada = null;
		for (Sessao sessao:listaSessoes) {
			if (dia == sessao.getData()) {
				if (filme == sessao.getFilme()) {
					if (horario == sessao.getHorario()) {
						selecionada = sessao;
					}
				}
			}
		}
		return selecionada;
	}

}

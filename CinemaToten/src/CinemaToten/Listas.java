package CinemaToten;

import java.util.ArrayList;

public class Listas {
	ArrayList<Sessao> listaSessoes;
	public Listas(ArrayList<Sessao> listaSessoes) {
		this.listaSessoes = listaSessoes;
	}
	
	public ArrayList<Filme> getFilmes(){
		ArrayList<Filme> filmes = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!filmes.contains(sessao.getFilme())) {
				filmes.add(sessao.getFilme());
			}
		}
		return filmes;
	}
	
	public ArrayList<String> getHorarios(){
		ArrayList<String> horarios = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!horarios.contains(sessao.getHorario())) {
				horarios.add(sessao.getHorario());
			}
		}
		return horarios;
	}
	
	public ArrayList<String> getDatas(){
		ArrayList<String> datas = new ArrayList<>();
		for (Sessao sessao:listaSessoes) {
			if (!datas.contains(sessao.getData())) {
				datas.add(sessao.getData());
			}
		}
		return datas;
	}
	
	public Sessao selecionada(Filme filme, String dia, String horario){
		Sessao selecionada = null;
		for (Sessao sessao:listaSessoes) {
			if (dia == sessao.getData()) {
				if (filme == sessao.getFilme()) {
					if (filme == sessao.getFilme()) {
						selecionada = sessao;
					}
				}
			}
		}
		return selecionada;
	}

}

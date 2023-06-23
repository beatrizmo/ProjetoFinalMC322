package CinemaToten;

import java.util.ArrayList;

//Classe Sessao que cria uma sessão com base no filme, lista de assentos, horário e data.

public class Sessao{
	private Filme filme;
	private ArrayList<Assento> listaAssentos;
	private String horario;
	private String data;

	public Sessao(Filme filme, int colunas, int linhas, String horario, String data) {
		this.filme = filme;
		this.listaAssentos = new ArrayList<Assento>();
		for (int i=1; i<=colunas; i++) {
			for (int j=1;j<=linhas;j++) {
				Assento novoAssento = new Assento(j,i);
				listaAssentos.add(novoAssento);
			}
		}
		this.data = data;
		this.horario = horario;
	}

	// Getters e Setters
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public ArrayList<Assento> getListaAssentos() {
		return listaAssentos;
	}

	public void setListaAssentos(ArrayList<Assento> listaAssentos) {
		this.listaAssentos = listaAssentos;
	}

	@Override
	public String toString() {
		return "Filme:" + filme.getTitulo() + 
				//"\nLista de Assentos:" + listaAssentos + 
				" Horario:" + horario + " Data:" + data + "\n";
	}
}

package CinemaToten;

import java.util.ArrayList;

public class Sessao{
	private Filme filme;
	private ArrayList<Assento> listaAssentos;
	private String horario;
	private String data;

	public Sessao(Filme filme, int colunas, int linhas, String horario, String data) {
		this.filme = filme;
		this.listaAssentos = new ArrayList<Assento>();
		String tipoAssento = "Normal";
		for (int i=1; i<=colunas; i++) {
			for (int j=1;j<=linhas;j++) {
				if (i>3) { 
					tipoAssento = "VIP"; 
				}
				Assento novoAssento = new Assento(j,i,tipoAssento);
				listaAssentos.add(novoAssento);
			}
		}
		this.data = data;
		this.horario = horario;
	}

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

	// Getters e Setters
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

	public boolean verificarAssento(String posAssento) {
		//devera retornar false se assento estiver ocupado e true caso contrario
		return false;
	}

	@Override
	public String toString() {
		return "Filme:" + filme + "\nLista de Assentos:" + listaAssentos + "\nHorario:" + horario + "\nData:" + data;
	}
}

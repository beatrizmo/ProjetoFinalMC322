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
				//fileiras da parte de tras (quarta em diante) sao reservada para VIPS
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

	public boolean verificarAssento(String posAssento) {
		// Verificamos na lista de assentos se o assento informado esta ocupado
		for (Assento assento : listaAssentos) {
	        if (assento.getPosAssento().equals(posAssento)) {
	            return false; //retorna falso caso esteja ocupado
	        }
	    }
		//Caso o assento informado nao esteja na listaAssentos ele esta livre 
		return true;
	}

	@Override
	public String toString() {
		return "Filme:" + filme + "\nLista de Assentos:" + listaAssentos + "\nHorario:" + horario + "\nData:" + data;
	}
}

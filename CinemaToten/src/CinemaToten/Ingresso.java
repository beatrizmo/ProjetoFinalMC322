package CinemaToten;

//Classe abstrata com os metodos que deverao ser implentados pelas classes filhas
//IngressoInteira e IngressoMeia

public abstract class Ingresso {
    private double preco;
    private String assento;
    private String nomeCliente;
    private Sessao sessao;
    
    public Ingresso(String assento, String nomeCliente, Sessao sessao) {
        this.assento = assento;
        this.nomeCliente = nomeCliente;
        this.sessao = sessao;
    }
    
    // Métodos abstratos
    public abstract void calcularPreco(); 
    
    // Getters e Setters
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getAssento() {
        return assento;
    }
    
    public void setAssento(String assento) {
        this.assento = assento;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public String retornarChave() { //chave que será gravada no arquivo .csv
    	return sessao.getFilme().getTitulo() + "," + sessao.getData() + "," + sessao.getHorario() + "," + assento;
    }

	public String toString() {
		return "Ingresso [preco=" + preco + ", assento=" + assento + ", nomeCliente=" + nomeCliente + ", sessao="
				+ sessao + "]";
	}
    
    
}


package CinemaToten;

public abstract class Ingresso {
    private double preco;
    private Assento assento;
    private String nomeCliente;
    
    public Ingresso(double preco, Assento assento, String nomeCliente) {
        this.preco = preco;
        this.assento = assento;
        this.nomeCliente = nomeCliente;
    }
    
    // Métodos abstratos
    public abstract double calcularPreco(); 
    
    // Getters e Setters
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public Assento getAssento() {
        return assento;
    }
    
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}


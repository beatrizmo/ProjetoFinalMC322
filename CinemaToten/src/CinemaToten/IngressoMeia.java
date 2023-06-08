package CinemaToten;

public class IngressoMeia extends Ingresso {
    private double porcentagemDesconto;
    
    public IngressoMeia(double preco, Assento assento, String nomeCliente, double porcentagemDesconto) {
        super(preco, assento, nomeCliente);
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    @Override
    public double calcularPreco() {
    	//calcula o preço do ingresso levando em conta a porcentagemDesconto
    	// e o tipo do assento
    }
    
    // Getter e Setter
    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }
    
    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}

package CinemaToten;

public class IngressoMeia extends Ingresso {
    private double porcentagemDesconto;
    
    public IngressoMeia(Assento assento, String nomeCliente, double porcentagemDesconto, Sessao sessao) {
        super(assento, nomeCliente, sessao);
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    @Override
    public double calcularPreco() {
    	//calcula o preço do ingresso levando em conta a porcentagemDesconto
    	// e o tipo do assento
    	double base = 1;
		if (this.getAssento().getTipoAssento().equals("VIP")) {
			base = 1.2;
		}
		double precoFinal = base*10*porcentagemDesconto;
		this.setPreco(precoFinal);
		return precoFinal;
    }
    
    // Getter e Setter
    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }
    
    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}

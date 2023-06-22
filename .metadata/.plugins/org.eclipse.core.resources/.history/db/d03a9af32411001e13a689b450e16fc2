package CinemaToten;

public class IngressoMeia extends Ingresso {
    private double porcentagemDesconto;
    
    public IngressoMeia(Assento assento, String nomeCliente, double porcentagemDesconto, Sessao sessao) {
        super(assento, nomeCliente, sessao);
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
    @Override
  
    // Metodo que calcula o preço do ingresso levando em conta a porcentagemDesconto e o tipo de assento
    public double calcularPreco() {
 
    	double base = 1;
    	
    	//verifica se o assento selecionado é do tipo VIP, se for, usa 1.2 como valor de base
		if (this.getAssento().getTipoAssento().equals("VIP")) {
			base = 1.2;
		}
		
		//atualiza o valor da variavel preco final como base no tipo de assento escolhido
		// e com base no desconto dado a quem paga meia entrada 
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

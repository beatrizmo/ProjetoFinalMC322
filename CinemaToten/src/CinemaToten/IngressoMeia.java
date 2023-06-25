package CinemaToten;

//Classe filha de Ingresso que cria um ingresso do tipo meia
public class IngressoMeia extends Ingresso {
    private double porcentagemDesconto;
    
    public IngressoMeia(String assento, String nomeCliente, double porcentagemDesconto, Sessao sessao) {
        super(assento, nomeCliente, sessao);
        this.porcentagemDesconto = porcentagemDesconto;
        this.calcularPreco();
    }
    
    @Override
  
    // Metodo que calcula o preço do ingresso levando em conta a porcentagemDesconto
    public void calcularPreco() {		
		//atualiza o valor da variavel preco final com base no desconto dado 
		double precoFinal =20*porcentagemDesconto;
		this.setPreco(precoFinal);
    }
    
    // Getter e Setter
    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }
    
    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
    
	public String toString() {
		return "IngressoMeia [porcentagemDesconto=" + porcentagemDesconto + "]";
	}
    
    
}

package CinemaToten;

public class IngressoInteira extends Ingresso{
	
	public IngressoInteira(double preco, Assento assento, String nomeCliente,Sessao sessao) {
		super(assento,nomeCliente, sessao);
	}

	@Override
	
	//Método que calcula o preço do ingresso levando em conta o tipo do assento
	public double calcularPreco() {
		
		//Ingresso VIP custa 20% a mais 
		
		double base = 1;
		//verifica se o assento selecionado é do tipo VIP, se for, usa 1.2 como valor de base
		if (this.getAssento().getTipoAssento().equals("VIP")) {
			base = 1.2;
		}
		
		//atualiza o valor da variavel preco final como base no tipo de assento escolhido
		double precoFinal = base*20;
		this.setPreco(precoFinal);
		return precoFinal;
	}
}

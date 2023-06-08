package CinemaToten;

public class IngressoInteira extends Ingresso{
	
	public IngressoInteira(double preco, Assento assento, String nomeCliente, Sessao sessao) {
		super(assento,nomeCliente, sessao);
	}

	@Override
	public double calcularPreco() {
		//calcula o preço do ingresso levando em conta o tipo do assento
		double base = 1;
		if (this.getAssento().getTipoAssento().equals("VIP")) {
			base = 1.2;
		}
		double precoFinal = base*20;
		this.setPreco(precoFinal);
		return precoFinal;
	}
}

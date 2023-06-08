package CinemaToten;

public class IngressoInteira extends Ingresso{
	
	public IngressoInteira(double preco, Assento assento, String nomeCliente) {
		super(preco,assento,nomeCliente);
	}

	@Override
	public double calcularPreco() {
		//calcula o preço do ingresso levando em conta o tipo do assento
	}
}

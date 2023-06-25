package CinemaToten;

//Classe filha de Ingresso que cria um ingresso do tipo inteira
public class IngressoInteira extends Ingresso{
	
	public IngressoInteira(String assento, String nomeCliente,Sessao sessao) {
		super(assento,nomeCliente, sessao);
		this.calcularPreco();
	}

	@Override	
	//Método que calcula o preço do ingresso levando em conta o tipo de ingresso meia
	public void calcularPreco() {
		double precoFinal = 20;
		this.setPreco(precoFinal);
	}

	@Override
	public String toString() {
		return "IngressoInteira [" + super.toString() + "]";
	}
}

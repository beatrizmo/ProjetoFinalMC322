package CinemaToten;

public class Assento {
    private String posAssento;
    
    public Assento(int linha, int coluna) {
        this.posAssento = FormatarPosAssento(linha, coluna);
    }
    
    //Formatar a posição do assento
    public String FormatarPosAssento(int linha, int coluna) {
    	char colunaAlfabetica = (char) ('A' + coluna - 1);
        return colunaAlfabetica + "" + linha;
    }
    
    // Getters e Setters
    public String getPosAssento() {
        return posAssento;
    }
    
    public void setPosAssento(String posAssento) {
        this.posAssento = posAssento;
    }

	@Override
	public String toString() {
		return posAssento;
	}
    
    
}

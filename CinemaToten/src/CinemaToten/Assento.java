package CinemaToten;

public class Assento {
    private String posAssento;
    private String tipoAssento;
    
    public Assento(int linha, int coluna, String tipoAssento) {
        this.posAssento = FormatarPosAssento(linha, coluna);
        this.tipoAssento = tipoAssento;
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
    
    public String getTipoAssento() {
        return tipoAssento;
    }
    
    public void setTipoAssento(String tipoAssento) {
        this.tipoAssento = tipoAssento;
    }

	@Override
	public String toString() {
		return posAssento + "(" + tipoAssento + ")";
	}
    
    
}

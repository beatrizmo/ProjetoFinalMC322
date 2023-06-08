package CinemaToten;

public class Assento {
    private String posAssento;
    private String tipoAssento;
    
    public Assento(String posAssento, String tipoAssento) {
        this.posAssento = posAssento;
        this.tipoAssento = tipoAssento;
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
}

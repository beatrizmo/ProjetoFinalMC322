package CinemaToten;

import java.util.List;

public class Sessao{
    private Filme filme;
    private List<Assento> listaAssentos;
    
    public Sessao(Filme filme, List<Assento> listaAssentos) {
        this.filme = filme;
        this.listaAssentos = listaAssentos;
    }
    
    // Getters e Setters
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public List<Assento> getListaAssentos() {
        return listaAssentos;
    }
    
    public void setListaAssentos(List<Assento> listaAssentos) {
        this.listaAssentos = listaAssentos;
    }
    
    public boolean verificarAssento(String posAssento) {
    	//devera retornar false se assento estiver ocupado e true caso contrario
    }
    
}

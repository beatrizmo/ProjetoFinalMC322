package CinemaToten;

import java.util.List;

public class Filme {
    private String titulo;
    private String sinopse;
    private String duracao;
    private List<String> horariosExibicao;
    
    public Filme(String titulo, String sinopse, String duracao, List<String> horariosExibicao) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.horariosExibicao = horariosExibicao;
    }
    
    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getSinopse() {
        return sinopse;
    }
    
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    public String getDuracao() {
        return duracao;
    }
    
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    public List<String> getHorariosExibicao() {
        return horariosExibicao;
    }
    
    public void setHorariosExibicao(List<String> horariosExibicao) {
        this.horariosExibicao = horariosExibicao;
    }
}


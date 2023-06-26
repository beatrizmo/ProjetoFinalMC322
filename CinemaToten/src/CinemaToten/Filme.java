package CinemaToten;

//Classe que cria um filme, com base no título, sinopse e duração.

public class Filme {
    private String titulo;
    private String sinopse;
    private String duracao;
    String caminhoPoster;
    
    public Filme(String titulo, String sinopse, String duracao, String caminhoPoster) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.caminhoPoster = caminhoPoster;
    }
    
    public String getCaminhoPoster() {
		return caminhoPoster;
	}

	public void setCaminhoPoster(String caminhoPoster) {
		this.caminhoPoster = caminhoPoster;
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

	@Override
	public String toString() {
		return "Titulo:" + titulo + "\nSinopse:" + sinopse + "\nDuracao:" + duracao;
	}
    
    
}


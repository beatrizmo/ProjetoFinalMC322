package CinemaToten;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.ArrayList;

//Classe que cria um recibo, com base no preço final, data, hora, título do filme e assentos selecionados.
// Alem disso possui um método que transforma o recibo em uma imagem

public class Recibo {
	double precoFinal;
	String data, hora, titulo;
	ArrayList<String> assentos;

	public Recibo(double preco, String data, String hora, String titulo, ArrayList<String> assentos){
		this.precoFinal = preco;
		this.assentos = assentos;
		this.data = data;
		this.hora = hora;
		this.titulo = titulo;
	}

	//getters e setters
	public ArrayList<String> getAssentos() {
		return assentos;
	}
	public String getData() {
		return data;
	}
	public String getHora() {
		return hora;
	}
	public double getPrecoFinal() {
		return precoFinal;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setAssentos(ArrayList<String> assentos) {
		this.assentos = assentos;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	//método to String
	public String toString(){
		String texto = new String("\n-----Recibo-----\nTitulo do filme: "+titulo+"\nDia: "+data+ "   Hora: "+hora+"\nAssentos:"+assentos+"\nPreço total: "+precoFinal);
		return texto;
	}

	//public void recibo em forma de imagem
	public void toImg(){
		String text = toString();
		int imageWidth = 600; // Largura da imagem
		int imageHeight = 900; // Altura da imagem

		// Cria uma nova imagem com o tamanho especificado
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

		// Obtém o objeto Graphics2D para desenhar na imagem
		Graphics2D g2d = image.createGraphics();

		// Define a cor de fundo da imagem (opcional)
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, imageWidth, imageHeight);

		// Define a fonte e cor do texto
		Font font = new Font("Arial", Font.BOLD, 20);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);

		// Define as coordenadas de início para desenhar o texto
		int x = 10;
		int y = 30;

		// Divide o texto em linhas e desenha cada linha na imagem
		String[] lines = text.split("\n");
		for (String line : lines) {
			g2d.drawString(line, x, y);
			y += g2d.getFontMetrics().getHeight(); // Incrementa a coordenada Y para a próxima linha
		}

		// Libera os recursos do objeto Graphics2D
		g2d.dispose();

		// Salva a imagem em um arquivo PNG
		File output = new File("output.png");
		try {
			ImageIO.write(image, "PNG", output);
			System.out.println("Imagem salva com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao salvar a imagem: " + e.getMessage());
		}
	}

}

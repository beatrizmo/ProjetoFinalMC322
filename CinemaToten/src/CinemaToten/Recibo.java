package CinemaToten;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import java.util.ArrayList;

//Classe que cria um recibo, com base no preço final, data, hora, título do filme e assentos selecionados.
// Alem disso possui um método que transforma o recibo em uma imagem

public class Recibo {
	double precoFinal;
	String data, hora, titulo,nome;
	ArrayList<String> assentos;

	public Recibo(double preco, String data, String hora, String titulo, String nome, ArrayList<String> assentos){
		this.precoFinal = preco;
		this.assentos = assentos;
		this.data = data;
		this.hora = hora;
		this.titulo = titulo;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	//Método to String
	public String toString(){
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String precoFinalFormatado = decimalFormat.format(precoFinal);

		String texto = "\n-----Recibo-----\n" +
		               "Cliente: " + this.nome + "\n" +
		               "Titulo do filme: " + titulo + "\n" +
		               "Dia: " + data + "   Hora: " + hora + "\n" +
		               "Assentos: " + assentos + "\n" +
		               "Preço total: R$" + precoFinalFormatado;
		return texto;
	}
	public String generateMD5Hash(String input) {
        try {
            // Cria uma instância do algoritmo de hash MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            
            // Obtém os bytes da string de entrada
            byte[] inputBytes = input.getBytes();
            
            // Calcula o hash dos bytes da string de entrada
            byte[] hashBytes = digest.digest(inputBytes);
            
            // Converte os bytes do hash em uma representação hexadecimal
            String hashHex = new BigInteger(1, hashBytes).toString(16);
            
            // Preenche com zeros à esquerda, se necessário, para obter 32 caracteres
            while (hashHex.length() < 32) {
                hashHex = "0" + hashHex;
            }
            
            // Obtém os primeiros 6 caracteres do hash
            String truncatedHash = hashHex.substring(0, 6);
            
            return truncatedHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
	//Recibo em forma de imagem
	public String toImg(){
		String buyId = this.generateMD5Hash(this.toString());
		String text = toString() + "\nID da compra: " + buyId;
		int imageWidth = 450; // Largura da imagem
		int imageHeight = 300; // Altura da imagem

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
		File output = new File("Ingresso"+buyId+".png");
		try {
			ImageIO.write(image, "PNG", output);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return "Ingresso"+buyId+".png";
	}

}

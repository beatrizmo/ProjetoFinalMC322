package CinemaToten;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

//Classe que cria um recibo, com base no preço final, data, hora, título do filme e assentos selecionados.
// Alem disso possui um método que transforma o recibo em uma imagem

public class Recibo {
    float precoFinal;
    String data, hora, titulo;
    ArrayList<Assento> assentos;

    public Recibo(float preco, String data, String hora, String titulo, ArrayList<Assento> assentos){
        this.precoFinal = preco;
        this.assentos = assentos;
        this.data = data;
        this.hora = hora;
        this.titulo = titulo;
    }

    //getters e setters
    public ArrayList<Assento> getAssentos() {
        return assentos;
    }
    public String getData() {
        return data;
    }
    public String getHora() {
        return hora;
    }
    public float getPrecoFinal() {
        return precoFinal;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //método to String
    public String toString(){
        String texto = new String("\n-----Recibo-----\nTitulo do filme: "+titulo+"\nDia: "+data+ "   Hora: "+hora+"\nAssentos selecionados"+assentos+"\nPreço total: "+precoFinal);
        return texto;
    }

    //public void recibo em forma de imagem
    public void toImg(){
        String text = toString();
        int width = 300;
        int height = 900;

        //Crie um objeto BufferedImage com a largura e altura especificadas
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Obtenha o objeto Graphics2D a partir da imagemß
        Graphics2D g2d = image.createGraphics();

        //Define a cor de fundo do reciboß
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Define a fonte e sua corß
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        // Desenha o texto centrado na imagem
        g2d.drawString(text, 20, 20);

        // Descarta o objeto Graphics 2Dß
        g2d.dispose();

        try {
            // Salve a imagem em um arquivo do tipo pngß
            File outputFile = new File("output.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagem salva com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}

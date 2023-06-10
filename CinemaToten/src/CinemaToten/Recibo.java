package CinemaToten;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

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

        // Create a BufferedImage object with the specified width and height
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the Graphics2D object from the image
        Graphics2D g2d = image.createGraphics();

        // Set the background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Set the text color and font
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        // Draw the centered text on the image
        g2d.drawString(text, 20, 20);

        // Dispose the Graphics2D object
        g2d.dispose();

        try {
            // Save the image to a file
            File outputFile = new File("output.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}

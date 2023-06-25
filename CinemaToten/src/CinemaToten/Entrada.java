package CinemaToten;

import java.awt.Font;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import javax.swing.Action;

//Classe que cria a tela de entrada do programa

public class Entrada extends JPanel {
	
	Filme film1, film2, film3;
	String data[];
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public Entrada(Filme film1, Filme film2,Filme film3,String[] data) {
		this.film1 = film1;
		this.film2 = film2;
		this.film3 = film3;
		this.data = data;
		
		//Definições iniciais da tela
		setMaximumSize(new Dimension(1050, 575));
		setMinimumSize(new Dimension(1050, 575));
		setBackground(new Color(13, 1, 73));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Painel do título do álbum
		JPanel titulo = new JPanel();
		titulo.setAlignmentY(Component.TOP_ALIGNMENT);
		titulo.setBorder(new EmptyBorder(15, 0, 0, 0));
		titulo.setBackground(new Color(13, 1, 73));
		add(titulo);
		FlowLayout fl_titulo = new FlowLayout(FlowLayout.CENTER, 5,0);
		titulo.setLayout(fl_titulo);
		
		
		//Painel com os conteúdos
		JPanel conteudos = new JPanel();
		conteudos.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout fl_conteudos = (FlowLayout) conteudos.getLayout();
		fl_conteudos.setVgap(0);
		fl_conteudos.setHgap(0);
		conteudos.setForeground(new Color(25, 25, 112));
		conteudos.setBackground(new Color(13, 1, 73));
		add(conteudos);
		
		JPanel datasPainel = new JPanel();
		datasPainel.setBorder(new EmptyBorder(0, 50, 0, 50));
		datasPainel.setBackground(new Color(13, 1, 73));
		conteudos.add(datasPainel);
		
		//Combobox com as datas disponíveis
		JComboBox<String> datas = new JComboBox<String>();
		datas.setForeground(new Color(13, 1, 73));
		datas.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		datas.setBackground(new Color(230, 230, 250));
		datas.setModel(new DefaultComboBoxModel<String>(data));
		datasPainel.add(datas);
		
		//Panel com os Filmes disponíveis na data
		JPanel catalogo = new JPanel();
		conteudos.add(catalogo);
		catalogo.setBorder(new EmptyBorder(40, 19, 20, 19));
		catalogo.setForeground(new Color(230, 230, 250));
		catalogo.setBackground(new Color(13, 1, 73));
		((FlowLayout) catalogo.getLayout()).setHgap(20);
		
		
		
		//Painel com o primeiro filme
		JPanel filme = new JPanel();
		filme.setBorder(new EmptyBorder(20, 8, 20, 8));
		filme.setBackground(new Color(54, 26, 115));
		filme.setPreferredSize(new Dimension(275,380));
		filme.setLayout(new BoxLayout(filme, BoxLayout.Y_AXIS));
		catalogo.add(filme);
		
		//painel com a capa do filme 1
		JPanel capaFilme1 = new JPanel();
		capaFilme1.setBorder(new EmptyBorder(0, 0, 5, 0));
		capaFilme1.setBackground(new Color(54, 26, 115));
		capaFilme1.setAlignmentY(1.0f);
		filme.add(capaFilme1);
		
		JLabel capa1 = new JLabel("");
		capa1.setIcon(new ImageIcon("C:\\Users\\Alexia\\Downloads\\LadyBird.png"));
		capa1.setAlignmentX(0.5f);
		capaFilme1.add(capa1);
		
		//Paineis com informações do filme
		JLabel tituloFilme1 = new JLabel();
		tituloFilme1.setText(film1.getTitulo());
		tituloFilme1.setHorizontalAlignment(SwingConstants.TRAILING);
		tituloFilme1.setVerticalAlignment(SwingConstants.TOP);
		tituloFilme1.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme1.setBackground(new Color(240, 240, 240));
		tituloFilme1.setForeground(new Color(230, 230, 250));
		tituloFilme1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		filme.add(tituloFilme1);
		
		JPanel duracao1Panel = new JPanel();
		duracao1Panel.setBorder(new EmptyBorder(6, 0, 8, 0));
		duracao1Panel.setBackground(new Color(54, 26, 115));
		filme.add(duracao1Panel);
		
		JLabel duracao1 = new JLabel();
		duracao1.setText(film1.getDuracao());
		duracao1.setForeground(new Color(240, 248, 255));
		duracao1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao1Panel.add(duracao1);
		
		//botão do filme 1
		JButton btnIngresso1 = new JButton("Compre seu ingresso");
		btnIngresso1.setAction(action);
		btnIngresso1.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnIngresso1.setForeground(new Color(13, 1, 73));
		btnIngresso1.setBackground(new Color(230, 230, 250));
		btnIngresso1.setAlignmentX(Component.CENTER_ALIGNMENT);
		filme.add(btnIngresso1);
		
		//Painel com o segundo filme
		JPanel filme2 = new JPanel();
		filme2.setBorder(new EmptyBorder(20, 8, 20, 8));
		filme2.setBackground(new Color(54, 26, 115));
		filme2.setPreferredSize(new Dimension(275,380));
		catalogo.add(filme2);

		//painel com a capa do filme 2
		JPanel capaFilme2 = new JPanel();
		capaFilme2.setBorder(new EmptyBorder(0, 0, 5, 0));
		capaFilme2.setBackground(new Color(54, 26, 115));
		filme2.add(capaFilme2);
		
		JLabel capa2 = new JLabel("");
		capa2.setIcon(new ImageIcon("C:\\Users\\Alexia\\Downloads\\Meninas.png"));
		capa2.setAlignmentX(0.5f);
		capaFilme2.add(capa2);
		
		//Paineis com informações do filme
		JLabel tituloFilme2 = new JLabel();
		tituloFilme2.setText(film2.getTitulo());
		tituloFilme2.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme2.setForeground(new Color(230, 230, 250));
		tituloFilme2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		filme2.add(tituloFilme2);
		
		JPanel duracao2Painel = new JPanel();
		duracao2Painel.setBorder(new EmptyBorder(6, 0, 8, 0));
		duracao2Painel.setBackground(new Color(54, 26, 115));
		filme2.add(duracao2Painel);
		
		JLabel duracao2 = new JLabel();
		duracao2.setText(film2.getDuracao());
		duracao2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao2.setForeground(new Color(240, 248, 255));
		duracao2.setAlignmentX(0.5f);
		duracao2Painel.add(duracao2);
		filme2.setLayout(new BoxLayout(filme2, BoxLayout.Y_AXIS));
		
		//botão do filme 2
		JButton btnIngresso2 = new JButton("Compre seu ingresso");
		btnIngresso2.setForeground(new Color(13, 1, 73));
		btnIngresso2.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnIngresso2.setBackground(new Color(230, 230, 250));
		btnIngresso2.setAlignmentX(0.5f);
		filme2.add(btnIngresso2);
		
		//Painel com o terceiro filme
		JPanel filme3 = new JPanel();
		filme3.setBorder(new EmptyBorder(20, 8, 20, 8));
		filme3.setBackground(new Color(54, 26, 115));
		filme3.setPreferredSize(new Dimension(275,380));
		catalogo.add(filme3);
		filme3.setLayout(new BoxLayout(filme3, BoxLayout.Y_AXIS));
		
		//painel com a capa do filme 3
		JPanel capaFilme3 = new JPanel();
		capaFilme3.setBorder(new EmptyBorder(0, 0, 5, 0));
		capaFilme3.setBackground(new Color(54, 26, 115));
		capaFilme3.setAlignmentY(1.0f);
		filme3.add(capaFilme3);
		
		JLabel capa3 = new JLabel("");
		capa3.setIcon(new ImageIcon("C:\\Users\\Alexia\\Downloads\\Indiana.png"));
		capa3.setAlignmentX(0.5f);
		capaFilme3.add(capa3);
		
		//Paineis com informações do filme
		JLabel tituloFilme3 = new JLabel("Dice");
		tituloFilme3.setText(film3.getTitulo());
		tituloFilme3.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme3.setForeground(new Color(230, 230, 250));
		tituloFilme3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		filme3.add(tituloFilme3);
		
		JPanel duracao3Painel = new JPanel();
		duracao3Painel.setBorder(new EmptyBorder(6, 0, 8, 0));
		duracao3Painel.setBackground(new Color(54, 26, 115));
		filme3.add(duracao3Painel);
		
		JLabel duracao3 = new JLabel();
		duracao3.setText(film3.getDuracao());
		duracao3.setForeground(new Color(240, 248, 255));
		duracao3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao3.setAlignmentX(0.5f);
		duracao3Painel.add(duracao3);
		
		//botão do filme 3
		JButton btnIngresso3 = new JButton("Compre seu ingresso");
		btnIngresso3.setForeground(new Color(13, 1, 73));
		btnIngresso3.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnIngresso3.setBackground(new Color(230, 230, 250));
		btnIngresso3.setAlignmentX(0.5f);
		filme3.add(btnIngresso3);
		
		JLabel lblNewLabel = new JLabel("SuperCine");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setBackground(new Color(13, 1, 73));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
		
		titulo.add(lblNewLabel);

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Compre seu ingresso.");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		
		}
	}
}

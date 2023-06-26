package CinemaToten;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

//Classe que cria a tela de entrada do programa
public class Entrada extends JFrame implements ActionListener{
	
	String data[];
	JComboBox<String> datas;
	ArrayList<Filme> filmes;
	ArrayList<Sessao> listaSessoes;
	JComboBox<String> Horarios;
	Sessao selected;
	Listas lista;
	private static final long serialVersionUID = 1L;
	
	public Entrada(ArrayList<Sessao> list) {
		
		this.listaSessoes = list;
		lista = new Listas(listaSessoes);
		filmes = lista.getFilmes();
		this.data = lista.getDatas().toArray(new String[0]);
		
		//Definições iniciais da tela
		setVisible(true);
		setSize(1050,675);
		setBackground(new Color(13, 1, 73));
		setTitle("SuperCine- sistema de reserva de cinema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Painel do título do álbum
		JPanel titulo = new JPanel();
		titulo.setAlignmentY(Component.TOP_ALIGNMENT);
		titulo.setBorder(new EmptyBorder(15, 0, 0, 0));
		titulo.setBackground(new Color(13, 1, 73));
		getContentPane().add(titulo);
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
		getContentPane().add(conteudos);
		
		JPanel datasPainel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) datasPainel.getLayout();
		flowLayout.setHgap(40);
		datasPainel.setBorder(new EmptyBorder(0, 50, 0, 50));
		datasPainel.setBackground(new Color(13, 1, 73));
		conteudos.add(datasPainel);
		
		JLabel data_1 = new JLabel("Datas:");
		data_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		data_1.setForeground(new Color(230, 230, 250));
		datasPainel.add(data_1);
		
		//Combobox com as datas disponíveis
		datas = new JComboBox<String>();
		datas.setForeground(new Color(13, 1, 73));
		datas.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		datas.setBackground(new Color(230, 230, 250));
		datas.setModel(new DefaultComboBoxModel<String>(lista.getDatas().toArray(new String[0])));
		datasPainel.add(datas);
		
		JLabel horario = new JLabel("Horarios:");
		horario.setForeground(new Color(230, 230, 250));
		horario.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		datasPainel.add(horario);
		
		Horarios = new JComboBox<String>();
		Horarios.setForeground(new Color(13, 1, 73));
		Horarios.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		Horarios.setBackground(new Color(230, 230, 250));
		Horarios.setModel(new DefaultComboBoxModel<String>(lista.getHorarios().toArray(new String[0])));
		datasPainel.add(Horarios);
		
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
		tituloFilme1.setText(filmes.get(0).getTitulo());
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
		duracao1.setText(filmes.get(0).getDuracao());
		duracao1.setForeground(new Color(240, 248, 255));
		duracao1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao1Panel.add(duracao1);
		
		//Botão do filme 1
		JButton btnIngresso1 = new JButton("Compre seu ingresso");
		btnIngresso1.addActionListener(this::sel1);
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
		tituloFilme2.setText(filmes.get(1).getTitulo());
		tituloFilme2.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme2.setForeground(new Color(230, 230, 250));
		tituloFilme2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		filme2.add(tituloFilme2);
		
		JPanel duracao2Painel = new JPanel();
		duracao2Painel.setBorder(new EmptyBorder(6, 0, 8, 0));
		duracao2Painel.setBackground(new Color(54, 26, 115));
		filme2.add(duracao2Painel);
		
		JLabel duracao2 = new JLabel();
		duracao2.setText(filmes.get(1).getDuracao());
		duracao2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao2.setForeground(new Color(240, 248, 255));
		duracao2.setAlignmentX(0.5f);
		duracao2Painel.add(duracao2);
		filme2.setLayout(new BoxLayout(filme2, BoxLayout.Y_AXIS));
		
		//Botão do filme 2
		JButton btnIngresso2 = new JButton("Compre seu ingresso");
		btnIngresso2.setForeground(new Color(13, 1, 73));
		btnIngresso2.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnIngresso2.setBackground(new Color(230, 230, 250));
		btnIngresso2.setAlignmentX(0.5f);
		btnIngresso2.addActionListener(this::sel2);
		filme2.add(btnIngresso2);
		
		//Painel com o terceiro filme
		JPanel filme3 = new JPanel();
		filme3.setBorder(new EmptyBorder(20, 8, 20, 8));
		filme3.setBackground(new Color(54, 26, 115));
		filme3.setPreferredSize(new Dimension(275,380));
		catalogo.add(filme3);
		filme3.setLayout(new BoxLayout(filme3, BoxLayout.Y_AXIS));
		
		//Painel com a capa do filme 3
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
		tituloFilme3.setText(filmes.get(2).getTitulo());
		tituloFilme3.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme3.setForeground(new Color(230, 230, 250));
		tituloFilme3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		filme3.add(tituloFilme3);
		
		JPanel duracao3Painel = new JPanel();
		duracao3Painel.setBorder(new EmptyBorder(6, 0, 8, 0));
		duracao3Painel.setBackground(new Color(54, 26, 115));
		filme3.add(duracao3Painel);
		
		JLabel duracao3 = new JLabel();
		duracao3.setText(filmes.get(2).getDuracao());
		duracao3.setForeground(new Color(240, 248, 255));
		duracao3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		duracao3.setAlignmentX(0.5f);
		duracao3Painel.add(duracao3);
		
		//Botão do filme 3
		JButton btnIngresso3 = new JButton("Compre seu ingresso");
		btnIngresso3.setForeground(new Color(13, 1, 73));
		btnIngresso3.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnIngresso3.setBackground(new Color(230, 230, 250));
		btnIngresso3.setAlignmentX(0.5f);
		btnIngresso3.addActionListener(this::sel3);
		filme3.add(btnIngresso3);
		
		JLabel lblNewLabel = new JLabel("SuperCine");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setBackground(new Color(13, 1, 73));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 36));
		
		titulo.add(lblNewLabel);

	}

	//Guardas a informacoes selecionadas por meio do botao 1 em uma variavel 
	public void sel1(ActionEvent event) {
		selected = lista.selecionada(filmes.get(0),(String)datas.getSelectedItem(), (String)Horarios.getSelectedItem());
		setVisible(false);
		new Selecao(listaSessoes, selected);
	}

	//Guardas a informacoes selecionadas por meio do botao 2 em uma variavel 
	public void sel2(ActionEvent event) {
		selected = lista.selecionada(filmes.get(1),(String)datas.getSelectedItem(), (String)Horarios.getSelectedItem());
		setVisible(false);
		new Selecao(listaSessoes, selected);
	}

	//Guardas a informacoes selecionadas por meio do botao 3 em uma variavel 
	public void sel3(ActionEvent event) {
		selected = lista.selecionada(filmes.get(2),(String)datas.getSelectedItem(), (String)Horarios.getSelectedItem());
		setVisible(false);
		new Selecao(listaSessoes, selected);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}

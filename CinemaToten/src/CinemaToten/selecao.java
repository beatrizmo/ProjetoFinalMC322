package CinemaToten;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

//Classe seleção que cria a tela de seleção de assentos

public class selecao extends JFrame implements ActionListener{

	String dia;
	Filme filme;
	String[] horarios;
	int total=0,sel=0;
	JComboBox<String> meiaSel, inteiraSel;
	private static final long serialVersionUID = 1L;
	
	public selecao(String[] horarios, Filme filme, String dia) {
		this.horarios = horarios;
		this.filme = filme;
		this.dia = dia;
		
		
		setVisible(true);
		
		//Definições iniciais da tela
		setSize(1050,675);
		setTitle("SuperCine - Compra de ingressos");
		setBackground(new Color(13, 1, 73));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Painel superior com as informações do cinema e do filme 
		JPanel info = new JPanel();
		info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		info.setPreferredSize(new Dimension(1000, 10));
		info.setMinimumSize(new Dimension(1000, 10));
		info.setBackground(new Color(13, 1, 73));
		getContentPane().add(info);
		
		JPanel dados = new JPanel();
		dados.setPreferredSize(new Dimension(1000, 130));
		dados.setMinimumSize(new Dimension(1000, 10));
		dados.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dados.setBackground(new Color(13, 1, 73));
		dados.setLayout(new BoxLayout(dados, BoxLayout.Y_AXIS));
		info.add(dados);
		
		//Painel com o nome do cinema e o botão de volta para a página anterior
		JPanel head = new JPanel();
		head.setBackground(new Color(13, 1, 73));
		head.setLayout(new GridLayout(0, 5, 0, 0));
		dados.add(head);
		
		//Painel e botão para voltar para a página de seleção de filme 
		JPanel voltarPanel = new JPanel();
		voltarPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		voltarPanel.setBackground(new Color(13, 1, 73));
		head.add(voltarPanel);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		voltarButton.setForeground(new Color(13, 1, 73));
		voltarButton.setBackground(new Color(54, 26, 115));
		voltarButton.addActionListener(this::voltar);
		voltarPanel.add(voltarButton);
		
		//Painel vaxio para manter o espaçamento
		JPanel vazio = new JPanel();
		vazio.setBorder(new EmptyBorder(0, 50, 0, 50));
		vazio.setBackground(new Color(13, 1, 73));
		head.add(vazio);
		
		//Painel e nome do Cinema
		JLabel cinema = new JLabel("SuperCine");
		cinema.setBackground(new Color(13, 1, 73));
		cinema.setAlignmentX(Component.CENTER_ALIGNMENT);
		cinema.setHorizontalAlignment(SwingConstants.CENTER);
		cinema.setForeground(new Color(230, 230, 250));
		cinema.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		head.add(cinema);
		
		//Painel contendo O título do filme e o botão de seleção de horario 
		JPanel tituloData = new JPanel();
		tituloData.setBackground(new Color(13, 1, 73));
		tituloData.setLayout(new BoxLayout(tituloData, BoxLayout.X_AXIS));
		dados.add(tituloData);
		
		//Painel e label contendo o nome do filme selecionado
		JPanel tituloPanel = new JPanel();
		FlowLayout fl_tituloPanel = (FlowLayout) tituloPanel.getLayout();
		fl_tituloPanel.setAlignment(FlowLayout.LEFT);
		tituloPanel.setBackground(new Color(13, 1, 73));
		tituloData.add(tituloPanel);
		
		JLabel tituloFilme = new JLabel();
		tituloFilme.setText(filme.getTitulo());
		tituloFilme.setMaximumSize(new Dimension(500, 45));
		tituloFilme.setHorizontalTextPosition(SwingConstants.LEFT);
		tituloFilme.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		tituloFilme.setForeground(new Color(230, 230, 250));
		tituloPanel.add(tituloFilme);
		
		//Painel e botão para a seleção do horário de exibição
		JPanel horarioPanel = new JPanel();
		horarioPanel.setBackground(new Color(13, 1, 73));
		tituloData.add(horarioPanel);
		
		JLabel horarioLabel = new JLabel("Horário: ");
		horarioLabel.setForeground(new Color(230, 230, 250));
		horarioLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		horarioPanel.add(horarioLabel);
		
		JComboBox<String> horarios_1 = new JComboBox<String>();
		horarioPanel.add(horarios_1);
		horarios_1.setModel((ComboBoxModel<String>) new DefaultComboBoxModel<String>(horarios));
		horarios_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		
		//Painel inferior para a seleção de assentos e resumo do pedido
		JPanel reserva = new JPanel();
        reserva.setBackground(new Color(13, 1, 73));
        reserva.setLayout(new GridLayout(1, 5, 0, 0));
        getContentPane().add(reserva);
		
        JPanel assentos = new JPanel();
        assentos.setBorder(new EmptyBorder(20, 60, 20, 60));
        assentos.setBackground(new Color(13, 1, 73));
        reserva.add(assentos);
        assentos.setLayout(new BorderLayout());
		
        //Mapa de Assentos
        JPanel mapa = new JPanel();
        mapa.setBorder(new EmptyBorder(20, 30, 20, 30));
        mapa.setBackground(new Color(13, 1, 73));
        assentos.add(mapa, BorderLayout.CENTER);
        mapa.setLayout(new GridLayout(6, 8, 10, 10));
        
        //Assentos
        JButton A1 = new JButton("A1"); mapa.add(A1);
        A1.addActionListener(this::selecionar);
        JButton A2 = new JButton("A2"); mapa.add(A2);
        JButton A3 = new JButton("A3"); mapa.add(A3);
        JButton A4 = new JButton("A4"); mapa.add(A4);
        JButton A5 = new JButton("A5"); mapa.add(A5);
        JButton A6 = new JButton("A6"); mapa.add(A6);
        JButton A7 = new JButton("A7"); mapa.add(A7);
        JButton A8 = new JButton("A8"); mapa.add(A8);
        JButton B1 = new JButton("B1"); mapa.add(B1);
        JButton B2 = new JButton("B2"); mapa.add(B2);
        JButton B3 = new JButton("B3"); mapa.add(B3);
        JButton B4 = new JButton("B4"); mapa.add(B4);
        JButton B5 = new JButton("B5"); mapa.add(B5);
        JButton B6 = new JButton("B6"); mapa.add(B6);
        JButton B7 = new JButton("B7"); mapa.add(B7);
        JButton B8 = new JButton("B8"); mapa.add(B8);
        JButton C1 = new JButton("C1"); mapa.add(C1);
        JButton C2 = new JButton("C2"); mapa.add(C2);
        JButton C3 = new JButton("C3"); mapa.add(C3);
        JButton C4 = new JButton("C4"); mapa.add(C4);
        JButton C5 = new JButton("C5"); mapa.add(C5);
        JButton C6 = new JButton("C6"); mapa.add(C6);
        JButton C7 = new JButton("C7"); mapa.add(C7);
        JButton C8 = new JButton("C8"); mapa.add(C8);
        JButton D1 = new JButton("D1"); mapa.add(D1);
        JButton D2 = new JButton("D2"); mapa.add(D2);
        JButton D3 = new JButton("D3"); mapa.add(D3);
        JButton D4 = new JButton("D4"); mapa.add(D4);
		JButton D5 = new JButton("D5"); mapa.add(D5);
		JButton D6 = new JButton("D6"); mapa.add(D6);
		JButton D7 = new JButton("D7"); mapa.add(D7);
		JButton D8 = new JButton("D8"); mapa.add(D8);
		JButton E1 = new JButton("E1"); mapa.add(E1);
		JButton E2 = new JButton("E2"); mapa.add(E2);
		JButton E3 = new JButton("E3"); mapa.add(E3);
		JButton E4 = new JButton("E4"); mapa.add(E4);
		JButton E5 = new JButton("E5"); mapa.add(E5);
		JButton E6 = new JButton("E6"); mapa.add(E6);
		JButton E7 = new JButton("E7"); mapa.add(E7);
		JButton E8 = new JButton("E8"); mapa.add(E8);
		JButton F1 = new JButton("F1"); mapa.add(F1);
		JButton F2 = new JButton("F2"); mapa.add(F2);
		JButton F3 = new JButton("F3"); mapa.add(F3);
		JButton F4 = new JButton("F4"); mapa.add(F4);
		JButton F5 = new JButton("F5"); mapa.add(F5);
		JButton F6 = new JButton("F6"); mapa.add(F6);
		JButton F7 = new JButton("F7"); mapa.add(F7);
		JButton F8 = new JButton("F8"); mapa.add(F8);    
	        
		configurar(mapa);
        
	    //Legenda das cores dos assentos
        JLabel legenda = new JLabel("Verde - Selecionado, Roxo -Livre, Vermelho - Reservado");
        legenda.setForeground(new Color(230, 230, 250));
        legenda.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        assentos.add(legenda, BorderLayout.SOUTH);
		
        //Painel para a seleção dos tipos de ingresso
        JPanel tipoPanel = new JPanel();
		tipoPanel.setBackground(new Color(13, 1, 73));
		assentos.add(tipoPanel, BorderLayout.NORTH);
		
		//Ingressos tipo inteira
		JLabel inteira = new JLabel("Inteiras");
		inteira.setForeground(new Color(230, 230, 250));
		inteira.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		tipoPanel.add(inteira);
		
		inteiraSel = new JComboBox<String>();
		inteiraSel.setModel(new DefaultComboBoxModel<String>(new String[] {"0","1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(inteiraSel);
		
		//Ingressos tipo meia 
		JLabel meia = new JLabel("Meias");
		meia.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		meia.setForeground(new Color(230, 230, 250));
		tipoPanel.add(meia);
		
		meiaSel = new JComboBox<String>();
		meiaSel.setModel(new DefaultComboBoxModel<String>(new String[] {"0","1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(meiaSel);

        //Painel com o resumo dos dados do pedido 
		JPanel resumoPainel = new JPanel();
		resumoPainel.setBorder(new EmptyBorder(5, 8, 5, 8));
		resumoPainel.setBackground(new Color(54, 26, 115));
		resumoPainel.setMinimumSize(new Dimension(100, 300));
		resumoPainel.setLayout(new BoxLayout(resumoPainel, BoxLayout.Y_AXIS));
		assentos.add(resumoPainel, BorderLayout.EAST);
		
		//Painel e label escrito resumo do pedido
		JPanel tituloPainel = new JPanel();
		tituloPainel.setBorder(new EmptyBorder(5, 10, 5, 10));
		tituloPainel.setBackground(new Color(13, 1, 73));
		tituloPainel.setLayout(new BoxLayout(tituloPainel, BoxLayout.X_AXIS));
		resumoPainel.add(tituloPainel);
		
		JLabel resumoLabel = new JLabel("Resumo do pedido");
		resumoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		resumoLabel.setForeground(new Color(230, 230, 250));
		resumoLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 19));
		tituloPainel.add(resumoLabel);
		
		//Painel contendo os dados
		JPanel dadosFinaisPanel = new JPanel();
		dadosFinaisPanel.setBackground(new Color(54, 26, 115));
		dadosFinaisPanel.setBorder(new EmptyBorder(5, 4, 5, 3));
		dadosFinaisPanel.setLayout(new GridLayout(6, 1, 0, 0));
		resumoPainel.add(dadosFinaisPanel);
		
		//Titulo do filme
		JLabel tituloFinal = new JLabel("Filme: "+ filme.getTitulo());
		tituloFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		tituloFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(tituloFinal);
		
		//Dia selecionado
		JLabel dataFinal = new JLabel();
		dataFinal.setText("Data: "+ dia);
		dataFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		dataFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(dataFinal);
		
		//horário selecionado
		JLabel horarioFinal = new JLabel("horário: "+horarios_1.getSelectedItem());
		horarioFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		horarioFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(horarioFinal);
		
		//Quantidade de ingressos selecionados
		JLabel qtdIngressos = new JLabel("Qunatidade de ingressos: "+total);
		qtdIngressos.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		qtdIngressos.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(qtdIngressos);
		
		//Preço total 
		JLabel precoFinal = new JLabel("Preço total: ");
		precoFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		precoFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(precoFinal);
		
		//Painel e botão de finalizar compra
		JPanel finalizarPanel = new JPanel();
		finalizarPanel.setBackground(new Color(13, 1, 73));
		dadosFinaisPanel.add(finalizarPanel);
		
		JButton finalizar = new JButton("Finalizar compra");
		finalizar.setForeground(new Color(230, 230, 250));
		finalizar.setVerticalAlignment(SwingConstants.BOTTOM);
		finalizar.setBackground(new Color(54, 26, 115));
		finalizar.setBorder(new EmptyBorder(4, 4, 4, 4));
		finalizarPanel.add(finalizar);
	}

	private static void configurar(Container container) {
        Component[] components = container.getComponents();
        for (Component component : components) {
        	JButton button = (JButton) component;
            button.setBackground(new Color(171, 96, 237));
            button.setForeground(new Color(0, 0, 128));
            button.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        button.setBorderPainted(false);
        }
    }
	
	public void voltar(ActionEvent event) {
		dispose();
		new Entrada(filme, filme, filme, horarios);
	}
	public void selecionar(ActionEvent e) {
		JButton aqui = (JButton) e.getSource();
		aqui.setBackground(new Color(157,205,90));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
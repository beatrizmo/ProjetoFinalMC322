package CinemaToten;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

public class selecao extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	String[] horarios;
	String dia;
	Filme filme;
	
	public selecao(String[] horarios, Filme filme, String dia) {
		this.horarios = horarios;
		this.filme = filme;
		this.dia = dia;
		
		//Definições iniciais da tela
		setMaximumSize(new Dimension(1050, 575));
		setMinimumSize(new Dimension(1050, 575));
		setBackground(new Color(13, 1, 73));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Painel superior com as informações do cinema e do filme 
		JPanel info = new JPanel();
		info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		info.setPreferredSize(new Dimension(1000, 10));
		info.setMinimumSize(new Dimension(1000, 10));
		info.setBackground(new Color(13, 1, 73));
		add(info);
		
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
		tituloFilme.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		tituloFilme.setForeground(new Color(230, 230, 250));
		tituloPanel.add(tituloFilme);
		
		//Painel e botão para a seleção do horário de exibição
		JPanel horarioPanel = new JPanel();
		horarioPanel.setBackground(new Color(13, 1, 73));
		tituloData.add(horarioPanel);
		
		JLabel horarioLabel = new JLabel("Horário:");
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
        add(reserva);
		
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
	        JPanel A1 = new JPanel();
	        A1.setBackground(new Color(171, 96, 237));
	        mapa.add(A1);
	        JLabel A1lbl = new JLabel("A1");
	        A1lbl.setForeground(new Color(0, 0, 128));
	        A1lbl.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A1.add(A1lbl);
	        
	        JPanel A2 = new JPanel();
	        A2.setBackground(new Color(171, 96, 237));
	        mapa.add(A2);
	        JLabel lblA = new JLabel("A2");
	        lblA.setForeground(new Color(0, 0, 128));
	        lblA.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A2.add(lblA);
	        
	        JPanel A3 = new JPanel();
	        A3.setBackground(new Color(157, 205, 90));
	        mapa.add(A3);
	        JLabel lblA_1 = new JLabel("A3");
	        lblA_1.setForeground(new Color(0, 0, 128));
	        lblA_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A3.add(lblA_1);
	        
	        JPanel A4 = new JPanel();
	        A4.setBackground(new Color(171, 96, 237));
	        mapa.add(A4);
	        JLabel lblA_2 = new JLabel("A4");
	        lblA_2.setForeground(new Color(0, 0, 128));
	        lblA_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A4.add(lblA_2);
	        
	        JPanel A5 = new JPanel();
	        A5.setBackground(new Color(171, 96, 237));
	        mapa.add(A5);
	        JLabel lblA_3 = new JLabel("A5");
	        lblA_3.setForeground(new Color(0, 0, 128));
	        lblA_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A5.add(lblA_3);
	        
	        JPanel A6 = new JPanel();
	        A6.setBackground(new Color(171, 96, 237));
	        mapa.add(A6);
	        JLabel lblA_4 = new JLabel("A6");
	        lblA_4.setForeground(new Color(0, 0, 128));
	        lblA_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A6.add(lblA_4);
	        
	        JPanel A7 = new JPanel();
	        A7.setBackground(new Color(171, 96, 237));
	        mapa.add(A7);
	        JLabel lblA_5 = new JLabel("A7");
	        lblA_5.setForeground(new Color(0, 0, 128));
	        lblA_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A7.add(lblA_5);
	        
	        JPanel A8 = new JPanel();
	        A8.setBackground(new Color(171, 96, 237));
	        mapa.add(A8);
	        JLabel lblA_6 = new JLabel("A8");
	        lblA_6.setForeground(new Color(0, 0, 128));
	        lblA_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        A8.add(lblA_6);
	        
	        JPanel B1 = new JPanel();
	        B1.setBackground(new Color(171, 96, 237));
	        mapa.add(B1);
	        JLabel lblB = new JLabel("B1");
	        lblB.setForeground(new Color(0, 0, 128));
	        lblB.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B1.add(lblB);
	        
	        JPanel B2 = new JPanel();
	        B2.setBackground(new Color(171, 96, 237));
	        mapa.add(B2);
	        JLabel lblB_1 = new JLabel("B2");
	        lblB_1.setForeground(new Color(0, 0, 128));
	        lblB_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B2.add(lblB_1);
	        
	        JPanel B3 = new JPanel();
	        B3.setBackground(new Color(171, 96, 237));
	        mapa.add(B3);
	        JLabel lblB_2 = new JLabel("B3");
	        B3.add(lblB_2);
	        lblB_2.setForeground(new Color(0, 0, 128));
	        lblB_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        
	        JPanel B4 = new JPanel();
	        B4.setBackground(new Color(248, 86, 70));
	        mapa.add(B4);
	        JLabel lblB_3 = new JLabel("B4");
	        lblB_3.setForeground(new Color(0, 0, 128));
	        lblB_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B4.add(lblB_3);
	        
	        JPanel B5 = new JPanel();
	        B5.setBackground(new Color(171, 96, 237));
	        mapa.add(B5);
	        JLabel lblB_4 = new JLabel("B5");
	        lblB_4.setForeground(new Color(0, 0, 128));
	        lblB_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B5.add(lblB_4);
	        
	        JPanel B6 = new JPanel();
	        B6.setBackground(new Color(171, 96, 237));
	        mapa.add(B6);
	        JLabel lblB_5 = new JLabel("B6");
	        lblB_5.setForeground(new Color(0, 0, 128));
	        lblB_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B6.add(lblB_5);
	        
	        JPanel B7 = new JPanel();
	        B7.setBackground(new Color(171, 96, 237));
	        mapa.add(B7);
	        JLabel lblB_6 = new JLabel("B7");
	        lblB_6.setForeground(new Color(0, 0, 128));
	        lblB_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B7.add(lblB_6);
	        
	        JPanel B8 = new JPanel();
	        B8.setBackground(new Color(171, 96, 237));
	        mapa.add(B8);
	        JLabel lblB_7 = new JLabel("B8");
	        lblB_7.setForeground(new Color(0, 0, 128));
	        lblB_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        B8.add(lblB_7);
	        
	        JPanel C1 = new JPanel();
	        C1.setBackground(new Color(171, 96, 237));
	        mapa.add(C1);
	        JLabel lblC = new JLabel("C1");
	        lblC.setForeground(new Color(0, 0, 128));
	        lblC.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C1.add(lblC);
	        
	        JPanel C2 = new JPanel();
	        C2.setBackground(new Color(171, 96, 237));
	        mapa.add(C2);
	        JLabel lblC_1 = new JLabel("C2");
	        lblC_1.setForeground(new Color(0, 0, 128));
	        lblC_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C2.add(lblC_1);
	        
	        JPanel C3 = new JPanel();
	        C3.setBackground(new Color(171, 96, 237));
	        mapa.add(C3);
	        JLabel lblC_2 = new JLabel("C3");
	        lblC_2.setForeground(new Color(0, 0, 128));
	        lblC_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C3.add(lblC_2);
	        
	        JPanel C4 = new JPanel();
	        C4.setBackground(new Color(171, 96, 237));
	        mapa.add(C4);
	        JLabel lblC_3 = new JLabel("C4");
	        lblC_3.setForeground(new Color(0, 0, 128));
	        lblC_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C4.add(lblC_3);
	        
	        JPanel C5 = new JPanel();
	        C5.setBackground(new Color(171, 96, 237));
	        mapa.add(C5);
	        JLabel lblC_4 = new JLabel("C5");
	        lblC_4.setForeground(new Color(0, 0, 128));
	        lblC_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C5.add(lblC_4);
	        
	        JPanel C6 = new JPanel();
	        C6.setBackground(new Color(171, 96, 237));
	        mapa.add(C6);
	        JLabel lblC_5 = new JLabel("C6");
	        lblC_5.setForeground(new Color(0, 0, 128));
	        lblC_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C6.add(lblC_5);
	        
	        JPanel C7 = new JPanel();
	        C7.setBackground(new Color(171, 96, 237));
	        mapa.add(C7);
	        JLabel lblC_6 = new JLabel("C7");
	        lblC_6.setForeground(new Color(0, 0, 128));
	        lblC_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C7.add(lblC_6);
	        
	        JPanel C8 = new JPanel();
	        C8.setBackground(new Color(171, 96, 237));
	        mapa.add(C8);
	        JLabel lblC_7 = new JLabel("C8");
	        lblC_7.setForeground(new Color(0, 0, 128));
	        lblC_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        C8.add(lblC_7);
	        
	        JPanel D1 = new JPanel();
	        D1.setBackground(new Color(171, 96, 237));
	        mapa.add(D1);
	        JLabel lblD = new JLabel("D1");
	        lblD.setForeground(new Color(0, 0, 128));
	        lblD.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D1.add(lblD);
	        
	        JPanel D2 = new JPanel();
	        D2.setBackground(new Color(171, 96, 237));
	        mapa.add(D2);
	        JLabel lblD_1 = new JLabel("D2");
	        lblD_1.setForeground(new Color(0, 0, 128));
	        lblD_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D2.add(lblD_1);
	        
	        JPanel D3 = new JPanel();
	        D3.setBackground(new Color(171, 96, 237));
	        mapa.add(D3);
	        JLabel lblD_2 = new JLabel("D3");
	        lblD_2.setForeground(new Color(0, 0, 128));
	        lblD_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D3.add(lblD_2);
	        
	        JPanel D4 = new JPanel();
	        D4.setBackground(new Color(171, 96, 237));
	        mapa.add(D4);
	        JLabel lblD_3 = new JLabel("D4");
	        lblD_3.setForeground(new Color(0, 0, 128));
	        lblD_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D4.add(lblD_3);
	        
	        JPanel D5 = new JPanel();
	        D5.setBackground(new Color(171, 96, 237));
	        mapa.add(D5);
	        JLabel lblD_4 = new JLabel("D5");
	        lblD_4.setForeground(new Color(0, 0, 128));
	        lblD_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D5.add(lblD_4);
	        
	        JPanel D6 = new JPanel();
	        D6.setBackground(new Color(171, 96, 237));
	        mapa.add(D6);
	        JLabel lblD_5 = new JLabel("D6");
	        lblD_5.setForeground(new Color(0, 0, 128));
	        lblD_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D6.add(lblD_5);
	        
	        JPanel D7 = new JPanel();
	        D7.setBackground(new Color(171, 96, 237));
	        mapa.add(D7);
	        JLabel lblD_6 = new JLabel("D7");
	        lblD_6.setForeground(new Color(0, 0, 128));
	        lblD_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D7.add(lblD_6);
	        
	        JPanel D8 = new JPanel();
	        D8.setBackground(new Color(171, 96, 237));
	        mapa.add(D8);
	        JLabel lblD_7 = new JLabel("D8");
	        lblD_7.setForeground(new Color(0, 0, 128));
	        lblD_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        D8.add(lblD_7);
	        
	        JPanel E1 = new JPanel();
	        E1.setBackground(new Color(171, 96, 237));
	        mapa.add(E1);
	        JLabel lblE = new JLabel("E1");
	        lblE.setForeground(new Color(0, 0, 128));
	        lblE.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E1.add(lblE);
	        
	        JPanel E2 = new JPanel();
	        E2.setBackground(new Color(171, 96, 237));
	        mapa.add(E2);
	        JLabel lblE_1 = new JLabel("E2");
	        lblE_1.setForeground(new Color(0, 0, 128));
	        lblE_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E2.add(lblE_1);
	        
	        JPanel E3 = new JPanel();
	        E3.setBackground(new Color(171, 96, 237));
	        mapa.add(E3);
	        JLabel lblE_2 = new JLabel("E3");
	        lblE_2.setForeground(new Color(0, 0, 128));
	        lblE_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E3.add(lblE_2);
	        
	        JPanel E4 = new JPanel();
	        E4.setBackground(new Color(171, 96, 237));
	        mapa.add(E4);
	        JLabel lblE_3 = new JLabel("E4");
	        lblE_3.setForeground(new Color(0, 0, 128));
	        lblE_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E4.add(lblE_3);
	        
	        JPanel E5 = new JPanel();
	        E1.setBackground(new Color(171, 96, 237));
	        mapa.add(E5);
	        JLabel lblE_4 = new JLabel("E5");
	        lblE_4.setForeground(new Color(0, 0, 128));
	        lblE_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E5.add(lblE_4);
	        
	        JPanel E6 = new JPanel();
	        E6.setBackground(new Color(171, 96, 237));
	        mapa.add(E6);
	        JLabel lblE_5 = new JLabel("E6");
	        lblE_5.setForeground(new Color(0, 0, 128));
	        lblE_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E6.add(lblE_5);
	        
	        JPanel E7 = new JPanel();
	        E7.setBackground(new Color(171, 96, 237));
	        mapa.add(E7);
	        JLabel lblE_6 = new JLabel("E7");
	        lblE_6.setForeground(new Color(0, 0, 128));
	        lblE_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E7.add(lblE_6);
	        
	        JPanel E8 = new JPanel();
	        E8.setBackground(new Color(171, 96, 237));
	        mapa.add(E8);
	        JLabel lblE_7 = new JLabel("E8");
	        lblE_7.setForeground(new Color(0, 0, 128));
	        lblE_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        E8.add(lblE_7);
	        
	        JPanel F1 = new JPanel();
	        F1.setBackground(new Color(171, 96, 237));
	        mapa.add(F1);
	        JLabel lblF = new JLabel("F1");
	        lblF.setForeground(new Color(0, 0, 128));
	        lblF.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F1.add(lblF);
	        
	        JPanel F2 = new JPanel();
	        F2.setBackground(new Color(171, 96, 237));
	        mapa.add(F2);
	        JLabel lblF_1 = new JLabel("F2");
	        lblF_1.setForeground(new Color(0, 0, 128));
	        lblF_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F2.add(lblF_1);
	        
	        JPanel F3 = new JPanel();
	        F3.setBackground(new Color(171, 96, 237));
	        mapa.add(F3);
	        JLabel lblF_2 = new JLabel("F3");
	        lblF_2.setForeground(new Color(0, 0, 128));
	        lblF_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F3.add(lblF_2);
	        
	        JPanel F4 = new JPanel();
	        F4.setBackground(new Color(171, 96, 237));
	        mapa.add(F4);
	        JLabel lblF_3 = new JLabel("F4");
	        lblF_3.setForeground(new Color(0, 0, 128));
	        lblF_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F4.add(lblF_3);
	        
	        JPanel F5 = new JPanel();
	        F5.setBackground(new Color(171, 96, 237));
	        mapa.add(F5);
	        JLabel lblF_4 = new JLabel("F5");
	        lblF_4.setForeground(new Color(0, 0, 128));
	        lblF_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F5.add(lblF_4);
	        
	        JPanel F6 = new JPanel();
	        F6.setBackground(new Color(171, 96, 237));
	        mapa.add(F6);
	        JLabel lblF_5 = new JLabel("F6");
	        lblF_5.setForeground(new Color(0, 0, 128));
	        lblF_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F6.add(lblF_5);
	        
	        JPanel F7 = new JPanel();
	        F7.setBackground(new Color(171, 96, 237));
	        mapa.add(F7);
	        JLabel lblF_6 = new JLabel("F7");
	        lblF_6.setForeground(new Color(0, 0, 128));
	        lblF_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F7.add(lblF_6);
	        
	        JPanel F8 = new JPanel();
	        F8.setBackground(new Color(171, 96, 237));
	        mapa.add(F8);
	        JLabel lblF_7 = new JLabel("F8");
	        lblF_7.setForeground(new Color(0, 0, 128));
	        lblF_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        F8.add(lblF_7);
        
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
		
		JComboBox<String> inteiraSel = new JComboBox<String>();
		inteiraSel.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(inteiraSel);
		
		//Ingressos tipo meia 
		JLabel meia = new JLabel("Meias");
		meia.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		meia.setForeground(new Color(230, 230, 250));
		tipoPanel.add(meia);
		
		JComboBox<String> meiaSel = new JComboBox<String>();
		meiaSel.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
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
		JLabel tituloFinal = new JLabel("Nome do filme");
		tituloFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		tituloFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(tituloFinal);
		
		//Dia selecionado
		JLabel dataFinal = new JLabel();
		dataFinal.setText(dia);
		dataFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		dataFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(dataFinal);
		
		//horário selecionado
		JLabel horarioFinal = new JLabel("horario");
		horarioFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		horarioFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(horarioFinal);
		
		//Quantidade de ingressos selecionados
		JLabel qtdIngressos = new JLabel("Qunatidade de ingresso");
		qtdIngressos.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		qtdIngressos.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(qtdIngressos);
		
		//Preço total 
		JLabel precoFinal = new JLabel("Preço totoal");
		precoFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		precoFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(precoFinal);
		
		//Painel e botão de finalizar compra
		JPanel finalizarPanel = new JPanel();
		finalizarPanel.setBackground(new Color(13, 1, 73));
		dadosFinaisPanel.add(finalizarPanel);
		
		JButton finalizar = new JButton("Finalizar compra");
		finalizar.setVerticalAlignment(SwingConstants.BOTTOM);
		finalizar.setBackground(new Color(54, 26, 115));
		finalizar.setBorder(new EmptyBorder(4, 4, 4, 4));
		finalizarPanel.add(finalizar);
	}

}

package CinemaToten;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Point;
import java.awt.CardLayout;

public class selecao extends JPanel {

	/**
	 * Create the panel.
	 */
	public selecao() {
		setBackground(new Color(13, 1, 73));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel dados = new JPanel();
		dados.setPreferredSize(new Dimension(1000, 130));
		dados.setMinimumSize(new Dimension(1000, 10));
		dados.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dados.setBackground(new Color(13, 1, 73));
		dados.setLayout(new BoxLayout(dados, BoxLayout.Y_AXIS));
		
		JPanel inicial = new JPanel();
		inicial.setBackground(new Color(13, 1, 73));
		dados.add(inicial);
		inicial.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel voltarPanel = new JPanel();
		FlowLayout fl_voltarPanel = (FlowLayout) voltarPanel.getLayout();
		voltarPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		voltarPanel.setBackground(new Color(13, 1, 73));
		inicial.add(voltarPanel);
		
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.setAlignmentY(Component.TOP_ALIGNMENT);
		voltarPanel.add(voltarButton);
		voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		voltarButton.setHorizontalAlignment(SwingConstants.LEFT);
		voltarButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		voltarButton.setForeground(new Color(13, 1, 73));
		voltarButton.setBackground(new Color(54, 26, 115));
		
		JPanel vazio = new JPanel();
		FlowLayout fl_vazio = (FlowLayout) vazio.getLayout();
		fl_vazio.setAlignment(FlowLayout.TRAILING);
		vazio.setBorder(new EmptyBorder(0, 50, 0, 50));
		vazio.setBackground(new Color(13, 1, 73));
		inicial.add(vazio);
		
		JLabel cinema = new JLabel("SuperCine");
		inicial.add(cinema);
		cinema.setAlignmentX(Component.CENTER_ALIGNMENT);
		cinema.setHorizontalAlignment(SwingConstants.CENTER);
		cinema.setForeground(new Color(230, 230, 250));
		cinema.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		cinema.setBackground(new Color(13, 1, 73));
		
		JPanel tituloData = new JPanel();
		tituloData.setBackground(new Color(13, 1, 73));
		dados.add(tituloData);
		tituloData.setLayout(new BoxLayout(tituloData, BoxLayout.X_AXIS));
		
		JPanel tituloPanel = new JPanel();
		FlowLayout fl_tituloPanel = (FlowLayout) tituloPanel.getLayout();
		fl_tituloPanel.setAlignment(FlowLayout.LEFT);
		tituloPanel.setBackground(new Color(13, 1, 73));
		tituloData.add(tituloPanel);
		
		JLabel tituloFilme = new JLabel("Nem que a vaca  que a vaca tussa ");
		tituloPanel.add(tituloFilme);
		tituloFilme.setMaximumSize(new Dimension(500, 45));
		tituloFilme.setFocusTraversalKeysEnabled(false);
		tituloFilme.setHorizontalTextPosition(SwingConstants.LEFT);
		tituloFilme.setHorizontalAlignment(SwingConstants.RIGHT);
		tituloFilme.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		tituloFilme.setForeground(new Color(230, 230, 250));
		
		JPanel horarioPanel = new JPanel();
		horarioPanel.setBackground(new Color(13, 1, 73));
		tituloData.add(horarioPanel);
		
		JLabel horarioLabel = new JLabel("Horário:");
		horarioLabel.setForeground(new Color(230, 230, 250));
		horarioLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		horarioPanel.add(horarioLabel);
		
		JComboBox<?> horarios_1 = new JComboBox<Object>();
		horarioPanel.add(horarios_1);
		horarios_1.setModel((ComboBoxModel<?>) new DefaultComboBoxModel<Object>(new String[] {"18:00", "20:00", "22:00"}));
		horarios_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		JPanel info = new JPanel();
		info.setPreferredSize(new Dimension(1000, 10));
		info.setMinimumSize(new Dimension(1000, 10));
		info.setBackground(new Color(13, 1, 73));
		add(info);
		info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		info.add(dados);
		
		JPanel reserva = new JPanel();
        reserva.setBackground(new Color(13, 1, 73));
        add(reserva);
        reserva.setLayout(new GridLayout(1, 5, 0, 0));

        // Create and add seat buttons to the seat map
        for (int i = 1; i <= 25; i++) {
            JButton seatButton = new JButton("Seat " + i);
            mapa.add(seatButton);
            // Add ActionListener and seat booking logic here as mentioned in the previous response
        }
		
        JPanel assentos = new JPanel();
        assentos.setBorder(new EmptyBorder(20, 60, 20, 60));
        assentos.setBackground(new Color(13, 1, 73));
        reserva.add(assentos);
        assentos.setLayout(new BorderLayout());
		        
        JPanel mapa = new JPanel();
        mapa.setBorder(new EmptyBorder(20, 30, 20, 30));
        mapa.setBackground(new Color(13, 1, 73));
        assentos.add(mapa, BorderLayout.CENTER);
        mapa.setLayout(new GridLayout(6, 8, 3, 3));
        
        JPanel A1 = new JPanel();
        A1.setBackground(new Color(171, 96, 237));
        mapa.add(A1);
        
        JLabel A1lbl = new JLabel("A1");
        A1lbl.setForeground(new Color(0, 0, 128));
        A1lbl.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A1.add(A1lbl);
        JPanel A2 = new JPanel();
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
        mapa.add(A4);
        
        JLabel lblA_2 = new JLabel("A4");
        lblA_2.setForeground(new Color(0, 0, 128));
        lblA_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A4.add(lblA_2);
        JPanel A5 = new JPanel();
        mapa.add(A5);
        
        JLabel lblA_3 = new JLabel("A5");
        lblA_3.setForeground(new Color(0, 0, 128));
        lblA_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A5.add(lblA_3);
        JPanel A6 = new JPanel();
        mapa.add(A6);
        
        JLabel lblA_4 = new JLabel("A6");
        lblA_4.setForeground(new Color(0, 0, 128));
        lblA_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A6.add(lblA_4);
        JPanel A7 = new JPanel();
        mapa.add(A7);
        
        JLabel lblA_5 = new JLabel("A7");
        lblA_5.setForeground(new Color(0, 0, 128));
        lblA_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A7.add(lblA_5);
        JPanel A8 = new JPanel();
        mapa.add(A8);
        
        JLabel lblA_6 = new JLabel("A8");
        lblA_6.setForeground(new Color(0, 0, 128));
        lblA_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        A8.add(lblA_6);
        JPanel B1 = new JPanel();
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
        mapa.add(B5);
        
        JLabel lblB_4 = new JLabel("B5");
        lblB_4.setForeground(new Color(0, 0, 128));
        lblB_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        B5.add(lblB_4);
        JPanel B6 = new JPanel();
        mapa.add(B6);
        
        JLabel lblB_5 = new JLabel("B6");
        lblB_5.setForeground(new Color(0, 0, 128));
        lblB_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        B6.add(lblB_5);
        JPanel B7 = new JPanel();
        mapa.add(B7);
        
        JLabel lblB_6 = new JLabel("B7");
        lblB_6.setForeground(new Color(0, 0, 128));
        lblB_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        B7.add(lblB_6);
        JPanel B8 = new JPanel();
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
        mapa.add(C2);
        
        JLabel lblC_1 = new JLabel("C2");
        lblC_1.setForeground(new Color(0, 0, 128));
        lblC_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C2.add(lblC_1);
        JPanel C3 = new JPanel();
        mapa.add(C3);
        
        JLabel lblC_2 = new JLabel("C3");
        lblC_2.setForeground(new Color(0, 0, 128));
        lblC_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C3.add(lblC_2);
        JPanel C4 = new JPanel();
        mapa.add(C4);
        
        JLabel lblC_3 = new JLabel("C4");
        lblC_3.setForeground(new Color(0, 0, 128));
        lblC_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C4.add(lblC_3);
        JPanel C5 = new JPanel();
        mapa.add(C5);
        
        JLabel lblC_4 = new JLabel("C5");
        lblC_4.setForeground(new Color(0, 0, 128));
        lblC_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C5.add(lblC_4);
        JPanel C6 = new JPanel();
        mapa.add(C6);
        
        JLabel lblC_5 = new JLabel("C6");
        lblC_5.setForeground(new Color(0, 0, 128));
        lblC_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C6.add(lblC_5);
        JPanel C7 = new JPanel();
        mapa.add(C7);
        
        JLabel lblC_6 = new JLabel("C7");
        lblC_6.setForeground(new Color(0, 0, 128));
        lblC_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C7.add(lblC_6);
        JPanel C8 = new JPanel();
        mapa.add(C8);
        
        JLabel lblC_7 = new JLabel("C8");
        lblC_7.setForeground(new Color(0, 0, 128));
        lblC_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        C8.add(lblC_7);
        JPanel D1 = new JPanel();
        mapa.add(D1);
        
        JLabel lblD = new JLabel("D1");
        lblD.setForeground(new Color(0, 0, 128));
        lblD.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D1.add(lblD);
        JPanel D2 = new JPanel();
        mapa.add(D2);
        
        JLabel lblD_1 = new JLabel("D2");
        lblD_1.setForeground(new Color(0, 0, 128));
        lblD_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D2.add(lblD_1);
        JPanel D3 = new JPanel();
        mapa.add(D3);
        
        JLabel lblD_2 = new JLabel("D3");
        lblD_2.setForeground(new Color(0, 0, 128));
        lblD_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D3.add(lblD_2);
        JPanel D4 = new JPanel();
        mapa.add(D4);
        
        JLabel lblD_3 = new JLabel("D4");
        lblD_3.setForeground(new Color(0, 0, 128));
        lblD_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D4.add(lblD_3);
        JPanel D5 = new JPanel();
        mapa.add(D5);
        
        JLabel lblD_4 = new JLabel("D5");
        lblD_4.setForeground(new Color(0, 0, 128));
        lblD_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D5.add(lblD_4);
        JPanel D6 = new JPanel();
        mapa.add(D6);
        
        JLabel lblD_5 = new JLabel("D6");
        lblD_5.setForeground(new Color(0, 0, 128));
        lblD_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D6.add(lblD_5);
        JPanel D7 = new JPanel();
        mapa.add(D7);
        
        JLabel lblD_6 = new JLabel("D7");
        lblD_6.setForeground(new Color(0, 0, 128));
        lblD_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D7.add(lblD_6);
        JPanel D8 = new JPanel();
        mapa.add(D8);
        
        JLabel lblD_7 = new JLabel("D8");
        lblD_7.setForeground(new Color(0, 0, 128));
        lblD_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        D8.add(lblD_7);
        JPanel E1 = new JPanel();
        mapa.add(E1);
        
        JLabel lblE = new JLabel("E1");
        lblE.setForeground(new Color(0, 0, 128));
        lblE.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E1.add(lblE);
        JPanel E2 = new JPanel();
        mapa.add(E2);
        
        JLabel lblE_1 = new JLabel("E2");
        lblE_1.setForeground(new Color(0, 0, 128));
        lblE_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E2.add(lblE_1);
        JPanel E3 = new JPanel();
        mapa.add(E3);
        
        JLabel lblE_2 = new JLabel("E3");
        lblE_2.setForeground(new Color(0, 0, 128));
        lblE_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E3.add(lblE_2);
        JPanel E4 = new JPanel();
        mapa.add(E4);
        
        JLabel lblE_3 = new JLabel("E4");
        lblE_3.setForeground(new Color(0, 0, 128));
        lblE_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E4.add(lblE_3);
        JPanel E5 = new JPanel();
        mapa.add(E5);
        
        JLabel lblE_4 = new JLabel("E5");
        lblE_4.setForeground(new Color(0, 0, 128));
        lblE_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E5.add(lblE_4);
        JPanel E6 = new JPanel();
        mapa.add(E6);
        
        JLabel lblE_5 = new JLabel("E6");
        lblE_5.setForeground(new Color(0, 0, 128));
        lblE_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E6.add(lblE_5);
        JPanel E7 = new JPanel();
        mapa.add(E7);
        
        JLabel lblE_6 = new JLabel("E7");
        lblE_6.setForeground(new Color(0, 0, 128));
        lblE_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E7.add(lblE_6);
        JPanel E8 = new JPanel();
        mapa.add(E8);
        
        JLabel lblE_7 = new JLabel("E8");
        lblE_7.setForeground(new Color(0, 0, 128));
        lblE_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        E8.add(lblE_7);
        JPanel F1 = new JPanel();
        mapa.add(F1);
        
        JLabel lblF = new JLabel("F1");
        lblF.setForeground(new Color(0, 0, 128));
        lblF.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F1.add(lblF);
        JPanel F2 = new JPanel();
        mapa.add(F2);
        
        JLabel lblF_1 = new JLabel("F2");
        lblF_1.setForeground(new Color(0, 0, 128));
        lblF_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F2.add(lblF_1);
        JPanel F3 = new JPanel();
        mapa.add(F3);
        
        JLabel lblF_2 = new JLabel("F3");
        lblF_2.setForeground(new Color(0, 0, 128));
        lblF_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F3.add(lblF_2);
        JPanel F4 = new JPanel();
        mapa.add(F4);
        
        JLabel lblF_3 = new JLabel("F4");
        lblF_3.setForeground(new Color(0, 0, 128));
        lblF_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F4.add(lblF_3);
        JPanel F5 = new JPanel();
        mapa.add(F5);
        
        JLabel lblF_4 = new JLabel("F5");
        lblF_4.setForeground(new Color(0, 0, 128));
        lblF_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F5.add(lblF_4);
        JPanel F6 = new JPanel();
        mapa.add(F6);
        
        JLabel lblF_5 = new JLabel("F6");
        lblF_5.setForeground(new Color(0, 0, 128));
        lblF_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F6.add(lblF_5);
        JPanel F7 = new JPanel();
        mapa.add(F7);
        
        JLabel lblF_6 = new JLabel("F7");
        lblF_6.setForeground(new Color(0, 0, 128));
        lblF_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F7.add(lblF_6);
        JPanel F8 = new JPanel();
        mapa.add(F8);
        
        JLabel lblF_7 = new JLabel("F8");
        lblF_7.setForeground(new Color(0, 0, 128));
        lblF_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        F8.add(lblF_7);
        
        JLabel legenda = new JLabel("Verde - Selecionado, Roxo -Livre, Vermelho - Reservado");
        legenda.setForeground(new Color(230, 230, 250));
        legenda.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        assentos.add(legenda, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 8, 5, 8));
		panel.setAlignmentY(15.0f);
		assentos.add(panel, BorderLayout.EAST);
		panel.setBackground(new Color(54, 26, 115));
		panel.setMinimumSize(new Dimension(100, 300));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel resumoPanel = new JPanel();
		resumoPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		resumoPanel.setBackground(new Color(13, 1, 73));
		panel.add(resumoPanel);
		resumoPanel.setLayout(new BoxLayout(resumoPanel, BoxLayout.X_AXIS));
		
		JLabel resumoLabel = new JLabel("Resumo do pedido");
		resumoPanel.add(resumoLabel);
		resumoLabel.setAlignmentY(10.0f);
		resumoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		resumoLabel.setForeground(new Color(230, 230, 250));
		resumoLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 19));
		
		JPanel dadosFinaisPanel = new JPanel();
		dadosFinaisPanel.setBackground(new Color(54, 26, 115));
		dadosFinaisPanel.setBorder(new EmptyBorder(5, 4, 5, 3));
		panel.add(dadosFinaisPanel);
		dadosFinaisPanel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel tituloFinal = new JLabel("Nome do filme");
		dadosFinaisPanel.add(tituloFinal);
		tituloFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		tituloFinal.setForeground(new Color(230, 230, 250));
		
		JLabel dataFinal = new JLabel("data");
		dadosFinaisPanel.add(dataFinal);
		dataFinal.setForeground(new Color(230, 230, 250));
		dataFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		dataFinal.setAlignmentX(0.5f);
		
		JLabel horarioFinal = new JLabel("horario");
		dadosFinaisPanel.add(horarioFinal);
		horarioFinal.setForeground(new Color(230, 230, 250));
		horarioFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		horarioFinal.setAlignmentX(0.5f);
		
		JLabel qtdIngressos = new JLabel("Qunatidade de ingresso");
		dadosFinaisPanel.add(qtdIngressos);
		qtdIngressos.setForeground(new Color(230, 230, 250));
		qtdIngressos.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		qtdIngressos.setAlignmentX(0.5f);
		
		JLabel precoFinal = new JLabel("Preço totoal");
		dadosFinaisPanel.add(precoFinal);
		precoFinal.setForeground(new Color(230, 230, 250));
		precoFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		precoFinal.setAlignmentX(0.5f);
		
		JPanel finalizarPanel = new JPanel();
		finalizarPanel.setBackground(new Color(13, 1, 73));
		dadosFinaisPanel.add(finalizarPanel);
		
		JButton finalizar = new JButton("Finalizar compra");
		finalizar.setVerticalAlignment(SwingConstants.BOTTOM);
		finalizar.setBackground(new Color(54, 26, 115));
		finalizar.setBorder(new EmptyBorder(4, 4, 4, 4));
		finalizarPanel.add(finalizar);
		
		JPanel tipoPanel = new JPanel();
		tipoPanel.setBackground(new Color(13, 1, 73));
		assentos.add(tipoPanel, BorderLayout.NORTH);
		
		JLabel inteira = new JLabel("Inteiras");
		inteira.setForeground(new Color(230, 230, 250));
		inteira.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		tipoPanel.add(inteira);
		
		JComboBox inteiraSel = new JComboBox();
		inteiraSel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(inteiraSel);
		
		JLabel meia = new JLabel("Meias");
		meia.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		meia.setForeground(new Color(230, 230, 250));
		tipoPanel.add(meia);
		
		JComboBox meiaSel = new JComboBox();
		meiaSel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(meiaSel);

	}

}

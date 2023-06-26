package CinemaToten;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

//Classe seleção que cria a tela de seleção de assentos

public class Selecao extends JFrame implements ActionListener{
	
	static Color roxo=new Color(171,96,237);
	static Color fundo=new Color(13, 1, 73);
	static Color vermelho=new Color(248,86,70);
	static Color verde=new Color(157,205,90);
	JLabel qtdIngressos;
	JLabel precoFinal;
	String dia, hora;
	Filme filme;
	JPanel mapa;
	static Sessao sessao;
	int total=0,sel=0, preco = 0;
	static Reservar reservas = new Reservar("AssentosReservados.csv");
	JComboBox<String> meiaSel, inteiraSel;
	ArrayList<Sessao> lista;
	ArrayList<String> lugares = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private JTextField txtDigiteSeuNome;
	
	public Selecao(ArrayList<Sessao> lista,Sessao sessao) {
		this.hora = sessao.getHorario();
		this.filme = sessao.getFilme();
		this.dia = sessao.getData();
		this.lista = lista;
		Selecao.sessao = sessao;
		
		
		setVisible(true);
		
		//Definições iniciais da tela
		setSize(1050,675);
		setTitle("SuperCine - Compra de ingressos");
		setBackground(fundo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Painel superior com as informações do cinema e do filme 
		JPanel info = new JPanel();
		info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		info.setPreferredSize(new Dimension(1000, 10));
		info.setMinimumSize(new Dimension(1000, 10));
		info.setBackground(fundo);
		getContentPane().add(info);
		
		JPanel dados = new JPanel();
		dados.setPreferredSize(new Dimension(1000, 130));
		dados.setMinimumSize(new Dimension(1000, 10));
		dados.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dados.setBackground(fundo);
		dados.setLayout(new BoxLayout(dados, BoxLayout.Y_AXIS));
		info.add(dados);
		
		//Painel com o nome do cinema e o botão de volta para a página anterior
		JPanel head = new JPanel();
		head.setBackground(fundo);
		head.setLayout(new GridLayout(0, 5, 0, 0));
		dados.add(head);
		
		//Painel e botão para voltar para a página de seleção de filme 
		JPanel voltarPanel = new JPanel();
		voltarPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		voltarPanel.setBackground(fundo);
		head.add(voltarPanel);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		voltarButton.setForeground(new Color(230, 230, 250));
		voltarButton.setBackground(new Color(54, 26, 115));
		voltarButton.addActionListener(this::voltar);
		voltarPanel.add(voltarButton);
		
		//Painel vaxio para manter o espaçamento
		JPanel vazio = new JPanel();
		vazio.setBorder(new EmptyBorder(0, 50, 0, 50));
		vazio.setBackground(fundo);
		head.add(vazio);
		
		//Painel e nome do Cinema
		JLabel cinema = new JLabel("SuperCine");
		cinema.setBackground(fundo);
		cinema.setAlignmentX(Component.CENTER_ALIGNMENT);
		cinema.setHorizontalAlignment(SwingConstants.CENTER);
		cinema.setForeground(new Color(230, 230, 250));
		cinema.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		head.add(cinema);
		
		//Painel contendo O título do filme e o botão de seleção de horario 
		JPanel tituloData = new JPanel();
		tituloData.setBackground(fundo);
		tituloData.setLayout(new BoxLayout(tituloData, BoxLayout.X_AXIS));
		dados.add(tituloData);
		
		//Painel e label contendo o nome do filme selecionado
		JPanel tituloPanel = new JPanel();
		tituloPanel.setBackground(fundo);
		tituloData.add(tituloPanel);
		
		JLabel tituloFilme = new JLabel();
		tituloFilme.setAlignmentX(Component.CENTER_ALIGNMENT);
		tituloFilme.setText(filme.getTitulo());
		tituloFilme.setMaximumSize(new Dimension(500, 45));
		tituloFilme.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloFilme.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		tituloFilme.setForeground(new Color(230, 230, 250));
		tituloPanel.add(tituloFilme);

		
		//Painel inferior para a seleção de assentos e resumo do pedido
		JPanel reserva = new JPanel();
        reserva.setBackground(fundo);
        reserva.setLayout(new GridLayout(1, 5, 0, 0));
        getContentPane().add(reserva);
		
        JPanel assentos = new JPanel();
        assentos.setBorder(new EmptyBorder(20, 60, 20, 60));
        assentos.setBackground(fundo);
        reserva.add(assentos);
        assentos.setLayout(new BorderLayout());
		
        //Mapa de Assentos
        mapa = new JPanel();
        mapa.setBorder(new EmptyBorder(20, 30, 20, 30));
        mapa.setBackground(fundo);
        assentos.add(mapa, BorderLayout.CENTER);
        mapa.setLayout(new GridLayout(6, 8, 10, 10));
        
        //Assentos
        JButton A1 = new JButton("A1"); mapa.add(A1);
        A1.addActionListener((ActionEvent e) -> {lugarSelecionado(A1,"A1");});
        JButton A2 = new JButton("A2"); mapa.add(A2);
        A2.addActionListener((ActionEvent e) -> {lugarSelecionado(A2,"A2");});
        JButton A3 = new JButton("A3"); mapa.add(A3);
        A3.addActionListener((ActionEvent e) -> {lugarSelecionado(A3,"A3");});
        JButton A4 = new JButton("A4"); mapa.add(A4);
        A4.addActionListener((ActionEvent e) -> {lugarSelecionado(A4,"A4");});
        JButton A5 = new JButton("A5"); mapa.add(A5);
        A5.addActionListener((ActionEvent e) -> {lugarSelecionado(A5,"A5");});
        JButton A6 = new JButton("A6"); mapa.add(A6);
        A6.addActionListener((ActionEvent e) -> {lugarSelecionado(A6,"A6");});
        JButton A7 = new JButton("A7"); mapa.add(A7);
        A7.addActionListener((ActionEvent e) -> {lugarSelecionado(A7,"A7");});
        JButton A8 = new JButton("A8"); mapa.add(A8);
        A8.addActionListener((ActionEvent e) -> {lugarSelecionado(A8,"A8");});
        JButton B1 = new JButton("B1"); mapa.add(B1);
        B1.addActionListener((ActionEvent e) -> {lugarSelecionado(B1,"B1");});
        JButton B2 = new JButton("B2"); mapa.add(B2);
        B2.addActionListener((ActionEvent e) -> {lugarSelecionado(B2,"B2");});
        JButton B3 = new JButton("B3"); mapa.add(B3);
        B3.addActionListener((ActionEvent e) -> {lugarSelecionado(B3,"B3");});
        JButton B4 = new JButton("B4"); mapa.add(B4);
        B4.addActionListener((ActionEvent e) -> {lugarSelecionado(B4,"B4");});
        JButton B5 = new JButton("B5"); mapa.add(B5);
        B5.addActionListener((ActionEvent e) -> {lugarSelecionado(B5,"B5");});
        JButton B6 = new JButton("B6"); mapa.add(B6);
        B6.addActionListener((ActionEvent e) -> {lugarSelecionado(B6,"B6");});
        JButton B7 = new JButton("B7"); mapa.add(B7);
        B7.addActionListener((ActionEvent e) -> {lugarSelecionado(B7,"B7");});
        JButton B8 = new JButton("B8"); mapa.add(B8);
        B8.addActionListener((ActionEvent e) -> {lugarSelecionado(B8,"B8");});
        JButton C1 = new JButton("C1"); mapa.add(C1);
        C1.addActionListener((ActionEvent e) -> {lugarSelecionado(C1,"C1");});
        JButton C2 = new JButton("C2"); mapa.add(C2);
        C2.addActionListener((ActionEvent e) -> {lugarSelecionado(C2,"C2");});
        JButton C3 = new JButton("C3"); mapa.add(C3);
        C3.addActionListener((ActionEvent e) -> {lugarSelecionado(C3,"C3");});
        JButton C4 = new JButton("C4"); mapa.add(C4);
        C4.addActionListener((ActionEvent e) -> {lugarSelecionado(C4,"C4");});
        JButton C5 = new JButton("C5"); mapa.add(C5);
        C5.addActionListener((ActionEvent e) -> {lugarSelecionado(C5,"C5");});
        JButton C6 = new JButton("C6"); mapa.add(C6);
        C6.addActionListener((ActionEvent e) -> {lugarSelecionado(C6,"C6");});
        JButton C7 = new JButton("C7"); mapa.add(C7);
        C7.addActionListener((ActionEvent e) -> {lugarSelecionado(C7,"C7");});
        JButton C8 = new JButton("C8"); mapa.add(C8);
        C8.addActionListener((ActionEvent e) -> {lugarSelecionado(C8,"C8");});
        JButton D1 = new JButton("D1"); mapa.add(D1);
        D1.addActionListener((ActionEvent e) -> {lugarSelecionado(D1,"D1");});
        JButton D2 = new JButton("D2"); mapa.add(D2);
        D2.addActionListener((ActionEvent e) -> {lugarSelecionado(D2,"D2");});
        JButton D3 = new JButton("D3"); mapa.add(D3);
        D3.addActionListener((ActionEvent e) -> {lugarSelecionado(D3,"D3");});
        JButton D4 = new JButton("D4"); mapa.add(D4);
        D4.addActionListener((ActionEvent e) -> {lugarSelecionado(D4,"D4");});
        JButton D5 = new JButton("D5"); mapa.add(D5);
        D5.addActionListener((ActionEvent e) -> {lugarSelecionado(D5,"D5");});
        JButton D6 = new JButton("D6"); mapa.add(D6);
        D6.addActionListener((ActionEvent e) -> {lugarSelecionado(D6,"D6");});
        JButton D7 = new JButton("D7"); mapa.add(D7);
        D7.addActionListener((ActionEvent e) -> {lugarSelecionado(D7,"D7");});
        JButton D8 = new JButton("D8"); mapa.add(D8);
        D8.addActionListener((ActionEvent e) -> {lugarSelecionado(D8,"D8");});
        JButton E1 = new JButton("E1"); mapa.add(E1);
        E1.addActionListener((ActionEvent e) -> {lugarSelecionado(E1,"E1");});
        JButton E2 = new JButton("E2"); mapa.add(E2);
        E2.addActionListener((ActionEvent e) -> {lugarSelecionado(E2,"E2");});
        JButton E3 = new JButton("E3"); mapa.add(E3);
        E3.addActionListener((ActionEvent e) -> {lugarSelecionado(E3,"E3");});
        JButton E4 = new JButton("E4"); mapa.add(E4);
        E4.addActionListener((ActionEvent e) -> {lugarSelecionado(E4,"E4");});
        JButton E5 = new JButton("E5"); mapa.add(E5);
        E5.addActionListener((ActionEvent e) -> {lugarSelecionado(E5,"E5");});
        JButton E6 = new JButton("E6"); mapa.add(E6);
        E6.addActionListener((ActionEvent e) -> {lugarSelecionado(E6,"E6");});
        JButton E7 = new JButton("E7"); mapa.add(E7);
        E7.addActionListener((ActionEvent e) -> {lugarSelecionado(E7,"E7");});
        JButton E8 = new JButton("E8"); mapa.add(E8);
        E8.addActionListener((ActionEvent e) -> {lugarSelecionado(E8,"E8");});
        JButton F1 = new JButton("F1"); mapa.add(F1);
        F1.addActionListener((ActionEvent e) -> {lugarSelecionado(F1,"F1");});
        JButton F2 = new JButton("F2"); mapa.add(F2);
        F2.addActionListener((ActionEvent e) -> {lugarSelecionado(F2,"F2");});
        JButton F3 = new JButton("F3"); mapa.add(F3);
        F3.addActionListener((ActionEvent e) -> {lugarSelecionado(F3,"F3");});
        JButton F4 = new JButton("F4"); mapa.add(F4);
        F4.addActionListener((ActionEvent e) -> {lugarSelecionado(F4,"F4");});
        JButton F5 = new JButton("F5"); mapa.add(F5);
        F5.addActionListener((ActionEvent e) -> {lugarSelecionado(F5,"F5");});
        JButton F6 = new JButton("F6"); mapa.add(F6);
        F6.addActionListener((ActionEvent e) -> {lugarSelecionado(F6,"F6");});
        JButton F7 = new JButton("F7"); mapa.add(F7);
        F7.addActionListener((ActionEvent e) -> {lugarSelecionado(F7,"F7");});
        JButton F8 = new JButton("F8"); mapa.add(F8); 
        F8.addActionListener((ActionEvent e) -> {lugarSelecionado(F8,"F8");});   
	        
		configurar(mapa);
        
	    //Legenda das cores dos assentos
        JLabel legenda = new JLabel("Verde - Selecionado, Roxo -Livre, Vermelho - Reservado");
        legenda.setForeground(new Color(230, 230, 250));
        legenda.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        assentos.add(legenda, BorderLayout.SOUTH);
		
        //Painel para a seleção dos tipos de ingresso
        JPanel tipoPanel = new JPanel();
		tipoPanel.setBackground(fundo);
		assentos.add(tipoPanel, BorderLayout.NORTH);
		
		//Ingressos tipo inteira
		JLabel inteira = new JLabel("Inteiras");
		inteira.setForeground(new Color(230, 230, 250));
		inteira.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		tipoPanel.add(inteira);
		
		inteiraSel = new JComboBox<String>();
		inteiraSel.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		inteiraSel.setModel(new DefaultComboBoxModel<String>(new String[] {"0","1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(inteiraSel);
		inteiraSel.addActionListener(this::atualizar);
		
		//Ingressos tipo meia 
		JLabel meia = new JLabel("Meias");
		meia.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		meia.setForeground(new Color(230, 230, 250));
		tipoPanel.add(meia);
		
		meiaSel = new JComboBox<String>();
		meiaSel.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		meiaSel.setModel(new DefaultComboBoxModel<String>(new String[] {"0","1", "2", "3", "4", "5", "6", "7"}));
		tipoPanel.add(meiaSel);
		meiaSel.addActionListener(this::atualizar);

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
		dadosFinaisPanel.setLayout(new GridLayout(7, 1, 0, 0));
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
		
		JLabel horarioFinal = new JLabel();
		horarioFinal.setText("Horario: "+ hora);
		horarioFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		horarioFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(horarioFinal);
		
		//Quantidade de ingressos selecionados
		qtdIngressos = new JLabel("Quantidade de ingressos: " + total);
		qtdIngressos.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		qtdIngressos.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(qtdIngressos);
		
		//Preço total 
		precoFinal = new JLabel("Preço total: ");
		precoFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		precoFinal.setForeground(new Color(230, 230, 250));
		dadosFinaisPanel.add(precoFinal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 26, 115));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		dadosFinaisPanel.add(panel);
		
		txtDigiteSeuNome = new JTextField();
		panel.add(txtDigiteSeuNome);
		txtDigiteSeuNome.setForeground(new Color(0, 0, 160));
		txtDigiteSeuNome.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtDigiteSeuNome.setText("Digite seu nome");
		txtDigiteSeuNome.setColumns(10);
		
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
            button.setForeground(new Color(0, 0, 128));
            button.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	        button.setBorderPainted(false);
	        try {
				if (reservas.reservarAssento(button.getText(),sessao)== false) {
					button.setBackground(vermelho);
				} else {
					button.setBackground(roxo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	public void voltar(ActionEvent event) {
		dispose();
		new Entrada(lista);
	}
	public void atualizar(ActionEvent e) {
		total = meiaSel.getSelectedIndex()+ inteiraSel.getSelectedIndex();
		preco = meiaSel.getSelectedIndex()*10+ inteiraSel.getSelectedIndex()*20;
		qtdIngressos.setText("Quantidade de ingressos: " + total);
		precoFinal.setText("Preço total: "+ preco);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void lugarSelecionado(JButton lugar, String posicao){
		if (lugar.getBackground() == verde) {
			lugar.setBackground(roxo);
			lugares.remove(posicao);
			sel--;
		} 
		if (total==sel) {
			JOptionPane.showMessageDialog(null,"Selecione primeiro o tipo de ingresso e depois o lugar.");
			return;
		} else if (lugar.getBackground() == vermelho) {
			JOptionPane.showMessageDialog(null,"Esse lugar já está reservado.");
			return;
		}
		try {
			if (reservas.reservarAssento(posicao, sessao) == true) {
				if (lugar.getBackground() == roxo) {
					lugar.setBackground(verde);
					lugares.add(posicao);
					sel++;
				}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void finalizarCompra() {
		if (sel != total) {
			JOptionPane.showMessageDialog(null,"Termine de selecionar os assentos ou reduza o número de ingressos.");
			return;
		}
		if (txtDigiteSeuNome.getText()==null) {
			JOptionPane.showMessageDialog(null,"Digite seu nome antes de encerrar.");
			return;
		}
		try {
			double precoFinal = reservas.comprarAssentos(meiaSel.getSelectedIndex(), inteiraSel.getSelectedIndex(), txtDigiteSeuNome.getText(), lugares, sessao);
			preco = (int)precoFinal;
			dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}

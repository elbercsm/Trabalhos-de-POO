package janela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import principal.Cliente;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmCadastroDeJogos;
	private JMenuItem mntmCadastroDeCliente;
	private JMenuItem mntmTelaDeCompras;
	private CadastroJogo1 frameJogo;
	private JDesktopPane desktopPane;
	private CadastroCliente1 frameCliente;
	private TelaCompras3 frameCompra;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 734);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 50, 133, 634);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 11, 153, 58);
		panel.add(menuBar);
		GridLayout grid = new GridLayout(0, 1);
		menuBar.setLayout(grid);

		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setForeground(Color.BLACK);
		mnCadastros.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnCadastros);

		mntmCadastroDeJogos = new JMenuItem("Cadastro de Jogos");
		mntmCadastroDeJogos.setForeground(Color.BLACK);
		mntmCadastroDeJogos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnCadastros.add(mntmCadastroDeJogos);
		mntmCadastroDeJogos.addActionListener(this);

		mntmCadastroDeCliente = new JMenuItem("Cadastro de Cliente");
		mntmCadastroDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mntmCadastroDeCliente.setForeground(Color.BLACK);
		mnCadastros.add(mntmCadastroDeCliente);
		mntmCadastroDeCliente.addActionListener(this);

		JMenu mnMenuDeCompras = new JMenu("Menu de Compras");
		mnMenuDeCompras.setForeground(Color.BLACK);
		mnMenuDeCompras.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnMenuDeCompras);

		mntmTelaDeCompras = new JMenuItem("Tela de Compras");
		mntmTelaDeCompras.setForeground(Color.BLACK);
		mntmTelaDeCompras.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnMenuDeCompras.add(mntmTelaDeCompras);
		mntmTelaDeCompras.addActionListener(this);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(146, 50, 768, 634);
		contentPane.add(desktopPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(146, 11, 768, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setForeground(new Color(255, 255, 255));
		lblMenuPrincipal.setBackground(new Color(255, 255, 255));
		lblMenuPrincipal.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setBounds(0, 0, 769, 34);
		panel_1.add(lblMenuPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mntmCadastroDeJogos)
		{
			try {
				frameJogo = new CadastroJogo1();
				frameJogo.preencheComboJogo(frameJogo.getJogos());
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frameJogo.setVisible(true);
			desktopPane.add("Cadastro de Jogo",frameJogo);
			frameJogo.setPosicao();

		}

		if(e.getSource()==mntmCadastroDeCliente)
		{
			try {
				frameCliente = new CadastroCliente1();
				frameCliente.preencheComboCliente(frameCliente.getClientes());
			} catch (ParseException | IOException e1) {
				e1.printStackTrace();
			}
			frameCliente.setVisible(true);
			desktopPane.add("Cadastro de Cliente",frameCliente);
			frameCliente.setPosicao();

		}

		if(e.getSource() == mntmTelaDeCompras)
		{
			try {
				frameCompra = new TelaCompras3();
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//frameCompra.preencheComboCliente(frameCompra.getClientes());
			frameCompra.preencheComboJogo(frameCompra.getJogos());
			frameCompra.preencheComboCliente(frameCompra.getClientes());
			frameCompra.setVisible(true);
			desktopPane.add("Tela de Compras", frameCompra);
			frameCompra.setPosicao();
		}
	}

}



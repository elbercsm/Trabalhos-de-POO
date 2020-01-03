package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField;
	private ImageIcon imgPipoca;
	private JLabel imagem;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroFuncionario() {
		
		setTitle("Cadastro de Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Inserindo imagem
		imgPipoca = new ImageIcon("img/icone3x4.png");
		
		JButton btnSalvar = new JButton("Novo");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(594, 424, 126, 49);
		contentPane.add(btnSalvar);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setBounds(594, 487, 126, 49);
		contentPane.add(btnSalvar_1);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionario");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 782, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 61, 764, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(583, 301, 127, 50);
		panel.add(btnNewButton);
		
		JLabel lblNomeDoFuncionario = new JLabel("Nome do Funcion\u00E1rio:");
		lblNomeDoFuncionario.setBounds(10, 34, 159, 14);
		panel.add(lblNomeDoFuncionario);
		
		textField = new JTextField();
		textField.setBounds(10, 59, 384, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 90, 68, 14);
		panel.add(lblEndereo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 115, 384, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(55, 146, 114, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 149, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(179, 146, 46, 14);
		panel.add(lblCidade);
		
		textField_5 = new JTextField();
		textField_5.setBounds(224, 146, 170, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNCelular = new JLabel("N\u00B0 Celular:");
		lblNCelular.setBounds(224, 188, 97, 14);
		panel.add(lblNCelular);
		
		textField_6 = new JTextField();
		textField_6.setBounds(82, 185, 114, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNTelefone = new JLabel("N\u00B0 Telefone:");
		lblNTelefone.setBounds(10, 188, 103, 14);
		panel.add(lblNTelefone);
		
		textField_7 = new JTextField();
		textField_7.setBounds(293, 185, 103, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(10, 237, 46, 14);
		panel.add(lblEmail);
		
		textField_8 = new JTextField();
		textField_8.setBounds(55, 234, 339, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTipoDeFucionario = new JLabel("Tipo de Fucion\u00E1rio:");
		lblTipoDeFucionario.setBounds(10, 266, 119, 14);
		panel.add(lblTipoDeFucionario);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBackground(Color.LIGHT_GRAY);
		rdbtnGerente.setBounds(10, 287, 87, 23);
		panel.add(rdbtnGerente);
		
		JRadioButton rdbtnCaixa = new JRadioButton("Caixa");
		rdbtnCaixa.setBackground(Color.LIGHT_GRAY);
		rdbtnCaixa.setBounds(99, 287, 68, 23);
		panel.add(rdbtnCaixa);
		
		JRadioButton rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setBackground(Color.LIGHT_GRAY);
		rdbtnAtendente.setBounds(169, 287, 86, 23);
		panel.add(rdbtnAtendente);
		
		JRadioButton rdbtnOutros = new JRadioButton("Outros");
		rdbtnOutros.setBackground(Color.LIGHT_GRAY);
		rdbtnOutros.setBounds(257, 287, 77, 23);
		panel.add(rdbtnOutros);
		
		JLabel lblCadastroDeDados = new JLabel("Cadastro de dados de acesso do funcion\u00E1rio : ");
		lblCadastroDeDados.setBounds(10, 338, 409, 14);
		panel.add(lblCadastroDeDados);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(10, 363, 56, 14);
		panel.add(lblUsuario);
		
		textField_9 = new JTextField();
		textField_9.setBounds(10, 388, 137, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 416, 46, 14);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 441, 137, 20);
		panel.add(passwordField);
		
		JLabel lblCodAcesso = new JLabel("C\u00F3d. Acesso: ");
		lblCodAcesso.setBounds(208, 363, 86, 14);
		panel.add(lblCodAcesso);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 382, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0:");
		lblN.setBounds(208, 416, 46, 14);
		panel.add(lblN);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 413, 46, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(208, 444, 22, 14);
		panel.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 441, 56, 20);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MG"}));
		
		JLabel lblFotox = new JLabel("Foto 3x4:");
		lblFotox.setBounds(538, 34, 68, 14);
		panel.add(lblFotox);
		
		JButton btnSalvarImagem = new JButton("Salvar Imagem");
		btnSalvarImagem.setBounds(583, 262, 127, 23);
		panel.add(btnSalvarImagem);
		imagem = new JLabel(imgPipoca);
		imagem.setBounds(548, 64, 188, 187);
		panel.add(imagem);
		imagem.setVisible(true);
	}

	
}

package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class CadastroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtTel;
	private JLabel lblCodigo;
	private JLabel lblTelefone;
	private JLabel lblNone;
	private JTextField txtNomeEmpresa;
	private JLabel lblRazaoSocial;
	private JTextField txtRazaoSocial;
	private JLabel lblEndereo;
	private JTextField txtEndereco;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblUf;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox comboBox;
	private JLabel lblCnpj;
	private JLabel lblInscriaoMunicipal;
	private JLabel lblInscriaoEstadual;
	private JTextField txtCnpj;
	private JTextField txtIncMunicipal;
	private JTextField txtIncEstadual;
	private JButton btnSalvar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Panel panel;
	private JButton btnEditar;
	private JLabel lblCadastro;
	private JLabel lblEndereo_1;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEmpresa frame = new CadastroEmpresa();
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
	public CadastroEmpresa() {
		setTitle("Cadastro de Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel = new Panel();
		panel.setFont(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 56, 764, 495);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(54, 176, 46, 14);
		panel.add(lblCodigo);
		
		txtCod = new JTextField();
		txtCod.setBounds(157, 173, 167, 20);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(54, 222, 63, 14);
		panel.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 219, 28, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(195, 219, 86, 20);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 250, 28, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(195, 250, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFax = new JLabel("FAX:");
		lblFax.setBounds(54, 256, 46, 14);
		panel.add(lblFax);
		
		lblNone = new JLabel("Nome (Fantasia)\r\n:");
		lblNone.setBounds(54, 56, 148, 14);
		panel.add(lblNone);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setBounds(157, 53, 348, 20);
		panel.add(txtNomeEmpresa);
		txtNomeEmpresa.setColumns(10);
		
		lblRazaoSocial = new JLabel("Razao Social:");
		lblRazaoSocial.setBounds(54, 91, 98, 14);
		panel.add(lblRazaoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(157, 81, 348, 20);
		panel.add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(54, 133, 46, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(157, 130, 348, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(222, 394, 46, 14);
		panel.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(305, 467, 68, 20);
		panel.add(txtCep);
		txtCep.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(49, 366, 68, 14);
		panel.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(103, 363, 307, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(49, 400, 46, 14);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(250, 391, 86, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(49, 433, 46, 14);
		panel.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(103, 430, 86, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		lblUf = new JLabel("UF:");
		lblUf.setBounds(199, 433, 46, 14);
		panel.add(lblUf);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MG", "SP", "RJ", "BA", "RS"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(222, 430, 53, 20);
		panel.add(comboBox);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(285, 433, 46, 14);
		panel.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(138, 467, 74, 20);
		panel.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		lblInscriaoMunicipal = new JLabel("Ins. Municipal:");
		lblInscriaoMunicipal.setBounds(52, 470, 122, 14);
		panel.add(lblInscriaoMunicipal);
		
		txtIncMunicipal = new JTextField();
		txtIncMunicipal.setBounds(103, 394, 109, 20);
		panel.add(txtIncMunicipal);
		txtIncMunicipal.setColumns(10);
		
		lblInscriaoEstadual = new JLabel("Ins. Estadual:");
		lblInscriaoEstadual.setBounds(222, 470, 121, 14);
		panel.add(lblInscriaoEstadual);
		
		txtIncEstadual = new JTextField();
		txtIncEstadual.setBounds(322, 430, 88, 20);
		panel.add(txtIncEstadual);
		txtIncEstadual.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(599, 204, 114, 50);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(599, 348, 114, 50);
		panel.add(btnCancelar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(599, 275, 112, 50);
		panel.add(btnEditar);
		
		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Serif", Font.BOLD, 14));
		lblCadastro.setBounds(23, 20, 74, 14);
		panel.add(lblCadastro);
		
		lblEndereo_1 = new JLabel("Endere\u00E7o");
		lblEndereo_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblEndereo_1.setBounds(23, 333, 74, 14);
		panel.add(lblEndereo_1);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(597, 140, 114, 50);
		panel.add(btnConsultar);
		
		JLabel lblCadastroDaEmpresa = new JLabel("Cadastro da Empresa");
		lblCadastroDaEmpresa.setFont(new Font("Serif", Font.BOLD, 20));
		lblCadastroDaEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDaEmpresa.setToolTipText("");
		lblCadastroDaEmpresa.setBounds(0, 0, 784, 50);
		contentPane.add(lblCadastroDaEmpresa);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				JOptionPane.showMessageDialog(null , "Codigo : "+txtCod.getText());
				JOptionPane.showMessageDialog(null , "Codigo Externo : "+txtCodExt.getText());
				JOptionPane.showMessageDialog(null , "Telefone : "+txtTel.getText());
				JOptionPane.showMessageDialog(null , "Nome Fantasia : "+txtNomeEmpresa.getText());
				*/
				
			}
		});
		
	}
}

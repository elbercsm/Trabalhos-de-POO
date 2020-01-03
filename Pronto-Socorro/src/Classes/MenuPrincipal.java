package Classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipal extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtNomePaciente, txtEmailPaciente, txtEnderecoPaciente, txtBairroPaciente, txtNumeroCasaPaciente,
			txtNomePacienteBusca, txtEmailPacienteBusca, txtNomeMedico, txtEmailMedico, txtNomeMedicoBusca,
			txtEmailMedicoBusca;
	private JFormattedTextField txtCpfPaciente, txtCepPaciente, txtNascimentoPaciente, txtTelefonePaciente,
			txtCpfPacienteBusca, txtCrm, txtCrmBusca;
	private JTable tablePaciente, tableMedico, tableAtendimento;
	private ButtonGroup grupoGenero;
	private JRadioButton rdbtnFeminino, rdbtnMasculino, rdbtnOutro;
	private JButton btnBuscarPaciente, btnAdicionarPaciente, btnEditarPaciente, btnRemoverPaciente, btnSalvarPaciente,
			btnBuscarMedico, btnBuscarImagemMedico, btnAdiconarNaLsitaEspera, btnSalvarMedico, btnRemoverMedico,
			btnEditarMedico, btnAdicionarMedico, btnBuscarPacienteMedicoPraAtendimento, btnAtender;
	private DadosPaciente listaDePacientes;
	private DadosMedico listaDeMedicos;
	private DadosAtendimento listaDeAtendimento;
	private JComboBox comboBoxSelectPaciente, comboBoxSelectMedico, comboBox_GeneroMedico, comboBox_Especialidade,
			comboBox_SelectMedicoAtendimento, comboBox_SelectPacienteAtendimento;
	private JSlider slider_Dor;
	private DefaultTableModel modeloPaciente, modeloMedico, modeloAtendimento;
	private int pacienteId, medicoId;
	private DefaultComboBoxModel<String> modeloComboPaciente;
	private DefaultComboBoxModel<String> modeloComboMedico;
	private DefaultComboBoxModel<String> modeloComboGeneroMedico;
	private DefaultComboBoxModel<String> modeloComboEspecialidadeMedico;
	private String caminho = "", caminhoTelaInicial = "";
	private JLabel lblFotoMedico, fotoTelaInicial;

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

	// -------------------------- METODOS ----------------------//

	private String retornaGeneroPaciente() {
		if (rdbtnMasculino.isSelected()) {
			return "Masculino";
		}
		if (rdbtnFeminino.isSelected()) {
			return "Feminino";
		}
		if (rdbtnOutro.isSelected()) {
			return "Outro";
		} else {
			return "Outro";
		}

	}

	private int retornaEspecialidade(String espec) {
		int id = -1;
		if (espec.equals("Cardiologia"))
			id = 0;
		if (espec.equals("Cirurgia Geral"))
			id = 1;
		if (espec.equals("Dermatologia"))
			id = 2;
		if (espec.equals("Obstetricia"))
			id = 3;
		if (espec.equals("Pediatria"))
			id = 4;
		if (espec.equals("Radioterapia"))
			id = 5;

		return id;
	}

	private int retornaGenero(String gen) {
		int id = -1;
		if (gen.equals("Masculino"))
			id = 0;
		if (gen.equals("Feminino"))
			id = 1;
		if (gen.equals("Outro"))
			id = 2;

		return id;
	}

	private void limparTabela(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void limparTextFieldPaciente() {
		txtNomePaciente.setText("");
		txtBairroPaciente.setText("");
		txtCepPaciente.setText("");
		txtCpfPaciente.setText("");
		txtEmailPaciente.setText("");
		txtEnderecoPaciente.setText("");
		txtNascimentoPaciente.setText("");
		txtNumeroCasaPaciente.setText("");
		txtTelefonePaciente.setText("");
		grupoGenero.clearSelection();
		slider_Dor.setValue(0);
		repaint();
	}

	public void limparTextFieldMedico() {
		txtNomeMedico.setText("");
		txtEmailMedico.setText("");
		txtCrm.setText("");
		ImageIcon imgMedico = new ImageIcon("img/img.gif");
		lblFotoMedico.setIcon(imgMedico);
		comboBoxSelectMedico.setSelectedIndex(-1);
		comboBox_GeneroMedico.setSelectedIndex(-1);
		comboBox_Especialidade.setSelectedIndex(-1);

		repaint();
	}

	public void populaTabelaPaciente() {

		limparTabela(tablePaciente);

		for (int i = 0; i < listaDePacientes.getListaPaciente().size(); i++) {

			modeloPaciente.addRow(new String[] { i + "", listaDePacientes.getPaciente(i).getNome(),
					listaDePacientes.getPaciente(i).getLvlDor() + "" });
		}

	}

	public void encheBoxPaciente() {
		modeloComboPaciente.removeAllElements();

		for (int i = 0; i < listaDePacientes.getListaPaciente().size(); i++) {
			comboBoxSelectPaciente.addItem("ID :   " + i + " | Nome:  " + listaDePacientes.getPaciente(i).getNome());
		}

	}

	public void populaTabelaMedico() {

		limparTabela(tableMedico);

		for (int i = 0; i < listaDeMedicos.getListaMedico().size(); i++) {

			modeloMedico.addRow(new String[] { i + "", listaDeMedicos.getMedico(i).getNomeMedico(),
					listaDeMedicos.getMedico(i).getEspecialidade() + "" });
		}

	}

	public void populaTabelaAtendimento() {

		limparTabela(tableAtendimento);

		for (int i = 0; i < listaDeAtendimento.getDadosAtend().size(); i++) {

			modeloAtendimento
					.addRow(new String[] { i + "", listaDeAtendimento.getDadosAtend().get(i).getPaciente().getNome(),
							listaDeAtendimento.getDadosAtend().get(i).getMedico().getNomeMedico(),
							listaDeAtendimento.getDadosAtend().get(i).getMedico().getEspecialidade(),
							listaDeAtendimento.getDadosAtend().get(i).getPaciente().getLvlDor() + "" });
		}

	}

	public void encheBoxMedico() {
		modeloComboMedico.removeAllElements();

		for (int i = 0; i < listaDeMedicos.getListaMedico().size(); i++) {
			comboBoxSelectMedico.addItem("ID :   " + i + " | Nome:  " + listaDeMedicos.getMedico(i).getNomeMedico());
			// comboBox_SelectMedicoAtendimento.addItem("ID : " + i + " | Nome: " +
			// listaDeMedicos.getMedico(i).getNomeMedico());
		}

	}

	/*
	 * public void encheBoxGeneroMedico() {
	 * modeloComboGeneroMedico.removeAllElements();
	 * 
	 * for (int i = 0; i < listaDeMedicos.getListaMedico().size(); i++) {
	 * comboBox_GeneroMedico.addItem("Genero: " +
	 * listaDeMedicos.getMedico(i).getGenero()); }
	 * 
	 * }
	 * 
	 * public void encheBoxEspecialidadeMedico() {
	 * modeloComboEspecialidadeMedico.removeAllElements();
	 * 
	 * for (int i = 0; i < listaDeMedicos.getListaMedico().size(); i++) {
	 * comboBox_Especialidade.addItem("Especialidade: " +
	 * listaDeMedicos.getMedico(i).getEspecialidade()); }
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public MenuPrincipal() throws ParseException {

		listaDeAtendimento = new DadosAtendimento();
		listaDeMedicos = new DadosMedico();
		listaDePacientes = new DadosPaciente();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_tela_inicial = new JPanel();
		tabbedPane.addTab("HOME", null, panel_tela_inicial, null);
		panel_tela_inicial.setLayout(null);

		// --------------------- PACIENTE --------------------//

		ImageIcon imgTelaInicial = new ImageIcon("img/hospitaLicon");
		fotoTelaInicial = new JLabel(imgTelaInicial);
		fotoTelaInicial.setBounds(0, 0, 991, 681);
		panel_tela_inicial.add(fotoTelaInicial);

		JPanel panel_paciente = new JPanel();
		panel_paciente.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("PACIENTE", null, panel_paciente, null);
		panel_paciente.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(224, 255, 255));
		panel_4.setBounds(12, 13, 967, 41);
		panel_paciente.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO PACIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 967, 41);
		panel_4.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(224, 255, 255));
		panel_5.setBounds(12, 78, 967, 51);
		panel_paciente.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("BUSCAR PACINETE :");
		lblNewLabel_1.setBounds(12, 13, 122, 32);
		panel_5.add(lblNewLabel_1);

		modeloComboPaciente = new DefaultComboBoxModel();
		comboBoxSelectPaciente = new JComboBox();
		comboBoxSelectPaciente.setModel(modeloComboPaciente);
		comboBoxSelectPaciente.setBounds(146, 13, 695, 32);
		panel_5.add(comboBoxSelectPaciente);

		btnBuscarPaciente = new JButton("BUSCAR");
		btnBuscarPaciente.setBounds(853, 13, 97, 32);
		panel_5.add(btnBuscarPaciente);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(224, 255, 255));
		panel_6.setBounds(12, 149, 967, 217);
		panel_paciente.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(12, 13, 56, 16);
		panel_6.add(lblNome);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(530, 48, 43, 16);
		panel_6.add(lblEmail);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(530, 13, 43, 16);
		panel_6.add(lblCpf);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(12, 83, 56, 16);
		panel_6.add(lblCep);

		JLabel lblEndereo = new JLabel("Endere\u00E7o :");
		lblEndereo.setBounds(178, 83, 68, 16);
		panel_6.add(lblEndereo);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(767, 83, 56, 16);
		panel_6.add(lblBairro);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setText("Roberto Silva");
		txtNomePaciente.setBounds(77, 10, 441, 22);
		panel_6.add(txtNomePaciente);
		txtNomePaciente.setColumns(10);

		MaskFormatter form1 = new MaskFormatter(" ### . ### . ### - ## ");
		txtCpfPaciente = new JFormattedTextField(form1);
		txtCpfPaciente.setText("123.590.754-78");
		txtCpfPaciente.setBounds(585, 13, 116, 22);
		panel_6.add(txtCpfPaciente);
		txtCpfPaciente.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data Nascimento :");
		lblDataNascimento.setBounds(713, 16, 110, 16);
		panel_6.add(lblDataNascimento);

		MaskFormatter form2 = new MaskFormatter(" #### / ## / ## ");
		txtNascimentoPaciente = new JFormattedTextField(form2);
		txtNascimentoPaciente.setText("1990/ 10 /15");
		txtNascimentoPaciente.setBounds(839, 13, 116, 22);
		panel_6.add(txtNascimentoPaciente);
		txtNascimentoPaciente.setColumns(10);

		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(12, 42, 56, 22);
		panel_6.add(lblGenero);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setBackground(new Color(224, 255, 255));
		rdbtnMasculino.setBounds(62, 44, 90, 25);
		panel_6.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBackground(new Color(224, 255, 255));
		rdbtnFeminino.setBounds(156, 44, 90, 25);
		panel_6.add(rdbtnFeminino);

		rdbtnOutro = new JRadioButton("Outro");
		rdbtnOutro.setBackground(new Color(224, 255, 255));
		rdbtnOutro.setBounds(243, 44, 90, 25);
		panel_6.add(rdbtnOutro);

		grupoGenero = new ButtonGroup();
		grupoGenero.add(rdbtnMasculino);
		grupoGenero.add(rdbtnFeminino);
		grupoGenero.add(rdbtnOutro);

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(341, 48, 68, 16);
		panel_6.add(lblTelefone);

		MaskFormatter form4 = new MaskFormatter("( ## ) #### - ####");
		txtTelefonePaciente = new JFormattedTextField(form4);
		txtTelefonePaciente.setText("( 34 ) 3268 - 1548");
		txtTelefonePaciente.setBounds(407, 45, 111, 22);
		panel_6.add(txtTelefonePaciente);
		txtTelefonePaciente.setColumns(10);

		txtEmailPaciente = new JTextField();
		txtEmailPaciente.setText("roberto@gmail.com");
		txtEmailPaciente.setBounds(585, 45, 370, 22);
		panel_6.add(txtEmailPaciente);
		txtEmailPaciente.setColumns(10);

		MaskFormatter form3 = new MaskFormatter(" ##### - ###");
		txtCepPaciente = new JFormattedTextField(form3);
		txtCepPaciente.setText("38307-465");
		txtCepPaciente.setBounds(77, 80, 89, 22);
		panel_6.add(txtCepPaciente);
		txtCepPaciente.setColumns(10);

		txtEnderecoPaciente = new JTextField();
		txtEnderecoPaciente.setText("Rua das rosas");
		txtEnderecoPaciente.setBounds(252, 80, 332, 22);
		panel_6.add(txtEnderecoPaciente);
		txtEnderecoPaciente.setColumns(10);

		txtBairroPaciente = new JTextField();
		txtBairroPaciente.setText("Platina");
		txtBairroPaciente.setBounds(839, 80, 116, 22);
		panel_6.add(txtBairroPaciente);
		txtBairroPaciente.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("N\u00B0 :");
		lblNewLabel_2.setBounds(595, 83, 32, 16);
		panel_6.add(lblNewLabel_2);

		txtNumeroCasaPaciente = new JTextField();
		txtNumeroCasaPaciente.setText("265");
		txtNumeroCasaPaciente.setBounds(622, 80, 116, 22);
		panel_6.add(txtNumeroCasaPaciente);
		txtNumeroCasaPaciente.setColumns(10);

		JLabel lblListaDePacientes = new JLabel("LISTA DE PACIENTES CADASTRADOS :");
		lblListaDePacientes.setBounds(12, 192, 321, 16);
		panel_6.add(lblListaDePacientes);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-26, 177, 1023, 2);
		panel_6.add(separator_2);

		slider_Dor = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		slider_Dor.setBackground(new Color(224, 255, 255));
		slider_Dor.setBounds(111, 112, 248, 52);
		slider_Dor.setMajorTickSpacing(5); // Distância separadores maiores
		slider_Dor.setMinorTickSpacing(1); // Distância separadores menores
		slider_Dor.setPaintTicks(true); // Exibir separadores (tracinhos)
		slider_Dor.setPaintLabels(true); // Exibir valores (números)

		panel_6.add(slider_Dor);

		JLabel lblNewLabel_17 = new JLabel("NIVEL DE DOR");
		lblNewLabel_17.setBounds(12, 133, 100, 16);
		panel_6.add(lblNewLabel_17);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 379, 967, 212);
		panel_paciente.add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 967, 212);
		panel_7.add(scrollPane);

		modeloPaciente = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Nível Dor" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		modeloAtendimento = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Paciente", "Medico", "Especialidade Medico", "Dor" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		tablePaciente = new JTable();
		tablePaciente.setModel(modeloPaciente);
		scrollPane.setViewportView(tablePaciente);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(224, 255, 255));
		panel_8.setBounds(12, 604, 967, 64);
		panel_paciente.add(panel_8);
		panel_8.setLayout(null);

		btnAdicionarPaciente = new JButton("ADICIONAR");
		btnAdicionarPaciente.setBounds(51, 13, 147, 38);
		panel_8.add(btnAdicionarPaciente);

		btnEditarPaciente = new JButton("EDITAR");
		btnEditarPaciente.setBounds(274, 13, 147, 38);
		panel_8.add(btnEditarPaciente);

		btnRemoverPaciente = new JButton("REMOVER");
		btnRemoverPaciente.setBounds(554, 13, 147, 38);
		panel_8.add(btnRemoverPaciente);

		btnSalvarPaciente = new JButton("SALVAR");
		btnSalvarPaciente.setBounds(768, 13, 147, 38);
		panel_8.add(btnSalvarPaciente);

		JSeparator separator = new JSeparator();
		separator.setBounds(-12, 67, 1003, 2);
		panel_paciente.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 134, 991, 2);
		panel_paciente.add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-12, 599, 1003, 2);
		panel_paciente.add(separator_3);

		// --------------------- MEDICO --------------------//

		JPanel panel_medico = new JPanel();
		panel_medico.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("MEDICO", null, panel_medico, null);
		panel_medico.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(12, 13, 967, 56);
		panel_medico.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("CADASTRO MEDICO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 967, 56);
		panel.add(lblNewLabel_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 143, 1003, 16);
		panel_medico.add(separator_5);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 250, 205));
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(12, 161, 967, 216);
		panel_medico.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Nome :");
		lblNewLabel_6.setBounds(12, 13, 56, 16);
		panel_1.add(lblNewLabel_6);

		JLabel lblCrm = new JLabel("CRM :");
		lblCrm.setBounds(12, 71, 56, 16);
		panel_1.add(lblCrm);

		JLabel lblGenero_1 = new JLabel("Genero :");
		lblGenero_1.setBounds(12, 100, 56, 16);
		panel_1.add(lblGenero_1);

		txtNomeMedico = new JTextField();
		txtNomeMedico.setText("DR.Mario Junior");
		txtNomeMedico.setBounds(106, 10, 599, 22);
		panel_1.add(txtNomeMedico);
		txtNomeMedico.setColumns(10);

		MaskFormatter form5 = new MaskFormatter("########-#/BR");
		txtCrm = new JFormattedTextField(form5);
		txtCrm.setText("12458637-7/BR");
		txtCrm.setBounds(106, 68, 149, 22);
		panel_1.add(txtCrm);
		txtCrm.setColumns(10);

		modeloComboGeneroMedico = new DefaultComboBoxModel(
				new String[] {"Masculino", "Feminino", "Outro" });
		comboBox_GeneroMedico = new JComboBox();
		comboBox_GeneroMedico.setModel(modeloComboGeneroMedico);
		comboBox_GeneroMedico.setBounds(106, 100, 261, 22);
		panel_1.add(comboBox_GeneroMedico);

		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setBounds(12, 42, 40, 16);
		panel_1.add(lblEmail_1);

		txtEmailMedico = new JTextField();
		txtEmailMedico.setText("dr.mj@gmail.com");
		txtEmailMedico.setBounds(106, 36, 599, 22);
		panel_1.add(txtEmailMedico);
		txtEmailMedico.setColumns(10);

		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setBounds(12, 142, 93, 16);
		panel_1.add(lblEspecialidade);

		modeloComboEspecialidadeMedico = new DefaultComboBoxModel(new String[] { "Cardiologia",
				"Cirurgia Geral", "Dermatologia", "Obstetricia", "Pediatria", "Radioterapia" });
		comboBox_Especialidade = new JComboBox();
		comboBox_Especialidade.setModel(modeloComboEspecialidadeMedico);
		comboBox_Especialidade.setBounds(106, 142, 261, 22);
		panel_1.add(comboBox_Especialidade);

		JLabel lblNewLabel_16 = new JLabel("BUSCAR IMAGEM DO MEDICO :");
		lblNewLabel_16.setBounds(529, 71, 187, 16);
		panel_1.add(lblNewLabel_16);

		btnBuscarImagemMedico = new JButton("BUSCAR");
		btnBuscarImagemMedico.setBounds(602, 96, 97, 25);
		panel_1.add(btnBuscarImagemMedico);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 207, 716, 2);
		panel_1.add(separator_6);

		ImageIcon imgMedico = new ImageIcon("img/img.gif");
		lblFotoMedico = new JLabel(imgMedico);
		lblFotoMedico.setBounds(752, 13, 178, 190);
		panel_1.add(lblFotoMedico);

		/*
		 * txtCrm = new JTextField(); txtCrm.setText("123.254.695-86");
		 * txtCrm.setBounds(106, 68, 158, 22); panel_1.add(txtCrm);
		 * txtCrm.setColumns(10);
		 */

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBounds(12, 90, 967, 49);
		panel_medico.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("BUSCAR MEDICO :");
		lblNewLabel_5.setBounds(0, 13, 119, 27);
		panel_2.add(lblNewLabel_5);

		modeloComboMedico = new DefaultComboBoxModel();
		comboBoxSelectMedico = new JComboBox();
		comboBoxSelectMedico.setModel(modeloComboMedico);
		comboBoxSelectMedico.setBounds(113, 13, 727, 27);
		panel_2.add(comboBoxSelectMedico);

		btnBuscarMedico = new JButton("BUSCAR");
		btnBuscarMedico.setBounds(858, 14, 97, 25);
		panel_2.add(btnBuscarMedico);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 82, 991, 16);
		panel_medico.add(separator_4);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 408, 967, 173);
		panel_medico.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 967, 173);
		panel_3.add(scrollPane_1);

		modeloMedico = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Especialidade" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		tableMedico = new JTable();
		tableMedico.setModel(modeloMedico);
		scrollPane_1.setViewportView(tableMedico);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 250, 205));
		panel_9.setBounds(12, 601, 967, 67);
		panel_medico.add(panel_9);
		panel_9.setLayout(null);

		btnAdicionarMedico = new JButton("ADICIONAR");
		btnAdicionarMedico.setBounds(56, 13, 168, 41);
		panel_9.add(btnAdicionarMedico);

		btnEditarMedico = new JButton("EDITAR");
		btnEditarMedico.setBounds(270, 13, 168, 41);
		panel_9.add(btnEditarMedico);

		btnRemoverMedico = new JButton("REMOVER");
		btnRemoverMedico.setBounds(530, 13, 168, 41);
		panel_9.add(btnRemoverMedico);

		btnSalvarMedico = new JButton("SALVAR");
		btnSalvarMedico.setBounds(751, 13, 168, 41);
		panel_9.add(btnSalvarMedico);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 592, 991, 2);
		panel_medico.add(separator_7);

		JLabel lblListaDeMedicos = new JLabel("LISTA DE MEDICOS CADASTRADOS :");
		lblListaDeMedicos.setBounds(12, 379, 318, 16);
		panel_medico.add(lblListaDeMedicos);

		JPanel panel_atendimento = new JPanel();
		panel_atendimento.setBackground(new Color(173, 255, 47));
		tabbedPane.addTab("ATENDIMENTO", null, panel_atendimento, null);
		panel_atendimento.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(173, 255, 47));
		panel_10.setForeground(new Color(0, 0, 0));
		panel_10.setBounds(12, 13, 967, 66);
		panel_atendimento.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("ATENDIMENTO");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setBackground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 967, 66);
		panel_10.add(lblNewLabel_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(0, 92, 991, 2);
		panel_atendimento.add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(12, 190, 451, 2);
		panel_atendimento.add(separator_9);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(519, 190, 460, 2);
		panel_atendimento.add(separator_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(173, 255, 47));
		panel_11.setBounds(12, 201, 967, 247);
		panel_atendimento.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("DADOS PACIENTE :");
		lblNewLabel_10.setBounds(0, 0, 126, 16);
		panel_11.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("DADOS MEDICO :");
		lblNewLabel_11.setBounds(509, 0, 126, 16);
		panel_11.add(lblNewLabel_11);

		JLabel lblNome_1 = new JLabel("Nome :");
		lblNome_1.setBounds(0, 32, 56, 16);
		panel_11.add(lblNome_1);

		txtNomePacienteBusca = new JTextField();
		txtNomePacienteBusca.setEditable(false);
		txtNomePacienteBusca.setBounds(0, 55, 451, 22);
		panel_11.add(txtNomePacienteBusca);
		txtNomePacienteBusca.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Email :");
		lblNewLabel_12.setBounds(0, 86, 56, 16);
		panel_11.add(lblNewLabel_12);

		txtEmailPacienteBusca = new JTextField();
		txtEmailPacienteBusca.setEditable(false);
		txtEmailPacienteBusca.setBounds(0, 115, 451, 22);
		panel_11.add(txtEmailPacienteBusca);
		txtEmailPacienteBusca.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("CPF :");
		lblNewLabel_13.setBounds(0, 146, 56, 16);
		panel_11.add(lblNewLabel_13);

		MaskFormatter form6 = new MaskFormatter(" ### . ### . ### - ## ");
		txtCpfPacienteBusca = new JFormattedTextField(form6);
		txtCpfPacienteBusca.setEditable(false);
		txtCpfPacienteBusca.setBounds(0, 178, 147, 22);
		panel_11.add(txtCpfPacienteBusca);
		txtCpfPacienteBusca.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Nome :");
		lblNewLabel_14.setBounds(509, 32, 76, 16);
		panel_11.add(lblNewLabel_14);

		txtNomeMedicoBusca = new JTextField();
		txtNomeMedicoBusca.setEditable(false);
		txtNomeMedicoBusca.setBounds(507, 55, 460, 22);
		panel_11.add(txtNomeMedicoBusca);
		txtNomeMedicoBusca.setColumns(10);

		JLabel lblEmail_2 = new JLabel("Email : ");
		lblEmail_2.setBounds(509, 86, 56, 16);
		panel_11.add(lblEmail_2);

		txtEmailMedicoBusca = new JTextField();
		txtEmailMedicoBusca.setEditable(false);
		txtEmailMedicoBusca.setBounds(509, 115, 460, 22);
		panel_11.add(txtEmailMedicoBusca);
		txtEmailMedicoBusca.setColumns(10);

		JLabel lblCrm_1 = new JLabel("CRM :");
		lblCrm_1.setBounds(509, 146, 56, 16);
		panel_11.add(lblCrm_1);

		MaskFormatter form7 = new MaskFormatter(" ######## - # / BR");
		txtCrmBusca = new JFormattedTextField(form7);
		txtCrmBusca.setEditable(false);
		txtCrmBusca.setBounds(509, 178, 147, 22);
		panel_11.add(txtCrmBusca);
		txtCrmBusca.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("ADICIONAR A LISTA DE ESPERA");
		lblNewLabel_15.setBounds(0, 213, 204, 23);
		panel_11.add(lblNewLabel_15);

		btnAdiconarNaLsitaEspera = new JButton("ADICIONAR");
		btnAdiconarNaLsitaEspera.setBounds(204, 212, 97, 25);
		panel_11.add(btnAdiconarNaLsitaEspera);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(173, 255, 47));
		panel_12.setBounds(12, 92, 967, 88);
		panel_atendimento.add(panel_12);
		panel_12.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Selecione Medico :");
		lblNewLabel_8.setBounds(0, 13, 116, 16);
		panel_12.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Selecione Paciente :");
		lblNewLabel_9.setBounds(0, 59, 126, 16);
		panel_12.add(lblNewLabel_9);

		comboBox_SelectMedicoAtendimento = new JComboBox(modeloComboMedico);
		comboBox_SelectMedicoAtendimento.setBounds(133, 10, 599, 22);
		panel_12.add(comboBox_SelectMedicoAtendimento);

		comboBox_SelectPacienteAtendimento = new JComboBox(modeloComboPaciente);
		comboBox_SelectPacienteAtendimento.setBounds(132, 56, 600, 22);
		panel_12.add(comboBox_SelectPacienteAtendimento);

		btnBuscarPacienteMedicoPraAtendimento = new JButton("BUSCAR");
		btnBuscarPacienteMedicoPraAtendimento.setBounds(764, 13, 97, 62);
		panel_12.add(btnBuscarPacienteMedicoPraAtendimento);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(0, 461, 991, 2);
		panel_atendimento.add(separator_11);

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(12, 476, 967, 162);
		panel_atendimento.add(panel_13);
		panel_13.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 967, 162);
		panel_13.add(scrollPane_2);

		tableAtendimento = new JTable(modeloAtendimento);
		scrollPane_2.setViewportView(tableAtendimento);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(173, 255, 47));
		panel_14.setBounds(12, 640, 967, 41);
		panel_atendimento.add(panel_14);

		panel_14.setLayout(null);

		btnAtender = new JButton("ATENDER");
		btnAtender.setBounds(840, 0, 115, 41);
		panel_14.add(btnAtender);

		// ----------------------------- Ações -------------------------------//

		btnAdicionarPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Paciente paciente = new Paciente(txtNomePaciente.getText(), txtEmailPaciente.getText(),
						txtEnderecoPaciente.getText(), txtBairroPaciente.getText(), txtCepPaciente.getText(),
						txtNumeroCasaPaciente.getText(), txtTelefonePaciente.getText(), txtCpfPaciente.getText(),
						txtNascimentoPaciente.getText(), retornaGeneroPaciente(), slider_Dor.getValue());

				listaDePacientes.addPaciente(paciente);
				encheBoxPaciente();
				populaTabelaPaciente();
				limparTextFieldPaciente();
				System.out.println(paciente);
			}
		});

		btnBuscarImagemMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser;
				chooser = new JFileChooser();
				File file = null;
				// showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será
				// para salvar.
				int retorno = chooser.showSaveDialog(null);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					caminho = chooser.getSelectedFile().getAbsolutePath();
					ImageIcon imgMedico = new ImageIcon(caminho);
					lblFotoMedico.setIcon(imgMedico);

				}

			}
		});

		btnAdicionarMedico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Medico medico = new Medico(txtNomeMedico.getText(), txtEmailMedico.getText(),
						comboBox_GeneroMedico.getSelectedItem() + "", txtCrm.getText(),
						comboBox_Especialidade.getSelectedItem() + "", caminho);

				listaDeMedicos.addMedico(medico);
				encheBoxMedico();
				populaTabelaMedico();
				limparTextFieldMedico();
				System.out.println(medico);
			}
		});

		btnBuscarPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDePacientes.getListaPaciente().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha pacientes cadastrados", "Impossível Buscar",
							JOptionPane.ERROR_MESSAGE);
				} else {

					pacienteId = modeloComboPaciente.getIndexOf(comboBoxSelectPaciente.getSelectedItem());
					System.out.println(pacienteId);

					// Strings
					txtNomePaciente.setText(listaDePacientes.getPaciente(pacienteId).getNome());
					txtEmailPaciente.setText(listaDePacientes.getPaciente(pacienteId).getEmail());
					txtEnderecoPaciente.setText(listaDePacientes.getPaciente(pacienteId).getEndereco());
					txtBairroPaciente.setText(listaDePacientes.getPaciente(pacienteId).getBairro());
					txtCepPaciente.setText(listaDePacientes.getPaciente(pacienteId).getCep());
					txtNumeroCasaPaciente.setText(listaDePacientes.getPaciente(pacienteId).getNumeroCasa());
					txtTelefonePaciente.setText(listaDePacientes.getPaciente(pacienteId).getTelefone());
					txtCpfPaciente.setText(listaDePacientes.getPaciente(pacienteId).getCpf());
					txtNascimentoPaciente.setText(listaDePacientes.getPaciente(pacienteId).getDataNascimento());
					
					// Radio Button
					if (listaDePacientes.getPaciente(pacienteId).getGenero().equals("Masculino")) {
						rdbtnOutro.setSelected(false);
						rdbtnFeminino.setSelected(false);
						rdbtnMasculino.setSelected(true);
					} else if (listaDePacientes.getPaciente(pacienteId).getGenero().equals("Feminino")) {
						rdbtnOutro.setSelected(false);
						rdbtnMasculino.setSelected(false);
						rdbtnFeminino.setSelected(true);

					} else {

						rdbtnMasculino.setSelected(false);
						rdbtnFeminino.setSelected(false);
						rdbtnOutro.setSelected(true);

					}
					// Slider
					slider_Dor.setValue(listaDePacientes.getPaciente(pacienteId).getLvlDor());
					
					

				}
			}
		});

		btnBuscarMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaDeMedicos.getListaMedico().isEmpty()) {
					JOptionPane.showMessageDialog(btnBuscarMedico, "Não ha médicos cadastrados", "Impossível buscar",
							JOptionPane.WARNING_MESSAGE);
				} else {

					medicoId = modeloComboMedico.getIndexOf(comboBoxSelectMedico.getSelectedItem());
					System.out.println(medicoId);

					txtNomeMedico.setText(listaDeMedicos.getMedico(medicoId).getNomeMedico());
					txtEmailMedico.setText(listaDeMedicos.getMedico(medicoId).getEmailMedico());
					txtCrm.setText(listaDeMedicos.getMedico(medicoId).getCrm());
					
					comboBox_Especialidade.setSelectedIndex(
							retornaEspecialidade(listaDeMedicos.getMedico(medicoId).getEspecialidade()));
					comboBox_GeneroMedico
							.setSelectedIndex(retornaGenero(listaDeMedicos.getMedico(medicoId).getGenero()));
					
					ImageIcon imgMedico = new ImageIcon(listaDeMedicos.getMedico(medicoId).getImagem());
					lblFotoMedico.setIcon(imgMedico);
				}
			}
		});

		btnEditarPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (listaDePacientes.getListaPaciente().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha pacientes cadastrados para ser editados",
							"Impossível Editar", JOptionPane.ERROR_MESSAGE);
				} else {
					Paciente paciente = new Paciente(txtNomePaciente.getText(), txtEmailPaciente.getText(),
							txtEnderecoPaciente.getText(), txtBairroPaciente.getText(), txtCepPaciente.getText(),
							txtNumeroCasaPaciente.getText(), txtTelefonePaciente.getText(), txtCpfPaciente.getText(),
							txtNascimentoPaciente.getText(), retornaGeneroPaciente(), slider_Dor.getValue());

					listaDePacientes.editPaciente(paciente, pacienteId);
					encheBoxPaciente();
					populaTabelaPaciente();
					limparTextFieldPaciente();
					System.out.println(listaDePacientes.getListaPaciente().toString());
				}
			}
		});

		btnEditarMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (listaDeMedicos.getListaMedico().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha medicos cadastrados para ser editados",
							"Impossível Editar", JOptionPane.ERROR_MESSAGE);
				} else {

					Medico medico = new Medico(txtNomeMedico.getText(), txtEmailMedico.getText(),
							comboBox_GeneroMedico.getSelectedItem() + "", txtCrm.getText(),
							comboBox_Especialidade.getSelectedItem() + "", caminho);

					listaDeMedicos.editMedico(medico, medicoId);
					encheBoxMedico();
					populaTabelaMedico();
					limparTextFieldMedico();
					System.out.println(medico);
				}
			}
		});

		btnRemoverPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDePacientes.getListaPaciente().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha pacientes cadastrados", "Impossível remover",
							JOptionPane.ERROR_MESSAGE);
				} else {

					listaDePacientes.dadosPaciente.remove(tablePaciente.getSelectedRow());
					encheBoxPaciente();
					populaTabelaPaciente();
					limparTextFieldPaciente();

				}
			}
		});

		btnRemoverMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDeMedicos.getListaMedico().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha medicos cadastrados", "Impossível remover",
							JOptionPane.ERROR_MESSAGE);
				} else {

					listaDeMedicos.dadosMedico.remove(tableMedico.getSelectedRow());
					encheBoxMedico();
					populaTabelaMedico();
					limparTextFieldMedico();

				}
			}
		});

		btnBuscarPacienteMedicoPraAtendimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((comboBox_SelectMedicoAtendimento.getSelectedIndex() < 0)
						|| (comboBox_SelectPacienteAtendimento.getSelectedIndex() < 0)) {
					JOptionPane.showMessageDialog(null, "Não ha medicos e pacientes cadastrados", "Impossível Buscar",
							JOptionPane.ERROR_MESSAGE);
				} else {
					medicoId = modeloComboMedico.getIndexOf(comboBoxSelectMedico.getSelectedItem());
					pacienteId = modeloComboPaciente.getIndexOf(comboBoxSelectPaciente.getSelectedItem());

					txtNomeMedicoBusca.setText(listaDeMedicos.getMedico(medicoId).getNomeMedico());
					txtEmailMedicoBusca.setText(listaDeMedicos.getMedico(medicoId).getEmailMedico());
					txtCrmBusca.setText(listaDeMedicos.getMedico(medicoId).getCrm());
					txtNomePacienteBusca.setText(listaDePacientes.getPaciente(pacienteId).getNome());
					txtEmailPacienteBusca.setText(listaDePacientes.getPaciente(pacienteId).getEmail());
					txtCpfPacienteBusca.setText(listaDePacientes.getPaciente(pacienteId).getCpf());

				}
			}
		});

		btnAdiconarNaLsitaEspera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ((comboBox_SelectMedicoAtendimento.getSelectedIndex() < 0)
						|| (comboBox_SelectPacienteAtendimento.getSelectedIndex() < 0)) {
					JOptionPane.showMessageDialog(null, "Não ha medicos e pacientes selecionados",
							"Impossível ir pra lista de espera", JOptionPane.ERROR_MESSAGE);
				} else {
					int idMedico, idPaciente;
					idMedico = comboBox_SelectMedicoAtendimento.getSelectedIndex();
					idPaciente = comboBox_SelectPacienteAtendimento.getSelectedIndex();
					Atendimento atende = new Atendimento(listaDeMedicos.getMedico(idMedico),
							listaDePacientes.getPaciente(idPaciente));
					listaDeAtendimento.dadosAtend.add(atende);
					populaTabelaAtendimento();
				}
			}
		});

		btnAtender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDeAtendimento.getDadosAtend().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não ha ninguem na lista de espera", "Impossível atender",
							JOptionPane.ERROR_MESSAGE);
				} else {
					listaDeAtendimento.getDadosAtend().remove(tableAtendimento.getSelectedRow());
					populaTabelaAtendimento();
				}
			}
		});

	}
}

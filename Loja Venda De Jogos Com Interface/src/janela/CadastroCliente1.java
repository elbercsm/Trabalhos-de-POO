package janela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import principal.Cliente;

public class CadastroCliente1 extends JInternalFrame implements MouseListener{

	private JPanel janela, panelBotoes;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JTextField txtNumeroCasa;
	private JTextField txtBairro;
	private JPanel panelTitulo, panelFuncoes, panel;
	private JLabel lblCadastroClientes, lblNome, lblEmail, lblTelefone, lblIdade, lblEndereco, lblBairro, lblNCasa, lblCep;
	private JButton btnAdicionar, btnEditar ;
	private JButton btnRemover;
	private JFormattedTextField txtCep, txtTelefone;
	private JLabel lblClientesCadastrados;
	private JScrollPane barraRolagem;
	private JTable tblCliente;
	private ClienteTableModel tableModel;
	private LeituraCliente leitura;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblBuscarCliente;
	private JComboBox comboBox_Cliente;
	private JButton button_BuscaCliente;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente1 frame = new CadastroCliente1();
					frame.preencheComboCliente(frame.getClientes());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroCliente1()  throws ParseException, IOException {
		setIconifiable(true);
		setTitle("Cadastro de Cliente");

		//_________________________Criando a janela___________________________
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 537);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setLayout(null);
		setContentPane(janela);

		//_______________________Criando os paineis___________________________
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(105, 105, 105));
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTitulo.setBounds(10, 11, 563, 45);
		janela.add(panelTitulo);
		panelTitulo.setLayout(null);

		panelFuncoes = new JPanel();
		panelFuncoes.setBackground(new Color(95, 158, 160));
		panelFuncoes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelFuncoes.setBounds(10, 107, 563, 191);
		janela.add(panelFuncoes);
		panelFuncoes.setLayout(null);

		panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(105, 105, 105));
		panelBotoes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelBotoes.setBounds(10, 444, 563, 45);
		janela.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 300, 563, 141);
		janela.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(10, 56, 563, 45);
		janela.add(panel_2);
		panel_2.setLayout(null);


		//________________________________Fim______________________________________

		//____________________________Criando os labels_____________________________
		lblCadastroClientes = new JLabel("Cadastro Clientes");
		lblCadastroClientes.setForeground(new Color(255, 255, 255));
		lblCadastroClientes.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblCadastroClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroClientes.setBounds(0, 11, 550, 23);
		panelTitulo.add(lblCadastroClientes);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 26, 46, 14);
		panelFuncoes.add(lblNome);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 59, 46, 14);
		panelFuncoes.add(lblEmail);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 88, 57, 14);
		panelFuncoes.add(lblTelefone);

		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(373, 59, 46, 14);
		panelFuncoes.add(lblIdade);

		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(245, 88, 61, 14);
		panelFuncoes.add(lblEndereco);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 115, 46, 14);
		panelFuncoes.add(lblBairro);

		lblNCasa = new JLabel("N\u00BA Casa:");
		lblNCasa.setBounds(245, 115, 61, 14);
		panelFuncoes.add(lblNCasa);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(397, 115, 33, 14);
		panelFuncoes.add(lblCep);

		lblClientesCadastrados = new JLabel("Clientes Cadastrados");
		lblClientesCadastrados.setBounds(10, 164, 122, 20);
		panelFuncoes.add(lblClientesCadastrados);
		
		lblBuscarCliente = new JLabel("Buscar Cliente:");
		lblBuscarCliente.setBounds(10, 15, 92, 14);
		panel_2.add(lblBuscarCliente);

		//_______________________________Fim_______________________________________

		//________________________Criando os textFields____________________________
		txtNome = new JTextField();
		txtNome.setBounds(77, 23, 431, 20);
		panelFuncoes.add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(77, 54, 284, 20);
		panelFuncoes.add(txtEmail);
		txtEmail.setColumns(10);

		MaskFormatter mas = new MaskFormatter("(##) ####-####");
		txtTelefone = new JFormattedTextField(mas);
		txtTelefone.setBounds(77, 85, 156, 20);
		panelFuncoes.add(txtTelefone);

		txtIdade = new JTextField();
		txtIdade.setBounds(431, 56, 77, 20);
		panelFuncoes.add(txtIdade);
		txtIdade.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(320, 85, 188, 20);
		panelFuncoes.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtNumeroCasa = new JTextField();
		txtNumeroCasa.setBounds(320, 112, 67, 20);
		panelFuncoes.add(txtNumeroCasa);
		txtNumeroCasa.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(77, 112, 158, 20);
		panelFuncoes.add(txtBairro);

		MaskFormatter masK = new MaskFormatter("#####-###");
		txtCep = new JFormattedTextField(masK);
		txtCep.setBounds(431, 112, 77, 20);
		panelFuncoes.add(txtCep);
		//_________________________________Fim_______________________________________

		//__________________________Criando os botões________________________________
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(82, 11, 89, 23);
		panelBotoes.add(btnAdicionar);
		btnAdicionar.addMouseListener(this);

		btnEditar = new JButton("Alterar");
		btnEditar.setBounds(181, 11, 89, 23);
		panelBotoes.add(btnEditar);
		btnEditar.addMouseListener(this);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(280, 11, 89, 23);
		btnRemover.addMouseListener(this);
		panelBotoes.add(btnRemover);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(379, 11, 89, 23);
		panelBotoes.add(btnSair);
		btnSair.addMouseListener(this);

		button_BuscaCliente = new JButton("Buscar");
		button_BuscaCliente.setBounds(476, 11, 77, 23);
		button_BuscaCliente.addMouseListener(this);
		panel_2.add(button_BuscaCliente);
		
		//__________________Criando um ScrollPane e um comboBox___________________________________
		JScrollPane scrolPane = new JScrollPane(getTblCliente());
		scrolPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		scrolPane.setLocation(0, 0);
		scrolPane.setSize(563, 141);
		panel_1.add(scrolPane);
		
		comboBox_Cliente = new JComboBox();
		comboBox_Cliente.setBounds(112, 12, 354, 20);
		panel_2.add(comboBox_Cliente);

		//____________________________________Fim________________________________________
	}


	//_________________________Métodos da tabela_________________________________________
	private JTable getTblCliente() throws IOException {

		if (tblCliente == null) {

			tblCliente = new JTable();
			System.out.println("Entrou no getTblCliente()");
			tblCliente.setModel(getTableModel());
		}

		return tblCliente;
	}

	private ClienteTableModel getTableModel() throws IOException {

		if (tableModel == null) {

			System.out.println("Entrou no getTableModel");
			tableModel = new ClienteTableModel(criaClientes());
		}
		return tableModel;
	}

	//___________________ cria uma lista com Clientes_________________________________________
	private List<Cliente> criaClientes() throws IOException {

		List<Cliente> clientes = getClientes();

		return clientes;

	}
	//________________________________Fim dos métodos da Tabela________________________________


	//________________________________________________________________________________________________________________________



	//_______________________________Método para adicionar um só cliente______________________________
	private void addCliente()
	{
		//Criando um novo cliente
		Cliente cliente = new Cliente();

		//Adicionando os seus dados na lista
		cliente.setBairro(txtBairro.getText());
		cliente.setCep(txtCep.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setIdade(txtIdade.getText());
		cliente.setNome(txtNome.getText());
		cliente.setNumeroCasa(txtNumeroCasa.getText());
		cliente.setTelefone(txtTelefone.getText());

		tableModel.addCliente(cliente);
		EscritaCliente.escrever(cliente);

		JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
	}

	//_________________________Adiciona mais de um cliente____________________________________________
	private void addClientes(List<Cliente> clientes, String nome)
	{	
		int i=0;
		EscritaCliente.deletarArquivo();

		for(Cliente c : clientes)
		{
			if(c.getNome().equals(nome))
			{

			}
			else 
			{
				EscritaCliente.escrever(c);
			}
		}
		Cliente cliente = new Cliente();
		//Adicionando os seus dados na lista
		cliente.setBairro(txtBairro.getText());
		cliente.setCep(txtCep.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setIdade(txtIdade.getText());
		cliente.setNome(txtNome.getText());
		cliente.setNumeroCasa(txtNumeroCasa.getText());
		cliente.setTelefone(txtTelefone.getText());
		

		tableModel.addCliente(cliente);
		tableModel.removeCliente(i);
		EscritaCliente.escrever(cliente);
		System.out.println(i++);
	}


	//_____________________Remove da lista, ou seja, do meu arquivo de txt____________________________
	private void removeClientesTxt(List<Cliente> clientes, String nome)
	{
		int i=0;
		EscritaCliente.deletarArquivo();

		for(Cliente c : clientes)
		{
			if(c.getNome().equals(nome))
			{

			}
			else 
			{
				EscritaCliente.escrever(c);
				if(tblCliente.getSelectedRow() != -1)
				{
					tableModel.removeCliente(tblCliente.getSelectedRow());
				}
			}
		}
	}

	//__________________Quando o cliente é selecionado no combobox_____________________________________
	public void selecionaCliente(List<Cliente> clientes)
	{	
		//Ele precisa saber qual é o cliente, e depois buscar os seus respectivos dados
		//e colocar os datos no JTexfield
		for(Cliente c : clientes)
		{
			if(c.getNome().equals(comboBox_Cliente.getSelectedItem()))
			{
				txtNome.setText(c.getNome());
				txtIdade.setText(c.getIdade());
				txtBairro.setText(c.getBairro());
				txtCep.setText(c.getCep());
				txtEmail.setText(c.getEmail());
				txtEndereco.setText(c.getEndereco());
				txtTelefone.setText(c.getTelefone());
				txtNumeroCasa.setText(c.getNumeroCasa());
			}		
		}
	}

	//________________________Pega o cliente que foi selecionado no combobox___________________________
	public Cliente pegaCliente(List<Cliente> clientes)
	{
		Cliente cliente = new Cliente();

		for(Cliente c : clientes)
		{
			if(c.getNome().equals(comboBox_Cliente.getSelectedItem()))
			{
				cliente.setNome(c.getNome());
				cliente.setBairro(c.getBairro());
				cliente.setCep(c.getCep());
				cliente.setEmail(c.getEmail());
				cliente.setIdade(c.getIdade());
				cliente.setNumeroCasa(c.getNumeroCasa());
				cliente.setTelefone(c.getTelefone());
				cliente.setEndereco(c.getEndereco());

				System.out.println("Nome: " +c.getNome());
			}
		}
		return cliente;
	}

	//________________________________Preenchendo o comboBox___________________________________________
	public void preencheComboCliente (List<Cliente> clientes)
	{
		comboBox_Cliente.removeAllItems();
		comboBox_Cliente.addItem("Selecione");

		//Criando o iterador para percorrer a lista de cliente
		for(Cliente c : clientes)
		{
			comboBox_Cliente.addItem(c.getNome());	
		}
	}
	//______________________________Fim do preenchimento do combobox___________________________________



	//__________________________Lê Cliente e preenche TableModel_______________________________________
	public List<Cliente> getClientes()
	{
		//System.out.println("Entrou no getClientes (Leitura)");
		List<Cliente> clientes = new ArrayList<Cliente>();

		String[] valores;
		FileReader fileReader = null;
		String linha;

		try {
			fileReader = new FileReader("Arquivos/clientes.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);

		try {
			while((linha = reader.readLine()) != null){

				Cliente cliente = new Cliente();
				valores = linha.split(";");

				cliente.setNome(valores[0]);
				cliente.setIdade(valores[1]);
				cliente.setEmail(valores[2]);
				cliente.setBairro(valores[3]);
				cliente.setEndereco(valores[4]);
				cliente.setCep(valores[5]);
				cliente.setNumeroCasa(valores[6]);
				cliente.setTelefone(valores[7]);

				clientes.add(cliente);
			}

			fileReader.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	//_____________________________________Fim do lê cliente___________________________________________

	//___________________________Remove o cliente da lista_____________________________________
	public List<Cliente> removeCliente(List<Cliente> clientes , Cliente cliente)
	{
		clientes.remove(cliente);
		JOptionPane.showMessageDialog(null, "txt Alterado com Sucesso");
		return clientes;
	}


	//__________________Limpa os campos de textField________________________________________
	public void limparTextField()
	{
		txtBairro.setText("");
		txtCep.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
		txtIdade.setText("");
		txtNome.setText("");
		txtNumeroCasa.setText("");
		txtTelefone.setText("");
		repaint();
	}
	
	//___________________________Para colocar a janela no centro da tela_________________________
	public void setPosicao()
	{
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width-this.getSize().width) /2, (d.height - this.getSize().height)/2);
	}


	//_____________________________________Métodos dos Botões________________________________________
	@Override
	public void mouseClicked(MouseEvent e) {
		//Quando o botão adicionar for clicado
		if(e.getSource() == btnAdicionar)
		{	
			addCliente();
			try {
				getTblCliente();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			comboBox_Cliente.removeAll(); //Atualizar o combobox
			preencheComboCliente(getClientes());
		}


		//______________________Botão remove da lista e do combobox_____________________________________________
		if(e.getSource() == btnRemover)
		{
			removeClientesTxt(removeCliente(getClientes(), pegaCliente(getClientes())),txtNome.getText());
			comboBox_Cliente.removeAll();
			preencheComboCliente(getClientes());
			limparTextField();
		}

		//_____________________Botão para editar o cliente____________________
		if(e.getSource() == btnEditar)
		{
			addClientes(removeCliente(getClientes(), pegaCliente(getClientes())),txtNome.getText());
			limparTextField();
		}


		//_____________Botão para buscar cliente para editá-lo____________________
		if(e.getSource() == button_BuscaCliente)
		{
			selecionaCliente(getClientes());
		}
		
		if(e.getSource() == btnSair)
		{
			dispose();
		}


	}

//_________________________________________________________________________________________________________________________________
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

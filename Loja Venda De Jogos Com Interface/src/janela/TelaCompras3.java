package janela;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import principal.Cliente;
import principal.Jogo;


public class TelaCompras3 extends JInternalFrame implements MouseListener {

	private JPanel janela;
	private JLabel lblImagem;
	private JButton btnAdd;
	private JPanel panelBotoes,  panel;
	private JPanel panelTitulo;
	private JPanel panelFuncoes;
	private JLabel lblFotoJogo;
	private JLabel lblCadastroJogo;
	private JButton btnBuscar, btnComprar;
	private JLabel lblJogosCadastrados;
	private ArrayList<Jogo> jogos = new ArrayList();
	private JTable tblJogo;
	private JComboBox comboBoxJogo;
	private JLabel lblBuscarJogo;
	private TelaComprasTableModel tableModel;
	private String caminho = "";
	private JScrollPane scrolPane;
	private JButton btnSair;
	private JComboBox comboJogo;
	private JComboBox comboBoxCliente;
	private JTextField txtNomeJogo;
	private JTextField txtPreco;
	private JTextField txtQtd;
	private JTextField txtNomeCliente;
	private JTextField txtTelefone;
	private JTextField txtCep;
	private float total;
	private JComboBox comboBox_Cliente;
	private JTable tblCliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompras3 frame = new TelaCompras3();
					frame.preencheComboJogo(frame.getJogos());
					frame.preencheComboCliente(frame.getClientes());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaCompras3() throws ParseException, IOException {

		setTitle("Tela de Compras");
		setIconifiable(true);


		//___________Criando Janela______________________
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 597);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setLayout(null);
		setContentPane(janela);

		//_________________Criando os paineis_________________
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(128, 128, 128));
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTitulo.setBounds(10, 11, 667, 37);
		janela.add(panelTitulo);
		panelTitulo.setLayout(null);


		panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(105, 105, 105));
		panelBotoes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelBotoes.setBounds(10, 498, 667, 47);
		janela.add(panelBotoes);
		panelBotoes.setLayout(null);

		panelFuncoes = new JPanel();
		panelFuncoes.setBackground(new Color(95, 158, 160));
		panelFuncoes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelFuncoes.setBounds(10, 49, 667, 447);
		janela.add(panelFuncoes);
		panelFuncoes.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 238, 647, 197);
		panelFuncoes.add(panel);
		panel.setLayout(null);
		//______________________fim_________________________________________

		//_________________Criando os botões da tela_________________
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(232, 11, 89, 23);
		panelBotoes.add(btnComprar);
		btnComprar.addMouseListener(this);

		btnSair = new JButton("Sair");
		btnSair.setBounds(355, 11, 89, 23);
		panelBotoes.add(btnSair);
		btnSair.addMouseListener(this);


		btnAdd = new JButton("Add");
		btnAdd.setBounds(381, 200, 73, 23);
		panelFuncoes.add(btnAdd);
		btnAdd.addMouseListener(this);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(330, 43, 93, 28);
		panelFuncoes.add(btnBuscar);
		btnBuscar.addMouseListener(this);

		//_______________________Fim_____________________________________

		//_________________Criando os labels_________________

		lblCadastroJogo = new JLabel("Compras");
		lblCadastroJogo.setForeground(new Color(255, 255, 255));
		lblCadastroJogo.setBackground(new Color(255, 255, 255));
		lblCadastroJogo.setBounds(10, 0, 657, 37);
		panelTitulo.add(lblCadastroJogo);
		lblCadastroJogo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCadastroJogo.setHorizontalAlignment(SwingConstants.CENTER);

		lblImagem = new JLabel("Imagem:");
		lblImagem.setBounds(534, 23, 123, 17);
		panelFuncoes.add(lblImagem);


		ImageIcon imgJogo = new ImageIcon("img/img.gif");
		lblFotoJogo = new JLabel(imgJogo);
		lblFotoJogo.setBounds(534, 51, 123, 142);
		panelFuncoes.add(lblFotoJogo);
		lblFotoJogo.addMouseListener(this);

		lblJogosCadastrados = new JLabel("Jogos Cadastrados");
		lblJogosCadastrados.setBounds(10, 212, 115, 23);
		panelFuncoes.add(lblJogosCadastrados);

		lblBuscarJogo = new JLabel("Buscar Jogo:");
		lblBuscarJogo.setBounds(10, 11, 91, 14);
		panelFuncoes.add(lblBuscarJogo);

		comboBoxJogo = new JComboBox();
		comboBoxJogo.setBounds(10, 30, 305, 23);
		panelFuncoes.add(comboBoxJogo);

		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(10, 60, 305, 23);
		panelFuncoes.add(comboBoxCliente);

		scrolPane = new JScrollPane(getTblJogo());
		scrolPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		scrolPane.setLocation(0, 0);
		scrolPane.setSize(647, 198);
		panel.add(scrolPane);

		JLabel label = new JLabel("Dados do Cliente:");
		label.setBounds(10, 94, 110, 14);
		panelFuncoes.add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 109, 252, 11);
		panelFuncoes.add(separator);

		JLabel label_1 = new JLabel("Dados do Jogo:");
		label_1.setBounds(296, 94, 110, 14);
		panelFuncoes.add(label_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(296, 109, 219, 14);
		panelFuncoes.add(separator_1);

		txtNomeJogo = new JTextField();
		txtNomeJogo.setColumns(10);
		txtNomeJogo.setBounds(371, 119, 144, 20);
		panelFuncoes.add(txtNomeJogo);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(371, 144, 86, 20);
		panelFuncoes.add(txtPreco);

		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		txtQtd.setBounds(371, 169, 86, 20);
		panelFuncoes.add(txtQtd);

		JLabel label_2 = new JLabel("Quantidade:");
		label_2.setBounds(296, 172, 68, 14);
		panelFuncoes.add(label_2);

		JLabel label_3 = new JLabel("Pre\u00E7o (R$):");
		label_3.setBounds(296, 147, 68, 14);
		panelFuncoes.add(label_3);

		JLabel label_4 = new JLabel("Nome:");
		label_4.setBounds(296, 122, 46, 14);
		panelFuncoes.add(label_4);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(65, 125, 195, 20);
		panelFuncoes.add(txtNomeCliente);

		JLabel label_5 = new JLabel("Nome:");
		label_5.setBounds(10, 131, 37, 14);
		panelFuncoes.add(label_5);

		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 159, 55, 14);
		panelFuncoes.add(lblTelefone);

		MaskFormatter mas = new MaskFormatter("(##) ####-####");
		txtTelefone = new JFormattedTextField(mas);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(65, 156, 122, 20);
		panelFuncoes.add(txtTelefone);

		MaskFormatter masK = new MaskFormatter("#####-###");
		txtCep = new JFormattedTextField(masK);
		txtCep.setColumns(10);
		txtCep.setBounds(65, 181, 98, 20);
		panelFuncoes.add(txtCep);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 184, 48, 14);
		panelFuncoes.add(lblCep);

		//____________________________Fim___________________________________________________
	}

	//_________________________Métodos da tabela_________________________________________
	private JTable getTblJogo() throws IOException {

		if (tblJogo == null) {

			tblJogo = new JTable();
			System.out.println("Entrou no getTblCliente()");
			tblJogo.setModel(getTableModel());
		}

		return tblJogo;
	}
	
	private JTable getTblCliente() throws IOException {

		if (tblCliente == null) {

			tblCliente = new JTable();
			System.out.println("Entrou no getTblCliente()");
			tblCliente.setModel(getTableModel());
		}

		return tblCliente;
	}

	private TelaComprasTableModel getTableModel() throws IOException {

		if (tableModel == null) {

			System.out.println("Entrou no getTableModel");
			tableModel = new TelaComprasTableModel(criaCompra());
		}
		return tableModel;
	}

	//___________________ cria uma lista com Jogos_________________________________________
	private List<Compra> criaCompra() throws IOException {

		List<Compra> compras = iniciaTable();
		return compras;
	}

	//________________________________Fim dos Métodos do TabelModel_________________________

	//Inicia a table de compra com uma linha, está dando erro se não iniciar com alguma coisa
	public List<Compra> iniciaTable()
	{
		List<Compra> compras = new ArrayList<Compra>();

		Compra compra = new Compra();
		compra.setNomeCliente("Laressa");
		compra.setCepCliente("38304088");
		compra.setTelefoneCliente("3432690680");
		compra.setNomeJogo("Mario");
		compra.setPrecoJogo(22);
		compra.setQtdJogo(2);
		compras.add(compra);

		return compras;
	}

	//___________________________Método para adicionar_______________________________________
	public void adicionaCompra()
	{
		Compra compra = new Compra();
		//Adicionando todos os elementos do objeto jogo em uma lista
		compra.setNomeJogo(txtNomeJogo.getText());
		compra.setPrecoJogo(Float.parseFloat(txtPreco.getText()+""));
		compra.setQtdJogo(Integer.parseInt(txtQtd.getText()));
		compra.setCepCliente(txtCep.getText());
		compra.setNomeCliente(txtNomeCliente.getText());
		compra.setTelefoneCliente(txtTelefone.getText());
		compra.setImagem(caminho);

		tableModel.addCompra(compra);
		JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
	}


	//__________________Quando o jogo é selecionado no combobox_____________________________________
	public void selecionaJogo(List<Jogo> jogos)
	{	
		//Ele precisa saber qual é o jogo, e depois buscar os seus respectivos dados
		//e colocar os dados no JTexfield
		for(Jogo j : jogos)
		{
			if(j.getNomeJogo().equals(comboBoxJogo.getSelectedItem()))
			{
				txtNomeJogo.setText(j.getNomeJogo());
				System.out.println("Nome: "+j.getNomeJogo());
				txtPreco.setText(j.getPreco() + "");
				ImageIcon img = new ImageIcon(j.getImagem());
				lblFotoJogo.setIcon(img);
				repaint();

			}		
		}
	}

	//__________________Quando o Cliente é selecionado no combobox_____________________________________
	public void selecionaClientes(List<Cliente> clientes)
	{	
		//Ele precisa saber qual é o jogo, e depois buscar os seus respectivos dados
		//e colocar os dados no JTexfield
		for(Cliente c : clientes)
		{
			if(c.getNome().equals(comboBoxCliente.getSelectedItem()))
			{
				txtNomeCliente.setText(c.getNome());
				txtTelefone.setText(c.getTelefone());
				txtCep.setText(c.getCep());
				repaint();

			}		
		}
	}

	//________________________Pega o jogo que foi selecionado no combobox___________________________
	public Jogo pegaJogo(List<Jogo> jogos)
	{
		Jogo jogo = new Jogo();

		for(Jogo j : jogos)
		{
			if(j.getNomeJogo().equals(comboBoxJogo.getSelectedItem()))
			{
				jogo.setNomeJogo(j.getNomeJogo());
				jogo.setClassificacao(j.getClassificacao());
				jogo.setDataLancamento(j.getDataLancamento());
				jogo.setGenero(j.getGenero());
				jogo.setPlataforma(j.getPlataforma());
				jogo.setPreco(j.getPreco());

				System.out.println("Nome: " +j.getNomeJogo());
			}
		}
		return jogo;
	}
	
	//_____________________________Pega o cliente que foi selecionado__________________________________________
	public Cliente pegaCliente(List<Cliente> clientes)
	{
		Cliente cliente = new Cliente();

		for(Cliente c : clientes)
		{
			if(c.getNome().equals(comboBox_Cliente.getSelectedItem()))
			{
				cliente.setNome(c.getNome());
				cliente.setCep(c.getCep());
				cliente.setTelefone(c.getTelefone());
				
				System.out.println("Nome: " +c.getNome());
			}
		}
		return cliente;
	}


	//________________________________Preenchendo o comboBox do jogo___________________________________________
	public void preencheComboJogo (List<Jogo> jogos)
	{
		comboBoxJogo.removeAllItems();
		comboBoxJogo.addItem("Selecione");

		//Criando o iterador para percorrer a lista de cliente
		for(Jogo j : jogos)
		{
			comboBoxJogo.addItem(j.getNomeJogo());	
		}
	}

	//________________________________Preenchendo o comboBox do cliente___________________________________________
	public void preencheComboCliente (List<Cliente> clientes)
	{
		comboBoxCliente.removeAllItems();
		comboBoxCliente.addItem("Selecione");

		//Criando o iterador para percorrer a lista de cliente
		for(Cliente c : clientes)
		{
			comboBoxCliente.addItem(c.getNome());	
		}
	}


	//__________________________Lê jogo e preenche TableModel do jogo_______________________________________
	public List<Jogo> getJogos()
	{
		//System.out.println("Entrou no getClientes (Leitura)");
		List<Jogo> jogos = new ArrayList<Jogo>();
		String[] valores;
		FileReader fileReader = null;
		String linha;

		try {
			fileReader = new FileReader("Arquivos/jogos.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);

		try {
			while((linha = reader.readLine()) != null){

				Jogo jogo = new Jogo();
				valores = linha.split(";");

				jogo.setNomeJogo(valores[0]);
				jogo.setClassificacao(valores[1]);
				jogo.setDataLancamento(valores[2]);
				jogo.setGenero(valores[3]);
				jogo.setPlataforma(valores[4]);
				jogo.setPreco(Float.parseFloat(valores[5]));
				jogo.setImagem(valores[6]);

				jogos.add(jogo);
			}

			fileReader.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return jogos;
	}

	//__________________________Lê jogo e preenche TableModel do cliente_______________________________________
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

				//System.out.println("Entrou Leitura: nome: "+valores[0]);
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
		//System.out.println(linha);
		return clientes;
	}

	
	//__________________Limpa os campos de textField________________________________________
	public void limparTextField()
	{
		txtNomeJogo.setText("");
		txtPreco.setText("");
		txtQtd.setText("");
		comboBoxCliente.setSelectedItem("Selecione");
		comboBoxJogo.setSelectedItem("Selecione");
		ImageIcon imgJogo = new ImageIcon("img/img.gif");
		lblFotoJogo.setIcon(imgJogo);
		repaint();
	}

	//_______________________________Para colocar a Janela no centro__________________________
	public void setPosicao()
	{
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width-this.getSize().width) /2, (d.height - this.getSize().height)/2);
	}
	//__________________________________________Fim____________________________________________________________


	
	
	//___________________________________________Métodos dos Botões_________________________________________
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnComprar)
		{
			///adicionaJogo();
			comboBoxJogo.removeAll(); //Atualizar o combobox
			preencheComboJogo(getJogos());
			limparTextField();
		}

		else if(e.getSource() == btnBuscar)
		{
			selecionaJogo(getJogos());
			selecionaClientes(getClientes());
		}
		
		else if(e.getSource() == btnAdd)
		{
			total = total + Float.parseFloat(txtPreco.getText())*(Integer.parseInt(txtQtd.getText()));
			System.out.println("Qtd: "+txtQtd.getText());
			adicionaCompra();
		}

		if(e.getSource()==btnComprar)
		{
			JOptionPane.showMessageDialog(null, "Parabéns pela Compra, TOTAL:   R$"+ total+"");
		}

		if(e.getSource() == btnSair)
		{
			dispose();
		}
	}





	//___________________________________________________________________________________________________________________________________	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

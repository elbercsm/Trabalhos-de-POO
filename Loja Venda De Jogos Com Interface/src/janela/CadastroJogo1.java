package janela;

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

import principal.Jogo;

public class CadastroJogo1 extends JInternalFrame implements MouseListener {

	private JPanel janela;
	private JTextField txtNomeJogo;
	private JLabel lblNomeDoJogo, lblPlataforma, lblGnero, lblDataDeLan, lblClassificao, lblImagem;
	private JComboBox comboPlataforma, comboGenero, comboClassificacao;
	private JButton btnBuscarImagem;
	private JPanel panelBotoes,  panel;
	private JPanel panelTitulo;
	private JPanel panelFuncoes;
	private JLabel lblFotoJogo;
	private JLabel lblCadastroJogo;
	private JLabel lblPreco;
	private JTextField txtPreco;
	private JButton btnRemover, btnBuscar, btnAlterar, btnAdicionar;
	private JFormattedTextField txtDataLancamento ;
	private JLabel lblJogosCadastrados;
	private ArrayList<Jogo> jogos = new ArrayList();
	private JTable tblJogo;
	private JComboBox comboBoxJogo;
	private JLabel lblBuscarJogo;
	private JogoTableModel tableModel;
	private String caminho = "";
	private JScrollPane scrolPane;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroJogo1 frame = new CadastroJogo1();
					frame.preencheComboJogo(frame.getJogos());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroJogo1() throws ParseException, IOException {
		setTitle("Cadastro de Jogo");
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
		panelBotoes.setBounds(10, 510, 667, 50);
		janela.add(panelBotoes);
		panelBotoes.setLayout(null);

		panelFuncoes = new JPanel();
		panelFuncoes.setBackground(new Color(95, 158, 160));
		panelFuncoes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelFuncoes.setBounds(10, 49, 667, 459);
		janela.add(panelFuncoes);
		panelFuncoes.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 238, 647, 209);
		panelFuncoes.add(panel);
		panel.setLayout(null);
		//______________________fim_________________________________________

		//_________________Criando os botões da tela_________________
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(104, 11, 89, 23);
		panelBotoes.add(btnAdicionar);
		btnAdicionar.addMouseListener(this);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(213, 11, 89, 23);
		panelBotoes.add(btnAlterar);
		btnAlterar.addMouseListener(this);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(329, 11, 89, 23);
		panelBotoes.add(btnRemover);
		btnRemover.addMouseListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(438, 11, 89, 23);
		panelBotoes.add(btnSair);
		btnSair.addMouseListener(this);
	

		btnBuscarImagem = new JButton("Buscar Img");
		btnBuscarImagem.setBounds(487, 204, 123, 23);
		panelFuncoes.add(btnBuscarImagem);
		btnBuscarImagem.addMouseListener(this);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 30, 93, 28);
		panelFuncoes.add(btnBuscar);
		btnBuscar.addMouseListener(this);

		//_______________________Fim_____________________________________

		//_________________Criando os labels_________________

		lblCadastroJogo = new JLabel("Cadastro Jogo");
		lblCadastroJogo.setForeground(new Color(255, 255, 255));
		lblCadastroJogo.setBackground(new Color(255, 255, 255));
		lblCadastroJogo.setBounds(10, 0, 657, 37);
		panelTitulo.add(lblCadastroJogo);
		lblCadastroJogo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCadastroJogo.setHorizontalAlignment(SwingConstants.CENTER);

		lblImagem = new JLabel("Insira a imagem do jogo:");
		lblImagem.setBounds(477, 25, 167, 17);
		panelFuncoes.add(lblImagem);

		lblClassificao = new JLabel("Classifica\u00E7\u00E3o: ");
		lblClassificao.setBounds(236, 112, 83, 17);
		panelFuncoes.add(lblClassificao);

		lblDataDeLan = new JLabel("Data de Lan\u00E7.:");
		lblDataDeLan.setBounds(10, 138, 83, 17);
		panelFuncoes.add(lblDataDeLan);

		lblGnero = new JLabel("G\u00EAnero: ");
		lblGnero.setBounds(10, 113, 83, 14);
		panelFuncoes.add(lblGnero);

		lblPlataforma = new JLabel("Plataforma: ");
		lblPlataforma.setBounds(236, 138, 74, 17);
		panelFuncoes.add(lblPlataforma);

		lblNomeDoJogo = new JLabel("Nome do Jogo:");
		lblNomeDoJogo.setBounds(10, 85, 91, 15);
		panelFuncoes.add(lblNomeDoJogo);


		ImageIcon imgJogo = new ImageIcon("img/img.gif");
		lblFotoJogo = new JLabel(imgJogo);
		lblFotoJogo.setBounds(487, 51, 123, 142);
		panelFuncoes.add(lblFotoJogo);
		lblFotoJogo.addMouseListener(this);

		lblPreco = new JLabel("Pre\u00E7o (R$):");
		lblPreco.setBounds(10, 166, 74, 17);
		panelFuncoes.add(lblPreco);

		lblJogosCadastrados = new JLabel("Jogos Cadastrados");
		lblJogosCadastrados.setBounds(10, 212, 115, 23);
		panelFuncoes.add(lblJogosCadastrados);

		lblBuscarJogo = new JLabel("Buscar Jogo:");
		lblBuscarJogo.setBounds(10, 11, 91, 14);
		panelFuncoes.add(lblBuscarJogo);
		//_________________________Fim_____________________________________________

		//_________________Criando os comboboxs_________________
		comboClassificacao = new JComboBox();
		comboClassificacao.setBounds(320, 111, 93, 20);
		panelFuncoes.add(comboClassificacao);
		comboClassificacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Livre", "+3", "+5", "+12", "+18"}));

		comboGenero = new JComboBox();
		comboGenero.setBounds(103, 110, 123, 20);
		panelFuncoes.add(comboGenero);
		comboGenero.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "A\u00E7\u00E3o", "Esporte", "Luta", "Corrida", "Outro G\u00EAnero"}));

		comboPlataforma = new JComboBox();
		comboPlataforma.setBounds(320, 136, 93, 20);
		panelFuncoes.add(comboPlataforma);
		comboPlataforma.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Xbox", "PS4", "PC", "Nintendo"}));

		comboBoxJogo = new JComboBox();
		comboBoxJogo.setBounds(10, 30, 305, 28);
		panelFuncoes.add(comboBoxJogo);
		//________________________________Fim___________________________________________

		//_________________Criando os textFields_________________
		txtNomeJogo = new JTextField();
		txtNomeJogo.setBounds(103, 82, 312, 20);
		panelFuncoes.add(txtNomeJogo);
		txtNomeJogo.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setBounds(103, 163, 91, 20);
		panelFuncoes.add(txtPreco);
		txtPreco.setColumns(10);

		MaskFormatter mas = new MaskFormatter("##/##/####");
		txtDataLancamento = new JFormattedTextField(mas);
		txtDataLancamento.setBounds(103, 135, 123, 20);
		panelFuncoes.add(txtDataLancamento);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 403, 14);
		panelFuncoes.add(separator);
		btnBuscar.addMouseListener(this);

		scrolPane = new JScrollPane(getTblJogo());
		scrolPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		scrolPane.setLocation(0, 0);
		scrolPane.setSize(647, 210);
		panel.add(scrolPane);

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

	private JogoTableModel getTableModel() throws IOException {

		if (tableModel == null) {

			System.out.println("Entrou no getTableModel");
			tableModel = new JogoTableModel(criaJogos());
		}
		return tableModel;
	}

	//___________________ cria uma lista com Jogos_________________________________________
	private List<Jogo> criaJogos() throws IOException {

		List<Jogo> jogos = getJogos();
		return jogos;
	}

	//________________________________Fim dos Métodos do TabelModel_________________________

	//___________________________Método para adicionar_______________________________________
	public void adicionaJogo()
	{
		Jogo jogo = new Jogo();
		//Adicionando todos os elementos do objeto jogo em uma lista
		jogo.setClassificacao(comboClassificacao.getSelectedItem()+"");
		jogo.setDataLancamento(txtDataLancamento.getText());
		jogo.setGenero(comboGenero.getSelectedItem()+"");
		jogo.setNomeJogo(txtNomeJogo.getText());
		jogo.setPlataforma(comboPlataforma.getSelectedItem()+"");
		jogo.setPreco(Float.parseFloat(txtPreco.getText()+""));
		jogo.setImagem(caminho);

		tableModel.addJogo(jogo);
		EscritaJogo.escrever(jogo);
		JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
	}


	//_______________________________Método adiciona e altera o selecionado_____________________
	private void addJogos(List<Jogo> jogos, String nome)
	{	
		int i=0;
		EscritaJogo.deletarArquivo();

		for(Jogo j : jogos)
		{
			if(j.getNomeJogo().equals(nome))
			{

			}
			else 
			{
				EscritaJogo.escrever(j);
			}
		}
		//Cria um novo objeto jogo
		Jogo jogo = new Jogo();
		//Adicionando os seus dados na lista
		jogo.setClassificacao(comboClassificacao.getSelectedItem() + "");
		jogo.setDataLancamento(txtDataLancamento.getText());
		jogo.setGenero(comboGenero.getSelectedItem() + "");
		jogo.setNomeJogo(txtNomeJogo.getText());
		jogo.setPlataforma(comboPlataforma.getSelectedItem() + "");
		jogo.setPreco(Float.parseFloat(txtPreco.getText()));

		tableModel.addJogo(jogo);
		tableModel.removeJogo(i);
		EscritaJogo.escrever(jogo);
		System.out.println(i++);
	}

	//_____________________Remove do txt____________________________
	private void removeJogosTxt(List<Jogo> jogos, String nome)
	{
		int i=0;
		EscritaJogo.deletarArquivo();

		for(Jogo j : jogos)
		{
			if(j.getNomeJogo().equals(nome))
			{

			}
			else 
			{
				EscritaJogo.escrever(j);
				if(tblJogo.getSelectedRow() != -1)
				{
					tableModel.removeJogo(tblJogo.getSelectedRow());
				}
			}
		}
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
				txtDataLancamento.setText(j.getDataLancamento());
				txtPreco.setText(j.getPreco() + "");
				comboClassificacao.setSelectedItem(j.getClassificacao());
				comboGenero.setSelectedItem(j.getGenero());
				comboPlataforma.setSelectedItem(j.getPlataforma());
				ImageIcon img = new ImageIcon(j.getImagem());
				lblFotoJogo.setIcon(img);
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

	//________________________________Preenchendo o comboBox___________________________________________
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

	//__________________________Lê jogo e preenche TableModel_______________________________________
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


	//___________________________Remove o cliente da lista_____________________________________
	public List<Jogo> removeJogo(List<Jogo> jogos , Jogo jogo)

	{
		jogos.remove(jogo);
		JOptionPane.showMessageDialog(null, "txt Alterado com Sucesso");
		return jogos;
	}

	//__________________Limpa os campos de textField________________________________________
	public void limparTextField()
	{
		txtDataLancamento.setText("");
		txtNomeJogo.setText("");
		txtPreco.setText("");
		comboClassificacao.setSelectedItem("Selecione");
		comboGenero.setSelectedItem("Selecione");
		comboPlataforma.setSelectedItem("Selecione");
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
		if(e.getSource() == btnAdicionar)
		{
			adicionaJogo();
			comboBoxJogo.removeAll(); //Atualizar o combobox
			preencheComboJogo(getJogos());
			limparTextField();
		}


		else if(e.getSource() == btnBuscar)
		{
			selecionaJogo(getJogos());
		}

		else if(e.getSource() == btnAlterar)
		{
			addJogos(removeJogo(getJogos(), pegaJogo(getJogos())),txtNomeJogo.getText());
			limparTextField();
		}

		if(e.getSource() == btnRemover)
		{
			removeJogosTxt(removeJogo(getJogos(), pegaJogo(getJogos())),txtNomeJogo.getText());
			comboBoxJogo.removeAll();
			preencheComboJogo(getJogos());
			limparTextField();

		}


		else if(e.getSource() == btnBuscarImagem)
		{
			JFileChooser chooser;
			chooser = new JFileChooser();
			File file = null;
			int retorno = chooser.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.

			if (retorno==JFileChooser.APPROVE_OPTION){
				caminho = chooser.getSelectedFile().getAbsolutePath();
				ImageIcon img = new ImageIcon(caminho);
				lblFotoJogo.setIcon(img);

			}
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

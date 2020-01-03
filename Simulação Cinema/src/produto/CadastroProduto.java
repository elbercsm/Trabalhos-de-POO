package produto;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CadastroProduto extends JFrame implements MouseListener
{
	JLabel descricaoProduto, categoriaProduto, fornecedor, unidadeProduto, observacao, precoCompra, precoVenda, imagem;
	JTextField txtDescricao, txtFornecedor, txtCompra, txtVenda;
	JComboBox categoria, unidade;
	TextArea observacoes;
	JButton  limpar, cadastrar, salvar, suspender;
	JPanel panel_esquerdo, panel_direito;
	private ImageIcon imgPipoca;
	
	public CadastroProduto()
	{
		this.setSize(800,600);
		this.setTitle("Cadastro de Produtos");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Inserindo imagem
		imgPipoca = new ImageIcon("img/logotipo 1.jpg");
		imagem = new JLabel(imgPipoca);
		imagem.setBounds(420, 90, 350, 350);
		imagem.setVisible(true);
		this.add(imagem);
		
		
		//Titulo
		JLabel titulo = new JLabel("Cadastro de Produtos");
		titulo.setBounds(250, 40, 300, 30);
		titulo.setFont(new Font("Serif", Font.BOLD, 30));
		titulo.setVisible(true);
		this.add(titulo);
		
		//Criando painel esquerdo
		panel_esquerdo = new JPanel();
		panel_esquerdo.setBounds(30, 90, 720, 400);
		panel_esquerdo.setBackground(Color.LIGHT_GRAY);
		panel_esquerdo.setVisible(true);
		panel_esquerdo.setBorder(new LineBorder(Color.black,2));
		panel_esquerdo.setLayout(null);
		this.add(panel_esquerdo);

	
		//Descrição do Produto
		descricaoProduto = new JLabel("Descrição : ");
		descricaoProduto.setBounds(10, 10, 70,50);
		descricaoProduto.setVisible(true);
		panel_esquerdo.add(descricaoProduto);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(110, 25, 200,20);
		txtDescricao.setVisible(true);
		panel_esquerdo.add(txtDescricao);
		
		//Categoria
		
		categoriaProduto = new JLabel("Categoria : ");
		categoriaProduto.setBounds(10, 50, 70,50);
		categoriaProduto.setVisible(true);
		panel_esquerdo.add(categoriaProduto);
		
		categoria = new JComboBox();
		categoria.setBounds(110, 65, 200,20);
		categoria.addItem("Selecione");
		categoria.addItem("Bebidas");
		categoria.addItem("Pipocas");
		categoria.addItem("Outros");
		categoria.setVisible(true);
		panel_esquerdo.add(categoria);
		
		//Fornecedor
		fornecedor = new JLabel("Fornecedor : ");
		fornecedor.setBounds(10, 95, 90,50);
		fornecedor.setVisible(true);
		panel_esquerdo.add(fornecedor);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(110, 110, 200,20);
		txtFornecedor.setVisible(true);
		panel_esquerdo.add(txtFornecedor);
		
		//Unidade
		unidadeProduto = new JLabel("Unidade : ");
		unidadeProduto.setBounds(10, 139, 70,50);
		unidadeProduto.setVisible(true);
		panel_esquerdo.add(unidadeProduto);
		
		unidade = new JComboBox();
		unidade.setBounds(110, 155, 200,20);
		unidade.addItem("Selecione");
		unidade.addItem("Garrafa");
		unidade.addItem("Lata");
		unidade.addItem("Pequeno");
		unidade.addItem("Médio");
		unidade.addItem("Grande");
		unidade.setVisible(true);
		panel_esquerdo.add(unidade);
		
		//Preço de Compra
		precoCompra = new JLabel("Preço Compra : ");
		precoCompra.setBounds(10, 190, 110,50);
		precoCompra.setVisible(true);
		panel_esquerdo.add(precoCompra);
		
		txtCompra = new JTextField();
		txtCompra.setBounds(110, 205, 200,20);
		txtCompra.setVisible(true);
		panel_esquerdo.add(txtCompra);
		
		//Preço de Venda
		
		precoVenda = new JLabel("Preço Venda : ");
		precoVenda.setBounds(10, 235, 110,50);
		precoVenda.setVisible(true);
		panel_esquerdo.add(precoVenda);
		
		txtVenda = new JTextField();
		txtVenda.setBounds(110, 250, 200,20);
		txtVenda.setVisible(true);
		panel_esquerdo.add(txtVenda);
		
		//Observações
		observacao = new JLabel("Obs : ");
		observacao.setBounds(10, 280, 50,50);
		observacao.setVisible(true);
		panel_esquerdo.add(observacao);
		
		observacoes = new TextArea();
		observacoes.setBounds(70,300,300, 80);
		observacoes.setVisible(true);
		panel_esquerdo.add(observacoes);
		
		//Botao Limpar
		limpar = new JButton("Limpar");
		limpar.setBounds(120, 500, 120, 40);
		limpar.setVisible(true);
		this.add(limpar);
		limpar.addMouseListener(this);
	
		//Botao cadastrar
		cadastrar = new JButton("Novo");
		cadastrar.setBounds(250, 500, 120, 40);
		cadastrar.setVisible(true);
		this.add(cadastrar);
		cadastrar.addMouseListener(this);
		
		//Boatao Salvar
		
		salvar = new JButton("Salvar");
		salvar.setBounds(380, 500, 120, 40);
		salvar.setVisible(true);
		this.add(salvar);
		salvar.addMouseListener(this);
		
		//Botao suspender
		suspender = new JButton("Suspender");
		suspender.setBounds(510, 500, 120, 40);
		suspender.setVisible(true);
		this.add(suspender);
		salvar.addMouseListener(this);
		
		
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == limpar)
		{
			JOptionPane.showMessageDialog(null, "Iten apagado!");
		}
		
		if(e.getSource() == salvar)
		{
			JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
		}
		
		
	}

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

package promocao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class CadastroPromocao  extends JFrame implements MouseListener
{
	JLabel codFilme, dataFilme, nomePromocao, periodoPromocao, desconto, totalPagar, codProduto, total;
	JPanel panel_inf;
	JTextField txtPromocao, txtPeriodo, txtDesconto, txtTotal, txtTotalPagar;
	private ImageIcon imgPipoca;
	private JLabel imagem;
	JButton limpar, salvar, cadastrar, suspender;
	private JComboBox comboTipo;
	private JSeparator separator;
	
	public CadastroPromocao()
	{
		this.setTitle("Cadastro Promoção");
		this.setSize(800, 600);//Tamanho da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Método botão fechar
		getContentPane().setLayout(null);
		
		//Inserindo imagem
		imgPipoca = new ImageIcon("img/promocao claquete.png");
		imagem = new JLabel(imgPipoca);
		imagem.setBounds(400, 120, 350, 300);
		imagem.setVisible(true);
		getContentPane().add(imagem);
		
		
		//Titulo da janela
		JLabel titulo = new JLabel("Cadastro de Promoções");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(0, 0, 784, 50);
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setVisible(true);
		getContentPane().add(titulo);
		
		//Criando painel esquerdo
		panel_inf = new JPanel();
		panel_inf.setBounds(10, 61, 767, 400);
		panel_inf.setBackground(Color.LIGHT_GRAY);
		panel_inf.setVisible(true);
		panel_inf.setBorder(new LineBorder(Color.black,2));
		panel_inf.setLayout(null);
		getContentPane().add(panel_inf);
		
		//Nome do filme
		JLabel lblTipo = new JLabel("Nome do Filme : ");
		lblTipo.setBounds(10, 10, 200, 20);
		lblTipo.setVisible(true);
		panel_inf.add(lblTipo);

		comboTipo = new JComboBox();
		comboTipo.setBounds(135, 10, 90, 20);
		comboTipo.setVisible(true);
		comboTipo.addItem("Selecione");
		comboTipo.addItem("Filme 1");
		comboTipo.addItem("Filme 2");
		comboTipo.addItem("Filme 3");
		comboTipo.addItem("Filme 4");
		comboTipo.setSelectedItem("Selecione");
		panel_inf.add(comboTipo);
		
		
		//Código Filme
		codFilme = new JLabel("Cód. Filme:   0002");
		codFilme.setBounds(230, -3, 130, 50);
		codFilme.setVisible(true);
		panel_inf.add(codFilme);
		
		//Código do Produto
		codFilme = new JLabel("Cód. Produto: 0002");
		codFilme.setBounds(230, 245, 200, 30);
		codFilme.setVisible(true);
		panel_inf.add(codFilme);
		
		//Criando o nome da Promoção
		nomePromocao = new JLabel("Nome da Promoção : ");
		nomePromocao.setBounds(10, 50, 200, 30);
		nomePromocao.setVisible(true);
		panel_inf.add(nomePromocao);
		
		txtPromocao = new JTextField();
		txtPromocao.setBounds(135, 55, 200,20);
		txtPromocao.setVisible(true);
		panel_inf.add(txtPromocao);
		
		//Periodo da Promoção
		periodoPromocao = new JLabel("Perído : ");
		periodoPromocao.setBounds(10, 80, 130, 50);
		periodoPromocao.setVisible(true);
		panel_inf.add(periodoPromocao);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(135, 95, 200,20);
		txtPeriodo.setVisible(true);
		panel_inf.add(txtPeriodo);
		
		//Desconto
		desconto = new JLabel("Desconto : ");
		desconto.setBounds(10, 120, 130, 50);
		desconto.setVisible(true);
		panel_inf.add(desconto);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(135, 135, 200,20);
		txtDesconto.setVisible(true);
		panel_inf.add(txtDesconto);
		
		//Total a pagar após o desconto
		totalPagar = new JLabel("Total à pagar : ");
		totalPagar.setBounds(10, 170, 150, 30);
		totalPagar.setVisible(true);
		panel_inf.add(totalPagar);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(135, 175, 200,20);
		txtTotal.setVisible(true);
		panel_inf.add(txtTotal);
		
		
		//Criando nome do Produto
		nomePromocao = new JLabel("Nome do Produto : ");
		nomePromocao.setBounds(10, 245, 200, 30);
		nomePromocao.setVisible(true);
		panel_inf.add(nomePromocao);

		comboTipo = new JComboBox();
		comboTipo.setBounds(135, 250, 90,20);
		comboTipo.setVisible(true);
		comboTipo.addItem("Selecione");
		comboTipo.addItem("Produto 1");
		comboTipo.addItem("Produto 2");
		comboTipo.addItem("Produto 3");
		comboTipo.addItem("Produto 4");
		comboTipo.setSelectedItem("Selecione");
		panel_inf.add(comboTipo);
		
		//Desconto do Produto
		desconto = new JLabel("Desconto : ");
		desconto.setBounds(10, 275, 130, 50);
		desconto.setVisible(true);
		panel_inf.add(desconto);

		txtDesconto = new JTextField();
		txtDesconto.setBounds(135, 290, 200,20);
		txtDesconto.setVisible(true);
		panel_inf.add(txtDesconto);

		//Total a pagar após o desconto do produto
		totalPagar = new JLabel("Total à pagar : ");
		totalPagar.setBounds(10, 325, 150, 30);
		totalPagar.setVisible(true);
		panel_inf.add(totalPagar);

		txtTotal = new JTextField();
		txtTotal.setBounds(135, 330, 200,20);
		txtTotal.setVisible(true);
		panel_inf.add(txtTotal);

		
		//Total
		total = new JLabel("Total : ");
		total.setBounds(10, 366, 160, 30);
		total.setVisible(true);
		panel_inf.add(total);

		txtTotalPagar = new JTextField();
		txtTotalPagar.setBounds(135, 366, 200,20);
		txtTotalPagar.setVisible(true);
		panel_inf.add(txtTotalPagar);
		
		separator = new JSeparator();
		separator.setBounds(10, 230, 325, -11);
		panel_inf.add(separator);
		

		//Botao Limpar
		limpar = new JButton("Limpar");
		limpar.setBounds(118, 482, 120, 40);
		limpar.setVisible(true);
		getContentPane().add(limpar);
		limpar.addMouseListener(this);

		//Botao cadastrar
		cadastrar = new JButton("Novo");
		cadastrar.setBounds(248, 482, 120, 40);
		cadastrar.setVisible(true);
		getContentPane().add(cadastrar);
		cadastrar.addMouseListener(this);

		//Boatao Salvar
		salvar = new JButton("Salvar");
		salvar.setBounds(378, 482, 120, 40);
		salvar.setVisible(true);
		getContentPane().add(salvar);
		salvar.addMouseListener(this);
		
		//Boatao Suspender
		suspender = new JButton("Suspender");
		suspender.setBounds(508, 482, 120, 40);
		suspender.setVisible(true);
		getContentPane().add(suspender);
		suspender.addMouseListener(this);
		
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource() == limpar)
		{
			JOptionPane.showMessageDialog(null,"Iten Apagado!");
		}
		
		if(e.getSource() == salvar)
		{
			JOptionPane.showMessageDialog(null,"Cadastro Salvo!");
		}
		
		
	}

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

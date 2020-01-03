package vendaIngresso;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;


public class RegistroVenda extends JFrame implements MouseListener
{
	private static final JLabel JTFData = null;
	JSpinner meio, inteiro;
	JLabel data, codVenda, hora, codFun,meioIngresso, titulo, codFilme, codSessao, codSala, codPromocao;
	JLabel ingressoInteiro, totalPagamento,formaPagamento ;
	JTextField txtData, txtHora, txtCodigo, txtPagamento, txtCodigoFilme,txtCodigoSessao, txtCodigoSala, txtCodigoPromocao;
	JSpinner txtmeio, txtinteira, spData;
	JRadioButton cartao, dinheiro;
	private ButtonGroup grupoRadioValor;
	private AbstractButton radioCartao;
	private AbstractButton radioDinheiro;
	JPanel panel_sup, panel_inf;
	JButton limpar, salvar, incluir, imprimir, suspender;
	private JComponent tabela;
	
	
	public RegistroVenda()
	{
		this.setSize(800, 600);
		this.setLayout(null);
		this.setResizable(false);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroVenda.class.getResource("img/logotipo1.jpg")));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Venda Ingresso");
		
		//Titulo 
		titulo = new JLabel("Registro de Venda");
		titulo.setBounds(300, 10, 190, 50);
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setVisible(true);
		this.add(titulo);
		
		panel_sup = new JPanel();
		panel_sup.setBounds(80, 55, 600, 55);	
		panel_sup.setBorder(new LineBorder(Color.black,2));
		panel_sup.setBackground(Color.LIGHT_GRAY);
		panel_sup.setLayout(null);
		panel_sup.setVisible(true);
		this.add(panel_sup);
		
		//Criando o Código de Venda
		codVenda = new JLabel("Cód. Venda :  0001");
		codVenda.setBounds(140, 5, 110, 50);
		codVenda.setVisible(true);
		panel_sup.add(codVenda);
		
		//Criando Código Funcionário
		codFun = new JLabel("Cód. Funcionário : ");
		codFun.setBounds(280, 5, 110, 50);
		codFun.setVisible(true);
		panel_sup.add(codFun);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(390,20, 70, 25);
		txtCodigo.setVisible(true);
		panel_sup.add(txtCodigo);
		
		panel_inf = new JPanel();
		panel_inf.setBounds(80, 130, 600, 400);	
		panel_inf.setBorder(new LineBorder(Color.black,2));
		panel_inf.setBackground(Color.LIGHT_GRAY);
		panel_inf.setLayout(null);
		panel_inf.setVisible(true);
		this.add(panel_inf);
		
		
		//Criando data
		data = new JLabel("Data : ");
		data.setBounds(10, 10, 40, 50);
		data.setVisible(true);
		panel_inf.add(data);
		
		txtData = new JTextField();
		txtData.setBounds(50,25, 70, 25);
		txtData.setVisible(true);
		panel_inf.add(txtData);
		
		//Inserindo hora
		hora = new JLabel("Hora : 15h30");
		hora.setBounds(140, 10, 100, 50);
		hora.setVisible(true);
		panel_inf.add(hora);
		
		//Codigo Filme
		codFilme = new JLabel("Cód. Filme : ");
		codFilme.setBounds(10, 50, 100, 50);
		codFilme.setVisible(true);
		panel_inf.add(codFilme);
		
		txtCodigoFilme = new JTextField();
		txtCodigoFilme.setBounds(95,65, 70, 25);
		txtCodigoFilme.setVisible(true);
		panel_inf.add(txtCodigoFilme);
		
		//Codigo Sessão
		codSessao = new JLabel("Cód. Sessão : ");
		codSessao.setBounds(10, 90, 100, 50);
		codSessao.setVisible(true);
		panel_inf.add(codSessao);
		
		txtCodigoSessao = new JTextField();
		txtCodigoSessao.setBounds(95,105, 70, 25);
		txtCodigoSessao.setVisible(true);
		panel_inf.add(txtCodigoSessao);
		
		//Codigo Sala
		codSala = new JLabel("Cód. Sala : ");
		codSala.setBounds(10, 130, 100, 50);
		codSala.setVisible(true);
		panel_inf.add(codSala);
		
		txtCodigoSala = new JTextField();
		txtCodigoSala.setBounds(95,145, 70, 25);
		txtCodigoSala.setVisible(true);
		panel_inf.add(txtCodigoSala);
		
		//Código Promoção
		codPromocao = new JLabel("Cód. Promoção : ");
		codPromocao.setBounds(10, 240, 110, 50);
		codPromocao.setVisible(true);
		panel_inf.add(codPromocao);
		
		txtCodigoPromocao = new JTextField();
		txtCodigoPromocao.setBounds(110,250, 70, 25);
		txtCodigoPromocao.setVisible(true);
		panel_inf.add(txtCodigoPromocao);
		
		
		//Meio Ingresso Spinner
		meioIngresso = new JLabel("Meio Ingresso : ");
		meioIngresso.setBounds(10,170, 90, 50);
		meioIngresso.setVisible(true);
		panel_inf.add(meioIngresso);
		
		txtmeio = new JSpinner();
		txtmeio.setBounds(110, 185,40, 20);
		txtmeio.setVisible(true);
		panel_inf.add(txtmeio);
		
		//Inteiro
		ingressoInteiro = new JLabel("Ingresso Inteiro : ");
		ingressoInteiro.setBounds(10,205, 100, 50);
		ingressoInteiro.setVisible(true);
		panel_inf.add(ingressoInteiro);
		
		txtinteira = new JSpinner();
		txtinteira.setBounds(110, 220,40, 20);
		txtinteira.setVisible(true);
		panel_inf.add(txtinteira);
		
		//Total
		totalPagamento = new JLabel("Total : ");
		totalPagamento.setBounds(10, 280,50, 50);
		totalPagamento.setVisible(true);
		panel_inf.add(totalPagamento);
		
		txtPagamento = new JTextField();
		txtPagamento.setBounds(49,295 ,90, 20);
		txtPagamento.setVisible(true);
		panel_inf.add(txtPagamento);
		

		//Forma de PAgamento
		formaPagamento = new JLabel("Forma de Pagamento : ");
		formaPagamento.setBounds(10, 340, 140, 50);
		formaPagamento.setVisible(true);
		panel_inf.add(formaPagamento);
		
		cartao = new JRadioButton("Cartao");
		cartao.setBounds(150,355, 70, 20);
		cartao.setVisible(true);
		panel_inf.add(cartao);
		
		dinheiro = new JRadioButton("Dinheiro");
		dinheiro.setBounds(230,355, 90, 20);
		dinheiro.setVisible(true);
		panel_inf.add(dinheiro);
		
		grupoRadioValor = new ButtonGroup();
		grupoRadioValor.add(radioCartao);
		grupoRadioValor.add(radioDinheiro);
		
		//Botao Limpar
		limpar = new JButton("Limpar");
		limpar.setBounds(460, 115, 120, 40);
		limpar.setVisible(true);
		panel_inf.add(limpar);
		limpar.addMouseListener(this);
	
		//Botao Incluir
		incluir = new JButton("Incluir");
		incluir.setBounds(460, 165, 120, 40);
		incluir.setVisible(true);
		panel_inf.add(incluir);
		incluir.addMouseListener(this);
		
		//Boatao Salvar
		salvar = new JButton("Salvar");
		salvar.setBounds(460, 210, 120, 40);
		salvar.setVisible(true);
		panel_inf.add(salvar);
		salvar.addMouseListener(this);
		
		//Boatao Suspender
		suspender = new JButton("Suspender");
		suspender.setBounds(460, 255, 120, 40);
		suspender.setVisible(true);
		panel_inf.add(suspender);
		suspender.addMouseListener(this);


		//Boatao Imprimir
		imprimir = new JButton("Imprimir");
		imprimir.setBounds(460, 300, 120, 40);
		imprimir.setVisible(true);
		panel_inf.add(imprimir);
		imprimir.addMouseListener(this);
				
		
		this.setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == limpar)
		{
			JOptionPane.showMessageDialog(null,"Iten apagado!");
		}
		
		if(e.getSource() == salvar)
		{
			JOptionPane.showMessageDialog(null,"Registro salvo!");
		}
		
		if(e.getSource() == imprimir)
		{
			
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

package iftm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.Line;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Janela extends JFrame implements MouseListener, ActionListener
{

	Medico medico = new Medico();
	JButton botaoAdd ;
	JButton botaoLimpar;
	JTextField txtNome;
	JSpinner txtIdade;
	JSlider percentualDePart;
	@SuppressWarnings("rawtypes")
	JComboBox comboTipo;
	JCheckBox checkPeriodoMatu, checkPeriodoVesp, checkPeriodoNotur;
	JRadioButton radioSexoMasculino, radioSexoFeminino;
	ButtonGroup grupoRadioSexo;
	TextArea mensagem;
	@SuppressWarnings("rawtypes")
	JList lista;
	JPanel panel_esquerdo, panel_direito;
	ArrayList<Medico> medicos = new ArrayList();
	private JButton botaoListar;
	

	public Janela()
	{
		super("Cadastro de Médicos");//Nome da janela
		this.setSize(800, 600);//Tamanho da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Método botão fechar
		this.setLayout(null);

		//Titulo da janela
		JLabel titulo = new JLabel("Cadastro de Médicos");
		titulo.setBounds(300, 40, 200, 30);
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setVisible(true);
		this.add(titulo);

		//Criando painel esquerdo
		panel_esquerdo = new JPanel();
		panel_esquerdo.setBounds(5, 80, 380, 400);
		panel_esquerdo.setBackground(Color.LIGHT_GRAY);
		panel_esquerdo.setVisible(true);
		panel_esquerdo.setBorder(new LineBorder(Color.black,2));
		panel_esquerdo.setLayout(null);
		this.add(panel_esquerdo);
		
		//Criando painel direito
		panel_direito = new JPanel();
		panel_direito.setBounds(390, 80,390, 400);
		panel_direito.setBackground(Color.darkGray);
		panel_direito.setVisible(true);
		panel_direito.setBorder(new LineBorder(Color.black,2));
		panel_direito.setLayout(null);
		this.add(panel_direito);

		//__________________________________
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 20, 100, 10);
		lblNome.setVisible(true);
		panel_esquerdo.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(90, 15, 165, 20);
		txtNome.setVisible(true);
		panel_esquerdo.add(txtNome);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(15, 50, 200, 20);
		lblIdade.setVisible(true);
		panel_esquerdo.add(lblIdade);

		txtIdade = new JSpinner();
		txtIdade.setBounds(90, 50, 165, 20);
		txtIdade.setVisible(true);
		panel_esquerdo.add(txtIdade);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(15, 80, 200, 20);
		lblTipo.setVisible(true);
		panel_esquerdo.add(lblTipo);

		comboTipo = new JComboBox();
		comboTipo.setBounds(90, 80, 165, 20);
		comboTipo.setVisible(true);
		comboTipo.addItem("Selecione");
		comboTipo.addItem("Cardiologista");
		comboTipo.addItem("Urologista");
		comboTipo.addItem("Pediatra");
		comboTipo.addItem("Neurologista");
		comboTipo.setSelectedItem("Selecione");
		panel_esquerdo.add(comboTipo);
		//_____________________________________________________________________

		//Criando checkBox
		JLabel lblCheckMatu = new JLabel("Periodo:");
		lblCheckMatu.setBounds(15, 110, 100, 20);
		lblCheckMatu.setVisible(true);
		panel_esquerdo.add(lblCheckMatu);
		
	
		checkPeriodoMatu = new JCheckBox("Matutino");
		checkPeriodoMatu.setBounds(90, 110, 80, 20);
		checkPeriodoMatu.setVisible(true);
		panel_esquerdo.add(checkPeriodoMatu);

		checkPeriodoVesp = new JCheckBox("Vespertino");
		checkPeriodoVesp.setBounds(175, 110, 80, 20);
		checkPeriodoVesp.setVisible(true);
		panel_esquerdo.add(checkPeriodoVesp);

		checkPeriodoNotur = new JCheckBox("Noturno");
		checkPeriodoNotur.setBounds(260, 110, 80, 20);
		checkPeriodoNotur.setVisible(true);
		panel_esquerdo.add(checkPeriodoNotur);
		//_________________________________________________
		
		//Criando sexo
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(15, 140, 100, 20);
		lblSexo.setVisible(true);
		panel_esquerdo.add(lblSexo);

		//Criando RadioButton
		radioSexoMasculino = new JRadioButton("Masculino");
		radioSexoMasculino.setBounds(90, 140, 80, 20);
		radioSexoMasculino.setVisible(true);
		panel_esquerdo.add(radioSexoMasculino);

		radioSexoFeminino = new JRadioButton("Feminino");
		radioSexoFeminino.setBounds(175, 140, 80, 20);
		radioSexoFeminino.setVisible(true);
		panel_esquerdo.add(radioSexoFeminino);

		grupoRadioSexo = new ButtonGroup();
		grupoRadioSexo.add(radioSexoMasculino);
		grupoRadioSexo.add(radioSexoFeminino);
		//______________________________________________
		
		//Criando Percentual
		JLabel lblPercentual = new JLabel("Percentual:"); //percentual de participação nos lucros do hospital
		lblPercentual.setBounds(15, 170, 100, 20);
		lblPercentual.setVisible(true);
		panel_esquerdo.add(lblPercentual);

		//Criando Slider
		percentualDePart = new JSlider();
		percentualDePart.setBounds(90, 170, 170, 40);
		percentualDePart.setMinorTickSpacing(10);
		percentualDePart.setMajorTickSpacing(20);
		percentualDePart.setPaintTicks(true);
		percentualDePart.setPaintLabels(true);
		percentualDePart.setLabelTable(percentualDePart.createStandardLabels(20));
		percentualDePart.setVisible(true);
		panel_esquerdo.add(percentualDePart);

		/*JLabel lblmensagem = new JLabel("Descrição"); 
		lblmensagem.setBounds(15, 220, 100, 20);
		lblmensagem.setVisible(true);
		panel_esquerdo.add(lblmensagem);*/

		mensagem = new TextArea();
		mensagem.setBounds(15, 50, 360, 330);
		mensagem.setVisible(true);
		panel_direito.add(mensagem);
		//panel_esquerdo.add(mensagem);

		//Criando uma lista
		JLabel lblLista = new JLabel("Lista"); 
		lblLista.setBounds(175, 20, 100, 20);
		lblLista.setVisible(true);
		lblLista.setForeground(Color.WHITE);
		panel_direito.add(lblLista);

		lista = new JList<Medico>();
		//lista.setBounds(15, 50, 360, 330);
		lista.setVisible(true);
		panel_direito.add(lista);
		this.setVisible(true);
		//__________________________________________
		
		botaoAdd = new JButton("Adicionar");
		botaoAdd.setBounds(10, 500, 120, 40);
		botaoAdd.setVisible(true);
		this.add(botaoAdd);
		botaoAdd.addMouseListener(this);

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(140, 500, 120, 40);
		botaoLimpar.setVisible(true);
		this.add(botaoLimpar);
		botaoLimpar.addMouseListener(this);

		botaoListar = new JButton("Listar");
		botaoListar.setBounds(270, 500, 120, 40);
		botaoListar.setVisible(true);
		this.add(botaoListar);
		botaoListar.addMouseListener(this);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getSource()==botaoLimpar)
		{
			limpar();
			
		}

		//______________________________BOTÃO ADICIONAR__________________________________
		if(e.getSource() == botaoAdd)
		{
			medico.setNome(txtNome.getText());
			medico.setIdade(Integer.parseInt(txtIdade.getValue()+""));
			if(radioSexoFeminino.isSelected()==true)
			{
				medico.setSexo("Feminino");
			}
			else if(radioSexoMasculino.isSelected()==true)
			{
				medico.setSexo("Masculino");
			}
			medico.setTipo(comboTipo.getSelectedItem()+"");
			medico.setPercentualDePart(percentualDePart.getValue());
			medico.setDescricao(mensagem.getText());

			medicos.add(medico);
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!!");
			limpar();
		}

		//__________________________BOTÃO LISTAR_______________________________________
		if(e.getSource()==botaoListar)
		{
			
			for(Medico m : medicos)//Criando um Iterator (iterador) (server para percorrer uma lista de objetos)
			{
				mensagem.setText(mensagem.getText()+m.getNome()+"\n");
				mensagem.setText(mensagem.getText()+m.getIdade()+"\n");
				mensagem.setText(mensagem.getText()+m.getTipo()+"\n");
				mensagem.setText(mensagem.getText()+m.getPercentualDePart()+"\n");
				mensagem.setText(mensagem.getText()+m.getSexo()+"\n_____________________________\n");
			}
		}
	}
	
	//____________________________BOTÃO LIMPAR________________________________
	public void limpar()
	{
		mensagem.setText(" ");
		txtNome.setText(" ");
		txtIdade.resetKeyboardActions();
		comboTipo.setSelectedItem("Selecione");
		radioSexoFeminino.setSelected(false);
		radioSexoMasculino.setSelected(false);
		checkPeriodoMatu.setSelected(false);
		checkPeriodoNotur.setSelected(false);
		checkPeriodoVesp.setSelected(false);
		percentualDePart.setValue(50);
		repaint();

	}
/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
/*	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
	/*
	@Override
	public void mouseEntered(MouseEvent e) 
	{


	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e) 
	{


	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{


	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}

	 

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

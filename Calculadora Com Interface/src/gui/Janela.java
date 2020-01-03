package gui;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Janela extends JFrame implements MouseListener
{
	JPanel panel_superior, panel_inferior;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bAd, bSub, bFat, bDiv, bMult, bPorc,bExp, bRaiz;
	JButton limpar, bAddMem, bVirgula, bIgual, bPonto; 
	int numeroConcatenado, numeroConcatenado2;
	int num1, num2;
	double resultado;
	String operadorSelecionado=null;
	private JTextField textoResultado;
	int cont = 0;
	private JPanel panel_total;
	
	
	public Janela()
	{
		this.setSize(400, 500);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);//NÃO DEIXA MAXIMIZAR MINHA TELA
		this.setTitle("Calculadora");
		
		panel_total = new JPanel();
		panel_total.setBounds(0, 0, 400, 500);
		panel_total.setVisible(true);
		panel_total.setBackground(getBackground().GRAY);
		panel_total.setLayout(null);
		this.add(panel_total);
		
		//Criando painel superior, contendo os valores da operação
		panel_superior = new JPanel();
		panel_superior.setBounds(20, 10, 315,75 );
		panel_superior.setVisible(true);
		panel_superior.setBorder(new LineBorder(Color.BLACK, 2));
		panel_superior.setBackground(getBackground().black);
		panel_superior.setLayout(null);
		panel_total.add(panel_superior);
		
		//Texto do painel superior
	    textoResultado = new JTextField();
	    textoResultado.setBounds(2, 2, 311, 71);
		textoResultado.setVisible(true);
		textoResultado.setFont(new Font("", 1, 20)); 
		panel_superior.add(textoResultado);
		
		//Criando o painel esquerdo, contendo os números a serem digitados pelo usuário
		panel_inferior = new JPanel();
		panel_inferior.setBounds(20, 100, 315, 310);
		panel_inferior.setVisible(true);
		panel_inferior.setBorder(new LineBorder(Color.BLACK, 2));
		panel_inferior.setLayout(null);
		//panel_esquerdo.setBackground(Color.BLUE);
		panel_total.add(panel_inferior);
	
		
		//Criando o botão Porcentagem
		bPorc = new JButton("%");
		bPorc.setBounds(10, 10, 50,50);
		bPorc.setVisible(true);
		panel_inferior.add(bPorc);
		bPorc.addMouseListener(this);
		
		//Criando o botão Raiz
		bRaiz = new JButton("²√");
		bRaiz.setBounds(70, 10, 50,50);
		bRaiz.setVisible(true);
		panel_inferior.add(bRaiz);
		bRaiz.addMouseListener(this);

		//Criando o botão Exponencial
		bExp = new JButton("x²");
		bExp.setBounds(130, 10, 50,50);
		bExp.setVisible(true);
		panel_inferior.add(bExp);
		bExp.addMouseListener(this);
		
		//Criando o botão Fatorial
		bFat = new JButton("x!");
		bFat.setBounds(190, 10, 50,50);
		bFat.setVisible(true);
		panel_inferior.add(bFat);
		bFat.addMouseListener(this);
		
		//Criando o botão Limpar
		bAddMem = new JButton("M+");
		bAddMem.setBounds(250, 10, 60,50);
		bAddMem.setVisible(true);
		panel_inferior.add(bAddMem);
		bAddMem.addMouseListener(this);

		//Criando o botão 7
		b7 = new JButton("7");
		b7.setBounds(10, 70, 50,50);
		b7.setVisible(true);
		panel_inferior.add(b7);
		b7.addMouseListener(this);
		
		//Criando o botão 8
		b8 = new JButton("8");
		b8.setBounds(70, 70, 50,50);
		b8.setVisible(true);
		panel_inferior.add(b8);
		b8.addMouseListener(this);
		
		//Criando o botão 9
		b9 = new JButton("9");
		b9.setBounds(130, 70, 50,50);
		b9.setVisible(true);
		panel_inferior.add(b9);
		b9.addMouseListener(this);
		
		//Criando o botão 4
		b4 = new JButton("4");
		b4.setBounds(10, 130, 50,50);
		b4.setVisible(true);
		panel_inferior.add(b4);
		b4.addMouseListener(this);
		
		//Criando o botão 5
		b5 = new JButton("5");
		b5.setBounds(70, 130, 50,50);
		b5.setVisible(true);
		panel_inferior.add(b5);
		b5.addMouseListener(this);
		
		//Criando o botão 6
		b6 = new JButton("6");
		b6.setBounds(130, 130, 50,50);
		b6.setVisible(true);
		panel_inferior.add(b6);
		b6.addMouseListener(this);

		//Criando o botão 1
		b1 = new JButton("1");
		b1.setBounds(10, 190, 50,50);
		b1.setVisible(true);
		panel_inferior.add(b1);
		b1.addMouseListener(this);

		//Criando o botão 2
		b2 = new JButton("2");
		b2.setBounds(70, 190, 50,50);
		b2.setVisible(true);
		panel_inferior.add(b2);
		b2.addMouseListener(this);
		
		//Criando o botão 3
		b3 = new JButton("3");
		b3.setBounds(130, 190, 50,50);
		b3.setVisible(true);
		panel_inferior.add(b3);
		b3.addMouseListener(this);
		
		//Criando o botão 0
		b0 = new JButton("0");
		b0.setBounds(10, 250, 50,50);
		b0.setVisible(true);
		panel_inferior.add(b0);
		b0.addMouseListener(this);
		
		//Criando o botão Virgula
		bVirgula = new JButton(",");
		bVirgula.setBounds(70, 250, 50,50);
		bVirgula.setVisible(true);
		panel_inferior.add(bVirgula);
		bVirgula.addMouseListener(this);
		
		//Criando o botão Ponto
		bPonto = new JButton(".");
		bPonto.setBounds(130, 250, 50,50);
		bPonto.setVisible(true);
		panel_inferior.add(bPonto);
		bPonto.addMouseListener(this);
		
		//Criando o botão Adição
		bAd = new JButton("+");
		bAd.setBounds(190, 70, 50,50);
		bAd.setVisible(true);
		panel_inferior.add(bAd);
		bAd.addMouseListener(this);

		//Criando o botão Subtração
		bSub = new JButton("-");
		bSub.setBounds(190, 130, 50,50);
		bSub.setVisible(true);
		panel_inferior.add(bSub);
		bSub.addMouseListener(this);
		
		//Criando o botão Divisão
		bDiv = new JButton("/");
		bDiv.setBounds(190, 190, 50,50);
		bDiv.setVisible(true);
		panel_inferior.add(bDiv);
		bDiv.addMouseListener(this);
		
		//Criando o botão Multiplicação
		bMult = new JButton("*");
		bMult.setBounds(190, 250, 50,50);
		bMult.setVisible(true);
		panel_inferior.add(bMult);
		bMult.addMouseListener(this);
		
		//Criando o botão Adição de memoria
		limpar = new JButton("C");
		limpar.setBounds(250, 70, 60,170);
		limpar.setVisible(true);
		panel_inferior.add(limpar);
		limpar.addMouseListener(this);
		
		//Criando o botão Igual
		bIgual = new JButton("=");
		bIgual.setBounds(250, 250, 60,50);
		bIgual.setVisible(true);
		panel_inferior.add(bIgual);
		bIgual.addMouseListener(this);
		
    	repaint(); 
		
	}

	
	@SuppressWarnings("rawtypes")
	@Override 
	
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==bSub)
		{
			operadorSelecionado = "subtracao";
			textoResultado.setText(textoResultado.getText()+"-");
			cont++;
		}
		else if (e.getSource()==bAd)
		{
			operadorSelecionado = "adicao";
			textoResultado.setText(textoResultado.getText()+"+");
			cont++;
		}
		else if(e.getSource() == bDiv)
		{
			operadorSelecionado = "divisao";
			textoResultado.setText(textoResultado.getText()+"/");
			cont++;
		}
		else if(e.getSource() == bMult)
		{
			operadorSelecionado = "multiplicacao";
			textoResultado.setText(textoResultado.getText()+"*");
			cont++;
		}
		else if(e.getSource() == bPorc)
		{
			operadorSelecionado = "porcentagem";
			textoResultado.setText(textoResultado.getText()+"%");
			cont++;
		}
		else if(e.getSource() == bFat)
		{
			operadorSelecionado = "fatorial";
			textoResultado.setText(textoResultado.getText()+"!");
			cont++;
		}
		else if(e.getSource() == bExp)
		{
			operadorSelecionado = "exponenciacao";
			textoResultado.setText(textoResultado.getText()+"^");
			cont++;
		}
		else if(e.getSource() == bRaiz)
		{
			operadorSelecionado = "raiz";
			textoResultado.setText(textoResultado.getText()+"²√");
			cont++;
		}
		
		//_____________________BOTÃO IGUAL____________________
		else if(e.getSource()==bIgual) //Gatilho
		{
			cont = 0;
			
			if(operadorSelecionado=="adicao")
			{
				textoResultado.setText(num1+num2+"");
		
			}
			
			if(operadorSelecionado == "subtracao")
			{
				textoResultado.setText(num1-num2+"");
			}
			
			if(operadorSelecionado == "divisao")
			{
				textoResultado.setText(num1/num2+"");
			}
			
			if(operadorSelecionado == "multiplicacao")
			{
				textoResultado.setText(num1*num2+"");
			}
			
			if(operadorSelecionado == "divisao" && num2 == 0)
			{
				textoResultado.setText("ERRO (DIVISÃO POR ZERO)");
			}
			
			if(operadorSelecionado == "porcentagem")
			{
				double resul = (num1*num2)/100;
				textoResultado.setText(String.valueOf(((resul))));
			}
			
			if(operadorSelecionado == "fatorial")
			{
				double resul = 0, fat = 0;
					resul = fat * (num1 - 1);
					num1--;
			
				if (num1 < 1)
				{
					resul = 1;
				}
				
				textoResultado.setText(String.valueOf(((resul))));
			}
			
			if(operadorSelecionado == "exponenciacao")
			{
				textoResultado.setText(Math.pow(num1,2)+"");
			}
			
			if(operadorSelecionado == "raiz")
			{
				double result = Math.sqrt(num1);
				
				textoResultado.setText( String.valueOf(result));
			}
		}
		
		//________________________________________________________________
		
		
		 if (e.getSource()==b1 && cont == 0 && operadorSelecionado == null)
		{
			
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"1"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
		}
		else if (e.getSource()==b1 && cont == 1 && !(operadorSelecionado == null))
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"1"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		
		//___________________________________________
		
		if(e.getSource()==b2 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"2"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}	
		else if(e.getSource()==b2 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"2"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//_______________________________________________
		
		if(e.getSource()==b3 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"3"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource()==b3 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"3"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		
		//__________________________________________________
		
		if(e.getSource() == b4 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"4"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b4 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"4"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//____________________________________________________
		
		if(e.getSource() == b5 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"5"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b5 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"5"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//________________________________________________________
		
		if(e.getSource() == b6 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"6"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b6 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"6"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//________________________________________________________
		
		if(e.getSource() == b7 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"7"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b7 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"7"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//_________________________________________________________
		
		if(e.getSource() == b8 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"8"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b8 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"8"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//__________________________________________________________
		
		if(e.getSource() == b9 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"9"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b9 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"9"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//____________________________________________________________
		
		if(e.getSource() == b0 && cont == 0)
		{
			numeroConcatenado = (Integer.parseInt(numeroConcatenado +"0"));
			num1 = (Integer.parseInt(num1 +""+numeroConcatenado+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado+"");
			numeroConcatenado = 0;
			
		}else if(e.getSource() == b0 && cont == 1)
		{
			numeroConcatenado2 = (Integer.parseInt(numeroConcatenado2 +"0"));
			num2 = (Integer.parseInt(num2 +""+ numeroConcatenado2+""));
			textoResultado.setText(textoResultado.getText()+numeroConcatenado2+"");
			numeroConcatenado2 = 0;
		}
		//________________________________________________________________
		
		//_______________________Botao limpar_____________________________
		
		if(e.getSource() == limpar)
		{
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

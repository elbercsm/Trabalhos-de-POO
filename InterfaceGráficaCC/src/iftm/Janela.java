package iftm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import clientes.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

// Janela utiliza a classe JFrame
// EXTENDS herda tudo da classe JFrame..

public class Janela extends JFrame 
{
	//Declarando Componentes como Atributos
	JLabel lblNome, lblIdade;
	JTextField txtNome, txtIdade;
	JButton btnEnviar, btnListar;
	
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	//Construtor
	public Janela()
	{
		//Definindo o tamanho da janela
		this.setSize(800, 600);
		
		//Definindo o layout dos componentes
		//Como os componentes ir�o se organizar na tela
		//null: nenhum layout ser� utilizado
		this.setLayout(null);
		
		//Definindo o comportamento do bot�o fechar da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//T�tulo da janela
		this.setTitle("Minha Janela");
		
		//Inserir os outros componentes aqui...
		this.criaComponentes();
		this.criaAcoes();
		
		//Exibindo a janela
		//DEVE SER O �LTIMO COMANDO DO M�TODO
		this.setVisible(true);	
	}
	
	private void criaComponentes()
	{
		//Criando uma nova inst�ncia de um Label (Texto n�o edit�vel)
		lblNome = new JLabel("Nome: ");
		//Definindo a posi��o : x, y, largura, altura
		lblNome.setBounds(10, 10, 100, 25);
		//Adicionando componente na janela
		this.add(lblNome);
		
		//___________________________________________
		
		//Texto edit�vel: TextField
		 txtNome = new JTextField();
		//Definindo a posi��o: x, y, largura, altura
		txtNome.setBounds(10,35,100, 25);
		//Adicionando componente a janela
		this.add(txtNome);
		
		//_____________________________________________
		
		//Criando uma nova inst�ncia
		lblIdade = new JLabel("Idade: ");
		lblIdade.setBounds(10, 60, 100, 25);
		this.add(lblIdade);
		
		//Texto Edit�vel
	    txtIdade = new JTextField();
		txtIdade.setBounds(10, 85, 70, 25);
		this.add(txtIdade);
		
		//______________________________________________
		
		//Criando um bot�o enviar
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 120, 90, 25);
		this.add(btnEnviar);
		
		//Criando um bot�o Listar
		btnListar = new JButton("Listar");
		btnListar.setBounds(110, 120, 90, 25);
		this.add(btnListar);
		
	}
	
	private void criaAcoes()
	{
		//Criando uma a��o para o bot�o enviar
		//_________________________________________
		
		//Listener - vem de ouvinte
		//Listener vai vigiar a a��o do bot�o enviar
		//Vai avisar que ocorreu uma a��o, mas n�o sabe que a��o foi 
		//essa.
		//Listener an�nimo, um objeto que n�o tem nome.
		//ActionListener - � uma classe de interface.
		//____________________________________________
		
		btnEnviar.addActionListener(new ActionListener() 
		{
			@Override
			//e � uma vari�vel, onde vai conter qual o tipo de evento que aconteceu.
			//Informa as informa��es do evento. 
			public void actionPerformed(ActionEvent e) 
			{
				String nome = txtNome.getText();
				int idade = Integer.parseInt(txtIdade.getText()); //Converte String para int
				boolean maior = idade >= 18 ? true : false;
				
				//Cria um novo cliente com suas caracteristicas
				Cliente cli = new Cliente(nome, idade, maior);
				
				//Listar o cliente adicionado..
				listaClientes.add(cli);
				
				//LIMPAR FORMUL�RIO
				txtNome.setText("");
				txtIdade.setText("");
				
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
				
				
				/*String msg = "Ol�, " +nome + "\n";
				if(idade >= 18)
				{
					msg += "Voc� � maior de idade.";
				}else
				{
					msg += "Voc� � menor de idade.";
				}*/
				
				//Janela m�e = null, mensagem = msg , t�tulo = Alerta, tipo da mensagem = INFORMATTION_MESSAGE...
				//JOptionPane.showMessageDialog(null, msg, "Alerta", JOptionPane.INFORMATION_MESSAGE);
				
				//e.getSource() retorna o elemento que disparou o evento (no caso o btnEnviar)
				//if(e.getSource() == btnEnviar)
				//	System.out.println("Clicou no btnEnviar");
				
				//System.out.println(e.getSource());
			}
		});
		
		btnListar.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String msg = "Lista de Clientes:\n";
						
						//listaClientes.size() � o tamanho da lista..
						//Lista cliente guarda o tipo de dado cliente..
						for(int i = 0; i < listaClientes.size(); i++)
						{
							Cliente cli = listaClientes.get(i);
							msg += cli.getNome() + "\n";
						}
						
						JOptionPane.showMessageDialog(null, msg);
					}
					
				});
	}
	
}

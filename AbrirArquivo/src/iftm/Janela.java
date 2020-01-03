package iftm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Janela extends JFrame
{
	JLabel lblFoto, lblImagem, lblNomes;
	JButton btnProcurar, btnRemover;
	JList jlistNomes;
	JFileChooser fc;
	DefaultListModel model;
	
	public Janela()
	{
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Abrir Arquivos");
		this.setLayout(null);
		
		criaComponentes();
		criaAcoes();
		abrirImagem();

		this.setVisible(true);
	}
	
	public void criaComponentes()
	{
		//Abrir arquivo
		lblFoto = new JLabel("Foto:");
		lblFoto.setBounds(10, 10, 100,25);
		this.add(lblFoto);
		
		//Inserindo imagem manualmente
		ImageIcon imagem = new ImageIcon("img/cachorro.jpg");
		
		lblImagem = new JLabel(imagem);
		lblImagem.setBounds(10, 35,300, 300);
		this.add(lblImagem);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(110, 345, 100, 25);
		this.add(btnProcurar);
		
		//Tratamento de Exce��es
		lblNomes = new JLabel("Lista de Nomes");
		lblNomes.setBounds(350, 10, 200, 25);
		this.add(lblNomes);
		
		//Modelo de lista padr�o
		model = new DefaultListModel();
		model.addElement("Amora");
		model.addElement("Banana");
		model.addElement("Caqui");
		
		jlistNomes = new JList(model);
		jlistNomes.setBounds(350,35, 300, 300);
		this.add(jlistNomes);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(460, 345, 100, 25);
		this.add(btnRemover);
		
	}
	
	public void criaAcoes()
	{
		//Caixa de di�logo de procura de arquivos
		fc = new JFileChooser();
		
		btnProcurar.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Verifica se o usu�rio escolheu uma foto e clicou e Abrir na janela que se abriu
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					//Pega caminho completo do arquivo selicionado
					String caminho = fc.getSelectedFile().getAbsolutePath();
					//Cria uma imagem com o endere�o do arquivo selecionado
					ImageIcon img = new ImageIcon(caminho);
					//Define a imagem criada como a imagem do Label lbl Imagem
					lblImagem.setIcon(img);
				}
			}
		});
		
		
		btnRemover.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int indice = jlistNomes.getSelectedIndex();
				
				
				//Tenta execultar o comando
				try 
				{
					model.remove(indice);
					
				//Cath: Em caso de exce��o, trata a exce��o
				} catch (ArrayIndexOutOfBoundsException ex)
				{
					JOptionPane.showMessageDialog(null, "N�o h� mais itens para remover");
					
				} catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO: "+ex);
				
				//Executa tanto em caso de sucesso quanto em caso de exce��o(serve para finalisar)
				} finally
				{
					
				}
				
			}
		});
	}


	private void abrirImagem()
	{
		File arquivo = new File("img/cachorro.jpg");
		
		try
		{
			BufferedImage img = ImageIO.read(arquivo);
			int w = img.getWidth();
			int h = img.getHeight();
			JOptionPane.showMessageDialog(null,"Dimes�es: "+w + " x " +h + " pixels");
			
		} catch (IOException ex)//IO e entrada e saida
		{
			JOptionPane.showMessageDialog(null,ex);
			//e.printStackTrace();
		}
		
	}

}
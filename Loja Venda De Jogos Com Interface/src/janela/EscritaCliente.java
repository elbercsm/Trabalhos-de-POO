package janela;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import principal.*;


//Criando arquivo para escrita....
public class EscritaCliente {
	
	public static  void escrever(Cliente cliente) {
		
		String conteudo = "";
		conteudo += cliente.getNome() + ";";
		conteudo += cliente.getIdade() + ";";
		conteudo += cliente.getEmail() + ";";
		conteudo += cliente.getBairro() + ";";
		conteudo += cliente.getEndereco() + ";";
		conteudo += cliente.getCep() + ";";
		conteudo += cliente.getNumeroCasa() + ";";
		conteudo += cliente.getTelefone() + ";";
		
		try {
			FileWriter fw = new FileWriter("./Arquivos/clientes.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(conteudo);
			out.close();
			System.out.println(conteudo);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void deletarArquivo()
	{
		File file = new File( "./Arquivos/clientes.txt" );
		file.delete();
	}
}
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
public class EscritaTelaCompras {
	
	public static  void escrever(Compra compra) {
		
		String conteudo = "";
		conteudo += compra.getNomeCliente() + ";";
		conteudo += compra.getTelefoneCliente() + ";";
		conteudo += compra.getCepCliente() + ";";
		conteudo += compra.getNomeJogo() + ";";
		conteudo += compra.getPrecoJogo() + ";";
		conteudo += compra.getQtdJogo() + ";";
		
		try {
			FileWriter fw = new FileWriter("./Arquivos/compras.txt",true);
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
		File file = new File( "./Arquivos/compras.txt" );
		file.delete();
	}
}
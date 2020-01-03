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
public class EscritaJogo {
	
	public static  void escrever(Jogo jogo) {
		
		String conteudo = "";
		conteudo += jogo.getNomeJogo() + ";";
		conteudo += jogo.getClassificacao() + ";";
		conteudo += jogo.getDataLancamento() + ";";
		conteudo += jogo.getGenero() + ";";
		conteudo += jogo.getPlataforma() + ";";
		conteudo += jogo.getPreco() + ";";
		conteudo += jogo.getImagem() + ";";
		
		try {
			FileWriter fw = new FileWriter("./Arquivos/jogos.txt",true);
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
		File file = new File( "./Arquivos/jogos.txt" );
		file.delete();
	}
}
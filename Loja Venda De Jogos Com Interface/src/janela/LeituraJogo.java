package janela;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.InternalFrameFocusTraversalPolicy;
import principal.Jogo;

public class LeituraJogo {

	public List<Jogo> getJogos()
	{
		//System.out.println("Entrou no getClientes (Leitura)");
		List<Jogo> jogos = new ArrayList<Jogo>();

		String[] valores;
		FileReader fileReader = null;
		//String conteudo = "";
		String linha;

		try {
			fileReader = new FileReader("Arquivos/jogos.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);

		try {
			while((linha = reader.readLine()) != null){

				Jogo jogo = new Jogo();
				valores = linha.split(";");

				System.out.println("Entrou Leitura: nome: "+valores[0]);
				//conteudo += ("Nome: " + valores[0] + "  idade: " + valores[1] + "  e-mail: " + valores[2]+ " Telefone: " + valores[3]);

				jogo.setNomeJogo(valores[0]);
				jogo.setClassificacao(valores[1]);
				jogo.setGenero(valores[2]);
				jogo.setPlataforma(valores[3]);
				jogo.setDataLancamento(valores[4]);
				jogo.setPreco(Integer.parseInt(valores[5]));
				jogo.setImagem(valores[6]);
				
				jogos.add(jogo);
			}
			fileReader.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(linha);

		return jogos;
	}
}

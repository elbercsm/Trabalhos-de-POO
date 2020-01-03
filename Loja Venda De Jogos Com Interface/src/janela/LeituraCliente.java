package janela;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import principal.Cliente;

public class LeituraCliente {

	public List<Cliente> getClientes()
	{
		System.out.println("Entrou no getClientes (Leitura)");
		List<Cliente> clientes = new ArrayList<Cliente>();

		String[] valores;
		FileReader fileReader = null;
		//String conteudo = "";
		String linha;

		try {
			fileReader = new FileReader("Arquivos/clientes.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);

		try {
			while((linha = reader.readLine()) != null){

				Cliente cliente = new Cliente();
				valores = linha.split(";");

				System.out.println("Entrou Leitura: nome: "+valores[0]);
				//conteudo += ("Nome: " + valores[0] + "  idade: " + valores[1] + "  e-mail: " + valores[2]+ " Telefone: " + valores[3]);

				cliente.setNome(valores[0]);
				cliente.setIdade(valores[1]);
				cliente.setEmail(valores[2]);
				cliente.setBairro(valores[3]);
				cliente.setEndereco(valores[4]);
				cliente.setCep(valores[5]);
				cliente.setNumeroCasa(valores[6]);
				cliente.setTelefone(valores[7]);

				clientes.add(cliente);
			}
			fileReader.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(linha);

		return clientes;
	}
}

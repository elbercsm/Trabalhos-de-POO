package classes;

import java.util.Scanner;

public class Lista 
{
	//Método main
	
	public static void main(String[] args)
	{
		//Declaração de variaveis
		
		String[] nome = new String[5];
		String[] idade = new String[5];
		String[] sexo = new String[5];
		
		//Vai garantir que apenas os contatos que não tenha aspas serão listados
		for(int i = 0; i < 5;i++)
		{
			nome[i] = "";
			idade[i] = "";
			sexo[i] = "";
		}
		
		//Declarando variavel opcao e continuar
		String opcao = "";
		String continuar = "";
		int posicao = 0;
		String nomeExcluir = "";
		
		//Declarando variavel entrada
		Scanner entrada = new Scanner(System.in); //variavel do tipo scanner, (faz leitura, "escuta" o teclado) 
		
		
		do 
		{
			System.out.println("|||||||||||||+++AGENDA+++|||||||||||||\n");
			System.out.println("Escolha uma das opções asseguir:\n[1] - Adicionar         [2] - Editar \n[3] - Remover           [4] - Buscar\n[5] - Sair\n");
			opcao = entrada.nextLine();
			
			switch (opcao) {
			case "1":
				//Código para adicionar
				
				do {
					
					System.out.print("Informe um nome: ");
					nome[posicao] = entrada.nextLine();       // usando a variavel entrada para obter os dados digitados no teclado
					
					System.out.print("Informe a idade: ");
					idade[posicao] = entrada.nextLine();      // usando a variavel entrada para obter os dados digitados no teclado
					
					System.out.print("Informe o sexo: ");
					sexo[posicao] = entrada.nextLine();       // usando a variavel entrada para obter os dados digitados no teclado
					
					System.out.print("Deseja cadastar outro contato?");
					continuar = entrada.nextLine();           // usando a variavel entrada para obter os dados digitados no teclado
					
					posicao++;//Incrementar a posição
					
				} while (continuar.equals("sim"));
				
				break;
				
			case "2":
				//Código para listar todos os contatos existentes
				
				System.out.println("Entre com o nome do contato que deseja editar?");
				String nomeEditar = entrada.nextLine();
				
				System.out.println("Entre com o novo nome do contato!");
				String nomeEditado = entrada.nextLine();
				System.out.println("Entre com o nova idade do contato!");
				String idadeEditado = entrada.nextLine();
				System.out.println("Entre com o novo sexo do contato!");
				String sexoEditado = entrada.nextLine();
				System.out.println("\n");
				
				
				for (int i = 0;i < 5;i++)
				{
					if(nome[i].equals(nomeEditar))//o equals verifica se contem a palavra na string.
					{
						nome[i] = "";
						idade[i] = "";
						sexo[i] = "";
						
						nome[i] = nomeEditado;
						idade[i] = idadeEditado;
						sexo[i] = sexoEditado;
						
						System.out.println("\nContato Alterado com Sucesso!!!!\n\n");
					}
				}
				
				
				break;
				
			case "3":
				//Código para Remover
				
				for(int i = 0; i < 5; i++)
				{
					if(!nome[i].equals(""))
					{
						System.out.println("______________________\nNome: "+nome[i] + "\nIdade:"+idade[i] + "\nSexo:"+sexo[i]+"\n______________________");
	
					}
				}
				
				break;
				
			case "4":
				//Código para buscar
				
				System.out.println("Entre com o nome do contato que deseja excluir?");
				nomeExcluir = entrada.nextLine();
				
				for (int i = 0;i < 5;i++)
				{
					if(nome[i].equals(nomeExcluir))//o equals verifica se contem a palavra na string.
					{
						nome[i] = "";
						idade[i] = "";
						sexo[i] = "";
					}
				}
				
				
				
				break;
				
			case "5":
				//Código para sair
				
				System.out.println("Programa Encerrado!!");
				return;
				
			default:
				//Opção Inválida
				
				System.out.println("Infelismente esta opção é inválida! Tente novamente.");
				break;
			}
			
		} while (!opcao.equals("Sair"));
		

	}

}

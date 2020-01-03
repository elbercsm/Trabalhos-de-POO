package clientes;

public class Cliente 
{
	private String nome;
	private int idade;
	private boolean maior;
	
	public Cliente(String pnome, int pidade, boolean pmaior)
	{
		this.nome = pnome;
		this.idade = pidade;
		this.maior = pmaior;
	}
	
	public void Imprimir()
	{
		System.out.println("Nome: "+this.nome);
		System.out.println("Idade: "+this.idade);
		System.out.println("Maior de Idade: "+(this.maior? "Sim" : "Não"));
		System.out.println("\n");
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isMaior() {
		return this.maior;
	}

	public void setMaior(boolean maior) {
		this.maior = maior;
	}
}

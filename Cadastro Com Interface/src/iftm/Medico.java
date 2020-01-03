package iftm;

public class Medico 
{
	private String nome;
	private int idade;
	private String sexo;
	private String tipo;
	private String descricao;
	private int percentualDePart;


	public int getPercentualDePart() {
		return percentualDePart;
	}
	public void setPercentualDePart(int percentualDePart) {
		this.percentualDePart = percentualDePart;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}

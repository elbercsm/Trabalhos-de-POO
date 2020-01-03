package Classes;

public class Paciente {

	
	private String nome;
	private String email;
	private String endereco;
	private String bairro;
	private String cep;
	private String numeroCasa;
	private String telefone;
	private String cpf;
	private String dataNascimento;
	private String genero;
	private int lvlDor;
	
	

	public Paciente(String nome, String email, String endereco, String bairro, String cep, String numeroCasa,
			String telefone, String cpf, String dataNascimento, String genero, int lvlDor) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.numeroCasa = numeroCasa;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.lvlDor = lvlDor;
	}
	
	
	public int getLvlDor() {
		return lvlDor;
	}

	public void setLvlDor(int lvlDor) {
		this.lvlDor = lvlDor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Paciente : \n\n"+nome+";\n"+email+";\n"+endereco+";\n"+bairro+";\n"+cep+";\n"+numeroCasa+";\n"+telefone+";\n"+cpf+";\n"+dataNascimento+";\n"+genero+";\n"+lvlDor+"\n";
	}
	
	
}

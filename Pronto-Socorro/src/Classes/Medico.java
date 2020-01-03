package Classes;

public class Medico {

	private String nomeMedico;
	private String emailMedico;
	private String genero;
	private String crm;
	private String especialidade;
	private String imagem;
	
	
	public Medico(String nomeMedico, String emailMedico, String genero, String crm, String especialidade,
			String imagem) {
		super();
		this.nomeMedico = nomeMedico;
		this.emailMedico = emailMedico;
		this.genero = genero;
		this.crm = crm;
		this.especialidade = especialidade;
		this.imagem = imagem;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	
	
	
	public String getEmailMedico() {
		return emailMedico;
	}
	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}
	
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	@Override
	public String toString() {
		return "Medico : \n"+nomeMedico+";\n"+emailMedico+";\n"+crm+";\n"+genero+";\n"+especialidade+";\n"+imagem+"\n";
	}
	
	
}

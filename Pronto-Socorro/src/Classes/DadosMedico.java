package Classes;

import java.util.ArrayList;


public class DadosMedico {

ArrayList<Medico> dadosMedico = new ArrayList<>();
	
	public ArrayList<Medico> getListaMedico(){
		return dadosMedico;
	}
	
	public Medico getMedico(int id) {
		return dadosMedico.get(id);
	}
	
	public void setListaMedico(ArrayList<Medico> dadosMedico) {
		this.dadosMedico = dadosMedico;
	}
	
	public void addMedico(Medico novoMedico) {
	
		dadosMedico.add(novoMedico);
	}
	public void editMedico(Medico novoMedico, int id) {
		dadosMedico.get(id).setNomeMedico(novoMedico.getNomeMedico());
		dadosMedico.get(id).setEmailMedico(novoMedico.getEmailMedico());
		dadosMedico.get(id).setCrm(novoMedico.getCrm());
		dadosMedico.get(id).setGenero(novoMedico.getGenero());
		dadosMedico.get(id).setEspecialidade(novoMedico.getEspecialidade());
		dadosMedico.get(id).setImagem(novoMedico.getImagem());
	
	}
	
}

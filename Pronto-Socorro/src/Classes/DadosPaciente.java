package Classes;

import java.util.ArrayList;


public class DadosPaciente {

ArrayList<Paciente> dadosPaciente = new ArrayList<>();
	
	public ArrayList<Paciente> getListaPaciente(){
		return dadosPaciente;
	}
	
	public Paciente getPaciente(int id) {
		return dadosPaciente.get(id);
	}
	
	public void setListaPaciente(ArrayList<Paciente> dadosPaciente) {
		this.dadosPaciente = dadosPaciente;
	}
	
	public void addPaciente(Paciente novoPaciente) {
	
		dadosPaciente.add(novoPaciente);
	}
	
	public void editPaciente(Paciente novoPaciente, int id) {
		dadosPaciente.get(id).setNome(novoPaciente.getNome());
		dadosPaciente.get(id).setEndereco(novoPaciente.getEndereco());
		dadosPaciente.get(id).setBairro(novoPaciente.getBairro());
		dadosPaciente.get(id).setCep(novoPaciente.getCep());
		dadosPaciente.get(id).setCpf(novoPaciente.getCpf());
		dadosPaciente.get(id).setDataNascimento(novoPaciente.getDataNascimento());
		dadosPaciente.get(id).setEmail(novoPaciente.getEmail());
		dadosPaciente.get(id).setGenero(novoPaciente.getGenero());
		dadosPaciente.get(id).setLvlDor(novoPaciente.getLvlDor());
		dadosPaciente.get(id).setNumeroCasa(novoPaciente.getNumeroCasa());
		dadosPaciente.get(id).setTelefone(novoPaciente.getTelefone());
	}
}

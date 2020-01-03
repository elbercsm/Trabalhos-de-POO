package Classes;

public class Atendimento 
{
	private Medico medico;
	private Paciente paciente;

	
	public Atendimento(Medico pMedico, Paciente pPaciente) {
		medico = pMedico;
		paciente = pPaciente;
	}
	
	
	public Medico getMedico() {
		return this.medico;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
}

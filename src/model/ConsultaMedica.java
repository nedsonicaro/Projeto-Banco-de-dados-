package model;

import java.util.Date;

public class ConsultaMedica extends GenericModel {
	private Date dt_consulta;
	private String nm_atendimento;
	private int paciente_id;
	private int medico_id;
	
	public ConsultaMedica(Long id, Date dt_consulta, String nm_atendimento, int paciente_id, int medico_id) {
		super();
		this.dt_consulta = dt_consulta;
		this.nm_atendimento = nm_atendimento;
		this.paciente_id = paciente_id;
		this.medico_id = medico_id;
	}

	public ConsultaMedica(Date dt_consulta, String nm_atendimento, int paciente_id, int medico_id) {
		super();
		this.dt_consulta = dt_consulta;
		this.nm_atendimento = nm_atendimento;
		this.paciente_id = paciente_id;
		this.medico_id = medico_id;
	}



	public Date getDt_consulta() {
		return dt_consulta;
	}

	public void setDt_consulta(Date dt_consulta) {
		this.dt_consulta = dt_consulta;
	}

	public String getNm_atendimento() {
		return nm_atendimento;
	}

	public void setNm_atendimento(String nm_atendimento) {
		this.nm_atendimento = nm_atendimento;
	}

	public int getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}

	public int getMedico_id() {
		return medico_id;
	}

	public void setMedico_id(int medico_id) {
		this.medico_id = medico_id;
	}

	@Override
	public String toString(){
		return "ConsultaMedica: {" +
				"dt_consulta: " + dt_consulta +
				"nm_atendimento: " + nm_atendimento +
				"paciente_id: " + paciente_id +
				"medico_id: " + medico_id;
	}
}

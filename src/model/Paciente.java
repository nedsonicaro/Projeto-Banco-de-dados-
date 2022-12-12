package model;

import java.util.Date;

public class Paciente extends GenericModel {
	private String nome;
	private Date dt_nascimento;
	
	
	public Paciente(Long id, String nome, Date dt_nascimento) {
		this.nome = nome;
		this.dt_nascimento = dt_nascimento;
		super.setId(id);;
	}


	public Paciente(String nome, Date dt_nascimento) {
		super();
		this.nome = nome;
		this.dt_nascimento = dt_nascimento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDt_nascimento() {
		return dt_nascimento;
	}


	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	@Override
	public String toString() {
		return "Paciente {"
				+ "id= " + this.getId() + "\'"
						+ "Nome: " + this.nome + "\'" +
						"Data de nascimento: " + this.dt_nascimento;	
	}
	
}

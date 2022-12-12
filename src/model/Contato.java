package model;

public class Contato extends GenericModel{
	private String telefone;
	private int laboratorio_id;
	
	public Contato(Long id, String telefone, int laboratorio_id) {
		this.telefone = telefone;
		this.laboratorio_id = laboratorio_id;
		super.setId(id);;
	}

	public Contato(String telefone, int laboratorio_id) {
		super();
		this.telefone = telefone;
		this.laboratorio_id = laboratorio_id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(int laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

	@Override
	public String toString() {
		return "Contato: {" +
				"telefone: " + telefone +
				"laboratorio_id: " + laboratorio_id;
	}
}

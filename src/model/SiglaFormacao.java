package model;

public class SiglaFormacao extends GenericModel {
	private String sigla;
	
	public SiglaFormacao(Long id, String sigla) {
		this.sigla = sigla;
		super.setId(id);;
	}
	
	public SiglaFormacao(String sigla) {
		super();
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public String toString() {
		return "SiglaFormacao {"
				+ "id= " + this.getId() + "\'"
						+ "Sigla: " + this.sigla;
	}
}

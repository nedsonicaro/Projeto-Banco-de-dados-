package model;

public class Laudo extends GenericModel {
	private String assinaturaDigital;
	private String dt_resultado;
	private String codigo;
	private int solicitacao_exame_id;
	
	public Laudo(Long id, String assinaturaDigital, String dt_resultado, String codigo, int solicitacao_exame_id) {
		this.assinaturaDigital = assinaturaDigital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
		this.solicitacao_exame_id = solicitacao_exame_id;
		super.setId(id);
	}
	
	public Laudo(String assinaturaDigital, String dt_resultado, String codigo, int solicitacao_exame_id) {
		super();
		this.assinaturaDigital = assinaturaDigital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
		this.solicitacao_exame_id = solicitacao_exame_id;
	}

	public String getAssinaturaDigital() {
		return assinaturaDigital;
	}

	public void setAssinaturaDigital(String assinaturaDigital) {
		this.assinaturaDigital = assinaturaDigital;
	}

	public String getDt_resultado() {
		return dt_resultado;
	}

	public void setDt_resultado(String dt_resultado) {
		this.dt_resultado = dt_resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getSolicitacao_exame_id() {
		return solicitacao_exame_id;
	}

	public void setSolicitacao_exame_id(int solicitacao_exame_id) {
		this.solicitacao_exame_id = solicitacao_exame_id;
	}

	@Override
	public String toString() {
		return "Laudo:  { "+
				"assinaturaDigital: " + assinaturaDigital +
				"dt_resultado: " + dt_resultado +
				"codigo: " + codigo +
				"solicitacao_exame_id: " + solicitacao_exame_id;
	}
}

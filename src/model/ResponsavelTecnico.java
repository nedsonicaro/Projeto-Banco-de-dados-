package model;

public class ResponsavelTecnico extends GenericModel {
	private String nome;
	private String conselho;
	private String formacao;
	private int sigla_formacao_id;
	
	public ResponsavelTecnico(Long id, String nome, String conselho, String formacao, int sigla_formacao_id) {
		this.nome = nome;
		this.conselho = conselho;
		this.formacao = formacao;
		this.sigla_formacao_id = sigla_formacao_id;
		super.setId(id);
	}
	
	public ResponsavelTecnico(String nome, String conselho, String formacao, int sigla_formacao_id) {
		super();
		this.nome = nome;
		this.conselho = conselho;
		this.formacao = formacao;
		this.sigla_formacao_id = sigla_formacao_id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getConselho() {
		return conselho;
	}
	
	public void setConselho(String conselho) {
		this.conselho = conselho;
	}
	
	public String getFormacao() {
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public int getSigla_formacao_id() {
		return sigla_formacao_id;
	}
	
	public void setSigla_formacao_id(int sigla_formacao_id) {
		this.sigla_formacao_id = sigla_formacao_id;
	}

	@Override
	public String toString() {
		return "Responsável Tecnico [nome=" 
				+ nome 
				+ ", conselho=" + conselho 
				+ ", formacao=" + formacao 
				+ ", sigla_formacao=" + sigla_formacao_id
				+ "]";
	}
}

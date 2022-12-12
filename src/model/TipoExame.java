package model;

public class TipoExame extends GenericModel {
	private String descricao;
	private String observacao;

	public TipoExame(Long id, String descricao, String observacao) {
		this.descricao = descricao;
		this.observacao = observacao;
		super.setId(id);
	}	
	
	public TipoExame(String descricao, String observacao) {
		super();
		this.descricao = descricao;
		this.observacao = observacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "TipoExame [descricao=" + descricao + ", observacao=" + observacao + "]";
	}
}

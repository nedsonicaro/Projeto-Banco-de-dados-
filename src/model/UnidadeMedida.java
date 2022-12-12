package model;

public class UnidadeMedida extends GenericModel {
	private String descricao;
	
	public UnidadeMedida(Long id, String descricao) {
		this.descricao = descricao;
		super.setId(id);
	}

	public UnidadeMedida(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "UnidadeMedida{" +
				"descricao='" + descricao + '\'' +
				'}';
	}
}

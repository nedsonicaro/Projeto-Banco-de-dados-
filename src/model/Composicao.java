package model;

public class Composicao extends GenericModel {
	private int exame_id;
	private int composicao_exame_id;
	private int valor_referencia_composicao_exame_id;
	
	public Composicao(Long id, int exame_id, int composicao_exame_id, int valor_referencia_composicao_exame_id) {
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
		super.setId(id);;
	}

	public Composicao(int exame_id, int composicao_exame_id, int valor_referencia_composicao_exame_id) {
		super();
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

	public int getComposicao_exame_id() {
		return composicao_exame_id;
	}

	public void setComposicao_exame_id(int composicao_exame_id) {
		this.composicao_exame_id = composicao_exame_id;
	}

	public int getValor_referencia_composicao_exame_id() {
		return valor_referencia_composicao_exame_id;
	}

	public void setValor_referencia_composicao_exame_id(int valor_referencia_composicao_exame_id) {
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
	}

	@Override
	public String toString(){
		return "Composiçaõ : { " +
				"exame_id: " + exame_id +
				"composicao_exame_id: " + composicao_exame_id +
				"valor_referencia_composicao_exame_id: " + valor_referencia_composicao_exame_id;
	}
}

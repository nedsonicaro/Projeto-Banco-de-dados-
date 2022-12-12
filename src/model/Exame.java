package model;

public class Exame extends GenericModel {
	private String descricao;
	private String metodo;
	private int material_exame_id;
	private int tipo_exame_id;
	
	public Exame(Long id, String descricao, String metodo, int material_exame_id, int tipo_exame_id) {
		this.descricao = descricao;
		this.metodo = metodo;
		this.material_exame_id = material_exame_id;
		this.tipo_exame_id = tipo_exame_id;
		super.setId(id);
	}

	public Exame(String descricao, String metodo, int material_exame_id, int tipo_exame_id) {
		super();
		this.descricao = descricao;
		this.metodo = metodo;
		this.material_exame_id = material_exame_id;
		this.tipo_exame_id = tipo_exame_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public int getMaterial_exame_id() {
		return material_exame_id;
	}

	public void setMaterial_exame_id(int material_exame_id) {
		this.material_exame_id = material_exame_id;
	}

	public int getTipo_exame_id() {
		return tipo_exame_id;
	}

	public void setTipo_exame_id(int tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
	}

	@Override
	public String toString(){
		return "Exame: { " +
				"descricao: " + descricao +
				"metodo: " + metodo +
				"material_exame_id" + material_exame_id +
				"tipo_exame_id: " + tipo_exame_id;
	}
}

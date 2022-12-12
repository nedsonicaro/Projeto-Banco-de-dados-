package model;

import java.util.Date;

public class ResultadoExame extends GenericModel {
	private Date dt_exame;
	private String valor;
	private int composicao_id;
	private int laudo_id;
	
	public ResultadoExame(Long id, Date dt_exame, String valor, int composicao_id, int laudo_id) {
		this.dt_exame = dt_exame;
		this.valor = valor;
		this.composicao_id = composicao_id;
		this.laudo_id = laudo_id;
		super.setId(id);
	}

	public ResultadoExame(Date dt_exame, String valor, int composicao_id, int laudo_id) {
		super();
		this.dt_exame = dt_exame;
		this.valor = valor;
		this.composicao_id = composicao_id;
		this.laudo_id = laudo_id;
	}

	public Date getDt_exame() {
		return dt_exame;
	}

	public void setDt_exame(Date dt_exame) {
		this.dt_exame = dt_exame;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getComposicao_id() {
		return composicao_id;
	}

	public void setComposicao_id(int composicao_id) {
		this.composicao_id = composicao_id;
	}

	public int getLaudo_id() {
		return laudo_id;
	}

	public void setLaudo_id(int laudo_id) {
		this.laudo_id = laudo_id;
	}

	@Override
	public String toString(){
		return "ResultadoExame: " +
				"dt_exame: " + dt_exame +
				"valor: " + valor +
				"composicao_id: " + composicao_id +
				"laudo_id: " + laudo_id;
	}
}


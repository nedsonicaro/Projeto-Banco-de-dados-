package model;

import java.util.Date;

public class SolicitacaoExame extends GenericModel {
	private String nm_prescrito;
	private Date dt_solicitacao;
	private int consulta_medica_id;
	private int habilitacao_exame_id;
	private int exame_id;
	
	public SolicitacaoExame(Long id, String nm_prescrito, Date dt_solicitacao, int consulta_medica_id, int habilitacao_exame_id,
			int exame_id) {
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
		this.consulta_medica_id = consulta_medica_id;
		this.habilitacao_exame_id = habilitacao_exame_id;
		this.exame_id = exame_id;
		super.setId(id);
	}

	public SolicitacaoExame(String nm_prescrito, Date dt_solicitacao, int consulta_medica_id, int habilitacao_exame_id,
			int exame_id) {
		super();
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
		this.consulta_medica_id = consulta_medica_id;
		this.habilitacao_exame_id = habilitacao_exame_id;
		this.exame_id = exame_id;
	}

	public String getNm_prescrito() {
		return nm_prescrito;
	}

	public void setNm_prescrito(String nm_prescrito) {
		this.nm_prescrito = nm_prescrito;
	}

	public Date getDt_solicitacao() {
		return dt_solicitacao;
	}

	public void setDt_solicitacao(Date dt_solicitacao) {
		this.dt_solicitacao = dt_solicitacao;
	}

	public int getConsulta_medica_id() {
		return consulta_medica_id;
	}

	public void setConsulta_medica_id(int consulta_medica_id) {
		this.consulta_medica_id = consulta_medica_id;
	}

	public int getHabilitacao_exame_id() {
		return habilitacao_exame_id;
	}

	public void setHabilitacao_exame_id(int habilitacao_exame_id) {
		this.habilitacao_exame_id = habilitacao_exame_id;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

	@Override
	public String toString() {
		return "SolicitacaoExame{" +
				"nm_prescrito='" + nm_prescrito + '\'' +
				", dt_solicitacao=" + dt_solicitacao +
				", consulta_medica_id=" + consulta_medica_id +
				", habilitacao_exame_id=" + habilitacao_exame_id +
				", exame_id=" + exame_id +
				'}';
	}
}


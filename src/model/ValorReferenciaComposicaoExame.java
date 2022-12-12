package model;

public class ValorReferenciaComposicaoExame extends GenericModel {
	private String valor_minimo;
	private String valor_maximo;
	private String limitador_minimo;
	private String limitador_maximo;
	private int unidade_medida_id;
	
	public ValorReferenciaComposicaoExame(Long id, String valor_minimo, String valor_maximo, String limitador_minimo,
			String limitador_maximo, int unidade_medida_id) {
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
		this.limitador_minimo = limitador_minimo;
		this.limitador_maximo = limitador_maximo;
		this.unidade_medida_id = unidade_medida_id;
		super.setId(id);
	}
	
	public ValorReferenciaComposicaoExame(String valor_minimo, String valor_maximo, String limitador_minimo,
			String limitador_maximo, int unidade_medida_id) {
		super();
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
		this.limitador_minimo = limitador_minimo;
		this.limitador_maximo = limitador_maximo;
		this.unidade_medida_id = unidade_medida_id;
	}

	public String getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(String valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public String getValor_maximo() {
		return valor_maximo;
	}

	public void setValor_maximo(String valor_maximo) {
		this.valor_maximo = valor_maximo;
	}

	public String getLimitador_minimo() {
		return limitador_minimo;
	}

	public void setLimitador_minimo(String limitador_minimo) {
		this.limitador_minimo = limitador_minimo;
	}

	public String getLimitador_maximo() {
		return limitador_maximo;
	}

	public void setLimitador_maximo(String limitador_maximo) {
		this.limitador_maximo = limitador_maximo;
	}

	public int getUnidade_medida_id() {
		return unidade_medida_id;
	}

	public void setUnidade_medida_id(int unidade_medida_id) {
		this.unidade_medida_id = unidade_medida_id;
	}

	@Override
	public String toString() {
		return "ValorReferenciaComposicaoExame{" +
				"valor_minimo='" + valor_minimo + '\'' +
				", valor_maximo='" + valor_maximo + '\'' +
				", limitador_minimo='" + limitador_minimo + '\'' +
				", limitador_maximo='" + limitador_maximo + '\'' +
				", unidade_medida_id=" + unidade_medida_id +
				'}';
	}
}
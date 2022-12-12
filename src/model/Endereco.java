package model;

public class Endereco extends GenericModel {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private int laboratorio_id;
	
	public Endereco(Long id, String rua, String numero, String complemento, String bairro, String cep, String cidade,
			int laboratorio_id) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.laboratorio_id = laboratorio_id;
		super.setId(id);
	}

	public Endereco(String rua, String numero, String complemento, String bairro, String cep, String cidade,
			int laboratorio_id) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.laboratorio_id = laboratorio_id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(int laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

	@Override
	public String toString(){
		return "Endereco: {" +
				"rua: " + rua +
				"numero: " + numero +
				"complemento: " + complemento +
				"bairro: " + bairro +
				"cep: " + cep +
				"cidade: " + cidade +
				"laboratorio_id: " + laboratorio_id;
	}
}

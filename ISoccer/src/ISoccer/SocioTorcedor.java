package ISoccer;

public class SocioTorcedor extends Pessoa {
	private String endereco;
	private String categoria;
	private double valordecontribuicao;
	private Boolean adimplente;
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getValordecontribuicao() {
		return valordecontribuicao;
	}
	public void setValordecontribuicao(double valordecontribuicao) {
		this.valordecontribuicao = valordecontribuicao;
	}
	public Boolean getAdimplente() {
		return adimplente;
	}
	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;
	}
}

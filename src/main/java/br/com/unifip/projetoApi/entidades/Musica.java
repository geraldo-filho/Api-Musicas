package br.com.unifip.projetoApi.entidades;

public class Musica {
	
	private String nome;
	private double tempoDuracao;
	private int anoLancamento;
	
	public Musica(String nome, double tempoDuracao, int anoLancamento) {
		this.nome = nome;
		this.tempoDuracao = tempoDuracao;
		this.anoLancamento = anoLancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(double tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	
 
	
}

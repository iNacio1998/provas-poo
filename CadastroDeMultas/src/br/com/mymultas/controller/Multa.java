package br.com.mymultas.controller;

public class Multa implements MultaInterface{
	
	private String cnh, placa, proprietario, infracao;
	private int gravidade, pontos;
	private float valor;
	
	public Multa(){}
	
	public Multa(String cnh, String placa, String pr, String i, int g){
		this.cnh = cnh;
		this.placa = placa;
		this.proprietario = pr;
		this.infracao = i;
		this.gravidade = g;
		setPointValue();
	}
	
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getInfracao() {
		return infracao;
	}

	public void setInfracao(String infracao) {
		this.infracao = infracao;
	}

	public int getGravidade() {
		return gravidade;
	}

	public void setGravidade(int gravidade) {
		this.gravidade = gravidade;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int sumPoints(Multa m1) {
		if (m1 != null) return this.getPontos() + m1.getPontos();
		return 0;
	}

	@Override
	public int sumPoints(Multa m1, Multa m2) {
		if (m1 != null && m2 != null) 
			return this.getPontos() + m1.getPontos() + m2.getPontos();
		return 0;
	}

	@Override
	public Multa copy() {
		Multa tmp = new Multa();
		tmp.setCnh(this.getCnh());
		tmp.setGravidade(this.getGravidade());
		tmp.setInfracao(this.getInfracao());
		tmp.setProprietario(this.getProprietario());
		tmp.pontos = this.pontos;
		tmp.valor = this.valor;
		return tmp;
	}

	@Override
	public void setPointValue() {
		switch (this.gravidade) {
			case 1:
				this.pontos = 3;
				this.valor = 53.2f;
				break;
			
			case 2:
				this.pontos = 4;
				this.valor = 85.13f;
				break;
				
			case 3:
				this.pontos = 5;
				this.valor = 127.69f;
				break;
				
			case 4:
				this.pontos = 7;
				this.valor = 574.62f;
				break;
				
		}
	}

	@Override
	public String print() {
		return "Multa de Transito:" 
				+ "\nCNH: " + this.getCnh()
				+ "\nProprietario: " + this.getProprietario()
				+ "\nPlaca: " + this.getPlaca()
				+ "\nDescrição da Inflação: " + this.getInfracao() 
				+ "\nPontos: " + this.getPontos()
				+ "\nValor da Multa: " + this.getValor() + "\n=================================";
		
	}

}

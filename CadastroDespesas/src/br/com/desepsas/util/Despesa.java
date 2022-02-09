package br.com.desepsas.util;

public class Despesa {

	private String cedente, datapagamento;
	private int diaVencimento;
	private float valor;
	private int juros;
	private String situacao;
	private float valorF;
	
	public Despesa() {
		
	}
	
	public Despesa(String ced, int diaVencimento, float valor) {
		this.cedente = ced;
		this.diaVencimento = diaVencimento;
		this.valor = valor;
	}
	
	public void setCedente(String c) {
		this.cedente = c;
	}
	
	public String getCedente() {
		return this.cedente;
	}
	
	public void setDataPagamento(String dpg) {
		this.datapagamento = dpg;
	}
	
	public String getDataPagamento() {
		return this.datapagamento;
	}
	
	public void setDiaVencimento(int diaVenc) {
		this.diaVencimento = diaVenc;
	}
	
	public int getDiaVencimento() {
		return this.diaVencimento;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return this.valor;
	}
	
	public void setJuros(int juros) {
		this.juros = juros;
	}
	
	public int getJuros() {
		return this.juros;
	}
	
	public float calculaValorFinal(int diaAtual) {
		float calculo;
		defineJuros(diaAtual);
		if(diaAtual > diaVencimento) {
			calculo = (this.valor / 100) * this.juros;
			this.valorF = this.valor + calculo;
			return valorF;
		}else {
			return this.valor;
		}
	}
	
	public float totalizarDespesas(Despesa desp1, Despesa desp2, int hoje) {
		return this.calculaValorFinal(hoje) + desp1.calculaValorFinal(hoje) + desp2.calculaValorFinal(hoje);
	}
	
	public void defineJuros(int diaAtual) {
		int diff = (diaVencimento - diaAtual);
		diff = (diff < 0) ? diff * -1: diff * 1; 
		
		
		if (diaAtual > diaVencimento) {
			if (diff <= 5) {
				this.juros = 0;
			}else if(diff > 6 && diff <= 10) {
				this.juros = 5;
			}else if(diff >= 11 && diff <= 15) {
				this.juros = 10;
			}else if (diff >=15){this.juros = 20;}
			
			System.out.println(diff);
		}
		

		
		situacao = (diaAtual > diaVencimento) ? "Pagamento vencido" : "Pagamento em aberto";
		
	}

	public String print() {
		return "-------------------------------------------------"
				+ "\nDespesa: " 
				+ "\nCedente: " + getCedente()
				+ "\nVencimento: " + getDiaVencimento()
				+ "\nValor: " + getValor()
				+ "\nValor Final: " + valorF
				+ "\nJuros: " + getJuros() + "%\n" 
				+ situacao + "\n" 
				+ "-------------------------------------------------";
	}
	
	public String print(int hoje) {
		return "-------------------------------------------------"
				+ "\nDespesa: " 
				+ "\nCedente: " + getCedente()
				+ "\nVencimento: " + getDiaVencimento()
				+ "\nValor: " + getValor()
				+ "\nValor Final: " + valorF
				+ "\nJuros: " + getJuros()
				+ situacao + "\n" 
				+ "-------------------------------------------------";
	}
}

package br.com.mymultas.controller;

public interface MultaInterface {

	int sumPoints(Multa m1);
	
	int sumPoints(Multa m1, Multa m2);
	
	Multa copy();
	
	void setPointValue();
	
	String print();
	
}

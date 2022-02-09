package br.com.despesas.app;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.desepsas.util.Despesa;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String ced = sc.nextLine();
		int vencimento = sc.nextInt();
		float valor = sc.nextFloat();
		
		Despesa des = new Despesa(ced, vencimento, valor);

		des.calculaValorFinal(10);
		
		JOptionPane.showMessageDialog(null, des.print());
		System.out.println(des.getJuros());

		
		sc.close();
	}

}

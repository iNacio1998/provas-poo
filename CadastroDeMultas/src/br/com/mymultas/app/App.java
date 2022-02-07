package br.com.mymultas.app;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.mymultas.controller.Multa;

public class App {

	public static void main(String[] args) {
		
		Multa multa1 = new Multa("1257954", "CHB-024", "Gon Freecs", "Dirigindo enquanto usa o celular", 4);
		Scanner sc = new Scanner(System.in);
		
		Multa multa2 = null;
		String cnh = sc.next();
		String placa = sc.next();
		String proprietario = sc.next();
		String infracao = sc.next();
		int gravidade = sc.nextInt();
		
		if (gravidade <= 4) multa2 = new Multa(cnh, placa, proprietario, infracao, gravidade);

		Multa multa3 = multa1.copy();
		
		int totalPontos = multa1.sumPoints(multa2, multa3);
		System.out.println("O total de pontos é de: " + totalPontos);
		
		if (multa2 != null) {
			JOptionPane.showMessageDialog(null, "---------------------------Historico de Multas-------------------" 
				+ "\nMulta 01\n" + multa1.print()
				+ "\nMulta 02\n" + multa2.print()
				+ "\nMulta 02\n" + multa3.print());
		}else {
			JOptionPane.showMessageDialog(null, "---------------------------Historico de Multas-------------------" 
					+ "\nMulta 01\n" + multa1.print()
					+ "\nMulta 02\n" + multa3.print());
		}
	}

}

package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.saqueException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			int numero;
			String titular;
			double saldoInicial;
			double limiteSaque;
			
			System.out.println("Enter account data");
			System.out.print("Numero: ");
			numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.next(); //Limpa o buffer
			titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			saldoInicial = sc.nextDouble();
			System.out.print("Limite de saque:");
			limiteSaque = sc.nextDouble();
			
			Conta c = new Conta(numero, titular, saldoInicial, limiteSaque);
			
			System.out.println();
			System.out.print("Informe um valor para saque: ");
			double valorSaque = sc.nextDouble();
			
			c.sacar(valorSaque);
			System.out.println("Novo saldo: " + c.getSaldo());
		}
		catch (saqueException e) {
			System.out.println("Erro ao sacar: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro desconhecido");
		}

		
		sc.close();
	}

}

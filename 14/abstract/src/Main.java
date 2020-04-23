import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

import entities.PagadorDeImposto;
import entities.PagadorFisico;
import entities.PagadorJuridico;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<PagadorDeImposto> pagadoresDeImposto = new ArrayList<>();
		
		System.out.print("Informe o numero de pagadores de taxa: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Dados do pagador numero #%d:%n", i+1);
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			
			if (type == 'i') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Renda anual: ");
				double rendaAnual = sc.nextDouble();
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				pagadoresDeImposto.add( new PagadorFisico(nome, rendaAnual, gastosSaude) );	
			} else {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Renda anual: ");
				double rendaAnual = sc.nextDouble();
				System.out.print("Numero de funcionarios: ");
				int numeroFuncionarios = sc.nextInt();
				pagadoresDeImposto.add( new PagadorJuridico(nome, rendaAnual, numeroFuncionarios) );
			}
		}
		
		double total = 0.00;
		
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (int i = 0; i < n; i++) {
			PagadorDeImposto p = pagadoresDeImposto.get(i);
			System.out.printf("%s: $ %.2f%n", p.getNome(), p.imposto());
			total += p.imposto();
		}
		
		System.out.println();
		System.out.printf("TOTAL DE IMPOSTOS: $ %.2f", total);
		
		sc.close();
	}

}

package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		String dateString = sc.nextLine();
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int numInstallments = sc.nextInt();
		System.out.println("Installments:");
		*/
		
		int number = 8028;
		String dateString = "25/06/2018";
		double totalValue = 600.00;
		int numInstallments = 3;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		Contract contract = new Contract(number, date, totalValue);
		ContractService contractService = new ContractService(new PayPalService());
		contractService.processContract(contract, numInstallments);
		
		for (Installment installment : contract.getIntallments()) {
			System.out.println(installment.toString());
		}
		
	}

}

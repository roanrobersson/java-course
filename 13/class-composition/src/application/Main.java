package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name ");
		String wName = sc.nextLine();
		System.out.print("Level ");
		String wLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double wBaseSalary = sc.nextDouble();
		
		Worker worker = new Worker(wName, WorkerLevel.valueOf(wLevel), wBaseSalary, new Department(departmentName));
				
		System.out.println("How many contracts to this worker?");
		int contracts = sc.nextInt();
		
		for(int i = 0; i < contracts; i++) {
			System.out.printf("Enter contract #%d data:%n", i+1);
			System.out.print("Date (DD/MM/YYYY): ");
			String  dateString = sc.next();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(dateString);
			
			HourContract c = new HourContract(date, valuePerHour, duration);
			
			worker.addContract(c);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYearString = sc.next();

		int month = Integer.parseInt(monthAndYearString.substring(0, 2));
		int year = Integer.parseInt(monthAndYearString.substring(3));
		
		System.out.printf("Name: %s %n", worker.getName());
		System.out.printf("Department: %s %n", worker.getDepartment().getName());
		System.out.printf("Income for %s: %.2f %n", monthAndYearString, worker.income(year, month));

		sc.close();
	}

}

package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Maria", "maria@gmail.com", 3200.00));
		employees.add(new Employee("Alex", "alex@gmail.com", 1900.00));
		employees.add(new Employee("Marco", "marco@gmail.com", 1700.00));
		employees.add(new Employee("Bob", "bob@gmail.com", 3500.00));
		employees.add(new Employee("Anna", "anna@gmail.com", 2800.00));
		
		System.out.print("Enter salary: ");
		double inputValue = sc.nextDouble();
	
		Comparator<String> sortRule = (a, b) -> a.toUpperCase().compareTo(b.toUpperCase());
		List<String> filteredEmployeesEmail = employees.stream()
			.filter(e -> e.getSalary() > inputValue)
			.map(e -> e.getEmail())
			.sorted(sortRule)
			.collect(Collectors.toList());
		
		System.out.println("Email of people whose salary is more than " + inputValue);
		filteredEmployeesEmail.forEach(System.out::println);

		double sumOfSalary = employees.stream()
				.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
				.map(e -> e.getSalary())
				.reduce(0.0, (a, b) -> a + b);
		
		System.out.print("Sum of salary of people whose name starts with 'M': ");
		System.out.println(String.format("%.2f", sumOfSalary));
		
	}

}

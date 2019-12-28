package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = df.parse(sc.nextLine());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		
		System.out.print("How many items to this order? ");
		Order order = new Order(new Date(), orderStatus, client);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Enter #%d item data:%n", i + 1);
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY:");
		df.applyPattern("dd/MM/yyyy hh:mm:ss");
		System.out.printf("Order moment: %s%n", df.format(order.getMoment()));
		System.out.printf("Order status: %s%n", order.getStatus().toString());
		System.out.printf("Client: %s%n", client.toString());
		System.out.println("Order items:");
		for(OrderItem orderItem : order.getOrderItems()) {
			System.out.println(orderItem.toString());
		}
		System.out.printf("Total price: $%.2f%n", order.total());
		
		sc.close();
	}

}

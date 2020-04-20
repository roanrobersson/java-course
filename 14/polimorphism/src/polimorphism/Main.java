package polimorphism;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Product #%d data: ", i+1);
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (type == 'c') {
				products.add(new Product(name, price));
			}
			else if(type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else if(type == 'u') {
				System.out.print("Manufacture date  (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, date));
			}
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}

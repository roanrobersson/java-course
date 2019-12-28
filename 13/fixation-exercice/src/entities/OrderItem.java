package entities;

import java.text.SimpleDateFormat;

public class OrderItem {
	private int quantity;
	private double price;
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.price = product.getPrice();
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double subTotal() {
		return this.price * this.quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.product.getName() + ", ");
		sb.append("$" + String.format("%.2f", this.price)  + ", ");
		sb.append("Quantity: " + this.quantity + ", ");
		sb.append("Subtotal: $" + String.format("%.2f", this.subTotal()) );
		return sb.toString();
	}
}

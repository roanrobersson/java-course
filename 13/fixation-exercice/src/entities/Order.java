package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
			
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		this.orderItems.remove(orderItem);
	}
	
	public double total() {
		double t = 0;
		for(OrderItem i : this.orderItems) {
			t += i.subTotal();
		}
		return t;
	}
	
}

package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private Date manufactureDate;
	
	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return 
				this.name + " (used) $" + 
				String.format("%.2f", this.price) +
				" (Manufacture date: " + 
				 sdf.format(this.manufactureDate) +
				")";
	}
}

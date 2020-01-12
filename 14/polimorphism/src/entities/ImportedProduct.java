package entities;

public class ImportedProduct extends Product{
	private double customsFee;
	
	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return 
				this.name + " $ " + 
				String.format("%.2f", this.price + this.customsFee) +
				"(Customs fee: $ " + 
				String.format("%.2f", this.customsFee) +
				")";
	}
	
}

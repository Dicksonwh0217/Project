
public class AirConditioner extends Product{

	private String type;
	private double horsePower;
	private double noiseLevel;
	private double weight;
	private int warranty;
	
	public AirConditioner(int itemNumber, String name, String type, double horsePower, double noiseLevel, double weight, int warranty, int quantity, double price) {
		
		super(itemNumber,name, quantity, price);
		this.type = type;
		this.horsePower = horsePower;
		this.noiseLevel = noiseLevel;
		this.weight = weight;
		this.warranty = warranty;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(double horsePower) {
		this.horsePower = horsePower;
	}
	
	public double getNoiseLevel() {
		return noiseLevel;
	}
	
	public void setNoiseLevel(double noiseLevel) {
		this.noiseLevel = noiseLevel;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getWarranty() {
		return warranty;
	}
	
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	@Override
	public double totalInventoryValue() {
		return getPrice() * getQuantity();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Item number\t: " + super.getItemNumber() + "\n");
		sb.append("Product name\t: " + super.getName() + "\n");
		sb.append("Air Conditioner Type\t: " + getType() + "\n");
		sb.append("Horse Power\t: " + getHorsePower() + " hp\n");
		sb.append("Noise Level\t: " + getNoiseLevel() + " dbA\n");
		sb.append("Weight\t: " + getWeight() + " kg\n");
		sb.append("Warranty\t: " + getWarranty() + " Year(s)\n");
		sb.append("Quantity available\t: " + super.getQuantity() + "\n");
		sb.append("Price (RM)\t: " + super.getPrice() + "\n");
		sb.append("Inventory value (RM)\t: " + totalInventoryValue() + "\n");
		sb.append("Product status\t: " + super.isStatus() + "\n");
		
		return sb.toString();
	}
	
}

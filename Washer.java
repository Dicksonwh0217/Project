
public class Washer extends Product{

	private double height;
	private double width;
	private double depth;
	private double weight;
	private String color;
	
	public Washer(int itemNumber, String name, double height, double width, double depth, double weight, String color, int quantity, double price) {
		
		super(itemNumber,name, quantity, price);
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.color = color;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getDepth() {
		return depth;
	}
	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		sb.append("Height\t: " + getHeight() + " cm\n");
		sb.append("Width\t: " + getWidth() + " cm\n");
		sb.append("Depth\t: " + getDepth() + " cm\n");
		sb.append("Weight\t: " + getWeight() + " kg\n");
		sb.append("Color\t: " + getColor() + "\n");
		sb.append("Quantity available\t: " + super.getQuantity() + "\n");
		sb.append("Price (RM)\t: " + super.getPrice() + "\n");
		sb.append("Inventory value (RM)\t: " + totalInventoryValue() + "\n");
		sb.append("Product status\t: " + super.isStatus() + "\n");
		
		return sb.toString();
	}

	
	
}

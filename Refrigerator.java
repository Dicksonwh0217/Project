
public class Refrigerator extends Product{
	
	private String doorDesign;
	private String color;
	private double capacity;
	
	public Refrigerator(int itemNumber,String name,String doorDesign, 
			String color, double capacity, int quantity, double price) {
		
		super(itemNumber,name, quantity, price);
		this.doorDesign = doorDesign;
		this.color = color;
		this.capacity = capacity;
	}

	public String getDoorDesign() {
		return doorDesign;
	}

	public void setDoorDesign(String doorDesign) {
		this.doorDesign = doorDesign;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public int getQuantity() {
		return super.getQuantity();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Item number\t: "+super.getItemNumber()+"\n");
		sb.append("Product name\t: "+super.getName()+"\n");
		sb.append("Door design\t: "+getDoorDesign()+"\n");
		sb.append("Color\t: "+getColor()+"\n");
		sb.append("Capacity (in Litres)\t: "+getCapacity()+"\n");
		sb.append("Quantity available\t: "+super.getQuantity()+"\n");
		sb.append("Price (RM)\t: "+super.getPrice()+"\n");
		sb.append("Inventort value (RM)\t: "+totalInventoryValue()+"\n");
		sb.append("Product status\t: "+super.isStatus()+"\n");
		
		return sb.toString();
	}
}

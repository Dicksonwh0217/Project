
public abstract class Product {

	private int itemNumber, quantity;
	private String name;
	private double price;
	private boolean status;
	
	public Product() {
		this.status = true;
	}
	
	public Product(int itemNumber, String name, int quantity
			, double price) {
		this.itemNumber = itemNumber;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double totalInventoryValue() {
		return price * quantity;
	}
	
	public void addQuantity(int AddedQuantity) {
		if(status)
			quantity += AddedQuantity;
		else
			System.out.println("Cannot add stock to a discontinued product line.");
		
	}
	
	public void deductQuantity(int DeductedQuantity) {
		if(status)
			if(quantity >= DeductedQuantity)
				quantity-=DeductedQuantity;
			else
				System.out.println("Insufficient quantity available in stock.");
		else
			System.out.println("Cannot deduct stock to a discontinued product line.");
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Item number\t: "+itemNumber+"\n");
		sb.append("Product name\t: "+name+"\n");
		sb.append("Quantity available\t: "+quantity+"\n");
		sb.append("Price (RM)\t: "+price+"\n");
		sb.append("Inventort value (RM)\t: "+totalInventoryValue()+"\n");
		sb.append("Product status\t: "+isStatus()+"\n");
		
		return sb.toString();
	}
	
	
}

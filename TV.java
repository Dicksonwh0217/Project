
public class TV extends Product{
	
	private String screenType;
	private String resolution;
	private int displaySize;
	
	public TV(int itemNumber,String name,String screenType, 
			String resolution, int displaySize, int quantity, double price) {
		
		super(itemNumber,name, quantity, price);
		this.screenType = screenType;
		this.resolution = resolution;
		this.displaySize = displaySize;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Item number\t: "+super.getItemNumber()+"\n");
		sb.append("Product name\t: "+super.getName()+"\n");
		sb.append("Screen Type\t: "+getScreenType()+"\n");
		sb.append("Resolution\t: "+getResolution()+"\n");
		sb.append("Display size\t: "+getDisplaySize()+"inches\n");
		sb.append("Quantity available\t: "+super.getQuantity()+"\n");
		sb.append("Price (RM)\t: "+super.getPrice()+"\n");
		sb.append("Inventort value (RM)\t: "+totalInventoryValue()+"\n");
		sb.append("Product status\t: "+super.isStatus()+"\n");
		
		return sb.toString();
	}
}

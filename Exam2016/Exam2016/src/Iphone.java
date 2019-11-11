
public class Iphone extends AppleDevice{
	
	private String modemType;
	private boolean has3DTouch;
	
	
	public Iphone (String model, double screenSize, String cpu, String modemType,
					String color, String memory, boolean has3DTouch, int price) {
		super(model, screenSize, cpu, color, memory, price);
		this.modemType = modemType;
		this.has3DTouch = has3DTouch;
	}


	@Override
	public boolean equals(Object other) {
		
		if (other instanceof Iphone) {
			
			Iphone that = (Iphone) other;
			if (this.equalsDevice(that)
				&& this.has3DTouch == that.has3DTouch
				&& this.modemType.equals(that.modemType)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return "IPHONE " + this.getModel() + ", " + this.getScreenSize() + ", " + this.getCpu() + ", "
				+ this.modemType + ", " + this.getColor() + ", " + this.getMemory() + ", " + this.has3DTouch
				+ ", " + this.getPrice();
	}
	
	
	
	
	

}

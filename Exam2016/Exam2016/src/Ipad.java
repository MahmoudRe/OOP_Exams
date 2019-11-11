
public class Ipad extends AppleDevice {
	
	private boolean has4G;

	public Ipad(String model, double screenSize, String cpu, boolean has4G, String color, String memory, int price) {
		super(model, screenSize, cpu, color, memory, price);
		this.has4G = has4G;
	}

	@Override
	public boolean equals(Object other) {
		
		if (other instanceof Ipad) {
			
			Ipad that = (Ipad) other;
			if (this.equals(that)
				&& this.has4G == that.has4G) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "IPAD " + this.getModel() + ", " + this.getScreenSize() + ", " + this.getCpu() + ", "
				+ ", " + this.has4G + this.getColor() + ", " + this.getMemory() + ", " + this.getPrice();
	}
	
	
}

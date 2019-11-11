
public class ELECTRIC_CAR extends Car{
	
	private String battery;
	
	public ELECTRIC_CAR (String brand, String model, String power, String battery, String price) {
		super (brand, model, power, price);
		this.battery = battery;
	}
	
	public String toString () {
		return "ELECTRIC_CAR " + getBrand() + ", " + getModel() + ", "
			 + getPower() + ", " + battery + ", " + getPrice();
	}

	@Override
	public boolean equals(Object other) {
		
		if (other != null && other instanceof ELECTRIC_CAR) {
			ELECTRIC_CAR that = (ELECTRIC_CAR) other;
			return (this.getBrand().equals(that.getBrand()) && this.getModel().equals(that.getModel())
					&& this.battery.equals(that.battery)) && this.getPrice().equals(that.getPrice());
		}
		return false;
	}
	
	
}

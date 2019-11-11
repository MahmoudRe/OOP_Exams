
public class HYBRID_CAR extends Car{
	
	private String battery;
	private String displacement;
	
	public HYBRID_CAR (String brand, String model, String displacement,  String power, String battery, String price) {
		super (brand, model, power, price);
		this.battery = battery;
		this.displacement = displacement;
		
	}
	
	@Override
	public String toString () {
		return "HYBRID_CAR " + getBrand() + ", " + getModel() + ", "
			 + displacement + ", " + getPower() + ", " + battery + ", " + getPrice();
	}
	
	@Override
	public boolean equals(Object other) {
		
		if (other != null && other instanceof HYBRID_CAR) {
			HYBRID_CAR that = (HYBRID_CAR) other;
			return (this.getBrand().equals(that.getBrand()) && this.getModel().equals(that.getModel())
					&& this.displacement.equals(that.displacement)) && this.battery.equals(that.battery)
					&& this.getPrice().equals(that.getPrice());
		}
		return false;
	}
	
}

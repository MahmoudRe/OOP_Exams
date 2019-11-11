
public class GAS_CAR extends Car{
	
	private String displacement;
	
	public GAS_CAR (String brand, String model, String displacement, String power, String price) {
		super (brand, model, power, price);
		this.displacement = displacement;
	}
	
	@Override
	public String toString () {
		return "GAS_CAR " + getBrand() + ", " + getModel() + ", "
			 + displacement + ", " + getPower() + ", " + getPrice();
	}
	
	@Override
	public boolean equals(Object other) {
		
		if (other != null && other instanceof GAS_CAR) {
			GAS_CAR that = (GAS_CAR) other;
			return (this.getBrand().equals(that.getBrand()) && this.getModel().equals(that.getModel())
					&& this.displacement.equals(that.displacement)) && this.getPrice().equals(that.getPrice());
		}
		return false;
	}
}


public class Speedelec extends ElectricBike {
	
	/**
	 * Constructor of Speedelec class.
	 * @param brand The name of the brand of this bike
	 * @param maxSpeed The maximum speed (in km/h)
	 * @param weight The weight of the bike (in grams)
	 * @param lightAvailability The availability of lights at front and back
	 * @param batteryCapacity The battery capacity (in mAh)
	 * @param color The main color of this bike
	 * @param price The price of this bike
	 */
	public Speedelec(String brand, int maxSpeed, int weight, boolean lightAvailability, int batteryCapacity, String color, int price) {
		super(brand, maxSpeed, weight, lightAvailability, batteryCapacity, color, price);
	}

	@Override
	/**
	 * @return textual representation of ElectricBike instance.
	 */
	public String toString() {
		return "SPEEDELEC " + this.getBrand() + "; " 
				+ this.getMaxSpeed() + "; " 
				+ this.getWeight() + "; "
				+ this.isLightAvailability() + "; " 
				+ this.getBatteryCapacity() + "; "
				+ this.getColor() + "; " 
				+ this.getPrice();
	}

}


public class ElectricBike extends Bike {
	
	private int maxSpeed;
	private int batteryCapacity;
	
	/**
	 * Constructor of ElectricBike class.
	 * @param brand The name of the brand of this bike
	 * @param maxSpeed The maximum speed (in km/h)
	 * @param weight The weight of the bike (in grams)
	 * @param lightAvailability The availability of lights at front and back
	 * @param batteryCapacity The battery capacity (in mAh)
	 * @param color The main color of this bike
	 * @param price The price of this bike
	 */
	public ElectricBike(String brand, int maxSpeed, int weight, boolean lightAvailability, int batteryCapacity, String color, int price) {
		super(brand, weight, lightAvailability, color, price);
		this.maxSpeed = maxSpeed;
		this.batteryCapacity = batteryCapacity;
	}
	
	@Override
	/**
	 * @return textual representation of ElectricBike instance.
	 */
	public String toString() {
		return "E-BIKE " + this.getBrand() + "; " 
				+ this.maxSpeed + "; " 
				+ this.getWeight() + "; "
				+ this.isLightAvailability() + "; " 
				+ this.batteryCapacity + "; "
				+ this.getColor() + "; " 
				+ this.getPrice();
	}

	/**
	 * @return the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @return the batteryCapacity
	 */
	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	/**
	 * @param batteryCapacity the batteryCapacity to set
	 */
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

}

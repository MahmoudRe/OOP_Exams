
public class FoldingBike extends Bike {
	
	private int wheelSize;
	private int numGears;
	
	/**
	 * Constructor of FoldingBike class.
	 * @param brand The name of the brand of this bike
	 * @param wheelSize The size of the wheels(in inch)
	 * @param numGears The number of gear
	 * @param weight The weight of the bike (in grams)
	 * @param lightAvailability The availability of lights at front and back
	 * @param color The main color of this bike
	 * @param price The price of this bike
	 */
	public FoldingBike(String brand, int wheelSize, int numGears, int weight, boolean lightAvailability, String color, int price) {
		super(brand, weight, lightAvailability, color, price);
		this.wheelSize = wheelSize;
		this.numGears = numGears;
	}
	
	@Override
	/**
	 * @return textual representation of FoldingBike instance.
	 */
	public String toString() {
		return "FOLDING BIKE " + this.getBrand() + "; " 
				+ this.wheelSize + "; " 
				+ this.numGears + "; "
				+ this.getWeight() + "; "
				+ this.isLightAvailability() + "; " 
				+ this.getColor() + "; " 
				+ this.getPrice();
	}

	/**
	 * @return the wheelSize
	 */
	public int getWheelSize() {
		return wheelSize;
	}

	/**
	 * @param wheelSize the wheelSize to set
	 */
	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}

	/**
	 * @return the numGears
	 */
	public int getNumGears() {
		return numGears;
	}

	/**
	 * @param numGears the numGears to set
	 */
	public void setNumGears(int numGears) {
		this.numGears = numGears;
	}
}
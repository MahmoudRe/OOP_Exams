
public abstract class Bike {

	private String brand;
	private int price;
	private String color;
	private int weight;
	private boolean lightAvailability;
	
	
	/**
	 * Constructor of Bike class.
	 * @param brand The name of the brand of this bike
	 * @param weight The weight of the bike (in grams)
	 * @param lightAvailability The availability of lights at front and back
	 * @param color The main color of this bike
	 * @param price The price of this bike
	 */
	public Bike(String brand, int weight, boolean lightAvailability, String color, int price) {
		this.brand = brand;
		this.weight = weight;
		this.lightAvailability = lightAvailability;
		this.color = color;
		this.price = price;
		
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * @return the lightAvailability
	 */
	public boolean isLightAvailability() {
		return lightAvailability;
	}


	/**
	 * @param lightAvailability the lightAvailability to set
	 */
	public void setLightAvailability(boolean lightAvailability) {
		this.lightAvailability = lightAvailability;
	}
}

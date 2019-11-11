
public abstract class Car {

	private String brand;
	private String model;
	private String power;
	private String price;
	
	public Car (String brand, String model, String power, String price) {
		this.brand = brand;
		this.model = model;
		this.power = power;
		this.price = price;
	}
	
	/**
	 * To check if two CAR's are the same. it take any object as parameter.
	 * If the type of the cars doesn't match, it will return false directly.
	 * @param object this method can accept any object
	 * @return boolean
	 */
	@Override
	public abstract boolean equals (Object other);

	
	@Override
	public int hashCode() {
		return brand.hashCode();
	}
	
	
	@Override
	public abstract String toString();
	
	
	
	// Getters and Setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}


public class AppleDevice {
	
	private String model;
	private double screenSize;
	private String cpu;
	private String color;
	private String memory;
	private int price;
	
	
	public AppleDevice(String model, double screenSize, String cpu, String color, String memory, int price) {
		super();
		this.setModel(model);
		this.screenSize = screenSize;
		this.cpu = cpu;
		this.color = color;
		this.memory = memory;
		this.price = price;
	}


	public boolean equalsDevice(Object other) {
	
		if (other instanceof AppleDevice) {	
			
			AppleDevice that = (AppleDevice) other;
			if (   this.model.equals(that.model)
				&& this.screenSize == that.screenSize
				&& this.cpu.equals(that.cpu)
				&& this.color.equals(that.color)
				&& this.memory.equals(that.memory)
				&& this.price == that.price ) {
				return true;
			}
		}
		return false;
	}

	
	// The rest of this class is just Getters and Setters
	// ^_^
	public double getScreenSize() {
		return screenSize;
	}


	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMemory() {
		return memory;
	}


	public void setMemory(String memory) {
		this.memory = memory;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikesCatalog<Bike> {
	private List<Bike> catalog;
	
	/**
	 * Constructor of BikeCatalog class
	 */
	public BikesCatalog() {
		this.catalog = new ArrayList<>();
	}
	
	public boolean addToCatalog(Bike bike) {
		return this.catalog.add(bike);
	}
	
	/**
	 * add a new bike to catalog
	 * @param bikeLine
	 */
	public boolean addBike(String bikeLine) {
		
		String bikeSpecs[] = bikeLine.split(";");
		
		String firstSegment[] = bikeSpecs[0].split("\\s");
		String type;
		String model;
		
		if(firstSegment[0].equals("FOLDING")) {
			type = firstSegment[0] + "\\s" + firstSegment[1];
			model = firstSegment[2];
		} else {
			type = firstSegment[0];
			model = firstSegment[1];
		}
		
		String color = bikeSpecs[5].trim();
		int price = Integer.parseInt(bikeSpecs[6]);
		
		if(type.equals("FOLDING BIKE")) {
			
			int wheelSize = Integer.parseInt(bikeSpecs[1].trim());
			int numGears = Integer.parseInt(bikeSpecs[2].trim());
			int weight = Integer.parseInt(bikeSpecs[3].trim());
			boolean lightAvailability = Boolean.parseBoolean(bikeSpecs[4].trim());
			
			this.addToCatalog(new FoldingBike(model, wheelSize, numGears, weight, lightAvailability, color, price));
		
		} else {
			
			int maxSpeed = Integer.parseInt(bikeSpecs[1].trim());
			int weight = Integer.parseInt(bikeSpecs[2].trim());
			boolean lightAvailability = Boolean.parseBoolean(bikeSpecs[3].trim());
			int batteryCapacity = Integer.parseInt(bikeSpecs[4].trim());
			
			if(type.equals("E-BIKE"))
				this.catalog.add((Bike) new ElectricBike(model, maxSpeed, weight, lightAvailability, batteryCapacity, color, price));
			else if (type.equals("SPEEDELEC")) 
				this.catalog.add((Bike) new Speedelec(model, maxSpeed, weight, lightAvailability, batteryCapacity, color, price));	
			else 
				return false;
		}
		
		return true;
	}
	
	/**
	 * read from the given file name and store them into this calalog list
	 * @param fileName
	 */
	public void read(String fileName) {
		
		Scanner sc;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.print("Couldn't find the file, please enter the correct file name!");
			return;
		}
		
		while(sc.hasNextLine()) {
			addBike(sc.nextLine());
		}
		
	}
	
	/**
	 * write to the given file name and store them into this calalog list
	 * @param fileName
	 */
	public void write(String fileName) {
		
		PrintWriter pr;
		try {
			pr = new PrintWriter(fileName);
			pr.print(catalog.toString());
			pr.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot write to the given file name!");
		}
	}
	
	/**
	 * 
	 */
	public String toString() {
		String res = "";
		
		for(Bike bike : this.catalog) {
			res += bike.toString() + "\n";
		}
		
		return res;
	}

	/**
	 * @return the catalog
	 */
	public List<Bike> getCatalog() {
		return catalog;
	}
	
	//Design choice note: I didn't implement a setter for catalog list because I don't want to have the functionality to change the entire catalog.
	//the user of this class still be able to modify the list using the getter.
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CarCatalog <T> {

	private HashSet<T> car_catalog;
	
	/**
	 * Creates a new instance of CarCatalog.
	 */
	public CarCatalog () {
		car_catalog = new HashSet<T> ();
	}
	
	/**
	 * To add a new car into the predefined catalog.
	 * @param car the car you want to add
	 */
	public void addToCatalog (T obj) {
		car_catalog.add(obj);
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other instanceof CarCatalog) {
			@SuppressWarnings("unchecked")
			CarCatalog<T> that = (CarCatalog<T>) other;
			 
			 Iterator<T> itr = that.car_catalog.iterator();
			 while (itr.hasNext()) {
				 if (!this.car_catalog.contains(itr.next())) {
					 return false;
				 }
			 }
			 
//			 for (T element : car_catalog) {
//				 if (!this.car_catalog.contains(element)) {
//					 return false;
//				 }
//			 }
			 return true;
		}
		return false;
	}

	public HashSet<T> getCatalog () {
		return car_catalog;
	}

	
	@Override
	public String toString() {
	
		String result = "";
		Iterator<T> itr = car_catalog.iterator();
		
		while (itr.hasNext()) {
			result += itr.next().toString() + "\n";
		}
		return result;
	}
	

	/**
	 * this method read in file, check the first token in each line and create
	 * a new car from the information existed in the rest of this line.
	 * Then it add this car to a CAR_CATALOG which contain all the read cars. 
	 * @param filename String for the name of the file
	 * @return	CAR_CATALOG contain all the car described in the file
	 * @throws FileNotFoundException
	 */
	public static CarCatalog<Car> read (String filename) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File (filename));
		
		CarCatalog<Car> resCatalog = new CarCatalog<>();
		
		while (sc.hasNextLine()) {
			String carType = sc.next();
			String[] line = sc.nextLine().split(",\\s");
			
			// remove the white space before the brand name
			line[0] = line[0].trim();
		
			// the constructor parameters of X_CAR objects are in the
			// same order as its values are in the line of the wanted file
		
			switch (carType) {
			
				case "ELECTRIC_CAR":
				resCatalog.addToCatalog (
						new ELECTRIC_CAR (line[0], line [1], line [2], line[3], line[4])
						);
				break;
				
				case "GAS_CAR":
				resCatalog.addToCatalog (
						new GAS_CAR (line[0], line [1], line [2], line[3], line[4])
						);
				break;
				
				case "HYBRID_CAR":
				resCatalog.addToCatalog (
						new HYBRID_CAR (line[0], line [1], line [2], line[3], line[4], line[5])
						);
				break;
			}
		}
		
		sc.close();
		return resCatalog;
	}

	
	public static void write (CarCatalog<Car> catalog, String filename) {
		PrintWriter pr;
		try {
			pr = new PrintWriter(filename);
			pr.print(catalog.toString());
			pr.close();
			
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("there is a problem accored during the saving of this file!");
			System.exit(0);
		}
	}
}

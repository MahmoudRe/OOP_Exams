import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {
	
	private List<AppleDevice> catalog;
	
	
	/**
	 * Construct a new Catalog object which will make a new empty list
	 */
	public Catalog () {
		catalog = new ArrayList<AppleDevice>();
	}
	
	
	/**
	 * return a String in the same format as it is in the given file
	 */
	@Override
	public String toString() {
		String result = "";
		
		for (AppleDevice dev : this.catalog) {
			result += dev.toString() + "\n";
		}
		
		return result;
	}


	/**
	 * to add a new device to the List in catalog
	 * @param device the AppleDevice to be add in catalog
	 */
	public void addToCatalog (AppleDevice device) {
		catalog.add(device);
	}
	
	
	/**
	 * this method read in a special formated file. It consumes the file line by line,
	 * having constructing the right object from the information in each line, and finally
	 * add it to the catalog
	 * @param catalog the catalog where the data can be saved
	 * @param fileName the name of the wanted file to be read
	 * @throws FileNotFoundException
	 */
	public void read(String fileName) throws FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (new File (fileName));
		
		while (sc.hasNextLine()) {
			
			//take the first token as the device-type
			String deviceType = sc.next();
			
			//take the rest of the line and split it to token
			String[] line = sc.nextLine().split(",\\s");
			
			//remove the whitespace before the model name
			line[0] = line[0].trim();
			
			//change the type of the screen size token to double
			//line[1] = line[1].replaceAll("[^0-9]", "");
			double screenSize = Double.valueOf(line[1]); 
			
			//change the type of the price-token to integer
			line[line.length-1] = line[line.length-1].replaceAll("[^0-9]", "");
			int price = Integer.valueOf(line[line.length-1]); 

			
			switch (deviceType.toUpperCase()) {
			
			case "IPHONE":
				//change the type of the 3Dtouch token to boolean
				boolean has3DTouch = false;
				if (line[6].equals("TRUE")) { has3DTouch = true; }
				
				// the order of the tokens in the "line" array is the same as the order of the parameters
				this.addToCatalog(
						new Iphone (line [0], screenSize, line [2], line [3], line[4], line[5], has3DTouch, price)
						);
				break;
				
			case "IPAD":
				//change the type of the has4G token to boolean
				boolean has4G = false;
				if (line[3].equals("TRUE")) { has4G = false; }
				
				// the order of the tokens in the "line" array is the same as the order of the parameters
				this.addToCatalog(
						new Ipad (line [0], screenSize, line [2], has4G, line[4], line[5], price)
						);
				break;
			}
		}
		
//		public void writeToFile (String fileName) {
//			PrintWritter() = new PrintWritter(new File (fileName));
//		}
		
	}

}

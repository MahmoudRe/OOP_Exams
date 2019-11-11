import java.util.ArrayList;
import java.util.Scanner;

public class ADD extends AudioFile {
	
	private String advertiser;
	private static ArrayList<ADD> listADD;
	
	public ADD (String advertiser, int min, int sec) {
		super (min, sec);
		this.advertiser = advertiser;
	}
	
	/**
	 * This method read one line in a file and return an ADD object.
	 * Particularly, it consumes one whole line (after "ADD" token, until \n), takes the advertiser's name 
	 * and the length, then, from this info, creates an ADD object.
	 * @param sc the scanner of the wanted text file
	 * @return ADD object
	 */
	public static ADD readADD (Scanner sc) {
		if (sc.hasNext()) {
			
			// skip the token "ADD" and save other info in a temporary string
			// sc.next();
			String advertiserX = sc.next();
			while (! sc.hasNextInt()) {
				advertiserX = advertiserX + " " + sc.next();
			}
			
			int minX = sc.nextInt();
			int secX = sc.nextInt();
			
			//skip "\n" and set the pointer on the next line for new read
			sc.nextLine(); 
			
			return new ADD (advertiserX, minX, secX);
			
		} else {
			System.out.println("there is no more information in this file");
			return null;
		}
		
	}
	
	
	public static void addADDlist(ADD add) {
		listADD.add(add);
	}

	public String toString() {
		return "ADD " + advertiser + ", " + length; 
	}

	public static String toStringADDs() {
		String res = "ADDS";
		
		for (int i = 0; i < getListADD().size(); i++) {
			res += "\n" + getListADD().get(i).toString();
		}
		
		return res;
	}
	
	// Introduce getters and setter
	public String getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(String advertiser) {
		this.advertiser = advertiser;
	}
	
	public static ArrayList<ADD> getListADD() {
		return listADD;
	}

	public static void setListADD(ArrayList<ADD> listADD) {
		ADD.listADD = listADD;
	}
}

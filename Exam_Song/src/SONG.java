import java.util.Scanner;

public class SONG extends AudioFile {
	
	private int tracknumber;
	private String title;
	
	/**
	 * This contracts Song object with a minutes and seconds of its length,
	 * and with its title and track number.
	 * @param min the minutes' length of this song
	 * @param sec the seconds' length of this song
	 * @param tracknumber the number of track for this song
	 * @param title the title of this song
	 */
	public SONG (int tracknumber, String title, int min, int sec) {
		super (min, sec);
		this.tracknumber = tracknumber;
		this.title = title;
	}
	
	
	/**
	 * This method read one line in a file and return a SONG object.
	 * Particularly, it consumes one whole line (with \n), takes the
	 * wanted parameters from this line and creates a SONG object.
	 * @param sc the scanner of the wanted text file
	 * @return SONG object
	 */
	public static SONG readSONG (Scanner sc) {
		if (sc.hasNext()) {
			 
			// skip the token "SONG" and save the other info into a temporary variables
			// sc.next();
			int tracknumberX = sc.nextInt();
			String titleX = sc.next();
			while (!sc.hasNextInt()) {
				titleX = titleX + " " + sc.next();
			}
			int minX = sc.nextInt();
			int secX = sc.nextInt();
			
			//skip "\n" and set the pointer on the next line for new read
			sc.nextLine(); 
			
			return new SONG (tracknumberX, titleX, minX, secX);
			
		} else {
			System.out.println("there is no more information in this file");
			return null;
		}
		
	}
	
	
	public String toString() {
		return "SONG " + tracknumber + ", "+ title + ", " + getLength();
	}
	
	//Introduce getters and setters for the track number and the title
	public void setTracknumber(int tracknumber) {
		this.tracknumber = tracknumber;
	}
	
	public int getTracknumber() {
		return tracknumber;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}

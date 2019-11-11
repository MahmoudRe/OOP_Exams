import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CD {
	
	private static ArrayList<CD> listCD = new ArrayList<CD>();
	private ArrayList<SONG> songList;
	private String bandName;
	private String name;
	private int year;
	
	
	public CD (String bandName, String name, int year) {
		this.bandName = bandName;
		this.name = name;
		this.year = year;
		
		songList = new ArrayList<SONG>();
	}
	
	/**
	 * Adding a song to this CD
	 * @param song
	 */
	public void addSong (SONG song) {
		songList.add(song);
	}

	/**
	 * Adding a new CD to the collection and create a new PlayList from this CD
	 */
	public static void addNewCD () {
		
		System.out.println("Adding a new CD\nPlz enter the following detail!");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		System.out.println("The band name?");
		String bandNamex = sc.nextLine();
		
		System.out.println("Album name?");
		String namex = sc.nextLine();
		
		System.out.println("The year of release?");
		int yearx = sc.nextInt();
		
		CD newCD = new CD (bandNamex, namex, yearx);
		listCD.add(newCD);
		
		// initialize the track number and new songList
		int tracknumberx = 0;
		ArrayList<SONG> songListx = new ArrayList<SONG>();
		
		while (true) {
			sc.nextLine();
			
			//Stop loop condition
			System.out.println("Do you want to add one (more) song?"
								+ "\n enter 'Y' for yes and 'N' for no");
			String st = sc.nextLine();
			if (st.contains("n")) { break; }
			
			System.out.println("the title of the song?");
			String titlex = sc.nextLine();
			
			System.out.println("minutes length of the song?");
			int min = sc.nextInt();
			
			System.out.println("seconds length of the song?");
			int sec = sc.nextInt();
			
			tracknumberx++;
			
			
			songListx.add(new SONG (tracknumberx, titlex, min, sec));
			
		}
		
		newCD.setSongList(songListx);
	}

	
	/**
	 * Returning a textual presentation of the name of this CD and list of all it's song
	 * @return String 
	 */
	public String toString () {
		
		String res = "";
		for (int i = 0; i < songList.size(); i++ ) {
			res += "\n" + songList.get(i).toString();
		}
		
		String result = "CD " + bandName + ", "
						+ name + ", " + year
						+ res;
 		
		return result;
	}

	
	public String toStringAlbum () {
		return bandName + "'s " + name ;
	}

	
	public static String toStringCDs () {
		String res = "CDS";
		
		for (int i = 0; i < listCD.size(); i++ ) {
			res += "\n" + listCD.get(i).toString();
		}
		
		return res;
	}

	/**
	 * Read in a file and return a list of ALL CD's in this file.
	 * @param filename the name of the file contains all the songs and adds
	 * @return	a list of all CD's in the file + initialize a list of all ADDs in this file
	 * @throws FileNotFoundException if the file didn't exist!
	 */
	public static ArrayList<CD> readlist(String filename) throws FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (new File (filename)).useDelimiter("\\s|,\\s|:");
	
		// Initialize CD = null; since we know from the format that a CD 
		// will come before songs and we can add the song below to that CD
		CD cdX = new CD ("", "", -1);
		listCD = new ArrayList<CD>();
		
		if (sc.hasNextLine()) {
			sc.nextLine();  // skip the first line with token "CDS"
			
			while (sc.hasNextLine()) {
				
				// save the first of each line to determine what should be next
				String firstToken = sc.next();
			
				switch (firstToken) {
					case "SONG":
						cdX.addSong(SONG.readSONG(sc));
						break;
						
					case "CD":
						String bandNamex = sc.next();
						String namex = sc.next();	
						
						while (!sc.hasNextInt()) {
							namex = namex + " " + sc.next();
						}
						
						int yearx = sc.nextInt();
						sc.nextLine(); // skip the rest of this line "\n"
						
						cdX = new CD (bandNamex, namex, yearx);
						listCD.add(cdX);
						break;
						
					case "ADDS":
						ADD.setListADD(new ArrayList<ADD>());
						sc.nextLine(); // skip the rest of this line "\n"
						break;
					case "ADD":
						ADD.addADDlist(ADD.readADD(sc));
						
					default:
						break;
				}
			}
			
		} else {
			System.out.println("there is no more information in this file");
		}
		
		return listCD;
	}

	
	
	//Getters and Setters
	public static ArrayList<CD> getListCD() {
		return listCD;
	}

	public static void setListCD(ArrayList<CD> listCD) {
		CD.listCD = listCD;
	}

	public ArrayList<SONG> getSongList() {
		return songList;
	}
	
	public void setSongList(ArrayList<SONG> songList) {
		this.songList = songList;
	}
}


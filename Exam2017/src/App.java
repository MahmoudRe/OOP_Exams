import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App {


	public static void main (String[] arg) throws FileNotFoundException {
		
		ArrayList<CD> listCDs = CD.readlist("SongFile.txt");
		
		CD.addNewCD();
			
		System.out.println (CD.toStringCDs());
		
		PLAYLIST pl = new PLAYLIST (listCDs);
		//System.out.println (ADD.toStringADDs());
		
		System.out.println (pl.toString());
		// System.out.println(CD.getListCD().get(0).toString());
	}
}

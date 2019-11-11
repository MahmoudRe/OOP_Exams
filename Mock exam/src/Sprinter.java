import java.util.*;

public class Sprinter extends Train {
	
	public Sprinter (String Departs, String Arrives, List<String> Stations) {
		super(Departs, Arrives, Stations);
	}
	
	public boolean SprinterConnects (String A, String B) {
		
		if (Stations.contains(A) && Stations.contains(B)) {
			if (Stations.indexOf(A) < Stations.indexOf(B)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String toStringSprinter() {
		
		String firstline = "Sprinter from " + Stations.get(0) + " to " + Stations.get(Stations.size() - 1) + "\n";
		String Dp_Ar = "Departure: " + Departs + "\n"
					 + "Arrival: " + Arrives + "\n";
		String s_list = "";
		
		for (int i = 0; i < Stations.size(); i++) {
			s_list = s_list + "---" + Stations.get(i) +"\n";
		}
		
		return firstline + Dp_Ar + s_list;
	}
}

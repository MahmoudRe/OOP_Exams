import java.util.*;

public class Intercity extends Train {
	
	private List<String> IC_Stations;

	public Intercity (String Departs, String Arrives, List<String> Stations, List<String> IC_Stations) {
		super(Departs, Arrives, Stations);
		this.IC_Stations = IC_Stations;
	}
	
	public boolean IntercityConnects (String A, String B) {
		
		if (IC_Stations.contains(A) && IC_Stations.contains(B)) {
			if (IC_Stations.indexOf(A) < IC_Stations.indexOf(B)) {
				return true;	
			}
		}
		
		return false;
	}
	
	
	public String toStringIntercity() {
		
		String firstline = "Intercity from " + Stations.get(0) + " to " + Stations.get(Stations.size() - 1) + "\n";
		String Dp_Ar = "Departure: " + Departs + "\n"
					 + "Arrival: " + Arrives + "\n";
		String s_list = "";
		
		for (int i = 0; i < Stations.size(); i++) {
			if (IC_Stations.contains(Stations.get(i))) {
				s_list = s_list + "---" + Stations.get(i) +"\n";
			} else {
				s_list = s_list + "----(" + Stations.get(i) +")\n";
			}
		}
		
		return firstline + Dp_Ar + s_list;
	}
	
}

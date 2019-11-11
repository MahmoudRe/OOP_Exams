import java.io.*;
import java.util.*;

public class Readfile {
	
	private Scanner sc_input;
	
	public Readfile (String fileName) throws IOException {
		
		sc_input = new Scanner(new File (fileName)).useDelimiter(":");	
	}
	
	public Scanner getSc_input() {
		return sc_input;
	}

	public Intercity ReadTrain () {
		
		if (sc_input.hasNextLine() ) {
			if (sc_input.next().toUpperCase().equals("TRAIN")) {
				
				String TrainType = sc_input.next().toUpperCase();

				int Departs_min = -1;
				int Departs_sec = -1;
				int Arrives_min = -1;
				int Arrives_sec = -1;
				
				List<String> IC_Stations = new ArrayList<String>();
				List<String> Stations = new ArrayList<String>();
				
				while_loop:
				while (sc_input.hasNextLine()) {
					
					String nextToken = sc_input.next().toUpperCase();
					
					switch (nextToken) {
					
						case "END":
							break while_loop;
						
						case "DEPARTS":
							Departs_min = sc_input.nextInt();
							Departs_sec = sc_input.nextInt();
							break;
							
						case "ARRIVES":
							Arrives_min = sc_input.nextInt();
							Arrives_sec = sc_input.nextInt();
							break;
							
						case "IC-STATION":
							String This_IC_Station = sc_input.nextLine();
							IC_Stations.add(This_IC_Station);
							Stations.add(This_IC_Station);
							break;
							
						case "STATION":
							Stations.add(sc_input.nextLine());
							break;
					}
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		
		Readfile inputFile = new Readfile("trains.txt");
		Scanner input = inputFile.getSc_input();
		
		
		while (input.hasNextLine()) {
			
			System.out.println(input.nextLine());
			
		}
		
		input.close();
		
		String DEPARTS = "";
		
		Readfile inputFile2 = new Readfile("trains.txt");
		Scanner input2 = inputFile2.getSc_input();
		
		
		while (input2.hasNextLine()) {
			
			if ( (input2.next()).equals("DEPARTS:") ) {
				DEPARTS = input2.next();
				System.out.println(DEPARTS);
				break;
			}
		
		}
		
	}

}

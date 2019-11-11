import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
	
	protected int Departs_Min;
	protected int Departs_Sec;
	
	protected int Arrives_Min;
	protected int Arrives_Sec;
	
	protected String Departs = Departs_Min + ":" + Departs_Sec;
	protected String Arrives = Arrives_Min + ":" + Arrives_Sec;
	protected List<String> Stations;
	
	
	public Train (String Departs, String Arrives, List<String> Stations) {
		this.Departs = Departs;
		this.Arrives = Arrives;
		this.Stations = Stations;
	}
	
	public static Train ReadOneTrain (Scanner sc_input) {
		
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
							if (sc_input.hasNextLine()) { sc_input.nextLine(); }
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
							sc_input.skip(": ");
							String This_IC_Station = sc_input.nextLine();
							IC_Stations.add(This_IC_Station);
							Stations.add(This_IC_Station);
							break;
							
						case "STATION":
							sc_input.skip(": ");
							Stations.add(sc_input.nextLine());
							break;
					}
					
				}
				
				String Departs = Departs_min + ":" + Departs_sec;
				String Arrives = Arrives_min + ":" + Arrives_sec;
				
				/*
				switch (TrainType) {
				
				case "INTERCITY":
					return new Intercity (Departs, Arrives, Stations, IC_Stations);
				
				case "SPRINTER":
					return new Sprinter (Departs, Arrives, Stations);
				}
				*/
				
				if (TrainType.equals("INTERCITY")) {
					return new Intercity (Departs, Arrives, Stations, IC_Stations);
					} else if (TrainType.equals("SPRINTER")) {
					return new Sprinter (Departs, Arrives, Stations);
					} else {
					System.out.println("Cannot define the type of the train");
					return new Train (Departs, Arrives, Stations);
					}
			
			}
		}
		
		System.out.println("there are no more trains in this file");
		return null;
	}

	
	public static ArrayList ReadTrain (String fileName) {
		
		ArrayList listTrain = new ArrayList();
		try {
			@SuppressWarnings("resource")
			Scanner sc_input = new Scanner(new File (fileName)).useDelimiter(":\\s|:|\\n|\\s");
			
			while (sc_input.hasNextLine() ) {
				Train t = ReadOneTrain(sc_input);
				listTrain.add(t);	
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("invalid file!");
			e.printStackTrace();
		}	
		
		return listTrain;
		
	}

	
	public static ArrayList Trains_from_A_To_B (ArrayList<Train> trainList, String A, String B) {
		ArrayList list_A_to_B = new ArrayList();
		
		for (int i = 0; i < trainList.size(); i++) {
			Train t = trainList.get(i);
			
			
			if (t instanceof Intercity ) {
				if ( ((Intercity) t).IntercityConnects(A, B) ) {
					list_A_to_B.add(t);
				}
			}
			
			
			if (t instanceof Sprinter ) {
				if ( ((Sprinter) t).SprinterConnects(A, B) ) {
					list_A_to_B.add(t);
				}
			}
			
		}
		
		return list_A_to_B;
	}
	
	
	public boolean equals (Object other) {
		
		if (other instanceof Train) {
			
			if (this.getClass().equals(other.getClass())) {
			
				Train that = (Train) other;
				return this.Stations.equals(that.Stations) && this.Departs.equals(that.Departs) && this.Arrives.equals(that.Arrives);
			}
		}
		
		return false;
	}
	
	
	public static String onScreen(ArrayList listTrain) {
		
		String result = "";
		
		for (int i = 0; i < listTrain.size(); i++) {
			
			if (listTrain.get(i) instanceof Intercity) {
				Intercity that = (Intercity) listTrain.get(i);
				result = result + that.toStringIntercity() + "\n";
			}
			
			if (listTrain.get(i) instanceof Sprinter) {
				result = result + ((Sprinter)listTrain.get(i)).toStringSprinter() + "\n";
			}
			
		}
		
		return result;
	}
}

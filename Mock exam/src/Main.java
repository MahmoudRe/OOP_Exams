import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main (String[] arg) {
		
		ArrayList trainlist = Train.ReadTrain("trains.txt");
		
		
		int in = -1;
		
		while (in != 3) {
			
			System.out.println("Please make your choice:\n"
					+ "\t1 – Show all trains that are inthe in-memory database on screen\n"
					+ "\t2 – Show all trains from station A to station B3–Stop the program\n"
					+ "\t3 – Stop the program");
			
			Scanner Input = new Scanner(System.in);
			in = Input.nextInt();
		
			if (in == 1) {
				System.out.println(Train.onScreen(trainlist));
			
			} else if (in == 2) {
				
				Scanner A = new Scanner(System.in);
				Scanner B = new Scanner(System.in);
				
				String A1 = A.nextLine();
				String B1 = B.nextLine();
				
				System.out.println(Train.onScreen(Train.Trains_from_A_To_B(trainlist, A1, B1 )));
			
			} else if (in == 3) {
				System.out.println("the end of the program!");
			} else {
				System.out.println("invalid choise: please enter the number 1, 2 or 3");
			}
	
		}
	}

}

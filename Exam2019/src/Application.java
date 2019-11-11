import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the file name: ");
		String fileName = input.nextLine();
		
		BikesCatalog<Bike> EcoBike = new BikesCatalog<>();
		EcoBike.read(fileName);
		
		int instruction = 0;
		while(instruction != 7) {
			System.out.println("Please make your choice:\n"
					+ "\t1 -Show the entire EcoBikecatalogue\n"
					+ "\t2 –Add a new folding bike\n"
					+ "\t3 –Add a new speedelec\n"
					+ "\t4 –Add a new e-bike\n"
					+ "\t5–Find first item of a particular brand\n"
					+ "\t6 –Write to file\n"
					+ "\t7 –Stop the program\n");
			
			instruction = input.nextInt();
			switch (instruction) {
				case 1:
					System.out.println(EcoBike.toString());
					break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					EcoBike.write(fileName);
					break;
			}		
		}
	}

}

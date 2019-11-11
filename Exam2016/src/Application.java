import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
	
	
	public static void main (String[] args) {
		
		System.out.println("Welcome to apple devices maneger!"
					+ "\nplease enter the name of the file to read it" );
		
		Catalog catalogX = new Catalog();
		
		Scanner input = new Scanner (System.in);
		
		while (true) {
			try {
				catalogX.read(input.next());
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Cann't find the file, please enter a valid file name!");
				e.getMessage();
			} catch (Exception e ) {
				System.out.println("Something went wrong, the program stop!");
				e.getMessage();
				System.exit(0);
			}
		}
	
		while (true) {
			
			System.out.println("Please make your choise:"
					+ "\n 1 – Show the entire Apple catalogue"
					+ "\n 2 – Add a new iPhone"
					+ "\n 3 – Add a new iPad"
					+ "\n 4 – Show the entire Apple catalogue sorted by product"
					+ "\n 5 – Show the entire Apple catalogue sorted by price (low -> high)"
					+ "\n 6 – Write to file"
					+ "\n 7 – Stop the program ");
			
			//Initializing a variable and using try/catch block 
			//to take care of the IOException or any other type
			int option = -1;
			try {
				option = input.nextInt();
			} catch (Exception e) {
				System.out.println("invalid choise ( please enter just a number 1-7)");
			}
			
			switch (option) {
			case 1:
				System.out.println(catalogX.toString());
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				input.close();
				System.exit(0);
			default:
				System.out.println("invalid choise!");
			}
			
			
		}
		
	}

}

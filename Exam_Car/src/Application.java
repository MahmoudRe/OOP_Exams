import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application extends Thread {
	
	/**
	 * to print all the cars inside the catalog
	 * @param CAR_CATALOG<CAR> the wanted catalog to be shown
	 */
	public static void op1_Show (CarCatalog<Car> catalog) {
		System.out.println(catalog.toString());
	}
	
	
	/**
	 * Creating a new object X_CAR and add it into the catalog.
	 * the X donate for the type of the car which determine using
	 * parameter as integer (2->ELECTRIC, 3->GAS, 4->HYBRID)
	 * @param CAR_CATALOG<CAR> the wanted catalog to be shown
	 * @param carType integer to determine the type of car
	 * @param input Scanner of the System.in or any other way of input
	 */
	public static void op_Add_Car (CarCatalog<Car> catalog, int carType, Scanner input) {
		System.out.println("Welecome into adding a new car wizard! \nPlease fill the folowing filds!");
		
		System.out.println("What is the brand of this car?");
		String brand = input.nextLine();
		
		System.out.println("Whats is the model name of this car?");
		String model = input.nextLine();
		
		System.out.println("Howmuch the power of the engine (in KW)?");
		String power = input.next() + "KW";
		
		System.out.println("Howmuch the price (in euro)?");
		String price = input.next() + " euro";
		
		
		switch (carType) {
			case 2:
				System.out.println("Howmuch the capacity of the battery (in Ah)?");
				String battery = input.next() + "Ah";
				
				catalog.addToCatalog(new ELECTRIC_CAR(brand, model, power, battery, price));
				break;
				
			case 3:
				System.out.println("Howmuch the displacement of the engine (in L)?");
				String displacement = input.next() + "L";
				
				catalog.addToCatalog(new GAS_CAR (brand, model, displacement, power, price));
				break;
				
			case 4:
				System.out.println("Howmuch the capacity of the battery (in Ah)?");
				String battery1 = input.next() + "Ah";
				
				System.out.println("Howmuch the displacement of the engine (in L)?");
				String displacement1 = input.next() + "L";
				
				catalog.addToCatalog(new HYBRID_CAR (brand, model, displacement1, power, battery1, price));
				break;
				
			default:
				System.out.println("there is a probrem accord! the type of this car isn't define!");
				break;
		}
	}
	
	/**
	 * take an integer and HashSet<Car> and print all the Car's sorted according to 
	 * this integer (5-> sorted by car-type, 6-> sorted by brand )
	 * @param catalog
	 * @param sortType integer to determine which way of sorting should be implemented
	 */
	public static void op_Sort (CarCatalog<Car> catalog, int sortType) {
		Thread th = new Thread(new MyRunnable(catalog.getCatalog(), sortType));
		th.start();
		
		System.out.println("wait");
	}


	public static void main (String[] args) {
		
		CarCatalog<Car> catalog = new CarCatalog<>();
		
		System.out.println("Please enter the file name including the extinsion (eg: X.txt)");
		
		Scanner input1 = new Scanner(System.in);
		String filename = input1.next();
		
		try {
			catalog = CarCatalog.read(filename);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("An exception has accord, the program stops");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An exception has accord, the program stops");
			System.exit(0);
		}
		
		int option = -1;
		while (true) {
			System.out.println("Please make your choise:"
								+ "\n   1 - Show the entire Mobility4You catalogue"
								+ "\n   2 - Add a new electric car"
								+ "\n   3 - Add a new gas-powered car"
								+ "\n   4 - Add a new hybrid car"
								+ "\n   5 - Show the entire Mobility4You catalogue sorted by car-type"
								+ "\n   6 - Show the entire Mobility4You catalogue sorted by brand (alphabetically)"
								+ "\n   7 - Write to file"
								+ "\n   8 - Stop the program");
			
			option = input1.nextInt();
			input1.nextLine(); // skip the rest of this line (/n)
			
			switch (option) {
			case 1:
				op1_Show(catalog);
				break;
			
			case 2:
			case 3:
			case 4:
				op_Add_Car(catalog, option, input1);
				break;
				
			case 5:
			case 6:
				op_Sort(catalog, option);
				break;
			
			case 7:
				CarCatalog.write(catalog, filename);
				break;
				
			case 8:
				input1.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Not valid choise!");
			}
			
		}
	}

}

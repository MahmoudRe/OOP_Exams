import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class MyRunnable implements Runnable {
	
	private HashSet<Car> catalog;
	private int sortType;
	

	public MyRunnable (HashSet<Car> catalog, int sortType) {
		this.catalog = catalog;
		this.sortType = sortType;
	}

	@Override
	public void run() {
		System.out.println("Sorting to be implemented!");
		
		List<Car> carList = new ArrayList<Car>();
		
		for (Car c : catalog) {
			carList.add(c);
		}
		
		Comparator <Car> comp_type = new Comparator<Car>() {
			
			@Override
			public int compare(Car c1, Car c2) {
				if (c1.toString().charAt(0) > c2.toString().charAt(0) && c2.toString().charAt(0) != 'G') {
					return 1;
				} else {
					return -1;
				}
			}
			
		};
		
		Comparator<Car> comp_brand = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				if (c1.getBrand().charAt(0) > c2.getBrand().charAt(0)) {
					return 1;
				} else {
					return -1;
				}
			}
			
		};
		
		if (sortType == 5) {
			Collections.sort(carList, comp_type);
		}
		else {
			Collections.sort(carList, comp_brand);
		}
			
		for (Car c : carList) {
			System.out.println(c.toString());
		}
		
	}
	
	
	// Getter and Setter
	public HashSet<Car> getCatalog() {
		return catalog;
	}

	public void setCatalog(HashSet<Car> catalog) {
		this.catalog = catalog;
	}
	
	
}

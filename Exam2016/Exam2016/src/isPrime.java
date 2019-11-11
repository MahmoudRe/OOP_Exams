
public class isPrime {

	public static int[] merge(int[] arr1, int[] arr2) {
	    if (arr1 == null && arr2 == null) { return null; }
	    if (arr1 == null) { return arr2; }
	    if (arr2 == null) { return arr1; }
	    
	    int [] result = new int [arr1.length + arr2.length];
	    int c = 0;
	    int indexArr2 = 0;
	    
	    for (int i = 0; i < arr1.length; i++) {
	        innerloop:
	        while (true) {
	          if (indexArr2 < arr2.length && arr2[indexArr2]<arr1[i]) {
	 	             result[c] = arr2[indexArr2];
	 	             indexArr2++;
	 	             c++; 
	          } else {
	            result[c] = arr1[i];
	            c++;
	            break innerloop;
	          }
	        }
	    } 
	     while (indexArr2 < arr2.length) {
	        result[c] = arr2 [indexArr2];
	        indexArr2++;
	        c++;
	     }
	    
	    return result;
	  }
	
	public static void main (String[] args) {
		int [] arr1 = {3,3,3,3};
		int [] arr2 = {1,2,3,4,5};
		
		int [] result = merge(arr1, arr2);
		
		for (int i =0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
	
}

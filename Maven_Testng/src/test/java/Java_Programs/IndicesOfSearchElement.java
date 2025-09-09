package Java_Programs;

public class IndicesOfSearchElement {

	
	// indices meaning: position/index of a number which u r searching in an array
	    public static void main(String[] args) {
	        int[] arr = {5, 3, 7, 5, 9, 5, 2, 5};
	        int searchElement = 5;

	        System.out.println("Indices of element " + searchElement + ":");
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == searchElement) {
	                System.out.println(i);
	            }
	        }
	    }
	}


/*	output: 
 
Indices of element 5:

0
3
5
7

 */

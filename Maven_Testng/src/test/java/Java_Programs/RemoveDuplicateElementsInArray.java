package Java_Programs;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int a[]={12,12,34,34,12,35,65,78,87,65};
	        
	        HashSet<Integer> set = new LinkedHashSet<Integer>();
	        for(int i=0;i<a.length;i++){
	            set.add(a[i]);
	        }
	        
	        for(int value:set){
	            System.out.print(" "+value);
	           
	        }
	        
	        //or
	        //System.out.print(set);
	        
	        //or 
	        
	        int a1[]=new int[set.size()];
	        int i=0;
	        
	        for(int value:set){
	            a1[i]=value;
	            i++;
	        }
	        for(int j=0;j<a1.length;j++){
	            System.out.print(" "+a1[j]);
	        }
	        
	       

	}

}

/*
 
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {12, 34, 43, 12, 34, 65, 76, 34};
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; ) {
                if (a[i] == a[j]) {
                    // Shift elements to the left
                    for (int k = j; k < n - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    n--;  // Reduce array size
                } else {
                    j++;
                }
            }
        }

        // Print the array after removing duplicates
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

 */

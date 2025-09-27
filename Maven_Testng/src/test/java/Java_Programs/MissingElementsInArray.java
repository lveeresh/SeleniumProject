package Java_Programs;

import java.util.HashSet;
import java.util.Set;

public class MissingElementsInArray {

	public static void main(String[] args) {
		
		        int a[]={1,3,5};
		        int n=10;
		        Set<Integer> set = new HashSet<>();
		        
		        for(int num : a){
		            set.add(num);
		        }
		        for(int i=1;i<=n;i++){
		            if(!set.contains(i)){
		                System.out.print(","+i);
		            }
		        }
		   
	}

}

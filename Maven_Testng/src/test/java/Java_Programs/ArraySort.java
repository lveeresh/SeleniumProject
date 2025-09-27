package Java_Programs;
import java.util.*;

public class ArraySort {
    public static void main(String args[]) {
        
        int a[]={12,34,65,76,24};
        Arrays.sort(a);
//        System.out.print("Sorted array: ");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
        System.out.println("Biggest number is: " + a[a.length - 1]);
        System.out.println("Lowest number is: " + a[0]);
        
        
        List<String> names = Arrays.asList("Veeresh", "Satya", "Abhishek", "Lakkandi");
        // Sort in ascending (alphabetical) order
        Collections.sort(names);
        System.out.println("Sorted list: " + names);
        
        
        String a1[] ={"veeresh", "lakkandi", "satya"};
        List<String> names1 = new ArrayList<>(Arrays.asList(a1));
        Collections.sort(names1);
        System.out.println("Sorted list names1: " + names1);
        Collections.sort(names1, Collections.reverseOrder());
        System.out.println("Reverse order:"+names1);
        Collections.reverse(names1);
    }
}

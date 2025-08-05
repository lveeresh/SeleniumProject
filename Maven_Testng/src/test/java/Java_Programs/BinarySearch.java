package Java_Programs;
import java.util.*;
public class BinarySearch {

	public static void main(String[] args) {
		int a[]= {12,43,54,60,87,93};
	      Scanner sc= new Scanner(System.in);
	      int l=0,r=a.length-1,mid=0;
	      int data= 18;
	      while(l<=r){
	          mid=(l+r)/2;
	          if(data==a[mid]){
	              System.out.println("data found");
	              break;
	          }
	          else if(data<a[mid])
	              r=mid-1;
	          else
	          r=mid+1;
	      }
	      if(l>r)
	      System.out.println("element not found");
	}

}

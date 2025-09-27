package Java_Programs;
import java.util.*;
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[]={12,87,34,54,50};
	        
	        int flag=0;
	        int temp;
	        
	        for(int i=0;i<a.length;i++){
	            for(int j=0;j<a.length-1-i;j++){
	                if(a[j]>a[j+1]){
	                    temp = a[j];
	                    a[j]=a[j+1];
	                    a[j+1]=temp;
	                    flag=1;
	                }
	            }
	           
	    }
	    if(flag==0)
	    System.out.println("sorting not required");
	    for(int i=0;i<5;i++){
	        System.out.println(a[i]);
	    }
	     System.out.println("biggest number is :"+a[a.length-1]);

	}

}


//or

  
//public class HashMapExample2{  
// public static void main(String args[]){  
//     Scanner sc= new Scanner(System.in);
//  int n = sc.nextInt();
//  int a[]=new int[n];
//  for(int i=0;i<a.length;i++){
//      a[i]= sc.nextInt();
//      }
//	int a[]={12,76,87,34,23};
//     int flag=0;
//     
//     for(int i=0;i<a.length;i++){
//         for(int j=0;j<a.length-1;j++){
//             
//             if(a[i]<a[j]){
//             int temp =a[j];
//             a[j]=a[j+1];
//             a[j+1]=temp;
//             flag=1;
//             }
//             
//         }
//     } 
//      if(flag==0){
//         System.out.println("sorting not required");
//      }
//      for(int i=0;i<a.length;i++){
//          System.out.print(","+a[i]);
//      }
//   
//}  
//}  
package Maven_Testng.Maven_Testng;

import java.util.Scanner;

public class JavaPrograms {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n= sc.nextInt();
//		int a[]= new int[n];
		
		int a[]= {10,23,54,11,22};
		int max=a[0];
		int temp=0;
		for(int j=0;j<5;j++) {
			if(a[j]>max) {
				temp =a[j];
				a[j]=max;
				max=temp;
			}
				
		}
		for(int i=0;i<5;i++) {
			 System.out.println(a[i]);
		}
		
		System.out.println("max is"+max);
	}

}

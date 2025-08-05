package Java_Programs;



import java.util.*;

class Main {
	public static void main(String[] args) {
		String s = "veereshcapgemini";
		String output = "";

		LinkedHashSet<Character> ob = new LinkedHashSet<>();
		char c[] = s.toCharArray();

		for (char ch : c) {
			ob.add(ch);
		}
		for (char ch1 : ob) {
			output = output + ch1;
		}
		System.out.print(output);
	}
}

//==========================================================
   //without using collections

//public class RemoveDuplicates {
//	public static void main(String[] args) {
//		String s1 = "veereshlakkandii";
//		char a[] = s1.toCharArray();
//		String s2 = "";
//
//		int n = a.length;
//
//		for (int i = 0; i < n; i++) {
//			for (int j = i + 1; j < n;) {
//				if (a[i] == a[j]) {
//					// Shift elements to the left
//					for (int k = j; k < n - 1; k++) {
//						a[k] = a[k + 1];
//					}
//					n--;  // Reduce array size
//				} else {
//					j++;
//				}
//			}
//		}
//
//		// Print the array after removing duplicates
//		System.out.println("Array after removing duplicates:");
//		for (int i = 0; i < n; i++) {
//			s2 = s2 + a[i];
//		}
//		System.out.println(s2);
//	}
//}

//=========================================================

//import java.util.*;
//class Remove_duplicate_char {
//	static void removeChar(String s) {
//		
//		LinkedHashSet<Character> ob= new LinkedHashSet<>();
//		
//		for(int i=0;i<s.length();i++) {
//			ob.add(s.charAt(i));
//		}
//		
//		//for(Character ch:ob) {
//		//or
//		for(char ch:ob) {
//			System.out.print(ch);
//		}	
//	}
//	
//	public static void main(String[] args) {
//		
//		String s1="veeresh capgemini z";
//		removeChar(s1);
//		
//		
//	}

//	public static void main(String args[]) {
//		StringBuffer sb = new StringBuffer("Hello Abhishek");
//		
//		String s2="veeresh";
//		String s3="lakkandi";
//		String s4="hhhfhh";
//		System.out.println(s2.concat(s3).concat(s4));
//
//	}

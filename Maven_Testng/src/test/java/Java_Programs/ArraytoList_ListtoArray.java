package Java_Programs;

import java.util.*;

public class ArraytoList_ListtoArray {

	public static void main(String[] args) {
		
		//Array to List
		
//		String s[] = {"veeresh","lakkandi","capgemini"};
//		
//		List<String> li = new ArrayList<>();
//		
//		for(String s1:s) {
//			li.add(s1);
//		}
//		System.out.println(li);
		
		
		// List/arraList to Array
		
		List<Integer> lst = new ArrayList<>();
		
		lst.add(12);
		lst.add(14);
		lst.add(10);
		lst.add(123);
		
		Integer s2[] = new Integer[lst.size()];
		s2 = lst.toArray(s2);
		
		for(int i=0;i<s2.length;i++) {
			System.out.println(s2[i]);
			
		}
		
	}

}

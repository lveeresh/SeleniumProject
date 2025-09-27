package Java_Programs;

//import java.util.*;
//import java.util.LinkedHashMap;
//import java.util.Set;
//
//public class FrequencyDitits {
//
//	static void digitFrequency(long n) {
//
//		HashMap<Long, Integer> digitMap = new LinkedHashMap<Long, Integer>();
//
//		while (n > 0) {
//			long lastNumb = n % 10;
//			if (digitMap.containsKey(lastNumb))
//				digitMap.put(lastNumb, digitMap.get(lastNumb) + 1);
//			else {
//				digitMap.put(lastNumb, 1);
//			}
//			n = n / 10;
//		}
//
//		Set<Long> set = digitMap.keySet();
//		for (Long key : set) {
//			System.out.println(key + ":" + digitMap.get(key));
//		}
//
//	// or
//		// System.out.println(digitMap);
//
//	}
//
//	public static void main(String args[]) {
//		digitFrequency(12346736);
//	}
//
//}

//below is for character frequency

//=============================
//Online Java Compiler
//Use this editor to write, compile and run your Java code online

import java.util.*;

public class FrequencyChar {

	 static void digitFrequency(String s) {
		
		LinkedHashMap<Character,Integer> digitMap = new LinkedHashMap<Character, Integer>();
		char c[]=s.toCharArray();
		
		for(char c1:c){
			if(!(c1==' ')){
			if(digitMap.containsKey(c1))
				digitMap.put(c1, digitMap.get(c1)+1);
				else {
					digitMap.put(c1, 1);
				}
			}
	 }
			System.out.println(s+":"+digitMap);
		for(Map.Entry entry : digitMap.entrySet()){
		    System.out.println("Key: "+entry.getKey()+" "+"Value: "+entry.getValue());
		}

	}
	public static void main(String args[]) {
		digitFrequency("veereshv vee gg");
	}
}

/*
 digits frequency
 import java.util.*;

public class FrequencyOfElementsInArray {

    public static void main(String args[]) {
        LinkedHashMap<Integer, Integer> digitMap = new LinkedHashMap<>();
        int n = 76894678;

        while (n > 0) {
            int digit = n % 10;

            if (digitMap.containsKey(digit)) {
                digitMap.put(digit, digitMap.get(digit) + 1);
            } else {
                digitMap.put(digit, 1);
            }

            n = n / 10;
        }

        System.out.println("Digit Frequencies: " + digitMap);

        for (Map.Entry<Integer, Integer> entry : digitMap.entrySet()) {
            System.out.println("Digit: " + entry.getKey() + " | Frequency: " + entry.getValue());
        }
    }
}
 
 */

//=====================================
//====> frequency off elements in array

/*

import java.util.*;
public class FrequencyOfElementsInArray {
    
		public static void main(String args[]) {
		LinkedHashMap<Integer,Integer> digitMap = new LinkedHashMap<Integer, Integer>();
		int c[]={1,1,2,4,4,5,6};
		for(int c1:c){
			
			if(digitMap.containsKey(c1))
				digitMap.put(c1, digitMap.get(c1)+1);
				else {
					digitMap.put(c1, 1);
				}
			
	 }
			System.out.println(digitMap);
		for(Map.Entry entry : digitMap.entrySet()){
		    System.out.println("Key: "+entry.getKey()+" "+"Value: "+entry.getValue());
		}
	}
	}

//===========================================================
 //  frequency of Strings

/*
 public class FrequencyChar {

	 static void digitFrequency(String s) {
		
		LinkedHashMap<String,Integer> digitMap = new LinkedHashMap<String, Integer>();
		String c[]=s.split(" ");
		
		for(String c1:c){
 			
			if(digitMap.containsKey(c1))
				digitMap.put(c1, digitMap.get(c1)+1);
				else 
					digitMap.put(c1, 1);
				
		}
			System.out.println(s+":"+digitMap);
		for(Map.Entry entry : digitMap.entrySet()){
		    System.out.println("Key: "+entry.getKey()+" "+"- "+entry.getValue());
		}

	}
	public static void main(String args[]) {
		digitFrequency("vee reshv vee reshv gg uyt");
	}
}
 
 */
   
   

//==========================================================


//  without using collections


//class FrequencyOfStrings {
// public static void main(String[] args) {
//String s="java is java is simple programming lan lan java is";
//		String a[]=s.split(" ");
//		int count;
//		
//		for(int i=0;i<a.length;i++) {
//			count=1;
//			if (a[i].equals("0")) {
//             continue;
//         }
//			for(int j=i+1;j<a.length;j++) {
//				if(a[i].equals(a[j])) {
//					count++;
//					a[j]="0";
//				}
//			}
//			if(count>1) 
//				System.out.println(a[i]+"-"+count);
//		else
//		System.out.println(a[i]+"-"+count);
//		
//		}
// }
//}
//=================================================================

//without using collections

/*
 
  class PrintDuplicteChars {
  public static void main(String[] args) {
        System.out.println("Try programiz.pro");
         String s="veer veer is is sup sup hi";
        // String a[]=s.split(" ");
        char c[]= s.toCharArray();
        
        int c1=0;
        for(int i=0;i<c.length;i++){
            c1=1;
            if(c[i]=='0' || c[i]==' '){
                continue;
            }
          
            for(int j=i+1;j<c.length;j++){
                if(c[i]==c[j]){
                    c1++;
                    c[j]='0';
                }
            }
             if(c1>1)
            System.out.println(c[i]+" - "+c1);
        else
        System.out.println(c[i]+" - "+c1);
        }
       
        
    }
}

----------------------------------------------
using integer array

class PrintDuplicteChars {
  public static void main(String[] args) {
        System.out.println("Try programiz.pro");
       
        int c[]={23,65,23,76,56,65};
       
        
        int c1=0;
        for(int i=0;i<c.length;i++){
            c1=1;
          
            for(int j=i+1;j<c.length;j++){
                if(c[i]==c[j]){
                    c1++;
                    c[j]='0';
                }
            }
             if(c1>1)
            System.out.println(c[i]+" - "+c1);
        else
        System.out.println(c[i]+" - "+c1);
        }
       
        
    }
}
*/
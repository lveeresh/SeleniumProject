package Java_Programs;

import java.util.Arrays;

public class Count_Letters_Numbers_SpecialChars {

	public static void main(String[] args) {
		
		String s = "bevr454545@#$*";
        char c1[] = s.toCharArray();
        
        for (char c: c1) {
            if (Character.isDigit(c)) {
                System.out.println("Digit: " + c);
            } else if (Character.isLetter(c)) {
                System.out.println("Letter: " + c);
            } else {
                System.out.println("Special character: " + c);
            }
        }
	}

}


/*
 
 			or
 String s = "bevr454545@#$*";
        char c1[] = s.toCharArray();
        
        for(char c:c1){
            if (Character.isDigit(c)) {
                System.out.println("Digit: " + c);
            } else if (Character.isLetter(c)) {
                System.out.println("Letter: " + c);
            } else {
                System.out.println("Special character: " + c);
            }
        }
 
 */

package Java_Programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

	//1. count the total words in a sentance
	public static void main(String[] args) {
		int c=0;
        String s = "veeresh ahreg djief wrifhw";
        String s1[]=s.split(" ");
        for(String words:s1){
            c++;
        }
        System.out.println(c);
        
        digitFrequency(s);

	}
	
	//Print First non repeating character in from String
	static void digitFrequency(String s) {
        LinkedHashMap<Character, Integer> digitMap = new LinkedHashMap<Character, Integer>();
        char c[] = s.toCharArray();

        for (char c1 : c) {
  //          if (c1 != ' ') {
                if (digitMap.containsKey(c1)) {
                    digitMap.put(c1, digitMap.get(c1) + 1);
                } else {
                    digitMap.put(c1, 1);
                }
  //          }
        }

        System.out.println(s + ": " + digitMap);

        boolean found = false;
        for (Map.Entry<Character, Integer> entry : digitMap.entrySet()) {	//imp is --> generic should be present here, otherwise it will throw an exception
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated char: " + entry.getKey());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeated character found.");
        }
    }
	
	
	

	

}

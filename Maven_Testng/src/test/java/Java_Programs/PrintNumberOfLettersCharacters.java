package Java_Programs;

public class PrintNumberOfLettersCharacters {

	public static void main(String[] args) {
		
		 String s = "ttrghdh1234@#$%^jsduy87";
	        System.out.println(s.length());
	        
	        int l=0,d=0,sc=0;
	        
	        for(char c: s.toCharArray()){
	            if(Character.isLetter(c))
	                l++;
	                else if(Character.isDigit(c))
	                d++;
	                else
	                sc++;
	            
	        }
	        System.out.println("letters " +l);
	        System.out.println("Digits " +d);
	        System.out.println("Special Characters " +sc);

	}

}

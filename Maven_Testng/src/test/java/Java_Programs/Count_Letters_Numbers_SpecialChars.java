package Java_Programs;

public class Count_Letters_Numbers_SpecialChars {

	public static void main(String[] args) {
		
		String s = "bevr454545@#$*";
        char c[] = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                System.out.println("Digit: " + c[i]);
            } else if (Character.isLetter(c[i])) {
                System.out.println("Letter: " + c[i]);
            } else {
                System.out.println("Special character: " + c[i]);
            }
        }
	}

}

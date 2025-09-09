package Java_Programs;

public class StringProgam {

	public static void main(String[] args) {
		
		String s = "HexAwarE";
		
		//output s= hEXaWARe;
		
		StringBuilder build = new StringBuilder();
		char[] c1= s.toCharArray();
		
		for(char c: c1 ) {
			if(Character.isUpperCase(c)) {
				build.append(Character.toLowerCase(c));
			}
			else if(Character.isLowerCase(c)) {
				build.append(Character.toUpperCase(c));
			}
			else {
				build.append((c));
			}
	}
		System.out.println(" input is  :"+s);
		System.out.println(" output is :"+build.toString());

}
}

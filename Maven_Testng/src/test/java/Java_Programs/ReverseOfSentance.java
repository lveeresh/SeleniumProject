package Java_Programs;

public class ReverseOfSentance {

	public static void main(String[] args) {
		
		String s1 = "veeresh lakkandi";
		String reverseString="";
		
		
		String words[]=s1.split(" ");
		
		for(int i=0;i<words.length;i++) {
			String word=words[i];
			String revrseWord="";
			
			for(int j=word.length()-1;j>=0;j--) {
			revrseWord= revrseWord+word.charAt(j);
			}
			reverseString=reverseString+revrseWord+" ";
		}
		
		
		System.out.println(reverseString);

	}

}


//

class HelloWorld1 {
    public static void main(String[] args) {
    	// here == means it will compare the the memory adress not a value 
       String s1="veeresh";	//case-1
       String s2="veeresh";	//case-2     for case-1 and case-2 in both the cases single object will create
       
       String s3= new String("veeresh");	//case-3    single object will create
       String s4= new String("veeresh");	//case-4	another single object will crate
       
        System.out.println(s1==s2);  //true
        System.out.println(s3==s4);	//false
         System.out.println(s3.equals(s4)); 	//true
         System.out.println(s1==s3);		//false
         
         System.out.println(s1.equals(s3));   //true
      
       
    }
}

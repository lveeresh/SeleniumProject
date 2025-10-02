package Java_Programs;

import org.testng.annotations.Test;

public class StringsSwap {

	@Test
	public void swap() {
		String s1="veeresh";
		String s2="lakkandi";
		
		s1 = s1+s2;	//veereshlakkandi
		System.out.println("s1 lenght "+s1.length());
		System.out.println("s2 length "+s2.length());
		
		s2= s1.substring(0,s1.length()-s2.length());	// veeresh
		s1= s1.substring(s2.length()); //it will start from index 7 to last
		
		System.out.println(s1);
		System.out.println(s2);
	
	}

	
	@Test(enabled=false)
	public void twiseLetter() {
		String s1="Testing";  //output: TTeessttiinngg
		
		StringBuilder sb = new StringBuilder();
		char c[]=s1.toCharArray();
		for(char c1:c) {
			sb.append(c1).append(c1);
		}
		
		System.out.println(sb.toString());
		
	
	}

	@Test(enabled=false)
	public void charCount() {
		String s1="abbcccdd";  //output: a1b2c3d2
		
		StringBuilder sb = new StringBuilder();
		char c[]=s1.toCharArray();
		
		int count;
		for (int i=0;i<c.length;i++) {
			if(c[i]==0)
				continue;
		        count=1;
			for(int j=i+1;j<c.length;j++) {
				if(c[i]==c[j]) {
					count++;
					c[j]=0;
					
				}
			}
			
				sb.append(c[i]).append(count);
			
		}
		System.out.println(sb.toString());
		
	
	}

}

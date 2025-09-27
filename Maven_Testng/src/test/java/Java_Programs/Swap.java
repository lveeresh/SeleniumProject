package Java_Programs;

public class Swap {
public static void main(String[] args) {
        
		//concat
        String s ="veeresh";
        String s2="Lakkandi";
        System.out.println("Concat:"+ s.concat(s2));//veereshLakkandi
        
        //Append
        StringBuffer sb = new StringBuffer(s);
        System.out.println("Append :"+ sb.append(s2));//veereshLakkandi
        
        //Swap
        String temp=s;
        s=s2;
        s2=temp;
        System.out.println("Swap: "+s+" "+s2);
    }

}

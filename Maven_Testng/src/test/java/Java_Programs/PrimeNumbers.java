package Java_Programs;

//public class PrimeNumbers {
//
//	public static void main(String[] args) {
//		int c,c1=0;
//		for(int i=1;i<=20;i++) {
//			c=0;
//			for(int j=1;j<=i;j++) {
//				if(i%j==0) 
//					c++;
//					
//			}
//			if(c==2) {
//				c1++;
//				System.out.println(i);
//			}
//		}
//		System.out.println(c1);
//	}
//
//}

//one more method  without using count 
public class PrimeNumbers {

	public static void main(String[] args) {

		int c, c1 = 0;
		for (int i = 1; i <= 20; i++) {

			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					if (j == i) {
						System.out.println(i);

					}
					break;

				}
			}

		}
	}
}

//Reverse of number

class Reverse {
    public static void main(String[] args) {
      int n=1234; int revrse =0;
      
      while(n>0){
          int rem=n%10;
          revrse= revrse*10+rem;
          n= n/10;
      }
      System.out.print(revrse);
    }
}
		

//		int n=7,c=0;
//		for(int i=1;i<=n;i++) {
//			if(n%i==0)
//				c++;
//		}
//		if(c==2)
//			System.out.println("prime");
//		else
//			System.out.println("not prime");
			
//	}
//
//}






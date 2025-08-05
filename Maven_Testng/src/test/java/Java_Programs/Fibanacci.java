package Java_Programs;

public class Fibanacci {

	public static void main(String[] args) {
		int a = 0, b = 1, c = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(a);
			a = b;
			b = c;
			c = a + b;
			
		}
	}
}

// Armstrong number  (153)  hole cube
class HelloWorld {
	public static void main(String[] args) {
		for (int i = 100; i <= 500; i++) {
			int n = i;
			int temp = n;
			int c = 0;
			int sum = 0;
			while (n > 0) {
				n = n / 10;
				c++;
			}
			n = temp;
			while (n > 0) {
				int rem = n % 10;
				n = n / 10;
				sum = sum + (int) Math.pow(rem, c);
			}
			if (temp == sum)
				System.out.println("this is armstrong " + sum);

		}

	}
}


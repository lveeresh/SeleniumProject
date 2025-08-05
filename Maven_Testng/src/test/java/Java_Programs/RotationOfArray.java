package Java_Programs;

public class RotationOfArray {

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5, 6, 7};
		System.out.println("Length of an array is " + ar.length);
		
		int n = ar.length, k = 1;
		while (k <= n-1) {
			
			int[] temp = ar.clone(); // Copy original array
			ratateArray(temp, 0, n-1);
			ratateArray(temp, 0, k - 1);
			ratateArray(temp, k, n-1);
			
			for (int i = 0; i < ar.length; i++) {
				System.out.print(temp[i] + " ");
			}
			
			System.out.println();
			k++;
			
		}
	}

	static void ratateArray(int a[], int i, int j) {
		while (i < j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++;
			j--;
		}
	}
	

}

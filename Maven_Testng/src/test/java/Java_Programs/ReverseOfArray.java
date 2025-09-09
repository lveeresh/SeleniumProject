package Java_Programs;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReverseOfArray {

	public static void main(String[] args) {

		int ar[] = { 12, 34, 65, 11, 9, 5 };
		
		
		//original array
		for (int i = 0; i < ar.length; i++) {
			System.out.print(" "+ar[i]);
		}
		
		reverse(ar);
		
		//reversed array
		System.out.println();
		for (int i = 0; i < ar.length; i++) {
			System.out.print(" "+ar[i]);
		}

	}

	public static void reverse(int a[]) {
		int i = 0, j = a.length-1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;

		}
	}

}

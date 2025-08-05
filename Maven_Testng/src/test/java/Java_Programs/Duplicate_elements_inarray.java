package Java_Programs;

public class Duplicate_elements_inarray {

	public static void main(String[] args) {
		
		int a[]= {12,34,43,12,34,65,76,34};
		
		int count,c2=0;
		
		for(int i=0;i<a.length;i++) {
			count=1;
			for(int j=i+1;j<a.length;j++) {
				if(a[i]==a[j]) {
					count++;
					a[j]=0;
					
				}
			}
			if(count>1&&a[i]!=0) {
				System.out.println("Duplicate elements are:"+a[i]);
				c2++;
			}
		}
		System.out.println(c2);

	}

}


//Duplicate character count************

//public class Duplicate_characters_inarray {
//
//	public static void main(String[] args) {
//		int c1,c2=0;
//		String s="veeresh lakkandi veer";
//		char a[]=s.toCharArray();
//		
//		for(int i=0;i<a.length;i++) {
//			c1=1;
//			for(int j=i+1;j<a.length;j++) {
//				if(a[i]==a[j] && a[i]!=' ') {
//					c1++;
//				a[j]='0';
//				}
//			}
//			if(c1>1 && a[i]!='0') {
//				System.out.println("Duplicate elements are:"+a[i]);
//			c2++;
//				}
//			
//		}
//		System.out.println(c2);
//
//
//	}
//
//}



//  Duplicate strings*****

//public class Duplicate_strings {
//
//	public static void main(String[] args) {
//		
//		//int a[]= {12,34,43,12,34,65,76,34};
//		String s="vvv tttt uuuu oooooo vvv uuuu";
//		String a[]=s.split(" ");
//		int count,c2=0;
//		
//		for(int i=0;i<a.length;i++) {
//			count=1;
//			for(int j=i+1;j<a.length;j++) {
//				if(a[i].equals(a[j])) {
//					count++;
//					a[j]="0";
//					
//				}
//			}
//			if(count>1&&a[i]!="0") {
//				System.out.println("Duplicate elements are:"+a[i]);
//				c2++;
//			}
//		}
//		System.out.println(c2);
//
//	}
//
//}

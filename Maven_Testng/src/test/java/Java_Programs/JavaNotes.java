package Java_Programs;

public class JavaNotes {
/*
 
1. How to create dynamic array ?
 
 	In Java, we use ArrayList to create a dynamic array. Unlike regular arrays, ArrayList can grow or shrink in size as needed.

	import java.util.ArrayList;
	public class Main {
	    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Printing elements
        System.out.println(numbers);

        // Removing an element
        numbers.remove(1); // removes 20

        // Printing updated list
        System.out.println(numbers);
    }
	}

2. Can we create constructor for abstract class?
 	Ans: yes

	abstract class Animal {
	    Animal() {
	        System.out.println("Animal constructor called");
	    }
	}
	class Dog extends Animal {
	    Dog() {
	        System.out.println("Dog constructor called");
	    }
	}
	public class Main {
	    public static void main(String[] args) {
	        Dog d = new Dog();
	    }
	}
	output:
	Animal constructor called
	Dog constructor called

3. Can main method overloaded and Overriden?

	Ovetload:
	Yes, the main() method can be overloaded in Java
	public class Test {
	    public static void main(String[] args) {
	        System.out.println("Main with String[] args");
	        main(10); // calling overloaded method
	    }
	
	    public static void main(int x) {
	        System.out.println("Overloaded main with int: " + x);
	    }
	}
	Output:
	Main with String[] args
	Overloaded main with int: 10


	Override:
	No, the main() method cannot be overridden because it is static, and static methods belong to the class,not the object

4.  can write non abstract method in interface?
 	Yes since java 8 we can write, but only as default, static or private methids(java 8+)
 
5. can execute java program without main?
	No
	
6. You can't use catch without try

7. Can we declare main method as private?
	Yes, you can declare the main() method as private, but the program will not run properly because the Java Virtual Machine
 	(JVM) won’t be able to access it.
 	
 	The JVM looks for a public static void main(String[] args) method to start the program. If it's not public, 
 	the JVM cannot access it, and you'll get a runtime error.
	
	Error: Main method not found in class Test

8. How to find whether an array is empty or null?

	int a[]={};--> empty array
	 int arr[]=null;--> array was not created
	 
	to check empty :
	 if (arr.length == 0) {
	    System.out.println("Array is empty");
	}
	
	to check null:
	if (arr == null) {
	    System.out.println("Array is null");
	}


9. can we overload private methods?
	yes
	
10. Exception hirarchy?

11. Loose Couple vs Tightly couple?

	Tight Coupling:
	Parts of the classes/system are dependent on each other.
	If one part changes, others may break.
	Harder to maintain and update.
 
 	Loose Coupling
	Parts of the system are independent.
	One part can change without affecting the other.
	Easier to maintain, test, and reuse.
	 
12. Why string are immutable?
	Strings are used in important places like passwords, file paths, and URLs, Java makes them unchangeable & keep them safe.
 
 
 
13. What is HashTable in collection ?
 	
	Hash table is similar to HashMap but there is few advantanges for using HashMap
	
	its a predefine class available in in java.util package
	it stores the data in the form of keyValue pair
	it doesnt allow the null key or null value
	its a synchronised and thread safe
	
14. Synchronisation vs Non-Synchronisation
	
	sysnchronization: means thread safe
	only one thread can access the object/method at a time
	
	No-Synchronisation: means not thread safe
	multiple threads can access the object simoultaneously
	
15. Garbage collector?
	Garbage collector in java is a process of removes object from memory that are no longer needed.

16. What is docker?
	Docker is like a tool packaging an application and its required dependencies into a container, so it can run any platform
	without any problem. 
	
	
17. All RunTImeExceptions?
 	1.Number format exception?
	A NumberFormatException in Java is a runtime exception that occurs when you try to convert a string into a numeric type
	(like int, float, double, etc.) and the string does not have a valid format for that type.
	 
 	String s = "abc";
	int num = Integer.parseInt(s); // This will throw NumberFormatException

	2. ArrayIndexOutOfBoundsException
	Definition:
	Thrown when you try to access an array index that does not exist.
	Example:
	int[] arr = {1, 2, 3};
	System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
	
	3. ArithmeticException
	Definition:
	Thrown when an exceptional arithmetic condition occurs, such as division by zero.
	Example:
	int a = 10 / 0; // ArithmeticException
	
	4. IllegalArgumentException
	Definition:
	Thrown when a method receives an argument that is inappropriate.
	Example:
	Thread.sleep(-100); // IllegalArgumentException


 
 */

}

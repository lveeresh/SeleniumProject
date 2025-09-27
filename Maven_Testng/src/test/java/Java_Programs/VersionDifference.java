package Java_Programs;

public class VersionDifference {

	public static void main(String[] args) {
		
	/*	
		Step 1: Functional Programming with Lambda Expressions
		
		java 7: Only anonymous inner classes for functional behavior.
		Java 8: Introduced lambda expressions for concise function definitions.
		// Java 7
		Runnable r = new Runnable() {
		    public void run() {
		        System.out.println("Running");
		    }
		};
		// Java 8
		Runnable r = () -> System.out.println("Running");


		Step 2: Stream API for Collections
		
		Before Java 8: Manual iteration using loops.
		Java 8: Introduced Streams for functional-style data processing.	
		// Java 7
		for (String name : list) {
		    if (name.startsWith("V")) {
		        System.out.println(name);
		    }
		}
		// Java 8
		list.stream().filter(name -> name.startsWith("V"))
					 .forEach(System.out::println);


		Step 3: Default Methods in Interfaces
		
		Before Java 8: Interfaces could not have method bodies.
		Java 8: Allowed default and static methods in interfaces.

		interface MyInterface {
		    default void show() {
		        System.out.println("Default method");
		    }
		}


		Step 4: New Date and Time API
		
		Before Java 8: Used java.util.Date and Calendar (not thread-safe).
		Java 8: Introduced java.time package (immutable and thread-safe).
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);
		
		
		Step 5: Optional Class to Avoid Nulls
		
		Before Java 8: Manual null checks.
		Java 8: Introduced Optional<T> to handle absence of values safely.
		
		JavaOptional<String> name = Optional.ofNullable(null);
		System.out.println(name.orElse("Default Name"));
		
				
	*/	

	}

}

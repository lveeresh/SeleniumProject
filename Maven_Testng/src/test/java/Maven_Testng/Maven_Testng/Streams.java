package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Streams {

	//remove duplicates using stream distinct() method
	
    @Test
    public void removeDuplicateUsingStream() {
        List<String> names = Arrays.asList("Apple", "banana", "manago", "Apple");
        List<Object> uniqueNames = names.stream()
                                        .distinct()
                                        .collect(Collectors.toList());
        System.out.println(uniqueNames); // Output: [Apple, banana, manago]
        
        
    }
}


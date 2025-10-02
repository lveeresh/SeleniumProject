package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Streams {

	//remove duplicates using stream distinct() method
	
    @Test
    public void removeDuplicateUsingStream() {
        List<String> names = Arrays.asList("Apple", "banana", "manago", "Apple","pine","banana");
        
        List<Object> uniqueNames = names.stream()
                                        .distinct()
                                        .collect(Collectors.toList());
        System.out.println(uniqueNames); 			// Output: [Apple, banana, manago]
        
        
        
//        Set<String> set = new HashSet<>(names);
//        names = new ArrayList(set);  //still work if u remove this line
//        System.out.println("using set :: "+set);
    }
}


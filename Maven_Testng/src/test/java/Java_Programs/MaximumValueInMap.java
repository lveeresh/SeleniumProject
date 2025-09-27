package Java_Programs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaximumValueInMap {
	public static void main(String[] args) {
	
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("grapes", 10);
		map.put("apple", 10);
        map.put("banana", 25);
        map.put("orange", 15);   
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
       // Map.Entry<String, Integer> minValue = list.get(0);
        Map.Entry<String, Integer> maxValue = list.get(0);      
        for(Map.Entry<String, Integer> entry : list) {
        	
//        	if(entry.getValue()<minValue.getValue()) {
//        		minValue = entry;
//        	}
        	
        	if(entry.getValue()>maxValue.getValue()) {
        		maxValue = entry;
        	}
        }
        System.out.println("Map: " + map);
        System.out.println("Highest Value: " + maxValue.getValue() + " (Key: " + maxValue.getKey() + ")");
	}
}
//---------------------------------------------------------------------

/*
 * using stream
class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 25);
        map.put("orange", 15);
        map.put("grape", 30);
        map.put("mango", 20);

        // Get the entry with the maximum value using streams
        Map.Entry<String, Integer> maxEntry = map.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null); // in case map is empty

        if (maxEntry != null) {
            System.out.println("Maximum Value: " + maxEntry.getValue() + " (Key: " + maxEntry.getKey() + ")");
        } else {
            System.out.println("Map is empty.");
        }
    }
}
*/

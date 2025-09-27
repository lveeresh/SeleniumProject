package Java_Programs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MinValueInMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("grapes", 10);
		map.put("apple", 10);
        map.put("banana", 25);
        map.put("orange", 15);
        
//       this will work perfectly above java 8 version we r using comparingByValue() method 
        
//        Map.Entry<String, Integer> entry = map.entrySet()
//        									.stream()
//        									.min(Map.Entry.comparingByValue())
//        									.orElse(null);
//        
//        if (entry != null) {
//            System.out.println("Maximum Value: " +entry.getValue() + " (Key: " + entry.getKey() + ")");
//        } else {
//            System.out.println("Map is empty.");
//        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
         Map.Entry<String, Integer> minValue = list.get(0);
            
         for(Map.Entry<String, Integer> entry : list) {         	
         	if(entry.getValue()<minValue.getValue()) {
         		minValue = entry;
         	}
         		
         }
         System.out.println("Map: " + map);
         System.out.println("Highest Value: " + minValue.getValue() + " (Key: " + minValue.getKey() + ")");
  
	}

}

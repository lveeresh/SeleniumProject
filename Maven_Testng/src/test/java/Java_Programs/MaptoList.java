package Java_Programs;

import java.util.*;

public class MaptoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> mp = new HashMap<Integer, String>();
		
		mp.put(1,"veeresh");
		mp.put(2,"lakkandi");
		mp.put(3,"capgemini");
		mp.put(4,"Tester");
		
		List<Integer> lst= new ArrayList(mp.entrySet());
		
						//or
		//List<String> lst1= new ArrayList(mp.keySet());
		//List<String> lst2= new ArrayList(mp.valueSet());
		
		System.out.println("keyset and valueset is :"+lst);
		
		System.out.println("value and keys from map only :"+mp.entrySet());
		
		
		

	}

}

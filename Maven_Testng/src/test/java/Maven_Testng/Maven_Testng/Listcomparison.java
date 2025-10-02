package Maven_Testng.Maven_Testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Listcomparison {
	WebDriver driver;
	@Test()
	public void compareList() {
		
		List<String> listNames = Arrays.asList("p1","p2","p3");
		
		List<String> actualNames = Arrays.asList("p3","p2","p1");
		Collections.sort(actualNames);
		Collections.sort(listNames);
//		List<WebElement> actualNames = driver.findElements(By.xpath("//div[@id='product']"));
//		List<String> list = new ArrayList<>();
//		
//		for(WebElement el: actualNames) {
//			list.add(el.getText());
//		}
//		
//		if(listNames.equals(list)) {
//			System.out.println("Pass List are equal");
//		}
//		else {
//			System.out.println("Pass List are not equal");
//		}
		
		
		if (listNames.equals(actualNames)) {
            System.out.println("list are equal");
        } else {
            System.out.println("lists are not equal");
        }
		
	}
	
	@Test
	public void compareMap() {

		Map<String, String> map1 = new HashMap<>();
        map1.put("A", "Apple");
        map1.put("B", "Banana");

        Map<String, String> map2 = new HashMap<>();
        map2.put("B", "Banana");
        map2.put("A", "Apple");

        if (map1.equals(map2)) {
            System.out.println("Maps are equal");
        } else {
            System.out.println("Maps are not equal");
        }

	}

}

package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void testLogin(String username, String password) {
    	/*
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        driver.quit();
        */
    	 System.out.println("UserID: " + username);
         System.out.println("Password: " + password);
    }
}


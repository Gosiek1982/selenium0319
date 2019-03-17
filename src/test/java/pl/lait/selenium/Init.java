package pl.lait.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {                   //to jest taka klasa Start, tu jest getdriver
	
	static WebDriver driver;
	
    public static WebDriver getDriver() {
    	System.setProperty("webdriver.chrome.driver","C:\\lait\\chromedriver_win32\\chromedriver.exe");
    	if(driver == null) {
    		driver = new ChromeDriver();
    		driver.get("http://newtours.demoaut.com/");
    		return driver;
    	} else {
    		return driver;         //to if zrby przegladarka sie ciagle nie otwierała przy kazdym tescie
    	}
    	    	
    	  	
}
    
    public static void log(String msg) {
    	System.out.println(" --- " + msg + "---");
    }

     public static void close() {
    	 driver.close();
    	 driver.quit();
    	 driver = null;
     }
     
     public static void sleep(int seconds) {
    	 try {
 			Thread.sleep(seconds * 1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
	}
	
	


package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Browser {		
	
	 public static WebDriver driver;
	 
	 public static ChromeOptions option ; 
	 
	 public Browser()
	 {
		 driver = getDriver();
	 }
	 
	    public static WebDriver getDriver() 
	    {         
	    	option = new ChromeOptions();
	    	option.addArguments("--start-maximized");
	    	option.addArguments("--disable-notifications");
	    	option.addArguments("--disable-extentions");
	    	option.addArguments("--disable-popup-blocking");
	    	option.addArguments("--disable-gpu");
	    	option.addArguments("--incognito");	        
	        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	       // option.addArguments("--headless");
	        
	        driver = new ChromeDriver(option);
	        return driver;
	    }
	} 
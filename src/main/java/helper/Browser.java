package helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {		
	
	 Properties prop;
	 public static WebDriver driver;
	 public static ChromeOptions option ; 
	 public static EdgeOptions edgeOption ; 
	 public static FirefoxOptions fireFoxOption ; 
	 File partialDownloadPath;
	 String downloadPath;

	 public void setDriver(WebDriver initializedDriver)
	 {
		 driver = initializedDriver;
	 }
	 
	 public static WebDriver getDriver()
	 {
		 return driver;
	 }
	 
	 public WebDriver getChromeDriver()
	 {
		partialDownloadPath = new File(ConfigReader.get("downloadPath"));
	    downloadPath = partialDownloadPath.getAbsolutePath();
	    
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath); 
		prefs.put("download.prompt_for_download", false);
		
		option = new ChromeOptions();
		
		option.setExperimentalOption("prefs", prefs);
	 	option.addArguments("--start-maximized");
	 	option.addArguments("--disable-notifications");
	 	option.addArguments("--disable-extentions");
	 	option.addArguments("--disable-popup-blocking");
	 	option.addArguments("--disable-gpu");
	 	option.addArguments("--no-sandbox");
	 	option.addArguments("--incognito");	        
	    option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	
	     if(ConfigReader.get("headless").contains("true")) 
	     {
	    	option.addArguments("--headless");
	     }
	             	     
	     driver = new ChromeDriver(option);	     
	     return driver;			 
	 }
	 
	 public WebDriver getEdgeDriver()
	 {
		 edgeOption = new EdgeOptions();
		 edgeOption.addArguments("--start-maximized");
		 edgeOption.addArguments("--disable-notifications");
		 edgeOption.addArguments("--disable-extentions");
		 edgeOption.addArguments("--disable-popup-blocking");
		 edgeOption.addArguments("--disable-gpu");
		 edgeOption.addArguments("--no-sandbox");
		 edgeOption.addArguments("--incognito");	        
		 edgeOption.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		 		  
	     if(ConfigReader.get("headless") == "true") 
	     {
	    	 edgeOption.addArguments("--headless");
	     }	
	     	     
		 driver = new EdgeDriver(edgeOption);
		 return driver;
	 }
	 
	 public WebDriver getFireFoxDriver()
	 {
		 fireFoxOption = new FirefoxOptions(); 		 
		 fireFoxOption.addArguments("--start-maximized");
		 fireFoxOption.addArguments("--disable-notifications");
		 fireFoxOption.addArguments("--disable-extentions");
		 fireFoxOption.addArguments("--disable-popup-blocking");
		 fireFoxOption.addArguments("--disable-gpu");
		 fireFoxOption.addArguments("--no-sandbox");
		 fireFoxOption.addArguments("--incognito");	        
				 
		 if(ConfigReader.get("headless") == "true") 
	     {
			 fireFoxOption.addArguments("--headless");
	     }	
		 
		 driver = new FirefoxDriver(fireFoxOption);		 
		 return driver;
	 }
	 
	 WebDriver getBrowserDriver(String browser)
	 {
		 switch(browser.toLowerCase())
		 {
		 	case "chrome":
		 		return getChromeDriver();
		 	case "edge":
		 		return getEdgeDriver();
		 	default:
		 		return getFireFoxDriver();
		 }
	 }	 	    
	} 
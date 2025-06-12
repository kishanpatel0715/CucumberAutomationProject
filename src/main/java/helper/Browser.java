package helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import runner.TestRunner;

public class Browser {		
	
	 public static WebDriver driver;
	 public static ChromeOptions option ; 
	 public static EdgeOptions edgeOption ; 
	 static File partialDownloadPath;
	 static String downloadPath;

	 private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	 
	 public static void setBrowserDriverInstance(String browser)
	 {
		threadLocalDriver.set(getBrowserDriverInstance(browser));
	 }
	 
	 public static WebDriver getBrowserDriverInstance()
	 {
		 return threadLocalDriver.get();
	 }
	 
	 public static WebDriver createChromeDriver()
	 {
		partialDownloadPath = new File(TestRunner.downloadPath);
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
	
	    driver = new ChromeDriver(option);	 
	    return driver;			 
	 }
	 
	 public static WebDriver createEdgeDriver()
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
		 		  
		 driver = new EdgeDriver(edgeOption);
		 return driver;
	 }
	 
	 public static WebDriver getBrowserDriverInstance(String browser)
	 {
		 if(browser.toLowerCase().contains("chrome"))
		 {
		 	 return createChromeDriver();
		 }
		 
		 else
		 {
		 	 return createEdgeDriver();
		 }
	 }	 	    
	} 
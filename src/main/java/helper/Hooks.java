package helper;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import runner.TestRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class Hooks {
	
    WebDriver driver;		
	Properties prop;
	
	@Before
	public void setup()
	{
		Browser.setBrowserDriverInstance(TestRunner.browser);
		driver = Browser.getBrowserDriverInstance();
	}
	
	@After (order = 1)
	public void teardown(Scenario scenario)
	{
		 if (!scenario.getSourceTagNames().contains("@API")) 
		 {
			 driver.quit();
		 }
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException 
	{
		if (!scenario.getSourceTagNames().contains("@API")) 
		{
	    if (scenario.isFailed()) {

	    TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
	    File sourceScreenShot = takeScreenshot.getScreenshotAs(OutputType.FILE);
	        
	    File relativePath = new File(TestRunner.screenshotPath);
	    String screenshotDirectory = relativePath.getAbsolutePath();    
	    File screenshotDir = new File(screenshotDirectory);
	        
        if (!screenshotDir.exists()) 
        {
	      screenshotDir.mkdirs();
	    }

	   String screenshotName = scenario.getName().replace(" ", "_") + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";

	   Path destFilePath = Paths.get(screenshotDirectory, screenshotName);
       File destSSFile = new File(destFilePath.toString());	     
	   Files.copy(sourceScreenShot, destSSFile);	     	        	        	    
	   }
	   }
	}	
}
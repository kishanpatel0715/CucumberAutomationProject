package runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java",
        glue = {"steps", "helper", "Models", "pages", "context", "api_Steps", "api_Pages"},
        plugin = {"pretty", "html:target/CucumberHtmlReport.html", "json:target/cucumber.json"},
        monochrome = true,
        tags = "@DynamicProperties" 
        )
        
public class TestRunner extends AbstractTestNGCucumberTests {
	
	public static String browser;
	public static String baseUrlSauceDemo;
	public static String baseUrlDemoQa;
	public static String downloadPath;
	public static String uploadPath;
	public static String screenshotPath;
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser","baseUrlSauceDemo","baseUrlDemoQa","downloadPath","uploadPath","screenshotPath"})
	public void setParameters(String browserParam, String baseUrlSauceDemoParam, String baseUrlDemoQaParam, String downloadPathParam, String uploadPathParam, String screenshotPathParam)
	{
		browser = browserParam;
		baseUrlSauceDemo = baseUrlSauceDemoParam;
		baseUrlDemoQa = baseUrlDemoQaParam;
		downloadPath = downloadPathParam;
		uploadPath = uploadPathParam;
		screenshotPath = screenshotPathParam;
	}
}
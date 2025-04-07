package helper;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;


public class Hooks {
	
public WebDriver driver;
	
	public Hooks()
	{		
		this.driver = Browser.driver;	
	}
	
	@After (order = 1)
	public void teardown()
	{
		driver.quit();
	}
	
	/*
	@Before (value = "@One", order =1)
	public void setupOne()
	{
		System.out.println("Before Method with order 1 gets executed before order 2");		
	}
	
	
	@Before (order=2)
	public void setupTwo()
	{		
		System.out.println("Before Method with order 2 gets executed after order 1");	
	} */
		
	/*
	@After (order=2)
	public void teardown2()
	{
		System.out.println("After Method with order 2 gets executed before order 1");
		driver.quit();
	}
	*/

	/*
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("Method gets executed before each step");
	}
	
	@AfterStep
	public void afterStepstep()
	{
		System.out.println("Method gets executed after each step");
	} */
}

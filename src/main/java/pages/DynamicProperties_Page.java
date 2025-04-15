package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicProperties_Page {
	
	WebDriver driver;
	
	public DynamicProperties_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 public By visibleAfter5SecElement = By.id("visibleAfter");
	 public By enabledAfter5SecElement = By.id("enableAfter");
}
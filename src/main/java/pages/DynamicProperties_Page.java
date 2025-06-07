package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Browser;

public class DynamicProperties_Page {
	
	WebDriver driver = Browser.getDriver();;
	
	 public By visibleAfter5SecElement = By.id("visibleAfter");
	 public By enabledAfter5SecElement = By.id("enableAfter");
}
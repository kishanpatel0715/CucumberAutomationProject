package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Browser;

public class DynamicProperties_Page {
	
	WebDriver driver = Browser.getBrowserDriverInstance();
	
	 public By visibleAfter5SecElement = By.id("visibleAfter");
	 public By enabledAfter5SecElement = By.id("enableAfter");
	 public By DynamicPropertiesSubmenuElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[9]/span");
	 
	 public void selectDynamicPropertiesFromSubMenu()
	 {
		 driver.findElement(DynamicPropertiesSubmenuElement).click();
	 }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Browser;

public class WindowsTab_Page {

	WebDriver driver = Browser.getBrowserDriverInstance();
	
	public By newTabElement = By.id("tabButton");
	public By newTabTextElement = By.id("sampleHeading");
	public By newWindowElement = By.id("windowButton");
	public By newWindowTextElement = By.id("sampleHeading");
	public By BrowserWindowsSubmenuElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[1]/span");
	
	 public void selectBrowserWindowsFromSubMenu()
	 {
		 driver.findElement(BrowserWindowsSubmenuElement).click();
	 }

	public void openNewTab()
	{
	    driver.findElement(newTabElement).click();
	}

	public void openNewWindow()
	{
	    driver.findElement(newWindowElement).click();
	}

	public String getNewTabText()
	{
		return driver.findElement(newTabTextElement).getText();
	}

	public String getNewWindowText()
	{
	    return driver.findElement(newWindowTextElement).getText();
	}
}
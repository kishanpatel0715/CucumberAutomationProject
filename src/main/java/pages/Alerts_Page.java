package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Browser;

public class Alerts_Page {

	WebDriver driver = Browser.getBrowserDriverInstance();;
	
	public By AlertElement = By.id("alertButton");
	public By DelayedAlertElement = By.id("timerAlertButton");
	public By ConfirmBoxElement = By.id("confirmButton");
	public By ConfirmResultTextElement = By.xpath("//*[text()='Cancel' or text()='Ok']");
	public By PromptElement = By.id("promtButton");
	public By AlertsFrameWindowsMenuElement = By.xpath("//*[text()='Alerts, Frame & Windows']");
	public By AlertsSubmenuElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[2]/span");
	
	public void selectAlertsFrameWindowsFromMenu()
	{
		driver.findElement(AlertsFrameWindowsMenuElement).click();
	}
	
	public void selectAlertsFromSubMenu()
	{
		driver.findElement(AlertsSubmenuElement).click();
	}
	
	public WebElement GetEnteredNameSuccessText(String name)
	{
	    return driver.findElement(By.xpath("//*[text()= '" + name + "']"));
	}

	public void openAlert()
	{
	    driver.findElement(AlertElement).click();
	}

	public void openDelayedAlert()
	{
	    driver.findElement(DelayedAlertElement).click();
	}

	public void openConfirmBoxPopUp()
	{
	    driver.findElement(ConfirmBoxElement).click();
	}

	public void openPromptBoxPopUp()
	{
	    driver.findElement(PromptElement).click();
	}
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Browser;
import helper.CommonMethods;

public class Alerts_Page {

	WebDriver driver = Browser.getDriver();;
    CommonMethods commonMethods;
	
	public Alerts_Page(WebDriver driver)
	{
        commonMethods = new CommonMethods();
	}
	
	public By AlertElement = By.id("alertButton");
	public By DelayedAlertElement = By.xpath("//*[contains(@id, 'timerAlert')]");
	public By ConfirmBoxElement = By.xpath("//*[starts-with(@id, 'confirmButton')]");
	public By ConfirmResultTextElement = By.xpath("//*[text()='Cancel' or text()='Ok']");
	public By PromptElement = By.id("promtButton");

	public WebElement GetEnteredNameSuccessText(String name)
	{
	    return driver.findElement(By.xpath("//*[text()= '" + name + "']"));
	}

	public void openAlert()
	{
	    commonMethods.click(AlertElement);
	}

	public void openDelayedAlert()
	{
	    commonMethods.click(DelayedAlertElement);
	}

	public void openConfirmBoxPopUp()
	{
	    commonMethods.click(ConfirmBoxElement);
	}

	public void openPromptBoxPopUp()
	{
	    commonMethods.click(PromptElement);
	}
}
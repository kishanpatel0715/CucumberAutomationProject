package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Browser;

public class FirstPage {
	
	WebDriver driver = Browser.getDriver();;
	
    private By userNameEle = By.id("user-name");
	private By passwordEle = By.name("password");
	private By loginEle = By.cssSelector("input[type=submit]");
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
	}

	public void enterUserNamePassword(String userName, String password)
	{
		driver.findElement(userNameEle).sendKeys(userName);
		driver.findElement(passwordEle).sendKeys(password);
	}
	
	public void login()
	{
		driver.findElement(loginEle).click();
	}
}
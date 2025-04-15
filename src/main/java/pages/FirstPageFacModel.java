package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FirstPageFacModel {

	WebDriver driver;
	
	public FirstPageFacModel(WebDriver driver)
	{
		this.driver = driver;
		AjaxElementLocatorFactory driverAJ = new AjaxElementLocatorFactory(driver,3); 
		PageFactory.initElements(driverAJ, this);
	}
	
	@FindBy(id="user-name")
	WebElement userNameWebEle; 
	
	@FindBy(name="password")
	WebElement passwordWebEle; 
	
	@FindBy(css="input[type=submit]")
	WebElement loginWebEle; 
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
	}

	public void enterUserNamePassword(String userName, String password)
	{
		userNameWebEle.sendKeys(userName);
		passwordWebEle.sendKeys(password);
	}
	
	public void login()
	{
		loginWebEle.click();
	}
}
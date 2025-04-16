package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.WaitHelper;

public class Login_Page {

	WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By userNameElement = By.id("user-name");
	public By passwordElement = By.id("password");
	public By loginElement = By.id("login-button");  
	public By logoutElement = By.id("logout_sidebar_link");
	public By loginErrorMessageElement = By.className("error-message-container");
	public By sideMenuElement = By.id("react-burger-menu-btn");

	public void enterCredential(String userName, String password)
	{
	    driver.get("https://www.saucedemo.com/");

	    driver.findElement(userNameElement).sendKeys(userName);
	    driver.findElement(passwordElement).sendKeys(password);          
	}

	public void login()
	{
	    driver.findElement(loginElement).click();
	}

	public void opensMenu()

	{
	    driver.findElement(sideMenuElement).click();
	}

	public void logout()
	{
	    new WaitHelper().waitForElementToBeVisible(logoutElement, 5);
	    driver.findElement(logoutElement).click();
	}
}
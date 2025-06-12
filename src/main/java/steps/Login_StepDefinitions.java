package steps;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import helper.Browser;
import helper.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;
import runner.TestRunner;

public class Login_StepDefinitions {

	Login_Page loginPage;
    WaitHelper waitHelper;
    WebDriver driver;
  
	public Login_StepDefinitions()
	{
		   driver = Browser.getBrowserDriverInstance(); 
		   loginPage = new Login_Page();
		   waitHelper = new WaitHelper();
	}
	
    @Given("User is on the login page")
    public void user_is_on_the_login_page()
    {
       driver.get(TestRunner.baseUrlSauceDemo);
    }
    
    @When("user enters {string} and {string}")
    public void user_enters_and(String userName, String password)
    {
    	loginPage.enterCredential(userName, password);
    }
    
    @When("user login")
    public void User_Login()
    {
    	loginPage.login();
    }
    
    @Then("user is logged-in successfully")
    public void user_is_loggedin_successfully()
    {
    	boolean isSideMenuIsDisplayed;
    	try
        {
    	   isSideMenuIsDisplayed = waitHelper.waitForElementToBeVisible(loginPage.sideMenuElement,4).isDisplayed();
    	}

        catch(NoSuchElementException e)
        {
    	   isSideMenuIsDisplayed = false;
    	}

        Assert.assertTrue(isSideMenuIsDisplayed, "Login is failed");
    }
    
    @When("^user enters invalid (.*) and (.*)$")
    public void user_enters_invalid_credentials(String userName, String password)
    {
        loginPage.enterCredential(userName, password);
    }
    
    @When("user opens side-menu")
    public void user_opens_sidemenu()
    {
    	loginPage.opensMenu();
    }
    
    @When("user logout")
    public void user_logout()
    {
    	loginPage.logout();
    }
    
    @Then("Error message is displayed")
    public void error_message_is_displayed()
    {
    	boolean isErrorMessageDisplayed;

    	try
    	{
    		isErrorMessageDisplayed = waitHelper.waitForElementToBeVisible(loginPage.loginErrorMessageElement, 5).isDisplayed();
    	}

    	catch(NoSuchElementException e)
        {
    	    isErrorMessageDisplayed = false;
        }

        Assert.assertTrue(isErrorMessageDisplayed, "Invalid user gets logged in successfully");
    	}
    
    @Then("user is logged-out")
    public void user_is_loggedout()
    {
        boolean isLoginButtonDisplayed;

    	try
    	{
    		 isLoginButtonDisplayed = waitHelper.waitForElementToBeVisible(loginPage.loginElement, 5).isDisplayed();
    	}

    	catch (NoSuchElementException e)
    	{
    		 isLoginButtonDisplayed = false;
    	}

        Assert.assertTrue(isLoginButtonDisplayed, "Logout is failed");
    }
}
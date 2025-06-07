package steps;

import java.util.NoSuchElementException;
import org.junit.Assert;
import helper.Browser;
import helper.CommonMethods;
import helper.ConfigReader;
import helper.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;

public class Login_StepDefinitions {

	Login_Page loginPage;
	CommonMethods commonMethods;
    WaitHelper waitHelper;
  
	public Login_StepDefinitions(Browser manageDriver)
	{
		   loginPage = new Login_Page();
		   commonMethods = new CommonMethods();		
		   waitHelper = new WaitHelper();
	}
	
    @Given("User is on the login page")
    public void GivenUserIsOnTheLoginPage()
    {
       commonMethods.visit(ConfigReader.get("baseUrl"));
    }
    
    @When("user enters {string} and {string}")
    public void WhenUserEntersAnd(String userName, String password)
    {
    	loginPage.enterCredential(userName, password);
    }
    
    @When("user login")
    public void WhenUserLogin()
    {
    	loginPage.login();
    }
    
    @Then("user is logged-in successfully")
    public void ThenUserIsLogged_InSuccessfully()
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

        Assert.assertTrue("Login is failed", isSideMenuIsDisplayed);
    }
    
    @When("^user enters invalid (.*) and (.*)$")
    public void WhenUserEntersInvalidCredentials(String userName, String password)
    {
        loginPage.enterCredential(userName, password);
    }
    
    @When("user opens side-menu")
    public void WhenUserOpensSideMenu()
    {
    	loginPage.opensMenu();
    }
    
    @When("user logout")
    public void WhenUserLogout()
    {
    	loginPage.logout();
    }
    
    @Then("Error message is displayed")
    public void ThenErrorMessageIsDisplayed()
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

        Assert.assertTrue("Invalid user gets logged in successfully", isErrorMessageDisplayed);
    	}
    
    @Then("user is logged-out")
    public void ThenUserIsLogged_Out()
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

        Assert.assertTrue("Logout is failed", isLoginButtonDisplayed);
    }
}
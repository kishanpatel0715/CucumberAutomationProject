package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import helper.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstPage;
import pages.FirstPageFacModel;

public class FirstSteps {
	
	FirstPage firstPage;
	WebDriver driver;
	FirstPageFacModel firstPageFacModel;

	
	public FirstSteps(Browser manageDriver)
	{
		driver = Browser.driver;
		firstPage = new FirstPage(driver);
				
		//firstPageFacModel = new FirstPageFacModel(webDriver);
	}
 
	@Given("User is on the login page")
	public void user_is_on_the_login_page() 
	{		
		firstPage.navigateToUrl("https://www.saucedemo.com/");
		
		//firstPageFacModel.navigateToUrl("https://www.saucedemo.com/");
	}
	
	@When("User enters {string} or {string}")
	public void user_enters_and(String userName, String password) 
	{
		firstPage.enterUserNamePassword(userName, password);	
		
		//firstPageFacModel.enterUserNamePassword(userName, password);	
	}
	
	@When("Clicks on login button")
	public void clicks_on_login_button() 
	{				
		firstPage.login();
		
		//firstPageFacModel.login();
	}
	
	@When("^User enters (.*) and (.*)$")
	public void user_enters_name1_and(String userName, String password)
	{
		firstPage.enterUserNamePassword(userName, password);		
	}
	
	@Then("User should be redirected to the home page")
	public void user_should_be_redirected_to_the_home_page() 
	{
	  String title = driver.getTitle();
	
	 Assert.assertEquals(title,"Swag Labs");
	 Assert.assertTrue(true);
	 Assert.assertFalse(false);
	 Assert.assertNotNull("kc");
	 Assert.assertNotEquals("kc", "kcp");
	 Assert.assertNull(null);
	 Assert.assertSame("kc", "kc");
	}	
	
	@Then("Error message {string} is displayed\" is displayed")
	public void error_message_is_displayed_is_displayed(String string) 
	{
		
	}
}
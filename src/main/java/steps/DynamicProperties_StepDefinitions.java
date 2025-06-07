package steps;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import helper.Browser;
import helper.CommonMethods;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DynamicProperties_Page;

public class DynamicProperties_StepDefinitions {

    CommonMethods commonMethods;
    WaitHelper waitHelper;
    DynamicProperties_Page dynamicProperties_Page;
    
    public DynamicProperties_StepDefinitions(Browser manageDriver)
    {
        commonMethods = new CommonMethods();
        waitHelper = new WaitHelper();
        dynamicProperties_Page = new DynamicProperties_Page();
    }
    
    @When("user navigates to the Dynamic Properties page")
    public void WhenUserNavigatesToTheDynamicPropertiesPage()
    {
    	commonMethods.visit("https://demoqa.com/dynamic-properties");
    }
    
    @Then("after {int} seconds, button is visible")
    public void ThenAfterSecondsButtonIsVisible(int second) throws InterruptedException
    {
    	boolean isElementDisplayedAfter5Sec;

    	try
    	{
    	   isElementDisplayedAfter5Sec = waitHelper.waitForElementToBeVisible(dynamicProperties_Page.visibleAfter5SecElement, second).isDisplayed();
    	}
    	
    	catch (WebDriverException e)   
    	{
    	   isElementDisplayedAfter5Sec = false;
    	}
        catch (NoSuchElementException e)
    	{
    	   isElementDisplayedAfter5Sec = false;
    	}
    	
    	Assert.assertTrue("Button is not visible after 5 seconds", isElementDisplayedAfter5Sec);
    }
    
    @Then("after {int} seconds, button is enabled")
    public void ThenAfterSecondsButtonIsEnabled(int p0)
    {
    	boolean isElementEnabledAfter5Sec;
        try
    	{
    		 isElementEnabledAfter5Sec = waitHelper.waitForElementToBeEnableOrClickable(dynamicProperties_Page.enabledAfter5SecElement, 5).isEnabled();
    	}

    	catch (Exception e)
        {
    		 isElementEnabledAfter5Sec = false;
    	}

    	Assert.assertTrue("Button is not enabled after 5 seconds", isElementEnabledAfter5Sec);
    }
}
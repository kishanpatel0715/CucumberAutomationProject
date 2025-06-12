package steps;

import java.util.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import helper.Browser;
import helper.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DynamicProperties_Page;

public class DynamicProperties_StepDefinitions {

    WaitHelper waitHelper;
    DynamicProperties_Page dynamicProperties_Page;
    
    public DynamicProperties_StepDefinitions(Browser manageDriver)
    {
        waitHelper = new WaitHelper();
        dynamicProperties_Page = new DynamicProperties_Page();
    }
    
    @Given("user selects Dynamic Properties from sub-menu")
    public void user_selects_dynamic_properties_from_submenu()
    {
    	dynamicProperties_Page.selectDynamicPropertiesFromSubMenu();
    }
    
    @Then("after {int} seconds, button is visible")
    public void after_seconds_button_is_visible(int second) throws InterruptedException
    {
    	boolean isElementDisplayedAfter5Sec;

    	try
    	{
    	   isElementDisplayedAfter5Sec = waitHelper.waitForElementToBeVisible(dynamicProperties_Page.visibleAfter5SecElement, 5).isDisplayed();
    	}
    	
    	catch (TimeoutException e)   
    	{
    	   isElementDisplayedAfter5Sec = false;
    	}
    	
        catch (NoSuchElementException e)
    	{
    	   isElementDisplayedAfter5Sec = false;
    	}
    	
    	Assert.assertTrue(isElementDisplayedAfter5Sec, "Button is not visible after 5 seconds");
    }
    
    @Then("after {int} seconds, button is enabled")
    public void after_seconds_button_is_enabled(int p0)
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

    	Assert.assertTrue(isElementEnabledAfter5Sec, "Button is not enabled after 5 seconds");
    }
}
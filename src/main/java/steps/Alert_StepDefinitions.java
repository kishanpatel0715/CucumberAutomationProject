package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import Context.AlertContext;
import helper.Browser;
import helper.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Alerts_Page;
import runner.TestRunner;

import org.testng.Assert;

public class Alert_StepDefinitions {

	 WebDriver driver = Browser.getBrowserDriverInstance();
	 WaitHelper waitHelper;
	 Alerts_Page alerts_Page;
	 AlertContext alertContext;

	 public Alert_StepDefinitions(Browser manageDriver)
	 {
	     waitHelper = new WaitHelper();
	     alerts_Page = new Alerts_Page();
	     alertContext = new AlertContext();
	 }
	 
	 @Given("the user navigates to DemoQA home page")
	 public void the_user_navigates_to_demoQA_home_page()
	 {
		 driver.get(TestRunner.baseUrlDemoQa);
	 }

     @Given("the user selects the Alerts, Frame & Windows from the menu")
     public void the_user_selects_the_alerts_frame_windows_from_the_menu() 
     {
    	 alerts_Page.selectAlertsFrameWindowsFromMenu();
     }
     
     @Given("the user selects Alerts from the sub-menu")
     public void the_user_selects_alerts_from_the_submenu() 
     {
    	 alerts_Page.selectAlertsFromSubMenu();
     }
     
     @When("the user opens the regular alert")
     public void the_user_opens_the_regular_alert()
     {
         alerts_Page.openAlert();
     }
     
     @Then("an alert is displayed with the text {string}")
     public void an_alert_is_displayed_with_the_text(String alertExpectedText)
     {
    	Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), alertExpectedText, "Alert Text is incorrect");
     }
     
     @When("the user accepts the alert")
     public void the_user_accepts_the_alert()
     {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
     }
     
     @Then("the alert is no longer visible")
     public void the_alert_is_no_longer_visible()
     {
    	Assert.assertTrue(driver.findElement(alerts_Page.AlertElement).isDisplayed(), "Alert is still present");
     }
     
     @When("the user opens the delayed alert")
     public void the_user_opens_the_delayed_alert()
     {
    	alerts_Page.openDelayedAlert();
     }
     
     @Then("delayed alert is displayed with the text {string}")
     public void delayed_alert_is_displayed_with_the_text(String alertExpectedText)
     {
    	waitHelper.waitForAlert(5);
     }
     
     @When("the user opens the confirm box")
     public void the_user_opens_the_confirm_box()
     {
    	alerts_Page.openConfirmBoxPopUp();
     }
     
     @When("the user cancels the alert")
     public void the_user_cancels_the_alert()
     {
    	//driver.SwitchTo().Alert().Dismiss();
    	waitHelper.waitForAlert(3).dismiss();
     }
     
     @Then("{string} message is displayed")
     public void message_is_displayed(String expectedMessage)
     {
    	String actualMessage;

    	if (expectedMessage.contains("entered"))
    	{
    		 actualMessage = alerts_Page.GetEnteredNameSuccessText(alertContext.getName()).getText();
    	}
    	else
        {
    		 actualMessage = driver.findElement(alerts_Page.ConfirmResultTextElement).getText();
    	}

    	Assert.assertEquals(expectedMessage, actualMessage, "Incorrect message is displayed");
    }
     
     @When("the user opens the prompt box")
     public void the_user_opens_the_prompt_box()
     {
         alerts_Page.openPromptBoxPopUp();
     }
     
     @When("the user enters the name {string}")
     public void the_user_enters_the_name(String name)
     {
    	alertContext.setName(name);
        Alert alert = driver.switchTo().alert();
    	alert.sendKeys(name);
     }
}
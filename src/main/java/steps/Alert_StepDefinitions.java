package steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import Context.AlertContext;
import helper.Browser;
import helper.CommonMethods;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Alerts_Page;

public class Alert_StepDefinitions {

	 WebDriver driver;
	 WaitHelper waitHelper;
	 CommonMethods commonMethods;
	 Alerts_Page alerts_Page;
	 AlertContext alertContext;

	 public Alert_StepDefinitions(Browser manageDriver)
	 {
	     driver = Browser.driver;
	     waitHelper = new WaitHelper();
	     commonMethods = new CommonMethods();
	     alerts_Page = new Alerts_Page(driver);
	     alertContext = new AlertContext();
	 }
	 

     @When("user navigates to the Alerts, Frame & Windows page page")
     public void WhenUserNavigatesToTheAlertsFrameWindowsPagePage()
     {
         commonMethods.visit("https://demoqa.com/alerts");
     }
     
     @When("user clicks on button to see alert")
     public void WhenUserClicksOnButtonToSeeAlert()
     {
         alerts_Page.openAlert();
     }
     
     @Then("alert is displayed with text {string}")
     public void ThenAlertIsDisplayedWithText(String alertExpectedText)
     {
    	Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Alert Text is incorrect", alertExpectedText, alert.getText());
     }
     
     @When("user accepts the alert")
     public void WhenUserAcceptsTheAlert()
     {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
     }
     
     @Then("alert is disappeared")
     public void ThenAlertIsDisappeared()
     {
    	Assert.assertTrue("Alert is still present",driver.findElement(alerts_Page.AlertElement).isDisplayed());
     }
     
     @When("user clicks on button to see delayed alert")
     public void WhenUserClicksOnButtonToSeeDelayedAlert()
     {
    	alerts_Page.openDelayedAlert();
     }
     
     @Then("delayed alert is displayed with text {string}")
     public void ThenDelayedAlertIsDisplayedWithText(String alertExpectedText)
     {
    	waitHelper.waitForAlert(5);
     }
     
     @When("user clicks on button to see confirm box")
     public void WhenUserClicksOnButtonToSeeConfirmBox()
     {
    	alerts_Page.openConfirmBoxPopUp();
     }
     
     @When("user cancels the alert")
     public void WhenUserCancelsTheAlert()
     {
    	//driver.SwitchTo().Alert().Dismiss();
    	waitHelper.waitForAlert(3).dismiss();
     }
     
     @Then("{string} message is displayed")
     public void ThenMessageIsDisplayed(String expectedMessage)
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

    	Assert.assertEquals("Incorrect message is displayed", expectedMessage, actualMessage);
    }
     
     @When("user clicks on button to see prompt box")
     public void WhenUserClicksOnButtonToSeePromptBox()
     {
         alerts_Page.openPromptBoxPopUp();
     }
     
     @When("user enters the name {string}")
     public void WhenUserEntersTheName(String name)
     {
    	 alertContext.setName(name);
        Alert alert = driver.switchTo().alert();
    	alert.sendKeys(name);
     }
}
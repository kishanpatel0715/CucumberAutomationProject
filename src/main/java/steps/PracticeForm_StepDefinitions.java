package steps;

import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Browser;
import helper.CommonMethods;
import helper.WaitHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PracticeForm_Page;

public class PracticeForm_StepDefinitions {

    WebDriver driver;
    PracticeForm_Page practiceForm_Page;
    WaitHelper waitHelper;
    CommonMethods commonMethods;
    
    public PracticeForm_StepDefinitions(Browser manageDriver)
    {
        driver = Browser.driver;
        practiceForm_Page = new PracticeForm_Page(driver);
        waitHelper = new WaitHelper();
        commonMethods = new CommonMethods();
    }
    
    @When("user navigates to the practice form page")
    public void WhenUserNavigatesToThePracticeFormPage()
    {
    	driver.get("https://demoqa.com/automation-practice-form");
    }

    @When("user enters following details:")
    public void WhenUserEntersFollowingDetails(DataTable dataTable)
    {
    	Map<String, String> input = dataTable.asMap(String.class, String.class);
    	
    	practiceForm_Page.enterPracticeFormData(input);
    }

     @When("user submits the form")
     public void WhenUserSubmitsTheForm()
     {
        practiceForm_Page.submitForm();
     }

     @Then("form is submitted successfully")
     public void ThenFormIsSubmittedSuccessfully()
     {
    	 boolean IsSuccessMessageIsDisplayed;

    	 try
    	 {
    		 IsSuccessMessageIsDisplayed =waitHelper.waitForElementToBeVisible(By.id("example-modal-sizes-title-lg"),4).isDisplayed();
    	 }

    	 catch(NoSuchElementException e)
    	 {
    		 IsSuccessMessageIsDisplayed = false;
    	 }

         Assert.assertTrue("Form submission is failed", IsSuccessMessageIsDisplayed);  		 
     }

     @Then("following details are displayed")
     public void ThenFollowingDetailsAreDisplayed(DataTable dataTable)
     {    	
     	 Map<String, String> expected = dataTable.asMap(String.class, String.class);
     	 Map<String, String> actual = practiceForm_Page.getSubmittedData();
     	
     	 Assert.assertEquals("First Name or Last Name is incorrect", expected.get("First Name") + " " + expected.get("Last Name"), actual.get("First Name"));
         Assert.assertEquals("Email is incorrect", expected.get("Email"), actual.get("Email"));
         Assert.assertEquals("Gender is incorrect", expected.get("Gender"), actual.get("Gender"));
         Assert.assertEquals("Mobile is incorrect", expected.get("Mobile"), actual.get("Mobile"));
         Assert.assertEquals("Hobbies is incorrect", expected.get("Hobbies"), actual.get("Hobbies"));
         Assert.assertEquals("Picture is incorrect", expected.get("Picture"), actual.get("Picture"));
         Assert.assertEquals("Current Address is incorrect", expected.get("Current Address"), actual.get("Current Address"));
         Assert.assertEquals("State or City is incorrect", expected.get("State") + " " + expected.get("City"), actual.get("State"));
     }
}
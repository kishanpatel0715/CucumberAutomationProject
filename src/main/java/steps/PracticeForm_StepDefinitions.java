package steps;

import java.util.Map;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.Browser;
import helper.WaitHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PracticeForm_Page;

public class PracticeForm_StepDefinitions {

    WebDriver driver = Browser.getBrowserDriverInstance();
    PracticeForm_Page practiceForm_Page;
    WaitHelper waitHelper;
    
    public PracticeForm_StepDefinitions(Browser manageDriver)
    {
        practiceForm_Page = new PracticeForm_Page();
        waitHelper = new WaitHelper();
    }
    
    @Given("the user selects the Forms from menu")
    public void the_user_selects_the_forms_from_menu()
    {
    	practiceForm_Page.selectFormsFromMenu();
    }
    
    @When("the user selects Practice Form from the sub-menu")
    public void the_user_selects_practice_form_from_submenu()
    {
    	practiceForm_Page.selectPracticeFormFromSubMenu();
    }

    @When("the user enters following details:")
    public void the_user_enters_following_details(DataTable dataTable)
    {
    	Map<String, String> input = dataTable.asMap(String.class, String.class);
    	
    	practiceForm_Page.enterPracticeFormData(input);
    }

    @When("the user submits the form")
    public void the_user_submits_the_form()
    {
       practiceForm_Page.submitForm();
    }

    @Then("the form is submitted successfully")
    public void the_form_is_submitted_successfully()
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

         Assert.assertTrue(IsSuccessMessageIsDisplayed, "Form submission is failed");  		 
     }

     @Then("the following details are displayed:")
     public void the_following_details_are_displayed(DataTable dataTable)
     {    	
     	 Map<String, String> expected = dataTable.asMap(String.class, String.class);
     	 Map<String, String> actual = practiceForm_Page.getSubmittedData();
     	
     	 Assert.assertEquals(actual.get("First Name"), expected.get("First Name") + " " + expected.get("Last Name"), "First Name or Last Name is incorrect");
         Assert.assertEquals(actual.get("Email"), expected.get("Email"), "Email is incorrect");
         Assert.assertEquals(actual.get("Gender"), expected.get("Gender"), "Gender is incorrect");
         Assert.assertEquals(actual.get("Mobile"), expected.get("Mobile"), "Mobile is incorrect");
         Assert.assertEquals(actual.get("Hobbies"), expected.get("Hobbies"), "Hobbies is incorrect");
         Assert.assertEquals(actual.get("Picture"), expected.get("Picture"), "Picture is incorrect");
         Assert.assertEquals(actual.get("Current Address"), expected.get("Current Address"), "Current Address is incorrect");
         Assert.assertEquals(actual.get("State"), expected.get("State") + " " + expected.get("City"), "State or City is incorrect");
     }
}
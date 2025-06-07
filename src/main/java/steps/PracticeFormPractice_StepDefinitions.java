package steps;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import helper.Browser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PracticeFormPractice_Page;

public class PracticeFormPractice_StepDefinitions {

	WebDriver driver = Browser.getDriver();
	PracticeFormPractice_Page _practiceFormPractice_Page;
	
	public PracticeFormPractice_StepDefinitions(Browser browser)
	{
		_practiceFormPractice_Page = new PracticeFormPractice_Page();
	}
	
	@Given("user has navigated to Practice Practice Form page")
	public void user_has_navigated_to_practice_practice_form_page() {
	   driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@When("user user enters following details:")
	public void user_user_enters_following_details(DataTable dataTable) {
		Map<String, String> input = dataTable.asMap(String.class, String.class);
		_practiceFormPractice_Page.enterData(input);
		
	}
	
	@When("user user enters enters following details:")
	public void user_user_enters_enters_following_details(DataTable dataTable)
	{
		List<Map<String,String>> expected = dataTable.asMaps(String.class, String.class);
		for(int i=0; i<expected.size(); i++)
		{
			System.out.println(expected.get(i).get("First Name"));
		}
	}
	
	@When("user submits e-form")
	public void user_submits_eform ()
	{
		_practiceFormPractice_Page.submit();
	}
	
	@Then("e-form is submitted successfully")
	public void eform_is_submitted_successfully()
	{
		try {
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

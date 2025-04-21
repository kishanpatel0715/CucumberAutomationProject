package api_Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import api_Pages.JSONSchema_Page;

public class JSONSchema_StepDefinitions {
	
	Response response;
	JSONSchema_Page jsonSchema_Page;
	
	public JSONSchema_StepDefinitions()
	{
		jsonSchema_Page = new JSONSchema_Page();
	}
	
	@When("user sends a request to {string}")
	public void user_sends_a_request_to(String commentsURI) {
		response = given().when().get(commentsURI);
	}
	
	@Then("JSON schema validation is completed successfully")
	public void json_schema_validation_is_completed_successfully() {
		jsonSchema_Page.verifyJSONSchema(response, "comments_json_schema.json");
	}
}
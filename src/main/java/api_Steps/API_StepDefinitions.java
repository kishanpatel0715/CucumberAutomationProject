package api_Steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_StepDefinitions {
	
	Response response;
	
	@Given("user sends a GET request to {string}")
	public void user_sends_a_get_request_to(String url) {
		
		response = get(url);
	}
	@Then("the response status code is {int}")
	public void the_response_status_code_is(int responseCode) {
		response.then().statusCode(responseCode);
	}
	
	@Then("response is contained name {string}")
	public void response_is_contained_name (String expectedName) {
//		response.then().body("name", containsString(expectedName));		
		response.then().body("name", equalTo(expectedName));
	}
	
	@Then("response is contained text {string}")
	public void response_is_contained_text(String expectedText) {
		response.then().body("[0].text", equalTo(expectedText));
		
// Other way to extract comment from response 		
//		System.out.println("First Comment" + response.jsonPath().getString("[0].text"));
	}
	
	@When("user adds a comment")
	public void user_adds_a_comment() {
			
		Map<String,Object> comment = new HashMap<>();
		comment.put("id", "3");
		comment.put("text", "KC");
		comment.put("postId", "3");
			
		response = given().baseUri("http://localhost:3000").basePath("/comments").contentType(ContentType.JSON).body(comment).when().post();
	}
	
	@Then("comment is added successfully")
	public void comment_is_added_successfully() {
	      response.then().statusCode(201);
	}
	
	@When("user updates a text")
	public void user_updates_a_text() {
		
		Map<String,Object> updatedtext = new HashMap<>();
		updatedtext.put("text", "Patel");		
		
		response = given().baseUri("http://localhost:3000").basePath("/comments/3").contentType(ContentType.JSON).body(updatedtext).when().patch();
	}
	
	@Then("text is updated successfully")
	public void text_is_updated_successfully() {
		 response.then().statusCode(200);
	}

	@When("user updates a comment")
	public void user_updates_a_comment() {
		
		Map<String,Object> updatedComment = new HashMap<>();
		updatedComment.put("id", "4");
		updatedComment.put("text", "CV");
		updatedComment.put("postId", "4");
		
		response = given().baseUri("http://localhost:3000").basePath("/comments/2").contentType(ContentType.JSON).body(updatedComment).when().put();

	}
	@Then("comment is updated successfully")
	public void comment_is_updated_successfully() {
		response.then().statusCode(200);
	}
	
	@When("user deletes a comment")
	public void user_deletes_a_comment() {
	   response = given().when().baseUri("http://localhost:3000").basePath("/comments/1").when().delete();
	}

	@Then("comment is deleted successfully")
	public void comment_is_deleted_successfully() {
		response.then().statusCode(200);
	}
}
package api_Steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import api_Pages.API_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_StepDefinitions {
	
	Response response;
	API_Page api_Page;
	
	public API_StepDefinitions()
	{
		api_Page = new API_Page(); 
	}
	
	@Given("user sends a GET request to {string}")
	public void user_sends_a_get_request_to(String url) {
		
		response = get(url);
	}
	
	@Then("the response status code is {int}")
	public void the_response_status_code_is(int responseCode) {
		System.out.println(response.jsonPath().getList("books").size());
		
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
		
//		 Other way to extract comment from response 		
// 		System.out.println("First Comment" + response.jsonPath().getString("[0].text"));
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
	
	@Then("following book details is displayed:")
	public void following_book_details_is_displayed(DataTable dataTable) {
	
		List<Map<String, Object>> expectedList = dataTable.asMaps(String.class, Object.class);
		List<Map<String, Object>> actualList = api_Page.getBookDetails(response);
		
		Assert.assertEquals("Number of books records are incorrect", expectedList.size(), actualList.size());
		
		for(int i=0 ; i<expectedList.size(); i++)
		{
			Map<String, Object> expected = expectedList.get(i);
			Map<String, Object> actual = actualList.get(i);
			Assert.assertEquals("ISBN is incorrect for Book: " + expected.get("title"), expected.get("isbn"), actual.get("isbn"));	
			Assert.assertEquals("Title is incorrect for Book isbn: " + expected.get("isbn"), expected.get("title"), actual.get("title"));	
			Assert.assertEquals("Sub Title is incorrect for Book: " + expected.get("title"), expected.get("subTitle"), actual.get("subTitle"));	
			Assert.assertEquals("Author is incorrect for Book: " + expected.get("title"), expected.get("author"), actual.get("author"));	
			Assert.assertEquals("Publish Date is incorrect for Book: " + expected.get("title"), expected.get("publish_date"), actual.get("publish_date"));	
			Assert.assertEquals("Publisher is incorrect for Book: " + expected.get("title"), expected.get("publisher"), actual.get("publisher"));	
			Assert.assertEquals("Pages is incorrect for Book: " + expected.get("title"), Integer.parseInt((String) expected.get("pages")), actual.get("pages"));	
			Assert.assertTrue("Description is incorrect for Book: " + expected.get("title"), actual.get("description").toString().contains(expected.get("description").toString()));	
			Assert.assertEquals("Website is incorrect for Book: " + expected.get("title"), expected.get("website"), actual.get("website"));	
		}
	}
}
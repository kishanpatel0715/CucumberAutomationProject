package api_Steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import api_Pages.REST_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class REST_StepDefinitions {
	
	Response response;
	REST_Page api_Page;
	
	public REST_StepDefinitions()
	{
		api_Page = new REST_Page(); 
	}
	
	@Given("the user sends a GET request to {string}")
	public void user_sends_a_GET_request_to(String url) {
		response = get(url);
	}
	
	@Then("the response status code is {int}")
	public void the_response_status_code_is(int responseCode) {
		response.then().statusCode(responseCode);
	}
	
	@Then("the response is contained name {string}")
	public void the_response_is_contained_name(String expectedName) {
//		response.then().body("name", containsString(expectedName));		
		response.then().body("name", equalTo(expectedName));
	}
	
	@Then("the response is contained text {string}")
	public void the_response_is_contained_text(String expectedText) {
		response.then().body("[0].text", equalTo(expectedText));
		
//		Other way to extract comment from response 		
// 		System.out.println("First Comment" + response.jsonPath().getString("[0].text"));
	}
	
	@When("the user adds a comment")
	public void the_user_adds_a_comment() {
			
		Map<String,Object> comment = new HashMap<>();
		comment.put("id", "3");
		comment.put("text", "KC");
		comment.put("postId", "3");
		response = given().baseUri("http://localhost:3000").basePath("/comments").contentType(ContentType.JSON).body(comment).when().post();
	}
	
	@Then("the comment is added successfully")
	public void the_comment_is_added_successfully() {
	      response.then().statusCode(201);
	}
	
	@When("the user updates the text")
	public void the_user_updates_the_text() {
		
		Map<String,Object> updatedtext = new HashMap<>();
		updatedtext.put("text", "Patel");		
		response = given().baseUri("http://localhost:3000").basePath("/comments/3").contentType(ContentType.JSON).body(updatedtext).when().patch();
	}
	
	@Then("the text is updated successfully")
	public void the_text_is_updated_successfully() {
		 response.then().statusCode(200);
	}

	@When("the user updates a comment")
	public void the_user_updates_a_comment() {
		
		Map<String,Object> updatedComment = new HashMap<>();
		updatedComment.put("id", "4");
		updatedComment.put("text", "CV");
		updatedComment.put("postId", "4");
		response = given().baseUri("http://localhost:3000").basePath("/comments/2").contentType(ContentType.JSON).body(updatedComment).when().put();
	}
	
	@Then("the comment is updated successfully")
	public void the_comment_is_updated_successfully() {
		
		response.then().statusCode(200);
	}
	
	@When("the user deletes a comment")
	public void the_user_deletes_a_comment() {
	   response = given().when().baseUri("http://localhost:3000").basePath("/comments/1").when().delete();
	}

	@Then("the comment is deleted successfully")
	public void the_comment_is_deleted_successfully() {
		response.then().statusCode(200);
	}
	
	@Then("the following book details are displayed:")
	public void the_following_book_details_are_displayed(DataTable dataTable) {
	
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
	
	@Then("book detail is added successfully")
	public void book_detail_is_added_successfully() {
		
		response.then().statusCode(201);
	}
	
	@When("the user adds a post")
	public void the_user_adds_a_post() {
		
		Map<String, Object> newPost = new HashMap<>();
		newPost.put("id", "3");
		newPost.put("title", "Third Title");
		newPost.put("views", "1000");
		response = given().when().baseUri("http://localhost:3000").basePath("/posts").contentType(ContentType.JSON).body(newPost).when().post();
	 }
	
	@Then("the post is added successfully")
	public void the_post_is_added_successfully() {
		
		response.then().statusCode(201);
	}

	@When("the user updates a post title")
	public void the_user_updates_a_postTitle() {
		
		Map<String, Object> updatePostTitle = new HashMap<>();
		updatePostTitle.put("title", "Fifth Title");
		response = given().when().baseUri("http://localhost:3000").basePath("/posts/4").contentType(ContentType.JSON).body(updatePostTitle).when().patch();
	}
	
	@Then("the post title is updated successfully")
	public void the_post_title_is_updated_successfully() {
		response.then().statusCode(200);
	}
	
	@When("the user updates a post")
	public void the_user_updates_a_post() {
	  
		Map<String, Object> updatedPost = new HashMap<>();
		
		updatedPost.put("title", "Sixth Title");
		updatedPost.put("views", "6000");
		response = given().when().baseUri("http://localhost:3000").basePath("/posts/4").contentType(ContentType.JSON).body(updatedPost).when().put();
	}
	
	@Then("the post is updated successfully")
	public void the_post_is_updated_successfully() {
	    response.then().statusCode(200);
	}

	@When("the user deletes a post")
	public void the_user_deletes_a_post() {
	    response = given().when().baseUri("http://localhost:3000").basePath("/posts/3").when().delete();
	}

	@Then("the post is deleted successfully")
	public void the_post_is_deleted_successfully() {
		response.then().statusCode(200);
	}
}
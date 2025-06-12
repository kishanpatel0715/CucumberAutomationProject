package api_Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.*;
import org.apache.commons.io.IOUtils;

public class SOAP_StepDefinitions {

	Response response;
	
	@When("the user sends a SOAP request to calculate the sum of {int} and {int}")
	public void the_user_sends_a_SOAP_request_to_calculate_the_sum_of_and(int int1, int int2) throws IOException {
	    
		File soap_Add_Request_File = new File("./XML_SOAP_Req_Files/Calculator_Add_SOAP_Req.xml");
		FileInputStream file = new FileInputStream(soap_Add_Request_File);
		String file_Content = IOUtils.toString(file, "UTF-8");
		
		response = given().baseUri("http://www.dneonline.com/").basePath("/calculator.asmx").contentType("text/xml").body(file_Content).when().post();
	}
	
	@Then("the status code is {int}")
	public void the_status_code_is(int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
//		System.out.println(response.then().log().all());
	}
	
	@Then("{int} is displayed as the result")
	public void is_displayed_as_the_result(int sum) {
		response.then().body("//*:AddResult.text()", equalTo(Integer.toString(sum)));
	}
}
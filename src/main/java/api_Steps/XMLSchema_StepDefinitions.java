package api_Steps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

public class XMLSchema_StepDefinitions {

	Response response;
	
	@When("the user sends a SOAP request to do sum of {int} and {int}")
	public void the_user_sends_a_SOAP_request_to_do_sum_of_and(Integer int1, Integer int2) throws IOException {
		
		File soap_Add_Request_File = new File("./XML_SOAP_Req_Files/Calculator_Add_SOAP_Req.xml");
		FileInputStream file = new FileInputStream(soap_Add_Request_File);
		String file_Content = IOUtils.toString(file, "UTF-8");
		
		response = given().baseUri("http://www.dneonline.com/").basePath("/calculator.asmx").contentType("text/xml").body(file_Content).when().post();
	}
	
	@Then("the response code is {int}")
	public void the_response_code_is(Integer responseStatusCode) {
		response.then().statusCode(responseStatusCode);
	}
	
	@Then("the XML Schema is verified successfully")
	public void the_XML_Schema_is_verified_successfully() {
		response.then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("sum_xml_schema.xsd"));		
	}
}
package api_Pages;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class JSONSchema_Page {

	public ValidatableResponse verifyJSONSchema(Response response, String fileName)
	{
		return response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(fileName));
	}
}
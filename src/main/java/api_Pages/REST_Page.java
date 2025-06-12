package api_Pages;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class REST_Page {

	public List<Map<String, Object>> getBookDetails(Response response)
	{
	    List<Map<String,Object>> listToReturn = response.jsonPath().getList("books");
		return listToReturn;
	}
}
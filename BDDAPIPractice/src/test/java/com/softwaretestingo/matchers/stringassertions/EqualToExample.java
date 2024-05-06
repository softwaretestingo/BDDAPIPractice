package com.softwaretestingo.matchers.stringassertions;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class EqualToExample 
{
	/*
	 * Compare The Two Values 
	 */
	
	@Test
	public void compareValueUsingLessThenTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		Map<String, String> payload= new HashMap<String, String>();
		payload.put("name", "morpheus");
		payload.put("job", "leader");
		
		
		Response response= given().log().all()
								.contentType("application/json")
									.body(payload)
										.post("/api/users");
		
		JsonPath path=response.jsonPath();
		String idValue= (String) path.get("id");
		
		//We Can Compare Strings
		response.then().log().all() 
			.assertThat() .statusCode(201) .and()
				.contentType(ContentType.JSON)
					.and()
						.body("id", equalTo(idValue));
		 
	}
}
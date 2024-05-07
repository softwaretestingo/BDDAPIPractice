package com.softwaretestingo.extractfromresponse;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ExtractResponseAsStringFromResponse 
{
	@Test
	public void ExtractResponseTest()
	{
	RestAssured.baseURI="https://reqres.in/";
	Map<String, String> payload= new HashMap<String, String>();
	payload.put("name", "morpheus");
	payload.put("job", "leader");
	
	String response= given()
							.contentType("application/json")
								.body(payload)
									.post("/api/users")
										.then()
											.contentType(ContentType.JSON)
												.extract()
													.response()
														.asString();
														//.asPrettyString(); If You Want to Pretty Format
	
	System.out.println(response);
	}
}

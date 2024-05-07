package com.softwaretestingo.extractfromresponse;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class ExtractAttributeValueFromJSONResponse 
{
	@Test
	public void ExtractResponseTest()
	{
	RestAssured.baseURI="https://reqres.in/";
	Map<String, String> payload= new HashMap<String, String>();
	payload.put("name", "morpheus");
	payload.put("job", "leader");
	
	Response response= given()
							.contentType("application/json")
								.body(payload)
									.post("/api/users")
										.then().log().body()
											.contentType(ContentType.JSON)
												.extract()
													.response();
														
	
	//Get Attribute Value With Help Of JSONPath() From a String
	System.out.println("---------------------------------");
	JsonPath pathview=response.jsonPath();
	System.out.println("Name: "+pathview.getString("name"));
	System.out.println("Job: "+pathview.getString("job"));
	System.out.println("Job ID: "+pathview.getInt("id"));  
	System.out.println("Created Date: "+pathview.get("createdAt"));
	}
}

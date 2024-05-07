package com.softwaretestingo.extractfromresponse;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
public class ExtractAttributeValueFromResponseString 
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
										.then().log().body()
											.contentType(ContentType.JSON)
												.extract()
													.response()
														//.asString();
														.asPrettyString(); //If You Want to Pretty Format
	
	//Get Attribute Value With Help Of JSONPath() From a String
	System.out.println("---------------------------------");
	JsonPath pathview=new JsonPath(response);
	System.out.println("Name: "+pathview.get("name"));
	System.out.println("Job: "+pathview.get("job"));
	System.out.println("ID: "+pathview.get("id"));  
	System.out.println("Created Date: "+pathview.get("createdAt"));
	}
}

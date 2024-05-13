package com.softwaretestingo.simpleJSONserializationdeserialization;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ConvertPojoToJson 
{
	/**
	 * In This Program We Will perform
	 * 
	 * 1. Create Java POJO Class
	 * 2. Convert Java Object to JSON
	 * 3. Create a USER by Post request and Get the Response
	 * 4. Convert JSON Response to Java class
	 * 5. Print the Value By Using newly Created Object
	 */
	String simpleJSOn;
	@Test
	public void simpleSerializationExample() throws JsonProcessingException
	{
		SimplePOJOClass obj=new SimplePOJOClass();
		obj.setName("SoftwareTestIngo");
		obj.setJob("Admin");
		
		
		// Serialize this SimplePOJOClass object into JSON
		ObjectMapper objMapper=new ObjectMapper();
		simpleJSOn = objMapper.writeValueAsString(obj);
		System.out.println(simpleJSOn);
		
		// Lets Create the User With The Post Request
		RestAssured.baseURI="https://reqres.in/";
		
		Response response= given()
							.contentType("application/json")
								.body(simpleJSOn)
									.when()
										.post("/api/users")
											.then().log().body()
												.assertThat()
													.statusCode(201)
														.and()
															.contentType(ContentType.JSON)
																.extract()
																	.response();
		
		// Deserialize the response body back into User object	
		// If the SimplePOJOClass have not all the variables then you will get error for that
		SimplePOJOClass user= objMapper.readValue(response.getBody().asString(), SimplePOJOClass.class);
		   
		//Print The Values
		System.out.println("Name : "+user.getName());
		System.out.println("Job : "+user.getJob());
		
		// Assertions
		Assert.assertEquals(obj.getName(), user.getName());
		Assert.assertEquals(obj.getJob(), user.getJob());
	}
}
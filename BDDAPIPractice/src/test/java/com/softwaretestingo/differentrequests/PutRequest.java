package com.softwaretestingo.differentrequests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class PutRequest 
{
	/**
	 * Here We Have Create A User, After that we retrieve the userID of newly created User
	 * and later based on the userID we update the user contents
	 */
	@Test(priority = 0)
	public String createUserTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response response=	given().log().all()
							.header("Content-Type", "application/json")
								.body("{\r\n"
									+ "    \"name\": \"SoftwareTestingo\",\r\n"
									+ "    \"job\": \"Admin\"\r\n"
									+ "}")
									.when()
										.post("/api/users");
							
		System.out.println(response.asPrettyString());
		JsonPath pathviewer = response.jsonPath();
		String id=pathviewer.getString("id");
		return id;
	}
	@Test(priority = 1)
	public void putUserTest()
	{
		String id = createUserTest();
		System.out.println("ID Here: "+id);
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response response=	given().log().all()
							.header("Content-Type", "application/json")
								.pathParam("id", id)
								.body("{\r\n"
									+ "    \"name\": \"SoftwareTestingo Blog\",\r\n"
									+ "    \"job\": \"Admin\"\r\n"
									+ "}")
									.when().log().all()
										.put("/api/users/{id}");
		
		System.out.println(response.asPrettyString());
	}	
}
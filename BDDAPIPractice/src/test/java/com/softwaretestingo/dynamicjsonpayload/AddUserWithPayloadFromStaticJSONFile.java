package com.softwaretestingo.dynamicjsonpayload;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ReusableMethods;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class AddUserWithPayloadFromStaticJSONFile 
{
	@Test
	public void addUsers() throws IOException
	{
		/**
		 * 1. In This Method We Are Using the Static Payload
		 * 2. For The Response Retrieve the User ID 
		 */
		RestAssured.baseURI= "https://gorest.co.in";
		String token="Bearer 1ca8e3450e4a08c05c669534d8e9591245c5d260289c7418ad924c2e98c2996b";
		
		// 1. By Using Static Payload We Are Adding The User, But if you run same script again you will get
		// 422 Error code because each time you need to give an unique email ID.
		// The Body Method Required String format to process, so our first task is convert file content into string
		// To Do this we need to convert file content into Byte and then Byte data to String
		// Files.readAllBytes(Paths.get("/BDDAPIPractice/src/test/java/files/addUser.json")) --> This will convert content to Bytes
		// new String(Files.readAllBytes(Paths.get("/BDDAPIPractice/src/test/java/files/addUser.json"))) --> This will convert Byte to String
		//
		Response response=given()
							.header("Content-Type", "application/json")
								.header("Authorization", token)
									.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Freelancer\\git\\BDDAPIPractice\\BDDAPIPractice\\src\\test\\java\\files\\addUser.json")))) //Instead Of Method how to get Payload From JSON File
										.when().log().body()
											.post("/public/v2/users")
												.then().log().body()
													.assertThat()
														.statusCode(201)
															.and()
																.contentType(ContentType.JSON)
																	.and()
																		.extract()
																			.response();
		
		// 2. From The Response we Will Retrieve the User ID
		JsonPath js= ReusableMethods.responseToJSON(response);
		int userId = js.getInt("id");
		System.out.println("User Id: "+userId);
	}
}

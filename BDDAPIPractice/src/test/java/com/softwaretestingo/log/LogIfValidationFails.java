package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class LogIfValidationFails 
{
	@Test
	public void validateResponseTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
		
		
		// You Can use the log().all() method With Given, When & Then
		given().  //This Will Print Basic Parameters Like Method, URI, Params, Headers, Cookies, Body
			when().
				get().
					then().log().ifValidationFails(). // Logs Will Generate If Validation Fails
						assertThat().
							statusCode(201). // EXPECTING 200
								contentType(ContentType.JSON).
									header("Connection", "keep-alive");
	}
}
package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class LogIfError 
{
	@Test
	public void validateResponseTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		
		
		// You Can use the log().all() method With Given, When & Then
		given().  //This Will Print Basic Parameters Like Method, URI, Params, Headers, Cookies, Body
			when().
				get().
					then().log().ifError(). // This Will Log If There are Some Errors, If There is no error in that case no logs
						assertThat().
							statusCode(200).
								contentType(ContentType.JSON).
									header("Connection", "keep-alive");
	}
}
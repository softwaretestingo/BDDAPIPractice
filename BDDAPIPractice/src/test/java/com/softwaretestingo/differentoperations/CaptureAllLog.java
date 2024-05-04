package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class CaptureAllLog 
{
	@Test
	public void validateResponseTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
		
		
		// You Can use the log().all() method With Given, When & Then
		given().log().all().  //This Will Print Basic Parameters Like Method, URI, Params, Headers, Cookies, Body
			when().
				get().
					then().log().all().  // This Will Print Headers & Response Body
						assertThat().
							statusCode(200).
								contentType(ContentType.JSON).
									header("Connection", "keep-alive");
	}
}
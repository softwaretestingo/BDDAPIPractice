package com.softwaretestingo.differentoperations;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class ValidateResponse 
{
	@Test
	public void validateResponseTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
		
		given().
			when().
				get().
					then().
						assertThat().
							statusCode(200).
								contentType(ContentType.JSON).
									header("Connection", "keep-alive");
	}
}
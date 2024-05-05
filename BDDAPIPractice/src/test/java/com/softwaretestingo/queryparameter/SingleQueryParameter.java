package com.softwaretestingo.queryparameter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class SingleQueryParameter 
{
	@Test
	public void singleQueryParameterTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Response response= given().log().all()
								.queryParam("page", 2)
									.when()
										.get("/api/users");
		
		System.out.println(response.asPrettyString());
				
	}
}

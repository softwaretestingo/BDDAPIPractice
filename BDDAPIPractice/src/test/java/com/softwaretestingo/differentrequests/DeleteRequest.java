package com.softwaretestingo.differentrequests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class DeleteRequest 
{
	@Test
	public void deleteUserTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
			.when()
				.delete("/api/users/2")
					.then().log().all()
						.assertThat()
							.statusCode(204);
	}
}
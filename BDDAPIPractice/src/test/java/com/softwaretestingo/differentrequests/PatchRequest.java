package com.softwaretestingo.differentrequests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class PatchRequest 
{
	@Test
	public void pathRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
			.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"name\": \"SoftwareTestingo\",\r\n"
						+ "    \"job\": \"Content Writer\"\r\n"
						+ "}")
					.when().log().all()
						.patch("/api/users/2")
							.then()
								.assertThat()
									.statusCode(200);
	}
}

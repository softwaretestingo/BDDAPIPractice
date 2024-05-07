package com.softwaretestingo.differentwaytopassbody;
import org.testng.annotations.Test;
import files.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class GetRequestBodyFromFiles 
{
	@Test
	public void HotelBookingTest()
	{
	RestAssured.baseURI="https://api.restful-api.dev";
	
	given()
		.body(Payload.payloadForAddingItems())
		.contentType("application/json")
			.when()
				.post("/objects")
				 	.then().log().body()
				 		.assertThat()
				 			.statusCode(200);
	}
}
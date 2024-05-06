package com.softwaretestingo.matchers.stringassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.startsWith;
import static io.restassured.RestAssured.*;

public class StartsWithExample {
	// Checks Whether Extracted String From JSON Starts With a Given String or Character
	@Test
	public void comparingValueTest() 
	{
		RestAssured.baseURI = "http://ergast.com";

		given().log().all()
			.when().get("/api/f1/2018/circuits.json")
				.then().log().body()
					.assertThat()
						.statusCode(200)
							.and()
								.body("MRData.CircuitTable.Circuits[0].circuitName", startsWith("Albert"));
	}
}
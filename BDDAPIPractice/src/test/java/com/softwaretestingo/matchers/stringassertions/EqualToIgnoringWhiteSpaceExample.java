package com.softwaretestingo.matchers.stringassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static io.restassured.RestAssured.*;
public class EqualToIgnoringWhiteSpaceExample 
{
	// Checks Whether Extracted String From JSON is Equal To the Expected String
	// By Considering the White Spaces
	@Test
	public void equalToIgnoringWhiteSpaceExampleTest()
	{
		RestAssured.baseURI="http://ergast.com";
		
		given().log().all()
			.when()
				.get("/api/f1/2018/circuits.json")
					.then().log().body()
						.assertThat()
							.statusCode(200)
								.and()
									.body("MRData.CircuitTable.Circuits[0].circuitName", equalToIgnoringWhiteSpace("Albert    Park Grand Prix Circuit"));
	}
}
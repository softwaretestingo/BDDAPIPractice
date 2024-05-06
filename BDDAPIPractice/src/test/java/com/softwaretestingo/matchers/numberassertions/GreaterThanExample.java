package com.softwaretestingo.matchers.numberassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;
public class GreaterThanExample 
{
	//Check the extracted Number is GreaterThan the expected Number
	// import static org.hamcrest.Matchers.greaterThan;
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		// If You Want to Compare Two Integer Value Then You Can Use greaterThan()
		given()
			.when()
				.get("/booking/1543")
					.then().log().body()
						.assertThat()
							.body("totalprice", greaterThan(100));
	}
}
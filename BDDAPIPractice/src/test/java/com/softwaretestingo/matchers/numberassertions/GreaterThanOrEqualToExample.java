package com.softwaretestingo.matchers.numberassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;;
public class GreaterThanOrEqualToExample 
{
	//Check the extracted Number is Greater Than Equal to the expected Number
	//import static org.hamcrest.Matchers.greaterThanOrEqualTo;;
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		// If You Want to Compare Two Integer Value Then You Can Use greaterThanOrEqualTo()
		given().log().all()
			.when()
				.get("/booking/108")
					.then().log().body()
						.assertThat()
							.body("totalprice", greaterThanOrEqualTo(100));
	}
}
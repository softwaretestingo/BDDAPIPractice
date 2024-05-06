package com.softwaretestingo.matchers.numberassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;
public class LessThanExample 
{
	//Check the whether the extracted Number is lesser Than the expected Number
	//import static org.hamcrest.Matchers.lessThan;
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		// If You Want to Compare Two Integer Value Then You Can Use lessThan()
		given().log().all()
			.when()
				.get("/booking/108")
					.then().log().body()
						.assertThat()
							.body("totalprice", lessThan(150));
	}
}
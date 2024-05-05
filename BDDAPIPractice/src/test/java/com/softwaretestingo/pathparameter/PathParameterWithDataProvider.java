package com.softwaretestingo.pathparameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class PathParameterWithDataProvider 
{
	@Test(dataProvider = "trackData")
	public void pathParameterWithDataProvider(int year, int totalTrack)
	{
		System.out.println("Year :"+year);
		System.out.println("Total Track: "+totalTrack);
		RestAssured.baseURI="http://ergast.com";
		
		given().log().all()
			.pathParam("year", year)
				.when()
					.get("/api/f1/{year}/circuits.json")
						.then()
							.assertThat()
								.statusCode(200)
									.and()
										.body("MRData.CircuitTable.Circuits.circuitId",hasSize(totalTrack));
	}
	
	@DataProvider
	public Object[][] trackData()
	{
		return new Object[][]
		{
			{2016,21},
			{2017,20},
			{2018,21},
			{2016,21}
		};
	}
}

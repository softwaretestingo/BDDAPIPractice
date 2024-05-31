package com.softwaretestingo.complexJSONWithOutArrayDeserialization;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class E2EFlowForComplexJSON 
{
	/**
	 * PROBLEM STATEMENT
	 * 
	 * 1. We Will Try To Learn How to Created Payload When we Have Nested JSON
	 * 2. We Will Perform Post Request To Create a Booking
	 * 3. By Using Deserialization Concept we Will Assign the Value to Java Object
	 * 4. Print All the Values  
	 */
	
	@Test
	public void E2EFlowForComplexJSONTest()
	{
		// Lets Create Payload For This
		/**
		 * {
		 *    "firstname" : "Manas",
		 *    "lastname" : "Sahu",
		 *    "totalprice" : 12345,
		 *    "depositpaid" : true,
		 *    "bookingdates" : {
		 *    		"checkin" : "2023-01-01",
		 *          "checkout" : "2024-01-01"
		 *          },
		 *    "additionalneeds" : "Breakfast"
		 * }
		 */
		
		Map<String, Object> bookingPayload=new HashMap<String, Object>();
		bookingPayload.put("firstname", "Manas");
		bookingPayload.put("lastname", "Sahu");
		bookingPayload.put("totalprice", "12345");
		bookingPayload.put("depositpaid", "true");
		
		
		//For Nested JSON Treat That as a Separate JSON and Create a Separate Payload For That
		Map<String, Object> bookingdatesPayload=new HashMap<String, Object>();
		bookingdatesPayload.put("checkin", "2023-01-01");
		bookingdatesPayload.put("checkout", "2024-01-01");
		
		bookingPayload.put("bookingdates", bookingdatesPayload);
		bookingPayload.put("additionalneeds", "Breakfast");
		
		
		//	After Creating the Payload Lets Peform the Post Request To Create the Booking
		RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		
		ComplexPojoClass obj=
								given()
									.header("Content-Type", "application/json")
										.body(bookingPayload)
											.when().log().body()
												.post("/booking")
													.then().log().body()
														.assertThat()
															.statusCode(200)
																.and()
																	.extract()
																		.as(ComplexPojoClass.class);
		
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println("Print All The Values:     ");
		System.out.println();
		System.out.println("First Name: "+obj.getBooking().getFirstname());
		System.out.println("Last Name: "+obj.getBooking().getLastname());
		System.out.println("Total Price: "+obj.getBooking().getTotalprice());
		System.out.println("Deposit Paid: "+obj.getBooking().getDepositpaid());
		System.out.println("Check In: "+obj.getBooking().getBookingdates().getCheckin());
		System.out.println("Check Out: "+obj.getBooking().getBookingdates().getCheckout());
		System.out.println("Additional Needs: "+obj.getBooking().getAdditionalneeds());
		System.out.println();
		System.out.println("------------------------------------------");
	}
}

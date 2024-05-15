package com.softwaretestingo.complexJSONWithOutArrayserializationdeserialization;
public class ComplexPojoClass 
{
	
	/**
	 * {
	 *     "bookingid": 2355,
	 *     "booking": 
	 *     	{
	 *     		"firstname": "Manas",
	 *     		"lastname": "Sahu",
	 *     		"totalprice": 12345,
	 *     		"depositpaid": true,
	 *     		"bookingdates": 
	 *     			{
	 *     				"checkin": "2013-01-01",
	 *     				"checkout": "2014-01-01"
	 *     			},
	 *     "additionalneeds": "Breakfast"
	 *     }
	 *  }
	 */
	
	private int bookingid;
	private BookingPOJOClass booking;
	public int getBookingid() 
	{
		return bookingid;
	}
	public void setBookingid(int bookingid) 
	{
		this.bookingid = bookingid;
	}
	public BookingPOJOClass getBooking() 
	{
		return booking;
	}
	public void setBooking(BookingPOJOClass booking) 
	{
		this.booking = booking;
	}
}

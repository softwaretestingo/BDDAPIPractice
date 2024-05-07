package com.softwaretestingo.matcher;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class AllOff 
{
	//AllOf method creates a matcher that examined object matches ALL of the specified matchers.
	@Test
	public void allOfMatcherTest() 
	{
		assertThat("myValue", allOf(startsWith("my"), containsString("Val")));
	}
}


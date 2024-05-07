package com.softwaretestingo.matcher;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class AnyOf 
{
	//AnyOf method creates a matcher that examined object matches ANY of the specified matchers.
	@Test
    public void anyOfMatcherTest() 
	{
        assertThat("myValue", anyOf(startsWith("your"), containsString("Val")));
    }
}

package com.softwaretestingo.matcher;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class BothAnd 
{
	//Matcher which, when used in combination with it’s combinable matcher 
	//.and() will match when both specified matchers match.
	@Test
    public void test_both()
	{
        String test = "Hello, world!";
        assertThat(test, both(startsWith("Hello")).and(endsWith("world!")));
    }
}

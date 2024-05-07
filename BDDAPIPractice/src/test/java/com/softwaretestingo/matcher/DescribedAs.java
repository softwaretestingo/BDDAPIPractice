package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class DescribedAs 
{
	//describedAs method adds a description to a Matcher
	@Test
    public void describedAsMatcherTest() 
	{
        assertThat("Sunday", describedAs("Sunday is not Saturday.", is(not("Saturday"))));
    }
}

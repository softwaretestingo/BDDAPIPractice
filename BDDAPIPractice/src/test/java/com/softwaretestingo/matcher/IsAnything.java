package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class IsAnything 
{
	//IsAnything method matcher always returns true.
	@Test
    public void isAnythingMatcherTest() 
	{
        assertThat("Software", is(anything("WelCome to Our Testing Blog")));
    }
}

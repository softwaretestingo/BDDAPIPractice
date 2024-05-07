package com.softwaretestingo.matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
public class Is
{
	//Is method checks two values are equal or not. If both are equal then it will returns true!
	@Test
    public void isMatcherTest() 
	{
        assertThat("SoftwareTestingo", is("SoftwareTestingo"));
        assertThat(2024, is(2024));
    }
}

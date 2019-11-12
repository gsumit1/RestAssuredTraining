package Hamcrast;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {

	  @Override 
	  public boolean matchesSafely(Double number) { 
	    return number.isNaN(); 
	  }

	  public void describeTo(Description description) { 
	    description.appendText("not a number"); 
	  }

	  @SuppressWarnings("rawtypes")
	  public static Matcher notANumber() { 
		    return new IsNotANumber(); 
	  }

	} 
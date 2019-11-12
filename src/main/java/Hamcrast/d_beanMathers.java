package Hamcrast;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 Bean matchers are extremely useful to check conditions over POJOs, something that is frequently
 required when writing most unit tests.*/


class Person {
   public String name;
    String address;
 
    public Person(String personName, String age) {
        name = personName;
        address = age;
    }
    
    public String getName(){
    	return this.name;
    }
}

public class d_beanMathers {
	@Test
	public void givenBean_whenHasValue_thenCorrect() {
	    Person person = new Person("Sumit", "25");
	    assertThat(person, hasProperty("name"));
	}
	
	@Test
	public void givenBean_whenHasCorrectValue_thenCorrect() {
	    Person person = new Person("Ghosh", "New York");
	    assertThat(person, hasProperty("address", equalTo("New York")));
	}
	
	@Test
	public void given2Beans_whenHavingSameValues_thenCorrect() {
	    Person person1 = new Person("Sumit", "New York");
	    Person person2 = new Person("Sumit", "New York");
	    assertThat(person1, samePropertyValuesAs(person2));
	}
	
	@Test
	public void givenACity_whenNotSamePropertyValuesAs_thenCorrect() {
		Person city = new Person("Sumit", "CA");
		Person city2 = new Person("Ghosh", "CA");
	    assertThat(city, not(samePropertyValuesAs(city2)));
	}

	
}
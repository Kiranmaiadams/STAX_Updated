package StepDefinitions;

import com.STAX_Implementations.HomePageImpl;

import cucumber.api.java.en.Given;

public class HomePageDefinitions {
	HomePageImpl Home= new HomePageImpl();
	
	 @Given("^User selects the (.+)$")
	    public void user_selects_the(String sortoption) throws Throwable {
		       Home.SelectSortOption(sortoption);
	    }
}

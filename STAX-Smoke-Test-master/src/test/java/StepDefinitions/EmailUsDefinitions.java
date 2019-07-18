package StepDefinitions;

import com.STAX_Implementations.EmailUsImpl;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmailUsDefinitions {
	EmailUsImpl email = new EmailUsImpl();
	
    @And("^Clicks on Email us$")
    public void clicks_on_email_us() throws Throwable {
    	Thread.sleep(5000);
    	email.ClickEmailUs();
    }

    @And("^Provides all the details$")
    public void provides_all_the_details() throws Throwable {
        email.EnterEmailDetails();
    }

    @And("^Click on Send My Email$")
    public void click_on_send_my_email() throws Throwable {
       email.ClickSendMyEmail();
    }
	
    @Then("^An email will be sent$")
    public void an_email_will_be_sent() throws Throwable {
        email.VerifyEmailSentText();
    }
    
}

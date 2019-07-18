package STAX_Smoketest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.STAX_Objects.staxFlightspage;
import com.STAX_Objects.staxHomepage;
import com.STAX_common.StaxBase;
import com.relevantcodes.extentreports.LogStatus;

public class staxSmoketest extends StaxBase {

	staxHomepage Homepage = new staxHomepage();
	staxFlightspage Flightpage = new staxFlightspage();

	@Test(groups = { "SmokeTestpack" })
	public void staxRegistration() throws IOException {

		String testCase = new Object() { }.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(testCase);

		try {

			launchapp();

			click(Homepage.Signinbutton);

			click(Homepage.registerwithemailaddress);
			type(Homepage.emailaddress, "staqateam@statravel.com");
			click(Homepage.Continuebutton);
			type(Homepage.Firstname, "QAAUtomation");
			type(Homepage.Lastname, "Automationteam");
			type(Homepage.Password, "Password1234$");
			type(Homepage.ConfirmPassword, "Password1234$");
			click(Homepage.Signupbutton);

		} catch (Exception | AssertionError e) {
			logger.log(LogStatus.INFO, e);
			Assert.fail(e.getMessage());
			String screenShotPath = getScreenshot(testCase);
		}
	}

	@Test(groups = { "SmokeTestpack" })
	public void bookOnewayflight() throws Exception {
		String testCase = new Object() {
		}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(testCase);

		try {

			launchapp();
			waitforelement(Homepage.AcceptCookies);
			click(Homepage.AcceptCookies);
			click(Flightpage.flightlink);
			type(Flightpage.fromFlightinputbox, "London");
			waitforelement(Flightpage.fromFlightdropdown);
			// selctfromdropdown(Flightpage.fromFlightdropdown, "London Heathrow Apt, United
			// Kingdom, LHR");
			waitforelement(Flightpage.destinationFlightinputbox);
			type(Flightpage.destinationFlightinputbox, "Syd");
			selctfromdropdownwithwebelement(Flightpage.destinationFlightinputbox, Flightpage.fromFlightdropdown,
					"Sydney, Nova Scotia, Canada, YQY");

			datepiecker("21");
			datepiecker("16");
			waitforelement(Flightpage.findFlightbutton);
			click(Flightpage.findFlightbutton);
			click(Flightpage.whoIsgoing);

		} catch (Exception | AssertionError e) {
			String screenShotPath = getScreenshot(testCase);
			logger.log(LogStatus.INFO, e);
			Assert.fail(e.getMessage());

		}
	}

}

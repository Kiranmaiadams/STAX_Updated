package cucumberOptions;



import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.STAX_common.drivercommon;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/TestCases/VerifySortOrder.feature", 
glue = "StepDefinitions",  plugin = {"pretty","json:target/cucumber-report/cucumber.json"}, monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {
	drivercommon d=new drivercommon();
	
	@BeforeTest
	public void beforeScenario() throws InterruptedException {
	    System.out.println("abcd");
	    d.driver.navigate().to("http://austaging.staexperiences.com/search/two?suppliers.items=CO");
	    Thread.sleep(9000);
	}
	
}

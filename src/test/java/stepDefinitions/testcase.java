package stepDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import resources.Utilities;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class testcase {

//This is demo showcase for cucumber BDD integration. No actual working code has been entered by me. We can refer previous LEtsKodIt
//implementation here also since the coding would remain the same. The data can be drived form either .feature file or excel depending upon the user preference.
	
	@Given("^I navigate to Maketrip page$")
	public void i_am_on_webpage() throws Throwable {
		Utilities util = new Utilities();
		WebDriver driver = util.getBrowser();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Then("^I Login$")
	public void i_Login() throws Throwable {
		System.out.println("Logged In");
	}
	
	 @When("^I enter \"([^\"]*)\" as travelling from city $")
	    public void toCity(String strArg1) throws Throwable {
		 System.out.println(strArg1);	
	    }

	    @Then("^Test is successfully passed$")
	    public void verifyTest() throws Throwable {
	    System.out.println("Passed");
	    }

	    @And("^I enter \"([^\"]*)\" as travelling to city $")
	    public void fromCity(String strArg1) throws Throwable {
	   	 System.out.println(strArg1);	
	    }

	    @And("^I click search button $")
	    public void searchButtonClick() throws Throwable {
	    System.out.println("User clicked search button");	
	    }
}

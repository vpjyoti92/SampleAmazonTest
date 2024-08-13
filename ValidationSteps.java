package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.net.MalformedURLException;
import base.BasePage;


/**
 * Class is with all the step definition
 * @author Jyoti Pareek
 *
 */
public class ValidationSteps {

	BasePage base = new BasePage();


	@Then("^Validate deals displayed in new page$")
	public void validate_deals() {
		base.switch_window();
		base.validateNewTab();
	}

	@Then("^Closed the driver$")
	public void close() {
		base.teardown();
	}

	@Then("^Took the snapshot$")
	public void takescreenshot() {
//		base.take_screenshots();
	}


	@Then("^Wait for (.*) seconds$")
	public void waitFor(int waitTime)
	{
		base.WaitForTime(waitTime);
	}

	@Given("^Launch Google using (.*) browser and (.*) url$")
	public void launch_Google(String browsertype, String url)
			throws MalformedURLException, InterruptedException {
		base.createDriver(browsertype, url);
	}


	@Then("^I refresh browser$")
	public void refreshBrowser() {
		base.getDriver().navigate().refresh();
	}

	@Then("^I search for (.*) in the search box$")
	public void iSearchForNMasksInTheSearchBox(String text) {
		base.searchThing(text);
	}

	@Then("^I submit the search$")
	public void iSubmitTheSearch() {
		base.searchHit();
		System.out.println("Search successfull");
	}

	@Then("^I select the first option$")
	public void iSelectTheFirstOption() {
		base.selectSearchedElement();
		System.out.println("selection successfull");
	}

	@Then("^I switch the window$")
	public void iSwitchTheWindow() {
		base.switch_window();
		System.out.println("Switching window successfull");
	}

	@Then("^validate the price is (.*)$")
	public void validateThePriceIs(String arg0) {
		base.validatePrice(arg0);
	}

	@And("^also validate the seller is (.*)$")
	public void alsoValidateTheSeller(String str) {
		base.validateDealer(str);
	}
}

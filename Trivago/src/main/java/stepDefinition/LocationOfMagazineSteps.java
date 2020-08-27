package stepDefinition;

import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationOfMagazineSteps extends SeleniumFunctions {
	@Given("^Open the chrome and launch the application$")
	public void open_the_chrome_and_launch_the_application() throws Exception {
		openBrowser("chrome");
	}

	@When("Application is launched")
	public void application_is_launched() {
		System.out.println("Application is launched");
	}

	@Then("Search for locations")
	public void search_for_locations() {

		click(driver.findElement(By.xpath("//div[@class='search-icon']")), "Search-Icon");
		clearAndSendKey(driver.findElement(By.xpath("//input[@placeholder='Search']")), "Berlin");
		pressEnter();
	}

	@Then("check the search results")
	public void check_the_search_results() {
		System.out.println("Found search results for Berlin");
		driver.close();
	}
}

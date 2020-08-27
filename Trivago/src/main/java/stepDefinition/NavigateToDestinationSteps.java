package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NavigateToDestinationSteps extends SeleniumFunctions {

	WebElement webElement;

	private final String destination = "DESTINATION";
	private final String themes = "THEMES";

	@Given("^Open the chrome web browser and launch the application$")
	public void open_the_chrome_web_browser_and_launch_the_application() throws Throwable {
		openBrowser("chrome");

	}

	@Then("^Click on the menu on the top left\\.$")
	public void click_on_the_menu_on_the_top_left() throws Throwable {
		click(driver.findElement(By.xpath("//div[@class='nav-icon']")), "nav-icon");
		System.out.println("Menu button on the top leftmost side it clicked.. and navigated to other menu page.");

	}

	@Then("^Two menu options will appear\\.$")
	public void two_menu_options_will_appear() throws Throwable {
		String result_of_themes = driver.findElement(By.xpath("//div[contains(text(),'Themes')]")).getText();
		String result_of_destinations = driver
				.findElement(By.xpath("//div[@class='menu-title'][contains(text(),'Destinations')]")).getText();
		result_of_themes.contentEquals(themes);
		result_of_destinations.contentEquals(destination);
		System.out.println("+ DESTINATIONS");
		System.out.println("+ THEMES");

	}

	@Then("^Click on \"([^\"]*)\" menu option to navigate desired destination\\.$")
	public void click_on_menu_option_to_navigate_desired_destination(String arg1) throws Throwable {
		click(driver.findElement(By.xpath("//div[@class='menu-title'][contains(text(),'Destinations')]")),
				"Destinations");
		System.out.println("+ DESTINATIONS is Clicked..");

	}

	@Then("^Select a destination from the displayed list of destinations\\.$")
	public void select_a_destination_from_the_displayed_list_of_destinations() throws Throwable {
		click(driver.findElement(By.xpath("//div[contains(text(),'Northwest')]")), "NorthWest");
		System.out.println("Destination place is clicked..");

	}

	@Then("^Destination pages appears including a Verification\\.$")
	public void destination_pages_appears() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		currentUrl.contains("Northwest");
	}

}

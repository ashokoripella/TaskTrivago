package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewsLetterSubscriptionSteps extends SeleniumFunctions {

	WebElement webElement;
	String header = "You are now checked-in!";

	@Given("^Open the chrome Browser and launch application$")
	public void open_the_chrome_Browser_and_launch_application() throws Throwable {
		openBrowser("chrome");
	}

	@When("^Application is opened$")
	public void application_is_opened() throws Throwable {
		System.out.println("Application is opened..");
	}

	@Then("^Scroll down to find the news letter subscription\\.$")
	public void scroll_down_to_find_the_news_letter_subscription() throws Throwable {
		scrollToElement(driver.findElement(By.xpath("//input[@placeholder='Your e-mail address']")));
	}

	@Then("^Enter a vaild email address inthe text area\\.$")
	public void enter_a_vaild_email_address_inthe_text_area() throws Throwable {
		clearAndSendKey(driver.findElement(By.xpath("//input[@placeholder='Your e-mail address']")),
				"asd.koripel@ymail.com");
	}

	@Then("^Click on the button \"([^\"]*)\" for Subscription\\.$")
	public void click_on_the_button_for_Subscription(String arg1) throws Throwable {
		click(driver.findElement(By.xpath("//button[@class='submit']")), "Submit");
		System.out.println("Inspired ME button is clicked!!");
	}

	@Then("^check forthe displayed message to inform the user that he has subscribed to the newsletter\\.$")
	public void check_forthe_displayed_message_to_inform_the_user_that_he_has_subscribed_to_the_newsletter()
			throws Throwable {
		driver.findElement(By.xpath("//p[@class='submitted h1']")).isDisplayed();
		String pmsg = driver.findElement(By.xpath("//p[@class='submitted h1']")).getText();
		pmsg.contentEquals(header);
	}
}
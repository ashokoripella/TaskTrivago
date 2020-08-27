package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumFunctions {

	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumFunctions.class);
	public WebDriver driver;
	public String url = "https://room5.trivago.com";

	public void openBrowser(String browser) {

		LOGGER.info("Starting Browser: " + browser);
		if (browser.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\champa\\eclipse-workspace\\Trivago\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\champa\\eclipse-workspace\\Trivago\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LOGGER.info("Browser " + browser + " Successfully Invoked ");
	}

	public void setUrl(String url) {

		if (driver != null) {
			LOGGER.info("Navigating to url " + url);
			driver.navigate().to(url);
		} else
			LOGGER.info("No URL to Navigate");
	}

	public void closeBrowser() {

		if (driver != null) {
			LOGGER.info("close browser");
			driver.quit();
		} else
			LOGGER.info("No Browser to Close");
	}

	public boolean checkElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (ElementNotVisibleException e) {
			return false;
		}
	}

	public void moveToElementAndClick(WebElement webElement) {

		try {
			System.out.println("Click on element");
			new Actions(driver).moveToElement(webElement).click().build().perform();
		} catch (ElementNotVisibleException e) {
			scrollToElement(webElement);
			webElement.click();
		}
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void click(WebElement element, String name) {

		try {
			LOGGER.info("Verify that " + name + " is clicked");
			checkElementIsVisible(element);
			element.click();
		} catch (StaleElementReferenceException ex) {
			element.click();
		} catch (ElementClickInterceptedException e) {
			moveToElementAndClick(element);
		} catch (Exception e) {
			LOGGER.info("Failed to click on " + name);
			throw (e);
		}
	}

	public void clearAndSendKey(WebElement fieldName, String data) {

		LOGGER.info("Verify text box is cleared and enter value ");
		clearTextBoxValue(fieldName);
		fieldName.sendKeys(data);

	}

	public void clearTextBoxValue(WebElement Elememt) {

		LOGGER.info("Verify clear text box value");
		Elememt.clear();

	}

	public void pressEnter() {

		final Actions builder = new Actions(this.driver);
		builder.sendKeys(Keys.RETURN).build().perform();

	}
}

package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {
	
	private static WebDriver mDriver = null;
	private final static String TAG = "GoogleSearchSteps";
	private final static boolean DEBUG = false;

	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		mDriver = new ChromeDriver();
		/*
		 * if (DEBUG) { if(mDriver!= NULL) { System.out.println(""); } else {
		 * System.out.println("mmDriver is NULL"); } } System.out.println(TAG +
		 * "Browser is open");
		 */

	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		mDriver.navigate().to("https://www.google.com/");
		System.out.println("user is on search box");

	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		mDriver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Car");

	}

	@And("hits enter")
	public void hits_enter() {
		mDriver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);

	}

	@Then("user is navigated to search page")
	public void user_is_navigated_to_search_page() {
		mDriver.getPageSource().contains("car");
		mDriver.close();
		mDriver.quit();
	}

}

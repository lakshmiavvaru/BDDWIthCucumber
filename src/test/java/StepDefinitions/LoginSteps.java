package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	private static WebDriver mDriver = null;

@Given("User is on LoginPage")
public void verifyPageLaunch() {
	WebDriverManager.chromedriver().setup();
	mDriver = new ChromeDriver();
    System.out.println("User is on Login page");
}

@And("user enters Username and Password")
public void addUsernameAndpassword() {
	
	  System.out.println("User enters username and password");
}

@When("clicks on login button")
public void clikOnLoginButton() {
	  System.out.println("User clicks on Login button");
}

@Then("user is navigated to Homepage")
public void UserNavigated() {
	  System.out.println("User is navigated to Homepage");
}
	

}

package rahhulshettyassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Assignment2 {
	private static WebDriver mDriver = null;
	private final static String TAG = "GoogleSearchSteps";
	private final static boolean DEBUG = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		mDriver = new ChromeDriver();
		mDriver.get("https://rahulshettyacademy.com/angularpractice/");
		mDriver.manage().window().maximize();
		mDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("Lakshmi");
		mDriver.findElement(By.name("email")).sendKeys("abb@yopmail.com");
		mDriver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
		mDriver.findElement(By.className("form-check-input")).click();
		WebElement choose = mDriver.findElement(By.id("exampleFormControlSelect1"));
		Select cho = new Select(choose);
		cho.selectByVisibleText("Female");
		mDriver.findElement(By.id("inlineRadio1")).click();
		mDriver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10-03-1988");
		//;
		mDriver.findElement(By.xpath("//input[@value='Submit']")).click();
		String successMessage = mDriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		Assert.assertEquals(successMessage, "Success! The Form has been submitted successfully!.");
		mDriver.quit();
		
}
}
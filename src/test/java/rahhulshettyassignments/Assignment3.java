package rahhulshettyassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	static WebDriver driver =  null;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		/*
		 * driver.findElement(By.id("//label[2]//span[2]")).click(); Alert alert =
		 * driver.switchTo().alert(); alert.accept();
		 */
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selobj =  new Select(staticDropdown);
		selobj.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		for(int i=1;i<=4;i++) {
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		
		
		
	}

}

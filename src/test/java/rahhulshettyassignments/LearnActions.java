package rahhulshettyassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnActions {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		WebElement move =  driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("list").build().perform();
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(10000);
		/*
		 * WebDriverWait w = new WebDriverWait(driver,5);
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
		 */
		int count = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']")).size();
		System.out.println(count);
		
		/*Select x = new Select(WebElement);
		Action x = new Actions(driver)*/
		
	}
	
	

}

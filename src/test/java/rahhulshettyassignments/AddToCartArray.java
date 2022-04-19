package rahhulshettyassignments;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AddToCartArray {

	static WebDriver mDriver = null;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		mDriver = new ChromeDriver();
		WebDriverWait w =  new WebDriverWait(mDriver,5);
		
		
		//mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String veggies[] = { "Cucumber", "Brocolli", "Beetroot" };
		mDriver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(mDriver, veggies);
		
		mDriver.findElement(By.xpath("//img[@alt='Cart']")).click();
		mDriver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		mDriver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		mDriver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String message = mDriver.findElement(By.cssSelector("span.promoInfo")).getText();
		Assert.assertEquals(message, "Code applied ..!");
		
		
		

	}

	public static void addItems(WebDriver mDriver, String[] veggies) throws InterruptedException {
		List<WebElement> products1 = mDriver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products1.size(); i++) {
			String[] name = products1.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// converting array Veggies to arrayList
			List itemsNeededList = Arrays.asList(veggies);
			int j = 0;
			if (itemsNeededList.contains(formattedName)) {
				j++;
				mDriver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				Thread.sleep(2000);
				if (j == 2) {
					break;
				}
			}
		}
	}
}

package rahhulshettyassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End2End {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver mDriver = new ChromeDriver();
		mDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		mDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		mDriver.findElement(By.xpath("//a[@value='ATQ']")).click();
		mDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		Thread.sleep(5000);
		mDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(5000);
		for(int i=1; i<=4;i++) {
			mDriver.findElement(By.id("hrefIncAdt")).click(); //click + icon on adult 4 times
		}
		mDriver.findElement(By.id("btnclosepaxoption")).click();
		WebElement staticDropdown = mDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select selobj =  new Select(staticDropdown);
		selobj.selectByIndex(3);
		mDriver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//mDriver.findElement(By.className("ui-state-default ui-state-highlight ui-state-active")).click();
		
		
		
		
		
		
		
		
		
		/*
		 * //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
		 * mDriver.findElement(By.className("red-arrow-btn")).click();
		 * mDriver.findElement(By.xpath("//a[contains(text(),'Delhi (DEL)')]")).click();
		 * mDriver.findElement(By.id(
		 * "ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		 * mDriver.findElement(By.xpath("(//a[contains(text(),'Bengaluru (BLR)')])[2]"))
		 * .click(); mDriver.findElement(By.cssSelector(
		 * ".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click
		 * ();
		 * if(mDriver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").
		 * contains("0.5")){ Assert.assertTrue(true); }
		 * mDriver.findElement(By.id("divpaxinfo")).click(); for(int i=1; i<=4;i++) {
		 * mDriver.findElement(By.id("hrefIncAdt")).click(); //click + icon on adult 4
		 * times } mDriver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		 * mDriver.findElement(By.xpath("//input[@type='submit']"));
		 */

		
		
		
		
		
	}

}

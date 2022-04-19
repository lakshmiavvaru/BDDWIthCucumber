package rahhulshettyassignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class WithoutBDD {
	
	private static WebDriver mDriver = null;
	private final static String TAG = "GoogleSearchSteps";
	private final static boolean DEBUG = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		mDriver = new ChromeDriver();
		//checkboxes(mDriver);
		//toAndFromDropdowns(mDriver);
		//dropDown(mDriver);
		//windowhandles(mDriver);
		//assignment(mDriver);
		//assignmentFrames(mDriver);
		//findLinks(mDriver);
		//findFooterLinks(mDriver);
		//findFooterPartOneLinks(mDriver);
		assign6(mDriver);
		
		
		
		/*
		 * String password = getPassword(mDriver);
		 * mDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		 * mDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
		 * mDriver.findElement(By.name("inputPassword")).sendKeys(password);
		 * mDriver.findElement(By.className("signInBtn")).click();
		 */
		/*
		 * Thread.sleep(1000); String errorText =
		 * mDriver.findElement(By.xpath("//p[@class='error']")).getText();
		 * Assert.assertEquals(errorText, "* Incorrect username or password");
		 * mDriver.findElement(By.linkText("Forgot your password?")).click();
		 */
		
		
		
	}
	
	public static String getPassword(WebDriver mDriver) throws InterruptedException {
		mDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		mDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		mDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String tempPassword = mDriver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String temppassword[] = tempPassword.split(" ");
		System.out.println(temppassword[4]);
		return temppassword[4];
		
	}
	//single option select with select tag - select by value, index, by visible text
	//static dropdowns - where choices are constant
	public static void dropDown(WebDriver mDriver) throws InterruptedException {
		mDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = mDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select selobj =  new Select(staticDropdown);
		selobj.selectByIndex(3);
		Thread.sleep(10000);
		System.out.println(selobj.getFirstSelectedOption().getText());
		selobj.selectByValue("INR");
		Thread.sleep(10000);
		System.out.println(selobj.getFirstSelectedOption().getText());
		selobj.selectByVisibleText("AED");
		System.out.println(selobj.getFirstSelectedOption().getText());
		
	}

	//select passengers in dropdown
	public static void passengerDropDown(WebDriver mDriver) throws InterruptedException {
		mDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		mDriver.findElement(By.id("divpaxinfo")).click();
		for(int i=1; i<=4;i++) {
			mDriver.findElement(By.id("hrefIncAdt")).click(); //click + icon on adult 4 times
		}
	}
	
	//Dynamic dropdowns
	public static void toAndFromDropdowns(WebDriver mDriver) throws InterruptedException {
	mDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	mDriver.findElement(By.className("red-arrow-btn")).click();
	mDriver.findElement(By.xpath("//a[contains(text(),'Delhi (DEL)')]")).click();
	mDriver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
	mDriver.findElement(By.xpath("(//a[contains(text(),'Bengaluru (BLR)')])[2]")).click();
	
	}
	//multi option select
	
	//checkboxes assignment
	public static void checkboxes(WebDriver mDriver) {
		mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox1 = mDriver.findElement(By.id("checkBoxOption1"));
		checkbox1.click();
		System.out.println(checkbox1.isSelected());
		checkbox1.click();
		System.out.println(checkbox1.isSelected());
		
		//find total num of checkboxes
		int x =  mDriver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(x);
		
	}
	
	//window handles
	public static void windowhandles(WebDriver mDriver) throws InterruptedException {
		mDriver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		//To switch from one window to another, we need to provide id's of window. thru getWindowhandle
		mDriver.findElement(By.className("blinkingText")).click();
		Set<String> windows = mDriver.getWindowHandles(); //parentid, childid will be saved in Set "windows"
		Iterator<String>it = windows.iterator();//to retrive the parent and child window id's, we use iterator
		String parentID = it.next();//this will take to 0th index and get parent window id and store it
		String childID = it.next();//this will take to 1st index and get child window id and store it
		mDriver.switchTo().window(childID);
		Thread.sleep(10000);
		String userName = mDriver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		mDriver.switchTo().window(parentID);
		mDriver.findElement(By.id("username")).sendKeys(userName);
		
	}

	//windows
	public static void assignment(WebDriver mDriver) {
		mDriver.get("https://the-internet.herokuapp.com/");
		mDriver.findElement(By.linkText("Multiple Windows")).click();
		WebDriverWait w =  new WebDriverWait(mDriver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
		mDriver.findElement(By.linkText("Click Here")).click();
		Set<String> windowHandles = mDriver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentId = it.next();
		String childId = it.next();
		mDriver.switchTo().window(childId);
		System.out.println(mDriver.findElement(By.xpath("//div[@class='example']//h3")).getText());
		mDriver.switchTo().window(parentId);
		System.out.println(mDriver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
	}
	
	//frames
	public static void handleFrames(WebDriver mDriver) {
		mDriver.get("https://jqueryui.com/droppable/");
		mDriver.switchTo().frame(mDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Actions a = new Actions(mDriver);
		WebElement source = mDriver.findElement(By.id("draggable"));
		WebElement destination = mDriver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destination).build().perform();
		// to perform action outside the frame, we need to switch back 
		mDriver.switchTo().defaultContent();
		
	}
	
	//frames assignment
	public static void assignmentFrames(WebDriver mDriver) {
		mDriver.get("https://the-internet.herokuapp.com/");
		mDriver.findElement(By.linkText("Nested Frames")).click();
		mDriver.switchTo().frame("frame-top");
		mDriver.switchTo().frame("frame-middle");
		System.out.println(mDriver.findElement(By.id("content")).getText());
	}
	
	//assignment to find total links
	public static void findLinks(WebDriver mDriver) {
		mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");// here web driver access is for whole page
		int allLinks = mDriver.findElements(By.tagName("a")).size();
		System.out.println(allLinks);
		
	}
	
	//gt count of links in footer
	public static void findFooterLinks(WebDriver mDriver) {
		mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");// here web driver access is for whole page
//To limit driver scope only for footer
		WebElement footerDriver = mDriver.findElement(By.id("gf-BIG"));
		int footerLinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinks);
	}
	
	
	public static void findFooterPartOneLinks(WebDriver mDriver) {
		mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");// here web driver access is for whole page
//To limit driver scope only for footer
		WebElement footerOneDriver = mDriver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/ul[1]"));
		int footerOneLinks = footerOneDriver.findElements(By.tagName("a")).size();
		System.out.println(footerOneLinks);
	}
	
	public static void clickAllLinksAndValidate(WebDriver mDriver) throws InterruptedException {
		mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footerOneDriver = mDriver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/ul[1]"));
		for(int i =1;i<footerOneDriver.findElements(By.tagName("a")).size();i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER); // open page in new tab
			footerOneDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);
			Set<String> windowID = mDriver.getWindowHandles();
			Iterator<String> it = windowID.iterator();
			while(it.hasNext()) {
				mDriver.switchTo().window(it.next());
				System.out.println(mDriver.getTitle());
			}
			//mDriver.navigate().back();
		}
	}
		//Assignment6
		public static void assign6(WebDriver mDriver) throws InterruptedException {
			
			mDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
			Thread.sleep(10000);
			/*
			 * WebDriverWait w = new WebDriverWait(mDriver,5);
			 * w.until(ExpectedConditions.elementToBeClickable(By.id(
			 * "//input[@id='checkBoxOption1']")));
			 */
			mDriver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
			String abc = mDriver.findElement(By.xpath("//label[@for='bmw']")).getText().trim();
			System.out.println(abc);
			WebElement dropdown = mDriver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
			Thread.sleep(5000);
			Select x =  new Select(dropdown);
			x.selectByVisibleText(abc);
			mDriver.findElement(By.id("name")).sendKeys(abc);
			mDriver.findElement(By.id("alertbtn")).click();
			mDriver.switchTo().alert().accept();
			
		}
	
	//Select  a date in calender
		public static void selectDate(WebDriver mDriver) {
			mDriver.get("https://www.yatra.com/");
			
			
			
		}
}
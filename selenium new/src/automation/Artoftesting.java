package automation;

import java.time.Duration;

//import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.Alert;
//import org.apache.commons.math3.ode.events.Action;
//import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;


public class Artoftesting {

	





	public WebDriver DoubleClick(WebDriver driver) throws InterruptedException
	{
		System.out.println("\n DOUBLE CLICK STARTED\n");
		driver.get("https://artoftesting.com/sampleSiteForSelenium");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//Double click the button to launch an alertbox
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.id("dblClkBtn"));
		action.doubleClick(btn).perform();
		System.out.println("\n DOUBLE CLICK SUCCESS\n");
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		//driver.quit();
		return driver;
	}


	public WebDriver Hover(WebDriver driver) throws InterruptedException {
		//*****performing Hover action 
		System.out.println("\n HOVER STARTED\n");
		Actions hover=new Actions(driver);
		driver.get("https://www.awwwards.com/awwwards/collections/hovers-cursors-and-cute-interactions/");
		driver.manage().window().maximize();
		//    System.out.println("___________________________");
		//    Thread.sleep(9000);
		//    System.out.println("____________________________");
		WebElement sch=driver.findElement(By.xpath("//li[2]//div[1]//figure[1]//a[1]//span[1]//video[1]"));
		//  sch.sendKeys("a");
		hover.moveToElement(sch).perform();

		Actions hover1=new Actions(driver);
		WebElement sch1=driver.findElement(By.xpath("//li[1]//div[1]//figure[1]//a[1]//span[1]//video[1]"));
		Thread.sleep(5000);
		hover1.moveToElement(sch1).perform();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("\n HOVER SUCCESS\n");
		return driver;
	}
	//____________________________________


	public WebDriver DragDrop(WebDriver driver) throws InterruptedException {
		//*****drag and drop
	//	driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		System.out.println("\nDRAG AND DROP STARTED\n");
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame(0);

	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,200)");

		WebElement from1=driver.findElement(By.id("draggable"));
	//	WebElement from2=driver.findElement(By.xpath("//span[contains(text(),'Draggable 2')]"));
	//	WebElement from3=driver.findElement(By.xpath("//span[contains(text(),'Draggable 3')]"));
	//	WebElement from4=driver.findElement(By.xpath("//span[contains(text(),'Draggable 4')]"));
		WebElement toElement=driver.findElement(By.id("droppable"));

		//Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);

		//Building a drag and drop action  (method from artoftesting)
		//org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(from1).pause(10).moveToElement(toElement).release(toElement).build();
		//dragAndDrop.perform();
		try {
		builder.clickAndHold(from1)
		.pause(Duration.ofSeconds(2))
		.moveToElement(toElement)
		.pause(Duration.ofSeconds(2))
		.release()
		.build().perform();
		System.out.println("\n DRAG AND DROP SUCCESS\n");
		}
		catch(Exception e) {
		
		System.out.println("\n DRAG AND DROP FAILED\n");
		}
		return driver;
		
	
	//	builder.dragAndDrop(from1, toElement).build().perform();
	}

	public WebDriver rightClick(WebDriver driver) {
		System.out.println("\n RIGHT CLICK STARTED\n");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("https://www.gmail.com");
		WebElement textbox = driver.findElement(By.name("btnK"));
		textbox.sendKeys(Keys.RETURN);

		try {
		WebElement gclick=driver.findElement(By.xpath("//h3[contains(text(),'gmail mail - Google')]"));
		Actions action = new Actions(driver);
		action.contextClick(gclick).build().perform();
		driver.get(driver.getCurrentUrl());
		System.out.println("\n RIGHT CLICK SUCCESS\n");
		}
		catch(NoSuchElementException e) {
			System.out.println("\n RIGHT CLICK FAILURE\n");
			System.out.println("__________________________________________________");
			e.printStackTrace();
			System.out.println("__________________________________________________");
			
		}
		
		return driver;
		
	}

	public WebDriver selectDropDown(WebDriver driver) throws InterruptedException {
		System.out.println("\n  SELECT DROP DOWN STARTED\n");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement testDropDown = driver.findElement(By.xpath("//select[@id='day']"));
		Select dropdown=new Select(testDropDown);
		dropdown.selectByIndex(24);

		WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
		Select monthdd=new Select(month);
		monthdd.selectByValue("12");

		WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
		Select yeardd=new Select(year);
		yeardd.selectByVisibleText("1997");
		Thread.sleep(3000);
		driver.manage().window().setPosition(new Point(0, -1000));
		
		System.out.println("\n SELECT DROP DOWN SUCCESS\n");
		return driver;
	}

	public WebDriver alretConfirmBox(WebDriver driver) throws InterruptedException {
		System.out.println("\n ALERT CONFORM BOX STARTED\n");
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement altbox=driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]"));
		altbox.click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Generate Confirm Box')]")).click();
		Thread.sleep(3000);
		Alert confrim=driver.switchTo().alert();
		confrim.accept();
		
		System.out.println("\n ALERT CONFORM BOX  SUCCESS\n");
		return driver;
	}

	public WebDriver keyboardEvents(WebDriver driver) throws InterruptedException {
		System.out.println("\n  KEYBOARD EVENTS STARTED\n");
		driver.get("https://w3c.github.io/uievents/tools/key-event-viewer.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement test=driver.findElement(By.xpath("//input[@id='input']"));
		test.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		test.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		test.sendKeys(Keys.UP);
		Thread.sleep(2000);
		test.sendKeys(Keys.LEFT);
		Thread.sleep(2000);
		test.sendKeys(Keys.RIGHT);
		Thread.sleep(2000);
		test.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		
		System.out.println("\n KEYBOARD EVENTS  SUCCESS\n");
		return driver;
	}

	public WebDriver testScroll(WebDriver driver) throws InterruptedException{
		System.out.println("\n  TEST SCROLL STARTED\n");
		
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 2500)"); 
		Thread.sleep(2000);
		WebElement learn=driver.findElement(By.xpath("//div[@class='button']"));
		learn.click();
		System.out.println("\n TEST SCROLL SUCCESS\n");
		return driver;
	}
	
	public WebDriver ResizeBrowser(WebDriver driver) throws InterruptedException {
		System.out.println("\nRESIZE BROWSER STARTED\n");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();	
		Thread.sleep(3000);
		int width=900;
		int height=1000;
		Dimension dimension=new Dimension(width,height);
		driver.manage().window().setSize(dimension);
		driver.manage().window().maximize();	
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		driver.get("https://www.youtube.com");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("butta bomma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer'][contains(text(),'#AlaVaikunthapurramuloo - ButtaBomma Full Video So')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
		System.out.println("\n RESIZE BROWSER SUCCESS\n");
		return driver;
	}
	
	
	public WebDriver keyboardAction(WebDriver driver) throws InterruptedException {
		System.out.println("\n KEYBOARD ACTIONS STARTED\n");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();	
		Thread.sleep(3000);
		WebElement search=driver.findElement(By.name("q"));
		Actions action=new Actions(driver);
		org.openqa.selenium.interactions.Action caps=action.keyDown(Keys.LEFT_SHIFT).sendKeys(search, "aNilkUmAr").keyUp(search, Keys.LEFT_SHIFT).build();
		caps.perform();
		Thread.sleep(5000);
		driver.get("http://www.uitestpractice.com/Students/Actions");
		Actions act=new Actions(driver);
		//act.keyDown(Keys.CONTROL)
		//.click(driver.findElement(By.name("one")))
		//.click(driver.findElement(By.name("two")))
		//.click(driver.findElement(By.name("eleven")))
		//.click(driver.findElement(By.name("twelve")))
		//.click(driver.findElement(By.name("seven")))
		//.keyUp(Keys.CONTROL)
		act.keyDown(driver.findElement(By.name("one")), Keys.CONTROL)
		  .keyDown(driver.findElement(By.name("six")), Keys.CONTROL)
		  .keyUp(driver.findElement(By.name("eleven")), Keys.CONTROL)
		.build()
		.perform();
		System.out.println("\n KEYBOARD ACTIONS SUCCESS\n");
		return driver;
		
		
	}

}

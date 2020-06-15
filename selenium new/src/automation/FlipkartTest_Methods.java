package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartTest_Methods {


	//*****	Testing the Login credentials	***** 
	public WebDriver TC_001(WebDriver driver) throws Exception {
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String name="Sunil";
		String email="sunilmk70@gmail.com";
		String password="9394797870";
		//	WebElement login=driver.findElement(By.xpath("//a[@class='_3Ep39l']"));
		//	login.click();

		WebElement userId=driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		userId.sendKeys(email);
		WebElement pass=driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		pass.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		login.click();
		Thread.sleep(5000);
		WebElement custname=driver.findElement(By.xpath("//div[contains(text(),'Sunil')]"));
		String customer=custname.getText();
		System.out.println("___________________________________");
		//	System.out.println(customer);
		if(name.equalsIgnoreCase(customer)) {
			System.out.println("****TEST CASE TC001 PASSED*****");
		}
		else {
			System.out.println("****TEST CASE TC001 FAILED*****");
		}
		System.out.println("___________________________________");
		Thread.sleep(3000);
		return driver;
	}

	//_________________________________________________________________________________________________________________________	

	//*****	Testing the Searched product name	*****
	public WebDriver TC_002(WebDriver driver) throws Exception {
		String item="iphone";
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(item);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement searched=driver.findElement(By.xpath("//span[@class='_2yAnYN']//span[contains(text(),'iphone')]"));
		String searchResult=searched.getText();
		System.out.println("___________________________________");
		//	System.out.println(searchResult);
		if(item.equalsIgnoreCase(searchResult)) {
			System.out.println("****TEST CASE TC002 PASSED*****");
		}
		else {
			System.out.println("****TEST CASE TC002 FAILED*****");
		}
		System.out.println("___________________________________");
		return driver;
	}


	//_________________________________________________________________________________________________________________________

	//*****	Testing the disable button and the content	*****
	public WebDriver TC_003(WebDriver driver) throws Exception {
		WebElement grocery=driver.findElement(By.xpath("//span[contains(text(),'Grocery')]"));
		grocery.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String item="sanitizer";
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(item);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement additem=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[1]//div[1]//div[1]//div[3]//button[2]"));
		additem.click();
		Thread.sleep(3000);
		WebElement cart=driver.findElement(By.className("_3ko_Ud"));
		cart.click();
		Thread.sleep(4000);
		WebElement placeOrder=driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']"));
		boolean OrderButton=placeOrder.isEnabled();
		//	System.out.println("*****\t"+OrderButton+"\t*****");
		int flag1=0;
		if(OrderButton) {
			flag1=1;
		}
		String Content="more to place an orderShop More";
		WebElement cartContent=driver.findElement(By.className("_3bojPq"));
		String actualContent=cartContent.getText();
		//	System.out.println("\n"+actualContent+"\n");
		if(actualContent.contains(Content)) {
			flag1=0;
		}


		if(flag1==0) {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC003 PASSED*****");
			System.out.println("___________________________________");
		}
		else {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC003 FAILED*****");
			System.out.println("___________________________________");
		}

		return driver;
	}

	//_________________________________________________________________________________________________________________________	

	//*****	Testing the Enabled button after the hiking the cart amount	*****
	public WebDriver TC_004(WebDriver driver) throws Exception {
		driver.navigate().back();
		Thread.sleep(3000);
		WebElement AddItem2=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[2]//div[1]//div[1]//div[3]//button[2]"));
		AddItem2.click();
		WebElement AddItem3=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[3]//div[1]//div[1]//div[3]//button[2]"));
		AddItem3.click();
		WebElement AddItem4=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[4]//div[1]//div[1]//div[3]//button[2]"));
		AddItem4.click();
		WebElement AddItem5=driver.findElement(By.xpath("//div[@class='t-0M7P _2doH3V']//div[3]//div[1]//div[1]//div[1]//div[1]//div[3]//button[2]"));
		AddItem5.click();

		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(2000);
		WebElement placeOrder=driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']"));
		boolean OrderButton=placeOrder.isEnabled();
		int flag1=0;
		if(OrderButton) {
			flag1=1;
		}
		if(flag1==1) {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC004 PASSED*****");
			System.out.println("___________________________________");
		}
		else {
			System.out.println("___________________________________");
			System.out.println("****TEST CASE TC004 FAILED*****");
			System.out.println("___________________________________");
		}
		Thread.sleep(3000);




		return driver;
	}

}

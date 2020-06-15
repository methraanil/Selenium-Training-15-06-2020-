package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_004 {

	public static void main(String[] args) throws Exception {
		//Setting up the Chrome driver path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");

		//Creating ChromeDriver Object
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String email="sunilmk70@gmail.com";
		String password="9394797870";


		WebElement userId=driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		userId.sendKeys(email);
		WebElement pass=driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		pass.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		login.click();
		Thread.sleep(5000);
		
		//*****	Testing the Enabled button after the hiking the cart amount	*****
		WebElement grocery=driver.findElement(By.xpath("//span[contains(text(),'Grocery')]"));
		grocery.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String item="sanitizer";
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(item);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement AddItem2=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[2]//div[1]//div[1]//div[3]//button[2]"));
		AddItem2.click();
		WebElement AddItem3=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[3]//div[1]//div[1]//div[3]//button[2]"));
		AddItem3.click();
		WebElement AddItem4=driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[4]//div[1]//div[1]//div[3]//button[2]"));
		AddItem4.click();
		WebElement AddItem5=driver.findElement(By.xpath("//div[@class='t-0M7P _2doH3V']//div[3]//div[1]//div[1]//div[1]//div[1]//div[3]//button[2]"));
		AddItem5.click();
		WebElement AddItem6=driver.findElement(By.xpath("//div[@class='t-0M7P _2doH3V']//div[3]//div[1]//div[3]//div[1]//div[1]//div[3]//button[2]"));
		AddItem6.click();

		Thread.sleep(3000);

		WebElement cart=driver.findElement(By.className("_3ko_Ud"));
		cart.click();
		Thread.sleep(4000);
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
		
		driver.quit();


	}

}

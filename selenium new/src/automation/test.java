package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/");
		driver.manage().window().maximize();
		WebElement java=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Java')]"));
	//	WebElement selenium=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium')]"));
		java.click();
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Done1");
		
	
		WebElement selenium=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium')]"));
		System.out.println("Done2");
		selenium.click();
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Done 3");
	}

}

package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/");
		driver.manage().window().maximize();	
		Thread.sleep(3000);
		WebElement java=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Java')]"));
		WebElement selenium=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium')]"));
		WebElement testng=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'TestNG')]"));
		String jresult="Java Tutorials Series - Java For Selenium";
		String sresult="Free Selenium Tutorial - Techlistic";
		String tresult="Selenium with TestNG Integration - Tutorial Series";
		
		//testing JAVA
		java.click();
		String result=driver.getTitle();
		validate(jresult, result);
		driver.navigate().back();
	//	driver.get("https://www.techlistic.com/p/selenium-tutorials.html");
		//driver.navigate().refresh();
		Thread.sleep(2000);
		result="";
		
	//	selenium.click();
		try {
		result=driver.getTitle();
		}
		catch(StaleElementReferenceException e){
			System.out.println("++++++++++++++++++");
			e.getMessage();
			System.out.println("++++++++++++++++++");
			 selenium=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium')]"));
			 result=driver.getTitle();
		}
		validate(sresult, result);
		
		//testing selenium
//	 String	result1=clicking(selenium, driver);
//		validate(sresult, result1);
//		driver.navigate().back();
//		Thread.sleep(2000);
		
		//testing testng
//	String	result2=clicking(testng, driver);
//		validate(tresult, result2);
//		driver.navigate().back();
//		Thread.sleep(2000);
		
		
		
	}
	
//	public static String clicking(WebElement element,WebDriver driver) {
//		element.click();
//		String p=driver.getTitle();
//		return p;
//	}
	
	public static void validate(String dresult,String result) {
		if(dresult.equals(result)) {
			System.out.println(dresult+" TEST CASE SUCCESS");
		}
		else {
			System.out.println(dresult+" TEST CASE FAILED");
		}
	}
	

}

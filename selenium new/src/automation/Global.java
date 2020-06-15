package automation;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebElement;

public class Global {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//Find element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.xpath("//a[@class='button tiny_button button_pale regular_text'][contains(text(),'Windows')]"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]")).click();
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		js.executeScript("window.scrollBy(0,200)");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search.ui-autocomplete-input"))
		);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		element.sendKeys("a");
		
	//	driver.findElement(By.cssSelector("input#search.ui-autocomplete-input")).sendKeys("a");
	}
}
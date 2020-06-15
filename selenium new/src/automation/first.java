package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		String a="Anil Kumar Methra";


		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(a);
		driver.findElement(By.xpath("//img[@id='hplogo']")).click();
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
	//	driver.findElement(By.xpath("//h3[contains(text(),'Anil Kumar Methra - Associate Engineer - Attra | L')]")).click();
	//	System.out.println(driver.findElement(By.className("top-card-layout__title")));

	//	boolean d=driver.findElement(By.className("top-card-layout__title")).getText().equals(a);

	//	if(d==true) {
	//		System.out.println("Test case success");
	//	}
	//	else {
	//				System.out.println("Test case failed");
	//			}	
	//	driver.navigate().back();
	//	WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.navigate().refresh();
		driver.navigate().back();
		driver.findElement(By.name("q")).sendKeys("https://artoftesting.com/sampleSiteForSelenium");
		//driver.close();
		driver.findElement(By.xpath("//img[@id='hplogo']")).click();
		System.out.println("_______________________--");
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
	//	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("btnK"))));
		
	//	driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

	//	driver.findElement(By.className("gNO89b")).click();
		//driver.get("https://artoftesting.com/sampleSiteForSelenium");


			//WebElement element = driver.findElement(By.className("gLFyf gsfi"));
			//	element.sendKeys("Anil kumar methra");
			//	driver.findElement(By.xpath("//i[@class='we_close']")).click();
			//	driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).click();
			//	driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).clear();
			//driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).sendKeys("Goa");

			//driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).sendKeys("Goa");

			//	driver.findElement(By.xpath("//li[@class='initial-tab flex1 safariFix__field activeBox safariFix__field--fifty']//li[1]")).click();
			//	driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).sendKeys("Hyderabad");
			//	driver.findElement(By.xpath("//input[@id='BE_flight_arrival_city']")).sendKeys("Hyderabad");

			//	System.out.println(driver.getClass());

			//driver.quit();
		}

	}

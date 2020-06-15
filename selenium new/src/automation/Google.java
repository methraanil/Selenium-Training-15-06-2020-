package automation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Google {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		testone t=new testone();

		var li=new ArrayList<String>();
		String excelpath="C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\Gmail.xlsx";
	//	li =t.ReadExcel(excelpath);
		System.out.println(li);



		driver.findElement(By.name("q")).sendKeys(li.get(0));
		WebElement textbox = driver.findElement(By.name("btnK"));
		textbox.sendKeys(Keys.RETURN);

		//testing double click
		WebElement gclick=driver.findElement(By.xpath("//h3[contains(text(),'Gmail www.gmail.com - Google')]"));
		Actions action = new Actions(driver);
		action.contextClick(gclick).build().perform();
		Actions move=new Actions(driver);
		move.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		//Right click was working fine, but selecting the new tab is not working.
		//______________________________________________________

		Thread.sleep(1000);
		driver.get("https://www.globalsqa.com/demo-site/auto-complete/");
		driver.manage().window().maximize();
		System.out.println("_______________________________");
		//user name and password

		try {
			driver.findElement(By.id("search")).sendKeys("a");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("_______________________________");

	}

}

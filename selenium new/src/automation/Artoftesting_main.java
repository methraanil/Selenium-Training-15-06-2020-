package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Artoftesting_main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	//	System.setProperty("webdriver.gecko.driver","C:\\Users\\sunil_Anil\\Desktop\\Attra-CoreJavaTraining\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		
		Artoftesting obj=new Artoftesting();
		
	/*	driver=obj.DoubleClick(driver); 
		driver=obj.Hover(driver);
		driver=obj.DragDrop(driver);   //***not working***
		
		
		driver=obj.alretConfirmBox(driver);
		driver=obj.keyboardEvents(driver);
		driver=obj.testScroll(driver);
		driver=obj.ResizeBrowser(driver); //added naviagtion(forward and Backward)
		driver=obj.keyboardAction(driver);	
		
*/		driver=obj.rightClick(driver); //added with refresh option
		driver=obj.selectDropDown(driver); //added minimize option
	}

}

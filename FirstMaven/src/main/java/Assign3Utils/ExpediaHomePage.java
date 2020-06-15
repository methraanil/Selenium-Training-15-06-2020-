package Assign3Utils;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ExpediaHomePage {

private WebDriver driver;
	
	
	public ExpediaHomePage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//__________________________________________________________________________________________________________
	
	
	@FindBy(id ="header-account-menu")
	private WebElement accountTab;
	
	@FindBy(id ="account-signin")
	private WebElement signInTab;
	
	@FindBy(id ="gss-signin-email")
	private WebElement emailField;
	
	@FindBy(id ="gss-signin-password")
	private WebElement passwordField;
	
	@FindBy(id ="gss-signin-submit")
	private WebElement signInButton;
	
	
	
	
	//__________________________________________________________________________________________________________
	
	public void SignInAccount(String emailId,String password) {
		accountTab.click();
		signInTab.click();
		
		emailField.click();
		emailField.sendKeys(emailId);
		
		passwordField.click();
		passwordField.sendKeys(password);
		
		signInButton.click();
	}
	
	public void ValidateHomePage(String url) {
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,url);
		System.out.println("_______________________________");
		System.out.println("TC-001 STEP-1: SUCCESS");
		System.out.println("_______________________________");
	}
}

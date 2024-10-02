package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TestExecute1 {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@AfterClass
	public void tarDown() {
		driver.quit();
	}
	
	@Test
	public void verify_account_registration() {
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickRegister();
		
		AccountRegistration reg = new AccountRegistration(driver);
		reg.setFirstname("aziz");
		reg.setLastname("sakib");
		reg.setEmail("azizsakib24@gmail.com");
		reg.setTelephone("01921380201");
		reg.setPass("sakib654");
		reg.setConfirmPass("sakib654");
		
		reg.checkBox();
		reg.btnClick();
	}
}

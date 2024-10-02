package selenium_1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
	 WebDriver driver;
	 
	 @BeforeClass
	 void setup() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	 @Test(dataProvider = "loginDataProvider")
	    void testLogin(String email, String pwd) throws InterruptedException {
	        // Navigate to the login page
	        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

	        // Enter email and password
	        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
	        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(pwd);

	        // Click on the login button
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]")).click();

	        // Adding wait time for demonstration purposes; in real cases, use WebDriverWait.
	        Thread.sleep(2000);

	        // Check if login was successful
	        boolean status = driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();

	        if (status) {
	            // Logout if login is successful
	            driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
	            Assert.assertTrue(true);
	        } else {
	            Assert.fail();
	        }
	    }
	 @AfterClass
	    void tearDown() {
	        // Quit the driver to close the browser
	        driver.quit();
	    }
	 @DataProvider(name = "loginDataProvider")
	    Object[][] loginData() {
	        return new Object[][]{
	                {"pavanol123@gmail.com", "test@123"},
	                {"johncanedy@gmail.com", "test"},
	                {"abc@gmail.com", "test123"}
	        };
	    }

}

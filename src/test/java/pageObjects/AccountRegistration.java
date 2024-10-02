package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="input-firstname") WebElement txt_firstName;
	@FindBy(id="input-lastname") WebElement txt_lastName;
	@FindBy(id="input-email") WebElement txt_email;
	@FindBy(id="input-telephone") WebElement txt_telephone;
	@FindBy(id="input-password") WebElement txt_password;
	@FindBy(id="input-confirm") WebElement txt_confirmpass;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]") WebElement checkbox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]") WebElement clickbtn;
	
	
	public void setFirstname(String fName) {
		txt_firstName.sendKeys(fName);
	}
	
	public void setLastname(String lname) {
		txt_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txt_telephone.sendKeys(tel);
	}
	
	public void setPass(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPass(String pwd) {
		txt_confirmpass.sendKeys(pwd);
	}
	
	public void checkBox() {
		checkbox.click();
	}
	
	public void btnClick() {
		clickbtn.click();
	}
	
}

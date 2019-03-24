package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "SIGN-ON")
 	WebElement signOnLink;
	@FindBy(name = "userName")
	WebElement loginInput;
	@FindBy(name = "password")
	WebElement passwInput;
	@FindBy(name = "login")
	WebElement loginBtn;
	
	
		public LoginPage(WebDriver driver) {        //konstruktor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void goToLoginPage() {
		signOnLink.click();
	
		
	}	
		public void loginAs(String login, String pass) {
			loginInput.sendKeys(login);
			passwInput.sendKeys(pass);
			loginBtn.click();
		}
		
		
	}


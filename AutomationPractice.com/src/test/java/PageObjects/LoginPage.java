package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver lDriver;
	public LoginPage(WebDriver rdriver)
	{
		lDriver=rdriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(id="username")
	WebElement txtBox_username;
	
	@FindBy(id="password")
	WebElement txtBox_password;
	
	@FindBy(xpath = "//input[@name='login']")
	WebElement btn_Login;
	
	@FindBy(id="reg_email")
	WebElement reg_email;
	
	@FindBy(id="reg_password")
	WebElement reg_password;
	
	@FindBy(xpath = "//input[@name='register']")
	WebElement btn_register;
	public void enterUsername(String uname) 
	{
		txtBox_username.clear();
		txtBox_username.sendKeys(uname);
		
	}
	public void enterPassword(String pass)
	{
		txtBox_password.clear();
		txtBox_password.sendKeys(pass);
		
	}
	public void clickOnLogin()
	{
		btn_Login.click();
		
	}
	public void enterEmailforRegistration(String email)
	{
		reg_email.clear();
		reg_email.sendKeys(email);
		
	}
	public void enterPasswornForRegistraion(String pswd) {
		reg_password.clear();
		reg_password.sendKeys(pswd);
		
	}
	public UserHomePage ClickOnRegisterButton()
	{
		btn_register.click();
		return new UserHomePage(lDriver);
		
	}
}

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

}

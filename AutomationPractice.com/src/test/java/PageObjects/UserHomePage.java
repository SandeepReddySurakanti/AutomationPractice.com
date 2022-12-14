package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserHomePage 
{
	WebDriver lDriver;
	public UserHomePage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://practice.automationtesting.in/my-account/customer-logout/' and text()='Logout']")
	WebElement link_Logout;
	
	
	public void clickOnLogout()
	{
		link_Logout.click();
	}

}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage 
{
	WebDriver lDriver;
	public ShopPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
		
	}
	@FindBy(xpath = "//nav[@class='woocommerce-breadcrumb']/a")
	WebElement link_homePage;
	
	public HomePage clickOnHomePageLink()
	{
		link_homePage.click();
		return new HomePage(lDriver);
		
	}
	

}

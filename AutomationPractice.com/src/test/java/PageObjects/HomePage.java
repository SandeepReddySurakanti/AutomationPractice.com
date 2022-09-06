package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.command.PullImageCmd;

public class HomePage
{
	WebDriver lDriver;
	public HomePage(WebDriver driver)
	{
		lDriver=driver;
		PageFactory.initElements(lDriver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='n2-ss-slider-3']/div/div/img")
	List<WebElement> NoOfSliders;
	
	@FindBy(xpath="//*[@id='menu-item-40']/a")
	WebElement link_shop;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div/div/div/ul/li/a[1]")
	List<WebElement> noOfArrivals;
	
	@FindBy(xpath="//a[@href='https://practice.automationtesting.in/product/selenium-ruby/']")
	WebElement rubyBook;
	
	public int getSliderCount()
	{
		return NoOfSliders.size();
	}
	public ShopPage clickONShopLink()
	{
		link_shop.click();
		return new ShopPage(lDriver);
		
	}
	public int getArrivalsCount()
	{
		return noOfArrivals.size();
	}
	public List<WebElement> getArrivalsList()
	{
		return noOfArrivals;
	}
	public ProductAddToCartPage clickONRubybook()
	{
		 rubyBook.click();
		 return new ProductAddToCartPage(lDriver);
	}

}

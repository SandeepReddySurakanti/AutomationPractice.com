package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddToCartPage 
{
	WebDriver lDriver;
	public ProductAddToCartPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(xpath  = "//button[@class='single_add_to_cart_button button alt']")
	WebElement button_addToCart;
	
	@FindBy(xpath="//div[@id='tab-description']//p")
	WebElement text_Description;
	
	@FindBy(xpath = "//div[@id='comments']/h2")
	WebElement  review;
	
	@FindBy(xpath="//a[@href='#tab-reviews']")
	WebElement link_reviews;
	
	@FindBy(xpath = "//p[@class='price']/span")
	WebElement price;
	
	@FindBy(xpath="//div/a[@href='https://practice.automationtesting.in/basket/']")
	WebElement link_viewBasket;
	
	@FindBy(xpath="//p[@class='stock in-stock']")
	WebElement stockOfBook;
	
	@FindBy(xpath="//div[@class='quantity']/input")
	WebElement quantityInput;
	
	@FindBy(xpath="//a[@class='wpmenucart-contents']/span[1]")
	WebElement menuListQuantity;
	
	@FindBy(xpath = "//a[@class='wpmenucart-contents']/span[2]")
	WebElement menuListPrice;
	
	@FindBy(xpath = "//li/a[@href='https://practice.automationtesting.in/basket/']")
	WebElement link_menuLink;
	
	public boolean isAddToCartButtonPresent()
	{
		return button_addToCart.isDisplayed();
	}
	public void clickOnAddToCart()
	{
		button_addToCart.click();
		
	}
	public String getDescriptionText()
	{
		String stringdesc=text_Description.getText();
		System.out.println("The discription text is : "+stringdesc);
		return stringdesc;
	}
	public void clickOnReviewsLink()
	{
		link_reviews.click();
	}
	public boolean IsReviewSectionPresent()
	{
		return review.isDisplayed();
	}
	public String getBookPrice()
	{
		return  price.getText();
	}
	public boolean isLink_ViewasketEnabled()
	{
		return link_viewBasket.isEnabled();
	}
	public String getBooksStock()
	{
		String stockString=stockOfBook.getText();
		System.out.println("The stock is : "+stockString);
		String[] strArray= stockString.split(" ");
		System.out.println("The stock is : "+strArray[0]);
		return strArray[0];

		
		
	}
	public void enterQuantity(String quantity)
	{
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}
	public String getMenuListQuantity()
	{
		String menulistquantityString=menuListQuantity.getText();
		String[] strArray=menulistquantityString.split(" ");
		return strArray[0];
	}
	public String getMenuListPrice()
	{
		String menuListpriceString=menuListPrice.getText();
		return menuListpriceString;
		
	}
	public ProceedToCheckOutPage clickOnMenuList()
	{
		link_menuLink.click();
		return new ProceedToCheckOutPage(lDriver);
		
	}
	
}

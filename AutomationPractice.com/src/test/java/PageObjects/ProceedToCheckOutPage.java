package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.command.PullImageCmd;

public class ProceedToCheckOutPage 
{
	WebDriver lDriver;
	
	public ProceedToCheckOutPage(WebDriver rdriver)
	{
		lDriver=rdriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(id = "coupon_code")
	WebElement txtBox_coupon;
	
	@FindBy(xpath = "//input[@name='apply_coupon']")
	WebElement btn_applyCoupon;
	
	@FindBy(xpath = "//td[@data-title='Coupon: krishnasakinala']/span[@class='woocommerce-Price-amount amount']")
	WebElement coupon_value;
	
	@FindBy(xpath="//table[@class='shop_table shop_table_responsive cart']/tbody/tr[1]/td/child::*")
	List<WebElement> addedItemfirstrowlist;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	WebElement removeProductMessagElement;
	
	@FindBy(xpath="//span[@class='amount']")
	WebElement menuListPrice;
	
	@FindBy(xpath="//input[@class='input-text qty text']")
	WebElement firstrowQuantity;
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]")
	WebElement btn_updateCart;
	
	@FindBy(xpath="//td[@data-title='Total']/strong/span[@class='woocommerce-Price-amount amount']")
	WebElement totalCartPrice;
	
	@FindBy(xpath="//td[@data-title='Subtotal']/span")
	WebElement subTotal;
	
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	WebElement btn_proceedToCheckout;
	
	
	public String getTitle()
	{
		return lDriver.getTitle();
	}
	public void enterCouponCode(String couponName)
	{
		txtBox_coupon.clear();
		txtBox_coupon.sendKeys(couponName);
				
	}
	public void clickOnApplyCoupon()
	{
		btn_applyCoupon.click();
		
	}
	public String getCouponValue()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coupon_value.getText().replace("₹","");
	}
	public boolean isCouponDisplayed()
	{
		return coupon_value.isDisplayed();
	}
	public List<WebElement> getFirstRowList()
	{
		return addedItemfirstrowlist;
		
	}
	public String getRemoveproductMessage()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(removeProductMessagElement.isDisplayed());
		return removeProductMessagElement.getText();
	}
	public String getmenuListPrice()
	{
		String string=menuListPrice.getText().replace("₹", "");
		return string;
	}
	public String getfirstRowQuantity()
	{
		System.out.println("firstrowQuantity is :"+firstrowQuantity.getAttribute("value"));
		return firstrowQuantity.getAttribute("value");
		
		
	}
	public void setFirstRowQuantity(String qua) 
	{
		firstrowQuantity.clear();
		firstrowQuantity.sendKeys(qua);
		
	}
	public boolean isUpdateCartButtonEnaled()
	{
		return btn_updateCart.isEnabled();
		
	}
	public void clickOnUpdateButton()
	{
		btn_updateCart.click();
		
	}
	public boolean isTotalCartPriceDisplayed()
	{
		return totalCartPrice.isDisplayed();
	}
	public String getTotalCartPrice()
	{
		System.out.println("Total cart price :"+totalCartPrice.getText().replace("₹", "").replaceAll(",",""));
		return totalCartPrice.getText().replace("₹", "").replaceAll(",","");
	}
	public String getSubTotal()
	{
		System.out.println(" Sub Total cart price :"+subTotal.getText().replace("₹", "").replaceAll(",",""));
		return subTotal.getText().replace("₹", "").replaceAll(",","");
		
	}
	public PaymentGatewayPage clickOnProceedToCheckOutButton()
	{
		btn_proceedToCheckout.click();
		return new PaymentGatewayPage(lDriver);
		
		
	}
}

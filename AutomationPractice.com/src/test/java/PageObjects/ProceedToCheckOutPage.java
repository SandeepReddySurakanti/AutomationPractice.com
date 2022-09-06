package PageObjects;

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

}

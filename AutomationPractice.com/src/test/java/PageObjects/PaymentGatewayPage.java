package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.command.PullImageCmd;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes.FaasTriggerValues;

public class PaymentGatewayPage
{
	WebDriver lDriver;
	public PaymentGatewayPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(id="billing_first_name")
	WebElement billing_first_name;
	
	@FindBy(id="billing_last_name")
	WebElement billing_last_name;
	
	@FindBy(id="billing_email")
	WebElement billing_email;
	
	@FindBy(id="billing_phone")
	WebElement billing_phone;
	
	@FindBy(id="billing_address_1")
	WebElement billing_address_1;
	
	@FindBy(id="billing_country")
	WebElement billing_country;
	
	@FindBy(id="billing_city")
	WebElement billing_city;
	
	@FindBy(id="s2id_billing_state")
	WebElement billing_state;
	
	@FindBy(id="billing_postcode")
	WebElement billing_postcode;
	
	@FindBy(id="coupon_code")
	WebElement textbox_couponCode;
	
	@FindBy(name = "apply_coupon")
	WebElement btn_apply_coupon;
	
	@FindBy(xpath = "//a[@class='showcoupon']")
	WebElement link_clickTOEnterCoupon;
	
	@FindBy(xpath = "//tr[@class='order-total']/td/strong/span")
	WebElement billingTotalPrice;
	
	
	public void enterFirstName(String g)
	{
		billing_first_name.clear();
		billing_first_name.sendKeys(g);
		
	}
	public void enterLastName(String str) 
	{
		billing_last_name.clear();
		billing_last_name.sendKeys(str);
	}
	public void enterPhone(String phone)
	{
		billing_phone.clear();
		billing_phone.sendKeys(phone);
		
	} 
	public void enterEmail(String email) 
	{
		billing_email.clear();
		billing_email.sendKeys(email);
		
	}
	public void enterBillingAddress(String address)
	{
		billing_address_1.clear();
		billing_address_1.sendKeys(address);
		
	}
	public void selectCountry(String country) throws InterruptedException
	{
		//clicking on dropdown element
				WebElement countryelement=lDriver.findElement(By.xpath("//div[@id='s2id_billing_country']/a[@class='select2-choice']"));

				WebDriverWait wait = new WebDriverWait(lDriver,Duration.ofSeconds(30)); 
				WebElement button = wait.until(ExpectedConditions.elementToBeClickable(countryelement));
				button.click();
				//selecting the value of dropdown
			    Thread.sleep(1000);
			    List<WebElement> mylist=lDriver.findElements(By.xpath("//ul[@id='select2-results-1']/li"));
			    for(WebElement element:mylist)
			    {
				   // System.out.println("the name of country is :"+element.getText());

			    	if(element.getText().equals(country))
			    	{
			    		element.click();
			    		break;
			    	}
			    }
				
	}
	public void selectCountry(int index) throws InterruptedException
	{
		//clicking on dropdown element
		WebElement countryelement=lDriver.findElement(By.xpath("//div[@id='s2id_billing_country']/a[@class='select2-choice']"));

		WebDriverWait wait = new WebDriverWait(lDriver,Duration.ofSeconds(30)); 
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(countryelement));
		button.click();
		//selecting the value of dropdown
	    Thread.sleep(1000);
	    WebElement ab=lDriver.findElement(By.xpath("//ul[@id='select2-results-1']/li["+index+"]"));
	    System.out.println("the name of country is :"+ab.getText());
	    ab.click();
		
	}
	public void selectState(String state) throws InterruptedException
	{
		WebDriverWait wait1= new WebDriverWait(lDriver,Duration.ofSeconds(30)); 

		WebElement statebutton = wait1.until(ExpectedConditions.elementToBeClickable(billing_state));
		statebutton.click();
		//selecting the value of dropdown
	    Thread.sleep(1000);
	    List<WebElement> mylist=lDriver.findElements(By.xpath("//ul[@id='select2-results-2']/li"));
	    for(WebElement element:mylist)
	    {
	    	if(element.getText().equals(state))
	    	{
	    		element.click();
	    		break;
	    	}
	    }
		
		
	}
	public void selectState(int index) throws InterruptedException
	{
		WebDriverWait wait1= new WebDriverWait(lDriver,Duration.ofSeconds(30)); 

		WebElement statebutton = wait1.until(ExpectedConditions.elementToBeClickable(billing_state));
		statebutton.click();
		//selecting the value of dropdown
	    Thread.sleep(1000);
	    WebElement ab=lDriver.findElement(By.xpath("//ul[@id='select2-results-2']/li["+index+"]"));
	    System.out.println("the name of country is :"+ab.getText());
	    ab.click();
		
		
	}
	public void enterBillingCity(String city) 
	{
		billing_city.clear();
		billing_city.sendKeys(city);
		
	}
	public void enterBillingPincode(String pincode) 
	{
		billing_postcode.clear();
		billing_postcode.sendKeys(pincode);
		
	}
	public void enterCouponCode(String coupon) 
	{
		textbox_couponCode.clear();
		textbox_couponCode.sendKeys(coupon);
		
	}
	public void clickOnApplyCouponButton()
	{
		btn_apply_coupon.click();
		
	}
	public void clickToEnterCoupon() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(lDriver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(link_clickTOEnterCoupon)).click();

		} catch (Exception e) 
		{
			JavascriptExecutor executor=(JavascriptExecutor) lDriver;
			executor.executeScript("arguments[0].click();", link_clickTOEnterCoupon);
		}
		Thread.sleep(5000);
		
	}
	public boolean isClickToEnterCouponisPresent() 
	{
		return link_clickTOEnterCoupon.isDisplayed();
		
	}
	public String getBillingTotalPrice() 
	{
		String price=billingTotalPrice.getText();
		price=price.replaceAll(",", "").replaceAll("₹", "");
		return price;
		
	}
	

}

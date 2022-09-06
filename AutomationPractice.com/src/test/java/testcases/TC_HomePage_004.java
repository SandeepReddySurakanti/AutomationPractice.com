package testcases;

import java.time.Duration;
import java.util.List;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_004 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	
	@Test
	public void checkForDescriptionOfProduct() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		List<WebElement> arrivalsList= homePage.getArrivalsList();
		int i=0;
		for(WebElement arrival:arrivalsList)
		{
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.elementToBeClickable(arrival)).click();
			arrivalsList.get(i).click();
			i++;
	
			productAddToCartPage=new ProductAddToCartPage(driver);
			String prodDescription=productAddToCartPage.getDescriptionText();
			Assert.assertNotEquals(prodDescription, "");
			Thread.sleep(5000);
			driver.navigate().back();
			//driver.navigate().refresh();
			Thread.sleep(3000);
			
		}
		
	}

}

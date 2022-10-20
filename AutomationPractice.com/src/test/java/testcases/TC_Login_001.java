package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UserHomePage;
import Utilities.ConfigUtil;
import Utilities.ExcelUtil;

public class TC_Login_001 extends BaseClass
{
	HomePage homePage;
	LoginPage loginPage;
	
	@DataProvider(name = "mydata")
	public Object[][] loadData() throws IOException
	{
		String filepathString="./test-data/LoginTestData.xlsx";
		int rowCount=ExcelUtil.getRowCount(filepathString, "Sheet1");
		int colCount=ExcelUtil.getColumnCount(filepathString, "Sheet1");
		System.out.println("rows ---->"+rowCount);
		System.out.println("columns ---->"+colCount);


		String[][] strArray=new String[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			System.out.println();
			System.out.println(i+1+"th row--------");
			for(int j=0;j<colCount;j++ )
			{
				
				System.out.print("  "+ExcelUtil.getCellData(filepathString, "Sheet1", i+1, j));

				strArray[i][j]=ExcelUtil.getCellData(filepathString, "Sheet1", i+1, j);
			}
		}
		return strArray;
		
	}
	@Test(dataProvider = "mydata")
	public void loginTest(String username,String pass, String errMsg) throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("\n"+username+"  "+pass+"  "+errMsg);
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		loginPage= homePage.clickOnMyAccount();
		loginPage.enterUsername(username);
		loginPage.enterPassword(pass);
		loginPage.clickOnLogin();
		if(driver.getPageSource().contains("From your account dashboard you can view your"))
		{
			UserHomePage userHomePage=new UserHomePage(driver);
			userHomePage.clickOnLogout();
			Assert.assertTrue(true);
		}
		else {
			Thread.sleep(2000);
		Assert.assertTrue(	driver.getPageSource().contains(errMsg));
			
		}
		
	}
}

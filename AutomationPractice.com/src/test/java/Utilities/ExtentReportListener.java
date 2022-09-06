package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.BaseClass;


public class ExtentReportListener extends BaseClass implements ITestListener  
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test;
	 
	    public void onStart(ITestContext arg0)
	    {
	    	String str=new  SimpleDateFormat("ddMMyymm").format(new Date());
	    	String timestampString=str+".html";
	    	htmlReporter =new ExtentHtmlReporter("./CustomReports/myCustomreport"+timestampString);	  
	    	htmlReporter.config().setDocumentTitle("AutomationPractice.com Report");
	    	htmlReporter.config().setReportName("AutomationPractice.com Report");
	    	htmlReporter.config().setTheme(Theme.STANDARD);
	    	extentReports=new ExtentReports();
	    	extentReports.attachReporter(htmlReporter);
	    	extentReports.setSystemInfo("OS", "windows");
	    	extentReports.setSystemInfo("Browser", "Chrome");
	    	extentReports.setSystemInfo("tested By", "Sandeep Reddy");
	    	


	    	
	    }	
	    public void onFinish(ITestContext arg0) {					
	        		extentReports.flush();
	    }		


	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    public void onTestFailure(ITestResult result) {					
	    	test.log(Status.FAIL, " Test case failed is "+result.getMethod().getMethodName());
	    	test.log(Status.FAIL, "Test finished in "+result.getMethod().getTimeOut());
	    	test.log(Status.FAIL, "The reason for failure is--> "+result.getThrowable());
	    	try {
	    		System.out.println("-------abc123----------------->");
				String screenshotpath=getScreenshotpath(result);
				test.addScreenCaptureFromPath(screenshotpath);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 catch (IOException e) {
				e.printStackTrace();
			}
	        		
	    }		

	    	
	    public void onTestSkipped(ITestResult result) {
	    	test.log(Status.SKIP, "Test skipped is "+result.getMethod().getMethodName());
	    	test.log(Status.SKIP, "Test finished in "+result.getMethod().getTimeOut());
	        		
	    }		

	    	
	    public void onTestStart(ITestResult result) 
	    {
	    	test=extentReports.createTest(result.getMethod().getMethodName());

	        		
	    }		

	 		
	    public void onTestSuccess(ITestResult result) 
	    {					
	    	test.log(Status.PASS, " Test case passed is "+result.getMethod().getMethodName());
	    	test.log(Status.PASS, "Test finished in "+result.getMethod().getTimeOut());

	        		
	    }		
	    public String getScreenshotpath(ITestResult result) throws InterruptedException
	    {
	    	System.out.println("-------abc----------------->"+driver.getTitle());
	    	Thread.sleep(2000);
	    	TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	    	File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
	    	String pathString="screenshots/"+result.getMethod().getMethodName()+System.currentTimeMillis()+".png";
	    	System.out.println("------->"+pathString);
	    	File destFile=new File(pathString);
	    	try {
				FileUtils.copyFile(src, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return destFile.getAbsolutePath();
	    }

}

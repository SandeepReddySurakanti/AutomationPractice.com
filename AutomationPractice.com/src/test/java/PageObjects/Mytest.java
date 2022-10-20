package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mytest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://practice.automationtesting.in/");
		
		driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product/selenium-ruby/']")).click();
		driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/form/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
	}

}

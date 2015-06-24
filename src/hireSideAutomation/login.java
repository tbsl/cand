package hireSideAutomation;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class login extends hireBaseFunctions{
	
	public static WebDriver driver= null;
	
	Set<String> funcAreadHandler;
	@org.testng.annotations.BeforeClass
	public void setup()throws IOException
	
	{
		//WebDriver driver=new FirefoxDriver();
		//driver.get("qchire.timesjobs.com");
		hireBaseFunctions.startup();
		
	}
	
	@Test
	
	public void logindata() throws Exception
	     {
		
		
			EmployerLogin("charu_stage1", "tbsl123456","http://qchire.timesjobs.com");
		
			driver.findElement(By.cssSelector("#maintab_searchCand > a > b")).click();
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[6]/ul/li[5]/a")).click();
			
			driver.findElement(By.id("token-input-txtKeywordLeast")).click();
			driver.findElement(By.id("token-input-txtKeywordLeast")).clear();
			driver.findElement(By.id("token-input-txtKeywordLeast")).sendKeys("java");
			
			WebElement desg1=driver.findElement(By.id("token-input-txtKeywordLeast"));
			Actions ajaxM1=new Actions(driver);
			ajaxM1.moveToElement(desg1).build().perform();
			
			driver.findElement(By.id("chk107649593")).click();
			
			driver.findElement(By.xpath("html/body/div/div[1]/div[2]/div/div[5]/form/div/div[2]/div[5]/a[2]/div")).click();
			
			/*
		 funcAreadHandler = driver.getWindowHandles();  
		if (driver.getWindowHandles().size()>= 1)
		{  
			for(String handler : funcAreadHandler)
			{
				driver.switchTo().window(handler); 
				if (driver.getCurrentUrl().contains("JobDetailView.html"))
				{ 
					
					
				}
				
			}
			
		}*/
			
			 WebElement ckeditor_frame = driver.findElement(By.className("GB_frame"));
				driver.switchTo().frame(ckeditor_frame);
				
				driver.findElement(By.id("from")).clear();
				driver.findElement(By.id("from")).click();
	}	
}
		
	



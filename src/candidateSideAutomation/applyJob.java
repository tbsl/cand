package candidateSideAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class applyJob extends candidateBaseFunctions{

	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
	}
	
	
	// Internal job apply from SRP page after user logged in to the application
	
	@Test
	public void internaljobApplySRPLoggedUser() throws InterruptedException
	
	{				
		driver.get("http://timesjobs.com/candidate/login.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys("sauravghosh@live.com");
		driver.findElement(By.id("j_password")).sendKeys("password");
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		
		//Internal job search
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("tbsl");
		driver.findElement(By.xpath("//*[@id='quickSearchBean']/button")).click();
		//Internal job search
		
		Thread.sleep(5000);
		String head="div.job-action.clearfix button#apply_";
		String middle= "51999320";
		String tail=".applybutton.gray-btn";
		
		driver.findElement(By.cssSelector(head+middle+tail)).click();
		
		
		WebDriverWait waiting = new WebDriverWait(driver, 30); 
		waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div.job-action.clearfix div#showPostApplyData_"+middle+".applied-dtl.clearfix span.appliedbutton")),  "APPLIED"));
		
		
		String Actual= driver.findElement(By.cssSelector("div.job-action.clearfix div#showPostApplyData_"+middle+".applied-dtl.clearfix span.appliedbutton")).getText();
		System.out.println(Actual);
		String expected= "APPLIED";
		Assert.assertEquals(expected, Actual);
		
	}
	
	
	// External job apply from SRP page after user logged in to the application
	
	@Test (priority=1)  //(enabled=false)
	public void externalJobApplyLoggedUser() throws InterruptedException{ 
				
		driver.get("http://www.timesjobs.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Login into the application
		driver.findElement(By.linkText("Sign In")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe1);
		WebElement iframe2 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe2);
	    driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("sauravghosh@live.com");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		//Login into the application
		
		
		//External job search
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("L3 Engineer: Java (6 - 11 yrs)");
		driver.findElement(By.xpath("//*[@id='quickSearchBean']/button")).click();
		//External job search
		String expected="http://www.mastercom.co.in/careers/jl3e/jd";
		
		driver.findElement(By.xpath("html/body/div[5]/div[2]/section/section/div/div[2]/div[1]/ul/li[1]/div/a[1]")).click();
		
		for(String winHandle : driver.getWindowHandles())
		{
	          driver.switchTo().window(winHandle);
	    }
		
		String actual= driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
	}
	
	// Internal job apply from SRP page before user logged in to the application
	
	@Test (priority=2) //(enabled=false)
	public void internaljobApplySRPNonLoggedUser() throws InterruptedException
	
	{
		driver.get("http://candstaging.timesjobs.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Internal job search
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("Purchase / Vendor Development Manager / Head DeveVendor Job from P2 (10 - 15 yrs)");
		driver.findElement(By.xpath("//*[@id='quickSearchBean']/button")).click();
		//Internal job search
				
		driver.findElement(By.xpath("html/body/div[5]/div[2]/section/section/div/div[2]/div[1]/ul/li[1]/div/button")).click();
		
		//Login into the application
		WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe1);
		WebElement iframe2 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe2);
	    driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("sauravstg@mailinator.com");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		//Login into the application
		String expected="Applied successfully. Recruiters may contact you at";
		
		WebDriverWait waiting = new WebDriverWait(driver, 30); 
		waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='confirmationLine']/div[1]/strong")), "Applied successfully. Recruiters may contact you at"));
		
		
		String actual= driver.findElement(By.xpath("//*[@id='confirmationLine']/div[1]/strong")).getText();
		Assert.assertEquals(actual, expected);
		
	
	}
	
	
	// External job apply from SRP page before user logged in to the application
	
	@Test  (priority=3) //(enabled=false)
	public void externalJobApplyNonLoggedUser() throws InterruptedException
	{
		driver.get("http://www.timesjobs.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//External job search
		driver.findElement(By.xpath("//*[@id='txtKeywords']")).sendKeys("L3 Engineer: Java (6 - 11 yrs)");
		driver.findElement(By.xpath("//*[@id='quickSearchBean']/button")).click();
		//External job search
		
		driver.findElement(By.xpath("html/body/div[5]/div[2]/section/section/div/div[2]/div[1]/ul/li[1]/div/a[1]")).click();
		
		//Login into the application
		WebElement iframe1 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe1);
		WebElement iframe2 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe2);
	    driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("sauravghosh@live.com");
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		//Login into the application
		
		Thread.sleep(5000);
		String expected="http://www.mastercom.co.in/careers/jl3e/jd";
		
			
		for(String winHandle : driver.getWindowHandles())
		{
	          driver.switchTo().window(winHandle);
	    }
		
		String actual= driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
	}
	
	@AfterMethod
	
	public void teardon()
	{
		driver.close();
	}

}
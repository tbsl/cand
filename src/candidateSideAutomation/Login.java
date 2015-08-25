package candidateSideAutomation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login extends candidateBaseFunctions{
	


	
	@BeforeMethod
	
	public void setup() throws IOException
	{
		startup();
	}
	
	//Login from sign in layer
	
		@Test(priority=1) 
		public void signInlayer() throws InterruptedException
		{
			
		driver.get(c.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
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
		
		WebDriverWait waiting = new WebDriverWait(driver, 30); 
		waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("mytjid")), "My TimesJobs"));
		
		String Actual=c.getProperty("url")+"candidate/myhome.html";
		String Expected=driver.getCurrentUrl();
		
		Assert.assertEquals(Actual, Expected);
		
		
	}
		
	//Login from Login.html page
		
		@Test(priority=2) 
		public void loginPage() throws InterruptedException
		{
			String  runUrl=c.getProperty("url")+"candidate/login.html";
			driver.get(runUrl);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			//Login into the application
			driver.findElement(By.id("txtUseName")).sendKeys("sauravghosh@live.com");
			driver.findElement(By.id("j_password")).sendKeys("password");
			driver.findElement(By.id("submitbutton")).click();
			//Login into the application
		
		WebDriverWait waiting = new WebDriverWait(driver, 30); 
		waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("mytjid")), "My TimesJobs"));
		
		String Actual=c.getProperty("url")+"candidate/myhome.html?from=myTimes";
		String Expected=driver.getCurrentUrl();
		
		Assert.assertEquals(Actual, Expected);
		
		
		}
		
		
		
	//Login from Login.html page for step one user
		
		@Test(priority=3) 
		public void loginStepOneUser() throws InterruptedException
		{
			String  runUrl=c.getProperty("url")+"candidate/login.html";
			driver.get(runUrl);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			//Login into the application
			driver.findElement(By.id("txtUseName")).sendKeys("automationstepone@gmail.com");
			driver.findElement(By.id("j_password")).sendKeys("123456");
			driver.findElement(By.id("submitbutton")).click();
			//Login into the application
		
		WebDriverWait waiting = new WebDriverWait(driver, 30); 
		waiting.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_button")));
		
		String Actual=c.getProperty("url")+"candidate/uploadyourresume.html";
		String Expected=driver.getCurrentUrl();
		
		Assert.assertEquals(Actual, Expected);
		
		
	}
		
		//Login from Login.html page for step 1.5 user
		
	@Test(priority=4) 
	public void loginStepOneptFiveUser() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys("automationsteponeptfive@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
				
	
				
	String Actual="Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!";
	String Expected=driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
				
	Assert.assertEquals(Actual, Expected);
				
				
	}
	
	
	//Login from Login.html page for step 7 user
	
	@Test(priority=5) 
	public void loginStepSevenUser() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"candidate/login.html";
		driver.get(runUrl);
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys("stepseven@gmail.com");
		driver.findElement(By.id("j_password")).sendKeys("password");
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
				
	
				
		String Actual="Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!";
		String Expected=driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
					
		Assert.assertEquals(Actual, Expected);
				
				
	}
	
	@AfterMethod
	public void teardon()
	{
		driver.quit();
	
	}

}

package hireSideAutomation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class searchApplication extends hireBaseFunctions {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
		
	}
	
	@Test
	
	public void searchCandidate() throws IOException, InterruptedException
	{

		// TODO Auto-generated method stub
		
	
		
		
		driver.get(c.getProperty("bidyut_url"));
		
		
	
		driver.findElement(By.id(p.getProperty("b_username"))).sendKeys(c.getProperty("bid_userName"));
		driver.findElement(By.id(p.getProperty("b_password"))).sendKeys(c.getProperty("bid_password"));
		driver.findElement(By.id(p.getProperty("login_button"))).click();
		driver.findElement(By.xpath(p.getProperty("wizjobtab"))).click();
		driver.findElement(By.xpath(p.getProperty("app_searchLink"))).click();
		driver.findElement(By.xpath(p.getProperty("activeJob_radiobutton"))).click();
		driver.findElement(By.id(p.getProperty("dropdownlist"))).click();
		
	//	driver.findElement(By.cssSelector(p.getProperty("b_username"))).sendKeys(c.getProperty("bid_userName"));
		driver.findElement(By.cssSelector(c.getProperty("checkbox_1"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_2"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_3"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_4"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_5"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_6"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_7"))).click();
		driver.findElement(By.cssSelector(c.getProperty("checkbox_8"))).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("closeDD"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(p.getProperty("searchButton"))).click();
		
		
		driver.findElement(By.xpath(p.getProperty("candResume"))).click();
	
				
		
		
		
		for(String winHandle : driver.getWindowHandles())
		{
		driver.switchTo().window(winHandle);

		//In case title change with new window name new title name can be known with below statement
		System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
		}
	    
		driver.findElement(By.cssSelector(c.getProperty("emailText"))).click();
		driver.findElement(By.xpath(p.getProperty("emailLink"))).click();
		
		
	     
	    //switch to iframe
	    
	    driver.switchTo().frame("GB_frame1");
	    driver.switchTo().frame("GB_frame");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(p.getProperty("templeteDD"))).click();
	    
	    //driver.findElement(By.cssSelector("select[value='443851']")).click();
	   // driver.findElement(By.xpath("//*[@id='from']")).sendKeys("bidyut");
	    
	    Select droplist = new Select(driver.findElement(By.xpath(p.getProperty("templeteDD"))));
	    driver.findElement(By.xpath(p.getProperty("templeteDD"))).click();
	    
		
	    droplist.selectByIndex(2);
	    
	    driver.findElement(By.xpath(p.getProperty("templeteDD"))).sendKeys(Keys.ENTER);
	    
	    
	   /* Thread.sleep(5000);
	    WebElement select11 = driver.findElement(By.xpath("//*[@id='templateId']"));
	    List<WebElement> options11 = select11.findElements(By.tagName("option"));
	    for (WebElement option : options11) {
	    if("hello templete".equals(option.getText()))
	    option.click();
	    */
	 
	    driver.findElement(By.xpath(p.getProperty("sendMail"))).click();
	    //Final Verification
	    
	    String actual = driver.findElement(By.xpath(p.getProperty("verifiationM"))).getText();
		String expected = "Your email/job has been successfully sent to 1 candidates.";
		Assert.assertEquals(actual, expected);
	
		
	}
	@AfterMethod
	public void teardon()
	{
		//driver.quit();
	}
	

}

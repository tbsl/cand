package candidateSideAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Endorsement {

	/**
	 * @param <IWebElement>
	 * @param args
	 * @throws InterruptedException 
	 */
	
	
	static WebDriver driver,driver1;
	@BeforeMethod
	public void setup() throws IOException
	{

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		
	}
	
	
		// TODO Auto-generated method stub
		//Author: Bidyut Hazarika
		//Test Case: Endorsement using email
	@Test 
	public void endoresement() throws IOException, InterruptedException 
	{
				       
        driver.get("http://timesjobs.com");
		
        //sign in
        
        driver.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul[3]/li[1]/a")).click();
        
        
        driver.switchTo().frame("GB_frame1");
        driver.switchTo().frame("GB_frame");
        Thread.sleep(1000);
        driver.findElement(By.id("j_username")).sendKeys("bidyut.tbsl@gmail.com");
        driver.findElement(By.id("j_password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id='loginForm']/ul/li[4]/input")).click();
        
        Thread.sleep(1000);
      
        
        driver.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul/li[3]/a")).click();
        
      
        
        driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div[2]/a")).click();   
        
              
        String checkboxXPath = "//*[@id='endrosementForm']/div[2]/div[3]/ul/li/strong/label";
        WebElement elementToClick = driver.findElement(By.xpath(checkboxXPath));
        elementToClick.click();
        	
        								
        driver.findElement(By.xpath("//*[@id='endrosementForm']/div[2]/div[3]/ul/a")).click();        
        
         
                 
        
        driver.findElement(By.xpath("//*[@id='addContact']/tbody/tr/td[1]/input")).sendKeys("Bidyut");
        driver.findElement(By.xpath("//*[@id='addContact']/tbody/tr/td[2]/input")).sendKeys("purani5@mailinator.com");
        driver.findElement(By.xpath("//*[@id='how_to_know']"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='endrosementAddContact']/div[2]/div/input")).click();
        
        driver.findElement(By.cssSelector("input[value='Send Request for Endorsement']")).click();
     //   driver.findElement(By.cssSelector("input[value='Send Request for Endorsement']")).click();

        
        //Verify the endorsement successfully posted
        
           
        String actual2= driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/h3")).getText();
        String expected2="Your request for endorsement has been sent successfully!";
        
        if(actual2.equals(expected2)) {
        driver.close();
       	 
       	 System.out.println("Email Endorsement successfull ");
       	 Thread.sleep(5000);
        
        //Opening mailinator.com site
        WebDriver driver1 = new FirefoxDriver();
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.get("http://mailinator.com");
        driver1.findElement(By.xpath("//*[@id='inboxfield']")).sendKeys("puranih5");
        driver1.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div[2]/div/div/btn")).click();
        
        driver1.findElement(By.xpath("//*[@id='mailcontainer']/li[1]/a/div[1]")).click();
        
        

        WebElement wb = driver1.findElement(By.xpath("//div[@class='inbox-content']/div[3]/iframe"));
       
        
        driver1.switchTo().frame(wb);
        
        driver1.findElement(By.xpath("//div[@class='mailview']/table/tbody/tr/td/table[1]/tbody/tr[3]/td/div/font/div[2]/table[1]/tbody/tr/td/table/tbody/tr/td/div/span/font/a")).click();
        
    

        
        for(String winHandle : driver1.getWindowHandles()){
            driver1.switchTo().window(winHandle);
        }
        
        driver1.findElement(By.xpath("//div[@class='inner-header']/nav/span/a/img")).click();
        
        driver1.findElement(By.xpath("//*[@id='txtUseName']")).clear();
        Thread.sleep(1000);
        driver1.findElement(By.xpath("//*[@id='txtUseName']")).sendKeys("bidyut.tbsl@gmail.com");
        driver1.findElement(By.xpath("//*[@id='j_password']")).sendKeys("password");
      
      
        driver1.findElement(By.xpath("//*[@id='submitbutton']")).click();
      
        
        //Re login
        
              
        driver1.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul/li[3]/a")).click();
         
        driver1.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/h2/span/a/span")).click();
   
        String actual3= driver1.findElement(By.xpath("//*[@id='GB_caption']")).getText();
        											
        String expected3="Endorsement Details";
        
        Assert.assertEquals(actual3, expected3);
       	 
        }
       
        else{
        System.out.println("Email Endorsement Failed");
                
        Assert.assertEquals("bidyut", "cccaas");
        
        }
        
       
        
        
       
	}

	@AfterMethod
	public void teardon()
	{
		driver.close();
		driver1.close();
		
	}
	
	

}

package candidateSideAutomation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UpdateProfile extends candidateBaseFunctions{
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
	}

	
	@Test(priority=1)
	public void profileEdite() throws InterruptedException
	
	{
       driver.get("url"+"/candidate/login.html");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		login();   //login to application from login .html page
      
        driver.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul/li[4]/a")).click();
      
     
        driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[2]/ul/li[1]/a")).click();
      
           
        //Filling Employment Details..........
        //driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("2");
      
      
        WebElement select1 = driver.findElement(By.xpath("//*[@id='cboWorkExpYear']"));
        List<WebElement> options1 = select1.findElements(By.tagName("option"));
        for (WebElement option : options1) {
        if("2".equals(option.getText()))
        option.click();
        }

        driver.findElement(By.id("cboWorkExpYear")).sendKeys("4");
        driver.findElement(By.id("cboWorkExpMonth")).sendKeys("4");
        driver.findElement(By.id("lacSalary")).sendKeys("5");
        driver.findElement(By.id("thousandSalary")).sendKeys("4");
        driver.findElement(By.id("cboLocCity")).sendKeys("Pune");
        driver.findElement(By.xpath("//*[@id='curEmpName']")).clear();
        driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("Ibm India Pvt");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='autoSuggestListComp']/ul/li[5]/a")).click();

     
        
        driver.findElement(By.id("curEmpDesignation")).clear();
        driver.findElement(By.xpath("//*[@id='curEmpDesignation']")).sendKeys("Test Manager");
        
        driver.findElement(By.xpath("//*[@id='curEmpStartMonth']")).sendKeys("Apr");  
        
        driver.findElement(By.xpath("//*[@id='curEmpStartYear']")).sendKeys("2007");  
        driver.findElement(By.xpath("//*[@id='noticePeriod']")).sendKeys("2 months");
      
        //Filling Industry Details..........
       
        driver.findElement(By.xpath("//*[@id='rolediv']/div[1]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='funcAreaMultiId']/ul/li[29]/label/span")).click();
        driver.findElement(By.xpath("//*[@id='roleSel']")).sendKeys("IT Sales/ Technical Sales - Executive");
        driver.findElement(By.xpath(".//*[@id='areaOfSpec']/option[3]")).click();
        driver.findElement(By.xpath("//*[@id='indDiv']/div/p/button")).click();
        Thread.sleep(3000);
       
        
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
        
        String Actual="My TimesJobs";
        String Expected= driver.findElement(By.id("mytjid")).getText();
        Assert.assertEquals(Actual, Expected);
        driver.close();

       
    }
    
    @AfterMethod
	
	public void teardon()
	{
		driver.close();
	}

}
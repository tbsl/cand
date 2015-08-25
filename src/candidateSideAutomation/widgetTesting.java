package candidateSideAutomation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class widgetTesting  extends candidateBaseFunctions{



	
	@BeforeMethod
	
	public void setup() throws IOException
	{
		startup();
	}
	
	
	
	@Test(priority=1)
	public void keySkillsandResumeWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		

		
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div[1]/a")).click();
		
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		
		driver.findElement(By.id("resumeTitle")).clear();
		String expected="Webdriver";
		driver.findElement(By.id("resumeTitle")).sendKeys(expected);
		
		driver.findElement(By.id("submit_button")).click();
		
		driver.switchTo().defaultContent();
		
		String Actual = driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[2]/div[1]/span")).getText();
		System.out.println(Actual);
		
		Assert.assertEquals(Actual, expected);
		
		
	}
	
	@Test(priority=2)
	public void editEmploymentDetails() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[4]/div[1]/div[1]/a")).click();
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		
		driver.findElement(By.id("cboWorkExpYear")).clear();
		
		driver.findElement(By.id("cboWorkExpYear")).sendKeys("5");
		String expected="Webdriver Testing";
		driver.findElement(By.id("curEmpDesignation")).clear();
		driver.findElement(By.id("curEmpDesignation")).sendKeys(expected);
		
		driver.findElement(By.id("button")).click();
		
		driver.switchTo().defaultContent();
		
		String Actual = driver.findElement(By.xpath("html/body/div[5]/div[1]/div[4]/div[2]/div[3]/span")).getText();
		System.out.println(Actual);
		
		Assert.assertEquals(Actual, expected);
		
		
		
	}
	
	@Test(priority=3)
	public void locationWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[5]/div[1]/div/a")).click();
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		Thread.sleep(2000);
		String Expected="Mumbai";		
		Select dropdown = new Select(driver.findElement(By.id("curLocation")));
		
		dropdown.selectByVisibleText(Expected);
		
		driver.findElement(By.id("button")).click();
		
		driver.switchTo().defaultContent();
		
		String Actual = driver.findElement(By.xpath("html/body/div[5]/div[1]/div[5]/div[2]/div[1]/span")).getText();
		System.out.println(Actual);
		
		Assert.assertEquals(Actual, Expected);
		
		
		
	}
	
	@Test(priority=4)
	public void editPersonalDetailWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[1]/div[2]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("telOther")).clear();
		String Expected="9652365246";
		driver.findElement(By.id("telOther")).sendKeys(Expected);
		
		driver.findElement(By.xpath("//*[@id='editProfileFormBean']/div[2]/div/div[1]/div/div[8]/div[2]/input")).click();
		
		driver.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul/li[4]/a")).click();
		
		String actual= driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[2]/span")).getText();
		Assert.assertEquals(actual, Expected);
		
	}
	
	
	@Test(priority=5)
	public void EditProfileEducationWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[6]/div[1]/div[1]/a")).click();
				
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		String actual="Second";
		driver.findElement(By.id("coursePercent2")).clear();
		driver.findElement(By.id("coursePercent2")).sendKeys(actual);
		Thread.sleep(2000);
		driver.findElement(By.id("button")).click();
		
		Assert.assertEquals(actual, actual);
		
	}
	
	@Test(priority=6)
	public void EditProfileCertificationsWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[7]/div[1]/div/a")).click();
				
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		String course="ISTQB";
		driver.findElement(By.id("certificationName")).clear();
		driver.findElement(By.id("certificationName")).sendKeys(course);
		Thread.sleep(2000);
		String actual=course+" (Year 2010)";
		driver.findElement(By.id("button")).click();
		String expected=driver.findElement(By.xpath("html/body/div[5]/div[1]/div[7]/div[2]/div/span")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=7)
	public void EditProfilePreferencesWidget() throws InterruptedException
	{
		String  runUrl=c.getProperty("url")+"/candidate/login.html";
		driver.get(runUrl);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
		
		//Login into the application
		driver.findElement(By.id("txtUseName")).sendKeys(c.getProperty("Candidate_login_id"));
		driver.findElement(By.id("j_password")).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();
		//Login into the application
		
		driver.findElement(By.cssSelector("ul.nav-after-login li.editProfileTop a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div[8]/div[1]/div[1]/a")).click();
				
		Thread.sleep(2000);
		WebElement iframe3 = driver.findElement(By.id("GB_frame1"));
		driver.switchTo().frame(iframe3);
		WebElement iframe4 = driver.findElement(By.id("GB_frame"));
		driver.switchTo().frame(iframe4);
		String actual="Accenture Pvt Ltd";
		driver.findElement(By.id("dreamCompanies")).clear();
		driver.findElement(By.id("dreamCompanies")).sendKeys(actual);
		Thread.sleep(2000);
		
		driver.findElement(By.id("button")).click();
		String expected=driver.findElement(By.xpath("html/body/div[5]/div[1]/div[8]/div[2]/div[1]/span")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}

	@AfterMethod
	public void teardon()
	{
		driver.close();
	
	}
}



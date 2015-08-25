package candidateSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pixelTesting extends candidateBaseFunctions{
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
		
	}
	
	
	@Test(priority=2)
	public void pixel3p9901() throws IOException, InterruptedException
	{
		
	driver.get(c.getProperty("url")+"candidate/register.html?siteparams=3p9901");	
	//driver.get("http://candstaging.timesjobs.com/candidate/register.html?siteparams=3p9901");
	driver.findElement(By.id("emailAdd")).clear();
	
	//===============================
	String emailAdd;
	Calendar currentDate1 = Calendar.getInstance();
	SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
	String getDate = formatter1.format(currentDate1.getTime());
	emailAdd = "sanity" + getDate + "@mailinator.com";
	System.out.println(emailAdd);
	//===============================
	
	driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

	driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

	driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
	
	driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

	driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

	Select selectReport   = new Select(driver.findElement(By.id("curLocation"))); 
    selectReport.selectByIndex(4);

	driver.findElement(By.id("basicSubmit")).click();
	Thread.sleep(20000);
	if(driver.getPageSource().contains("paramList['siteparams'] = '3p9901'") && driver.getPageSource().contains("_sokClient = '60'"))
	{
	
	System.out.println("Page source contains the param in the first step");
	
	driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Bidyut");

	driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[3]")).click();
	driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='thousandSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
	driver.findElement(By.xpath("//*[@id='resumeTitle']")).sendKeys("TestResume");
	driver.findElement(By.xpath("//*[@id='token-input-keySkills']")).sendKeys("Java");
	Thread.sleep(2000);

	driver.findElement(By.xpath("html/body/div[4]/ul/li[1]")).click();

	driver.findElement(By.xpath("//*[@id='categorisedDegree']")).sendKeys("BE/B.Tech(Engineering)");
	driver.findElement(By.xpath("//*[@id='detailResume']/figure/a")).click();
	driver.findElement(By.xpath("//*[@id='description']")).sendKeys("To play a key information systems, QA Engineer or Quality Assurance role and ensuring Quality Products are delivered, using new technology, new innovative testing ideas, working on tight scheduled projects saving time and money and being productive, 2 years of experience in Manual Testing, UI Testing, EDI testing in ecommerce application of shipping logistics. 7 months of experience of automation testing using selenium. Experienced in manual testing with the focus on Functional Testing, Stress Testing, and Regression Testing. Experienced in Production and CVT acceptance testing. Experience in working with analysts, developers, and testers for complex projects during the full Software Development Life Cycle (SDLC).");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id='submit_button']")).click();
	Thread.sleep(10000);
	String str = "google_conversion_label = \"signup\";";
	
	if(driver.getPageSource().contains(str) && driver.getPageSource().contains("var google_conversion_id = 1067146772;"))
	{
		System.out.println("Page source contains the param in the second step");
		Assert.assertEquals(1, 1);
	}
	else
	{
	System.out.println("Page source does not contains the param in the second step");
	Assert.assertEquals(1, 2);
	}
	
	
	}
	else
	{
	System.out.println("Page source does not contains the param");
	Assert.assertEquals(1, 2);
	}
	}
	
	
	@Test(priority=1)
	public void pixel3p9909() throws IOException, InterruptedException
	{
		
	driver.get(c.getProperty("url")+"candidate/register.html?siteparams=3p9909");	
	//driver.get("http://candstaging.timesjobs.com/candidate/register.html?siteparams=3p9909");
	driver.findElement(By.id("emailAdd")).clear();
	
	//===============================
	String emailAdd;
	Calendar currentDate1 = Calendar.getInstance();
	SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
	String getDate = formatter1.format(currentDate1.getTime());
	emailAdd = "sanity" + getDate + "@mailinator.com";
	System.out.println(emailAdd);
	//===============================
	
	driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

	driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

	driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
	
	driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

	driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

	Select selectReport   = new Select(driver.findElement(By.id("curLocation"))); 
    selectReport.selectByIndex(4);

	driver.findElement(By.id("basicSubmit")).click();
	WebDriverWait waiting = new WebDriverWait(driver, 30); 
	waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")), "Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!"));
	
	if(driver.getPageSource().contains("paramList['siteparams'] = '3p9909'") && driver.getPageSource().contains("_sokClient = '60'"))
	{
	
	System.out.println("Page source contains the param in the first step");
	
	driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Bidyut");

	driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[3]")).click();
	driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='thousandSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
	driver.findElement(By.xpath("//*[@id='resumeTitle']")).sendKeys("TestResume");
	driver.findElement(By.xpath("//*[@id='token-input-keySkills']")).sendKeys("Java");
	Thread.sleep(2000);

	driver.findElement(By.xpath("html/body/div[4]/ul/li[1]")).click();

	driver.findElement(By.xpath("//*[@id='categorisedDegree']")).sendKeys("BE/B.Tech(Engineering)");
	driver.findElement(By.xpath("//*[@id='detailResume']/figure/a")).click();
	driver.findElement(By.xpath("//*[@id='description']")).sendKeys("To play a key information systems, QA Engineer or Quality Assurance role and ensuring Quality Products are delivered, using new technology, new innovative testing ideas, working on tight scheduled projects saving time and money and being productive, 2 years of experience in Manual Testing, UI Testing, EDI testing in ecommerce application of shipping logistics. 7 months of experience of automation testing using selenium. Experienced in manual testing with the focus on Functional Testing, Stress Testing, and Regression Testing. Experienced in Production and CVT acceptance testing. Experience in working with analysts, developers, and testers for complex projects during the full Software Development Life Cycle (SDLC).");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id='submit_button']")).click();
	Thread.sleep(10000);
	String str = "google_conversion_label = \"signup\";";
	
	if(driver.getPageSource().contains(str) && driver.getPageSource().contains("var google_conversion_id = 1046295539;"))
	{
		System.out.println("Page source contains the param in the second step");
		Assert.assertEquals(1, 1);
	}
	else
	{
	System.out.println("Page source does not contains the param in the second step");
	Assert.assertEquals(1, 2);
	}
	
	
	}
	else
	{
	System.out.println("Page source does not contains the param");
	Assert.assertEquals(1, 2);
	}
	}
	
	@Test(priority=3)
	public void pixel3p_808_630_4888() throws IOException, InterruptedException
	{
	
	driver.get(c.getProperty("url")+"candidate/register.html?siteparams=3p_808_630_4888");	
	//driver.get("http://candstaging.timesjobs.com/candidate/register.html?siteparams=3p_808_630_4888");
	driver.findElement(By.id("emailAdd")).clear();
	
	//===============================
	String emailAdd;
	Calendar currentDate1 = Calendar.getInstance();
	SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
	String getDate = formatter1.format(currentDate1.getTime());
	emailAdd = "sanity" + getDate + "@mailinator.com";
	System.out.println(emailAdd);
	//===============================
	
	driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

	driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
	driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

	driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
	
	driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

	driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

	Select selectReport   = new Select(driver.findElement(By.id("curLocation"))); 
    selectReport.selectByIndex(4);

	driver.findElement(By.id("basicSubmit")).click();
	WebDriverWait waiting = new WebDriverWait(driver, 30); 
	waiting.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")), "Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!"));
	
	if(driver.getPageSource().contains("paramList['siteparams'] = '3p_808_630_4888'")&& driver.getPageSource().contains("_sokClient = '60'"))
	{
	
	System.out.println("Page source contains the param in the first step");
	
	driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Bidyut");

	driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[3]")).click();
	driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='thousandSalary']")).sendKeys("3");
	driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
	driver.findElement(By.xpath("//*[@id='resumeTitle']")).sendKeys("TestResume");
	driver.findElement(By.xpath("//*[@id='token-input-keySkills']")).sendKeys("Java");
	Thread.sleep(2000);

	driver.findElement(By.xpath("html/body/div[4]/ul/li[1]")).click();

	driver.findElement(By.xpath("//*[@id='categorisedDegree']")).sendKeys("BE/B.Tech(Engineering)");
	driver.findElement(By.xpath("//*[@id='detailResume']/figure/a")).click();
	driver.findElement(By.xpath("//*[@id='description']")).sendKeys("To play a key information systems, QA Engineer or Quality Assurance role and ensuring Quality Products are delivered, using new technology, new innovative testing ideas, working on tight scheduled projects saving time and money and being productive, 2 years of experience in Manual Testing, UI Testing, EDI testing in ecommerce application of shipping logistics. 7 months of experience of automation testing using selenium. Experienced in manual testing with the focus on Functional Testing, Stress Testing, and Regression Testing. Experienced in Production and CVT acceptance testing. Experience in working with analysts, developers, and testers for complex projects during the full Software Development Life Cycle (SDLC).");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id='submit_button']")).click();
	Thread.sleep(10000);
	String str = "vFRXCL2EvQIQm7Ln0QM";
	
	
	if(driver.getPageSource().contains(str) && driver.getPageSource().contains("var google_conversion_id = 976869659;"))
	{
		System.out.println("Page source contains the param in the second step");
		Assert.assertEquals(1, 1);
	}
	else
	{
	System.out.println("Page source does not contains the param in the second step");
	Assert.assertEquals(1, 2);
	}
	
	
	}
	else
	{
	System.out.println("Page source does not contains the param");
	Assert.assertEquals(1, 2);
	}
	}
	
	@AfterMethod
	public void teardon()
	{
		driver.close();
	}

}

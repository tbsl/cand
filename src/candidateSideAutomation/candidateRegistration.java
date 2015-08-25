package candidateSideAutomation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class candidateRegistration extends candidateBaseFunctions {
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
		
	}
	
	// Author name :Bidyut Hazarika
	// Product name:  "timesjobs-candidate"
	// Creation date: 3-5-2014
	// Below script checks successful tj registration using LinkedIn profile
	
	
	
	@Test (enabled=false)
	public void linkedinRegistration() throws IOException, InterruptedException
	{
		driver.get(c.getProperty("url"));
		
		
		
        driver.findElement(By.xpath("//*[@class='universal-header']/header/nav[2]/ul[3]/li[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/img")).click();
        
        
        
        driver.findElement(By.xpath("//*[@id='session_key-oauthAuthorizeForm']")).sendKeys("bidyut.tjtest@gmail.com");
        driver.findElement(By.xpath("//*[@id='session_password-oauthAuthorizeForm']")).sendKeys("Password123");
        
       
        driver.findElement(By.name("authorize")).click();
        driver.switchTo().frame("GB_frame1");
        driver.switchTo().frame("GB_frame");
        
        
        driver.findElement(By.id("emailAdd")).clear();
        Thread.sleep(1000);
        
        //generating email id
        
        String emailAdd;
        Calendar currentDate1 = Calendar.getInstance();
        SimpleDateFormat formatter1= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String getDate = formatter1.format(currentDate1.getTime());
        emailAdd = "kid" + getDate + "@mailinator.com";
        System.out.println(emailAdd);
           
          
        Thread.sleep(5000);  
        
        //not working
        
        driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);   //emailAdd
        driver.findElement(By.id("passwordField")).sendKeys("password");
        driver.findElement(By.id("retypePassword")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id='basicSubmit']")).click();
        
          
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");
        driver.findElement(By.xpath("//*[@id='name']")).clear();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Linkedin Test");
        							  
       
        
        driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[1]")).click();
        driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
        driver.findElement(By.xpath("//*[@id='myButton2']")).click();
        WebElement dropDownListBox = driver.findElement(By.xpath("//*[@id='categorisedDegree']"));

        Select clickThis = new Select(dropDownListBox);

        clickThis.selectByVisibleText("BGL");
        WebElement dropDownListBox1 = driver.findElement(By.xpath("//*[@id='curLocation']"));
        Select clickThis1 = new Select(dropDownListBox1);

        clickThis1.selectByVisibleText("Delhi");
        
        Thread.sleep(10000);
        
        driver.findElement(By.xpath("//*[@id='submit_button']")).submit();
        
        Thread.sleep(2000);
      
        
        String actual2= driver.findElement(By.xpath("//*[@id='site']/div[6]/div[1]/div/div/div[2]/div/div[1]/div/p")).getText();
        String expected2="Verify your email address!";
        
        Assert.assertEquals(actual2, expected2);
		
		
	}
	
	@Test(priority=1)
	public void registraionCompleteStage() throws IOException, InterruptedException
	{
		driver.get(c.getProperty("url"));
		
		String currentURL  = driver.getCurrentUrl();
		System.out.println(currentURL);

		//****************************screen shot**************
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Bidyut.Hazarika\\Desktop\\guesthome.jpeg"));
		

		//****************************screen shot**************
		
		driver.findElement(By.xpath("//*[@class='universal-header']/header/nav[2]/ul[3]/li[2]/a")).click();

		// Generating email id
		//------------------------------------
		driver.findElement(By.id("emailAdd")).clear();
		Thread.sleep(1000);
		String emailAdd;
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
		String getDate = formatter1.format(currentDate1.getTime());
		emailAdd = "sanity" + getDate + "@mailinator.com";
		System.out.println(emailAdd);
		//------------------------------------
		// Generating email id
		
		driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);
		
		String Result=driver.findElement(By.id("emailAdd")).getAttribute("value");
		System.out.println("email id is: "+ Result);

		driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

		driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

		driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");

		Select selectReport   = new Select(driver.findElement(By.id("curLocation"))); 
        selectReport.selectByIndex(6);

		Thread.sleep(1000);
		driver.findElement(By.id("basicSubmit")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Bidyut");

		driver.findElement(By.xpath("//*[@id='areaOfSpec']/option[3]")).click();
		driver.findElement(By.xpath("//*[@id='lacSalary']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='thousandSalary']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='curEmpName']")).sendKeys("TBSL");
		driver.findElement(By.xpath("//*[@id='resumeTitle']")).sendKeys("TestResume");
		driver.findElement(By.xpath("//*[@id='token-input-keySkills']")).sendKeys("Java");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='token-input-dropdown-facebook']/ul/li[1]")).click();    //html/body/div[4]/ul/li[1]

		driver.findElement(By.xpath("//*[@id='categorisedDegree']")).sendKeys("BE/B.Tech(Engineering)");
		driver.findElement(By.xpath("//*[@id='detailResume']/figure/a")).click();
		driver.findElement(By.xpath("//*[@id='description']")).sendKeys("To play a key information systems, QA Engineer or Quality Assurance role and ensuring Quality Products are delivered, using new technology, new innovative testing ideas, working on tight scheduled projects saving time and money and being productive, 2 years of experience in Manual Testing, UI Testing, EDI testing in ecommerce application of shipping logistics. 7 months of experience of automation testing using selenium. Experienced in manual testing with the focus on Functional Testing, Stress Testing, and Regression Testing. Experienced in Production and CVT acceptance testing. Experience in working with analysts, developers, and testers for complex projects during the full Software Development Life Cycle (SDLC).");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='submit_button']")).click();
		


		String actual1 = driver.findElement(By.xpath("//*[@id='site']/div[6]/div[1]/div/div/div[2]/div/div[1]/div/p")).getText();
		String expected1 = "Verify your email address!";
		Assert.assertEquals(actual1, expected1);
		
	/*	
		driver.findElement(By.xpath("//*[@id='noedit']/a")).click();
		String usermailId=driver.findElement(By.xpath("//*[@id='newemail']")).getAttribute("value");
		System.out.println("verify email user id"+usermailId);
*/
     
	}
	
	@Test(priority=3)
	public void registraionFirstStage() throws IOException,	InterruptedException 
	
	{

		driver.get(c.getProperty("url"));
		
		driver.findElement(By.xpath("//*[@class='universal-header']/header/nav[2]/ul[3]/li[2]/a")).click();
		
		// Generating email id
		driver.findElement(By.id("emailAdd")).clear();
		Thread.sleep(1000);
		String emailAdd;
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
		String getDate = formatter1.format(currentDate1.getTime());
		emailAdd = "sanity" + getDate + "@mailinator.com";
		System.out.println(emailAdd);
		// Generating email id
		
		driver.findElement(By.id("emailAdd")).sendKeys(emailAdd);

		driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='retypePassword']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='mobNumber']")).sendKeys("7599180973");

		driver.findElement(By.xpath("//*[@id='jobfuncDiv']/fieldset[1]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='funcAreaMultiId']/ul/li[4]/label")).click();

		driver.findElement(By.xpath("//*[@id='cboWorkExpYear']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id='cboWorkExpMonth']")).sendKeys("3");
		
		Select selectReport   = new Select(driver.findElement(By.id("curLocation"))); 
        selectReport.selectByIndex(6);

		

		Thread.sleep(1000);
		driver.findElement(By.id("basicSubmit")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
		String actual = driver.findElement(By.xpath("//*[@id='registrationStep2Bean']/div[1]/h4")).getText();
		String expected = "Congratulations! Your registration is successful. Now please complete your profile to become visible to the Recruiters!";
		Assert.assertEquals(actual, expected);
	
	
	}
	
	
	@Test(priority=4)
	public void recommendedJobsVerification() throws IOException, InterruptedException 
	
	{
	
		String  runUrl=c.getProperty("url")+"candidate/login.html";
		driver.get(runUrl);
	String name = new Object(){}.getClass().getEnclosingMethod().getName();	
	
	//Login into the application
	driver.findElement(By.id("txtUseName")).sendKeys("sauravghosh@live.com");
	driver.findElement(By.id("j_password")).sendKeys("password");
	driver.findElement(By.id("submitbutton")).click();
	//Login into the application
	
	WebElement ele = driver.findElement(By.className("accordion-bx"));
	List<WebElement> joblist=ele.findElements(By.xpath("//*[@id='recoJobsContentDetails']/div/ul/li"));
	int s=joblist.size();
	
	
	int s1=Integer.parseInt(driver.findElement(By.xpath("//*[@id='suggestedJobsByOtherUser']")).getText());
	
	int p=s+s1;
	System.out.println(p);
	
	String ss=Integer.toString(p);
	
	String actual= "Recommended Jobs ("+ss+")";
	String expected=driver.findElement(By.xpath("//*[@id='personlise_RJ']")).getText();
	System.out.println(expected);
	System.out.println(actual);
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshotfolder" + "//" +name+".jpg"));
	
	Assert.assertEquals(expected, actual);
	
	}
	
	@Test(priority=2)
	public  void verifyEmail(){
		  
		    
	        driver.get("http://mailinator.com");
	      //  System.out.println(usermailId);
	       // driver.findElement(By.id("inboxfield")).sendKeys(usermailId);
	        driver.findElement(By.id("inboxfield")).sendKeys(Keys.ENTER);
	       // driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div[2]/div/div/btn")).click();
	        
	        driver.findElement(By.xpath("//*[@id='mailcontainer']/li[1]/a/div[1]")).click();
	        
	        

	        WebElement wb = driver.findElement(By.xpath("//div[@class='inbox-content']/div[3]/iframe"));
	       
	        
	        driver.switchTo().frame(wb);
	        
	        driver.findElement(By.xpath("//div[@class='mailview']/table/tbody/tr/td/table[1]/tbody/tr[3]/td/div/font/div[2]/table[1]/tbody/tr/td/table/tbody/tr/td/div/span/font/a")).click();
	}
	
	
	
	@AfterMethod
	public void teardon()
	{
		//driver.close();
	}



}

package candidateSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewResume extends candidateBaseFunctions{
	

	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
		
	}
	


@Test(priority=1)
public void AddNewResume() throws IOException, InterruptedException 

{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String  runUrl=c.getProperty("url")+"candidate/login.html";
	driver.get(runUrl);
	login();


/*//Login into the application
driver.findElement(By.id(p.getProperty("l_username"))).sendKeys(c.getProperty("Candidate_login_id"));
driver.findElement(By.id(p.getProperty("l_password"))).sendKeys(c.getProperty("Candidate_pwd"));
driver.findElement(By.id("submitbutton")).click();
*/
//click on edit profile link
Thread.sleep(2000);
driver.findElement(By.linkText(p.getProperty("EditProfileLink"))).click();

//driver.findElement(By.xpath(p.getProperty("addProfile"))).click();  

//driver.navigate().refresh(); 

//driver.findElement(By.linkText(p.getProperty("EditProfileLink"))).sendKeys(Keys.F5);

//AddNewResumeFunction();
if(driver.findElement(By.id("tab2")).isDisplayed()==false){
	driver.findElement(By.linkText(p.getProperty("EditProfileLink"))).sendKeys(Keys.F5);
}

Thread.sleep(5000);
driver.findElement(By.id(p.getProperty("inactiveResumeTab"))).click();

String ProfileCount=driver.findElement(By.id(p.getProperty("inactive_count"))).getText();
System.out.println(ProfileCount);

int counter = Integer.parseInt(ProfileCount);


if(counter==4){
	driver.findElement(By.id(p.getProperty("deleteResume"))).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	AddNewResumeFunction();
	
}else
	
AddNewResumeFunction();

}

public void AddNewResumeFunction() throws InterruptedException{
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(p.getProperty("addProfile"))).click();           //add new resume link

	String actual = driver.findElement(By.xpath(p.getProperty("PostResumeText"))).getText();
	String expected = "Post Resume";
	Assert.assertEquals(actual, expected);

	System.out.println("Add new resume page open successfully");


	Thread.sleep(5000);
	driver.findElement(By.id(p.getProperty("exp_yr"))).sendKeys(c.getProperty("exp_val"));  

	driver.findElement(By.id(p.getProperty("exp_mnth"))).sendKeys(c.getProperty("exp_val"));

	Select selectReport   = new Select(driver.findElement(By.id(p.getProperty("curLoc")))); 
	selectReport.selectByIndex(6);
	Thread.sleep(2000);
	//driver.findElement(By.id(p.getProperty("resume_title"))).sendKeys(c.getProperty("resumeTitle"));
	String resumeTitle;
	String resTitle=driver.findElement(By.id(p.getProperty("resume_title"))).getText();
	
	Calendar currentDate1 = Calendar.getInstance();
	SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
	String getDate = formatter1.format(currentDate1.getTime());
	resumeTitle ="Test"+resTitle + getDate;
	driver.findElement(By.id(p.getProperty("resume_title"))).sendKeys(resumeTitle);
	System.out.println(resumeTitle);
	


	driver.findElement(By.id(p.getProperty("key_skill"))).sendKeys(c.getProperty("keySkill"));

	Thread.sleep(2000);
	driver.findElement(By.id(p.getProperty("key_skill"))).sendKeys(Keys.TAB);

	driver.findElement(By.xpath(p.getProperty("job_func_section"))).click();
	driver.findElement(By.xpath(p.getProperty("job_function"))).click();
	driver.findElement(By.id(p.getProperty("role"))).sendKeys(c.getProperty("roleName"));
	Thread.sleep(1000);
	driver.findElement(By.xpath(p.getProperty("specialization"))).click();
	Thread.sleep(1000);
	driver.findElement(By.id(p.getProperty("degree"))).sendKeys(c.getProperty("degreeName"));
	driver.findElement(By.xpath(p.getProperty("resumeDescLink"))).click();
	driver.findElement(By.id(p.getProperty("resDescTextBox"))).sendKeys(c.getProperty("resumeDescText"));
	driver.findElement(By.id(p.getProperty("dontoactivateresume"))).click();	
	driver.findElement(By.id(p.getProperty("submitButton"))).click();

	//verification point   //*************not required as i have not allow the newly added resume to activate
/*
	String actual1=driver.findElement(By.id(p.getProperty("postResumeSuc"))).getText();
	String expected1="New Profile has been successfully created. Please update this profile now.";
	Assert.assertEquals(actual1, expected1);*/
	
	Thread.sleep(5000);
	driver.findElement(By.id(p.getProperty("inactiveResumeTab"))).click();

	String ProfileCount=driver.findElement(By.id(p.getProperty("inactive_count"))).getText();
	System.out.println(ProfileCount);

	int counter = Integer.parseInt(ProfileCount);


	if(counter==4){
		
		System.out.println("New resume Added Successfully");
	}
	
	//System.out.println("New resume Added Successfully");

	
}

@AfterMethod
public void teardon()
{
	driver.close();
}

}
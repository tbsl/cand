package candidateSideAutomation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class editProfile extends candidateBaseFunctions{
	
	@BeforeMethod
	public void setup() throws IOException
	{
		startup();
		String  runUrl=c.getProperty("url")+"candidate/login.html";
		driver.get(runUrl);
		login();
		
	}
	
@Test(priority=0)
public void editSummary() throws InterruptedException{
	Thread.sleep(1000);
	driver.findElement(By.linkText(p.getProperty("EditProfileLink"))).click();
	driver.findElement(By.id(p.getProperty("resumeTitleUpdate_Btn"))).click();
	
	//String resumeTitle=driver.findElement(By.id(p.getProperty("res_title_textBox")));
	
	String resumeTitle;
	
	Calendar currentDate1 = Calendar.getInstance();
	SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
	String getDate = formatter1.format(currentDate1.getTime());
	resumeTitle ="Test User " + getDate;
	driver.findElement(By.id(p.getProperty("res_title_textBox"))).clear();
	driver.findElement(By.id(p.getProperty("res_title_textBox"))).sendKeys(resumeTitle);
	System.out.println(resumeTitle);
	driver.findElement(By.id(p.getProperty("submit_btn"))).click();
	
	//verification point
	
	//Thread.sleep(100000);
	String proSummaryTitle=driver.findElement(By.xpath(p.getProperty("profileTitle"))).getText();
	System.out.println(proSummaryTitle);
	
	//if(resumeTitle!=proSummaryTitle){
	if(resumeTitle.equals(proSummaryTitle)){
		System.out.println("Resume Title is same as profile summary title--pass");
	}
	else	{
		System.out.println("fail....Resume Title is not same as profile summary title");
	}
	
	
	
	
	
/*	Mozilla
	log4j:WARN No appenders could be found for logger (org.apache.http.client.protocol.RequestAddCookies).
	log4j:WARN Please initialize the log4j system properly.
	Test User 090815054743
	Test User 09081505474355
	fail....Resume Title is same as profile summary title
	PASSED: editSummary*/



	
	
}

}

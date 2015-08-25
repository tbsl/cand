package candidateSideAutomation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class stepOneReg extends candidateBaseFunctions{
	
	
	
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

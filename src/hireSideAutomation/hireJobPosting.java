package hireSideAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class hireJobPosting extends hireBaseFunctions{
	
	 	  
	
	@org.testng.annotations.BeforeClass
	public void setup() throws IOException
	{
		
		hireBaseFunctions.startup();
		
		//driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		/*try {
			EmployerLogin("charu_stage1", "tbsl123456","http://qchire.timesjobs.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	@Test (priority =1)
	public void JobPost() throws Exception
	   {
		    
		    String jobtitle=x.getCellData("Emp_Sanity", "designation", 2);
		    String keyskill=x.getCellData("Emp_Sanity", "keySkills", 2);
		    String MinExp=x.getCellData("Emp_Sanity", "minExp", 2);
		    String MaxExp=x.getCellData("Emp_Sanity", "maxExp", 2);
		    String loc1=x.getCellData("Emp_Sanity", "joblocation_id1", 2);
		    String loc2=x.getCellData("Emp_Sanity", "joblocation_id2", 2);
		    String loc3=x.getCellData("Emp_Sanity", "joblocation_id3", 2);
		    String HiringOffice=x.getCellData("Emp_Sanity", "hiringOff_id", 2);  
		    String MinSalary=x.getCellData("Emp_Sanity", "minSalary", 2); 
		    String MinSalaryThousand=x.getCellData("Emp_Sanity", "minSalaryThousand", 2); 
		    String MaxSalary=x.getCellData("Emp_Sanity", "maxSalary", 2); 
		    String MaxSalaryThousand=x.getCellData("Emp_Sanity", "maxSalaryThousand", 2); 
		    String Perks=x.getCellData("Emp_Sanity", "perks", 2);
		    String Vacencies=x.getCellData("Emp_Sanity", "noOfVacancies", 2);
		    String Industry=x.getCellData("Emp_Sanity", "idIndustry", 2);
		    String functionalArea=x.getCellData("Emp_Sanity", "idfuncArea", 2);
		    String AOS=x.getCellData("Emp_Sanity", "idareaOfSpec", 2);
		    String JobDescription=x.getCellData("Emp_Sanity", "JobDesc", 2);
		    String PostGraduation=x.getCellData("Emp_Sanity", "PostGraduation", 2);
		    String UsageReportUser=x.getCellData("Emp_Sanity","UsageReportUser",2);
		    String UsageReportType=x.getCellData("Emp_Sanity","UsageReportType",2);
		    int jobsPostedbefore;
		    
		  //Before Posting Job Check the Usage Report to Verify After Post
		    driver.findElement(By.cssSelector("#maintab_accSettings > a > b")).click();
		    //Thread.sleep(2000);
		    
		    driver.findElement(By.xpath("//a[@href='/employer/usageReport.html']")).click();
		    //Thread.sleep(4000);
		    driver.findElement(By.id("user")).sendKeys(UsageReportUser);
		    //Thread.sleep(2000);
			driver.findElement(By.id("reportType")).sendKeys(UsageReportType);
		    driver.findElement(By.xpath("//input[@class='btn'and @type='button']")).click();
		    
		    Thread.sleep(4000);
		    
		    driver.findElement(By.xpath("//input[@id='quickTimePeriod' and @value='currMonth']")).click();
			driver.findElement(By.id("button1")).click();
			
			if (driver.getCurrentUrl().contains("usageReport.html"))
			{
				String DateRange=driver.findElement(By.cssSelector("td")).getText();
				System.out.println(DateRange);
				assertTrue(isElementPresent(By.xpath("//tr[5]/td[3]")));
				String PostCount=driver.findElement(By.xpath("//tr[5]/td[3]")).getText();
				System.out.println("Already Posted:- "+PostCount);
				if (PostCount.equalsIgnoreCase("No Records"))
				{
					PostCount="0";
				}
				jobsPostedbefore=Integer.parseInt(PostCount);
				System.out.println("Before:- "+jobsPostedbefore);
			}
			else
			{
				System.out.println("Usage Report Page is not displayed");
			}
			driver.findElement(By.cssSelector("#maintab_postJobs > a > b")).click();
			//Thread.sleep(2000);
			driver.findElement(By.linkText("Post a WizJob")).click();
			//Thread.sleep(3000);
			driver.findElement(By.id("token-input-designation")).clear();
			driver.findElement(By.id("token-input-designation")).sendKeys(jobtitle);
			WebElement desg=driver.findElement(By.id("token-input-designation"));
			Actions ajaxM=new Actions(driver);
			ajaxM.moveToElement(desg).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[3]/ul/li[2]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("token-input-keySkills")).click();
			driver.findElement(By.id("token-input-keySkills")).clear();
			driver.findElement(By.id("token-input-keySkills")).sendKeys(keyskill);
			
			WebElement desg1=driver.findElement(By.id("token-input-keySkills"));
			Actions ajaxM1=new Actions(driver);
			ajaxM1.moveToElement(desg1).build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[2]/ul/li[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("minExp")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("minExp")).sendKeys(MinExp);
			Thread.sleep(1000);
			driver.findElement(By.id("maxExp")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("maxExp")).sendKeys(MaxExp);
			Thread.sleep(1000);
			driver.findElement((By.id("textLocation"))).click();
			
			driver.findElement(By.xpath("//input[@id='joblocation_id' and @title='"+loc1+"']")).click();
			driver.findElement(By.xpath("//input[@id='joblocation_id' and @title='"+loc2+"']")).click();
			driver.findElement(By.xpath("//input[@id='joblocation_id' and @title='"+loc3+"']")).click();
			
			Thread.sleep(1000);			
			driver.findElement(By.linkText("Close")).click();
			
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div/form/div/div[8]/div[2]/div[3]/div[3]/span[3]/a")).click();
			driver.findElement(By.id("textHiringLocation")).click();
			driver.findElement(By.xpath("//input[@id='hiringOff_id' and @title='"+HiringOffice+"']")).click();
			driver.findElement(By.id("minSalary")).click();
			driver.findElement(By.id("minSalary")).sendKeys(MinSalary);
			
			driver.findElement(By.id("minSalaryThousand")).click();
			driver.findElement(By.id("minSalaryThousand")).sendKeys(MinSalaryThousand);
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='maxSalary']")).sendKeys(MaxSalary);
			Thread.sleep(1000);
			driver.findElement(By.id("maxSalaryThousand")).sendKeys(MaxSalaryThousand);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div/form/div/div[8]/div[2]/div[7]/a/span")).click();
			
			driver.findElement(By.id("perks")).clear();
			driver.findElement(By.id("perks")).sendKeys(Perks);
			driver.findElement(By.id("noOfVacancies")).clear();
			driver.findElement(By.id("noOfVacancies")).sendKeys(Vacencies);
			
			
			driver.findElement(By.cssSelector("#idIndustry > option[value=\""+Industry+"\"]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("#idfuncArea > option[value=\""+functionalArea+"\"]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.cssSelector("#idareaOfSpec > option[value=\""+AOS+"\"]")).click();
		    
		    
		    WebElement ckeditor_frame = driver.findElement(By.className("cke_wysiwyg_frame"));
		    driver.switchTo().frame(ckeditor_frame);
		
		    ((JavascriptExecutor)driver).executeScript("document.body.innerHTML = '" + JobDescription + "'");
		
		    driver.switchTo().defaultContent();
			
		    driver.findElement(By.id("rdoCourse2")).click();
			driver.findElement(By.id("rdoCourse1")).sendKeys(PostGraduation);
			
			 Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div/form/div/div[8]/div[9]/div[1]/div[1]/a/span")).click();
			
			driver.findElement(By.id("rd_2")).click();
			driver.findElement(By.name("sameHiring")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div/form/div/div[8]/div[9]/div[3]/div/div[1]/a/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("r2")).click();
			driver.findElement(By.id("exp")).click();
			driver.findElement(By.id("func")).click();
			driver.findElement(By.id("expReq")).click();
			driver.findElement(By.id("preview")).click();
			Thread.sleep(3000);
			
			try
			{
				assertTrue(driver.getCurrentUrl().contains("http://qchire.timesjobs.com/employer/preview_job.html"));
				System.out.println("Job Preview page is displayed");		       					
			}
			catch(Exception e)
			{
				System.out.println("Job Preview page not displayed");
			}        	
			
			driver.findElement(By.name("Post")).click();
			System.out.println("Job Posted Successfully");
			
			Thread.sleep(3000);
			
			if(driver.getPageSource().contains("has been Posted Successfully"))
			  {
				driver.findElement(By.xpath("//a[@href='job_post_stage1.html']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//select[@id='jobTempData']//option[2]")).click();
				assertTrue(driver.getCurrentUrl().contains("job_post_stage1.html?jobTempId="));
				String urlGet=driver.getCurrentUrl();
				int ss=urlGet.indexOf("=");
				System.out.println(ss);
				int lenURL=urlGet.length();
				System.out.println("URL Length:- "+lenURL);
				String jobID=urlGet.substring(ss+1);
				System.out.println("JOB ID:- "+jobID);
				x.setCellData("Emp_Sanity", "JOB_ID", 2, jobID);
				
			  }
			else
			  {
				System.out.println("Job Posted page not displayed");
				
			  }
			}
	
	@Test(priority =0)
	public void EditJob() throws Exception
	{
		driver.findElement(By.cssSelector("#maintab_postJobs > a > b")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Manage WizJobs")).click();
		//driver.findElement(By.xpath("//input[@class='mrgn_L5' and @name='jobId']")).sendKeys(x.getCellData("Emp_Sanity", "JOB_ID", 2));
		driver.findElement(By.xpath("//input[@class='mrgn_L5' and @name='jobId']")).sendKeys("50124439");
		driver.findElement(By.xpath("//input[@type='submit' and @Value='Go']")).click();
		driver.findElement(By.linkText("Edit Job")).click();
		driver.findElement(By.id("token-input-keySkills")).click();
		driver.findElement(By.id("token-input-keySkills")).clear();
		driver.findElement(By.id("token-input-keySkills")).sendKeys(x.getCellData("Emp_Sanity", "editKeySkills", 2));
		WebElement desg1=driver.findElement(By.id("token-input-keySkills"));
		Actions ajaxM1=new Actions(driver);
		ajaxM1.moveToElement(desg1).build().perform();
		Thread.sleep(1000);
		
		
		
	}
	
	private boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}

	@AfterClass
	public void teardon()
	{
		driver.quit();
	}

}

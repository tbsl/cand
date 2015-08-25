package candidateSideAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSearchLoggedinuser extends candidateBaseFunctions{	

		
	@BeforeClass	
	public void setup() throws IOException
	{
		startup();
	}
		
		/////////////Search with Skill,Location & Experience from Home Page/////////////////
		
		@Test(priority=1)
		public void SearchWithAllHome() throws InterruptedException
		{
		int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
		int i=0;
		for (int j=2;j<=count;j++)
		{	
			driver.get(p.getProperty("url"));
			
			//Login into the application
			driver.findElement(By.id("txtUseName")).sendKeys("sauravghosh@live.com");
			driver.findElement(By.id("j_password")).sendKeys("password");
			driver.findElement(By.id("submitbutton")).click();
			//Login into the application
			
			driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
			driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
			driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
			
			driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
			Thread.sleep(5000);
			String Pass = "Passed";
			String Fail = "Failed";
			if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					System.out.println("Result is "+val);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Home Page)", j, val);
					
					Assert.assertEquals(actual, expected);
				}
			else if (driver.getPageSource().contains(p.getProperty("d_jobtext")))
				{
					//x.setCellData("Deep_SearchSkillLoc&Exp", "Result", j, val);
					String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
					System.out.println("Result is "+val);
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Home Page)", j, "0 Job Found");
					
					Assert.assertEquals(actual, expected);
				}
			else{
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Home Page)", j, Fail);
					String actual = "Job Found";
					String expected = " Jobs Found";
					Assert.assertEquals(actual, expected);
				}
		}
	}
		
			
		
		/////////////Search with Skill,Location & Experience from Job_search Page/////////////////
		
		@Test(priority=2)
		public void SearchWithAllJobSearchpage() throws InterruptedException
		{
		int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
		int i=0;
		for (int j=2;j<=count;j++)
		{	
			driver.get("http://www.timesjobs.com/candidate/job-search.html");
			
			driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
			driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
			driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
			
			driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
			Thread.sleep(5000);
			String Pass = "Passed";
			String Fail = "Failed";
			if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					System.out.println("Result is "+val);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, val);
					
					Assert.assertEquals(actual, expected);
				}
			else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
					System.out.println("Result is "+val);
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, "0 Job Found");
					
					Assert.assertEquals(actual, expected);
				}
			else
				{
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Fail);
					String actual = "Job Found";
					String expected = " Jobs Found";
					Assert.assertEquals(actual, expected);
				}
		}
		
	}
		
		
		/////////////Search with Skill,Location & Experience from SEO Page/////////////////
		@Test(priority=3)
		public void SearchWithAllSEOpages() throws InterruptedException
		{
		int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
		int i=0;
		for (int j=2;j<=count;j++)
		{	
			driver.get("http://www.timesjobs.com/jobfunction/it-software-jobs");
			
			driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
			driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
			driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
			
			driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
			Thread.sleep(5000);
			String Pass = "Passed";
			String Fail = "Failed";
			if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					System.out.println("Result is "+val);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, val);
					
					Assert.assertEquals(actual, expected);
				}
			else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
					System.out.println("Result is "+val);
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, "0 Job Found");
					
					Assert.assertEquals(actual, expected);
				}
			else
				{
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Fail);
					String actual = "Job Found";
					String expected = " Jobs Found";
					Assert.assertEquals(actual, expected);
				}
		}
		
	}
		
		
		
	/////////////Search with Skill,Location & Experience from SRP Page/////////////////
				
			@Test(priority=4)
			public void SearchWithAllSRPpage() throws InterruptedException
			{
			int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
			int i=0;
			for (int j=2;j<=count;j++)
			{	
			driver.findElement(By.xpath(p.getProperty("d_skill"))).clear();
			driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
			driver.findElement(By.xpath(p.getProperty("d_location"))).clear();
			driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
			
			
			driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
			Thread.sleep(5000);
			String Pass = "Passed";
			String Fail = "Failed";
			if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					System.out.println("Result is "+val);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, val);
					
					Assert.assertEquals(actual, expected);
				}
			else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
					System.out.println("Result is "+val);
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, "0 Job Found");
					
					Assert.assertEquals(actual, expected);
				}
			else
				{
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Fail);
					String actual = "Job Found";
					String expected = " Jobs Found";
					Assert.assertEquals(actual, expected);
				}
			}
			
		}
		
		/////////////Search with Skill,Location & Experience from SRP Page/////////////////
				
			@Test(priority=5)
			public void SearchWithAllJDpage() throws InterruptedException
			{
			int count = x.getRowCount("Deep_SearchSkillLoc&Exp");
			int i=0;
			for (int j=2;j<=count;j++)
			{	
			driver.get("http://www.timesjobs.com/candidate/JobDetailView.html?adId=H__PLUS__unoPkW7BFzpSvf__PLUS__uAgZw==&bc=EXT&searchName=inner&from=submit&target=p2n&txtKeywords=java");
			
			driver.findElement(By.xpath(p.getProperty("d_skill"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i, j));
			driver.findElement(By.xpath(p.getProperty("d_location"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+1, j));
			driver.findElement(By.xpath(p.getProperty("d_experience"))).sendKeys(x.getCellData("Deep_SearchSkillLoc&Exp", i+2, j));
			
			driver.findElement(By.xpath(p.getProperty("d_searchbutton"))).click();
			Thread.sleep(5000);
			String Pass = "Passed";
			String Fail = "Failed";
			if(driver.getPageSource().contains(p.getProperty("d_jobstext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobsfound"))).getText();
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					System.out.println("Result is "+val);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, val);
					
					Assert.assertEquals(actual, expected);
				}
			else if(driver.getPageSource().contains(p.getProperty("d_jobtext")))
				{
					String val=driver.findElement(By.xpath(p.getProperty("d_jobfound"))).getText();
					System.out.println("Result is "+val);
					String actual= val.replaceAll("[^a-z A-Z]", "");
					String expected = " Jobs Found";
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Pass);
					x.setCellData("Deep_SearchSkillLoc&Exp", "Result (Register page)", j, "0 Job Found");
					
					Assert.assertEquals(actual, expected);
				}
			else
				{
					x.setCellData("Deep_SearchSkillLoc&Exp", "Test Case Status (Register page)", j, Fail);
					String actual = "Job Found";
					String expected = " Jobs Found";
					Assert.assertEquals(actual, expected);
				}
			}
			
			}
		
		@AfterClass
		public void teardown()
		{
			driver.quit();
		}



}



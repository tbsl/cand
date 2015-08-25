package candidateSideAutomation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class jobalert {

	public WebDriver driver;
	public String email,mobile,countrycode,yearexperience,monthexperience,location,role,funcArea;
	public ArrayList<String> ar, prefloc;
	
	@BeforeTest()
	
	public void setup() throws InterruptedException
	
	{
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("http://candstaging.timesjobs.com/candidate/login.html");
		
		//Login into the application
		
		driver.findElement(By.id("txtUseName")).sendKeys("roomtesting@mailinator.com");
		driver.findElement(By.id("j_password")).sendKeys("123456");
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(5000);	
		
		driver.findElement(By.cssSelector("li.editProfileTop > a")).click();
		Thread.sleep(5000);
		
		// Getting email id 
		driver.findElement(By.cssSelector("span.update-edit > a")).click();
		email=driver.findElement(By.id("newemail")).getAttribute("value");
		System.out.println("actual  email  "+email);
		
		
		// Getting mobile number 
		driver.findElement(By.cssSelector("#mobile > a")).click();
		mobile=driver.findElement(By.id("telOther")).getAttribute("value");
		System.out.println("actual mobile  "+mobile);
		
		
		// Getting country code
		countrycode=driver.findElement(By.id("mobileCode")).getAttribute("value");
		System.out.println("actual country code  "+countrycode);
		
		//Getting current location
		driver.findElement(By.id("locationWidget")).click();
		Select locationlist = new Select(driver.findElement(By.id("curLocation")));
		location=locationlist.getFirstSelectedOption().getText();
		
		
		//Getting Preferred location
		int z=driver.findElements(By.xpath("//ul[@id='prefLocTarget']/li")).size();
		System.out.println("Number of prefered locatios in edit profile page   "+z);
		
		System.out.println("Selected preffered location  "+driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li")).getText());
		
		prefloc=new ArrayList<String>();
		prefloc.add(driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li")).getText());
		
		for(int j=2;j<=z;j++)
		{
			System.out.println("Selected preffered location  "+driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li["+j+"]")).getText());
			prefloc.add(driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li["+j+"]")).getText());
		}
		
		System.out.println("Size of prefloc array in edit profile page   "+prefloc.size());
		
		
		//Getting experience year
		driver.findElement(By.id("employmentWidgetUpdate")).click();
		yearexperience=driver.findElement(By.id("cboWorkExpYear")).getAttribute("value");
		System.out.println("actual year experience  "+yearexperience);
		
		//Getting experience month
		monthexperience=driver.findElement(By.id("cboWorkExpMonth")).getAttribute("value");
		System.out.println("actual month experience  "+monthexperience);
		
		//Getting Specialization
		driver.findElement(By.id("jobCategoryIndustryWidget")).click();
		Select archiveList = new Select(driver.findElement(By.id("areaOfSpec")));
		List<WebElement> selectedValue = archiveList.getAllSelectedOptions();
		System.out.println("selected Value   "+selectedValue.size());
				
		ar = new ArrayList<String>();
		
		for(int i=0;i<selectedValue.size();i++)
		{
			System.out.println(selectedValue.get(i).getText());
			ar.add(selectedValue.get(i).getText());
		}
		
		
		//Getting Current Role
		Select rolList = new Select(driver.findElement(By.id("roleSel")));
		role=rolList.getFirstSelectedOption().getText();
		System.out.println("Selected role   "+role);
		
		//Getting Functional area
		funcArea=driver.findElement(By.xpath("//*[@id='emp_eud']/ul/li[2]/button")).getText();
		System.out.println("selected FA   "+funcArea);
		
		
		driver.findElement(By.cssSelector("div.white-bx > ul > li > a")).click();
	
		
		
	}
	
	
	
	
	
	//Below code checks the preferred location in update job alert page if same with update profile page
	
	@Test
	public void prefferedLocationtest() throws InterruptedException
	{
		
		
		int k=driver.findElements(By.xpath("//ul[@id='prefLocTarget']/li")).size();
		System.out.println("Number of prefered locatios in update job aler   "+k);
		
		System.out.println("Selected preffered location  "+driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li")).getText());
		ArrayList<String> updatePrferedLoc = new ArrayList<String>();
		updatePrferedLoc.add(driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li")).getText());
		
		for(int l=2;l<=k;l++)
		{
			System.out.println("Selected preffered location in update job aler "+driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li["+l+"]")).getText());
			updatePrferedLoc.add(driver.findElement(By.xpath("//ul[@id='prefLocTarget']/li["+l+"]")).getText());
		}
		
		System.out.println("Size of prefloc array in update job aler "+updatePrferedLoc.size());
		
		Assert.assertEquals(updatePrferedLoc, prefloc);
		
	}
	
	
	//Below code checks the Functional area in update job alert page if same with update profile page
	
	@Test
	public void funcAreatest() throws InterruptedException
	{
		
		String updateFA=driver.findElement(By.xpath("(//button[@type='button'])[3]")).getText();
		System.out.println("Selected role in update job alert page  "+updateFA);
		Assert.assertEquals(updateFA, funcArea);
	}
	
	
	
	//Below code checks the Current Role in update job alert page if same with update profile page
	
	@Test
	public void roletest() throws InterruptedException
	{
		Select rolelist = new Select(driver.findElement(By.id("roleSel")));
		String upjobrole=rolelist.getFirstSelectedOption().getText();
		System.out.println("Selected role in update job alert page  "+upjobrole);
		Assert.assertEquals(role, upjobrole);
	}

	
	
	//Below code checks the Current location in update job alert page if same with update profile page
	
	@Test
	public void locationtest() throws InterruptedException
	{
		Select locationlist = new Select(driver.findElement(By.id("resumeLocation")));
		String upjoblocation=locationlist.getFirstSelectedOption().getText();
		Assert.assertEquals(upjoblocation, location);
	}
	
	
	
	
	//Below code checks the communication Email in update job alert page if same with update profile page
	
	@Test
	public void emailtest() throws InterruptedException
	{
		String emailid= driver.findElement(By.id("resumeEmail")).getAttribute("value");
		System.out.println("emailid   "+emailid);
		Assert.assertEquals(emailid, email);
	}
	
	
	
	//Below code checks the mobile number in update job alert page if same with update profile page
	
	@Test
	public void mobiletest() throws InterruptedException
	{
		String emailid= driver.findElement(By.id("resumeMobile")).getAttribute("value");
		System.out.println("emailid   "+emailid);
		Assert.assertEquals(emailid, mobile);
	}
	
	
	
	//Below code checks the country code in update job alert page if same with update profile page
	
	@Test
	public void countryCodeTest() throws InterruptedException
	{
		String emailid= driver.findElement(By.id("mobileCode")).getAttribute("value");
		System.out.println("emailid   "+emailid);
		Assert.assertEquals(emailid, countrycode);
	}
	
	
	
	//Below code checks the year in update job alert page if same with update profile page
	
	@Test
	public void yearTest() throws InterruptedException
	{
		Select archiveList = new Select(driver.findElement(By.id("resumeWorkExpYear")));
		String selectedValue = archiveList.getFirstSelectedOption().getText();
		System.out.println("selected year   "+selectedValue);
		Assert.assertEquals(yearexperience, selectedValue);
		
		
	}
	
	
	
	//Below code checks the experience in month in update job alert page if same with update profile page
	
	@Test
	public void monthTest() throws InterruptedException
	{
		Select archiveList = new Select(driver.findElement(By.id("resumeWorkExpMonth")));
		String selectedValue = archiveList.getFirstSelectedOption().getText();
		System.out.println("selected month   "+selectedValue);
		Assert.assertEquals(monthexperience, selectedValue);	
		
	}
	
		
	
	//Below code checks the Specialization in update job alert page if same with update profile page
	
	@Test()
	public void specializationTest() throws InterruptedException
	{
		Select updatejob = new Select(driver.findElement(By.id("areaOfSpec")));
		List<WebElement> selected = updatejob.getAllSelectedOptions();
		System.out.println("Number of specialization in job alert page "+selected.size());
		
		ArrayList<String> ar1 = new ArrayList<String>();
				
		for(int j=0;j<selected.size();j++)
		{
			System.out.println(selected.get(j).getText());
			ar1.add(selected.get(j).getText());
		}
		
		System.out.println("ar1   "+ar1.size());
		Assert.assertEquals(ar, ar1);
		
		
	}
}


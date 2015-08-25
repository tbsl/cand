package candidateSideAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitypackage.Xls_Reader;

public class candidateBaseFunctions {
	

	
	
	public static WebDriver  driver=null;
	public static WebDriver  driver1=null;
	public static Properties  p=null;
	public static Properties  c=null;
	public static Xls_Reader  x,y=null;
	public String usermailId=null;
	
	public static void startup() throws IOException
	{
		FileInputStream  Orfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		p=new Properties();
		p.load(Orfile);
		
		FileInputStream  configfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\CONFIG.properties");
		c=new Properties();
		c.load(configfile);
		
	//	x =new Xls_Reader(System.getProperty("user.dir")+"\\excel\\CandSearch.xls");;
		
		System.out.println(c.getProperty("browserName"));
		if(c.getProperty("browserName").equals("Mozilla"))
		{
			driver = new FirefoxDriver();
		}
		else if(c.getProperty("browserName").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
	
	public void login(){
		
		//Login into the application
		driver.findElement(By.id(p.getProperty("l_username"))).sendKeys(usermailId);
		driver.findElement(By.id(p.getProperty("l_password"))).sendKeys(c.getProperty("Candidate_pwd"));
		driver.findElement(By.id("submitbutton")).click();

}
	
	public void emailAddress() throws InterruptedException{
		
		// Generating email id
		driver.findElement(By.id("emailAdd")).clear();
		Thread.sleep(1000);
		String emailAdd;
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMyyhhmmss");
		String getDate = formatter1.format(currentDate1.getTime());
		emailAdd = "sanity" + getDate + "@mailinator.com";
		System.out.println(emailAdd);
	}
}
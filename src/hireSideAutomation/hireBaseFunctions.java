package hireSideAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitypackage.Xls_Reader;

public class hireBaseFunctions {

	public static WebDriver  driver=null;
	public static Properties  p=null;
	public static Properties  c=null;
	public static Xls_Reader  x=null;
	//public static Xls_Reader  y=null;
	
	public static void startup() throws IOException
	{
		FileInputStream  Orfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		p=new Properties();
		p.load(Orfile);
		
		FileInputStream  configfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\CONFIG.properties");
		c=new Properties();
		c.load(configfile);
		
		//x =new Xls_Reader("D:\\workspace_automatiom\\TimesAutomationProject\\excelEmployer_DataFile.xls");
		//y =new Xls_Reader("D:\\workspace_automatiom\\TimesAutomationProject\\Candidate_DataFile.xls");
		
		System.out.println(c.getProperty("browserName"));
		if(c.getProperty("browserName").equals("Mozilla"))
		{
			driver=new FirefoxDriver();
		}
		else if(c.getProperty("browserName").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	public void EmployerLogin(String EmpLoginID, String EmpPassword,String driverURL) throws Exception
	{
		
		driver.get(driverURL);
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(EmpLoginID);
		driver.findElement(By.id("j_password")).sendKeys(EmpPassword);
		driver.findElement(By.id("button")).click();
		//Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("http://qchire.timesjobs.com/employer/dashboard.html"))
		{
			System.out.println("Employer Logged in successfully");
			//Thread.sleep(4000);
		}
		
	}
	
	


}

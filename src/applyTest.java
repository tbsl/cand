import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class applyTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://candstaging.timesjobs.com/candidate/JobDetailView.html?adId=UkpsvkEOwdFzpSvf__PLUS__uAgZw==&bc=INT&searchName=inner&from=submit&txtKeywords=0DQT0Java0DQT0");
		driver.findElement(By.xpath("html/body/div[2]/header/nav[2]/ul[3]/li[1]/a")).click();
		
		   driver.switchTo().frame("GB_frame1");
	        driver.switchTo().frame("GB_frame");
	        Thread.sleep(1000);
	        driver.findElement(By.id("j_username")).sendKeys("bidyut.tbsl@gmail.com");
	        driver.findElement(By.id("j_password")).sendKeys("password");
	        driver.findElement(By.xpath("//*[@id='loginForm']/ul/li[4]/input")).click();
		
		//driver.findElement(By.cssSelector("input[value='Apply']")).click();
		
		//driver.findElement(By.linkText("Apply")).click();
		//a[contains(@href, 'javascript:void(0);')])[2]
		driver.findElement(By.xpath("//div[@class='wrap jd-page clearfix']/section/div/section/div/a[1]")).click();

	}

}

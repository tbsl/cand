package candidateSideAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplyJobNew {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		
		
		
		
		WebDriver driver=new FirefoxDriver();
		
		String baseUrl="http://candstaging.timesjobs.com";
		
		driver.get(baseUrl);
		driver.findElement(By.id("txtKeywords")).sendKeys("p1");
		driver.findElement(By.xpath("//*[@id='quickSearchBean']/button")).click();
		
		
	}

}

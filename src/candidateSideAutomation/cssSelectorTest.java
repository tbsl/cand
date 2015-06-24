package candidateSideAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cssSelectorTest {

	public static void main(String[] args) {
		
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://timesjobs.com");
		driver.findElement(By.cssSelector("div.wrap section.guest-landing section.lhs section.top-ind div.tj-tab-container div.landin-cate div.white-bx div.popu-cate ul.grey-bdr-ul li a.button")).click();
		
	}

}

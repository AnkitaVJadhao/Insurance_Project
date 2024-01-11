package coverFoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base
{
	static protected WebDriver driver;
	//open browser
	//Non static :- we are calling this method in test class
	//we want to access directly 
	public void launchCoverFox() throws InterruptedException
	{
		Reporter.log("Opening Browser",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1000);
	}
	
	public void closeCoverFox() throws InterruptedException
	{
		Reporter.log("Closing Browser", true);
		Thread.sleep(1000);
		driver.close();
	}
	
	

}

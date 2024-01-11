package coverFoxUsingTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage 
{

	@FindBy(xpath = "//div[text()='Female']")private WebElement checkbox;
	
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncheckbox()
	{
		Reporter.log("clicking on gender button ", true);
		checkbox.click();
	}
	
	
}

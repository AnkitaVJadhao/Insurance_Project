package coverFoxUsingTestNg;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanResultsPage
{

	@FindBy(xpath="//div[contains(text(),'matching Health')]")private WebElement result;
	@FindBy(id="plans-list")private List<WebElement> search_results;
	@FindBy(xpath ="(//div[@class='fc-filter-val'])[3]") private WebElement Preferred_Brands;
	@FindBy(xpath = "(//div[@class='acb-relative']//i)[13]") private WebElement  Aditya_Birla;
	@FindBy(className = "apply-btn") private WebElement apply_button;
	@FindBy(xpath = "//img[@alt='Star Health Insurance']") private List<WebElement>  Birla_Banner;
	public CoverFoxHealthPlanResultsPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(10000);
		PageFactory.initElements(driver, this);
	}
	public int search_result()
	{
		 Reporter.log("Fetching number of results from text ", true);
		String r1 = result.getText();
		String a[]=r1.split(" ");
		
		String numberOfResultsInString = a[0];
		int numberOfResultsInInt = Integer.parseInt(numberOfResultsInString);
		System.out.println(numberOfResultsInInt);
		return numberOfResultsInInt;
	}	
	public int availablePlanNumberFromBanners()	
	{
		Reporter.log("Fetching number of results from Banners ", true);
		int totalNumberofPlan=search_results.size();
		return totalNumberofPlan;
	}
	public void clickOnPreferred_Brands()
	{
		Preferred_Brands.click();
	}
	public void clickOnAdityaBirla()
	{
		Aditya_Birla.click();
	}
	public void clicONApplyButton()
	{
		apply_button.click();
	}
	public int filterSearchResult()
	{
		String r1 = result.getText();
		String a[]=r1.split(" ");
		
		String numberOfResultsInString = a[0];
		int numberOfResultsInInt = Integer.parseInt(numberOfResultsInString);
		System.out.println(numberOfResultsInInt);
		return numberOfResultsInInt;
	}
	public int validatebirlaPlans()
	{
		
		return Birla_Banner.size();		
		
	}
	
	
	
	
	
	
	
//		if(size1==numberOfResultsInInt)
//		{
//			System.out.println("Plans number matching with plans List,TC is passed");
//		}
//		else
//		{
//			System.out.println("Plans number is not matching with plans List, TC is failed");
//		}
	
}
	
	
	


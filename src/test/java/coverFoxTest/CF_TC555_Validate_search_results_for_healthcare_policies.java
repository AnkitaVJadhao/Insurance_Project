package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxUsingTestNg.CoverFoxAddressDetailsPage;
import coverFoxUsingTestNg.CoverFoxHealthPlanPage;
import coverFoxUsingTestNg.CoverFoxHealthPlanResultsPage;
import coverFoxUsingTestNg.CoverFoxHomePage;
import coverFoxUsingTestNg.CoverFoxMemberDetailsPage;
import coverFoxUtility.Utility;

public class CF_TC555_Validate_search_results_for_healthcare_policies extends Base
{   
	public static Logger logger;
	
	CoverFoxHomePage home;
	CoverFoxMemberDetailsPage memberDetails;
	CoverFoxAddressDetailsPage addressDetails;
	CoverFoxHealthPlanPage healthPlan;
	CoverFoxHealthPlanResultsPage results;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
	      logger=logger.getLogger("CoverFox_Insurance");
	      PropertyConfigurator.configure("log4j.properties");
		  logger.info("launching Browser");
		  launchCoverFox();
		  home=new CoverFoxHomePage(driver);
		  memberDetails=new CoverFoxMemberDetailsPage(driver);
		  addressDetails=new CoverFoxAddressDetailsPage(driver);
		  healthPlan=new CoverFoxHealthPlanPage(driver);
		  results=new CoverFoxHealthPlanResultsPage(driver);
	}
	@BeforeMethod
	 public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException
	  {
		  
		  logger.info("Clicking on gender button");
		  home.clickoncheckbox();
		  Thread.sleep(5000);
		  
		  
		  logger.info("Clicking on Next button");
		  healthPlan.click_on_Nextbutton();
		  Thread.sleep(2000);
		  
		  
		  logger.info("Handeling age drop down");
		  memberDetails.select_age(Utility.readDataFromExcel(0, 0));
		 
		  logger.info("Clicking on next button after adding age");
		  memberDetails.next_after_selecting_age();
		  Thread.sleep(2000);
		  
		  
		  logger.info("Enter mobile pincode");
		  addressDetails.enter_pincode(Utility.readDataFromExcel(0, 1));
		  
		  logger.info("Enter mobile number");
		  addressDetails.enter_mobile(Utility.readDataFromExcel(0, 2));
		  
		  logger.info("Clicking on continue button after adding all address details");
		  addressDetails.click_continueButton();
		  
		  Thread.sleep(2000); 
	  }
	@Test
	public void validateTestPlansFromTextAndBanners() throws InterruptedException
	  {
		  Thread.sleep(5000);
		 
		  logger.info("Fetching number of results from text");
		  int textResult = results.search_result();
		  Thread.sleep(7000);
		  
		  
		  int bannerResult=results.availablePlanNumberFromBanners();
		  Thread.sleep(1000);
		  Assert.assertEquals(textResult, bannerResult,"Both are not equal ,Test case is failed");
		  Reporter.log("TC is passed ", true);
		  logger.info("TC is passed");
		  Reporter.log("Click on Apply");
		  
		  results.clickOnPreferred_Brands();
		  results.clickOnAdityaBirla();
		  results.clicONApplyButton();
		  
		  Thread.sleep(3000);
		  int expectedplans = results.filterSearchResult();
		  int actualResult = results.validatebirlaPlans();
		  Assert.assertEquals(expectedplans, actualResult,"Plans not matching");
		  Reporter.log(expectedplans+ "and" +actualResult,true);
	  }
	 @AfterMethod
	  public void closeBrowser() throws InterruptedException
	  {
		  
		  closeCoverFox();
		  
	  }
}
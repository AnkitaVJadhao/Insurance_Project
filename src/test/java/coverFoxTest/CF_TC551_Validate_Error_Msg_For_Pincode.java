package coverFoxTest;

import java.io.IOException;
import java.net.SocketException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxUsingTestNg.CoverFoxAddressDetailsPage;
import coverFoxUsingTestNg.CoverFoxHealthPlanPage;
import coverFoxUsingTestNg.CoverFoxHomePage;
import coverFoxUsingTestNg.CoverFoxMemberDetailsPage;
import coverFoxUtility.Utility;

@Listeners(coverFoxListener.CoverFoxListener.class)
public class CF_TC551_Validate_Error_Msg_For_Pincode extends Base 
{
	public static Logger logger;
	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlan;
	CoverFoxMemberDetailsPage memberDetails;
	CoverFoxAddressDetailsPage adressDetails;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		logger=logger.getLogger("CoverFox_Insurance");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("launching Browser");
		launchCoverFox();
		home = new CoverFoxHomePage(driver);
		healthPlan = new CoverFoxHealthPlanPage(driver);
		memberDetails = new CoverFoxMemberDetailsPage(driver);
		adressDetails = new CoverFoxAddressDetailsPage(driver);
		Thread.sleep(2000);
	}

	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("Clicking on gender", true);
		logger.info("Clicking on gender");
		home.clickoncheckbox();
		Thread.sleep(2000);

		Reporter.log("Clicking on next Button", true);
		logger.info("Clicking on next Button");
		healthPlan.click_on_Nextbutton();
		Thread.sleep(2000);

		Reporter.log("Select Age", true);
		logger.info("Select Age");
		memberDetails.select_age(Utility.readDataFromExcel(1, 0));
		logger.info("Clicking on next button after adding age");
		memberDetails.next_after_selecting_age();
		Thread.sleep(2000);

	}

	@Test
	public void checkErrorMsgIsDisplayed() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("check error message is Showing or not", true);
		
		adressDetails.enter_pincode("");
		logger.info("enter mobile");
		adressDetails.enter_mobile(Utility.readDataFromExcel(1, 2));
		adressDetails.click_continueButton();
		Thread.sleep(2000);
		logger.info("Check error message is display or not");
		Assert.assertTrue(adressDetails.errorMsg());
		Reporter.log("TC is Pass", true);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException, SocketException {
		Thread.sleep(7000);
		logger.info("Closing browser");
		closeCoverFox();
	}
}

package coverFoxUsingTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage 
{
	//variable
		@FindBy(xpath = "//input[@placeholder='6 Digit Pincode']")private WebElement pincode;
		@FindBy(xpath = "//input[@placeholder='Your mobile number']") private WebElement mobile_number;
		@FindBy(className = "next-btn")private WebElement continue_button;
		@FindBy(xpath =  "//div[@class='error-ui']") private WebElement pincodeErrorMsg;
		//constructor
		public CoverFoxAddressDetailsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public void enter_pincode(String pincode1)
		{
			Reporter.log("Entering pin code ",true);
			pincode.sendKeys(pincode1);
		}
		public void enter_mobile(String mobilenumber)
		{
			Reporter.log("Entering mobile num ",true);
			mobile_number.sendKeys(mobilenumber);
		}
		public void click_continueButton()
		{
			Reporter.log("Clicking on continue button ", true);
			continue_button.click();
		}
		public boolean errorMsg()
		{
			Reporter.log("Error msg is displaying");
			boolean errormsgdisplay = pincodeErrorMsg.isDisplayed();
			return errormsgdisplay;
		}
		public String getErrorMsg()
		{
			return pincodeErrorMsg.getText();
		}
		
		
}

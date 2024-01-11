package coverFoxListener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;
import coverFoxUtility.Utility;

public class CoverFoxListener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String TCName = result.getName();
		Reporter.log("TC " + TCName + " execution is started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TCName = result.getName();
		Reporter.log("TC " + TCName + " is completed successfully", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TCName = result.getName();
		Reporter.log("TC " + TCName + " is skipped, please check dependent method", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

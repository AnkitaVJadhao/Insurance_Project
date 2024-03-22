package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{
	
	
	public static void takeScreenshot(WebDriver driver, String TCID) throws IOException
	{
		Reporter.log("Taking screenshot", true);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Ankita\\Desktop\\Velocity\\Selenium\\Screenshots\\coverFox"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved screenshot at "+dest,true);
		FileHandler.copy(src, dest);
		
	}
	
	public static String readDataFromExcel(int i,int j) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Ankita\\Downloads\\Book1.xlsx");
		String data = WorkbookFactory.create(file).getSheet("Sheet4").getRow(i).getCell(j).getStringCellValue();
		return data;
	}
	
	public static String readDataFromProperty(String key) throws IOException
	{
		//Create object of properties
		Properties prop=new Properties();
		
		//Create Object of FileInputStream
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\testData.properties");
		prop.load(myFile);
		String values = prop.getProperty(key);
		return values;
	}
	
	
}


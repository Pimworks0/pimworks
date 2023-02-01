package baselibrary;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ReusableLibrary;

public class TestBase extends PimBase{

	// Static global variable to handle the instance of webdriver
	public static WebDriver driver = null;
	static String propertyFilePath = "./config.properties";
	static BufferedReader reader;
	static Properties properties = new Properties();
	Logger logger;



	public static Properties getProperties() {
		return properties;
	}



	public static int RandomNumber() {
		Random robj = new Random();
		int rNo = robj.nextInt(100000);
		return rNo;
	}

	/*
	 * public void passTest(){ logger = extent.startTest("passTest");
	 * Assert.assertTrue(true); logger.log(LogStatus.PASS,
	 * "Test Case Passed is passTest"); }
	 * 
	 * 
	 * public void failTest(){ logger = extent.startTest("failTest");
	 * logger.log(LogStatus.FAIL, "Test Case (failTest) Status is passed"); }
	 * 
	 * public void skipTest(){ logger = extent.startTest("skipTest"); }
	 */

	public String getFormattedDate(int days) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);

		String strcalendardate = formatter.format(c.getTime()).concat("Z");
		System.out.println(strcalendardate);

		return strcalendardate;
	}
	public static Properties getLocator() throws IOException {
		ReusableLibrary reuse= new ReusableLibrary();
		FileReader reader=new FileReader("src/test/java/test_data/locator.properties");
	//	reuse.propertyloder("src/test/java/test_data/locator.properties");
		Properties p=new Properties();
		p.load(reader);
		return  p;
	}
	public  static  void scrolltoexactelement(WebElement element){


	}
	public static void enterText(WebElement webelement, String text) {
		try {
			webelement.sendKeys(text);
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Element is not visible to enter text"+e.getMessage());

		}

	}
     public static String readExcel (String name, int row, int column, String Path)throws Exception {
		FileInputStream fs = new FileInputStream(Path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(name);
		return String.valueOf(sheet.getRow(row).getCell(column));
	}
	public static void clickOnElement( WebElement element) {
		try {
			element.click();
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Element is not visible to click"+e.getMessage());

		}

	}

	public String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Date dt = new Date();
		String strcurrentdate = formatter.format(dt).concat("Z");
		System.out.println(strcurrentdate);

		return strcurrentdate;
	}


	public static class ListenersImplementation implements ITestListener {

		static ExtentReports report;
			   ExtentTest test;

		public void onTestStart(ITestResult result) {
			//before each test case
			test = report.createTest(result.getMethod().getMethodName());
			ExtentFactory.getInstance().setExtent(test);
		}

		public void onTestSuccess(ITestResult result) {
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
			ExtentFactory.getInstance().removeExtentObject();
		}

		public void onTestFailure(ITestResult result) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

			//add screenshot for failed test.
			File src = null;
			try {
				src = ((TakesScreenshot)TestBase.getWebDriver()).getScreenshotAs(OutputType.FILE);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
			Date date = new Date();
			String actualDate = format.format(date);

			String screenshotPath = System.getProperty("user.dir")+
					"/Reports/Screenshots/"+actualDate+".jpeg";
			File dest = new File(screenshotPath);

			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
			ExtentFactory.getInstance().removeExtentObject();

		}

		public void onTestSkipped(ITestResult result) {
			ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
			ExtentFactory.getInstance().removeExtentObject();
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

		public void onTestFailedWithTimeout(ITestResult result) {
		}

		public void onStart(ITestContext context) {
			try {
				 report = ExtentReportNG.setupExtentReport();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void onFinish(ITestContext context) {
			//close extent
			report.flush();
		}

	}
}

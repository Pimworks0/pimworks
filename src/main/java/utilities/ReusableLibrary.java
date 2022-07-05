package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baselibrary.Logger;
import org.openqa.selenium.interactions.Actions;

public class ReusableLibrary  extends TestBase {

	static WebDriver driver;
	static String propertyFilePath = "./config.properties";
	static BufferedReader reader;
	public static Properties properties = new Properties();
	public static Logger logger = new Logger();

	public ReusableLibrary(WebDriver driver) throws IOException {
		this.driver = driver;
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties.load(reader);
	}

	public static void enterText(WebElement webelement, String text) {
		try {
			webelement.sendKeys(text);
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Element is not visible to enter text"+e.getMessage());

		}

	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}

	public static void clickWebelement(WebElement element) {
		try {
			element.click();
		}

		catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}
	}

	public static void mouseOverTOElement(WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
		}

		catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}
	}


	public static void typevalue(WebElement element) {
		try {

		}

		catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}
	}



}

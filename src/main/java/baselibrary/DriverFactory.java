package baselibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	WebDriver driver = null;

	public WebDriver GetBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			options.addArguments("-allow-running-insecure-content");

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("edge")) {

//		    File file = new File("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();


		} else if (browser.equalsIgnoreCase("firefox")) {


//			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
//			System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}
}

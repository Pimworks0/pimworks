package baselibrary;

import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static baselibrary.TestBase.readExcel;

public class PimBase {
    // Static global variable to handle the instance of webdriver
    public static WebDriver driver = null;
    static String propertyFilePath = "./config.properties";
    static BufferedReader reader;
    static Properties properties = new Properties();
    Logger logger;

    static String Datapath = "src//test//java//test_data//TestData.xlsx";

    public static WebDriver getWebDriver() throws Exception {
        reader = new BufferedReader(new FileReader(propertyFilePath));
        properties.load(reader);

        String browser = readdata1(2,1);
        if (driver == null) {
            DriverFactory df = new DriverFactory();
            driver = df.GetBrowser(browser);
        }

        launchApp();
        return driver;
    }
    public static String readdata1(int row, int cell) throws Exception {
        return  readExcel("Config",row,cell,Datapath);
    }

    public static void launchApp() throws Exception {
        driver.get((readdata1(1,1)));
    }
}

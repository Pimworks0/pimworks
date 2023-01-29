package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class Bulk_Upload_Attribute extends TestBase {
    String Datapath = "src//test//java//test_data//TestData.xlsx";

    private WebDriver driver;
    private static String c_pump_mr;

    public String readdata(int row, int cell) throws Exception {
        return readExcel("Bulk_Upload_Attribute", row, cell, Datapath);
    }

    public static void uploadFile(String key) throws AWTException, InterruptedException {
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection(key);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        Thread.sleep(7000);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(7000);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    @Test(priority = 1)
    public void createAttributeGroup() throws Exception {
        this.driver = TestBase.getWebDriver();
        ExtentFactory.getInstance().getExtent().pass("This test case will create a attribute group and give the Attribute type");
        // --------Login as admin
        System.out.println(readdata(1,1));
        System.out.println(readdata(2,1));
        new LoginPage(driver).login(readdata(1,1), readdata(2,1));
        Thread.sleep(4000);
        AccountManagement user = new AccountManagement(driver);
        // --------------move to the side menu ---------------
        user.moveTosidemenu();
        System.out.println(getLocator().getProperty("Settings"));
        driver.findElement(By.xpath(getLocator().getProperty("Settings"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Settings from side menu ");

        Thread.sleep(8000);
        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroups"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Attribute Groups from side menu ");
        Thread.sleep(2000);

        driver.findElement(By.xpath(getLocator().getProperty("CreateGroup"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create Group");
        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroupName"))).sendKeys(readdata(3,1));
        driver.findElement(By.xpath(getLocator().getProperty("Attributeorder"))).sendKeys(readdata(4,1));
        ExtentFactory.getInstance().getExtent().pass(" User Enter Attribute group Name and Display order than click save button");
        driver.findElement(By.xpath(getLocator().getProperty("SaveAtrribute"))).click();
        ExtentFactory.getInstance().getExtent().pass(" Created Attribute Group displayed on the screen ");
        Thread.sleep(7000);
        driver.findElement(By.xpath(getLocator().getProperty("closeAttributealert"))).click();
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    public void BulkAttributeCreation() throws Exception {
        driver.findElement(By.xpath(getLocator().getProperty("AttributeNoClick"))).click();
        ExtentFactory.getInstance().getExtent().pass("User click Created group No of Attributes hyperlink");
        Thread.sleep(5000);
         driver.findElement(By.xpath("//div[@class='qq-uploader-selector qq-uploader single-uploader']")).click();

        c_pump_mr = new File(".//src//test//java//test_data//Bulk upload Attributes.xlsx").getCanonicalPath();
        System.out.println(c_pump_mr);
        uploadFile(c_pump_mr);

//       WebElement upload_file = driver.findElement(By.xpath(getLocator().getProperty("clicktoUploadFiles")));
//       upload_file.sendKeys(".//src//test//java//test_data//Bulk upload Attributes.xlsx");
        Thread.sleep(7000);
        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("Bulk created attributes have been saved");
    }

}
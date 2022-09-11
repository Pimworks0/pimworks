package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class uploadfile

     extends TestBase {

        LoginPage Loginobj;
        String loginUserName = null;
        String loginPassword = null;
        private WebDriver driver;
        Logger logger = new Logger();

        @BeforeClass
        public void StartTest() throws Exception {
            setExcel();
            this.driver = TestBase.getWebDriver();

            loginUserName = getProperties().getProperty("LoginUserName");
            loginPassword = getProperties().getProperty("LoginPassword");

            Loginobj = new LoginPage(driver);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        }


        public void setExcel() throws Exception {

            writeExcel("Attributes", "main screen\n", 0, 0);
            writeExcel("Attributes", "cpu\n", 0, 1);
            writeExcel("Attributes", "loadtime\n", 0, 2);
            writeExcel("Attributes", "spec\n", 0, 3);
            writeExcel("Attributes", "size\n", 0, 4);


            writeExcel("Attributes", "laptop", 1, 0);
            writeExcel("Attributes", "laptop", 1, 1);
            writeExcel("Attributes", "laptop", 1, 2);
            writeExcel("Attributes", "laptop", 1, 3);
            writeExcel("Attributes", "laptop", 1, 4);


        }

    public void writeExcel(String sheetName, String cellvalue, int rowvalue, int col) throws IOException {

        String excelPath="./src/Testdata/UploadAttributesTemplate.xlsx";

        File file= new File(excelPath);

        FileInputStream fis= new FileInputStream(file);

//        XSSFWorkbook wb= new XSSFWorkbook(fis);
//        XSSFSheet sheet= wb.getSheet(sheetName);
//        sheet.getRow(rowvalue).createCell(col).setCellValue(cellvalue);
//
//        FileOutputStream fos= new FileOutputStream(file);
//        wb.write(fos);

    }
        @Test(priority = 1)
        public void validate_Attribute_group_page() throws Exception {
            ExtentFactory.getInstance().getExtent().info("User Started verifying Attribute group page");
            this.driver = TestBase.getWebDriver();
            //  Setting_Attribute settings= new Setting_Attribute();

            AccountManagement user = new AccountManagement(driver);
            // --------Login as admin
            new LoginPage(driver).login("envautotesting@gmail.com", getProperties().getProperty("LoginPassword"));

            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ProductCreation"))));
            //   UserManagementPage userManagement= new UserManagementPage(driver);
            user.moveTosidemenu();
            WebElement ele = driver.findElement(By.xpath("(//a[@class='mm-next'])[6]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            Thread.sleep(2000);
            ele.click();
            driver.findElement(By.xpath("//span[normalize-space()='Attribute Groups']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[normalize-space()='9']")).click();
            Thread.sleep(2000);
            WebElement upload= driver.findElement(By.xpath("//input[@title='Click here to select files']"));
            upload.sendKeys("C://Pimpomproject//com.pimwork//src//Testdata//UploadAttributesTemplate.xlsx");
            Thread.sleep(12000);
        }
}

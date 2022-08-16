package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;
import pageLibrary.UserManagementPage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductEdit extends TestBase {

    LoginPage Loginobj;
    String loginUserName = null;
    String loginPassword = null;
    private WebDriver driver;
    Logger logger = new Logger();

    @BeforeClass
    public void StartTest() throws IOException, InterruptedException {
        this.driver = TestBase.getWebDriver();
        loginUserName = getProperties().getProperty("LoginUserName");
        loginPassword = getProperties().getProperty("LoginPassword");
        Loginobj = new LoginPage(driver);


    }
    @Test(priority = 1)
    public void EditProduct() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying Healthcheck Subscription");
        this.driver = TestBase.getWebDriver();
        //  Setting_Attribute settings= new Setting_Attribute();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login("envautotesting@gmail.com", getProperties().getProperty("LoginPassword"));
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("searchProducts"))));








        driver.findElement(By.id("searchProducts")).sendKeys("Lenovo");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa fa-search searchDataProducts']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Lenovo']")).click();
        Thread.sleep(5000);

        Select objSelect =new Select(driver.findElement(By.id("ddlMarketplacePIMProducts")));
        objSelect.selectByVisibleText("Shopify");
        Thread.sleep(10000);
        WebElement textbox1=  driver.findElement(By.xpath("//*[@id='attrib_169186']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox1);
        textbox1.sendKeys("17");

        Thread.sleep(7000);
        driver.findElement(By.id("toptoSave")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnSendToAPI")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(15000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.get("https://accounts.shopify.com/");
        driver.findElement(By.linkText("Your store")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("account_email")).sendKeys("envautotest@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='body-content']/div[2]/div/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(" //input[@name='password']")).sendKeys("Mobius@123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(10000);









    }
}

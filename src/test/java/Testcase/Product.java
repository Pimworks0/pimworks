package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.io.IOException;

public class Product extends TestBase {

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
    public void create_product() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying the product creation");
        this.driver = TestBase.getWebDriver();
        //  Setting_Attribute settings= new Setting_Attribute();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login("envautotesting@gmail.com", getProperties().getProperty("LoginPassword"));
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ProductCreation"))));
        //   UserManagementPage userManagement= new UserManagementPage(driver);
        Thread.sleep(7000);
        // user.moveTosidemenu();
        WebElement element  =driver.findElement(By.xpath(" //*[@class='site-menu-icon fa fa-dashboard']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Product button on side menu");
        driver.findElement(By.xpath("//input[@id='ProductCreation']")).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create product");
        driver.findElement(By.xpath(" //input[@id='producttxtbox']")).sendKeys("Lap04");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='productNametxtbox']")).sendKeys("Lenovo");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath("//span[@class='k-widget k-dropdown k-header form-control']//span[@class='k-icon k-i-arrow-s'][normalize-space()='select']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[normalize-space()='Laptop']")).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user choose laptop from the Taxonomy dropdown");
        driver.findElement(By.xpath("//input[@id='saveProductId']")).click();
        Thread.sleep(10000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on save button to Create product");
       // driver.findElement(By.xpath("//span[@role='presentation']")).click();
     //      Thread.sleep(2000);
//      driver.findElement(By.xpath("//input[@role='listbox']")).sendKeys("Draft");
        Thread.sleep(2000);
        WebElement textbox1=  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div[15]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox1);
        textbox1.sendKeys("17");
        Thread.sleep(2000);
        driver.findElement(By.id("toptoSave")).click();
        ExtentFactory.getInstance().getExtent().pass("user save the product after adding Display ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
        Thread.sleep(2000);

    }

    @AfterClass
    public void logout() throws Exception {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@class='circular-border']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout")).click();
        Thread.sleep(2000);
    }
}

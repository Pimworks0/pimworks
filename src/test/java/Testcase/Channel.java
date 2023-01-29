package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;
import pageLibrary.UserManagementPage;

import java.io.IOException;
import java.time.Duration;

public class Channel extends TestBase {

    LoginPage Loginobj;
    String loginUserName = null;
    String loginPassword = null;
    private WebDriver driver;
    Logger logger = new Logger();

    @BeforeClass
    public void StartTest() throws Exception {
        this.driver = TestBase.getWebDriver();
        loginUserName = getProperties().getProperty("LoginUserName");
        loginPassword = getProperties().getProperty("LoginPassword");
        Loginobj = new LoginPage(driver);


    }



    @Test(priority = 1)
    public void Healthcheck_Subscription() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying Healthcheck Subscription");
        this.driver = TestBase.getWebDriver();
        //  Setting_Attribute settings= new Setting_Attribute();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login("envautotesting@gmail.com", getProperties().getProperty("LoginPassword"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ProductCreation"))));
        UserManagementPage userManagement= new UserManagementPage(driver);
        user.moveTosidemenu();
        driver.findElement(By.xpath(" (//a[@class='mm-next'])[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Healthcheck subscriptions']")).click();
        ExtentFactory.getInstance().getExtent().pass("user click on Health check subscriptions from side menu");
        Thread.sleep(10000);
        WebElement ele2 = driver.findElement(By.id("chkbox_10"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        Thread.sleep(4000);
        ele2.click();
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
        ExtentFactory.getInstance().getExtent().pass("user check and uncheck the Channel");
        Thread.sleep(4000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        ele2.click();
        Thread.sleep(2000);

        WebElement spotify = driver.findElement(By.xpath("//img[@title='Shopify']"));
        Actions act = new Actions(driver);
        act.moveToElement(spotify).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='channel-full-content AddCredentialInputBtn']")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Close")).click();
        Thread.sleep(7000);
        act.sendKeys(Keys.PAGE_DOWN);
        act.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath(" //input[@id='saveButton']")).click();
        Thread.sleep(25000);
        WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='site-menu-icon fa fa-dashboard']"))));
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass(" user should choose channel and click channel Checkbox and save button");

    }

    @Test(priority = 2)
    public void Taxonomy_Node_mapping() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying Taxonomy Node mapping");
        AccountManagement user = new AccountManagement(driver);
        user.moveTosidemenu();
        Thread.sleep(3000);
        WebElement ele1= driver.findElement(By.xpath("(//a[@class='mm-next'])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele1);
        ele1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Taxonomy Node Mapping']")).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("user click on Taxonomy Node Mapping");

        driver.findElement(By.xpath("//input[@value='View']")).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user click on view");
        WebElement ele2 = driver.findElement(By.xpath("//td[normalize-space()='Laptop']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//span[@class='k-icon k-filter'])[3]")).click();
        Thread.sleep(2000);

        Thread.sleep(3000);
        driver.findElement(By.xpath(" //div[@class='k-animation-container']//input[1]")).sendKeys("Laptop");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/form/div[1]/div[2]/button[1]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
        ExtentFactory.getInstance().getExtent().pass("user check mark MOBILE PHONES");


        driver.findElement(By.xpath(" //th[@data-field='MappProjectIDs']//i[@class='fa fa-users']")).click();
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("user click on Bulk Edit");

        driver.findElement(By.xpath("//*[@id=\"AttribAdvFilterWindow\"]/span/span/span/span[2]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='k-animation-container']//li[@role='option'][normalize-space()='Shopify updated CSG']")).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("user click on Apply and get Attribute Mapping");


        ExtentFactory.getInstance().getExtent().pass("user click on Apply and get Attribute Mapping");
        driver.findElement(By.xpath("//button[@id='btnFilterAttribute']")).click();
        Thread.sleep(3000);

        WebElement attribute=  driver.findElement(By.linkText("Attributes"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", attribute);
        Thread.sleep(3000);
        attribute.click();
        Thread.sleep(7000);
        driver.findElement(By.id("ddl0_1")).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("user click on Attribute ");


        driver.findElement(By.xpath("//div[@id='ddl0_1-list']//input[@role='listbox']")).sendKeys("product name");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@id='ddl0_1_option_selected']")).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("user Search for product name and save the details ");
        driver.findElement(By.xpath("//input[@id='savefunctionMapp']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("(//span[@role='presentation'][normalize-space()='Close'])[2]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@class='circular-border']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


    }

}

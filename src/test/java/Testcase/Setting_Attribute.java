package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
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
import java.util.concurrent.TimeUnit;

public class Setting_Attribute extends TestBase {

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
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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
        ExtentFactory.getInstance().getExtent().pass("user clicked on Attribute Groups from side menu ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='CreateGrp'])[1]")).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on +Create Group");

        driver.findElement(By.xpath("//input[@id='attributeGrptextbox']")).sendKeys("Laptop");
        driver.findElement(By.xpath("//input[@id='attrGroupOrder']")).sendKeys("1");
        driver.findElement(By.xpath(" //input[@id='saveProductId']")).click();
        ExtentFactory.getInstance().getExtent().pass(" Create Attribute Group displayed on the screen ");
        ExtentFactory.getInstance().getExtent().pass(" User Enter Attribute group Name and Display order than click save button");

        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[@role='presentation']")).click();
        ExtentFactory.getInstance().getExtent().pass("User click Created group No of Attributes hyperlink");


    }
    @Test(priority = 2)
    public void validate_Attribute_Page() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying Attribute page");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user can See the Empty grid");
        driver.findElement(By.xpath("//span[@class='k-icon k-filter']")).click();
         Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='k-textbox']")).sendKeys("Laptop");
         Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Filter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='0']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='pimcreateattributeid']")).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( "user able to click  Create Attribute");
        driver.findElement(By.xpath("//input[@id='AddAttributeName']")).sendKeys("Display");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( " display Add New Attribute popup and user entered the Attribute name");

        Select dropdown = new Select(driver.findElement(By.id("ddlAttributeGrp")));
        dropdown.selectByVisibleText("Laptop");

        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");


        driver.findElement(By.xpath("//input[@id='PIM_btnAttributeSubmit']")).click();
        ExtentFactory.getInstance().getExtent().pass( " user click on Save Button for Attribute page");

        //span[@role='presentation']
        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[@role='presentation']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@title='Save']")).click();


    }

    @Test(priority = 3)
    public void validate_Taxonomy_Page() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        ExtentFactory.getInstance().getExtent().info("User Started verifying Taxonomy page");
        Thread.sleep(2000);
        user.moveTosidemenu();
        WebElement ele = driver.findElement(By.xpath("(//a[@class='mm-next'])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        Thread.sleep(2000);
        ele.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Taxonomy']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnPIMProduct']")).click();

        ExtentFactory.getInstance().getExtent().pass("user click + Add New Taxonomy");
        Thread.sleep(2000);
        driver.findElement(By.id("createTaxonomyBreadcrumbValParent")).sendKeys("Laptop");
        Thread.sleep(2000);

        ExtentFactory.getInstance().getExtent().pass("Create Taxonomy  popup is Displayed");
        driver.findElement(By.xpath("//input[@value='Apply']")).click();
        Thread.sleep(7000);

        ExtentFactory.getInstance().getExtent().pass(" user enter Textbox and click save button");
        driver.findElement(By.xpath("//a[normalize-space()='Add by Group']")).click();

        Thread.sleep(2000);

        ExtentFactory.getInstance().getExtent().pass("user Navigate to Taxonomy Settings page");
        driver.findElement(By.xpath("//span[normalize-space()='Select group']")).click();
        Thread.sleep(2000);

        ExtentFactory.getInstance().getExtent().pass("  Default Attribute group displayed");
        ExtentFactory.getInstance().getExtent().pass("user choosed to either Add by group or Add by Attributes");
        driver.findElement(By.xpath("//input[@title='Laptop']")).click();
        Thread.sleep(2000);

        ExtentFactory.getInstance().getExtent().pass( "As a user choose Add by group should select group dropdown and choose to select Attribute group Checkbox\n");
        driver.findElement(By.xpath("//button[@id='btnFilterAttributeGrp']")).click();
        Thread.sleep(2000);


//
     //   driver.findElement(By.xpath("//a[normalize-space()='Laptop']")).click();



        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//button[@id='PrimarybtnFilter']")).click();
//        WebElement e =  driver.findElement(By.xpath("//button[@id='PrimarybtnFilter']"));
//        for (int i= 0; i<= 4;i++)
//        {
//            e.sendKeys(Keys.PAGE_UP);
//        }

        ExtentFactory.getInstance().getExtent().pass( "user click on Apply button");


        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@class='circular-border']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

}
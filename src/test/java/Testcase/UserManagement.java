package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;
import pageLibrary.UserManagementPage;

import java.io.IOException;

public class UserManagement extends TestBase {


    LoginPage Loginobj;
    String loginUserName = null;
    String loginPassword = null;
    private WebDriver driver;




    @BeforeClass
    public void StartTest() throws IOException, InterruptedException {
        this.driver = TestBase.getWebDriver();

        loginUserName = getProperties().getProperty("LoginUserName");
        loginPassword = getProperties().getProperty("LoginPassword");

        Loginobj = new LoginPage(driver);

    }

    @Test (priority = 1)
    public void linkUserManagement() throws Exception {


        this.driver = TestBase.getWebDriver();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login(getProperties().getProperty("LoginUserName"), getProperties().getProperty("LoginPassword"));

        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//i[@id='1'])[1]"))));
        // --------------move to the side menu ---------------
        Thread.sleep(4000);
        user.moveToUserManagement();
        user.clickOnUserManagement();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnOpenAddAccount"))));
     //   driver.findElement(By.xpath("//a[contains(text(),'User Management')]")).click();
        UserManagementPage usm= new UserManagementPage(driver);
        usm.clickUserManagement();
        Thread.sleep(2000);

      //  driver.findElement(By.xpath("//th[@data-field='EmployeeEmail']//span[@class='k-icon k-filter']")).click();
        usm.clickonfilter();
        Thread.sleep(2000);
        user.serchAccount("demo33@gmail.com");
        Thread.sleep(2000);
        user.clickOnFilter();
        Thread.sleep(5000);
        user.clickOnView();
        Thread.sleep(5000);
        WebElement ele1= driver.findElement(By.xpath("//div[@class='site-footer-legal']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele1);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-icon k-filter'])[8]")));
     //   driver.findElement(By.xpath("(//span[@class='k-icon k-filter'])[8]")).click();
        usm.clickonfilter2();

       // driver.findElement(By.xpath("  ")).sendKeys("demo32@gmail.com");
        usm.serchinSideUserManagement("demo32@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Filter'])[2]")).click();
        Thread.sleep(2000);

        String gettext  = driver.findElement(By.xpath(" (//input[@id='IsMapp'])[1]")).getAttribute("value");
        System.out.println(gettext);
        if (gettext.equals("true")){
            driver.findElement(By.id("IsMapp")).click();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            ExtentFactory.getInstance().getExtent().pass("the pop is accepted to disable the check in");

        }
        Thread.sleep(2000);
        driver.findElement(By.id("IsMapp")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        ExtentFactory.getInstance().getExtent().pass("the pop is accepted to disable the check in");
        logout();
        loginWithUserAndVerifyAccess();


    }


    public  void logout() throws Exception {
        AccountManagement user = new AccountManagement(driver);
// -------------Logout ----------------
        Thread.sleep(5000);
        user.clickProfileImage();
        Thread.sleep(5000);
        user.logout();



    }

    public  void loginWithUserAndVerifyAccess() throws Exception {
// Verify the given access
        Thread.sleep(3000);
        AccountManagement user = new AccountManagement(driver);
        new LoginPage(driver).login("demo32@gmail.com",getProperties().getProperty("LoginPassword"));
//        WebDriverWait wait = new WebDriverWait(driver, 100);
//        wait.until(ExpectedConditions.elementToBeClickable(user.getProfileImage()));
//        user.clickProfileImage();
//        String getText= driver.findElement(By.xpath("//label[@id='3622']")).getText();
//        System.out.println("Linked Secondery account is     "+ getText);
        ExtentFactory.getInstance().getExtent().pass("The linked user showed successfully");
        logout();

    }

}
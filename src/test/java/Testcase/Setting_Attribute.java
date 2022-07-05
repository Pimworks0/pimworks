package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.io.IOException;

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

    }

    @Test(priority = 1)
    public void givingAccess_SelectedModule_User() throws Exception {
        ExtentFactory.getInstance().getExtent().info("User Started verifying the module which was given accessed by admin");
        this.driver = TestBase.getWebDriver();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login(getProperties().getProperty("LoginUserName"), getProperties().getProperty("LoginPassword"));


        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//i[@id='1'])[1]"))));
//        // --------------move to the side menu ---------------
        user.moveToUserManagement();
        user.clickOnUserManagement();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tr[@role='row']"))));
        Thread.sleep(5000);
        user.clickFilterIcon();
//        // ----------------Type demo32@gmail.com  and select filter
        Thread.sleep(2000);
        logger.info("uyser ring to search demo35@gmail.com ");
        user.serchAccount("demo35@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[normalize-space()='demo35@gmail.com']")).click();
        user.clickOnFilter();
        Thread.sleep(5000);
    }

}

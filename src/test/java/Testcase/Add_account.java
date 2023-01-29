package Testcase;

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
import pageLibrary.Account_ResiterPage;
import pageLibrary.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class Add_account extends TestBase {

    String password= "Mobius@123";

    LoginPage Loginobj;
    String loginUserName = null;
    String loginPassword = null;
    private WebDriver driver;




    @BeforeClass
    public void StartTest() throws Exception {
        this.driver = TestBase.getWebDriver();
        loginUserName = getProperties().getProperty("LoginUserName");
        loginPassword = getProperties().getProperty("LoginPassword");
        Loginobj = new LoginPage(driver);

    }

    @Test(priority = 1)
    public void createAccount() throws Exception {


        this.driver = TestBase.getWebDriver();
        AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login(getProperties().getProperty("LoginUserName"), getProperties().getProperty("LoginPassword"));
        WebElement save = driver.findElement(By.xpath("(//h3[normalize-space()='Sentiment Analysis'])[1]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
        Thread.sleep(4000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//i[@id='1'])[1]"))));
        // --------------move to the side menu ---------------
        user.moveToUserManagement();
        user.clickOnUserManagement();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnOpenAddAccount"))));
        driver.findElement(By.id("btnOpenAddAccount")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("FirstName"))));
        // Need to change Lastname , Email, AccountUser
    //    driver.findElement(By.id("FirstName")).sendKeys("env");
        Account_ResiterPage resister= new Account_ResiterPage(driver);
        resister.enterFirstName("env");
        Thread.sleep(2000);
        resister.enterLastName("9");
        Thread.sleep(2000);
        resister.enterEmail("envtestauto15@gmail.com");
        Thread.sleep(2000);
        resister.enterPhoneNumber("0929292493");
        Thread.sleep(2000);
        resister.enterAccountUser("env12");
        Thread.sleep(2000);
        resister.enterCompanyName("XYZ");
        Thread.sleep(2000);
        resister.saveAccount();
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='alert-success']")));
       // String gettext=driver.findElement(By.xpath("//span[@class='alert-success']")).getText();
    //    System.out.println("The alert for Sudent creation is"+ gettext);

   }





}

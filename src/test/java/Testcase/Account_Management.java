package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.LongPressAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.LoginPage;
import pageLibrary.AccountManagement;

import java.io.IOException;

public class Account_Management extends TestBase {

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
      //  Setting_Attribute settings= new Setting_Attribute();

         AccountManagement user= new AccountManagement(driver);
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
        user.clickOnAccess();
        logger.info("User clicked on view access");
        Thread.sleep(5000);
        check_unchec_module();
        scrolltoTopofthePage();
        user.clickSave();
        logout();
        loginWithUserAndVerifyAccess();

    }

    public void scrolltoTopofthePage() throws InterruptedException {
        WebElement ele2 = driver.findElement(By.id("mGroupId_17"));
        try {
            for (int i= 0; i<= 10;i++)
            {
                ele2.sendKeys(Keys.PAGE_UP);
            }
            driver.findElement(By.xpath("//img[@alt='PIMworks']")).click();
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
            ExtentFactory.getInstance().getExtent().pass("Scrolled to top successful");
        }
       catch (Exception e)
       {
           ExtentFactory.getInstance().getExtent().fail("scrolling fail");
       }

    }

public void check_unchec_module() throws InterruptedException {
     try {

         WebElement ele1= driver.findElement(By.id("mGroupId_12"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele1);
         ele1.sendKeys(Keys.ARROW_UP);
         ele1.sendKeys(Keys.ARROW_UP);
         String firstOpt = ele1.getAttribute("checked");
             Thread.sleep(2000);
             driver.findElement(By.id("mId_32")).click();
             Thread.sleep(2000);
             driver.findElement(By.id("mId_32")).click();
             Thread.sleep(2000);
             driver.findElement(By.id("mId_47")).click();
             Thread.sleep(2000);
             driver.findElement(By.id("mId_47")).click();
             Thread.sleep(2000);
             ExtentFactory.getInstance().getExtent().pass("Account Settings sub modules are selected and unselected");

     }
     catch (Exception e)
     {
         ExtentFactory.getInstance().getExtent().fail("unable to check first module");
     }


         try {
            WebElement ele1= driver.findElement(By.id("mGroupId_13"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele1);
             ele1.sendKeys(Keys.ARROW_UP);
             ele1.sendKeys(Keys.ARROW_UP);
            String firstOpt = ele1.getAttribute("checked");
         if (firstOpt != null) {
             Thread.sleep(5000);
             ele1.click();
             ExtentFactory.getInstance().getExtent().pass("PIM was selected already , so unchecking this");
         }
            ele1.click();
            ExtentFactory.getInstance().getExtent().pass("Checked the PIM module");
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            ExtentFactory.getInstance().getExtent().fail("unable to check first module");
        }
        try
         {
        WebElement ele2 = driver.findElement(By.id("mGroupId_17"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        String secondOption = ele2.getAttribute("checked");
        Thread.sleep(2000);
        for (int i= 1; i<=2; i++) {
        driver.findElement(By.id("mId_8"+i+"")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mId_8"+i+"")).click();
        Thread.sleep(2000);

          }
             ExtentFactory.getInstance().getExtent().pass("Checked the sub-module inside the Vendor management");
    }
       catch (Exception e){
       ExtentFactory.getInstance().getExtent().fail("unable to check second module");
   }

}


    public  void logout() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        Thread.sleep(5000);
        user.clickProfileImage();
        Thread.sleep(5000);
        user.logout();



    }


    public  void loginWithUserAndVerifyAccess() throws Exception {
        // Verify the given access
        Thread.sleep(3000);
        AccountManagement user = new AccountManagement(driver);
        new LoginPage(driver).login("demo35@gmail.com", getProperties().getProperty("LoginPassword"));
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ProductCreation"))));
//        // --------------move to the side menu ---------------
        Thread.sleep(2000);
        user.moveTosidemenu();
        ExtentFactory.getInstance().getExtent().pass("user moved to side menu");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='site-menu-item has-sub VendorManagement']//a[@class='mm-next']")).click();
         ExtentFactory.getInstance().getExtent().pass("user clicked on vendor management");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Vendor Management')]")).click();
        ExtentFactory.getInstance().getExtent().pass("user verify the Vendor Management ");
        logout();
   }



   @Test (priority = 2)
    public void verify_Readonly_Functionality() throws Exception {
       ExtentFactory.getInstance().getExtent().info("This Test will verify the Read only functionality");
       AccountManagement user = new AccountManagement(driver);
        // --------Login as admin
        new LoginPage(driver).login(getProperties().getProperty("LoginUserName"), getProperties().getProperty("LoginPassword"));
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//i[@id='1'])[1]"))));
        // --------------move to the side menu ---------------
        user.moveToUserManagement();
        user.clickOnUserManagement();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tr[@role='row']"))));
        Thread.sleep(5000);
        user.clickFilterIcon();
        // ----------------Type demo32@gmail.com  and select filter
        Thread.sleep(2000);
        driver.findElement(By.xpath( "//input[@role='textbox']")).clear();
        ExtentFactory.getInstance().getExtent().pass("Text box cleared before entered the email");

        Thread.sleep(2000);
        user.serchAccount("demo32@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[normalize-space()='demo32@gmail.com']")).click();
        user.clickOnFilter();
        Thread.sleep(5000);
        user.clickOnAccess();
        Thread.sleep(5000);
        // check the 1st option
        String firstOption = user.getOption1().getAttribute("checked");
        if (firstOption != null) {
            user.checkoption1();
            new Actions(driver).clickAndHold(user.getOption1()).build().perform();
        }
        Thread.sleep(2000);
        //click on select all
        user.seletAllModule();
        // select unselect readonly
        Thread.sleep(2000);
        user.clickReadonly();
        //Save after giving the access
        Thread.sleep(2000);
        user.clickReadonly();
        Thread.sleep(2000);
        user.clickSave();
        Thread.sleep(5000);
        logout();
        loginWithReadOnlyUser();
    }


    public  void loginWithReadOnlyUser() throws Exception {
        Thread.sleep(3000);
        new LoginPage(driver).login("demo32@gmail.com",getProperties().getProperty("LoginPassword"));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("User can't click on Select New because it is disabled");

        logout();
    }

    }



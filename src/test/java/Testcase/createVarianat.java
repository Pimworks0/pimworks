package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
import java.util.concurrent.TimeUnit;

public class createVarianat extends TestBase {

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
           UserManagementPage userManagement= new UserManagementPage(driver);
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

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='attributeGrptextbox']")).sendKeys("Mobile");
        driver.findElement(By.xpath("//input[@id='attrGroupOrder']")).sendKeys("3");
        driver.findElement(By.xpath(" //input[@id='saveProductId']")).click();
        ExtentFactory.getInstance().getExtent().pass(" Create Attribute Group displayed on the screen ");

        ExtentFactory.getInstance().getExtent().pass(" User Enter Attribute group Name and Display order than click save button");
        Thread.sleep(5000);
        driver.findElement(By.linkText("Close")).click();
        Thread.sleep(5000);
        // Moving to Attribute
        user.moveTosidemenu();
        WebElement ele1 = driver.findElement(By.xpath("(//a[@class='mm-next'])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
        Thread.sleep(7000);
        ele1.click();
        driver.findElement(By.xpath("//span[normalize-space()='Attributes']")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("pimcreateattributeid")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("AddAttributeName")).sendKeys("OPTION1NAME");
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.id("ddlAttributeGrp")));
        dropdown.selectByVisibleText("Mobile");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");

        driver.findElement(By.id("PIM_btnAttributeSubmit")).click();
        ExtentFactory.getInstance().getExtent().pass( " user click on Save Button for Attribute page");
        driver.findElement(By.id("AddAttributeName")).clear();
        driver.findElement(By.id("AddAttributeName")).sendKeys("OPTION1VALUE");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");
        driver.findElement(By.id("PIM_btnAttributeSubmit")).click();
        ExtentFactory.getInstance().getExtent().pass( " user click on Save Button for Attribute page ");

        driver.findElement(By.id("AddAttributeName")).clear();
        driver.findElement(By.id("AddAttributeName")).sendKeys("OPTION2NAME");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");
        driver.findElement(By.id("PIM_btnAttributeSubmit")).click();

        driver.findElement(By.id("AddAttributeName")).clear();
        driver.findElement(By.id("AddAttributeName")).sendKeys("OPTION2VALUE");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");
        driver.findElement(By.id("PIM_btnAttributeSubmit")).click();








        ExtentFactory.getInstance().getExtent().pass( " user click on Save Button for Attribute");
        Thread.sleep(5000);
        driver.findElement(By.linkText("Close")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@title='Save']")).click();
        Thread.sleep(7000);
        user.moveTosidemenu();
        WebElement ele3 = driver.findElement(By.xpath("(//a[@class='mm-next'])[6]"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele3);
        Thread.sleep(2000);
        ele3.click();

// use moves to taxonomy
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Taxonomy']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnPIMProduct']")).click();

        ExtentFactory.getInstance().getExtent().pass("user click + Add New Taxonomy");
        Thread.sleep(2000);
        driver.findElement(By.id("createTaxonomyBreadcrumbValParent")).sendKeys("MOBILE PHONES");
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
        driver.findElement(By.xpath("//input[@placeholder='Search Attribute group']")).sendKeys("Mobile");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@title='Mobile']")).click();
        Thread.sleep(2000);

        ExtentFactory.getInstance().getExtent().pass( "As a user choose Add by group should select group dropdown and choose to select Attribute group Checkbox\n");
        driver.findElement(By.xpath("//button[@id='btnFilterAttributeGrp']")).click();
        Thread.sleep(5000);
////User moves to the product
        user.moveTosidemenu();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Product button on side menu");
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='ProductCreation']")).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create product");
        driver.findElement(By.xpath(" //input[@id='producttxtbox']")).sendKeys("Mobile23");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='productNametxtbox']")).sendKeys("Galaxy 02");
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath("//span[@class='k-widget k-dropdown k-header form-control']//span[@class='k-icon k-i-arrow-s'][normalize-space()='select']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@role='listbox']")).sendKeys("MOBILE PHONES");
        driver.findElement(By.xpath("//li[normalize-space()='MOBILE PHONES']")).click();
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
        textbox1.sendKeys("SPECIFICATION");
        Thread.sleep(2000);

        WebElement textbox2=  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div[15]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/div/div[2]/div[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox2);
        textbox2.sendKeys("32GB");
        Thread.sleep(2000);


        WebElement textbox3=  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div[15]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/div/div[3]/div[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox3);
        textbox3.sendKeys("COLOR");
        Thread.sleep(2000);

        WebElement textbox4=  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div[15]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[2]/div/div[4]/div[2]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox4);
        textbox4.sendKeys("Black");
        Thread.sleep(2000);
        driver.findElement(By.id("toptoSave")).click();
        ExtentFactory.getInstance().getExtent().pass("user save the product after adding Display ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
        Thread.sleep(10000);

//////===============================================================

        //Moving to node mapping

        user.moveTosidemenu();
        Thread.sleep(3000);
        WebElement ele4= driver.findElement(By.xpath("(//a[@class='mm-next'])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele4);
        ele4.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Taxonomy Node Mapping']")).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("user click on Taxonomy Node Mapping");

        driver.findElement(By.xpath("//input[@value='View']")).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user click on view");
        WebElement ele2 = driver.findElement(By.xpath("//td[normalize-space()='MOBILE PHONES']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
        Thread.sleep(7000);

        driver.findElement(By.xpath("(//span[@class='k-icon k-filter'])[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //div[@class='k-animation-container']//input[1]")).sendKeys("MOBILE PHONES");
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
        driver.findElement(By.xpath("//button[@id='btnFilterAttribute']")).click();
        Thread.sleep(5000);

        //clickin on atrribute

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
//SCROLLING STARTED
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        WebElement  Mobile = driver.findElement(By.id("ddl38_2"));
        js.executeScript("arguments[0].scrollIntoView();", Mobile);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ddl38_2\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ddl38_2-list\"]/span/input")).sendKeys("OPTION1NAME");
        Thread.sleep(3000);
        driver.findElement(By.id("ddl38_2_option_selected")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"ddl39_2\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ddl39_2-list\"]/span/input")).sendKeys("OPTION1VALUE");
        Thread.sleep(3000);
        driver.findElement(By.id("ddl39_2_option_selected")).click();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ddl40_2\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ddl40_2-list\"]/span/input")).sendKeys("OPTION2NAME");
        Thread.sleep(3000);
        driver.findElement(By.id("ddl40_2_option_selected")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@id=\"ddl41_2\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ddl41_2-list\"]/span/input")).sendKeys("OPTION2VALUE");
        Thread.sleep(3000);
        driver.findElement(By.id("ddl41_2_option_selected")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='savefunctionMapp']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Close")).click();
        driver.switchTo().alert().accept();
//==============================================================================
        //moving to product
        Thread.sleep(10000);
       // user.moveTosidemenu();
        WebElement element  =driver.findElement(By.xpath(" //*[@class='site-menu-icon fa fa-dashboard']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Product button on side menu");
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
        driver.findElement(By.id("searchProducts")).sendKeys("Mobile23");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa fa-search searchDataProducts']")).click();
        Thread.sleep(7000);
        driver.findElement(By.linkText("Mobile23")).click();
        Thread.sleep(5000);


     //   Create new variant
        driver.findElement(By.xpath(" //div[contains(@title,'Create new variant')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //input[@id='variantskuid']")).sendKeys("MOB33");
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //input[@id='variantproductname']")).sendKeys("Galaxy 02");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@type='checkbox'])[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='CreateVariantId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Close")).click();
        //Create Second variant
        driver.findElement(By.xpath(" //div[contains(@title,'Create new variant')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //input[@id='variantskuid']")).sendKeys("MOB34");
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //input[@id='variantproductname']")).sendKeys("Galaxy 03");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@type='checkbox'])[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='CreateVariantId']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Close")).click();
        Thread.sleep(10000);

        Select objSelect =new Select(driver.findElement(By.id("ddlMarketplacePIMProducts")));
        objSelect.selectByVisibleText("Shopify");
        Thread.sleep(10000);

        WebElement first=     driver.findElement(By.xpath("//*[contains(@attributedisplayname, 'Product Name')]"));
        WebElement second=     driver.findElement(By.xpath("//*[contains(@attributedisplayname, 'OPTION1NAME')]"));
        WebElement third=      driver.findElement(By.xpath("//*[contains(@attributedisplayname, 'OPTION1VALUE')]"));
        WebElement four=       driver.findElement(By.xpath("//*[contains(@attributedisplayname, 'OPTION2NAME')]"));
        WebElement five=       driver.findElement(By.xpath("//*[contains(@attributedisplayname, 'OPTION2VALUE')]"));
;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", first);
        first.clear();
        first.sendKeys("Galaxy 02");
        Thread.sleep(2000);

       //second
        second.clear();
        second.sendKeys("SPECIFICATION");
        Thread.sleep(1000);
        //third
        third.clear();
        third.sendKeys("32GB");
        Thread.sleep(1000);
       //four
        four.clear();
        four.sendKeys("Color");
       //five
        Thread.sleep(1000);
        five.clear();
        five.sendKeys("White");
        Thread.sleep(4000);
        driver.findElement(By.id("toptoSave")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();

        Thread.sleep(8000);


        driver.findElement(By.xpath("//a[normalize-space()='MOB34']")).click();
        Thread.sleep(10000);
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", first);
        Actions at1 = new Actions(driver);
        at1.sendKeys(Keys.PAGE_DOWN).build().perform();
//        at.sendKeys(Keys.PAGE_DOWN).build().perform();
//
        WebElement rrr= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[2]/input"));
        rrr.clear();
        rrr.sendKeys("Galaxy 04");
        Thread.sleep(2000);

        //second
        WebElement sss= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[3]/input"));
        sss.clear();
        sss.sendKeys("SPECIFICATION");
        Thread.sleep(1000);

        //third
        WebElement lll= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[4]/input"));

        lll.clear();
        lll.sendKeys("642GB");
        Thread.sleep(1000);
        //four
        WebElement color= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[5]/input"));

        color.clear();
        color.sendKeys("Color");
        //five
        WebElement white= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[6]/input"));

        Thread.sleep(1000);
        white.clear();
        white.sendKeys("Black");
        Thread.sleep(4000);
        driver.findElement(By.id("toptoSave")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();

        driver.findElement(By.xpath("//a[normalize-space()='MOB33']")).click();

        Thread.sleep(7000);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
//        at.sendKeys(Keys.PAGE_DOWN).build().perform();
//
        WebElement rrrr= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[2]/input"));

        rrrr.clear();
        rrrr.sendKeys("Galaxy 05");
        Thread.sleep(2000);

        //second
        WebElement ssss= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[3]/input"));

        ssss.clear();
        ssss.sendKeys("SPECIFICATION");
        Thread.sleep(1000);
        //third
        WebElement gb= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[4]/input"));

        gb.clear();
        gb.sendKeys("132GB");
        Thread.sleep(1000);

        //four
        WebElement color1= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[5]/input"));

        color1.clear();
        color1.sendKeys("Color");

        //five
        WebElement blue= driver.findElement(By.xpath("(//*[@class='col-lg-12 p-l-0 m-b-20 getattributeIdProd'])[6]/input"));

        Thread.sleep(1000);
        blue.clear();
        blue.sendKeys("Blue");
        Thread.sleep(4000);
        driver.findElement(By.id("toptoSave")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();



        driver.findElement(By.linkText("Mobile23 - Galaxy 02")).click();
        Thread.sleep(7000);
        driver.findElement(By.id("toptoSave")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnSendToAPI")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(15000);
        driver.navigate().refresh();


    }

}
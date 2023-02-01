package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class ProductDetails_verification extends TestBase {
    String Datapath= "src//test//java//test_data//TestData.xlsx";

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
    public String readdata(int row, int cell) throws Exception {
     return  readExcel("ProductDetails_verification",row,cell,Datapath);
    }
    public void createitems(String data) throws Exception {
        driver.findElement(By.xpath(getLocator().getProperty("attibutesNamae"))).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("attibutesNamae"))).sendKeys(data);
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("attrubuteSubmit"))).click();
        ExtentFactory.getInstance().getExtent().pass( data+ "item created");
        Thread.sleep(7000);
    }
    public void input_item(String item, String inputtype,String type) throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty(item))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("changeType"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty(inputtype))).click();
        ExtentFactory.getInstance().getExtent().pass( "Type changed to " +type+ " to iteam one");

    }

    @Test(priority = 1)
    public void createAttributes() throws Exception {
        this.driver = TestBase.getWebDriver();
        AccountManagement user = new AccountManagement(driver);
        ExtentFactory.getInstance().getExtent().pass("This test case will create a attribute group and give the Attribute type");
        // --------Login as admin
        System.out.println(readdata(1,1));
        System.out.println(readdata(2,1));
        new LoginPage(driver).login(readdata(1,1), readdata(2,1));
        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        // --------------move to the side menu ---------------
//        user.moveTosidemenu();
//        System.out.println(getLocator().getProperty("Settings"));
//        driver.findElement(By.xpath(getLocator().getProperty("Settings"))).click();
//        ExtentFactory.getInstance().getExtent().pass("user clicked on Settings from side menu ");
//
//        Thread.sleep(8000);
//        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroups"))).click();
//        ExtentFactory.getInstance().getExtent().pass("user clicked on Attribute Groups from side menu ");
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath(getLocator().getProperty("CreateGroup"))).click();
//        ExtentFactory.getInstance().getExtent().pass("user clicked on +Create Group");
//        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroupName"))).sendKeys(readdata(3,1));
//        driver.findElement(By.xpath(getLocator().getProperty("Attributeorder"))).sendKeys(readdata(4,1));
//        driver.findElement(By.xpath(getLocator().getProperty("SaveAtrribute"))).click();
//        ExtentFactory.getInstance().getExtent().pass(" Create Attribute Group displayed on the screen ");
//        ExtentFactory.getInstance().getExtent().pass(" User Enter Attribute group Name and Display order than click save button");
//        Thread.sleep(7000);
//        driver.findElement(By.xpath(getLocator().getProperty("closeAttributealert"))).click();
//        ExtentFactory.getInstance().getExtent().pass("User click Created group No of Attributes hyperlink");
//        Thread.sleep(4000);
//        driver.findElement(By.xpath(getLocator().getProperty("AttributenotoClick"))).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath(getLocator().getProperty("createatributes"))).click();
//        Thread.sleep(2000);
//        ExtentFactory.getInstance().getExtent().pass( "user able to click  Create Attribute");
//
//        driver.findElement(By.xpath(getLocator().getProperty("attibutesNamae"))).sendKeys(readdata(5,1));
//        Thread.sleep(2000);
//        ExtentFactory.getInstance().getExtent().pass( " display Add New Attribute popup and user entered the Attribute name");
//        Select dropdown = new Select(driver.findElement(By.id(getLocator().getProperty("atrributsDropdown"))));
//        dropdown.selectByVisibleText(readdata(3,1));
//        ExtentFactory.getInstance().getExtent().pass( " user select respected Attribute group from drop down");
//        driver.findElement(By.xpath(getLocator().getProperty("attrubuteSubmit"))).click();
//        ExtentFactory.getInstance().getExtent().pass( " user click on Save Button for Attribute page");
//        ExtentFactory.getInstance().getExtent().pass( readdata(5,1)+ "item created");
//
//        createitems(readdata(6,1));
//        createitems(readdata(7,1));
//        createitems(readdata(8,1));
//        createitems(readdata(9,1));
//        createitems(readdata(10,1));
//        createitems(readdata(11,1));
//        createitems(readdata(12,1));
//        createitems(readdata(13,1));
//
//
//        driver.findElement(By.xpath(getLocator().getProperty("closeAttributealert"))).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
//        Thread.sleep(7000);
//        ExtentFactory.getInstance().getExtent().pass( "All iteams are saved sucessfully");
//
//        input_item("item9","ninethoption", "Datetime");
//        input_item("item8","eighthoption", "Date");
//        input_item("item7","seventhoption", "Docs");
//        input_item("item6","sixthOption", "Tags");
//        input_item("item5","fifthoption", "Image");
//        input_item("item4","fourthoption", "RichText");
//        input_item("item3","thirdoption", "Numeric");
//        input_item("item2","secondOption", "Text+Numeric");
//        input_item("item1","firstoption", "Text");
//
//        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
//        Thread.sleep(7000);
//        ExtentFactory.getInstance().getExtent().pass( "Type changed are done successfully and saved");

    }


    @Test(priority = 2)
    public void addAtributestoTaxonomy() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        user.moveTosidemenu();

        driver.findElement(By.xpath(getLocator().getProperty("Settings"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Settings from side menu ");
        Thread.sleep(4000);
        driver.findElement(By.xpath(getLocator().getProperty("Taxonamoysidemu"))).click();
        Thread.sleep(4000);
     //   driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_New_Taxonomy"))).click();

       ExtentFactory.getInstance().getExtent().pass("user click + Add New Taxonomy");
        Thread.sleep(2000);
        driver.findElement(By.id(getLocator().getProperty("teonomybox"))).sendKeys(readdata(14,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("Create Taxonomy  popup is Displayed");
        driver.findElement(By.xpath(getLocator().getProperty("Apply"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass(" user enter Textbox and click save button");
        driver.findElement(By.xpath(getLocator().getProperty("Add_by_Attributes"))).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(getLocator().getProperty("dropdown_on_stting_txn"))).click();
        driver.findElement(By.cssSelector(getLocator().getProperty("selectall_tax"))).click();

        Thread.sleep(2000);
        driver.findElement(By.id(getLocator().getProperty("apply_seletall"))).click();


        user.moveTosidemenu();
        driver.findElement(By.xpath(getLocator().getProperty("productsidemenu"))).click();
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Product button on side menu");
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("createProduct"))).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create product");
        driver.findElement(By.xpath(getLocator().getProperty("SKUvalue"))).sendKeys(readdata(15,1));
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("ProductName"))).sendKeys(readdata(16,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath(getLocator().getProperty("node"))).click();
        Thread.sleep(4000);

       driver.findElement(By.xpath(getLocator().getProperty("boxtosearch"))).sendKeys(readdata(14,1));
       //need to change the locator

        driver.findElement(By.xpath(getLocator().getProperty("Searchiteam"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user choose item from the Taxonomy dropdown");
        driver.findElement(By.xpath(getLocator().getProperty("saveProduct"))).click();
        Thread.sleep(10000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on save button to Create product");

    }


    @Test(priority = 3)
    public void addWrongdetails() throws Exception {
        Thread.sleep(10000);

        WebElement ele= driver.findElement(By.xpath("(//*[contains(text(),'earbud3')])[1]"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(3000);
        actions.moveToElement(ele);
        actions.perform();
        Thread.sleep(3000);
        //1 pass
        driver.findElement(By.xpath("(//*[contains(text(),'earbud1')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud1input"))).sendKeys(readdata(5,2));
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(5,2)+" for First textbox");

        Thread.sleep(3000);
        //2 pass
        driver.findElement(By.xpath(getLocator().getProperty("earbud2input"))).clear();
          Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud2input"))).sendKeys(readdata(6,2));
        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//*[contains(text(),'earbud2')])[1]//following:: div[1]/div/div/div[1]")).click();
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(6,2)+" for second text box");
        Thread.sleep(3000);
        //3 pass
        driver.findElement(By.xpath(getLocator().getProperty("earbud3input"))).clear();
//        driver.findElement(By.xpath("(//*[contains(text(),'earbud3')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud3input"))).sendKeys(readdata(7,2));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(7,2)+" for third text box");
        //
        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud4')])[1]//following:: div[1]/div/div/div[1]")));
        actions.perform();
        WebElement frame= driver.findElement(By.xpath("//iframe[contains(@id,'attrib')]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath(getLocator().getProperty("earbud4input"))).clear();
//      driver.findElement(By.xpath("(//*[contains(text(),'earbud4')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud4input"))).sendKeys(readdata(8,2));
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(8,2)+" for fourth text box");
        //5
        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud5')])[1]//following:: div[1]/div/div/div[1]")));
        actions.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud5input"))).clear();
     //   driver.findElement(By.xpath("(//*[contains(text(),'earbud5')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud5input"))).sendKeys("http://pimworks-qa.s3.us-east-1.amazonaws.com/ImageRepository/52ABC30F-BC1B-4AA9-9E88-35A47F23915D/test(1).jp");
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input for fifth textbox");
        //6


        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]")));
        actions.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud6input"))).clear();
       // driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud6input"))).sendKeys(readdata(10,2));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(10,2)+" for sixth text box");
        //7

        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud7')])[1]")));
        actions.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud7input"))).clear();
        // driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud7input"))).sendKeys(readdata(10,2));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input "+readdata(10,2)+" for seventh textbox");
        //8
        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud8')])[1]")));
        actions.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud8input"))).clear();
        // driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud8input"))).sendKeys("09/16/2022");
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input  for eighth textbox");
        //9
        actions.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud9')])[1]")));
        actions.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud9input"))).clear();
        // driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud9input"))).sendKeys("09/16/2022 20:36:09");
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong input last text box");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)");
        Thread.sleep(3000);
        driver.findElement(By.id(getLocator().getProperty("productSave"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("clickOkNotification"))).click();
        ExtentFactory.getInstance().getExtent().pass("the user enters the wrong inputs ans clicks on save button");



    }
    @Test(priority = 4)
    public void addcorrectdetails() throws Exception {
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(3000);
        at.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(3000);

        //1 text
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud1')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud1input"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("earbud1input"))).sendKeys(readdata(5,3));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input "+readdata(5,3)+" for First text box");
       //2 Text + Numeric
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud2')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud2input"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("earbud2input"))).sendKeys(readdata(6,3));
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input "+readdata(6,3)+" for second text box");
        //3 Numeric
         at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud3')])[1]")));
         at.perform();
         driver.findElement(By.xpath(getLocator().getProperty("earbud3input"))).clear();
         driver.findElement(By.xpath(getLocator().getProperty("earbud3input"))).sendKeys(readdata(7,3));
         Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input "+readdata(7,3)+" for third text box");
         //4 Rich test
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud4')])[1]//following:: div[1]/div/div/div[1]")));
        at.perform();
        Thread.sleep(3000);
        WebElement frame= driver.findElement(By.xpath("//iframe[contains(@id,'attrib')]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath(getLocator().getProperty("earbud4input"))).clear();
//      driver.findElement(By.xpath("(//*[contains(text(),'earbud4')])[1]//following:: div[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud4input"))).sendKeys(readdata(8,2));
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input "+readdata(8,3)+" for fourth text box");
        //5 image
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud5')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud5input"))).clear();
        driver.findElement(By.xpath("(//*[contains(text(),'earbud5')])[1]//following:: div[1]/div/div/span[1]")).click();
        Thread.sleep(3000);
        WebElement upload= driver.findElement(By.xpath("//input[@title='Click here to select files']"));
        upload.sendKeys("C://Pimpomproject//com.pimwork//src//test//java//test_data//test.jpg");
        Thread.sleep(10000);
        driver.findElement(By.id("mediaPopupButtonSubmitEnable")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Ok' and @class='confirm']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Close']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[text()='Ok' and @class='confirm']")).click();
        Thread.sleep(7000);
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud5')])[1]")));
        at.perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud5input"))).sendKeys("http://pimworks-qa.s3.us-east-1.amazonaws.com/ImageRepository/52ABC30F-BC1B-4AA9-9E88-35A47F23915D/test.jpg");
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct image for fifth text box");
        //6 Tag
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud6')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud6input"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("earbud6input"))).sendKeys("@Tag0g");
        at.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct tag for sixth text box");
        //7 doc
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud7')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud7input"))).clear();
        driver.findElement(By.xpath("(//*[contains(text(),'earbud7')])[1]//following:: div[1]/div/div/span[1]")).click();
        Thread.sleep(3000);
        WebElement upload1= driver.findElement(By.xpath("//input[@title='Click here to select files']"));
        upload1.sendKeys("C://Pimpomproject//com.pimwork//src//test//java//test_data//UploadAttributesTemplate.xlsx");
        Thread.sleep(12000);
        driver.findElement(By.id("mediaPopupButtonSubmitEnable")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Ok' and @class='confirm']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Close']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[text()='Ok' and @class='confirm']")).click();
        Thread.sleep(7000);
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud7')])[1]")));
        at.perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("earbud7input"))).sendKeys(readdata(11,3));
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input "+readdata(11,3)+" for seventh text box");
        //8 date
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud8')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud8input"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("earbud8input"))).sendKeys("09/13/2022");
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct date for 8th text box");
        //9 date time
        at.moveToElement( driver.findElement(By.xpath("(//*[contains(text(),'earbud9')])[1]")));
        at.perform();
        driver.findElement(By.xpath(getLocator().getProperty("earbud9input"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("earbud9input"))).sendKeys("09/13/2022");
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass("the user enters the correct input Dte with time for ninth  text box");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)");
        Thread.sleep(3000);
        driver.findElement(By.id(getLocator().getProperty("productSave"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Ok' and @class='confirm']")).click();
        at.sendKeys(Keys.PAGE_UP).build().perform();
        ExtentFactory.getInstance().getExtent().pass("the user enters the Correct inputs ans clicks on save button");

    }




    }

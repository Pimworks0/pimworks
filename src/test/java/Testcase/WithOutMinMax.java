package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.io.IOException;

public class WithOutMinMax extends TestBase {
    String Datapath = "src//test//java//test_data//TestData.xlsx";

    private WebDriver driver;

    public String readdata(int row, int cell) throws Exception {
        return  readExcel("Without_Min_Max",row,cell,Datapath);
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
    public void createAttributeGroup() throws Exception {
        this.driver = TestBase.getWebDriver();
        ExtentFactory.getInstance().getExtent().pass("This test case will create a attribute group and give the Attribute type");
        // --------Login as admin
        System.out.println(readdata(1,1));
        System.out.println(readdata(2,1));
        new LoginPage(driver).login(readdata(1,1), readdata(2,1));
        Thread.sleep(4000);
        AccountManagement user = new AccountManagement(driver);
        // --------------move to the side menu ---------------
        user.moveTosidemenu();
        System.out.println(getLocator().getProperty("Settings"));
        driver.findElement(By.xpath(getLocator().getProperty("Settings"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Settings from side menu ");

        Thread.sleep(8000);
        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroups"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Attribute Groups from side menu ");
        Thread.sleep(2000);

        driver.findElement(By.xpath(getLocator().getProperty("CreateGroup"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create Group");
        driver.findElement(By.xpath(getLocator().getProperty("AttributeGroupName"))).sendKeys(readdata(3,1));
        driver.findElement(By.xpath(getLocator().getProperty("Attributeorder"))).sendKeys(readdata(4,1));
        driver.findElement(By.xpath(getLocator().getProperty("SaveAtrribute"))).click();
        ExtentFactory.getInstance().getExtent().pass(" Create Attribute Group displayed on the screen ");
        ExtentFactory.getInstance().getExtent().pass(" User Enter Attribute group Name and Display order than click save button");
        Thread.sleep(7000);
        driver.findElement(By.xpath(getLocator().getProperty("closeAttributealert"))).click();
        ExtentFactory.getInstance().getExtent().pass("User click Created group No of Attributes hyperlink");
        Thread.sleep(4000);
    }


    @Test(priority = 2)
    public void createAttribute() throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty("AttributeNoClick"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("createatributes"))).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user able to click  Create Attribute");

        driver.findElement(By.xpath(getLocator().getProperty("attibutesNamae"))).sendKeys(readdata(5, 1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass(" display Add New Attribute popup and user entered the Attribute name");
        Select dropdown = new Select(driver.findElement(By.id(getLocator().getProperty("atrributsDropdown"))));
        dropdown.selectByVisibleText(readdata(3, 1));
        ExtentFactory.getInstance().getExtent().pass(" user select respected Attribute group from drop down");
        driver.findElement(By.xpath(getLocator().getProperty("attrubuteSubmit"))).click();
        ExtentFactory.getInstance().getExtent().pass(" user click on Save Button for Attribute page");
        ExtentFactory.getInstance().getExtent().pass(readdata(5, 1) + "item created");
        createitems(readdata(6, 1));
        driver.findElement(By.xpath(getLocator().getProperty("closeAttributealert"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
        ExtentFactory.getInstance().getExtent().pass("All iteams are saved sucessfully");
        Thread.sleep(7000);

    }

    @Test(priority = 3)
    public void selectValues() throws Exception {
        driver.findElement(By.xpath(getLocator().getProperty("ClickColumn"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("ClickDropDown"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(getLocator().getProperty("SelectMultiple"))).click();
        Thread.sleep(3000);
        ExtentFactory.getInstance().getExtent().pass(" user select Multiple Option in Attribute2");
        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
        Thread.sleep(7000);
    }

    @Test(priority = 4)
    public void addPossibleValues() throws Exception {
        driver.findElement(By.xpath(getLocator().getProperty("PossibleValueClick_2"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("AddNewValue"))).sendKeys(readdata(9,1));
        driver.findElement(By.xpath(getLocator().getProperty("AddValuebtn"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("AddNewValue"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("AddNewValue"))).sendKeys(readdata(10,1));
        driver.findElement(By.xpath(getLocator().getProperty("AddValuebtn"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("AddNewValue"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("AddNewValue"))).sendKeys(readdata(11,1));
        driver.findElement(By.xpath(getLocator().getProperty("AddValuebtn"))).click();
        driver.navigate().refresh();
        driver.switchTo().alert().accept();
        Thread.sleep(7000);
        // driver.findElement(By.xpath(getLocator().getProperty("AddValueDialogCloseBtn"))).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath(getLocator().getProperty("saveAttributes"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("Possible values are added and saved successfully");
    }


    @Test(priority = 6)
    public void addAtributestoTaxonomy() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        user.moveTosidemenu();
        driver.findElement(By.xpath(getLocator().getProperty("Settings"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Settings from side menu ");
        Thread.sleep(4000);
        driver.findElement(By.xpath(getLocator().getProperty("Taxonamoysidemu"))).click();
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_New_Taxonomy"))).click();

        ExtentFactory.getInstance().getExtent().pass("user click + Add New Taxonomy");
        Thread.sleep(2000);
        driver.findElement(By.id(getLocator().getProperty("teonomybox"))).sendKeys(readdata(13,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("Create Taxonomy  popup is Displayed");
        driver.findElement(By.xpath(getLocator().getProperty("Apply"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass(" user enter Textbox and click save button");
        driver.findElement(By.xpath(getLocator().getProperty("Add_by_Attributes"))).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(getLocator().getProperty("dropdown_on_stting_txn"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("SearchAttribute"))).sendKeys(readdata(3,1));
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
        driver.findElement(By.xpath(getLocator().getProperty("SKUvalue"))).sendKeys(readdata(14,1));
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("ProductName"))).sendKeys(readdata(15,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath(getLocator().getProperty("node"))).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath(getLocator().getProperty("boxtosearch"))).sendKeys(readdata(13,1));
        //need to change the locator

        driver.findElement(By.xpath(getLocator().getProperty("Searchiteam"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user choose item from the Taxonomy dropdown");
        driver.findElement(By.xpath(getLocator().getProperty("saveProduct"))).click();
        Thread.sleep(10000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on save button to Create product");

    }

    @Test(priority = 7)
    public void SelectValuesAndSave() throws Exception {
        driver.findElement(By.xpath(getLocator().getProperty("SelectorClick"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Acer_checkbox"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("LenovaCheckbox"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("DellCheckbox"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Textbox_Single"))).sendKeys(readdata(12,1));
        driver.findElement(By.xpath(getLocator().getProperty("Savebutton"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("OkButton"))).click();
        ExtentFactory.getInstance().getExtent().pass("Save values without Min and Max");
    }


}






package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;
import java.awt.Robot;


import java.awt.event.KeyEvent;
import java.time.Duration;

import static baselibrary.TestBase.getLocator;
import static baselibrary.TestBase.readExcel;

public class Product_Page_Operations {

    String Datapath = "src//test//java//test_data//TestData.xlsx";

    private WebDriver driver;

    public String readdata(int row, int cell) throws Exception {
        return  readExcel("Product_Page_Operations",row,cell,Datapath);
    }
    public String readdata_config(int row, int cell) throws Exception {
        return  readExcel("Config",row,cell,Datapath);
    }

    public void mouseOverTOElement(WebElement element) {
        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).build().perform();
        }

        catch (Exception e) {
            System.out.println("Element is not enabled");
            e.printStackTrace();
        }
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
        driver.findElement(By.id(getLocator().getProperty("teonomybox"))).sendKeys(readdata(7,1));
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
        Thread.sleep(10000);
        driver.get(readdata_config(3,1));
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
    }


    @Test(priority = 4)
    public void addProduct_1() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        driver.findElement(By.xpath(getLocator().getProperty("createProduct"))).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create product");
        driver.findElement(By.xpath(getLocator().getProperty("SKUvalue"))).sendKeys(readdata(8,1));
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("ProductName"))).sendKeys(readdata(9,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath(getLocator().getProperty("node"))).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath(getLocator().getProperty("boxtosearch"))).sendKeys(readdata(7,1));
        //need to change the locator

        driver.findElement(By.xpath(getLocator().getProperty("Searchiteam"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user choose item from the Taxonomy dropdown");
        driver.findElement(By.xpath(getLocator().getProperty("saveProduct"))).click();
        //Thread.sleep(20000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on save button to Create product");
    }

    @Test(priority = 5)
    public void addVariant() throws Exception {
        // explicit wait condition
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30000));
        // presenceOfElementLocated condition
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(getLocator().getProperty("Add_variant"))));
        driver.findElement(By.xpath(getLocator().getProperty("Add_variant"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("variant_skuid"))).sendKeys(readdata(10,1));
        driver.findElement(By.xpath(getLocator().getProperty("variant_prod_name"))).sendKeys(readdata(11,1));
        driver.findElement(By.xpath(getLocator().getProperty("varinat_selectall"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("varinat_create_btn"))).click();
        ExtentFactory.getInstance().getExtent().pass("Variant one added to the product");
        Thread.sleep(4000);
        driver.findElement(By.xpath(getLocator().getProperty("variant_skuid"))).sendKeys(readdata(12,1));
        driver.findElement(By.xpath(getLocator().getProperty("variant_prod_name"))).sendKeys(readdata(13,1));
        driver.findElement(By.xpath(getLocator().getProperty("varinat_create_btn"))).click();
        Thread.sleep(5000);
        driver.get(readdata_config(3,1));
        Thread.sleep(10000);
    }

    @Test(priority = 6)
    public void CheckVariantSelection() throws Exception {
        //    this.driver = TestBase.getWebDriver();
//        // --------Login as admin
//        System.out.println(readdata(1,1));
//        System.out.println(readdata(2,1));
//        new LoginPage(driver).login(readdata(1,1), readdata(2,1));
//        Thread.sleep(10000);
        driver.findElement(By.xpath(getLocator().getProperty("Fist_product_check_box"))).click();
        Thread.sleep(10000);
        String record_no = driver.findElement(By.xpath(getLocator().getProperty("rec_select_num"))).getText();
        System.out.println("Error from scren:"+record_no);
        System.out.println("Error from Excel:"+readdata(14,1));
        String doubleAsString = String.valueOf(readdata(14,1));
        int indexOfDecimal = doubleAsString.indexOf(".");
        String expected_value= doubleAsString.substring(0, indexOfDecimal);
        Assert.assertEquals(record_no,expected_value,"Variant number check is failed.");
        driver.findElement(By.xpath(getLocator().getProperty("Fist_product_check_box"))).click();
        String record_no_deselect = driver.findElement(By.xpath(getLocator().getProperty("rec_select_num"))).getText();
        System.out.println("Error from scren:"+record_no_deselect);
        System.out.println("Error from Excel:"+readdata(15,1));
        String doubleAsString_1 = String.valueOf(readdata(15,1));
        int indexOfDecimal_1 = doubleAsString.indexOf(".");
        String expected_value_1= doubleAsString.substring(0, indexOfDecimal);
        Assert.assertEquals(record_no,expected_value,"Variant number check is failed.");
        Assert.assertEquals(record_no_deselect,expected_value_1,"Deselect is not working");
        ExtentFactory.getInstance().getExtent().pass("The varaint select and deselect check is done");
    }

    @Test(priority = 7)
    public void SearchOperation() throws Exception {
        mouseOverTOElement(driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))));
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).sendKeys(readdata(16,1));
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Search Operation is Done for No data available scenario");
        Thread.sleep(5000);
        String No_data_text = driver.findElement(By.xpath(getLocator().getProperty("No_data_ava"))).getText();
        System.out.println("Error from scren:"+No_data_text);
        System.out.println("Error from Excel:"+readdata(17,1));
        Assert.assertEquals(No_data_text,readdata(17,1),"No data message is wrong.");
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).sendKeys(readdata(19,1));
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).sendKeys(readdata(9,1));
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        WebElement search_result_row = driver.findElement(By.xpath(getLocator().getProperty("product_search_res")));
        Assert.assertTrue(search_result_row.isDisplayed());
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).clear();
        driver.findElement(By.xpath(getLocator().getProperty("SearchProduct"))).click();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        ExtentFactory.getInstance().getExtent().pass("Search Operation is Done for valid data");
    }

    @Test(priority = 8)
    public void SelectProdCheckbox() throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty("ProdCheckboxOpt"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("ProdCheckboxOpt_selct_all"))).click();
        Thread.sleep(10000);
        ExtentFactory.getInstance().getExtent().pass("Select All Checkbox is Selected");
        driver.findElement(By.xpath(getLocator().getProperty("ProdCheckboxOpt"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("ProdCheckboxOpt_none"))).click();
        ExtentFactory.getInstance().getExtent().pass("None Checkbox is Selected");
        Thread.sleep(5000);

    }

    @Test(priority = 9)
    public void ProdPagination() throws Exception {

        WebElement testDropDown = driver.findElement(By.xpath(getLocator().getProperty("pagination_dropdown")));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByValue("5");
        Thread.sleep(10000);
        dropdown.selectByValue("20");
        Thread.sleep(10000);
        dropdown.selectByValue("49");
        Thread.sleep(10000);
        ExtentFactory.getInstance().getExtent().pass("Pagination changed to 25,50 records per page");

    }


    @Test(priority = 10)
    public void ProdFooter() throws Exception {

        String footer = driver.findElement(By.xpath(getLocator().getProperty("ProductPage_footer"))).getText();
        System.out.println("footer from scren:"+footer);
        System.out.println("footer from Excel:"+readdata(18,1));
        Assert.assertEquals(footer,readdata(18,1),"footer message is wrong.");
        ExtentFactory.getInstance().getExtent().pass("Page footer message check done");
    }

}

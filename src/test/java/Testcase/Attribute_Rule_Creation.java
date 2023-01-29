package Testcase;

import baselibrary.ExtentFactory;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageLibrary.AccountManagement;
import pageLibrary.LoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static baselibrary.TestBase.getLocator;
import static baselibrary.TestBase.readExcel;


public class Attribute_Rule_Creation {

    String Datapath = "src//test//java//test_data//TestData.xlsx";

    private WebDriver driver;
    private static String c_pump_mr;

    public String readdata(int row, int cell) throws Exception {
        return readExcel("Attribute_Rule_Creation", row, cell, Datapath);
    }

    public String readdata_config(int row, int cell) throws Exception {
        return readExcel("Config", row, cell, Datapath);
    }

    public void mouseOverTOElement(WebElement element) {
        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).build().perform();
        } catch (Exception e) {
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
        ExtentFactory.getInstance().getExtent().pass(data + "item created");
        Thread.sleep(7000);
    }

    public void AddAttributeToRule(String Add_Attribute_btn,String Condition_select,String Condition_search,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_select))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Select_attribute"))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_search))).sendKeys(readdata(rownumber,1));
        Thread.sleep(5000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Created the "+readdata(rownumber,1)+" Condtion");

    }

    public void AddOperatorToRule(String Add_Attribute_btn,String Operator_select,String Operator_search,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Operator_select))).click();

        driver.findElement(By.xpath(getLocator().getProperty("Select_operator"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty(Operator_search))).sendKeys(readdata(rownumber,1));
        Thread.sleep(5000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Added the "+readdata(rownumber,1)+" Operator to the rule");
    }

    public void AddValueToRule(String Add_Attribute_btn,String Value_select,String Value_input,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Value_select))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Value_input))).sendKeys(readdata(rownumber,1));
        ExtentFactory.getInstance().getExtent().pass("Added the "+readdata(rownumber,1)+" value to the rule");

    }

    public void AddConditionToRule(String Add_Attribute_btn,String Condition_select,String Condition_search,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_select))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Condition_Click"))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_search))).sendKeys(readdata(rownumber,1));
        Thread.sleep(5000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Created the "+readdata(rownumber,1)+" Condtion");
    }

    public void AddOtherOptionToRule(String Add_Attribute_btn,String Other_Option_select,String Other_Option_search,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Other_Option_select))).click();

        driver.findElement(By.xpath(getLocator().getProperty("Select_Other_Options"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty(Other_Option_search))).sendKeys(readdata(rownumber,1));
        Thread.sleep(5000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Added the "+readdata(rownumber,1)+" Operator to the rule");
    }

    public void AddConditionToRuleElse(String Add_Attribute_btn,String Condition_select,String Condition_search,int rownumber) throws Exception {

        driver.findElement(By.xpath(getLocator().getProperty(Add_Attribute_btn))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_select))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Condition_Click"))).click();
        driver.findElement(By.xpath(getLocator().getProperty(Condition_search))).sendKeys(readdata(rownumber,1));
        Thread.sleep(5000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ExtentFactory.getInstance().getExtent().pass("Created the "+readdata(rownumber,1)+" Condtion");
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
        createitems(readdata(7, 1));
        createitems(readdata(8, 1));
        createitems(readdata(9, 1));
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
        driver.findElement(By.id(getLocator().getProperty("teonomybox"))).sendKeys(readdata(10,1));
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
//        driver.get(readdata_config(3,1));
//        Thread.sleep(5000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(10000);
    }

    @Test(priority = 4)
    public void SelectChannelHealthSubscriptions() throws Exception {
        AccountManagement user = new AccountManagement(driver);
        user.moveTosidemenu();
        driver.findElement(By.xpath(getLocator().getProperty("Channels"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Channels from side menu ");
        Thread.sleep(8000);
        driver.findElement(By.xpath(getLocator().getProperty("Healthcheck_subscriptions"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Healthcheck subscriptions from side menu ");
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_btn_1"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_btn_2"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_btn_3"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Add_btn_4"))).click();
        Thread.sleep(5000);


    }


    @Test(priority = 5)
    public void createAttributeRule() throws Exception {
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
        driver.findElement(By.xpath(getLocator().getProperty("AttributeRules"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Attribute Rules from side menu ");
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("Vendor_Attribute_rule_tab"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Create_New_Rule_btn"))).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user is in create vendor Atrribute Rules page ");
        driver.findElement(By.xpath(getLocator().getProperty("Rule_Name_Input"))).sendKeys(readdata(11,1));

        driver.findElement(By.xpath(getLocator().getProperty("Add_Attribute_btn"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Condition_select"))).click();
        ExtentFactory.getInstance().getExtent().pass("Created the IF Condtion");

        AddAttributeToRule("Add_Attribute_btn","Attribute_select",
                "Attribute_search",12);
        AddOperatorToRule("Add_Attribute_btn","Operator_select",
                "Operator_search",13);
        AddValueToRule("Add_Attribute_btn","Value_select",
                "Value_input",14);
        Robot rb = new Robot();

//----------------------AND------------------------------

         AddConditionToRule("Add_Attribute_btn","Condition_select",
                 "Condition_search",15);
        AddAttributeToRule("Add_Attribute_btn_2","Attribute_select_2",
                "Attribute_search_2",16);
        AddOperatorToRule("Add_Attribute_btn_2","Operator_select_2",
                "Operator_search_2",17);
        AddValueToRule("Add_Attribute_btn_2","Value_select_2",
                "Value_input_2",18);

//------------------- SECOND AND--------------------------

        AddConditionToRule("Add_Attribute_btn_2","Condition_select_2",
                "Condition_search_3",19);
        AddAttributeToRule("Add_Attribute_btn_3","Attribute_select_3",
                "Attribute_search_3",20);
        AddOperatorToRule("Add_Attribute_btn_3","Operator_select_3",
                "Operator_search_3",21);
        AddValueToRule("Add_Attribute_btn_3","Value_select_3",
                "Value_input_3",22);


        // ----------------THEN-------------------------

        AddConditionToRule("Add_Attribute_btn_3","Condition_select_3",
                "Condition_search_4",23);
        AddAttributeToRule("Add_Attribute_btn_4","Attribute_select_4",
                "Attribute_search_4",24);
        AddOperatorToRule("Add_Attribute_btn_4","Operator_select_4",
                "Operator_search_4",25);
        AddAttributeToRule("Add_Attribute_btn_4","Attribute_select_4",
                "Attribute_search_4_1",26);

        // ----------------ELSEIF-------------------------

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AddConditionToRule("Add_Attribute_btn_4","Condition_select_4",
                "Condition_search_5",27);
        AddAttributeToRule("Add_Attribute_btn_5","Attribute_select_5",
                "Attribute_search_5",28);
        AddOperatorToRule("Add_Attribute_btn_5","Operator_select_5",
                "Operator_search_5",29);
        AddValueToRule("Add_Attribute_btn_5","Value_select_5",
                "Value_input_5",30);

        // ----------------OR-------------------------
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AddConditionToRule("Add_Attribute_btn_5","Condition_select_5",
                "Condition_search_6",31);
        AddAttributeToRule("Add_Attribute_btn_6","Attribute_select_6",
                "Attribute_search_6",32);
        AddOperatorToRule("Add_Attribute_btn_6","Operator_select_6",
                "Operator_search_6",33);
        AddValueToRule("Add_Attribute_btn_6","Value_select_6",
                "Value_input_6",34);

        // ----------------THEN-------------------------
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AddConditionToRule("Add_Attribute_btn_6","Condition_select_6",
                "Condition_search_7",35);
        AddAttributeToRule("Add_Attribute_btn_7","Attribute_select_7",
                "Attribute_search_7",36);
        AddOperatorToRule("Add_Attribute_btn_7","Operator_select_7",
                "Operator_search_7",37);
        AddAttributeToRule("Add_Attribute_btn_7","Attribute_select_7",
                "Attribute_search_7_1",38);
        AddOperatorToRule("Add_Attribute_btn_7","Operator_select_7",
                "Operator_search_7_1",39);
        AddOtherOptionToRule("Add_Attribute_btn_7","Other_Options_7",
                "Other_Options_search_7",40);
        AddAttributeToRule("Add_Attribute_btn_7","Attribute_select_7",
                "Attribute_search_7_2",41);
        AddOperatorToRule("Add_Attribute_btn_7","Operator_select_7",
                "Operator_search_7_3",42);
        AddAttributeToRule("Add_Attribute_btn_7","Attribute_select_7",
                "Attribute_search_7_3",43);
        AddOperatorToRule("Add_Attribute_btn_7","Operator_select_7",
                "Operator_search_7_4",44);
        AddValueToRule("Add_Attribute_btn_7","Value_select_7",
                "Value_input_7_1",45);
        AddOtherOptionToRule("Add_Attribute_btn_7","Other_Options_7",
                "Other_Options_search_7_1",46);

// ----------------ELSE-------------------------
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AddConditionToRuleElse("Add_Attribute_btn_7","Condition_select_7",
                "Condition_search_8",47);
        AddAttributeToRule("Add_Attribute_btn_8","Attribute_select_8",
                "Attribute_search_8",48);
        AddOperatorToRule("Add_Attribute_btn_8","Operator_select_8",
                "Operator_search_8",49);
        AddAttributeToRule("Add_Attribute_btn_8","Attribute_select_8",
                "Attribute_search_8_1",50);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath(getLocator().getProperty("Validate_btn"))).click();

    }

    @Test(priority = 6)
    public void RuleAddStep2_3() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, 0);");

        driver.findElement(By.xpath(getLocator().getProperty("Next_btn"))).click();
        Thread.sleep(5000);

        double j = Double.parseDouble(readdata(51, 1));

        for ( double i = 2; i < j; i++) {

            driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
        }

        driver.findElement(By.xpath(getLocator().getProperty("Tab_2_Next_btn"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Taxonomy_dropdown"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Select_all_taxonomy"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Search_Taxonomy"))).sendKeys(readdata(10, 1));
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Select_all_taxonomy"))).click();
        driver.findElement(By.xpath(getLocator().getProperty("Finish_btn"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("Confirmation_No"))).click();
        Thread.sleep(5000);

    }

    @Test(priority = 7)
    public void VendorProfileFileUpload() throws Exception {

        AccountManagement user = new AccountManagement(driver);
        user.moveTosidemenu();
        driver.findElement(By.xpath(getLocator().getProperty("Vendor_Management"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Vendor Management from side menu ");
        Thread.sleep(8000);
        driver.findElement(By.xpath(getLocator().getProperty("Vendor_Profile_Menu"))).click();
        ExtentFactory.getInstance().getExtent().pass("user clicked on Healthcheck subscriptions from side menu ");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//div[@class='qq-uploader-selector qq-uploader single-uploader']")).click();
        Thread.sleep(5000);
        c_pump_mr = new File(".//src//test//java//test_data//Account_VendorProfile_.xlsx").getCanonicalPath();
        Bulk_Upload_Attribute.uploadFile(c_pump_mr);
        Thread.sleep(5000);
        driver.findElement(By.xpath(getLocator().getProperty("Vendor_profile"))).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void addProduct() throws Exception {
        driver.get(readdata_config(3, 1));
        Thread.sleep(10000);
        AccountManagement user = new AccountManagement(driver);
        driver.findElement(By.xpath(getLocator().getProperty("createProduct"))).click();
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on Create product");
        driver.findElement(By.xpath(getLocator().getProperty("SKUvalue"))).sendKeys(readdata(52,1));
        Thread.sleep(2000);
        driver.findElement(By.xpath(getLocator().getProperty("ProductName"))).sendKeys(readdata(53,1));
        Thread.sleep(2000);
        ExtentFactory.getInstance().getExtent().pass("user gives the product details like SKU and product name");
        driver.findElement(By.xpath(getLocator().getProperty("node"))).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath(getLocator().getProperty("boxtosearch"))).sendKeys(readdata(10,1));
        //need to change the locator

        driver.findElement(By.xpath(getLocator().getProperty("Searchiteam"))).click();
        Thread.sleep(7000);
        ExtentFactory.getInstance().getExtent().pass("user choose item from the Taxonomy dropdown");
        driver.findElement(By.xpath(getLocator().getProperty("saveProduct"))).click();
        //Thread.sleep(20000);
        ExtentFactory.getInstance().getExtent().pass("user clicked on save button to Create product");
    }
}
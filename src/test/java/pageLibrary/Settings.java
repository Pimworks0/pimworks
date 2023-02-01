package pageLibrary;

import baselibrary.ExtentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableLibrary;

import java.io.IOException;

public class Settings extends ReusableLibrary {

    WebDriver driver;


    @FindBy(xpath="(//i[@id='23'])[1]")
    WebElement mouseoverElement;

    @FindBy(xpath="(//span[normalize-space()='User Management'])[1]")
    WebElement userManagement;

    @FindBy(xpath="//button[@id='btnOpenAddAccount']")
    WebElement addAccount;

    @FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/a[1]/span[1]")
    WebElement filter;


    @FindBy(xpath="//a[normalize-space()='Account Management']")
    WebElement AccountManagement;

    @FindBy(xpath="//a[@href='/PIMWorks_QA/Products']//*[name()='svg']//*[name()='path']")
    WebElement sidemenu;

    @FindBy(xpath="(//a[@class='mm-next'])[6]")
    WebElement setting;

    @FindBy(xpath = "//input[@role='textbox']")
    WebElement textBox;

    @FindBy(xpath="//li[normalize-space()='demo35@gmail.com']")
    WebElement chooseUserfromDropdown;

    @FindBy(xpath="(//button[normalize-space()='Filter'])[1]")
    WebElement SelectFilter;

    @FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/a[4]")
    WebElement clickOnAccess;



    @FindBy(id="moduleselectUnSelect")
    WebElement SelectAllModule;

    public WebElement getOption1() {
        return option1;
    }

    public void setOption1(WebElement option1) {
        this.option1 = option1;
    }

    @FindBy(id="mGroupId_1")
    WebElement option1;


    public WebElement getOption2() {
        return option2;
    }

    public void setOption2(WebElement option2) {
        this.option2 = option2;
    }

    @FindBy(id="mGroupId_2")
    WebElement option2;

    public WebElement getOption3() {
        return option3;
    }

    public void setOption3(WebElement option3) {
        this.option3 = option3;
    }

    @FindBy(xpath="//input[@id='mGroupId_3]")
    WebElement option3;


    @FindBy(xpath="//input[@value='Save']")
    WebElement save;


    @FindBy(id="ReadonlyeselectUnSelect")
    WebElement readonly;


    public WebElement getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(WebElement profileImage) {
        this.profileImage = profileImage;
    }

    @FindBy(xpath="//img[@class='circular-border']")
    WebElement profileImage;

    @FindBy(id="logout")
    WebElement logout;
    @FindBy(linkText = "View")
    WebElement view;
    @FindBy(xpath = "(//a[@class='k-grid-filter'])[3]")
    WebElement clickfilterInsideChangeaccount;

    public Settings(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;
        implicitWait(5);

        PageFactory.initElements(driver, this);
    }


    public void moveToUserManagement() {
        try{
            mouseOverTOElement(userManagement);
            ExtentFactory.getInstance().getExtent().pass("User able to move side menu ");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to move side menu and the exception "+e.getMessage());
        }

    }
    public void moveToSetting() {
        try{
            mouseOverTOElement(setting);
            ExtentFactory.getInstance().getExtent().pass("User able to move side menu ");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to move side menu and the exception "+e.getMessage());
        }

    }
    public void moveTosidemenu() {
        try{
            mouseOverTOElement(sidemenu);
            ExtentFactory.getInstance().getExtent().pass("User able to move VendorManagement");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to move VendorManagement and the exception "+e.getMessage());
        }

    }
    public void clickOnUserManagement() {
         try{
             clickWebelement(userManagement);
             ExtentFactory.getInstance().getExtent().pass("User able to  ");

         }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to click on user management "+e.getMessage());
        }
    }

    public void clickOnAccountmanagement() {

        clickWebelement(AccountManagement);
    }

    public void clickFilterIcon() {
        try {
            clickWebelement(filter);
            ExtentFactory.getInstance().getExtent().pass("user able to click on the filter");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().fail("user not able to click on the filter");
        }
    }

    public void serchAccount(String str) {
        try {
            enterText(textBox,str);
            ExtentFactory.getInstance().getExtent().pass("Searching "+str +"Account is Successful");
        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("Searching "+str +"Account is Successful");
        }

    }

    public void selectSearchitem() {
       clickWebelement(chooseUserfromDropdown);
    }

    public  void clickOnFilter(){
        try{
            clickWebelement(SelectFilter);
            ExtentFactory.getInstance().getExtent().pass("User able to click on the filter");

        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("not able to click on filter");
        }

    }


    public  void clickOnAccess(){
        try{
            clickWebelement(clickOnAccess);
            ExtentFactory.getInstance().getExtent().pass("click on the access successful");

        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("not able to click on the access ");
        }
    }

    public  void checkoption1(){
        clickWebelement(option1);
    }

    public  void checkoption2(){
        clickWebelement(option2);
    }

    public  void checkoption3(){
        clickWebelement(option3);
    }
    public  void clickSave(){
        try {
            clickWebelement(save);
            ExtentFactory.getInstance().getExtent().pass("click on the access successful");
        }
        catch (Exception e)
        {
            ExtentFactory.getInstance().getExtent().fail("not able to save the element");

        }
    }

    public  void seletAllModule(){
        clickWebelement(SelectAllModule);
    }
    public  void clickReadonly(){
        clickWebelement(readonly);
    }
    public  void clickProfileImage(){
        try {
            clickWebelement(profileImage);
            ExtentFactory.getInstance().getExtent().pass("User able to click on Profile image successful");
        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to click on Profile image");
        }

    }
    public  void logout(){
        try{
            clickWebelement(logout);
            ExtentFactory.getInstance().getExtent().pass("User able to click on logout successful");
        }
        catch (Exception e)
        {
            ExtentFactory.getInstance().getExtent().fail("User not able to click on logout "+e.getMessage());
        }

    }
    public  void clickOnView() {

            try {
                clickWebelement(view);
                ExtentFactory.getInstance().getExtent().pass("User able to click on view successful");
            } catch (Exception e) {
                ExtentFactory.getInstance().getExtent().fail("User not able to click on view " + e.getMessage());
            }


    }
    public  void clickfilterInsideChangeaccount(){
        clickWebelement(clickfilterInsideChangeaccount);
    }

}

package pageLibrary;

import baselibrary.ExtentFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableLibrary;

import java.io.IOException;

public class UserManagementPage  extends ReusableLibrary {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'User Management')]")
    WebElement userManagement;

    @FindBy(xpath = "//th[@data-field='EmployeeEmail']//span[@class='k-icon k-filter']")
    WebElement filter;

    @FindBy(xpath = "(//span[@class='k-icon k-filter'])[8]")
    WebElement filter2;

    @FindBy(xpath = "(//input[@role='textbox'])[2]")
    WebElement textbox;

    public UserManagementPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        implicitWait(5);
        PageFactory.initElements(driver, this);
    }


    public void clickUserManagement() {
        try {
            clickWebelement(userManagement);
            ExtentFactory.getInstance().getExtent().pass("click on the access successful");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().fail("not able to save the element");

        }
        //driver.findElement(By.xpath("//a[contains(text(),'User Management')]")).click();
    }

    public void clickonfilter() {
        try {
            clickWebelement(filter);
            ExtentFactory.getInstance().getExtent().pass("click on filter successful");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().fail("not able to click on filter");

        }
        //driver.findElement(By.xpath("//a[contains(text(),'User Management')]")).click();
    }
    public void clickonfilter2() {
        try {
            clickWebelement(filter2);
            ExtentFactory.getInstance().getExtent().pass("click on second filter successful");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().fail("not able to click on second filter");

        }
        //driver.findElement(By.xpath("//a[contains(text(),'User Management')]")).click();
    }
    public void serchinSideUserManagement(String str) {
        try {
            enterText(textbox,str);
            ExtentFactory.getInstance().getExtent().pass("Searching "+str +"Account is Successful");
        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("Searching "+str +"Account is Successful");
        }

    }




}
package pageLibrary;

import baselibrary.ExtentFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableLibrary;

import java.io.IOException;

public class Account_ResiterPage extends ReusableLibrary {

    WebDriver driver;


    public Account_ResiterPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver=driver;
        implicitWait(5);

        PageFactory.initElements(driver, this);
    }


    public void enterFirstName(String str) {
        try{
            enterText(FirstName,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter Firstname ");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to enter First Name "+e.getMessage());
        }

    }
    public void enterLastName(String str) {
        try{
            enterText(LastName,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter last name ");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to enter last name "+e.getMessage());
        }

    }

    public void enterEmail(String str) {
        try{
            enterText(Email,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter email");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to enter email "+e.getMessage());
        }

    }
    public void enterPhoneNumber(String str) {
        try{
            enterText(PhoneNumber,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter Phone Number");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able enter Phone Number"+e.getMessage());
        }

    }
    public void enterAccountUser(String str) {
        try{
            enterText(AccountUser,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter Account user");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to enter Company Name "+e.getMessage());
        }

    }
    public void enterCompanyName(String str) {
        try{
            enterText(CompanyName,str);
            ExtentFactory.getInstance().getExtent().pass("User able to enter Company Name ");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to enter Company Name "+e.getMessage());
        }

    }
    public void saveAccount() {
        try{
            clickWebelement(btnsaveEmpAccount);
            ExtentFactory.getInstance().getExtent().pass("User able to click the Account save button");

        }
        catch (Exception e){
            ExtentFactory.getInstance().getExtent().fail("User not able to move side menu and the exception "+e.getMessage());
        }

    }

    @FindBy(id="FirstName")
    WebElement FirstName;

    @FindBy(id="LastName")
    WebElement LastName;

    @FindBy(id="Email")
    WebElement Email;

    @FindBy(id="PhoneNumber")
    WebElement PhoneNumber;

    @FindBy(id="AccountUser")
    WebElement AccountUser;

    @FindBy(id="CompanyName")
    WebElement CompanyName;

    @FindBy(id="btnsaveEmpAccount")
    WebElement btnsaveEmpAccount;


}

package pageLibrary;

import java.io.IOException;

import baselibrary.ExtentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableLibrary;

public class LoginPage extends ReusableLibrary {
	
WebDriver driver;
	
	@FindBy(id="loginEmail")
	WebElement userName;
	
	@FindBy(id="loginPassword")
	WebElement password;
	
	@FindBy(id="LoginButton")
	WebElement signin;
	
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver=driver;
		implicitWait(5);

		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String strUserName) {
		try {
			enterText(userName,strUserName);
			logger.info("User name entered");
			ExtentFactory.getInstance().getExtent().pass("Username is Entered and the username is"+ strUserName);
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Some error happened to entered username and the error is"+e.getMessage());
		}

	}
	
	public void enterPassword(String strPassword) {
		try {
			enterText(password,strPassword);
			logger.info("Password entered");
			ExtentFactory.getInstance().getExtent().pass("Password is Entered and the password is"+ strPassword);
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Some error happened to entered password and the error is"+e.getMessage());
		}

	}
	
	public void clickSignIn() {
		try {
			clickWebelement(signin);
			logger.info("login submit is successful");
			ExtentFactory.getInstance().getExtent().pass("User able to login Successfully");
		}
		catch (Exception e){
			ExtentFactory.getInstance().getExtent().fail("Some error happened for login and the error is"+e.getMessage());
		}


	}
	
	public ProductPage login(String userName,String password) throws IOException, InterruptedException {
		enterUserName(userName);
		enterPassword(password);
		clickSignIn();

		return new ProductPage(driver);

	}

}

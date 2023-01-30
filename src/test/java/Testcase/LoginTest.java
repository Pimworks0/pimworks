package Testcase;

import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase {
	
	private WebDriver driver;
	
	LoginPage Loginobj;
	Logger logger;

	String loginUserName=null;
	String loginPassword=null;
	
	@BeforeClass
	public void StartTest() throws Exception {
		this.driver = TestBase.getWebDriver();
		
		loginUserName=getProperties().getProperty("LoginUserName");
		loginPassword=getProperties().getProperty("LoginPassword");
				
		Loginobj = new LoginPage(driver);		
		logger = new Logger();
	}

	@Test
	public void loginPIM() throws IOException, InterruptedException{
	Loginobj.login(loginUserName,loginPassword);
	}
	


}

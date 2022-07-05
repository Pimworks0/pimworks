package pageLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableLibrary;

public class ProductPage extends ReusableLibrary {
	WebDriver driver;

	public ProductPage(WebDriver driver) throws IOException, InterruptedException {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	

}

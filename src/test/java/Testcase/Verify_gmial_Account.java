package Testcase;

import TestListeners.ListenersImplementation;
import baselibrary.ExtentFactory;
import baselibrary.Logger;
import baselibrary.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.LoginPage;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Verify_gmial_Account   {

   //private WebDriver driver;

    @Test
    public void verifyAccount_inGmail() throws IOException, InterruptedException {


        ChromeOptions chrome_options = new ChromeOptions();

        chrome_options.addArguments("--disable-extensions");
        chrome_options.addArguments("--disable-popup-blocking");
        chrome_options.addArguments("--profile-directory=Default");
        chrome_options.addArguments("--ignore-certificate-errors");
        chrome_options.addArguments("--disable-plugins-discovery");
        chrome_options.addArguments("--incognito");
        chrome_options.addArguments("user_agent=DN");


        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        chrome_options.addArguments("start-maximized");
        chrome_options.setExperimentalOption("useAutomationExtension", false);
        chrome_options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver = new ChromeDriver(chrome_options);

        driver.get("https://mail.google.com/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("envtestauto18@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("Mobius@123");
        driver.findElement(By.id("passwordNext")).click();
        System.out.println(driver.getTitle());

//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[@id=':2d']/span/span")).click();
//        WebElement ele = driver.findElement(By.cssSelector("a[title='PimWorks']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//        ele.click();
//        String parent = driver.getWindowHandle();
//        Set<String> s = driver.getWindowHandles();
//        Iterator<String> I1 = s.iterator();
//
//        while (I1.hasNext()) {
//
//            String child_window = I1.next();
//
//            if (!parent.equals(child_window)) {
//                driver.switchTo().window(child_window);
//
//                System.out.println(driver.switchTo().window(child_window).getTitle());
//
//            }
//        }
//        driver.findElement(By.id("NewPassword")).sendKeys("chandan");
//        Thread.sleep(2000);
//        driver.findElement(By.id("ConfirmNewPassword")).sendKeys("Pass@123");
//    }
    }


}


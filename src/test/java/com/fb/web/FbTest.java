package com.fb.web;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fb.object.FBPage;
import com.fb.object.GooglePage;
public class FbTest {

	WebDriver driver;
	GooglePage objgoogle;
	FBPage     objfb;
	String GoogleURL = "http://www.google.com/";
	Properties prop = new Properties();
	//Logger logger = Logger.getLogger("devpinoyLogger");

	@BeforeTest
	public void setup() {
	//    System.setProperty("webdriver.gecko.driver", "/home/jombay/jombay_testing/workspace_git/driver/geckodriver");
	//	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	//	capabilities.setCapability("marionette", false);
	//    driver = new FirefoxDriver(capabilities);

		//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		System.setProperty("webdriver.chrome.driver","C:/Users/narendar.g.EXCERSHYD/Downloads/chromedriver_win32/chromedriver.exe");
         //       driver =new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless","--disable-gpu");
              //  options.addArguments("--remote-debugging-port=9222");
              //  options.addArguments("--no-sandbox");
                //options.addArguments("--disable-setuid-sandbox");
		driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}

	@Test
	public void Google_Search_Test() throws InterruptedException, IOException {
        System.out.println("Starting the testing");
		driver.get("http://www.google.com/");
		Thread.sleep(2000);
		objgoogle = new GooglePage(driver);
		objgoogle.googleSearch("Facebook");
		objfb= new FBPage(driver);
		objfb.fbLogin("gandar@gmail.com", "35436");

	}

	@Test
	public void sample_Test()
	{
             System.out.println("This is passed test");
	}

	@AfterTest
	public void shutdown() {
	//	logger.info("The Fb Test is completed!Shutdowning the Test!!");
		driver.quit();
	}
}

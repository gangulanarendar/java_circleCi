package com.fb.web;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FbTest {

	WebDriver driver;
	
	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "pass")
	WebElement pwdId;
	
	Properties prop = new Properties();
	// Logger logger = Logger.getLogger("devpinoyLogger");

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		// System.setProperty("webdriver.chrome.driver","C:/Users/narendar.g.EXCERSHYD/Downloads/chromedriver_win32/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
	 	//options.addArguments("--headless", "--disable-gpu");
	  	options.addArguments("--browsertime.xvfb");
	  	
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();


	}
	


	
	@Test
	public void sample_Test() {
		System.out.println("This is passed test");
	}


	@Test
	public void loginTogmail() throws InterruptedException{
		   String URL = "https://www.google.com/intl/en_in/gmail/about/";
	        driver.get(URL);
	     //  driver.manage().window().maximize();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
	        driver.findElement(By.name("identifier")).sendKeys("test.letznav@gmail.com");
	        driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@id='password']/div/div/div/input")).sendKeys("letznav123");
	       
	        driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
	        Thread.sleep(5000);

	}
	
	@AfterTest
	public void shutdown() {
		// logger.info("The Fb Test is completed!Shutdowning the Test!!");
		driver.quit();
	}
}

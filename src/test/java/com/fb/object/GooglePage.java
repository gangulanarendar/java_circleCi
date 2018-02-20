package com.fb.object;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	WebDriver driver;
	boolean present = false;
	String getTestURL = "";
	String GmailURL = "http://www.gmail.com/";

	@FindBy(id = "gs_htif0")
	WebElement searchId;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement inputId;

	Logger logger = Logger.getLogger("devpinoyLogger");

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void googleSearch(String text) throws InterruptedException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		this.enterSearchText(text);
		logger.info("Text is entered Successfully!!");
		Thread.sleep(1000);
	}

	private void enterSearchText(String text) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		inputId.sendKeys(text);
		Thread.sleep(1000);
		inputId.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
}

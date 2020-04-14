package com.automation.TRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	
  @BeforeMethod
  public void openChromedriver() {
	    System.out.println("In @BeforeMethod");
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void closeDriver() {
	  System.out.println("In @AfterMethod");
	  driver.close();
  }
  
  public void quitDriver() {
	  driver.quit();
  }

}

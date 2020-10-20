package com.automation.TRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
  @BeforeMethod
  public void openDriver() {
	    System.out.println("In @BeforeMethod");
	    String os = System.getProperty("os.name");
	    String browserEnv = System.getenv("hcap_browser_type");
	    System.out.println("before = "+browserEnv);
	    if (browserEnv.isEmpty()) {
			browserEnv = "Chrome";
		}
	    System.out.println("after = "+browserEnv);
	    System.out.println("OS = "+os);
		switch (browserEnv) {
		case "Chrome":
    		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
    		System.out.println("opening chromedriver");
	    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    	if(os.contains("Mac OS")) {
	    		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	    	}
	    	System.out.println("chrome opened");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			DesiredCapabilities capabilitie = new DesiredCapabilities();
			capabilitie.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.out.println("opening firefoxdriver");
			System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver"); 
	    	if(os.contains("Mac OS")) {
	    		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
	    	}
			driver= new FirefoxDriver();
		    driver.manage().window().maximize();
			break;
		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//return driver; // or other browser drivers

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

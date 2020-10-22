package com.automation.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.TRunner.BaseClass;

public class GooglePage extends BaseClass {

	String baseUrl="https://google.com";
	
	@Test
	public void  verifyGoogleTitle() {
		System.out.println("In @Test1");
			driver.get(baseUrl);
			String actualTitle= driver.getTitle();
			String expectedTitle= "Google";
			Assert.assertEquals(actualTitle, expectedTitle);
	  }
	
	@Test
	public void searchStringOnGoogle() {
		System.out.println("In @Test2");
			driver.get(baseUrl);
			String textToSearch="Privacy";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Boolean result=driver.getPageSource().contains(textToSearch);
			System.out.println(result);
		    if (result == true)
		    {
		     System.out.print("Text is present\n");
		    }
		    else
		    {
		     System.out.print("Text is not present\n");
		    }
		    Assert.assertTrue((driver.getPageSource().contains(textToSearch)), "Text not found");

	  }
	
	@Test(enabled = false)
	public void googleSearchListOfSuggestions() {
		driver.get(baseUrl);
		String Search="amazon";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Search);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean ele = driver.findElement(By.xpath("//ul[@role=\"listbox\"]")).isDisplayed();
		if(ele) {
			System.out.println("List of suggestion present");
		}
		else {
			throw new RuntimeException("No suggestion provider");
		}
	}
	
	@Test
	public void searchAmazon() {
		driver.get(baseUrl);
		String Search="amazon";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Search);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle= driver.getTitle();
		String expectedTitle= "amazon - Google Search";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	//@Test
	public void searchAmazonAndNavigateToAmazonURL() {
		driver.get(baseUrl);
		String Search="amazon";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Search);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//h2/span[contains(text(),'Amazon.com')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		boolean cart = driver.findElement(By.id("nav-cart")).isDisplayed();
		if(cart) {
			System.out.println("On Amazon page");
		}
		else {
			throw new RuntimeException("No cart present");
		}
		
	}
	
	
	
	
}


package com.automation.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.TRunner.BaseClass;

public class GmailPage extends BaseClass {

	String baseUrl="https://gmail.com";
	
	@Test
	public void  verifyGmailTitle() {
		System.out.println("In @Test1");
			driver.get(baseUrl);
			driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("shrutigoldengirl@gmail.com");
			driver.findElement(By.xpath("//button/span[contains(text(),'Next')]")).click();
			String actualTitle= driver.getTitle();
			String expectedTitle= "Gmail";
			Assert.assertEquals(actualTitle, expectedTitle);
	  }
	
	@Test
	public void  searchString() {
		System.out.println("In @Test2");
			driver.get(baseUrl);
			String textToSearch="Sign ";
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
}

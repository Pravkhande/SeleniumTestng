package com.automation.webpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.TRunner.BaseClass;

public class LoadTest extends BaseClass {
    
	@Test(invocationCount = 5)
	public void loadTestThisWebsite() {

		driver.get("http://www.google.com");
		System.out.println("Page Title is " + driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());

	}
}

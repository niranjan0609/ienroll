package com.ieasy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.ieasy.base.ExtentTestManager;
import com.ieasy.base.TestBase;

public class TwoWheelerTest extends TestBase {
	
	private WebDriver driver;
	private String errorMessage = "please enter valid password.";
	private static ExtentTest test;
	

		@BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl() + "admin";
			driver.get(URL);
			test = ExtentTestManager.getTest();
		}
		
		

}

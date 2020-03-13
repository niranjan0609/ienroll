package com.ienroll.tests;
import java.util.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ienroll.base.ExtentTestManager;
import com.ienroll.base.TestBase;
import com.ienroll.pageobjects.EnrollmentPage;

import com.ienroll.utils.ExcelReader;

import org.testng.asserts.SoftAssert;



public class FCB extends TestBase{
private static final Logger log = LogManager.getLogger(FCB.class);
	
	private WebDriver driver;
	//LoginPage loginPage;
	Actions action;
	EnrollmentPage  enrollmentPage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		enrollmentPage = new EnrollmentPage(driver);
	}

	
	String xlFilePath = "E:\\Selenium\\iEnroll\\src\\test\\resources\\iEnroll_Data.xlsx";
	ExcelReader sheet = null;


	public ArrayList<FCBPOJO> testData(String xlFilePath, String sheetName) throws Exception {

		ArrayList<FCBPOJO> dataList = new ArrayList<FCBPOJO>();
	
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

	

		for (int i = 1; i < rows; i++) {
			FCBPOJO fcbPojo = new FCBPOJO();
			log.debug("Reading row - " +i);
			for (int j = 0; j < columns; j++) {
				log.debug("Reading columns - " +j);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("EmpID")) {
				    fcbPojo.setEmpID(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Password")) {
					fcbPojo.setPassword(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("SumInsured")) {
					fcbPojo.setSumInsured(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Premium")) {
					fcbPojo.setPremium(sheet.getCellData(sheetName, j, i));
				
				}
				
			}
			dataList.add(fcbPojo);
				
		}
		return dataList;
	}

	@DataProvider(name = "FCBData")
	public Object[][] enrollmentDataProvider() throws Exception {
		log.debug("Fetching test data ...");
		
		ArrayList<FCBPOJO> enrollmentDataList = testData(xlFilePath, "FCB");
		int j = enrollmentDataList.size();
		Object[][] obj = new Object[j][1];
		for (int i = 0; i < j; i++) {
			obj[i][0] = enrollmentDataList.get(i);
		}
		return obj;
	}

	
	
	@Test(dataProvider = "FCBData")
	public void fcbPortal(FCBPOJO pojoData) throws InterruptedException {

	
		log.debug("Test started...");
		ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter Emp ID & Password"); 
		enrollmentPage.enterEmpID(pojoData.getEmpID());
		enrollmentPage.enterPassword(pojoData.getPassword());
		enrollmentPage.clickOnSubmit();
		Thread.sleep(2000);
		enrollmentPage.clickonProceed();

		
		log.debug("Verify Sum Insured displayed on Portal");
		ExtentTestManager.getTest().log(Status.INFO, "Verifying Sum Insured displayed on Portal");
		String sumI = enrollmentPage.getSumInsured();
		String SumInsuredValue = sumI.trim();
		String premiumValue = enrollmentPage.getPremium();
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SumInsuredValue, pojoData.getSumInsured(), "Sum insured displayed on Portal is not correct");
		softAssert.assertEquals(premiumValue, pojoData.getPremium(), "Actual premium value not matching with expected value");
		
		
		  log.debug("Verifying Premium after adding Children");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium after adding Children"); 
		  enrollmentPage.AddSon(); 
		  enrollmentPage.AddDaughter();
		  String premchild = enrollmentPage.getPremium();
		  
		  String premaAftchild = premchild.trim(); 
		  
		  Thread.sleep(2000);
	
		  
		  softAssert.assertEquals(premaAftchild, pojoData.getPremium(), "Actual premium value not matching with expected value");
			
		  log.debug("Verifying Premium after adding Spouse");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium after adding Spouse"); 
		  enrollmentPage.AddSpouse(); 
		
		  String premSpouse = enrollmentPage.getPremium();
		  
		  String premaAftSpouse = premSpouse.trim(); 
		  
		  Thread.sleep(2000);
	
		
		  softAssert.assertEquals(premaAftSpouse, pojoData.getPremium(), "Actual premium value not matching with expected value");
			
		 
		 
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void testTearDown() {
		//To start a test from beginning
		enrollmentPage.deleteAllCookies();
		
		}
}


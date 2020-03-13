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



public class DCB extends TestBase{
private static final Logger log = LogManager.getLogger(DCB.class);
	
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


	public ArrayList<DCBPOJO> testData(String xlFilePath, String sheetName) throws Exception {

		ArrayList<DCBPOJO> dataList = new ArrayList<DCBPOJO>();
	
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

	

		for (int i = 1; i < rows; i++) {
			DCBPOJO dcbPojo = new DCBPOJO();
			log.debug("Reading row - " +i);
			for (int j = 0; j < columns; j++) {
				log.debug("Reading columns - " +j);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("EmpID")) {
					dcbPojo.setEmpID(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Password")) {
					dcbPojo.setPassword(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("SumInsured")) {
					dcbPojo.setSumInsured(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Premium")) {
					dcbPojo.setPremium(sheet.getCellData(sheetName, j, i));
				
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1 Lac TopUp Premium")) {
					dcbPojo.set1LacPremium(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 1 Lac")) {
					dcbPojo.setTotalTop1LacPremium(sheet.getCellData(sheetName, j, i));
					
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2 Lac TopUp Premium")) {
					dcbPojo.set2LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 2 Lac")) {
					dcbPojo.setTotalTop2LacPremium(sheet.getCellData(sheetName, j, i));	
				
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3 Lac TopUp Premium")) {
					dcbPojo.set3LacPremium(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 3 Lac")) {
					dcbPojo.setTotalTop3LacPremium(sheet.getCellData(sheetName, j, i));
				
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("4 Lac TopUp Premium")) {
					dcbPojo.set4LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 4 Lac")) {
					dcbPojo.setTotalTop4LacPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PIL Premium")) {
					dcbPojo.setPILPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Payable Premium PIL")) {
					dcbPojo.setTotalPILPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PIL Top Up Premium")) {
					dcbPojo.setTopUpPILPremium(sheet.getCellData(sheetName, j, i));	
				}
				
			}
			dataList.add(dcbPojo);
				
		}
		return dataList;
	}

	@DataProvider(name = "DCBData")
	public Object[][] enrollmentDataProvider() throws Exception {
		log.debug("Fetching test data ...");
		
		ArrayList<DCBPOJO> enrollmentDataList = testData(xlFilePath, "DCB");
		int j = enrollmentDataList.size();
		Object[][] obj = new Object[j][1];
		for (int i = 0; i < j; i++) {
			obj[i][0] = enrollmentDataList.get(i);
		}
		return obj;
	}

	
	
	@Test(dataProvider = "DCBData")
	public void dcbPortal(DCBPOJO pojoData) throws InterruptedException {

	
		log.debug("Test started...");
		ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password"); 
		enrollmentPage.enterEmpID(pojoData.getEmpID());
		enrollmentPage.enterPassword(pojoData.getPassword());
		enrollmentPage.clickOnSubmit();
		ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");
		Thread.sleep(2000);
		enrollmentPage.clickonProceed();

		
		log.debug("Verify Sum Insured displayed on Portal");
		ExtentTestManager.getTest().log(Status.INFO, "After Login, Verifying Sum Insured displayed on DCB Portal");
		String sumI = enrollmentPage.getSumInsured();
		String SumInsuredValue = sumI.trim();
		String premV = enrollmentPage.getPremium();
		String premiumValue = premV.replaceAll("Rs.", "").replaceAll("\\.0*$", "").trim();
		
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SumInsuredValue, pojoData.getSumInsured(), "Sum insured displayed on Portal is not correct");
		ExtentTestManager.getTest().log(Status.INFO, "SI Sum Insured displayed on correctly on Portal");
		softAssert.assertEquals(premiumValue, pojoData.getPremium(), "Actual premium value not matching with expected value");
		ExtentTestManager.getTest().log(Status.INFO, "SUM Insured displayed on Portal is matching with the SI on DCB policy note");
		
		//
		log.debug("Verifying Premium when Top Up sum insured is 1 lac");
		ExtentTestManager.getTest().log(Status.INFO, "Verifying Premium when Top Up sum insured is 1 lac");
		enrollmentPage.selectTopUpSI1Lac();
		Thread.sleep(2000);
		
		String topprem1 = enrollmentPage.getTopPremValue();
		String topPremium1Lac = topprem1.replaceAll("Rs.", "").replaceAll("\\.0*$", "").replace(",", "").trim();
		String TotPrem1 = enrollmentPage.getTotalPremiumPayabale();
		String TotalTopPremium1Lac = TotPrem1.trim();
	  
		
		//softAssert.assertEquals(topSumInsuredValue1Lac, pojoData.get1LacSumInsured(), "Top up Sum insured value for 1 lac not correct");
		softAssert.assertEquals(topPremium1Lac, pojoData.get1LacPremium() , "Actual premium value not matching for 1 lac topup SI");
		softAssert.assertEquals(TotalTopPremium1Lac, pojoData.getTotalTop1LacPremium(), "Total Actual premium value including GST not matching for 1 lac topup SI");

		
		
		
		  log.debug("Verifying Premium when Top Up sum insured is 2 lac");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when Top Up sum insured is 2 lac");
		  enrollmentPage.selectTopUpSI2Lac();
		  Thread.sleep(2000);
		  String topprem2 = enrollmentPage.getTopPremValue(); 
		  String topPremium2Lac = topprem2.trim();
		  String TotPrem2 = enrollmentPage.getTotalPremiumPayabale();
		  String TotalTopPremium2Lac = TotPrem2.trim();
		  
		
		  softAssert.assertEquals(topPremium2Lac, pojoData.get2LacPremium(),"Actual premium value not matching for 2 lac topup SI");
		  softAssert.assertEquals(TotalTopPremium2Lac,pojoData.getTotalTop2LacPremium(),"Actual total premium value including GST not matching for 2 lac topup SI");
		  
		  log.debug("Verifying Premium when Top Up sum insured is 3 lac");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when Top Up sum insured is 3 lac");
		  enrollmentPage.selectTopUpSI3Lac();
		  Thread.sleep(2000);
		  String topprem3 = enrollmentPage.getTopPremValue(); 
		  String topPremium3Lac = topprem3.trim();
		  String TotPrem3 = enrollmentPage.getTotalPremiumPayabale(); 
		  String TotalTopPremium3Lac = TotPrem3.trim();
		  
		  
		 
		  softAssert.assertEquals(topPremium3Lac, pojoData.get3LacPremium(), "Actual premium value not matching for 3 lac topup SI");
		  softAssert.assertEquals(TotalTopPremium3Lac, pojoData.getTotalTop3LacPremium(),"Actual total premium value including GST not matching for 3 lac topup SI");
		  
		  log.debug("Verifying Premium when Top Up sum insured is 4 lac");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when Top Up sum insured is 4 lac"); 
		  enrollmentPage.selectTopUpSI4Lac();
		  Thread.sleep(2000);
		  String topprem4 = enrollmentPage.getTopPremValue();
		  String topPremium4Lac = topprem4.trim();
		  String TotPrem4 = enrollmentPage.getTotalPremiumPayabale();
		  String TotalTopPremium4Lac = TotPrem4.trim();
		  
		  
		//  softAssert.assertEquals(topSumInsuredValue4Lac, pojoData.get4LacSumInsured(), "Top up Sum insured value for 4 lac not correct");
		  softAssert.assertEquals(topPremium4Lac, pojoData.get4LacPremium(), "Actual premium value not matching for 4 lac topup SI");
		  softAssert.assertEquals(TotalTopPremium4Lac,pojoData.getTotalTop4LacPremium(),"Actual total premium value including GST not matching for 4 lac topup SI");
		  
		  log.debug("Verifying Premium after adding PIL");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium after adding PIL"); 
		  enrollmentPage.clearTopUpSI();
		  enrollmentPage.AddFIL(); 
		  enrollmentPage.AddMIL();
		  
		  String pilPrem = enrollmentPage.getParentalPremium(); 
		  String parentPremium = pilPrem.trim(); 
		  String totPremPIL = enrollmentPage.getTotalPremiumPayabale();
		  String totalPremiumPIL = totPremPIL.trim();
		  
		  softAssert.assertEquals(parentPremium, pojoData.getPILPremium(),"PIL Premium not matching"); 
		  softAssert.assertEquals(totalPremiumPIL,
		  pojoData.getTotalPILPremium(), "Total Premium payable not matching");
		  
		  log.debug("Verifying Premium when PIL Top Up is taken");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when PIL Top Up is taken");
		  
		  enrollmentPage.selectPILTopSI(); 
		  String pilTopPrem = enrollmentPage.getPILTopupPremium(); 
		  String pILTopUpPremium = pilTopPrem.trim();
		  
		  
		  
		  String totPremPILTop = enrollmentPage.getTotalPremiumPayabale();
		  String totalTopUpPremiumPIL = totPremPILTop.trim();
		  
		  
		  
		  softAssert.assertEquals(pILTopUpPremium, pojoData.getTopUpPILPremium(),"PIL TopUp Premium not matching");
		  softAssert.assertEquals(totalTopUpPremiumPIL,pojoData.getTotalTopUpPILPremium(), "Total Premium payable not matching");
		 
		 
		 
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void testTearDown() {
		//To start a test from beginning
		enrollmentPage.deleteAllCookies();
		
		}
}

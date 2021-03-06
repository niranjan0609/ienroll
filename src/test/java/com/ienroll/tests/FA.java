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



public class FA extends TestBase{
private static final Logger log = LogManager.getLogger(FA.class);
	
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


	public ArrayList<FAPOJO> testData(String xlFilePath, String sheetName) throws Exception {

		ArrayList<FAPOJO> dataList = new ArrayList<FAPOJO>();
	
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

	

		for (int i = 1; i < rows; i++) {
			FAPOJO faPojo = new FAPOJO();
			log.debug("Reading row - " +i);
			for (int j = 0; j < columns; j++) {
				log.debug("Reading columns - " +j);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("EmpID")) {
					faPojo.setEmpID(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Password")) {
					faPojo.setPassword(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("SumInsured")) {
					faPojo.setSumInsured(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Premium")) {
					faPojo.setPremium(sheet.getCellData(sheetName, j, i));
				
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1 Lac TopUp Premium")) {
					faPojo.set1LacPremium(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 1 Lac")) {
					faPojo.setTotalTop1LacPremium(sheet.getCellData(sheetName, j, i));
					
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2 Lac TopUp Premium")) {
					faPojo.set2LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 2 Lac")) {
					faPojo.setTotalTop2LacPremium(sheet.getCellData(sheetName, j, i));	
				
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3 Lac TopUp Premium")) {
					faPojo.set3LacPremium(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 3 Lac")) {
					faPojo.setTotalTop3LacPremium(sheet.getCellData(sheetName, j, i));
				
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("5 Lac TopUp Premium")) {
					faPojo.set5LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 5 Lac")) {
					faPojo.setTotalTop5LacPremium(sheet.getCellData(sheetName, j, i));	
					
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("7 Lac TopUp Premium")) {
					faPojo.set7LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Premium Payable 7 Lac")) {
				    faPojo.setTotalTop7LacPremium(sheet.getCellData(sheetName, j, i));
				    
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PIL Premium")) {
					faPojo.setPILPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Total Payable Premium PIL")) {
					faPojo.setTotalPILPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PIL Top Up Premium")) {
					faPojo.setTopUpPILPremium(sheet.getCellData(sheetName, j, i));	
				}
				
			}
			dataList.add(faPojo);
				
		}
		return dataList;
	}

	@DataProvider(name = "FAData")
	public Object[][] enrollmentDataProvider() throws Exception {
		log.debug("Fetching test data ...");
		
		ArrayList<FAPOJO> enrollmentDataList = testData(xlFilePath, "FA");
		int j = enrollmentDataList.size();
		Object[][] obj = new Object[j][1];
		for (int i = 0; i < j; i++) {
			obj[i][0] = enrollmentDataList.get(i);
		}
		return obj;
	}

	
	
	@Test(dataProvider = "FAData")
	public void faPortal(FAPOJO pojoData) throws InterruptedException {

	
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
		//
		log.debug("Verifying Premium when Top Up sum insured is 1 lac");
		ExtentTestManager.getTest().log(Status.INFO, "Verifying Premium when Top Up sum insured is 1 lac");
		enrollmentPage.selectTopUpSI1Lac();
		Thread.sleep(2000);
		String topprem1 = enrollmentPage.getTopPremValue();
		String topPremium1Lac = topprem1.trim();
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
		  
		  log.debug("Verifying Premium when Top Up sum insured is 5 lac");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when Top Up sum insured is 5 lac"); 
		  enrollmentPage.selectTopUpSI5Lac();
		  Thread.sleep(2000);
		  String topprem5 = enrollmentPage.getTopPremValue();
		  String topPremium5Lac = topprem5.trim();
		  String TotPrem5 = enrollmentPage.getTotalPremiumPayabale();
		  String TotalTopPremium5Lac = TotPrem5.trim();
		  
		  
		//  softAssert.assertEquals(topSumInsuredValue4Lac, pojoData.get4LacSumInsured(), "Top up Sum insured value fo 7 lac not correct");r
		  softAssert.assertEquals(topPremium5Lac, pojoData.get5LacPremium(), "Actual premium value not matching for 7 lac topup SI");
		  softAssert.assertEquals(TotalTopPremium5Lac,pojoData.getTotalTop5LacPremium(),"Actual total premium value including GST not matching for 7 lac topup SI");
		  
		  log.debug("Verifying Premium when Top Up sum insured is 7 lac");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium when Top Up sum insured is 7 lac"); 
		  enrollmentPage.selectTopUpSI7Lac();
		  Thread.sleep(2000);
		  String topprem7 = enrollmentPage.getTopPremValue();
		  String topPremium7Lac = topprem5.trim();
		  String TotPrem7 = enrollmentPage.getTotalPremiumPayabale();
		  String TotalTopPremium7Lac = TotPrem7.trim();
		  
		  
		//  softAssert.assertEquals(topSumInsuredValue4Lac, pojoData.get4LacSumInsured(), "Top up Sum insured value for 4 lac not correct");
		  softAssert.assertEquals(topPremium7Lac, pojoData.get5LacPremium(), "Actual premium value not matching for 7 lac topup SI");
		  softAssert.assertEquals(TotalTopPremium7Lac,pojoData.getTotalTop5LacPremium(),"Actual total premium value including GST not matching for 7 lac topup SI");
		  
		  
		  log.debug("Verifying Premium after adding PIL");
		  ExtentTestManager.getTest().log(Status.INFO,"Verifying Premium after adding PIL"); 
		  enrollmentPage.clearTopUpSI();
		  enrollmentPage.AddSpouse();
		  enrollmentPage.AddDaughter();
		  enrollmentPage.AddSon();
		  enrollmentPage.AddFather();
		  enrollmentPage.AddMother();
		  enrollmentPage.AddFIL(); 
		  enrollmentPage.AddMIL();
		  
		  String pilPrem = enrollmentPage.getParentalPremium(); 
		  String parentPremium = pilPrem.trim(); 
		  String totPremPIL = enrollmentPage.getTotalPremiumPayabale();
		  String totalPremiumPIL = totPremPIL.trim();
		  
		  softAssert.assertEquals(parentPremium, pojoData.getPILPremium(),
		  "PIL Premium not matching"); softAssert.assertEquals(totalPremiumPIL,
		  pojoData.getTotalPILPremium(), "Total Premium payable not matching");
		  
		  log.debug("Verifying Premium when PIL Top Up is taken");
		  ExtentTestManager.getTest().log(Status.INFO,
		  "Verifying Premium when PIL Top Up is taken");
		  
		  enrollmentPage.selectPILTopSI(); String pilTopPrem =
		  enrollmentPage.getPILTopupPremium(); String pILTopUpPremium =
		  pilTopPrem.trim();
		  
		  
		  
		  String totPremPILTop = enrollmentPage.getTotalPremiumPayabale(); String
		  totalTopUpPremiumPIL = totPremPILTop.trim();
		  
		  
		  
		  softAssert.assertEquals(pILTopUpPremium, pojoData.getTopUpPILPremium(),
		  "PIL TopUp Premium not matching");
		  softAssert.assertEquals(totalTopUpPremiumPIL,
		  pojoData.getTotalTopUpPILPremium(), "Total Premium payable not matching");
		 
		 
		 
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void testTearDown() {
		//To start a test from beginning
		enrollmentPage.deleteAllCookies();
		
		}
}


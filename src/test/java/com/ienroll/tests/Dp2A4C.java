package com.ieasy.tests;
import com.ieasy.base.TestBase;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ieasy.base.ExtentTestManager;
import com.ieasy.pageobjects.HealthPage;
import com.ieasy.pageobjects.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ieasy.utils.ExcelReader;
import org.testng.asserts.SoftAssert;
public class Dp2A4C extends TestBase {

private static final Logger log = LogManager.getLogger(Dp2APlan.class);
	
	private WebDriver driver;
	private static ExtentTest test;
	HomePage homePage;
	Actions action;
	HealthPage healthPage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		test = ExtentTestManager.getTest();
	}

	String xlFilePath = "E:\\Selenium\\New IEA\\InsureEasyAutomation\\src\\test\\resources\\InsureEasy_ABHI_Data.xlsx";
	ExcelReader sheet = null;

	public ArrayList<HealthPOJO> testData(String xlFilePath, String sheetName) throws Exception {

		ArrayList<HealthPOJO> dataList = new ArrayList<HealthPOJO>();
		// Object[][] excelData = null;
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

		// excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			HealthPOJO hPojo = new HealthPOJO();
			for (int j = 0; j < columns; j++) {
				// excelData[i - 1][j] = sheet.getCellData(sheetName, j, i);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PinCode")) {
					hPojo.setPinCode(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Mobile Number")) {
					hPojo.setMobileNumber(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Email ID")) {
					hPojo.setEmailId(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Self Age")) {
					hPojo.setSelfAge(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Wife Age")) {
					hPojo.setWifeAge(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Daughter Age")) {
					hPojo.setDaughterAge(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Son Age")) {
					hPojo.setSonAge(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Daughter2 Age")) {
					hPojo.setDaughter2Age(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Son2 Age")) {
					hPojo.setSon2Age(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("300000 SI")) {
					hPojo.set3LacSumInsured(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("300000 Premium")) {
					hPojo.set3LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("400000 SI")) {
					hPojo.set4lacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("400000 Premium")) {
					hPojo.set4LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("500000 SI")) {
					hPojo.set5LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("500000 Premium")) {
					hPojo.set5LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("700000 SI")) {
					hPojo.set7LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("700000 Premium")) {
					hPojo.set7LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1000000 SI")) {
					hPojo.set10LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1000000 Premium")) {
					hPojo.set10LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1500000 SI")) {
					hPojo.set15LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1500000 Premium")) {
					hPojo.set15LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2000000 SI")) {
					hPojo.set20LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2000000 Premium")) {
					hPojo.set20LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2500000 SI")) {
					hPojo.set25LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2500000 Premium")) {
					hPojo.set25LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3000000 SI")) {
					hPojo.set30LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3000000 Premium")) {
					hPojo.set30LacPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("4000000 SI")) {
					hPojo.set40LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("4000000 Premium")) {
					hPojo.set40LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("5000000 SI")) {
					hPojo.set50LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("5000000 Premium")) {
					hPojo.set50LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("7500000 SI")) {
					hPojo.set75LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("7500000 Premium")) {
					hPojo.set75LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("10000000 SI")) {
					hPojo.set100LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("10000000 Premium")) {
					hPojo.set100LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("15000000 SI")) {
					hPojo.set150LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("15000000 Premium")) {
					hPojo.set150LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("20000000 SI")) {
					hPojo.set200LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("20000000 Premium")) {
					hPojo.set200LacPremium(sheet.getCellData(sheetName, j, i));
				}
				
			}
			dataList.add(hPojo);
		}
		return dataList;
	}

	@DataProvider(name = "abhiinsuranceData")
	public Object[][] healthDataProvider() throws Exception {
		log.debug("Fetching test data ...");
		ArrayList<HealthPOJO> healthDataList = testData(xlFilePath, "Dp2A4C");
		int j = healthDataList.size();
		Object[][] obj = new Object[j][1];
		for (int i = 0; i < j; i++) {
			obj[i][0] = healthDataList.get(i);
		}
		return obj;
	}

	
	@BeforeMethod
	public void testSetUp() {
		homePage = new HomePage(driver);
		action = new Actions(driver);
		healthPage = homePage.clickHealth();
	}
	
	@Test(dataProvider = "abhiinsuranceData")
	public void diamondPlanIndividual(HealthPOJO pojoData) throws InterruptedException {

		healthPage.clickHealthInsurance();
		String part1 = pojoData.getPinCode().substring(0, 4);
		String part2 = pojoData.getPinCode().substring(4);
		healthPage.enterPinCode(part1, true);
		Thread.sleep(3000);
		healthPage.enterPinCode(part2, false);
		healthPage.selectFirstPinValue();
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		healthPage.enterMobileNo(pojoData.getMobileNumber());
		healthPage.emailId(pojoData.getEmailId());
		healthPage.clickNextBtn();
		Thread.sleep(3000);
	
	    healthPage.enterSelfAge(pojoData.getSelfAge());
        healthPage.enterWifeAge(pojoData.getWifeAge());
        //healthPage.enterDaughterAge(pojoData.getDaughterAge());
        //healthPage.enterSonAge(pojoData.getSonAge());
        healthPage.clickAddMembers();
        healthPage.clickAddDaughter();
        Thread.sleep(3000);
        
        //healthPage.enterDaughter2Age(pojoData.getDaughter2Age());
    
        healthPage.clickAddMembers();
        healthPage.clickAddSon();
      
        //healthPage.enterSon2Age(pojoData.getSon2Age());
        Thread.sleep(3000);
		healthPage.clickGetQuote();
		
		log.debug("Verify default sum assured premium 3lac");
		String sumI = healthPage.getSumAssuredValue();
		String SumInsuredValue = sumI.trim();
		String premiumValue = healthPage.getQuoteValue();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SumInsuredValue, pojoData.get3LacSumInsured(), "Sum insured value not correct");
		softAssert.assertEquals(premiumValue, pojoData.get3LacPremium(), "Actual premium value not matching with expected");
		
		log.debug("Verifying sum assured premium 4 lac");
		healthPage.changeSI(pojoData.get4LacSumInsured());
	    String lacSI4 = healthPage.getSumAssuredValue();
		String SumInsured4lac = lacSI4.trim();
		String premium4lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured4lac, pojoData.get4LacSumInsured(), "Sum insured value for 4 lac not correct");
		softAssert.assertEquals(premium4lac, pojoData.get4LacPremium(), "Actual premium value not matching for 4 lac with expected");
		
		log.debug("Verifying sum assured premium 5 lac");
		healthPage.changeSI(pojoData.get5LacSumInsured());
	    String lacSI5 = healthPage.getSumAssuredValue();
		String SumInsured5lac = lacSI5.trim();
		String premium5lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured5lac, pojoData.get5LacSumInsured(), "Sum insured value for 5 lac not correct");
		softAssert.assertEquals(premium5lac, pojoData.get5LacPremium(), "Actual premium value not matching for 5 lac with expected");
		
		log.debug("Change sum assured from search bar - 5lac to 10lac");
		healthPage.selectSumInsuredFromSearchInput("500000-1000000");
		
		log.debug("Verifying sum assured premium 7 lac");
		Thread.sleep(6000);
		healthPage.changeSI(pojoData.get7LacSumInsured());
		
	    String lacSI7 = healthPage.getSumAssuredValue();
		String SumInsured7lac = lacSI7.trim();
		String premium7lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured7lac, pojoData.get7LacSumInsured(), "Sum insured value for 7 lac not correct");
		softAssert.assertEquals(premium7lac, pojoData.get7LacPremium(), "Actual premium value not matching for 7 lac with expected");
		
		log.debug("Verifying sum assured premium 10 lac");
		Thread.sleep(6000);
		healthPage.changeSI(pojoData.get10LacSumInsured());
	    String lacSI10 = healthPage.getSumAssuredValue();
		String SumInsured10lac = lacSI10.trim();
		String premium10lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured10lac, pojoData.get10LacSumInsured(), "Sum insured value for 10 lac not correct");
		softAssert.assertEquals(premium10lac, pojoData.get10LacPremium(), "Actual premium value not matching for 10 lac with expected");
		
		log.debug("Change sum assured from search bar - 10lac - 15lac");
		healthPage.selectSumInsuredFromSearchInput("1000000-1500000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 15 lac");
		healthPage.changeSI(pojoData.get15LacSumInsured());
	    String lacSI15 = healthPage.getSumAssuredValue();
		String SumInsured15lac = lacSI15.trim();
		String premium15lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured15lac, pojoData.get15LacSumInsured(), "Sum insured value for 15 lac not correct");
		softAssert.assertEquals(premium15lac, pojoData.get15LacPremium(), "Actual premium value not matching for 15 lac with expected");
		
		log.debug("Change sum assured from search bar - 15lac - 20lac");
		healthPage.selectSumInsuredFromSearchInput("1500000-2000000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 20 lac");
		healthPage.changeSI(pojoData.get20LacSumInsured());
	    String lacSI20 = healthPage.getSumAssuredValue();
		String SumInsured20lac = lacSI20.trim();
		String premium20lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured20lac, pojoData.get20LacSumInsured(), "Sum insured value for 20 lac not correct");
		softAssert.assertEquals(premium20lac, pojoData.get20LacPremium(), "Actual premium value not matching for 20 lac with expected");
		
		log.debug("Change sum assured from search bar - 20lac - 25lac");
		healthPage.selectSumInsuredFromSearchInput("2000000-2500000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 25 lac");
		healthPage.changeSI(pojoData.get25LacSumInsured());
	    String lacSI25 = healthPage.getSumAssuredValue();
		String SumInsured25lac = lacSI25.trim();
		String premium25lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured25lac, pojoData.get25LacSumInsured(), "Sum insured value for 25 lac not correct");
		softAssert.assertEquals(premium25lac, pojoData.get25LacPremium(), "Actual premium value not matching for 25 lac with expected");
		
		log.debug("Change sum assured from search bar - 25lac - 30lac");
		healthPage.selectSumInsuredFromSearchInput("2500000-3000000");
		Thread.sleep(3000);
		log.debug("Verifying sum assured premium 30 lac");
		healthPage.changeSI(pojoData.get30LacSumInsured());
	    String lacSI30 = healthPage.getSumAssuredValue();
		String SumInsured30lac = lacSI30.trim();
		String premium30lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured30lac, pojoData.get30LacSumInsured(), "Sum insured value for 30 lac not correct");
		softAssert.assertEquals(premium30lac, pojoData.get30LacPremium(), "Actual premium value not matching for 30 lac with expected");
		
		log.debug("Change sum assured from search bar - 35lac - 40lac");
		healthPage.selectSumInsuredFromSearchInput("3500000-4000000");
		Thread.sleep(3000);
		log.debug("Verifying sum assured premium 40 lac");
		healthPage.changeSI(pojoData.get40LacSumInsured());
	    String lacSI40 = healthPage.getSumAssuredValue();
		String SumInsured40lac = lacSI40.trim();
		String premium40lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured40lac, pojoData.get40LacSumInsured(), "Sum insured value for 40 lac not correct");
		softAssert.assertEquals(premium40lac, pojoData.get40LacPremium(), "Actual premium value not matching for 40 lac with expected");
		
		log.debug("Change sum assured from search bar - 45lac - 50lac");
		healthPage.selectSumInsuredFromSearchInput("4500000-5000000");
		Thread.sleep(5000);
		log.debug("Verifying sum assured premium 50 lac");
		healthPage.changeSI(pojoData.get50LacSumInsured());
		Thread.sleep(3000);
	    String lacSI50 = healthPage.getSumAssuredValue();
		String SumInsured50lac = lacSI50.trim();
		String premium50lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured50lac, pojoData.get50LacSumInsured(), "Sum insured value for 50 lac not correct");
		softAssert.assertEquals(premium50lac, pojoData.get50LacPremium(), "Actual premium value not matching for 50 lac with expected");
		
		log.debug("Change sum assured from search bar - 50lac - 75lac");
		healthPage.selectSumInsuredFromSearchInput("5000000-7500000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 75 lac");
		healthPage.changeSI(pojoData.get75LacSumInsured());
	    String lacSI75 = healthPage.getSumAssuredValue();
		String SumInsured75lac = lacSI75.trim();
		String premium75lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured75lac, pojoData.get75LacSumInsured(), "Sum insured value for 75 lac not correct");
		softAssert.assertEquals(premium75lac, pojoData.get75LacPremium(), "Actual premium value not matching for 75 lac with expected");
		
		log.debug("Change sum assured from search bar - 75lac - 100lac");
		healthPage.selectSumInsuredFromSearchInput("7500000-10000000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 100 lac");
		healthPage.changeSI(pojoData.get100LacSumInsured());
	    String lacSI100 = healthPage.getSumAssuredValue();
		String SumInsured100lac = lacSI100.trim();
		String premium100lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured100lac, pojoData.get100LacSumInsured(), "Sum insured value for 100 lac not correct");
		softAssert.assertEquals(premium100lac, pojoData.get100LacPremium(), "Actual premium value not matching for 100 lac with expected");
		
		log.debug("Change sum assured from search bar - 125lac - 150lac");
		healthPage.selectSumInsuredFromSearchInput("12500000-15000000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 150 lac");
		healthPage.changeSI(pojoData.get150LacSumInsured());
	    String lacSI150 = healthPage.getSumAssuredValue();
		String SumInsured150lac = lacSI150.trim();
		String premium150lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured150lac, pojoData.get150LacSumInsured(), "Sum insured value for 150 lac not correct");
		softAssert.assertEquals(premium150lac, pojoData.get150LacPremium(), "Actual premium value not matching for 150 lac with expected");
		
		log.debug("Change sum assured from search bar - 175lac - 200lac");
		healthPage.selectSumInsuredFromSearchInput("17500000-20000000");
		Thread.sleep(4000);
		log.debug("Verifying sum assured premium 200 lac");
		healthPage.changeSI(pojoData.get200LacSumInsured());
	    String lacSI200 = healthPage.getSumAssuredValue();
		String SumInsured200lac = lacSI200.trim();
		String premium200lac = healthPage.getQuoteValue();
		
		softAssert.assertEquals(SumInsured200lac, pojoData.get200LacSumInsured(), "Sum insured value for 200 lac not correct");
		softAssert.assertEquals(premium200lac, pojoData.get200LacPremium(), "Actual premium value not matching for 200 lac with expected");
		
		
		
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void testTearDown() {
		//To start a test from beginning
		healthPage.deleteAllCookies();
		healthPage.deleteCookieQuoteId();
		homePage = healthPage.backHome();
	}
}

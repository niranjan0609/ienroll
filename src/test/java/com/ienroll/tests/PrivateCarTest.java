package com.ieasy.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ieasy.base.ExtentTestManager;
import com.ieasy.base.TestBase;
import com.ieasy.pageobjects.HomePage;
import com.ieasy.pageobjects.PrivateCarPage;
import com.ieasy.utils.ExcelReader;

public class PrivateCarTest extends TestBase {

	private WebDriver driver;
	private String errorMessage = "please enter valid password.";
	private static ExtentTest test;


	@BeforeClass
	public void setUp() {
		driver = getDriver();
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		test = ExtentTestManager.getTest();
	}

	String xlFilePath = "E:/Selenium/InsureEasyData.xlsx";
	ExcelReader sheet = null;

	public ArrayList<PrivateCarPOJO> testData(String xlFilePath, String sheetName) throws Exception {
		PrivateCarPOJO carPojo = new PrivateCarPOJO();
		ArrayList<PrivateCarPOJO> dataList = new ArrayList<PrivateCarPOJO>();
		// Object[][] excelData = null;
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

		// excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// excelData[i - 1][j] = sheet.getCellData(sheetName, j, i);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Name")) {
					carPojo.setPreviousPolicyName(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Number")) {
					carPojo.setPreviousPolicyNumber(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Date")) {
					carPojo.setPreviousPolicyDate(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Month")) {
					carPojo.setPreviousPolicyMonth(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Year")) {
					carPojo.setPreviousPolicyYear(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Did You Claimed")) {
					carPojo.setDidYouClaimed(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("No Claim Bonus")) {
					carPojo.setNoClaimBonus(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Car Registration No")) {
					carPojo.setCarRegistrationNo(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Reg Date")) {
					carPojo.setRegDate(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Reg Month")) {
					carPojo.setRegMonth(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Reg Year")) {
					carPojo.setRegYear(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Car Model")) {
					carPojo.setCarModel(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Fuel Type")) {
					carPojo.setFuelType(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Car Variant")) {
					carPojo.setCarVariant(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Car Mfg Month")) {
					carPojo.setCarMfgMonth(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Car Mfg Year")) {
					carPojo.setCarMfgYear(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("email or mobile")) {
				carPojo.setEmailorMobile(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Full Name for Reg")) {
				carPojo.setFullnameForReg(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Email for Reg")) {
				carPojo.setEmailForReg(sheet.getCellData(sheetName, j, i));
			    } else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("First Name")) {
					carPojo.setFirstName(sheet.getCellData(sheetName, j, i));
			    } else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Last Name")) {					
			    	carPojo.setLastName(sheet.getCellData(sheetName, j, i));
			    } else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Gender")) {
					carPojo.setGender(sheet.getCellData(sheetName, j, i));	
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("DOB Date")) {
				carPojo.setDOBDate(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("DOB Month")) {
				carPojo.setDOBMonth(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Previous Policy Year")) {
				carPojo.setDOBYear(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PAN Number")) {
				carPojo.setPANNumber(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Aadhar Number")) {
				carPojo.setAadharNumber(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Email of Proposer")) {
				carPojo.setEmailofProposer(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Mobile of Proposer")) {
				carPojo.setMobileOfProposer(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Address")) {
				carPojo.setAddress(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("State")) {
				carPojo.setState(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("City")) {
				carPojo.setCity(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Pin No")) {
				carPojo.setPinNo(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Fuel Type Proposer")) {
				carPojo.setFuelTypeOnPropPage(sheet.getCellData(sheetName, j, i));	
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Engine No")) {
				carPojo.setEngineNo(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Chassis No")) {
				carPojo.setChassisNo(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Nominee Name")) {
				carPojo.setNomineeName(sheet.getCellData(sheetName, j, i));	
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Nominee Age")) {
				carPojo.setNomineeAge(sheet.getCellData(sheetName, j, i));
			} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Nominee Relation")) {
				carPojo.setNomineeRelation(sheet.getCellData(sheetName, j, i));
            }
			dataList.add(carPojo);
		}
		return dataList;
	}
		return dataList;
	}
	
	  @DataProvider(name="insuranceData")
	  public Object[][] privateCarDataProvider() throws Exception {
		  ArrayList<PrivateCarPOJO> privateCarDataList = testData(xlFilePath, "Sheet1");
		  int j = privateCarDataList.size();
		  Object[][] obj = new Object[j][1];
		  for (int i=0;i<j;j++) {
			  obj[i][0] = privateCarDataList.get(i);
		  }
		return obj;
		  
	  }

	@Test(dataProvider = "insuranceData")
	public void testPrivateCar(PrivateCarPOJO pojoData) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		PrivateCarPage privateCarPage = homePage.clickPrivateCar();

		privateCarPage.selectInsurer(pojoData.getPreviousPolicyName());
		privateCarPage.enterPolicyNumber(pojoData.getPreviousPolicyNumber());
		privateCarPage.enterPolicyEndDate(pojoData.getPreviousPolicyDate(), pojoData.getPreviousPolicyMonth(), pojoData.getPreviousPolicyYear());
		privateCarPage.didYouclaimedInPreviousPolicy(pojoData.getDidYouClaimed(), pojoData.getNoClaimBonus());
		privateCarPage.clickPolicyNextBtn();
		privateCarPage.enterCarRegistrationNo(pojoData.getCarRegistrationNo());
        privateCarPage.enterRegistrationDate(pojoData.getRegDate(), pojoData.getRegMonth(), pojoData.getRegYear());
        privateCarPage.clickRegistrationNextBtn();
        privateCarPage.enterCarModel(pojoData.getCarModel());
        Thread.sleep(3000);
        privateCarPage.fuelType(pojoData.getFuelType());
        privateCarPage.selectVariant(pojoData.getCarVariant());
        privateCarPage.enterManufacturingDate(pojoData.getCarMfgMonth(), pojoData.getCarMfgYear());
        privateCarPage.clickViewQuotes();
        Thread.sleep(3000);
       /* privateCarPage.clickUiiccQuote();
        Thread.sleep(3000);
        privateCarPage.enterEmailOrMobile(pojoData.getEmailorMobile());
        Thread.sleep(3000);
        privateCarPage.enterFullNameForReg(pojoData.getFullnameForReg());
        privateCarPage.enterEmailForReg(pojoData.getEmailForReg());
        privateCarPage.enterPasswordForReg(pojoData.getPasswordForReg());
        privateCarPage.enterFirstName(pojoData.getFirstName());
        privateCarPage.enterLastName(pojoData.getLastName());
        privateCarPage.selectGender(pojoData.getGender());
        privateCarPage.selectDOB(pojoData.getDOBDate(), pojoData.getDOBMonth(), pojoData.getDOBYear());
        privateCarPage.enterPANNumber(pojoData.getPANNumber());
        privateCarPage.enterAadharNumber(pojoData.getAadharNumber());
        privateCarPage.enterEmailOfProposer(pojoData.getEmailofProposer());
        privateCarPage.enterMobileOfProposer(pojoData.getMobileOfProposer());
        privateCarPage.enterAddress(pojoData.getAddress());
        privateCarPage.selectState(pojoData.getState());
        privateCarPage.selectCity(pojoData.getCity());
        privateCarPage.enterPinNo(pojoData.getPinNo());
        privateCarPage.clickOnVehicleDetails();
        Thread.sleep(3000);
        privateCarPage.selectFuelTypeOnPropPage(pojoData.getFuelTypeOnPropPage());
        privateCarPage.enterEngineNo(pojoData.getEngineNo());
        privateCarPage.enterChassisNo(pojoData.getChassisNo());
        privateCarPage.clickOnNomineeDetails();
        Thread.sleep(3000);
        privateCarPage.enterNomineeName(pojoData.getNomineeName());
        privateCarPage.enterNomineeAge(pojoData.getNomineeAge());
        privateCarPage.enterNomineeRelation(pojoData.getNomineeRelation());
        privateCarPage.clickOnReview();
        Thread.sleep(3000);
        privateCarPage.clickOnGetPoposalQuote();
        Thread.sleep(3000);
        privateCarPage.clickOnMakePayment();*/
        

	}

}

package com.ienroll.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ienroll.tests.DCB;

import java.util.List;

public class EnrollmentPage {

	private static final Logger log = LogManager.getLogger(EnrollmentPage.class);

	private WebDriver driver;
	private WebDriverWait wait;


	private By  empIdTxt = By.id("txtUsrName");
	private By  passwordTxt = By.id("txtPassword");
	private By  submitTxt = By.id("btnLogin");
	private By  proceedTxt = By.xpath("//*[@id=\"SnapShot\"]/div[2]/div/button");
	private By  bSITxt = By.xpath("//*[@id=\"spnBsi\"]");
	private By  bPremiumTxt = By.xpath("//*[@id=\"spnEntryTotalPremiumPayable\"]");
	private By  topUpTxt = By.xpath("//*[@id=\"dvtopupsel\"]/div/input");
	private By  topUpPremiumITxt = By.xpath("//*[@id=\"spnEntryTotalTopupPremium\"]");
	private By  TottopUpPremiumITxt= By.xpath("//*[@id=\"spnEntryTotalPremiumPayable\"]");
	private By  AddBtnTxt  = By.id("btnAddDep");
	private By  nameTxt= By.id("txtFirstName");
	private By  yearTxt = By.id("ddlYear");
	private By filrelTxt = By.xpath("//*[@id=\"AddDep\"]/div/div[2]/div[2]/div/fieldset/div/p[7]/label/span");
	private By  milrelTxt = By.xpath("//*[@id=\"AddDep\"]/div/div[2]/div[2]/div/fieldset/div/p[8]/label/span");
	private By  pilPremTxt = By.xpath("//*[@id=\"spnEntryParentalPremium\"]");
	private By  PiltopUpTxt = By.xpath("//*[@id=\"trInlawTopup\"]/td[2]/div/input");
	private By  piltopUpPremTxt = By.xpath("//*[@id=\"spnEntryTotalInLawTopupPremium\"]");
	
	
/*public EnrollmentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}*/

	
	

	/*public void enterMobileNo(String mobileNumber) {
		// TODO Auto-generated method stub
		driver.findElement(mobileTxt).clear();
		driver.findElement(mobileTxt).sendKeys(mobileNumber);
	}

	public void emailId(String emailId) {
		// TODO Auto-generated method stub
		driver.findElement(emailTxt).clear();
		driver.findElement(emailTxt).sendKeys(emailId);
	}

	
	public String getSumAssuredValue() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(quoteSumAssured)));
		Select select = new Select(driver.findElement(quoteSumAssured));
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}*/





	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	
	

	

	public void enterEmpID(String EmpID) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(empIdTxt)));
		driver.findElement(empIdTxt).clear();
		driver.findElement(empIdTxt).sendKeys(EmpID);
	}

	public void enterPassword(String Password) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordTxt)));
		driver.findElement(passwordTxt).clear();
		driver.findElement(passwordTxt).sendKeys(Password);
	}

	public void enterPassword(Object password) {
		// TODO Auto-generated method stub
		
	}

	public void clickonProceed() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedTxt)));
		driver.findElement(proceedTxt).click();
		
	}

	public String selectTopUpSI() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		Select select = new Select(driver.findElement(topUpTxt));
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();	
	}

	public String getTopPremValue() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpPremiumITxt)));
		return driver.findElement(topUpPremiumITxt).getText();
		}

	public String getTotalPremiumPayabale() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(TottopUpPremiumITxt)));
		return driver.findElement(TottopUpPremiumITxt).getText();
	}

	public String getSumInsured() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bSITxt)));
		return driver.findElement(bSITxt).getText();
	}

	public String getPremium() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bPremiumTxt)));
		return driver.findElement(bPremiumTxt).getText();
	}

	public String selectTopUpSI(String TopUpSumInsured) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		Select select = new Select(driver.findElement(topUpTxt));
       select.selectByValue(TopUpSumInsured);
		
	}

	public void AddFIL() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Ramesh");
		Select select = new Select(driver.findElement(yearTxt));
		select.selectByValue("1976");
		driver.findElement(filrelTxt).click();
		
	}

	public void AddMIL() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Vimala");
		Select select = new Select(driver.findElement(yearTxt));
		select.selectByValue("1977");
		driver.findElement(milrelTxt).click();
	}

	public String getParentalPremium() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pilPremTxt)));
		String parentPrem = driver.findElement(pilPremTxt).getText();
		return  parentPrem;
	}

	public void selectPILTopUpSI() {
		// TODO Auto-generated method stub
		
	}

	public void selectPILTopSI() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(PiltopUpTxt)));
		Select select = new Select(driver.findElement(PiltopUpTxt));
    select.selectByIndex(0);
	}

	public String getPILTopupPremium() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(piltopUpPremTxt)));
		String parenttopPrem = driver.findElement(piltopUpPremTxt).getText();
		return  parenttopPrem;
		
	}

	public void clickOnSubmit() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitTxt)));
		driver.findElement(submitTxt).click();
		
	}

	public void clearTopUpSI() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		Select select = new Select(driver.findElement(topUpTxt));
    select.selectByIndex(0);
	}

}

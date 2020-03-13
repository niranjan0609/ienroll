package com.ienroll.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	private By empIdTxt = By.id("txtUsrName");
	private By passwordTxt = By.id("txtPassword");
	private By submitTxt = By.id("btnLogin");
	private By proceedTxt = By.xpath("//*[@id=\"SnapShot\"]/div[2]/div/button");
	private By bSITxt = By.xpath("//*[@id=\"spnBsi\"]");
	private By bPremiumTxt = By.xpath("//*[@id=\"spnEntryTotalPremiumPayable\"]");
	private By topUpTxt = By.cssSelector("td#dvtopupsel div>input");//By.xpath("//*[@id=\"dvtopupsel\"]/div/input");
	private By topUpTxt1Lac = By.cssSelector("#dvtopupsel span");
	private By topUpPremiumITxt = By.xpath("//*[@id=\"spnEntryTotalTopupPremium\"]");
	private By TottopUpPremiumITxt = By.xpath("//*[@id=\"spnEntryTotalPremiumPayable\"]");
	private By AddBtnTxt = By.id("btnAddDep");
	private By nameTxt = By.id("txtFirstName");
	private By yearTxt = By.id("ddlYear");
	private By sonrelTxt = By.xpath("//*[@id=\"PrbRelation2\"]/label/span");
	private By daughtrelTxt = By.xpath("//*[@id=\"PrbRelation3\"]/label/span");
	private By spouseTxt = By.xpath("//*[@id=\"PrbRelation7\"]/label/span");
	private By filrelTxt = By.xpath("//*[@id=\"AddDep\"]/div/div[2]/div[2]/div/fieldset/div/p[7]/label/span");
	private By milrelTxt = By.xpath("//*[@id=\"AddDep\"]/div/div[2]/div[2]/div/fieldset/div/p[8]/label/span");
	private By popupSubmitBtn = By.cssSelector(".popup-submit .btn");
	private By PiltopUpTxt = By.xpath("//*[@id=\"trInlawTopup\"]/td[2]/div/input");
	private By piltopUpPremTxt = By.xpath("//*[@id=\"spnEntryTotalInLawTopupPremium\"]");
	private By pilPremTxt = By.xpath("//*[@id=\"spnEntryParentalPremium\"]");
	private By PiltopUpSIIlacTxt = By.cssSelector("#trInlawTopup li span");
	
	public EnrollmentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}

	/*
	 * public void enterMobileNo(String mobileNumber) { // TODO Auto-generated
	 * method stub driver.findElement(mobileTxt).clear();
	 * driver.findElement(mobileTxt).sendKeys(mobileNumber); }
	 * 
	 * public void emailId(String emailId) { // TODO Auto-generated method stub
	 * driver.findElement(emailTxt).clear();
	 * driver.findElement(emailTxt).sendKeys(emailId); }
	 * 
	 * 
	 * public String getSumAssuredValue() {
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(quoteSumAssured
	 * ))); Select select = new Select(driver.findElement(quoteSumAssured));
	 * WebElement selectedElement = select.getFirstSelectedOption(); return
	 * selectedElement.getText(); }
	 */

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

	/*
	 * public void selectTopUpSI(String valueToSelect) { // TODO Auto-generated
	 * method stub
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
	 * Select select = new Select(driver.findElement(topUpTxt));
	 * select.selectByValue(valueToSelect);
	 * 
	 * WebElement selectedElement = select.getFirstSelectedOption(); return
	 * selectedElement.getText();
	 * 
	 * }
	 */

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

	/*
	 * public String selectTopUpSI(String TopUpSumInsured) { // TODO Auto-generated
	 * method stub
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
	 * Select select = new Select(driver.findElement(topUpTxt));
	 * select.selectByValue(TopUpSumInsured);
	 * 
	 * }
	 */

	public void AddFIL() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Ramesh");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click(); 
		Thread.sleep(1000);
		
		//List<WebElement> optionList = driver.findElements(yearTxt);

        driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
	        driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
	        driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
		    driver.findElement(yearTxt).click();

		/*
		 * //driver.findElements(yearTxt).get(45).click(); JavascriptExecutor je =
		 * (JavascriptExecutor) driver;
		 * je.executeScript("arguments[0].scrollIntoView(true);", optionList.get(32) );
		 */
		driver.findElement(filrelTxt).click();
		driver.findElement(popupSubmitBtn).click();

	}

	public void AddMIL() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Vimala");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click(); 
		Thread.sleep(1000);
		/*
		 * Select select = new Select(driver.findElement(yearTxt));
		 * select.selectByValue(selectYear); driver.findElement(milrelTxt).click();
		 * driver.findElement(popupSubmitBtn).click();
		 */

            driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
	        driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
	       
		    driver.findElement(yearTxt).click();
		    driver.findElement(milrelTxt).click();
		    Thread.sleep(2000);
			driver.findElement(popupSubmitBtn).click();
		    
	}

	public String getParentalPremium() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pilPremTxt)));
		String parentPrem = driver.findElement(pilPremTxt).getText();
		return parentPrem;
	}

	public void selectPILTopUpSI() {
		// TODO Auto-generated method stub

	}

	public void selectPILTopSI() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(PiltopUpTxt)));
		
		  driver.findElement(PiltopUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(PiltopUpSIIlacTxt).get(1).click();
	}

	public String getPILTopupPremium() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(piltopUpPremTxt)));
		String parenttopPrem = driver.findElement(piltopUpPremTxt).getText();
		return parenttopPrem;

	}

	public void clickOnSubmit() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitTxt)));
		driver.findElement(submitTxt).click();

	}

	public void clearTopUpSI() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(0).click();
	}

	public void selectTopUpSI(String valueToSelect) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
	
		/*
		 * Select select = new Select(driver.findElement(topUpTxt));
		 * select.selectByValue(valueToSelect);
		 */
	}

	public void selectTopUpSI1Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		/*
		 * Select topup = new Select(driver.findElement(topUpTxt));
		 * topup.selectByIndex(1);
		 */
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(1).click();
		 
	}

	public void selectTopUpSI2Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(2).click();
		 
	}

	public void selectTopUpSI3Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(3).click();
		
	}

	public void selectTopUpSI4Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(4).click();
		
	}

	public void AddSon() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Venu");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click(); 
		Thread.sleep(1000);
		driver.findElement(sonrelTxt).click();
		driver.findElement(popupSubmitBtn).click();
		
	}

	public void AddDaughter() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Sravya");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click();

		
		
		driver.findElement(daughtrelTxt).click();
		driver.findElement(popupSubmitBtn).click();
		
		
	}

	public void AddSpouse() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Viren");
		Thread.sleep(2000);
		  driver.findElement(yearTxt).sendKeys(Keys.PAGE_DOWN);
		  
	
		Thread.sleep(1000);
		driver.findElement(spouseTxt).click();
		driver.findElement(popupSubmitBtn).click();

	}

	public void selectTopUpSI5Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(4).click();
		
	}

	public void selectTopUpSI7Lac() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
		
		
		  driver.findElement(topUpTxt).click(); 
		  Thread.sleep(1000);
		 
		  driver.findElements(topUpTxt1Lac).get(5).click();
		
	}

	public void AddFather() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Anil");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click(); 
		Thread.sleep(1000);
		driver.findElement(sonrelTxt).click();
		driver.findElement(popupSubmitBtn).click();
	}

	public void AddMother() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddBtnTxt)));
		driver.findElement(AddBtnTxt).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTxt)));
		driver.findElement(nameTxt).sendKeys("Alekya");
		Thread.sleep(2000);
		driver.findElement(yearTxt).click(); 
		Thread.sleep(1000);
		driver.findElement(sonrelTxt).click();
		driver.findElement(popupSubmitBtn).click();
	}

	
	/*
	 * public void selectTopUpSI(String valueToSelect) { // TODO Auto-generated
	 * method stub
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(topUpTxt)));
	 * Select select = new Select(driver.findElement(topUpTxt));
	 * select.selectByValue(valueToSelect); }
	 */
}

package com.ieasy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivateCarPage {

	private WebDriver driver;
	private WebDriverWait wait;

	String imageNameHDFC = "hdfc.jpg";
	String imageAltHDFC = "hdfc";

	String imageNameOriental = "oriental.jpg";
	String imageAltOriental = "oriental";

	String imageNameuiic = "uiic.jpg";
	String imageAltuiic = "uiic";

	private By cardContent = By.cssSelector(".card-title ~ .card-description");
	private By activeTab = By.cssSelector(".nav-stacked li.active");

	// common
	private By byDate = By.id("date");
	private By byMonth = By.id("month");
	private By byYear = By.id("year");

	// Policy tab
	private By previousSelectInsurer = By.cssSelector(".input-group ng-select[formcontrolname='prevIidnsurer']");
	private By previousPolicyNumber = By.cssSelector(".input-group input[ng-reflect-name='prevPolicyNumber']");
	private By hasPreviousClaimsYES = By.cssSelector(".form-group > .radio:nth-child(3) .circle:nth-child(4)");
	private By hasPreviousClaimsNO = By.cssSelector(".form-group > .radio:nth-child(4) .circle:nth-child(4)");
	private By noClaimBonuspercentage = By.cssSelector("select[ng-reflect-name='prevYearNCB']");
	private By policyNextBtn = By.cssSelector(".submit:nth-child(3) .btn");
	// Registration tab
	private By carRegistrationNo = By.cssSelector(".input-group input[formcontrolname='carRegNo']");
	private By regNextBtn = By.xpath("//*[@id='regTab']/car-registration//button");

	// Car Make & Model
	private By carMake = By.cssSelector(".input-group input[formcontrolname='make']");
	// private By carDropdown = By.xpath
	private By petrol = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By diesel = By.cssSelector(".radio:nth-child(2) .circle:nth-child(4)");
	private By cng = By.cssSelector(".radio:nth-child(3) .circle:nth-child(4)");
	private By selectVariant = By.cssSelector("select[formcontrolname='variant']");
	private By viewQuote = By.cssSelector(".submit:nth-child(5) .btn");

	// View Quotes
	private By privateCarSections = By.cssSelector(".section .row .col-md-5:not(.col-md-offset-2) private-car-quote");
	private By cardQuote = By.cssSelector("private-car-quote > .row >.col-md-12 .card:not(.card-disabled)");
	private By imageSection = By.cssSelector(".card-description img");
	private By priceSection = By.cssSelector(".card-description .col-md-4 .btn");

	// personal details
	private By modalDialog = By.cssSelector(".modal .modal-dialog");
	private By emailMobile = By.cssSelector(".modal .modal-dialog .form-group input[formcontrolname='emailMobile']");
	private By continueBtn = By.cssSelector(".modal-footer .btn.btn-danger");

	private By customCalCarRegDate = By.cssSelector("custom-calender[formcontrolname='carRegDate']");
	private By customCalCarMfgDate = By.cssSelector("custom-calender[formcontrolname='mfgDate']");
	
	
	private By fullnameTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By emailTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By pwdTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By fnameTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By lnameTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By maleTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By femaleTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");

	
	
	
	private By DOBOfProposer = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By DOBbyDate = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By DOBbyMonth = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By DOBbyYear = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By PANTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By AadharTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By EmailPropTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By mobilePropTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");

	private By addressTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By stateTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By cityTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By pinNoTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By vehicleBtnOne = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By fuelTypePropTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By engineNoTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By ChassisNoTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By nomNameTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By nomAgeTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By nomRelationTxt = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By vehicleBtn = By.xpath("//car-make-model/form/div[2]//div[1]/label");

	private By getproposalBtn = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	private By reviewBtn = By.xpath("//car-make-model/form/div[2]//div[1]/label");
    private By paymentBtn = By.xpath("//car-make-model/form/div[2]//div[1]/label");
	
	

	public PrivateCarPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	public void selectInsurer(String strInsurer) throws InterruptedException {
		// selectDropdownByVisibleText(previousSelectInsurer, strInsurer);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#basicTab .input-group")));
		WebElement insurer = driver
				.findElement(By.cssSelector("ng-select[formcontrolname='prevInsurer'] .ui-select-toggle"));
		insurer.sendKeys(strInsurer);
		Thread.sleep(3000);
		WebElement click = driver.findElement(By.cssSelector("li[role='menuitem'] a:first-of-type"));
		click.sendKeys(Keys.ENTER);
	}

	public void enterPolicyNumber(String policyNumber) {
		driver.findElement(previousPolicyNumber).sendKeys(policyNumber);
	}

	public void enterPolicyEndDate(String date, String month, String year) {
		selectDropdownByVisibleText(byDate, date);
		selectDropdownByVisibleText(byMonth, month);
		selectDropdownByVisibleText(byYear, year);
	}

	public void selectDropdownByVisibleText(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(text);

	}

	public void selectDropdownByVisibleText(WebElement ele, String text) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(text);
	}

	public void didYouclaimedInPreviousPolicy(String response, String percentage) {
		if (response.equalsIgnoreCase("No")) {
			// Selected by default
			/*
			 * wait.until(ExpectedConditions.presenceOfElementLocated(hasPreviousClaimsNO));
			 * driver.findElement(hasPreviousClaimsNO).click();
			 * wait.until(ExpectedConditions.presenceOfElementLocated(noClaimBonuspercentage
			 * )); driver.findElement(noClaimBonuspercentage).sendKeys(percentage);
			 */
		} else {
			driver.findElement(hasPreviousClaimsYES).click();
		}
	}

	public void clickPolicyNextBtn() {
		driver.findElement(policyNextBtn).click();
	}

	public void enterCarRegistrationNo(String carRegNo) {
		wait.until(ExpectedConditions.presenceOfElementLocated(carRegistrationNo));
		driver.findElement(carRegistrationNo).sendKeys(carRegNo);
	}

	public void enterRegistrationDate(String regDate, String regMonth, String regYear) {
		WebElement ele = driver.findElement(customCalCarRegDate);
		selectDropdownByVisibleText(ele.findElement(byDate), regDate);
		selectDropdownByVisibleText(ele.findElement(byMonth), regMonth);
		selectDropdownByVisibleText(ele.findElement(byYear), regYear);
	}

	public void clickRegistrationNextBtn() {
		driver.findElement(regNextBtn).click();

	}

	public void enterCarModel(String carModel) throws InterruptedException {
		WebElement textBox = driver.findElement(carMake);
		textBox.sendKeys(carModel);
		Thread.sleep(3000);
		textBox.sendKeys(Keys.ENTER);

	}

	public void fuelType(String type) {
		if (type.equalsIgnoreCase("CNG")) {
			driver.findElement(cng).click();
		} else if (type.equalsIgnoreCase("Diesel")) {
			driver.findElement(diesel).click();
		} else {
			driver.findElement(petrol).click();
		}
	}

	public void selectVariant(String variantName) {
		selectDropdownByVisibleText(selectVariant, variantName);
	}

	// Select a Manufacturing Date (MM/YYYY) from calendar.
	public void enterManufacturingDate(String mfgMonth, String mfgYear) {
		WebElement ele = driver.findElement(customCalCarMfgDate);
		selectDropdownByVisibleText(ele.findElement(byMonth), mfgMonth);
		selectDropdownByVisibleText(ele.findElement(byYear), mfgYear);
	}

	public void clickViewQuotes() {
		driver.findElement(viewQuote).click();
	}

	public void clickOrientalQuote() {
		List<WebElement> listSections;
		wait.until(ExpectedConditions.presenceOfElementLocated(privateCarSections));
		listSections = driver.findElements(privateCarSections);
		for (WebElement element : listSections) {
			String myText = element.findElement(imageSection).getAttribute("alt");
			if (myText.contains(imageAltOriental)) {
				String price = element.findElement(priceSection).getText();
				if (Integer.parseInt(price) > 0) {
					element.findElement(priceSection).click();
				} else {
					throw new RuntimeException("Oriental quote not found");
				}
			}
		}
	}

	public void clickHdfcQuote() {
		List<WebElement> listSections;
		wait.until(ExpectedConditions.presenceOfElementLocated(privateCarSections));
		listSections = driver.findElements(privateCarSections);
		for (WebElement element : listSections) {
			String myText = element.findElement(imageSection).getAttribute("alt");
			if (myText.contains(imageAltHDFC)) {
				String price = element.findElement(priceSection).getText();
				if (Integer.parseInt(price) > 0) {
					element.findElement(priceSection).click();
				} else {
					throw new RuntimeException("HDFC quote not found");
				}

			}
		}
	}

	public void clickUiiccQuote() {
		List<WebElement> listSections;
		wait.until(ExpectedConditions.presenceOfElementLocated(privateCarSections));
		wait.until(ExpectedConditions.presenceOfElementLocated(cardQuote));
		listSections = driver.findElements(privateCarSections);
		for (WebElement element : listSections) {
			String myText = element.findElement(imageSection).getAttribute("alt");
			if (myText.contains(imageAltuiic)) {
				String price = element.findElement(priceSection).getText();
				String actualPrice = price.split("/")[0];
				if (Integer.parseInt(actualPrice) > 0) {
					element.findElement(priceSection).click();
				} else {
					throw new RuntimeException("UIIC quote not found");
				}

			}
		}
	}

	public void enterEmailOrMobile(String emailorMobile) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(modalDialog));
		WebElement mob = driver.findElement(emailMobile);
		mob.sendKeys(emailorMobile);
		Thread.sleep(3000);
		mob.sendKeys(Keys.ENTER);
	}

	public void enterFullNameForReg(String fullnameForReg) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(fullnameTxt));
		//driver.findElement(fullnameTxt).sendKeys(fullnameForReg);
	}

	public void enterEmailForReg(String emailForReg) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(emailTxt));
		//driver.findElement(emailTxt).sendKeys(EmailReg);
	}
	
	public void enterPasswordForReg(String pwdForReg) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(pwdTxt));
		//driver.findElement(pwdTxt).sendKeys(pwdForReg);
		
		WebElement pwd = driver.findElement(pwdTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pwd.sendKeys(Keys.ENTER);
	}

	public void enterFirstName(String firstName) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(fnameTxt));
		driver.findElement(fnameTxt).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(lnameTxt));
		driver.findElement(lnameTxt).sendKeys(lastName);
	}



	public void selectGender(String gender) {
		// TODO Auto-generated method stub
		if (gender.equalsIgnoreCase("Male")) {
			driver.findElement(maleTxt).click();
		} else if (gender.equalsIgnoreCase("Female")) {
			driver.findElement(femaleTxt).click();
		}
	}

	public void selectDOB(String dobDate, String dobMonth, String dobYear) {
		// TODO Auto-generated method stub
		WebElement ele = driver.findElement(DOBOfProposer);
		selectDropdownByVisibleText(ele.findElement(DOBbyDate), dobDate);
		selectDropdownByVisibleText(ele.findElement(DOBbyMonth), dobMonth);
		selectDropdownByVisibleText(ele.findElement(DOBbyYear), dobYear);
	}

	public void enterPANNumber(String panNumber) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(PANTxt));
		driver.findElement(PANTxt).sendKeys(panNumber);
	}

	public void enterAadharNumber(String aadharNumber) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(AadharTxt));
		driver.findElement(AadharTxt).sendKeys(aadharNumber);
	}

	public void enterEmailOfProposer(String emailofProposer) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(EmailPropTxt));
		driver.findElement(EmailPropTxt).sendKeys(emailofProposer);
	}

	public void enterMobileOfProposer(String mobileOfProposer) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(mobilePropTxt));
		driver.findElement(mobilePropTxt).sendKeys(mobileOfProposer);
	}

	public void enterAddress(String address) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(addressTxt));
		driver.findElement(addressTxt).sendKeys(address);
	}

	public void selectState(String state) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(stateTxt));
		selectDropdownByVisibleText(stateTxt, state);
	}

	public void selectCity(String city) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(cityTxt));
		selectDropdownByVisibleText(cityTxt, city);
	}

	public void enterPinNo(String pinNo) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(pinNoTxt));
		driver.findElement(pinNoTxt).sendKeys(pinNo);
	}

	public void clickOnVehicleDetails() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(vehicleBtnOne));
		driver.findElement(vehicleBtnOne).click();
	}

	public void selectFuelTypeOnPropPage(String fuelTypeOnPropPage) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(fuelTypePropTxt));
		selectDropdownByVisibleText(fuelTypePropTxt, fuelTypeOnPropPage);
	}

	public void enterEngineNo(String engineNo) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(engineNoTxt));
		driver.findElement(engineNoTxt).sendKeys(engineNo);
	}

	public void enterChassisNo(String chassisNo) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(ChassisNoTxt));
		driver.findElement(ChassisNoTxt).sendKeys(chassisNo);
	}

	public void clickOnNomineeDetails() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(vehicleBtn));
		driver.findElement(vehicleBtn).click();
	}

	public void clickOnReview() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(reviewBtn));
		driver.findElement(reviewBtn).click();
	}
	

	public void clickOnGetPoposalQuote() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(getproposalBtn));
		driver.findElement(getproposalBtn).click();
	
	}

	public void clickOnMakePayment() {
		// TODO Auto-generated method stub
		
		wait.until(ExpectedConditions.presenceOfElementLocated(paymentBtn));
		driver.findElement(paymentBtn).click();
	}

	public void enterNomineeName(String nomineeName) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(nomNameTxt));
		driver.findElement(nomNameTxt).sendKeys(nomineeName);
	}

	public void enterNomineeAge(String nomineeAge) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(nomAgeTxt));
		driver.findElement(nomAgeTxt).sendKeys(nomineeAge);
	}

	
	  public void enterNomineeRelation(String nomineeRelation) { 
		  // TODO Auto-generated method stub
	  wait.until(ExpectedConditions.presenceOfElementLocated(nomRelationTxt));
	  selectDropdownByVisibleText(nomRelationTxt, nomineeRelation); }
	 

	/*
	 * public void enterNomineeRelation(String nomineeRelation) { // TODO
	 * Auto-generated method stub
	 * 
	 * wait.until(ExpectedConditions.presenceOfElementLocated(nomRelationTxt));
	 * selectDropdownByVisibleText(nomRelationTxt, nomineeRelation); }
	 */

}

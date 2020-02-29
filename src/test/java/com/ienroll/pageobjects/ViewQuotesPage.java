package com.ieasy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewQuotesPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	String imageNameHDFC = "hdfc.jpg";
	String imageAltHDFC = "hdfc";
	
	String imageNameOriental = "oriental.jpg";
	String imageAltOriental = "oriental";
	
	private By pageHeader = By.cssSelector("h1.title");

	private By privateCarSections = By.cssSelector(".section .row .col-md-5:not(.col-md-offset-2) private-car-quote");
	private By imageSection = By.cssSelector(".card-description img");
	private By priceSection = By.cssSelector(".card-description .col-md-4 .btn");
	
	
	public ViewQuotesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	
	public void clickOrientalQuote() {
		List<WebElement> listSections;
		wait.until(ExpectedConditions.presenceOfElementLocated(privateCarSections));
		listSections = driver.findElements(privateCarSections);
	    for (WebElement element : listSections){
	        String myText = element.findElement(imageSection).getAttribute("alt");
	        if (myText.contains(imageAltOriental)) {
	        	String price = element.findElement(priceSection).getText();
	        	if(Integer.parseInt(price) > 0) {
	        		element.findElement(priceSection).click();
	        	} else {
	        		throw new RuntimeException("Oriental quote not found");
	        	}
	        }
	    }
	}

	
}

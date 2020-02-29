package com.ieasy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By pageHeader = By.cssSelector("h1.title");
	private By byPrivateCar = By.cssSelector(".circletab:first-of-type");
	private By byTwoWheeler = By.cssSelector(".circletab > span:contains('Two Wheeler')");
	private By byHealth = By.xpath("//my-home/div[1]/div/div/div[2]/div[1]/div[3]/a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	
	public PrivateCarPage clickPrivateCar() {
		wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
		driver.findElement(byPrivateCar).click();
		return new PrivateCarPage(driver);
		
	}
	
	public HealthPage clickHealth() {
		//wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
  driver.findElement(byHealth).click();
		return new HealthPage(driver);
		
	}
	
	public void clickTwoWheeler() {
			
		}
	
	
	
	

}

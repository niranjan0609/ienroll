package com.ienroll.base;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ienroll.utils.Util;

public class TestListener implements ITestListener {

	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportsPath = System.getProperty("user.dir")+ fileSeperator +"TestReport" +fileSeperator+ "screenshots";

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println(context.getName() + "Test Suite started!!!!");
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!!!!!"));
		//Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		//Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		String targetLocation=null;
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		String testClassName = getTestClassName(result.getInstanceName()).trim();
		String timeStamp = Util.getCurrentTimeStamp();
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		
		try {
			File file = new File("TestReport" + fileSeperator + "screenshots");
			if (!file.exists()) {
				System.out.println("Screenshots directory created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator + testClassName +fileSeperator+ screenShotName;
			File targetFile = new File(targetLocation);
			FileUtils.copyFile(screenshotFile, targetFile);
			
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
		
		// adding screenshots to log
		try {
			ExtentTestManager.getTest().fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
		
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentTestManager.getTest().fail(result.getThrowable());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		ExtentTestManager.getTest().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
	
}
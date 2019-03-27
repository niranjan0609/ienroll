package com.gmc.base;


import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class  ExtentTestManager {
	static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getInstance();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
       // extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    	extent.flush();
    }
 
    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
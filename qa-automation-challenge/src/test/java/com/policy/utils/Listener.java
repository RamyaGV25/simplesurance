package com.policy.utils;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("Test Failed: " + tr.getName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("Test Skipped: " + tr.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("Test Passed: " + tr.getName());
    }
}

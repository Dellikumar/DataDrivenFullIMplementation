package com.qa.listneres;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplement implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println( result.getName() + " test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println( result.getName() + "this is passed test case");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println( result.getName() + "test got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The skipped test case is " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + "test is started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + "test is Finished");
		
	}

}

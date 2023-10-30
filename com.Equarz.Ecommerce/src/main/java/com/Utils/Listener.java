package com.Utils;

	import org.testng.ITestListener;
	import org.testng.ITestResult;

	public class Listener implements ITestListener{
Getscreen gs=new Getscreen();
		public void onTestFailure(ITestResult result) {
	try {
		gs.capture(result.getName());
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}

	}


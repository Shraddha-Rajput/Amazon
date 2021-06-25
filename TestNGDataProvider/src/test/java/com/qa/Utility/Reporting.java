package com.qa.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports xReports;
	ExtentTest xTest;

	public void onStart(ITestContext testContext) 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String Repname = "Test-execution-report"+ timeStamp + ".html";

		String dest=System.getProperty("user.dir")+"/Reports/"+ Repname;
		htmlReporter = new  ExtentHtmlReporter(dest);
		htmlReporter.config().setDocumentTitle("Automation testing ");
		htmlReporter.config().setReportName("Functional testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		
		xReports=new ExtentReports();
		xReports.attachReporter(htmlReporter);
		xReports.setSystemInfo("hostname", "localhost");
		xReports.setSystemInfo("QA Name","Shraddha Rajput");
		xReports.setSystemInfo("Os","Windows10");      // environment name running
	}


	public void onFinish(ITestContext testContext)
	{
		xReports.flush();

	}


	public void onTestSuccess(ITestResult tr) 
	{   xTest = xReports.createTest(tr.getName());
	xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	xTest.log(Status.PASS,"Test  is passed");

	}

	public void onTestFailure(ITestResult tr) 
	{ xTest = xReports.createTest(tr.getName());
	xTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	xTest.log(Status.FAIL,"Test  is  failed");    // why test fail? reason
	xTest.log(Status.FAIL,tr.getThrowable());   //reasom why test failedso throw use
	
	
	 String Path = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
	File  file = new File(Path);
	if(file.exists())
	{
		try {
			xTest.fail("Screnshot for the  failed test is :"+ xTest.addScreenCaptureFromPath(Path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
			
	}


	public void onTestSkipped(ITestResult tr)
	{    
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		xTest.log(Status.SKIP,"Test  is  Skipped ");
		xTest.log(Status.SKIP,tr.getThrowable()); 
	}

}

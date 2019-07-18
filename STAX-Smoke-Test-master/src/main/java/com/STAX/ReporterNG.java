package com.STAX;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReporterNG implements IReporter {

	public ExtentReports extent;
	public ExtentTest test;
	public static WebDriver driver;

	// @Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + File.separator + "STAX-SmokeTest.html", true);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				String testcase = result.getMethod().getMethodName();
				String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testcase + ".png";
				test = extent.startTest(result.getMethod().getMethodName());
				if (result.getStatus() == ITestResult.FAILURE) {

					test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
					test.log(LogStatus.FAIL, "Reason for Failure is =>> " + result.getThrowable());
				}

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);
				extent.endTest(test);
			}
		}
	}

}

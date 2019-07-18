package com.STAX_common;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StaxBase extends drivercommon {

	public ExtentTest report;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static String datenow = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());

	@BeforeTest(alwaysRun = true)
	public void startreport() {

		extent = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + File.separator + "STAX-SmokeTest.html", true);

	}

	public static void launchapp() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://austaging.staexperiences.com/search/two?suppliers.items=CO");

		if (driver.findElement(By.xpath("//button[@id='sta-cookie-save-all-button']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@id='sta-cookie-save-all-button']")).click();
			waitforpagetoload();
		} else {
			waitforpagetoload();
		}
	}

	public static String getScreenshot(String screenshotname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getdriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotname + ".png";
		File destination = new File(dest);

		FileUtils.copyFile(source, destination);
		return dest;
	}

	public void click(By key) throws Exception {
		try {

			WebElement element = driver.findElement(key);
			element.click();
			logger.log(LogStatus.INFO, " user clicks on  " + key);

		} catch (AssertionError ex) {

			logger.log(LogStatus.INFO, ex);
		}

	}

	public void ClickAfterElementBecomesClickable(By key) throws Exception {
		try {
			WebElement element = driver.findElement(key);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			logger.log(LogStatus.INFO, " user clicks on  " + key);
		} catch (AssertionError ex) {

			logger.log(LogStatus.INFO, ex);
		}
	}

	public void SwitchToNewWindow() throws Exception {
		try {
			Set<String> handles = driver.getWindowHandles();
			Iterator itr = handles.iterator();
			String parent_window = (String) itr.next();
			System.out.println(parent_window + "....." + driver.getTitle());

			String child_window = (String) itr.next();
			driver.switchTo().activeElement();
			driver.switchTo().window(child_window);
		} catch (AssertionError ex) {
			logger.log(LogStatus.INFO, ex);
		}

	}

	public void type(By key, String text) throws IOException {

		WebElement element = driver.findElement(key);
		element.sendKeys(text);
		logger.log(LogStatus.INFO, " user types  " + text + "    into" + key);

	}

	public void SelectFromDropDown(By key, String text) {

		List<WebElement> autoSuggest = driver.findElements(key);
		for (int i = 0; i < autoSuggest.size(); i++) {

			logger.log(LogStatus.INFO, "Dropdown Values displayed" + autoSuggest.get(i).getText());

			if (autoSuggest.get(i).getText().equalsIgnoreCase(text)) {
				autoSuggest.get(i).click();

				return;
			}
		}
	}

	public void selctfromdropdownwithwebelement(By webkey, By key, String text) {

		WebElement focusdriver = driver.findElement(webkey);

		List<WebElement> autoSuggest = focusdriver.findElements(key);

		for (int i = 0; i < autoSuggest.size(); i++) {

			if (autoSuggest.get(i).getText().equalsIgnoreCase(text)) {
				autoSuggest.get(i).click();

				return;
			}
		}

	}

	public void verifyThePageContentWithParticularText(String text) {
		driver.getPageSource().contains(text);
	}

	public void waitforelement(By key) {

		WebDriverWait wait = new WebDriverWait(getdriver(), 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(key));

	}

	public String datefunction(int numberofdays) {

		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date currentDate = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		c.add(Calendar.DATE, numberofdays);

		// convert calendar to date
		Date currentDatePlus = c.getTime();
		String givendate = dateFormat.format(currentDatePlus);

		return givendate;

	}

	public void datepiecker(String usergivendate) {

		WebElement dateWidgetFrom = driver
				.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']"));

		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		for (WebElement cell : columns) {

			if (cell.getText().equals(usergivendate)) {
				cell.click();
				break;
			}
		}
	}

	public static void waitforpagetoload() {
		JavascriptExecutor js = (JavascriptExecutor) getdriver();
		js.executeScript("return document.readyState").toString().equals("complete");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() throws InterruptedException {
		extent.endTest(logger);
		extent.flush();
		extent.close();

		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;
	}

}

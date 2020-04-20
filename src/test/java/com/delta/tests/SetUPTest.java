package com.delta.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.delta.utils.BrowserUtils;
import com.delta.utils.ConfigReader;
import com.delta.utils.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class SetUPTest {
	protected WebDriver driver;
	protected Actions actions;

	protected ExtentReports reporter;
	protected ExtentSparkReporter htmlreporter;
	protected ExtentTest logger;

	@BeforeSuite(alwaysRun = true)
	public void setUpSuite() {
		reporter = new ExtentReports();

		String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";

		htmlreporter = new ExtentSparkReporter(path);
		htmlreporter.config().setDocumentTitle("Delta Airlines Automation Tests");
//	htmlreporter.config().setTheme(Theme.DARK);
		reporter.attachReporter(htmlreporter);

		reporter.setSystemInfo("Tester", "Liliia");
		reporter.setSystemInfo("Environment", "Staging/Pre-production");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getConfiguration("browser"));

///	public void setUp() {
		driver = Driver.getDriver();
		actions = new Actions(Driver.getDriver());
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout")),
				TimeUnit.SECONDS);
		driver.get(ConfigReader.getConfiguration("url"));
		driver.manage().window().maximize();
//	}
//	
//	@BeforeMethod (alwaysRun = true)
//	}

//	@AfterMethod (alwaysRun = true)

		// Driver.closeDriver();
	}

	@AfterSuite(alwaysRun = true)
//	public void tearDownSuite() {
	public void tearDownDriver(ITestResult testResult) throws IOException {

		if (testResult.getStatus() == ITestResult.FAILURE) {
			logger.fail("FAILED test case: " + testResult.getName());
			logger.fail(testResult.getThrowable());

			String imagePath = BrowserUtils.getScreenshot(testResult.getName());
			logger.addScreenCaptureFromPath(imagePath);

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			logger.skip("SKIPPED test case: " + testResult.getName());
			logger.skip(testResult.getName());
			logger.skip(testResult.getThrowable());
		}
		reporter.flush();

	}

	@AfterSuite
	public void tearDownSuit() {
		reporter.flush(); // without flush() report won't be updated
	}

}

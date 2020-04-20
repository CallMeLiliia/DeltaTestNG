package com.delta.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private Driver() {

	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigReader.getConfiguration("browser").toLowerCase();
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "headlesschrome":
				WebDriverManager.chromedriver().setup();
				final ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); // <-- only for Windows
				driver = new ChromeDriver(options);
				break;
			case "headlessfirefox":
				WebDriverManager.firefoxdriver().setup();
				final ChromeOptions foptions = new ChromeOptions();
				foptions.addArguments("--headless");

				driver = new ChromeDriver(foptions);
				break;
				
			case "phantomjs":
				WebDriverManager.phantomjs().setup();
				driver = new PhantomJSDriver();
				break;
				
			//	case "htmlunit":
					

			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

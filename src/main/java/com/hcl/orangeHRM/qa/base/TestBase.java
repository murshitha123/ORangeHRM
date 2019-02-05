package com.hcl.orangeHRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hcl.orangeHRM.qa.util.TestUtil;
import com.hcl.orangeHRM.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public TestBase() {
		prop = new Properties();
		//PropertyConfigurator.configure("C:\\Users\\Murshi\\eclipse-workspace\\OrangeHRM\\src\\main\\resources\\log4j.properties");

		FileInputStream f;
		try {
			f = new FileInputStream(
					"C:\\Users\\Murshi\\eclipse-workspace\\OrangeHRM\\src\\main\\java\\com\\hcl\\orangeHRM\\qa\\config\\config.properties");
			try {
				prop.load(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    @BeforeTest
	public static void initialization() {

		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Murshi\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.firefox.marionette", "E:\\Murshi\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Murshi\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
    @AfterTest
    public static void teardown() {
    	driver.close();
    }

}

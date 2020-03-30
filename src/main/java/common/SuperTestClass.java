package common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class SuperTestClass {

	@BeforeTest
	public void beforeTest() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		webDriver = driverManager.getDriver();
	}

	@AfterTest
	public void afterTest() {
		driverManager.quitDriver();
	}

	protected DriverManager driverManager;
	protected WebDriver webDriver;

}
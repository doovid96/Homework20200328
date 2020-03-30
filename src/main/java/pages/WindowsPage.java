package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.SuperPageObject;

public class WindowsPage extends SuperPageObject {

	public WindowsPage(WebDriver webDriverInstance, String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public WindowsPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}
	
	public WindowsPage clickOnLink() {
		final String selector = "#content > div > a";
		webDriver.findElement(By.cssSelector(selector)).click();
		return this;
	}

	public String getText() {
		final String selector = ".example";
		return webDriver.findElement(By.cssSelector(selector)).getText();
	}
	
}

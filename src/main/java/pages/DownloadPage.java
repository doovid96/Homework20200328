package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.SuperPageObject;

public class DownloadPage extends SuperPageObject {

	public DownloadPage(final WebDriver webDriverInstance, final String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public DownloadPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}
	
	public DownloadPage downloadFile(final int index) {
		final String selector = "#content>div>a";
		webDriver.findElements(By.cssSelector(selector)).get(index).click();
		return this;
	}
	
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.SuperPageObject;

public class NestedFramePage extends SuperPageObject {

	public NestedFramePage(final WebDriver webDriverInstance, final String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public NestedFramePage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	public String getLeftText() {
		final String text = webDriver.switchTo().frame(0)
			.switchTo().frame(0)
			.findElement(By.cssSelector("body")).getText().strip();
		webDriver.switchTo().defaultContent();
		return text;
	}

	public String getMiddleText() {
		final String text = webDriver.switchTo().frame(0)
			.switchTo().frame(1)
			.findElement(By.cssSelector("#content")).getText().strip();
		webDriver.switchTo().defaultContent();
		return text;
	}

	public String getRightText() {
		final String text = webDriver.switchTo().frame(0)
			.switchTo().frame(2)
			.findElement(By.cssSelector("body")).getText().strip();
		webDriver.switchTo().defaultContent();
		return text;
	}

	public String getBottomText() {
		final String text = webDriver.switchTo().frame(1)
			.findElement(By.cssSelector("body")).getText().strip();
		webDriver.switchTo().defaultContent();
		return text;
	}

}

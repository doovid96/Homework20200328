package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.SuperPageObject;

public class JavaScriptAlertPage extends SuperPageObject {

	public JavaScriptAlertPage(final WebDriver webDriverInstance, final String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}
	
	public JavaScriptAlertPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	public JavaScriptAlertPage interactWithFirstButton() {
		webDriver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
		webDriver.switchTo().alert().accept();
		return this;
	}

	public JavaScriptAlertPage interactWithSecondButton() {
		webDriver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button")).click();
		webDriver.switchTo().alert().accept();
		return this;
	}

	public JavaScriptAlertPage interactWithThirdButton() {
		webDriver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button")).click();
		webDriver.switchTo().alert().sendKeys("Hello World!");
		webDriver.switchTo().alert().accept();
		return null;
	}

	public String getPrompt() {
		return webDriver.findElement(By.cssSelector("#result")).getText();
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.SuperPageObject;

public class HoverPage extends SuperPageObject {

	public HoverPage(final WebDriver webDriverInstance, final String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}
	
	public HoverPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	public HoverPage mouseOverUser3() {
		final String selector = "#content > div > div:nth-child(5) > img";
		WebElement user3 = webDriver.findElement(By.cssSelector(selector));
		new Actions(webDriver).moveToElement(user3).perform();
		return this;
	}

	public HoverPage clickOnProfileLink() {
		final String selector = "#content > div > div:nth-child(5) > div > a";
		webDriver.findElement(By.cssSelector(selector)).click();
		return this;
	}

	public String getURL() {
		return webDriver.getCurrentUrl();
	}

}

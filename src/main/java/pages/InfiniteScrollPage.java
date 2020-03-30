package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import common.SuperPageObject;

public class InfiniteScrollPage extends SuperPageObject {

	final static String LIST_SELECTOR = ".jscroll-added";
	
	public InfiniteScrollPage(WebDriver webDriverInstance, String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public InfiniteScrollPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	public int getJScrollCount() {
		return webDriver.findElements(By.cssSelector(LIST_SELECTOR)).size();
	}

	public void scrollDown() {
		final int x = 0;
		final int y = 1;
		final String script = String.format("window.scrollBy(%d, %d)", x, y);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript(script);
	}

	public String getJScrollByIndex(final int index) {
		return webDriver
			.findElements(By.cssSelector(LIST_SELECTOR))
			.get(index)
			.getText();
	}
	
}

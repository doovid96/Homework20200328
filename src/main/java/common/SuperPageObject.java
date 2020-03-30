package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class SuperPageObject {

	protected WebDriver webDriver;
	protected String domainName;
	
	protected SuperPageObject(final WebDriver webDriverInstance, final String domainNameInstance) {
		webDriver = webDriverInstance;
		domainName = domainNameInstance;
	}
	
	public Select getSelect(WebElement element) {
        return new Select(element);
    }
}
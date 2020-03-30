package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.SuperPageObject;

public class JqueryMenuPage extends SuperPageObject {

	public JqueryMenuPage(final WebDriver webDriverInstance, final String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public JqueryMenuPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	public JqueryMenuPage clickItemByMenuPath(final String[] menuPath) throws Exception {

		String menuListItemSelector = "#menu > li";
		List<WebElement> menuElementList = webDriver.findElements(By.cssSelector(menuListItemSelector));
		
		for (String menuPathOption : menuPath) {
			final int menuPathIndex = findElementIndexByText(menuElementList, menuPathOption);
			menuElementList.get(menuPathIndex).click();
			menuListItemSelector = new StringBuilder(menuListItemSelector)
					.append(":nth-child(")
					.append(menuPathIndex + 1)
					.append(")")
					.append(" > ul")
					.append(" > li")
					.toString();
			menuElementList = webDriver.findElements(By.cssSelector(menuListItemSelector));
		}
		
		return this;
	}

	private int findElementIndexByText(final List<WebElement> list, final String key) throws Exception {
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getText().equals(key)) {
				return i;
			}
		}
		throw new Exception(new StringBuilder("Unable to find key: ").append(key).toString());
	}

	public void getDownloadedFile() {
		return;
	}

}

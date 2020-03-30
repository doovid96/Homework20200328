package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.WindowsPage;

public class WindowTest extends SuperTestClass {

	@Test
	public void windowTest() {
		
		final String expectedTitle = "The Internet";
		
		WindowsPage page = new WindowsPage(webDriver, "http://the-internet.herokuapp.com")
			.navigate("/windows")
			.clickOnLink();
		final String[] tabs = webDriver.getWindowHandles().toArray(new String[0]);
		webDriver.switchTo().window(tabs[1]);
		final String text = page.getText();
		webDriver.close();
		webDriver.switchTo().window(tabs[0]);
		System.out.println(text);
		
		Assert.assertEquals(webDriver.getTitle(), expectedTitle);
	}
	
}

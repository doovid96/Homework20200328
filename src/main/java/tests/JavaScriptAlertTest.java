package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends SuperTestClass {

	@Test
	public void javaScriptAlertTest() {
		
		final String expectedText1 = "You successfuly clicked an alert";
		final String expectedText2 = "You clicked: Ok";
		final String userInput = "Hello World!";
		final String expectedText3 = new StringBuilder("You entered: ").append(userInput).toString();
		
		JavaScriptAlertPage page = new JavaScriptAlertPage(webDriver, "http://the-internet.herokuapp.com/")
			.navigate("javascript_alerts");
		
		page.interactWithFirstButton();
		Assert.assertEquals(page.getPrompt(), expectedText1);
		
		page.interactWithSecondButton();
		Assert.assertEquals(page.getPrompt(), expectedText2);
		
		page.interactWithThirdButton();
		Assert.assertEquals(page.getPrompt(), expectedText3);
		
	}
	
}

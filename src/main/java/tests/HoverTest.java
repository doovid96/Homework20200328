package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.HoverPage;

public class HoverTest extends SuperTestClass {

	@Test
	public void hoverTest() {
		
		final String expectedURL = "http://the-internet.herokuapp.com/users/3";
		
		HoverPage page = new HoverPage(webDriver, "http://the-internet.herokuapp.com")
			.navigate("/hovers")
			.mouseOverUser3()
			.clickOnProfileLink();
		
		Assert.assertEquals(page.getURL(), expectedURL);
		
	}
	
}

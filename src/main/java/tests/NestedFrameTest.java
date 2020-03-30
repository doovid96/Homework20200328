package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.NestedFramePage;

public class NestedFrameTest extends SuperTestClass {

	@Test
	public void nestedFrametest() {
		
		final String expectedLeftText = "LEFT";
		final String expectedMiddletext = "MIDDLE";
		final String expectedRightText = "RIGHT";
		final String expectedBottomText = "BOTTOM";
		
		NestedFramePage page = new NestedFramePage(webDriver, "http://the-internet.herokuapp.com/")
			.navigate("nested_frames");
		
		Assert.assertEquals(page.getLeftText(), expectedLeftText);
		Assert.assertEquals(page.getMiddleText(), expectedMiddletext);
		Assert.assertEquals(page.getRightText(), expectedRightText);
		Assert.assertEquals(page.getBottomText(), expectedBottomText);
		
	}
	
}

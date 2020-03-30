package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.InfiniteScrollPage;

public class InfiniteScrollTest extends SuperTestClass {

	@Test
	public void infiniteScrolltest() {
		
		final int sleepDuration = 50;
		final int maxSleepIntervals = 10;
		
		InfiniteScrollPage page = new InfiniteScrollPage(webDriver, "http://the-internet.herokuapp.com")
			.navigate("/infinite_scroll");
		final int initialJScrollCount = page.getJScrollCount();		
		while (page.getJScrollCount() == initialJScrollCount) {
			page.scrollDown();
		}
		for (int interval = 0; interval < maxSleepIntervals; ++interval) {
			if (! page.getJScrollByIndex(initialJScrollCount).equalsIgnoreCase("Loading...") ) {
				break;
			}
			try {Thread.sleep(sleepDuration);} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println(page.getJScrollByIndex(initialJScrollCount));
		
		Assert.assertTrue(page.getJScrollCount() > initialJScrollCount);
	}
	
}

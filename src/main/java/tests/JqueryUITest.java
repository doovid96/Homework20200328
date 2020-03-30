package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.JqueryMenuPage;

public class JqueryUITest extends SuperTestClass {

	@Test
	public void downloadFile() throws Exception {
		
		final String path = "C:\\Users\\David\\Downloads\\menu.xls";
		
		if (new File(path).delete()) {
			System.out.println("Deleted file.");
		}
		new JqueryMenuPage(webDriver, "http://the-internet.herokuapp.com/")
			.navigate("jqueryui/menu#")
			.clickItemByMenuPath(new String[] {"Enabled", "Downloads", "Excel"})
			.getDownloadedFile();

		Assert.assertTrue(constantFileSize(path));
		
	}
	
	private boolean constantFileSize(final String filepath) throws InterruptedException {
		final int iterations = 5;
		final int milliseconds = 100;
		long bytes = new File(filepath).length();
		for (int iteration = 0; iteration < iterations; ++iteration) {
			Thread.sleep(milliseconds);
			if (new File(filepath).length() == bytes) {
				return true;
			}
		}
		return false;
	}

}

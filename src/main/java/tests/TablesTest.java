package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.TablesPage;

public class TablesTest extends SuperTestClass {

	@Test
	public void tabletest() {
		
		final String targetColumnName = "Due";
		final String searchColumnName = "Email";
		final String email = "jdoe@hotmail.com";
		final String expectedAmount = "$100.00";
		
		TablesPage page = new TablesPage(webDriver, "http://the-internet.herokuapp.com")
			.navigate("/tables");
		final String amountDue = page.indexTable1(targetColumnName, searchColumnName, email);
		System.out.println(amountDue);
		
		Assert.assertEquals(amountDue, expectedAmount);
		
	}
	
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.SuperPageObject;

public class TablesPage extends SuperPageObject {

	public TablesPage(WebDriver webDriverInstance, String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}
	
	public TablesPage navigate(final String subdirectory) {
		webDriver.navigate().to(new StringBuilder(domainName).append(subdirectory).toString());
		return this;
	}

	/**
	 * @param targetColumnName Name of column where element is to be returned.
	 * @param searchColumnName Name of column where key is to be found.
	 * @param searchKey String to be found in searchColumnName.
	 * @return Indexed column element which is in the same position as the searchKey in the searchColumnName.
	 * If the 
	 */
	public String indexTable1(String targetColumnName, String searchColumnName, String searchKey) {
		
		final int targetColumnIndex = indexOfColumnByHeader(targetColumnName);
		final int searchColumnIndex = indexOfColumnByHeader(searchColumnName);
		final int rows = webDriver.findElements(By.cssSelector("#table1 > tbody > tr")).size();
		
		for (int row = 1; row <= rows; ++row) {
			final String tableData = getStringByIndex(row, searchColumnIndex);
			if (tableData == null) {
				return null;
			}
			if (tableData.equals(searchKey)) {
				return getStringByIndex(row, targetColumnIndex);
			}
		}
		return null;
	}
	
	/**
	 * @param searchColumnName Name of the column to be found.
	 * @return Returns the index of the named column where the first index is 1.
	 * If the column is not found, -1 is returned.
	 */
	private int indexOfColumnByHeader(String searchColumnName) {
		final String selector = "#table1 > thead > tr > th";
		List<WebElement> columnNameElementList = webDriver.findElements(By.cssSelector(selector));
		for (int columnIndex = 0; columnIndex < columnNameElementList.size(); ++columnIndex) {
			if (columnNameElementList.get(columnIndex).getText().equals(searchColumnName)) {
				return columnIndex + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param row Index of the row starting from 1.
	 * @param column Index of the column starting from 1.
	 * @return Returns the String representation of the element contained in the table at (row, column).
	 * If the element cannot be found, returns null.
	 */
	private String getStringByIndex(final int row, final int column) {
		final String selector = String.format("#table1 > tbody > tr:nth-child(%d) > td:nth-child(%d)", row, column);
		return webDriver.findElement(By.cssSelector(selector)).getText();
	}

}

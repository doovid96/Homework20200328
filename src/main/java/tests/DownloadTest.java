package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import common.SuperTestClass;
import pages.DownloadPage;

public class DownloadTest extends SuperTestClass {

	@Test
	public void downloadTest() {
		
		try {
			final String path = "C:\\Users\\David\\Downloads\\Srinaya.txt";
			final String baseURL = "http://the-internet.herokuapp.com";
			final String subdirectory = "/download";
			
			if (new File(path).delete()) {
				System.out.println("File was deleted.");
			}
			new DownloadPage(webDriver, baseURL)
				.navigate(subdirectory)
				.downloadFile(1);
			waitForDownload(path);
			printFileContents(path);
		}
		catch (Exception e) {
			System.out.println("Unable to fulfil download test.");
			e.printStackTrace();
		}
	}

	private void waitForDownload(final String path) throws Exception {
		final int duration = 100;
		final int iterations = 10;
		for (int iteration = 0; iteration < iterations; ++iteration) {
			if (new File(path).exists()) {
				return;
			}
			Thread.sleep(duration);
		}
		throw new Exception("Download timed out.");
	}
	
	private void printFileContents(final String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			while (br.ready()) {
				System.out.println(br.readLine());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				br.close();
			}
		}
	}
	
}

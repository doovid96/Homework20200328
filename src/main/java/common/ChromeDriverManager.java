package common;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void startService() {}

	@Override
	protected void stopService() {}

	@Override
	protected void createDriver() {		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		final long time = 5000;
		final TimeUnit unit = TimeUnit.MILLISECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}

}
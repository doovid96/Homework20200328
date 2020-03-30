package common;

public class DriverManagerFactory {

	public static DriverManager getManager(final DriverType type) {
		
		switch (type) {
		
		case CHROME:
			return new ChromeDriverManager();
			
		default:
			System.out.println(type + " is not a supported driver!");
			return null;
		}
		
	}
	
}
package users;

public class User {
	
	private String username;
	private String password;
	
	protected User(final String usernameInstance, final String passwordInstance) {
		username = usernameInstance;
		password = passwordInstance;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}

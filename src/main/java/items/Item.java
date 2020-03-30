package items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import users.User;

public abstract class Item {

	final protected String url = "jdbc:mysql://localhost:3306/";
	protected Connection connection;
	protected Statement statement;
	protected ResultSet set;
	
	public Connection getConnection(final String url, final User user) throws SQLException {
		return DriverManager.getConnection(url, user.getUsername(), user.getPassword());
	}
	
	public abstract void runner() throws Exception;
	
}

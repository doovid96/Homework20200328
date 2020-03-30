package items;

import java.sql.SQLException;

import org.testng.annotations.Test;

import users.DavidUser;

final public class Item02 extends Item {

	@Test
	@Override
	public void runner() throws SQLException {
		final String schema = "sakila";
		final String columnName = "title";
		final String tableName = "film";
		final String compareTo = "'%airplane%'";
		final String sql = new StringBuilder("SELECT ")
				.append(columnName)
				.append(" FROM ")
				.append(tableName)
				.append(" WHERE ")
				.append(columnName)
				.append(" LIKE ")
				.append(compareTo)
				.append(";")
				.toString();
		try {
			connection = getConnection(
					new StringBuilder(url).append(schema).toString(),
					new DavidUser());
			statement = connection.createStatement();
			set = statement.executeQuery(sql);
			while (set.next()) {
				System.out.println(set.getString("title"));
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Vendor Error: " + e.getErrorCode());
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
}

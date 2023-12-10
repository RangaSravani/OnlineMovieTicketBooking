
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/movie";

	static Connection conn;

	// Database Credentials
	static final String user = "root";
	static final String password = "1234";

	public static Connection createC() {

		try {
			// load the driver
			Class.forName(JDBC_DRIVER);

			// create the connection
			conn = DriverManager.getConnection(DB_URL, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return conn;
	}
}


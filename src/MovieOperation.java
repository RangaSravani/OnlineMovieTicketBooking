import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieOperation {

	static PreparedStatement pstmt = null;
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	// 1. Method to Insert
	public static boolean insert(Movie obj) {

		boolean f = false;
		try {
			// this will create Connection
			conn = JdbcConnection.createC();

			// Use connection to fire queries
			String q = "INSERT INTO MOVIES(ID, Title, Genre, YearOfRelease) Values(?,?,?,?)";

			// PreparedStatement
			pstmt = conn.prepareStatement(q);

			// Set the value for parameter
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getTitle());
			pstmt.setString(3, obj.getGenre());
			pstmt.setInt(4, obj.getYearOfRelease());

			// Execute
			pstmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally { // Finally block to close all resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}

	// 2. Method to Update
	public static boolean update(Movie obj, int sid) {
		boolean f = false;
		try {
			// this will create Connection
			conn = JdbcConnection.createC();

			// Use connection to fire queries
			String q = "UPDATE MOVIES SET Title = ? ,  Genre = ?,  YearOfRelease = ? WHERE ID = ?";

			// PreparedStatement
			pstmt = conn.prepareStatement(q);

			// Set the value for parameter
			pstmt.setString(1, obj.getTitle());
			pstmt.setString(2, obj.getGenre());
			pstmt.setInt(3, obj.getYearOfRelease());
			pstmt.setInt(4, sid);

			// Execute
			pstmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}

	// 3. Method to Delete
	public static boolean delete(int id) {
		boolean f = false;
		try {
			// this will create Connection
			conn = JdbcConnection.createC();

			// Use connection to fire queries
			String q = "DELETE FROM MOVIES WHERE ID = ?";

			// PreparedStatement
			pstmt = conn.prepareStatement(q);

			// Set the value for parameter
			pstmt.setInt(1, id);

			// Execute
			pstmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}

	// 4. Method to Display
	public static void display() {

		try {
			// this will create Connection
			conn = JdbcConnection.createC();

			// Use connection to fire queries
			String q = "SELECT * FROM MOVIES";

			// Statement
			stmt = conn.createStatement();

			// Execute Using ResultSet
			rs = stmt.executeQuery(q);

			while (rs.next()) {
				// Retrieve by Column name
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);
				int yearOfRelease = rs.getInt(4);

				// Display values
				System.out.println("ID : " + id);
				System.out.println("TITLE : " + title);
				System.out.println("GENRE : " + genre);
				System.out.println("YEAR OF RELEASE : " + yearOfRelease);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

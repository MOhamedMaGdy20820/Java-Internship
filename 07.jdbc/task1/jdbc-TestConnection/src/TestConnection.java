import java.sql.*;

public class TestConnection {
	public static void main(String[] args) throws SQLException{
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		try (Connection conn = DriverManager.getConnection(dbUrl, user, pass)) {
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to connect to the database.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employees");
			while (myRs.next()) {
				System.out.println( myRs.getString("first_name")+ ", " +
						            myRs.getString("last_name" ));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}


	}
}

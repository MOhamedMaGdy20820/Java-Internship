import java.sql.*;

public class TestConnection {

	public static void main(String[] args) throws SQLException{
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);

			createEmployeeTable(myConn);

			insertEmployees(myConn);

			displayEmployees(myConn);

			updateEmployeeVacationAndTitle(myConn);

			displayEmployees(myConn);

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

	private static void createEmployeeTable(Connection conn) throws SQLException {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee ("
				+ "Id INT NOT NULL AUTO_INCREMENT, "
				+ "F_Name VARCHAR(50), "
				+ "L_Name VARCHAR(50), "
				+ "Sex CHAR(1), "
				+ "Age INT, "
				+ "Address VARCHAR(100), "
				+ "Phone_Number VARCHAR(15), "
				+ "Vacation_Balance INT DEFAULT 30, "
				+ "PRIMARY KEY (Id))";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(createTableSQL);
			System.out.println("Table Employee created.");
		}
	}

	private static void insertEmployees(Connection conn) throws SQLException {
		String insertSQL = "INSERT INTO Employee (F_Name, L_Name, Sex, Age, Address, Phone_Number) " +
							"VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setString(1, "John");
			pstmt.setString(2, "Doe");
			pstmt.setString(3, "M");
			pstmt.setInt(4, 35);
			pstmt.setString(5, "123 Elm St");
			pstmt.setString(6, "555-1234");
			pstmt.addBatch();

			pstmt.setString(1, "Jane");
			pstmt.setString(2, "Smith");
			pstmt.setString(3, "F");
			pstmt.setInt(4, 50);
			pstmt.setString(5, "456 Oak St");
			pstmt.setString(6, "555-5678");
			pstmt.addBatch();

			pstmt.setString(1, "Peter");
			pstmt.setString(2, "Brown");
			pstmt.setString(3, "M");
			pstmt.setInt(4, 42);
			pstmt.setString(5, "789 Pine St");
			pstmt.setString(6, "555-8765");
			pstmt.addBatch();

			pstmt.setString(1, "Lucy");
			pstmt.setString(2, "Johnson");
			pstmt.setString(3, "F");
			pstmt.setInt(4, 48);
			pstmt.setString(5, "321 Maple St");
			pstmt.setString(6, "555-4321");
			pstmt.addBatch();

			pstmt.setString(1, "David");
			pstmt.setString(2, "Williams");
			pstmt.setString(3, "M");
			pstmt.setInt(4, 30);
			pstmt.setString(5, "654 Cedar St");
			pstmt.setString(6, "555-5678");
			pstmt.addBatch();

			pstmt.executeBatch();
			System.out.println("Inserted employees");
		}
	}

	private static void updateEmployeeVacationAndTitle(Connection conn) throws SQLException {
		String updateVacationSQL = "UPDATE Employee SET Vacation_Balance = 45 WHERE Age > 45";

		String updateTitleSQL =   "UPDATE Employee SET F_Name = CASE "
								+ "WHEN Sex = 'M' THEN CONCAT('Mr. ', F_Name) "
								+ "WHEN Sex = 'F' THEN CONCAT('Mrs. ', F_Name) "
								+ "END WHERE Age > 45";

		try (Statement stmt = conn.createStatement()) {
			conn.setAutoCommit(false);

			// You can set a variety of SQL tags to all and all can be batched by the database
			stmt.addBatch(updateVacationSQL);
			stmt.addBatch(updateTitleSQL);

			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	private static void displayEmployees(Connection conn) throws SQLException {
		String selectSQL = "SELECT * FROM Employee";

		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(selectSQL)) {

			System.out.println("Employee Data:");
			while (rs.next()) {
				String fName = rs.getString("F_Name");
				String lName = rs.getString("L_Name");
				String sex = rs.getString("Sex");
				int age = rs.getInt("Age");
				int vacationBalance = rs.getInt("Vacation_Balance");
				System.out.printf(" Name: %s %s, Sex: %s, Age: %d,, Vacation Balance: %d \n",
						 fName, lName, sex, age, vacationBalance);
			}
		}
	}



}

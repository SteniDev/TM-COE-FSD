package Week3.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletEmployee {
    public static final String URL = "jdbc:mysql://localhost:3306/employee";
   public static final String USER = "root"; // Change as per your database credentials
    public static final String PASSWORD = "Dev@2003"; // Change as per your database credentials

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to delete: ");
            int id = scanner.nextInt();

            deleteEmployee(conn, id);

            System.out.println("Employee record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM employeedetails WHERE empid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }
}

package Week3.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "root"; // Change as per your database credentials
    private static final String PASSWORD = "Dev@2003"; // Change as per your database credentials

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Phone Number: ");
            String phone = scanner.nextLine();

            updateEmployee(conn, id, name, phone);

            System.out.println("Employee details updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateEmployee(Connection conn, int id, String name, String phone) throws SQLException {
        String sql = "UPDATE employeedetails SET empname = ?, phoneno = ? WHERE empid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }
}

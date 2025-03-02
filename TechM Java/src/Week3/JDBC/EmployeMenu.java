package Week3.JDBC;

import java.util.Scanner;
import java.sql.*;
public class EmployeMenu {
    public static final String URL = "jdbc:mysql://localhost:3306/employee";
    public static final String USER = "root";
    public static final String PASSWORD = "Dev@2003";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        deleteEmployee(conn, scanner);
                        break;
                    case 4:
                        selectEmployee(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO employeedetails (empname, empid, phoneno) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            System.out.println("Employee inserted successfully.");
        }
    }

    public static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        String sql = "UPDATE employeedetails SET empname = ?, phoneno = ? WHERE empid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Phone Number: ");
            String phone = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee details updated successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }
    public static void deleteEmployee(Connection conn, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM employeedetails WHERE empid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to delete: ");
            int id = scanner.nextInt();

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee record deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }

    public static void selectEmployee(Connection conn, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM employeedetails WHERE empid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to view: ");
            int id = scanner.nextInt();

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Employee ID: " + rs.getInt("empid"));
                    System.out.println("Employee Name: " + rs.getString("empname"));
                    System.out.println("Phone Number: " + rs.getString("phoneno"));
                } else {
                    System.out.println("No employee found with ID: " + id);
                }
            }
        }
    }
}

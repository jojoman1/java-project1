import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class project1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice:");
        System.out.println("1. User Login");
        System.out.println("2. Admin Login");
        System.out.println("3. Insert Employee Data");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Username:");
                String username = sc.nextLine();
                System.out.println("Enter Password:");
                String userpass = sc.nextLine();
                System.out.println("\n--- User Login ---");
                System.out.println("Username: " + username);
                System.out.println("Password: " + userpass);
                break;

            case 2:
                System.out.println("Enter Admin Name:");
                String adminName = sc.nextLine();
                System.out.println("Enter Admin Password:");
                String adminPass = sc.nextLine();
                System.out.println("\n--- Admin Login ---");
                System.out.println("Admin Name: " + adminName);
                System.out.println("Admin Password: " + adminPass);
                break;

            case 3:
                insertEmployeeData(sc);
                break;

            default:
                System.out.println("Invalid choice. Login Unsuccessful!");
                break;
        }

        sc.close();
    }

    public static void insertEmployeeData(Scanner sc) {
        String dbUrl = "jdbc:mysql://localhost:3306/data";
        String dbUser = "root";
        String dbPass = "";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            System.out.println("Connected to Database ✅");

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            String query = "INSERT INTO data (Id, Name, Dept, salary, location) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, dept);
            pst.setInt(4, salary);
            pst.setString(5, location);

            int n = pst.executeUpdate();
            if (n == 1) {
                System.out.println("✅ Data Inserted Successfully!");
            } else {
                System.out.println("❌ Data Insertion Failed!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

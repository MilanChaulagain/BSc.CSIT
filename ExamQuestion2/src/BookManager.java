import java.sql.*;
import java.util.Scanner;

public class BookManager {
    // JDBC credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/Book";
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement()
        ) {
            // Get book details from user
            System.out.print("Enter book name: ");
            String name = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter publish date (YYYY-MM-DD): ");
            String publishDate = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();

            // Insert book into the database
            String insertSQL = "INSERT INTO book (name, author, publish_date, price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, name);
                pstmt.setString(2, author);
                pstmt.setDate(3, Date.valueOf(publishDate)); // Convert string to SQL Date
                pstmt.setDouble(4, price);
                pstmt.executeUpdate();
                System.out.println("Book inserted successfully.\n");
            }

            // Retrieve and display all books
            String selectSQL = "SELECT * FROM book";
            try (ResultSet rs = stmt.executeQuery(selectSQL)) {
                System.out.println("Stored Books:");
                System.out.printf("%-5s %-30s %-20s %-15s %-10s\n", "ID", "Name", "Author", "Publish Date", "Price");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String bookName = rs.getString("name");
                    String bookAuthor = rs.getString("author");
                    Date pubDate = rs.getDate("publish_date");
                    double bookPrice = rs.getDouble("price");

                    System.out.printf("%-5d %-30s %-20s %-15s %-10.2f\n",
                            id, bookName, bookAuthor, pubDate.toString(), bookPrice);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

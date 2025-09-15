package JDBC;

import java.sql.*;

public class MovieInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/moviesdb"; // Replace with your DB details
        String user = "root"; // Replace with your DB username
        String password = ""; // Replace with your DB password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql1 = "INSERT INTO MOVIE (id, title, genre) VALUES (1, 'Jatra', 'Drama')";
            String sql2 = "INSERT INTO MOVIE (id, title, genre) VALUES (2, 'Loot', 'Action')";
            String sql3 = "INSERT INTO MOVIE (id, title, genre) VALUES (3, 'Kabaddi', 'Romance')";

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

            System.out.println("3 records inserted successfully.");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


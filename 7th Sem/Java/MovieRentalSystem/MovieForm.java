package MovieRentalSystem;


import javax.swing.*;
import java.sql.*;

public class MovieForm {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/MRS";
    private static final String USER = "root"; // change if needed
    private static final String PASS = "";     // change if needed

    private Connection conn;

    public MovieForm() {
        // Connect to DB
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
            System.exit(1);
        }

        // Create JFrame
        JFrame frame = new JFrame("Add Movie");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and Fields
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 100, 25);
        JTextField titleField = new JTextField();
        titleField.setBounds(120, 20, 200, 25);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(20, 60, 100, 25);
        JTextField genreField = new JTextField();
        genreField.setBounds(120, 60, 200, 25);

        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setBounds(20, 100, 100, 25);
        JTextField languageField = new JTextField();
        languageField.setBounds(120, 100, 200, 25);

        JLabel lengthLabel = new JLabel("Length (min):");
        lengthLabel.setBounds(20, 140, 100, 25);
        JTextField lengthField = new JTextField();
        lengthField.setBounds(120, 140, 200, 25);

        JButton okButton = new JButton("OK");
        okButton.setBounds(120, 190, 80, 30);

        // Add components to frame
        frame.add(titleLabel);
        frame.add(titleField);
        frame.add(genreLabel);
        frame.add(genreField);
        frame.add(languageLabel);
        frame.add(languageField);
        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(okButton);

        // OK button action
        okButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String genre = genreField.getText().trim();
            String language = languageField.getText().trim();
            String lengthStr = lengthField.getText().trim();

            if (title.isEmpty() || lengthStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Title and Length are required fields.");
                return;
            }

            int length;
            try {
                length = Integer.parseInt(lengthStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Length must be a valid integer.");
                return;
            }

            try {
                String insertSQL = "INSERT INTO Movie (Title, Genre, Language, Length) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(insertSQL);
                ps.setString(1, title);
                ps.setString(2, genre);
                ps.setString(3, language);
                ps.setInt(4, length);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(frame, "Movie added successfully!");
                    // Clear fields
                    titleField.setText("");
                    genreField.setText("");
                    languageField.setText("");
                    lengthField.setText("");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error inserting movie: " + ex.getMessage());
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Load MySQL JDBC driver (optional, depends on driver version)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
        }

        SwingUtilities.invokeLater(() -> new MovieForm());
    }
}


package Table;

import javax.swing.*;
import java.awt.*;

public class SimpleTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Column headers
        String[] columns = {"ID", "Name", "Age"};

        // Table data
        Object[][] data = {
    {1, "Alice", 25},
    {2, "Bob", 30},
    {3, "Charlie", 22},
    {4, "David", 28},
    {5, "Eva", 31},
    {6, "Frank", 27},
    {7, "Grace", 26},
    {8, "Hannah", 29},
    {9, "Ian", 24},
    {10, "Jane", 23},
    {11, "Kevin", 32},
    {12, "Lily", 21},
    {13, "Mike", 30},
    {14, "Nina", 28},
    {15, "Oscar", 25},
    {16, "Paula", 27},
    {17, "Quinn", 29},
    {18, "Rachel", 24},
    {19, "Steve", 31},
    {20, "Tina", 26},
    {21, "Uma", 22},
    {22, "Victor", 33},
    {23, "Wendy", 25},
    {24, "Xander", 28},
    {25, "Yara", 27},
    {26, "Zack", 30},
    {27, "Adam", 29},
    {28, "Bella", 23},
    {29, "Carl", 31},
    {30, "Diana", 24}
};

        // Create JTable with data and columns
        JTable table = new JTable(data, columns);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scroll pane to frame
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}


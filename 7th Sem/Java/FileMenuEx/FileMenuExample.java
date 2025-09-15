package FileMenuEx;

import javax.swing.*;
import java.awt.event.*;

public class FileMenuExample {
    public static void main(String[] args) {
        // Create a frame (window)
        JFrame frame = new JFrame("Menu Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("File");

        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "New File Created!"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "File Saved!"));
        exitItem.addActionListener(e -> System.exit(0));

        // Add items to File menu
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.add(exitItem);

        // Add File menu to menu bar
        menuBar.add(fileMenu);

        // Set menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Show the frame
        frame.setVisible(true);
    }
}


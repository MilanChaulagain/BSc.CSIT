package LayoutManagement; //Model Set II Solution

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayoutDemo extends JFrame {
    private JTextField firstNumberField, secondNumberField, resultField;

    public BorderLayoutDemo() {
        setTitle("BorderLayout Calculator Example");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // North panel with descriptive label
        JPanel northPanel = new JPanel();
        JLabel label = new JLabel("Simple Calculator Using BorderLayout");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        northPanel.add(label);
        add(northPanel, BorderLayout.NORTH);

        // East panel with buttons with icons
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1, 10, 10));

        // JButton btnAddIcon = new JButton("Add", new ImageIcon("icons/add.png"));
        // JButton btnSubIcon = new JButton("Subtract", new ImageIcon("icons/subtract.png"));
        // JButton btnMulIcon = new JButton("Multiply", new ImageIcon("icons/multiply.png"));
        // JButton btnDivIcon = new JButton("Divide", new ImageIcon("icons/divide.png"));

        // If you don't have icon files, you can comment icons out or use default buttons
        // For demo, let's just create buttons without icons:
        JButton btnAddIcon = new JButton("Add");
        JButton btnSubIcon = new JButton("Subtract");
        JButton btnMulIcon = new JButton("Multiply");
        JButton btnDivIcon = new JButton("Divide");

        eastPanel.add(btnAddIcon);
        eastPanel.add(btnSubIcon);
        eastPanel.add(btnMulIcon);
        eastPanel.add(btnDivIcon);

        add(eastPanel, BorderLayout.EAST);

        // Center panel subdivided for the form
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Labels and text fields
        centerPanel.add(new JLabel("First Number:"));
        firstNumberField = new JTextField();
        centerPanel.add(firstNumberField);

        centerPanel.add(new JLabel("Second Number:"));
        secondNumberField = new JTextField();
        centerPanel.add(secondNumberField);

        centerPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        centerPanel.add(resultField);

        // Empty cell to align buttons nicely (optional)
        centerPanel.add(new JLabel("")); 
        centerPanel.add(new JLabel("")); 

        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners for buttons to perform operations
        btnAddIcon.addActionListener(e -> performOperation('+'));
        btnSubIcon.addActionListener(e -> performOperation('-'));
        btnMulIcon.addActionListener(e -> performOperation('*'));
        btnDivIcon.addActionListener(e -> performOperation('/'));

        setVisible(true);
    }

    private void performOperation(char operator) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText().trim());
            double num2 = Double.parseDouble(secondNumberField.getText().trim());
            double res = 0;

            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    res = num1 / num2;
                    break;
            }
            resultField.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderLayoutDemo::new);
    }
}


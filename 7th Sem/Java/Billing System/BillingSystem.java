import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BillingSystem extends JFrame {
    private JTextField itemNameField, quantityField, priceField, discountField;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JTextArea receiptArea;
    private JLabel totalLabel;

    public BillingSystem() {
        setTitle("Billing System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Top Input Panel ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Item"));

        itemNameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        JButton addButton = new JButton("Add Item");

        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(itemNameField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // --- Table for Items ---
        String[] columns = {"Item", "Quantity", "Price", "Total"};
        tableModel = new DefaultTableModel(columns, 0);
        itemTable = new JTable(tableModel);
        add(new JScrollPane(itemTable), BorderLayout.CENTER);

        // --- Right Receipt Area ---
        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(receiptArea), BorderLayout.EAST);

        // --- Bottom Panel for Totals ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(new JLabel("Discount (%):"));
        discountField = new JTextField(5);
        bottomPanel.add(discountField);

        JButton generateButton = new JButton("Generate Bill");
        bottomPanel.add(generateButton);

        totalLabel = new JLabel("Total: 0.0");
        bottomPanel.add(totalLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        // --- Button Actions ---
        addButton.addActionListener(this::addItem);
        generateButton.addActionListener(this::generateBill);
    }

    private void addItem(ActionEvent e) {
        String item = itemNameField.getText();
        String qtyText = quantityField.getText();
        String priceText = priceField.getText();

        if (item.isEmpty() || qtyText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            double price = Double.parseDouble(priceText);
            double total = qty * price;

            tableModel.addRow(new Object[]{item, qty, price, total});
            updateTotal();

            itemNameField.setText("");
            quantityField.setText("");
            priceField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers for Quantity and Price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotal() {
        double sum = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += (double) tableModel.getValueAt(i, 3);
        }
        totalLabel.setText("Total: " + sum);
    }

    private void generateBill(ActionEvent e) {
        double total = 0;
        receiptArea.setText("========= RECEIPT =========\n");
        receiptArea.append(String.format("%-15s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total"));

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String item = (String) tableModel.getValueAt(i, 0);
            int qty = (int) tableModel.getValueAt(i, 1);
            double price = (double) tableModel.getValueAt(i, 2);
            double rowTotal = (double) tableModel.getValueAt(i, 3);

            receiptArea.append(String.format("%-15s %-10d %-10.2f %-10.2f\n", item, qty, price, rowTotal));
            total += rowTotal;
        }

        receiptArea.append("\n---------------------------\n");
        receiptArea.append("Subtotal: " + total + "\n");

        double discount = 0;
        if (!discountField.getText().isEmpty()) {
            try {
                discount = Double.parseDouble(discountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid discount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double discountAmount = (total * discount) / 100;
        double finalAmount = total - discountAmount;

        receiptArea.append("Discount: " + discount + "%\n");
        receiptArea.append("Final Total: " + finalAmount + "\n");
        receiptArea.append("===========================\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BillingSystem().setVisible(true));
    }
}

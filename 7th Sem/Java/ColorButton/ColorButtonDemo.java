package ColorButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonDemo extends JFrame implements ActionListener {

    JButton redButton, blueButton, greenButton;

    public ColorButtonDemo() {
        // Set the layout manager
        setLayout(new FlowLayout());

        // Create buttons
        redButton = new JButton("RED");
        blueButton = new JButton("BLUE");
        greenButton = new JButton("GREEN");

        // Add action listeners
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Add buttons to frame
        add(redButton);
        add(blueButton);
        add(greenButton);

        // Set frame properties
        setTitle("Color Button Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            redButton.setBackground(Color.RED);
        } else if (e.getSource() == blueButton) {
            blueButton.setBackground(Color.BLUE);
        } else if (e.getSource() == greenButton) {
            greenButton.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new ColorButtonDemo();
    }
}
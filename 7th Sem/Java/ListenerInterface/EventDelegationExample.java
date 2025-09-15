package ListenerInterface;

import javax.swing.*;
import java.awt.event.*;

public class EventDelegationExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Delegation Example");
        JButton button = new JButton("Click Me");

        // Registering listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


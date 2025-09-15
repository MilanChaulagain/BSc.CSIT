package ListenerInterface;

import java.awt.event.*;
import javax.swing.*;

public class ButtonClickExample implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }

    public static void main(String[] args) {
        JButton button = new JButton("Click");
        button.addActionListener(new ButtonClickExample());
        
        JFrame frame = new JFrame();
        frame.add(button);
        frame.setSize(400, 100);
        frame.setVisible(true);
    }
}


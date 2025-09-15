package LayoutManagement;

import javax.swing.*;
import java.awt.*;


public class FlowLayoutDemo {
    JFrame frameObj;

    //Constructor
    FlowLayoutDemo() {
        frameObj = new JFrame();

        //Creating a button
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");

        //adding button to frame
        frameObj.add(b1);
        frameObj.add(b2);

        frameObj.setLayout(new FlowLayout());
        frameObj.setSize(300, 300);
        frameObj.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}

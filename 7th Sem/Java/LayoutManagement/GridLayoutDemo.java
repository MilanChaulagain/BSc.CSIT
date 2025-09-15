package LayoutManagement;

import java.awt.*;

public class GridLayoutDemo extends Frame {
    Button b1,b2,b3,b4,b5;

    GridLayoutDemo() {
        setSize(400,200);
        setTitle("GridLayout Demo");
        setLayout(new GridLayout(0,3));

        b1 = new Button("Button1");
        b2 = new Button("This is new long Button");
        b3 = new Button("button 3");
        b4 = new Button("button 4");
        b5 = new Button("button 5");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        setVisible(true);
    
    }

    public static void main(String[] args) {
        GridLayoutDemo frame = new GridLayoutDemo();
    }
}

package JScrollPaneExample;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneEx{

    public JScrollPaneEx() {
        JFrame frame = new JFrame("Scroll Pane Example");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        JTextArea ta = new JTextArea(10,10);
        ta.setBackground(Color.CYAN);

        JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(sp);

        frame.setVisible(true);

    }
    
     public static void main(String[] args) {
        new JScrollPaneEx();
     }
}

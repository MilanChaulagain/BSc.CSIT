package ListenerInterface;

import javax.swing.*;
import java.awt.event.*;;

public class FocusEventEx implements FocusListener{

    JTextField t1;
    JTextArea ta;

    public FocusEventEx() {
        JFrame frame = new JFrame("FocusEvent Example");
        frame.setSize(400, 500);
        frame.setLayout(null);

        t1 = new JTextField();
        t1.setBounds(50, 100, 100 , 30);

        frame.add(t1);
        t1.addFocusListener(this);

        ta = new JTextArea();
        ta.setBounds(200,50,300,300);
        frame.add(ta);

        frame.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        ta.setText(ta.getText()+ "\n" + "textbox focus gained");
    }

    @Override
    public void focusLost(FocusEvent e) {
        ta.setText(ta.getText()+ "\n" + "textbox focus lost");
    }

    public static void main(String[] args) {
        new FocusEventEx();
    }
    
}

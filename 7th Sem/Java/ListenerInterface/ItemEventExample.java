package ListenerInterface;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ItemEventExample extends JFrame implements ItemListener {

    JRadioButton rb1, rb2;
    ButtonGroup bg;
    JComboBox<String> cb;

    public ItemEventExample() {
        setTitle("Handling Item Event");
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

        rb1 = new JRadioButton("Male");
        rb2 = new JRadioButton("Female");

        bg = new ButtonGroup();

        String cn[] = {"Nepal", "India", "USA", "China"};

        cb = new JComboBox<>(cn);

        bg.add(rb1);
        bg.add(rb2);

        add(rb1);
        add(rb2);
        add(cb);

        rb1.addItemListener(this);
        rb2.addItemListener(this);

        setSize(400, 300);
        setVisible(true);
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == rb1 && rb1.isSelected() == true) 
            JOptionPane.showMessageDialog(this, "male is selected");
        else if(e.getSource() == rb2 && rb2.isSelected() == true) 
            JOptionPane.showMessageDialog(this, "female is selected");
        else if(e.getSource() == cb && e.getStateChange() == e.SELECTED)
            JOptionPane.showMessageDialog(this, "Your country is: " + cb.getSelectedItem());

    }

    public static void main(String[] args) {
        new ItemEventExample();
    }
    
}

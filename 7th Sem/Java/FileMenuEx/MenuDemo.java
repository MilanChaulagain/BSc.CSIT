package FileMenuEx;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends Frame {
    TextArea ta;

    public MenuDemo() {
        MenuBar mBar = new MenuBar();
        setMenuBar(mBar);


        Menu files = new Menu("Files");
        Menu date = new Menu("Date");
        Menu exit = new Menu("Exit");
        ta = new TextArea(10,40);
        ta.setBackground(Color.CYAN);
        add(ta);


        mBar.add(files);
        mBar.add(date);
        mBar.add(exit);

        //Create menu Items to menus

        Menu mnew = new Menu("New");
        files.add(mnew);

        Menu save = new Menu("Save");
        files.add(save);

        Menu open = new Menu("Open");
        files.add(open);

        files.addSeparator();

        MenuItem print = new MenuItem("Print");
        files.add(print);

        CheckboxMenuItem tb = new CheckboxMenuItem("Toolbar");
        files.add(tb);

        date.add(new MenuItem("Today"));
        exit.add(new MenuItem("Close"));

        setSize(500, 300);
        setVisible(true);
        
        // Equivalent to setDefaultCloseOperation for AWT
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // closes the window
                System.exit(0); // exits the program
            }
        });
    }

    public static void main(String[] args) {
        new MenuDemo();
    }
}

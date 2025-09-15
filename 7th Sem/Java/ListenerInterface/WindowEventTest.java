package ListenerInterface;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowEventTest implements WindowListener {

    JFrame frame = new JFrame();

    public WindowEventTest() {
        frame.setTitle("Handling Windows Event");
        frame.addWindowListener(this);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(frame, "Message: Welcome");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(frame, "Message: Byeee");

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    public static void main(String[] args) {
        new WindowEventTest();
    }
}

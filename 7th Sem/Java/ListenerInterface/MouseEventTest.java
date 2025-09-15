package ListenerInterface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest implements MouseListener {

    JFrame frame = new JFrame();
    DrawPanel panel = new DrawPanel();

    int x = -100, y = -100; // initialize offscreen
    int r1 = 60, r2 = 40;

    public MouseEventTest() {
        frame.setTitle("Handling Mouse Event");

        panel.addMouseListener(this);  // Add listener to the panel, not frame

        frame.add(panel);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        // Trigger repaint to draw the oval at new coordinates
        panel.repaint();
    }

    // Other empty methods required by MouseListener
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    // Custom JPanel class where drawing happens
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(x, y, r1, r2);
        }
    }

    public static void main(String[] args) {
        new MouseEventTest();
    }
}

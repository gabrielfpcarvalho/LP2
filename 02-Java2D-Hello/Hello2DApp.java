import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.getContentPane().setBackground(Color.gray);
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawRect(10, 10, w-20, h-20);
        g2d.setPaint(Color.orange);
        g2d.drawRect(34, 34, w-68, h-68);
        g2d.setPaint(Color.yellow);
        g2d.drawRect(58, 58, w-116, h-116);
        g2d.setPaint(Color.green);
        g2d.drawRect(82, 82, w-164, h-164);
        g2d.setColor(Color.cyan);
        g2d.drawRect(106, 106, w-212, h-212);
        g2d.setPaint(Color.blue);
        g2d.drawRect(130, 130, w-260, h-260);
        g2d.setPaint(Color.magenta);
        g2d.drawRect(154, 154, w-308, h-308);
    }
}

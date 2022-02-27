import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class RectEllipseApp2
{
    public static void main (String[] args) 
    {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame 
{
    Rect r1,r2,r3;
    Ellipse e1,e2,e3;

    RectEllipseFrame () 
    {
        this.addWindowListener (
            new WindowAdapter() {

                public void windowClosing (WindowEvent e) 
                {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);

        this.r1 = new Rect(50,50, 100,30);
        this.r2 = new Rect(50,100, 40,80);
        this.r3 = new Rect(50,300, 150,25);

        this.e1 = new Ellipse(70,200, 100,50);
        this.e2 = new Ellipse(210,40, 120,30);
        this.e3 = new Ellipse(200,100, 70,220);

    }

    public void paint (Graphics g) 
    {
        super.paint(g);
        
        this.r1.paint(g,Color.blue, Color.gray);
        this.r2.paint(g,Color.red, Color.magenta);
        this.r3.paint(g,Color.green, Color.black);

        this.e1.paint(g,Color.yellow, Color.cyan);
        this.e2.paint(g,Color.white, Color.pink);
        this.e3.paint(g,Color.black, Color.red);
    }
}

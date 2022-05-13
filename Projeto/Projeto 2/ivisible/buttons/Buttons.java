package ivisible.buttons;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import ivisible.*;
import ivisible.figures.*;

public class Buttons implements IVisible {
    private int x, y, w, h;
    private int x1, y1, w1, h1;
    public int index;
    public boolean focus;
    public Buttons (int index) {
        if (index == 0) {       //ellipse
            this.x = 25;
            this.y = 25;
            this.w = 50;
            this.h = 50;
            this.x1 = 30;
            this.y1 = 33;
            this.w1 = 40;
            this.h1 = 34;
            this.index = index;
        }

        else if (index == 1) {      //rect
            this.x = 25;
            this.y = 79;
            this.w = 50;
            this.h = 50;
            this.x1 = 30;
            this.y1 = 87;
            this.w1 = 40;
            this.h1 = 34;
            this.index = index;
        }

        else if (index == 2) {      //horline
            this.x = 25;
            this.y = 133;
            this.w = 50;
            this.h = 50;
            this.x1 = 32;
            this.y1 = 157;
            this.w1 = 68;
            this.h1 = 157;
            this.index = index;
        }

        else if (index == 3) {      //vertline
            this.x = 25;
            this.y = 187;
            this.w = 50;
            this.h = 50;
            this.x1 = 50;
            this.y1 = 194;
            this.w1 = 50;
            this.h1 = 230;
            this.index = index;
        }

    }

    public void paint(Graphics g) {
        Color figc, butc;
        figc = Color.darkGray;
        butc = Color.lightGray;

        if (focus) {
            figc = Color.black;
            butc = Color.gray;
        }

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(butc);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(figc);

        if (this.index == 0) {
            g2d.fill(new Ellipse2D.Double(this.x1, this.y1, this.w1, this.h1));
        }

        else if (this.index == 1) {
            g.fillRect(this.x1, this.y1, this.w1, this.h1);
        }

        else if (this.index == 2) {
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(this.x1, this.y1, this.w1, this.h1);
        }

        else if (this.index == 3) {
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(this.x1, this.y1, this.w1, this.h1);
        }
    }

    public boolean area (Point point) {
        if  (this.x <= point.x &&
                this.y <= point.y &&       //comparando o x e y do click do mouse com o x e y da área do botão
                point.x <= this.x + this.w &&       
                point.y <= this.y + this.h)    {
                return true;             
        }
        return false;
    }
}

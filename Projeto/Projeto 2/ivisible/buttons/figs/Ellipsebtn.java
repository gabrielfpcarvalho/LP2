package ivisible.buttons.figs;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import ivisible.buttons.Buttons;

public class Ellipsebtn extends Buttons {
    private int x1, y1, w1, h1;
    
    public Ellipsebtn () {
        this.x = 25;
        this.y = 25;
        this.w = 50;
        this.h = 50;
        this.x1 = 30;
        this.y1 = 33;
        this.w1 = 40;
        this.h1 = 34;
        this.index = 0;
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

        g2d.fill(new Ellipse2D.Double(this.x1, this.y1, this.w1, this.h1));
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

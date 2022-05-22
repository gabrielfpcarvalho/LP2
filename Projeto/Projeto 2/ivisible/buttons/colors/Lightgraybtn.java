package ivisible.buttons.colors;

import java.awt.*;
import ivisible.buttons.Buttons;

public class Lightgraybtn extends Buttons {
    public Lightgraybtn() {
        this.x = 25;
        this.y = 315;
        this.w = 20;
        this.h = 20;
        this.index = 8;
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.focus){
            g.setColor(Color.green);
            g2d.setStroke(new BasicStroke(2));
        }
        else{
            g.setColor(Color.black);
            g2d.setStroke(new BasicStroke(1));
        }

        g2d.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(Color.lightGray);
        g2d.fillRect(this.x,this.y, this.w,this.h);
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

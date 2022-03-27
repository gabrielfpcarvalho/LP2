package figures;

import java.awt.*;

public class Triangle extends Figure {
    public Triangle (int x, int y, int w) {
        this.x = x - (w/2);         //posição do triangulo é o centro da figura
        double h = (w * Math.sqrt(3))/2;    //calcula a altura do triângulo equilátero
        this.h = (int) h;
        if(h > this.h) {        //arredonda para cima a altura de double pra int
            this.h++;
        }
        this.y = y + (this.h/3);    //posição do triangulo é o centro da figura
        this.w = w;

       this.xa1 = this.x;
       this.ya1 = this.y - this.h;
       this.xa2 = this.x + this.w;
       this.ya2 = this.y;

        this.focus  = true; //assim que a figura é criada, ela é a figura foco.
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        g2d.drawLine(this.x, this.y, (this.x + this.w), this.y);
        g2d.drawLine(this.x, this.y, (this.x + this.w/2), (this.y - this.w));
        g2d.drawLine((this.x + this.w/2), (this.y - this.w), (this.x + this.w), this.y);

        if (focus) {    //se for a figura em foco, ela será destacada por um retangulo vermelho
            g2d.setStroke(new BasicStroke(3));
            g.setColor(Color.red);
            int x = this.x - 4;
            int y = this.y + 2; 
            int w = this.w + 8;
            g2d.drawLine(x, y, (x + w), y);
            g2d.drawLine(x, y, (x + w/2), (y - w));
            g2d.drawLine((x + w/2), (y - w), (x + w), y);

        }
    }
}
package figures;

import java.awt.*;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h) {
        this.x = x - (w/2);     //isso faz com que a coordenada da posição de x seja o centro da figura, não o vértice
        this.y = y - (h/2);     //isso faz com que a coordenada da posição de y seja o centro da figura, não o vértice
        //a posição da figura é o centro dela
        this.w = w;
        this.h = h;

        this.xa1 = x - (w/2);   //no caso do retângulo, x e xa1 assumem os mesmos valores, porém, em outras figuras não, por isso ele é necessário na subclasse Figure
        this.ya1 = y - (h/2);   //no caso do retângulo, y e ya1 assumem os mesmos valores, porém, em outras figuras não, por isso ele é necessário na subclasse Figure

        this.xa2 = x + (w/2);   //marca o final da figura na coordenada x
        this.ya2 = y + (h/2);   //marca o final da figura na coordenada y

        this.focus  = true; //assim que a figura é criada, ela é a figura foco. 
    }


    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g.setColor(Color.gray);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g.fillRect(this.x, this.y, this.w, this.h);

        if (focus) {    //se for a figura em foco, ela será destacada por um retangulo vermelho
            g2d.setStroke(new BasicStroke(3));
            g.setColor(Color.red);
            g2d.drawRect(this.x - 2, this.y - 2, this.w + 4, this.h + 4); // construindo o retângulo com medidas um pouco maiores que a figura para ser melhor visto
        }
    }
}
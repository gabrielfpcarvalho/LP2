package figures;
import java.awt.*;

public class VertLine extends Figure {
    public VertLine (int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.w = x2;    //na linha, o w e o h são respectivamente o x2 e y2
        this.h = y2;    //na linha, o w e o h são respectivamente o x2 e y2

        this.xa1 = x - 3;   //como a linha é muito fina, eu aumentei uns pixeis para almentar a area de clicar nela
        this.ya1 = y - 2;   

        this.xa2 = x2 + 3;  
        this.ya2 = y2 + 2;   

        this.focus  = true; //assim que a figura é criada, ela é a figura foco.
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        g2d.drawLine(this.x, this.y, this.w, this.h);

        if (focus) {                    //se for a figura em foco, ela será destacada por um retangulo vermelho
            g2d.setStroke(new BasicStroke(2));
            g.setColor(Color.red);
            g2d.drawRect(this.x - 2, this.y - 2, 5, (this.h - this.y) + 4);     // construindo o retângulo com medidas um pouco maiores que a figura para ser melhor visto
        }
    }
}

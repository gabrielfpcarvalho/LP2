package figures;
import java.awt.*;

public class Line extends Figure {
    int x2, y2;

    public Line (int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void print () {

        System.out.format("Esta linha foi traçada da posição (%d, %d) até a posição (%d, %d).\n",
            this.x, this.y, this.x2, this.y2);
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x, this.y, this.x2, this.y2);
    }
}

package figures;

import java.awt.*;

public class Line 
{
    private int x1, y1;
    private int x2, y2;

    public Line (int x1, int y1, int x2, int y2) 
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void print () 
    {
        System.out.format("A Linha foi traçada da posição (%d, %d) até a posição (%d, %d).\n",
            this.x1, this.x1, this.x2, this.y2);
    }

    public void paint (Graphics g, Color drawColor) 
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(drawColor);
        g2d.drawLine(this.x1,this.y1, this.x2,this.y2);
    }
}

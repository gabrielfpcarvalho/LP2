package ivisible.figures;

import java.awt.*;

public class VertLine extends Figure {

    private int x2, y2;
    
    public VertLine (int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.w = x2 - x;    
        this.h = y2 - y;
        this.x2 = x2;       //coordenadas x final da linha
        this.y2 = y2;       //coordenada y final da linha   

        this.focus = true; //assim que a figura é criada, ela é a figura foco.

        this.changefillcolor = 9;
    }

    void color () {

        if (this.changefillcolor > 12 ) {
            this.changefillcolor = 1;
        }


        //fillcolor
        if (this.changefillcolor == 1) {
            this.fillcolor = Color.darkGray;
        }

        else if (this.changefillcolor == 2) {
            this.fillcolor = Color.red;
        }

        else if (this.changefillcolor == 3) {
            this.fillcolor = Color.yellow;
        }

        else if (this.changefillcolor == 4) {
            this.fillcolor = Color.blue;
        }

        else if (this.changefillcolor == 5) {
            this.fillcolor = Color.orange;
        }

        else if (this.changefillcolor == 6) {
            this.fillcolor = Color.pink;
        }

        else if (this.changefillcolor == 7) {
            this.fillcolor = Color.cyan;
        }

        else if (this.changefillcolor == 8) {
            this.fillcolor = Color.magenta;
        }

        else if (this.changefillcolor == 9) {
            this.fillcolor = Color.black;
        }

        else if (this.changefillcolor == 10) {
            this.fillcolor = Color.white;
        }

        else if (this.changefillcolor == 11) {
            this.fillcolor = Color.gray;
        }

        else if (this.changefillcolor == 12) {
            this.fillcolor = Color.lightGray;
        }
    }

    public void paint(Graphics g) {
        color();
        //na linha, sempre que um repaint() acontecer, o valor final x2 e y2 serão atualizados
        this.x2 = this.x + this.w;
        this.y2 = this.y + this.h;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g.setColor(this.fillcolor);
        g2d.drawLine(this.x, this.y, this.x2, this.y2);

        if (focus) {                    //se for a figura em foco, ela será destacada por um retangulo vermelho
            g2d.setStroke(new BasicStroke(2));
            g.setColor(Color.red);
            g2d.drawRect(this.x - 2, this.y - 2, 5, this.h + 5);     // construindo o retângulo com medidas um pouco maiores que a figura para ser melhor visto
        }
    }

    public boolean area (Point point) {

        if  ((this.x - 2) <= point.x &&
             this.y <= point.y &&       //comparando o x e y do click do mouse com o x e y da área da figura pra ver se alguma figura foi clicada
             point.x <= (this.x + this.w) + 2 &&       //na linha, algumas variaveis são aumentadas em 2 pixeis para a área clicável ficar maior e facilitar para seleciona-la
             point.y <= this.y + this.h)    {
                return true;             
        }
        
        return false;
    }

    public void resize (int typedrag, Point LastPosition, Point NewPosition, boolean PlusMinus) {
        // aumentar/diminuir pelo teclado
        if(typedrag == 0) {
            if (PlusMinus) {
                if (this.h < 700){      //tamanho máximo = 700

                    this.y -= 1;
                    this.h += 2;
                }
            }
            else if (!PlusMinus) {
                if (this.h > 25) {      //tamanho mínimo = 25

                    this.y += 1;
                    this.h -= 2;
                }
            }
        }

        // aumentar/diminuir arrastando com mouse
        else if (typedrag == 3) {
            this.h += (NewPosition.y*2) - (LastPosition.y*2);
            this.y -= NewPosition.y - LastPosition.y; 
        }

        if (this.h < 25 || this.h > 700) { 
            this.h -= (NewPosition.y*2) - (LastPosition.y*2);
            this.y += NewPosition.y - LastPosition.y;
        }
    }

    public int cursor(Point position, boolean press) {

        if ((this.y + this.h - 5 <= position.y &&
             this.y + this.h >= position.y) &&
            (this.x - 3 <= position.x &&
             this.x + 3 >= position.x)) { 
                return 3;
        }

        else if (this.area(position) && press) {
            return 1;
        }

        else if (this.area(position)) {
            return 4;
        }
        
        else {
            return 0;
        }
    }
}
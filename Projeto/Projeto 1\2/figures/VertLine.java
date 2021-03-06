package figures;

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

        this.changedrawcolor = 12;
    }

    void color () {

        if (this.changedrawcolor > 12 ) {
            this.changedrawcolor = 1;
        }


        //drawcolor
        if (this.changedrawcolor == 1) {
            this.drawcolor = Color.white;
        }

        else if (this.changedrawcolor == 2) {
            this.drawcolor = Color.gray;
        }

        else if (this.changedrawcolor == 3) {
            this.drawcolor = Color.lightGray;
        }

        else if (this.changedrawcolor == 4) {
            this.drawcolor = Color.darkGray;
        }

        else if (this.changedrawcolor == 5) {
            this.drawcolor = Color.red;
        }

        else if (this.changedrawcolor == 6) {
            this.drawcolor = Color.yellow;
        }

        else if (this.changedrawcolor == 7) {
            this.drawcolor = Color.blue;
        }

        else if (this.changedrawcolor == 8) {
            this.drawcolor = Color.orange;
        }

        else if (this.changedrawcolor == 9) {
            this.drawcolor = Color.pink;
        }

        else if (this.changedrawcolor == 10) {
            this.drawcolor = Color.cyan;
        }

        else if (this.changedrawcolor == 11) {
            this.drawcolor = Color.magenta;
        }

        else if (this.changedrawcolor == 12) {
            this.drawcolor = Color.black;
        }
    }

    public void paint(Graphics g) {
        color();
        //na linha, sempre que um repaint() acontecer, o valor final x2 e y2 serão atualizados
        this.x2 = this.x + this.w;
        this.y2 = this.y + this.h;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g.setColor(this.drawcolor);
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
             this.y + this.h >= position.y)) {    
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
package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h) {
        this.x = x - (w/2);     //isso faz com que a coordenada da posição de x seja o centro da figura, não o vértice
        this.y = y - (h/2);     //isso faz com que a coordenada da posição de y seja o centro da figura, não o vértice
        //a posição da figura é o centro dela
        this.w = w;
        this.h = h;

        this.focus  = true; //assim que a figura é criada, ela é a figura foco. 

        this.changedrawcolor = 12;
        this.changefillcolor = 12;
    }

    void color () {
        if (this.changefillcolor > 12 ) {
            this.changefillcolor = 1;
        }

        if (this.changedrawcolor > 12 ) {
            this.changedrawcolor = 1;
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

    public void paint (Graphics g) {
        color();

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(this.fillcolor);
        g.fillRect(this.x, this.y, this.w, this.h);
        g2d.setStroke(new BasicStroke(2));
        g.setColor(this.drawcolor);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        if (focus) {    //se for a figura em foco, ela será destacada por um retangulo vermelho
            g2d.setStroke(new BasicStroke(3));
            g.setColor(Color.red);
            g2d.drawRect(this.x - 2, this.y - 2, this.w + 4, this.h + 4); // construindo o retângulo com medidas um pouco maiores que a figura para ser melhor visto
        }

        
    }
 
    public boolean area (Point point) {
        if  (this.x <= point.x &&
             this.y <= point.y &&       //comparando o x e y do click do mouse com o x e y da área da figura pra ver se alguma figura foi clicada
             point.x <= this.x + this.w &&       
             point.y <= this.y + this.h)    {
                return true;             
        }
        
        return false;
    }

    public void resize (int typedrag, Point LastPosition, Point NewPosition, boolean PlusMinus) {
        // aumentar/diminuir pelo teclado
        if (typedrag == 0) {
            if (PlusMinus) {
                if (this.w < 700) {

                    this.x -= 1;
                    this.w += 2;
                }
                if (this.h < 700) {

                    this.y -= 1;
                    this.h += 2;
                }
            }
            else if (!PlusMinus) {
                if (this.w > 25) {

                    this.x += 1;
                    this.w -= 2;
                }
                if (this.h > 25) {
                    
                    this.y += 1;
                    this.h -= 2;
                }
            }
        }


        // aumentar/diminuir arrastando com mouse
        else if (typedrag == 2) {
            this.w += (NewPosition.x*2) - (LastPosition.x*2);
            this.x -= NewPosition.x - LastPosition.x; 
        }

        else if (typedrag == 3) {
            this.h += (NewPosition.y*2) - (LastPosition.y*2);
            this.y -= NewPosition.y - LastPosition.y;
        }

        else if (typedrag == 5) {
                    this.w += (NewPosition.x*2) - (LastPosition.x*2);
                    this.x -= NewPosition.x - LastPosition.x;
                    this.h += (NewPosition.y*2) - (LastPosition.y*2);
                    this.y -= NewPosition.y - LastPosition.y;
        }

        if (this.w < 25 || this.w > 700) {
            this.w -= (NewPosition.x*2) - (LastPosition.x*2);
            this.x += NewPosition.x - LastPosition.x;
        }

        if (this.h < 25 || this.h > 700) {
            this.h -= (NewPosition.y*2) - (LastPosition.y*2);
            this.y += NewPosition.y - LastPosition.y;
        }
    }

    public int cursor(Point position, boolean press) {

        int h5 = (int) Math.round(this.h/5);    //h5 recebe 1/5 do valor de h
        int w5 = (int) Math.round(this.w/5);    //w5 recebe 1/5 do valor de w
        

        if ((this.x + this.w - 5 <= position.x &&
              this.x + this.w >= position.x) && 
             (this.y + (this.h/2) - h5 <= position.y &&
              this.y + (this.h/2) + h5 >= position.y)) {

                return 2;
        }

        else if ((this.y + this.h - 5 <= position.y &&
                   this.y + this.h >= position.y) && 
                  (this.x + (this.w/2) - w5 <= position.x &&
                   this.x + (this.w/2) + w5 >= position.x)) {

                       return 3;
        }

        else if (this.x + this.w - 4<= position.x &&
                 this.y + this.h - 4<= position.y &&
                 this.x + this.w >= position.x &&
                 this.y + this.h >= position.y) {
                    return 5;
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
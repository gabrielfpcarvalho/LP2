package figures;

import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int w, h;

    public int xa1, xa2, ya1, ya2; //xa1 -> coordenada x inicial da área da figura \\ xa2-> coordenada x final da área da figura \\ o mesmo vale para ya1 e ya2
    //estes inteiros servem para delimitar toda a área da figura e saber se o mouse clicou em cima dela ou não.
    

    public boolean focus = false;       //focus recebe verdadeiro quando uma figura é clicada, fazendo com que ganhe o contorno vermelho de foco
    public abstract void paint (Graphics g);
}

package figures;

import java.awt.Color;
import java.awt.Point;
import ivisible.*;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
    public int changefillcolor, changedrawcolor;
    Color fillcolor, drawcolor;
    public boolean focus;     
    //focus recebe verdadeiro quando uma figura é clicada, fazendo com que ganhe o contorno vermelho de foco.

    public abstract void color ();

    public abstract void resize (int typedrag, Point LastPosition, Point NewPosition, boolean PlusMinus);
    //método resize altera o tamanho da figura\\
    //typedrag - retorna o tipo do resize (diagonal, cima, baixo ou pelas teclas)\\ plusminus - se verdadeiro significa shift '+' foi pressionado, se falso shift '-' pressionado

    public abstract int cursor(Point position, boolean press);  //método cursor calcula em que área da figura o estilo do mouse será mudado

    //método paint, area, resize e cursor foram criados pois a forma de calcular os parametros é diferente entre a linha e o retangulo/elipse

}
package ivisible;

import java.awt.Graphics;
import java.awt.Point;

public interface IVisible {
    void    paint (Graphics g);
    boolean area (Point point);  //método area serve para verificar se o mouse clicou dentro da área da figura
    //método area foi criado pois a linha é diferente de calcular do retangulo e elipse e dos botões

}

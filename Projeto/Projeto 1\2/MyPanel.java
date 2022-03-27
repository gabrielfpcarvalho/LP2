import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import figures.*;

public class MyPanel extends JPanel {

    ArrayList<Figure> figlist = new ArrayList<Figure>();
    Figure focusfig = null;

    public MyPanel() {

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(700, 700));
        this.setVisible(true);

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed (MouseEvent evt) {
                focusfig = null;            //sempre que um click for feito, a ultima figura em foco perde o foco
                repaint();

                for (int i = 0; i < figlist.size(); i++) {
                    figlist.get(i).focus = false;

                    if  (figlist.get(i).xa1 <= evt.getX() &&
                        figlist.get(i).ya1 <= evt.getY() &&       //comparando o x e y do click do mouse com o x e y da área da figura pra ver se alguma figura foi clicada
                        evt.getX() <= figlist.get(i).xa2 &&       
                        evt.getY() <= figlist.get(i).ya2)    {
                            focusfig = figlist.get(i);             // guardando a figura em foco
                    }
                }

                if(focusfig != null) {              //esse if só será executado se uma figura for clicada, caso nada seja clicado, focusfig terá valor null
                    for (int i = 0; i<figlist.size(); i++) {
                        if (focusfig == figlist.get(i)){
                            figlist.get(i).focus = true;
                            figlist.remove(figlist.get(i));        // colocando a figura em foco para o final da lista de figuras, garantindo que ela tenha o maior z-order da lista.
                            figlist.add(focusfig);
                        }
                    }
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged (MouseEvent evt) {
                
            }
        });

        this.addKeyListener (new KeyAdapter() {

                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'q') {          //tecla q altera o foco entre as figuras
                        if (!figlist.isEmpty()) {
                            figlist.get(figlist.size() - 1).focus = false;      //tira o foco da última figura colocando falso
                            figlist.get(0).focus = true;        //coloca o foco na primeira figura da lista
                            focusfig = figlist.get(0);
                            figlist.remove(focusfig);
                            figlist.add(focusfig);      //coloca a figura em foco pro final da lista
                            repaint();
                        }
                    }

                    else if (evt.getKeyChar() == 'r') {      //tecla r gera um retângulo
                        int x = 350;
                        int y = 350;
                        int w = 90;
                        int h = 75;

                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //tira o foco da última figura colocando falso
                        }

                        Figure fig = new Rect(x,y, w,h);
                        figlist.add(fig);
                        focusfig = fig;             //figura criada é o novo foco
                        repaint(); 
                    }

                    else if (evt.getKeyChar() == 'e') {     //tecla e gera uma elipse
                        int x = 300;
                        int y = 350;
                        int w = 70;
                        int h = 85;

                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //tira o foco da última figura colocando falso
                        }

                        Figure fig = new Ellipse(x,y, w,h);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                        repaint();  
                    }

                    else if (evt.getKeyChar() == 'h') {         //tecla h gera uma linha horizontal
                        int x = 305;
                        int y = 350;
                        int x2 = 395;   //na linha, o w e o h são respectivamente o x2 e y2
                        int y2 = 350;   //na linha, o w e o h são respectivamente o x2 e y2
                        
                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //tira o foco da última figura colocando falso
                        }

                        Figure fig = new HorLine(x,y, x2,y2);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                        
                        repaint();
                    }

                    else if (evt.getKeyChar() == 'v') {         // tecla v gera uma linha vertical
                        int x = 350;
                        int y = 305;
                        int x2 = 350;    //na linha, o w e o h são respectivamente o x2 e y2
                        int y2 = 395;    //na linha, o w e o h são respectivamente o x2 e y2
                        
                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        }

                        Figure fig = new VertLine(x,y, x2,y2);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                        repaint();
                    }

                    else if (evt.getKeyChar() == 't') {     //tecla t gera um triângulo
                        int x = 350;
                        int y = 350;
                        int w = 80;

                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //tira o foco da última figura colocando falso
                        }

                        Figure fig = new Triangle(x, y, w);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                        repaint();  
                    }
                }
            }
        );
    }


    public void paint (Graphics g) {
        super.paint(g);

        for (Figure fig: figlist)
        {
            fig.paint(g);
        }
    }
}

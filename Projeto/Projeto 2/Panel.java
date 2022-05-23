import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import ivisible.buttons.*;
import ivisible.buttons.figs.*;
import ivisible.buttons.colors.*;
import ivisible.figures.*;

class Panel extends JPanel {

    ArrayList<Figure> figlist = new ArrayList<Figure>();
    private ArrayList<Buttons> butlist = new ArrayList<Buttons>();
    private Figure focusfig = null;
    private Buttons focusbut = null;
    private Point position = new Point();
    private boolean dragging2, dragging3, dragging5, dragging6, dragging7  = false;
    private Color bgcolor;


    Panel() {

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(700, 700));
        this.setLayout(null);
        this.setVisible(true);

        //adcionando todos os botões no panel
        butlist.add(new Ellipsebtn());
        butlist.add(new Rectbtn());
        butlist.add(new VertLinebtn());
        butlist.add(new HorLinebtn());
        butlist.add(new Whitebtn());
        butlist.add(new Blackbtn());
        butlist.add(new Darkgraybtn());
        butlist.add(new Graybtn());
        butlist.add(new Lightgraybtn());
        butlist.add(new Bluebtn());
        butlist.add(new Cyanbtn());
        butlist.add(new Yellowbtn());
        butlist.add(new Orangebtn());
        butlist.add(new Redbtn());
        butlist.add(new Pinkbtn());
        butlist.add(new Magentabtn());
        
    
        this.addMouseListener(new MouseAdapter() {

            public void mousePressed (MouseEvent evt) {
                int x, y, w, h, x2, y2;
                boolean but = false;
                focusfig = null;            //sempre que um click for feito, a ultima figura em foco perde o foco
                repaint();

                for (int i = 0; i < figlist.size(); i++) {
                    figlist.get(i).focus = false;

                    position.x = evt.getX();    //variaveis usadas no mouseDragged também
                    position.y = evt.getY();

                    if (figlist.get(i).area(position)) {    //verificando se a figura foi clicada
                        focusfig = figlist.get(i);  //caso tenha sido clicada, ela é a figura em foco
                    }
                }

                for (int i = 0; i < butlist.size(); i++) {
                    butlist.get(i).focus = false;

                    position.x = evt.getX();    
                    position.y = evt.getY();

                    if (butlist.get(i).area(position)) {  
                        if (focusbut == butlist.get(i)) {   //quando um botão é clicado novamente ele deixa de ficar selecionado
                            focusbut = null;
                            focusfig = null;
                        }

                        else{
                            focusbut = butlist.get(i);
                            focusfig = null;
                            but = true;
                        }
                    }
                }

                if (focusbut != null && !but) {

                    if (focusbut.index == 0){
                        x = position.x;
                        y = position.y;
                        w = 80;
                        h = 80;

                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        }
                        
                        Figure fig = new Ellipse(x,y, w,h);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                    }

                    else if (focusbut.index == 1) {
                        x = position.x;
                        y = position.y;
                        w = 80;
                        h = 80;

                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        }

                        Figure fig = new Rect(x,y, w,h);
                        figlist.add(fig);
                        focusfig = fig;             //figura criada é o novo foco
                    }

                    else if (focusbut.index == 2) {
                        x = position.x - 50;
                        y = position.y;
                        x2 = position.x + 50;   
                        y2 = position.y;   
                        
                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        }
    
                        Figure fig = new HorLine(x,y, x2,y2);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                    }
                    
                    else if (focusbut.index == 3) {
                        x = position.x;
                        y = position.y - 50;
                        x2 = position.x;    
                        y2 = position.y + 50;    
                        
                        if (!figlist.isEmpty()){
                            figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        }
    
                        Figure fig = new VertLine(x,y, x2,y2);
                        figlist.add(fig);
                        focusfig = fig;                 //figura criada é o novo foco
                    }

                    else if (focusbut.index > 3) {
                        boolean repeat = false;
                        for (int i = 0; i < figlist.size(); i++) {
                            figlist.get(i).focus = false;
        
                            position.x = evt.getX();    //variaveis usadas no mouseDragged também
                            position.y = evt.getY();
        
                            if (figlist.get(i).area(position)) {    //verificando se a figura foi clicada
                                focusfig = figlist.get(i);  //caso tenha sido clicada, ela é a figura em foco

                                if (focusbut.index == 4) {
                                    focusfig.changefillcolor = 10;
                                    repeat = true;
                                }

                                else if (focusbut.index == 5) {
                                    focusfig.changefillcolor = 9;
                                    repeat = true;
                                }

                                else if (focusbut.index == 6) {
                                    focusfig.changefillcolor = 1;
                                    repeat = true;
                                }

                                else if (focusbut.index == 7) {
                                    focusfig.changefillcolor = 11;
                                    repeat = true;
                                }

                                else if (focusbut.index == 8) {
                                    focusfig.changefillcolor = 12;
                                    repeat = true;
                                }

                                else if (focusbut.index == 9) {
                                    focusfig.changefillcolor = 4;
                                    repeat = true;
                                }

                                else if (focusbut.index == 10) {
                                    focusfig.changefillcolor = 7;
                                    repeat = true;
                                }

                                else if (focusbut.index == 11) {
                                    focusfig.changefillcolor = 3;
                                    repeat = true;
                                }

                                else if (focusbut.index == 12) {
                                    focusfig.changefillcolor = 5;
                                    repeat = true;
                                }

                                else if (focusbut.index == 13) {
                                    focusfig.changefillcolor = 2;
                                    repeat = true;
                                }

                                else if (focusbut.index == 14) {
                                    focusfig.changefillcolor = 6;
                                    repeat = true;
                                }

                                else if (focusbut.index == 15) {
                                    focusfig.changefillcolor = 8;
                                    repeat = true;
                                }
                            }
                        }

                        if (!repeat) {
                            if (focusbut.index == 4) {
                                bgcolor = Color.white;
                            }

                            else if (focusbut.index == 5) {
                                bgcolor = Color.black;
                            }

                            else if (focusbut.index == 6) {
                                bgcolor = Color.darkGray;
                            }

                            else if (focusbut.index == 7) {
                                bgcolor = Color.gray;
                            }

                            else if (focusbut.index == 8) {
                                bgcolor = Color.lightGray;
                            }

                            else if (focusbut.index == 9) {
                                bgcolor = Color.blue;
                            }

                            else if (focusbut.index == 10) {
                                bgcolor = Color.cyan;
                            }

                            else if (focusbut.index == 11) {
                                bgcolor = Color.yellow;
                            }

                            else if (focusbut.index == 12) {
                                bgcolor = Color.orange;
                            }

                            else if (focusbut.index == 13) {
                                bgcolor = Color.red;
                            }

                            else if (focusbut.index == 14) {
                                bgcolor = Color.pink;
                            }

                            else if (focusbut.index == 15) {
                                bgcolor = Color.magenta;
                            }
                        }
                        repeat = false;
                    }
                    focusbut = null;
                }

                if(focusfig != null) {              //esse if só será executado se uma figura for clicada, caso nada seja clicado, focusfig terá valor null
                    for (int i = 0; i<figlist.size(); i++) {
                        if (focusfig == figlist.get(i)){
                            figlist.get(i).focus = true;
                            figlist.remove(figlist.get(i));        // colocando a figura em foco para o final da lista de figuras, garantindo que ela tenha o maior z-order da lista.
                            figlist.add(focusfig);
                        }
                    }
                    

                    //alterar cursor quando mouse está pressionado
                    int i = 0;
                    boolean press = true;
                    if (focusfig.area(position)) {
                        i = focusfig.cursor(position, press);
                        NewCursor(i);
                    }
                    else {NewCursor(i);}
                }

                if(focusbut != null) {
                    for (int i = 0; i<butlist.size(); i++) {
                        if (focusbut == butlist.get(i)){
                            butlist.get(i).focus = true;
                        }
                    }
                }
                repaint();
            }

            public void mouseReleased (MouseEvent evt) {    //quando o botão do mouse é solto o tipo do cursor é alterado
                dragging2 = dragging3 = dragging5 = dragging6 = dragging7 = false;
                if (focusfig != null) {
                    int i = 0;

                    if (focusfig.area(position)) {
                        i = 4;
                        NewCursor(i);
                    }
                    else {NewCursor(i);}
                }
            }
        });

        this.addMouseMotionListener (new MouseMotionAdapter() {

            public void mouseMoved (MouseEvent evt) {
                //alterar cursor quando mouse NÃO está pressionado
                boolean press = false;
                int i = 0;
                position.x = evt.getX();
                position.y = evt.getY();

                if (focusfig != null) {
                    i = focusfig.cursor(position, press);
                    NewCursor(i);
                }
                else {NewCursor(i);}
            }

            public void mouseDragged (MouseEvent evt) {
                if (focusfig != null) {
                    Point newposition = new Point();
                    newposition.x = evt.getX(); 
                    newposition.y = evt.getY();

                    if ((focusfig.cursor(position, true) == 7 && !dragging2 && !dragging6 && !dragging3 && !dragging5) || dragging7) {
                        focusfig.resize(7, position, newposition, false);
                        position = newposition;
                        dragging7 = true;
                    }

                    else if ((focusfig.cursor(position, true) == 6 && !dragging2 && !dragging3 && !dragging5) || dragging6) {
                        focusfig.resize(6, position, newposition, false);
                        position = newposition;
                        dragging6 = true;
                    }

                    else if ((focusfig.cursor(position, true) == 2 && !dragging3 && !dragging5) || dragging2) {
                        focusfig.resize(2, position, newposition, false);
                        position = newposition;
                        dragging2 = true;
                    }

                    else if ((focusfig.cursor(position, true) == 3 && !dragging5) || dragging3) {
                        focusfig.resize(3, position, newposition , false);
                        position = newposition;
                        dragging3 = true;
                    }

                    else if (focusfig.cursor(position, true) == 5 || dragging5) {
                        focusfig.resize(5, position, newposition, false);
                        position = newposition;
                        dragging5 = true;
                    }

                    else if (focusfig.cursor(position, true) == 1) {

                        focusfig.x += evt.getX() - position.x; 
                        focusfig.y += evt.getY() - position.y;
                        position.x = evt.getX();
                        position.y = evt.getY();
                    }
                    repaint();
                }
            }
        });
        
        this.addKeyListener (new KeyAdapter() {

            public void keyPressed (KeyEvent evt) {
                int x, y, w, h, x2, y2;

                if (evt.getKeyChar() == 'q' || evt.getKeyChar() == 'Q') {          //tecla 'q' altera o foco entre as figuras
                    if (!figlist.isEmpty()) {
                        figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                        figlist.get(0).focus = true;        //coloca o foco na primeira figura da lista
                        focusfig = figlist.get(0);
                        figlist.remove(focusfig);
                        figlist.add(focusfig);      //coloca a figura em foco pro final da lista, garantindo que ela tenha o maior z-order
                    }
                }

                else if (evt.getKeyChar() == 'r' || evt.getKeyChar() == 'R') {      //tecla r gera um retângulo
                    x = position.x;
                    y = position.y;
                    w = 80;
                    h = 80;

                    if (!figlist.isEmpty()){
                        figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                    }

                    Figure fig = new Rect(x,y, w,h);
                    figlist.add(fig);
                    focusfig = fig;             //figura criada é o novo foco
                }

                else if (evt.getKeyChar() == 'e' || evt.getKeyChar() == 'E') {     //tecla e gera uma elipse
                    x = position.x;
                    y = position.y;
                    w = 80;
                    h = 80;

                    if (!figlist.isEmpty()){
                        figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                    }
                    
                    Figure fig = new Ellipse(x,y, w,h);
                    figlist.add(fig);
                    focusfig = fig;                 //figura criada é o novo foco
                }

                else if (evt.getKeyChar() == 'h' || evt.getKeyChar() == 'H') {         //tecla h gera uma linha horizontal
                    x = position.x - 50;
                    y = position.y;
                    x2 = position.x + 50;   
                    y2 = position.y;   
                    
                    if (!figlist.isEmpty()){
                        figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                    }

                    Figure fig = new HorLine(x,y, x2,y2);
                    figlist.add(fig);
                    focusfig = fig;                 //figura criada é o novo foco
                }

                else if (evt.getKeyChar() == 'v' || evt.getKeyChar() == 'V') {         // tecla v gera uma linha vertical
                    x = position.x;
                    y = position.y - 50;
                    x2 = position.x;    
                    y2 = position.y + 50;    
                    
                    if (!figlist.isEmpty()){
                        figlist.get(figlist.size() - 1).focus = false;      //caso tenha algo na lista, tira o foco da última figura colocando o valor falso
                    }

                    Figure fig = new VertLine(x,y, x2,y2);
                    figlist.add(fig);
                    focusfig = fig;                 //figura criada é o novo foco
                }

                else if ((evt.getKeyChar() == 'f' || evt.getKeyChar() == 'F') && focusfig != null) {  //tecla f altera a cor de Fundo da imagem
                    focusfig.changefillcolor += 1;
                }

                else if ((evt.getKeyChar() == 'c' || evt.getKeyChar() == 'C') && focusfig != null) {  //tecla c altera a cor de Contorno da imagem
                    focusfig.changedrawcolor += 1;
                    
                }

                else if (evt.getKeyChar() == '+' && focusfig != null) {     // shift "+" aumenta o tamanho da figura
                    focusfig.resize(0, position, position, true);      //o método recebe true se a imagem aumentar de tamanho
                }

                else if (evt.getKeyChar() == '_' && focusfig != null) {     // shift "-" diminui o tamanho da figura
                    focusfig.resize(0, position, position, false);     //o método recebe false se a imagem diminuir de tamanho
                }

                else if (evt.getKeyCode() == 127 && focusfig != null) {   // figura foco é deletada quando aperta delete ou del
                    figlist.remove(focusfig);
                }
                
                else if (evt.getKeyCode() == 37 && focusfig != null) {      //seta para esquerda muda a posição da figura
                    focusfig.x -= 2;
                }

                else if (evt.getKeyCode() == 38 && focusfig != null) {      //seta para cima muda a posição da figura
                    focusfig.y -= 2;
                }

                else if (evt.getKeyCode() == 39 && focusfig != null) {      //seta para direita muda a posição da figura
                    focusfig.x += 2;
                }

                else if (evt.getKeyCode() == 40 && focusfig != null) {      //seta para baixo muda a posição da figura
                    focusfig.y += 2;
                }
                
                repaint();      //repaint depois de qualquer tecla pressionada
            }
        });
    }

    private void NewCursor (int i) {     //alterna entre os tipos de cursores dependendo de onde o mouse é posicionado
        if (i == 1) {
            super.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }

        else if (i == 2 || i == 6) {
            super.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        }

        else if (i == 3 || i == 7) {
            super.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        }

        else if (i == 4) {
            super.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        else if (i == 5) {
            super.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        }

        else if (i == 0) {
            super.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void paint (Graphics g) {
        super.paint(g);
        super.setBackground(bgcolor);

        for (Figure fig: figlist)
        {
            fig.paint(g);
        }

        for (Buttons but: butlist)
        {
            but.paint(g);
        }
    }
}
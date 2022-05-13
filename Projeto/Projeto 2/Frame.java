import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;

import ivisible.figures.*;

class Frame extends JFrame {

    private Panel panel;

    Frame() {
        panel = new Panel();

        this.setVisible(true);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Editor Grafico Vetorial");

        try {
            FileInputStream   f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            panel.figlist = (ArrayList<Figure>) o.readObject();
            panel.repaint();
            o.close();
        }

        catch (Exception x) {
            System.out.println("ERRO NA LEITURA!  " + x);
        }

        this.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent evt) {
                try {
                    FileOutputStream    f = new FileOutputStream("proj.bin");
                    ObjectOutputStream  o = new ObjectOutputStream(f);
                    o.writeObject(panel.figlist);
                    o.flush();
                    o.close();
                }
                catch (Exception x) {
                    System.out.println("ERRO NA GRAVAÇÃO!  "+ x);
                }
                System.exit(0);
            }
        });
    }
}
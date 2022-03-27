import javax.swing.*;

class ListFrame extends JFrame {

    MyPanel panel;

    public ListFrame() {
        panel = new MyPanel();

        this.setVisible(true);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setTitle("Editor Grafico Vetorial");
    }
}
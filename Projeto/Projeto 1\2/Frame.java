import javax.swing.*;

class Frame extends JFrame {

    Panel panel;

    public Frame() {
        panel = new Panel();

        this.setVisible(true);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setTitle("Editor Grafico Vetorial");
    }
}
package atesetme;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Renderer extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        AtesEtme.atesEtme.repaint(g);
    }
    
    
    
}

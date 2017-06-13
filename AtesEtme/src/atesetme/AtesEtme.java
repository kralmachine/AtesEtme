package atesetme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class AtesEtme extends JFrame implements ActionListener{

   public static final int WIDTH=600,HEIGHT=600;
   
   public static AtesEtme atesEtme;
   
   public Random random;
   
   public boolean durum=false;
   
   public Rectangle r1,r2;
   
   public int x=100,y=100,vX=0,vY=0;
   
   public Timer zaman;
   
   public Renderer renderer;
    
    public AtesEtme() {
        JFrame pencere=new JFrame("Ateş Etme");
        
        random=new Random();
        vX=random.nextInt(10);
        vY=random.nextInt(10);
        
        r1=new Rectangle(WIDTH-45, 0, 40, 40);
        r2=new Rectangle(0, 0, 40, 40);
        
        zaman=new Timer(20, this);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setResizable(false);
        pencere.setSize(new Dimension(WIDTH, HEIGHT));
        pencere.setLocationRelativeTo(null);
        pencere.requestFocus();
        
        random=new Random();
        pencere.add(renderer=new Renderer());
      
        
        zaman.start();
        pencere.setVisible(true);
    }

    public static void main(String[] args) {
        atesEtme=new AtesEtme();
    }

    public void repaint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
         g.setColor(Color.CYAN);
        g.fillRect(250, 500, 100, 10);
        
        g.setColor(Color.red);
        g.fillOval(r1.x, r1.y, r1.width, r1.height);
        
        g.setColor(Color.red);
        g.fillOval(r2.x, r2.y, r2.width, r2.height);
        
       
       
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if (!durum) {
            r2.y+=5;
            r2.x+=5;
            
            r1.y+=5;
            r1.x-=5;
            if (r2.y==545) {
                 durum=true;
            }
            
            if (r1.y==545) {
               durum=true;
            }
           
            
        }
        else{
            r2.y-=5;
            r2.x-=5;
            
             r1.y-=5;
            r1.x+=5;
            
            
            if (r2.y==0) {
                durum=false;
            }
            if (r1.y==555) {
                    durum=false;
                }
        }
       
        renderer.repaint();
    }

   
    
  
    

    
  
  
}

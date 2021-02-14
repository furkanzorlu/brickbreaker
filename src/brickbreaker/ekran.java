/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import com.sun.jmx.snmp.EnumRowStatus;
import com.sun.nio.sctp.AssociationChangeNotification;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PageAttributes;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.security.auth.DestroyFailedException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author furkan
 */
class Ates{
    private int x;
    private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
        
}
public class ekran extends JPanel implements KeyListener,ActionListener{
    
  ArrayList<Block> blocks=new ArrayList<Block>();
 // Block paddle=new Block(175,480,150,25,"paddle.png");

    Timer timer=new Timer(5, this);
   private ArrayList<Ates> atesler=new ArrayList<Ates>();
    private int atesdiry=5;
    
  
    
    private int brickx=300;
    private int bricky=550;
    private int xdirbrick=20;
    private int ydirbrick=20;
     private int topx = 120;
    private int ballposY = 350;
      private int topydir=2;
    private int topxdir=2;
    private BufferedImage image;
    
    public boolean kontrolet(){
         if(new Rectangle(topx,ballposY,20,20).intersects(new Rectangle(0, 560, 1500, 15))){
            return  true;
             
         }
      return false;
        
    }
    public boolean  kazan(){
        if(new Rectangle(brickx,bricky,100,10).intersects(new Rectangle(150, 0, 50, 15))){
            return  true;
             
         }
      return false;
        
    }
     public void kontrolett(){
        for(Ates ates:atesler){
            blocks.forEach(block -> {
			if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(block) && !block.destroyed) {
			
				block.destroyed = true;
				
			}
		});
         
                
            }
            
        
        
        
     }
   
    

    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int c=ke.getKeyCode();
        
        if (c ==KeyEvent.VK_LEFT) {
            if (brickx<=0) {
                brickx=0;
                
            }else{
                brickx-=xdirbrick;
            }
            
        }
        else if (c==KeyEvent.VK_RIGHT) {
            if (brickx>=700) {
                brickx=700;
                
            }else{
                brickx +=xdirbrick;
            }
            
        }
        else if (c==KeyEvent.VK_SPACE) {
            atesler.add(new Ates(brickx+35,490 ));
            
            
            
        }
         else if (c==KeyEvent.VK_UP) {
            if (brickx>=700) {
                brickx=700;
                
            }else{
                bricky -=ydirbrick;
            }
            
        }
        
            
            
        
        
       
        }
    

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        topx +=topxdir;
        if (topx >=770) {
            topxdir= -topxdir;
            
            
        }
        if (topx<=0) {
            topxdir= - topxdir;
            
        }
        ballposY +=topydir;
         if (ballposY >=550) {
            topydir= -topydir;
            
            
        }
        if (ballposY<=0) {
            topydir= - topydir;
            
        }
        
         if (new Rectangle(brickx,bricky,100,10).intersects(new Rectangle(topx,ballposY,20,20))) {
             topydir*=-1;
            
        
            }
          for (Ates ates: atesler) {
            ates.setY(ates.getY() -atesdiry);
            
            
        }
        
        
       
    
      
         
         
          
            
         }
         
           
                        
        
    
  

   
     public void paint(Graphics grphcs){
          super.paint(grphcs);
        
          
          
          
            
            
          grphcs.setColor(Color.yellow);
          grphcs.fillRect(150, 0, 50, 15);
          grphcs.setColor(Color.white);
          grphcs.fillRect(0, 560, 1500, 15);
          
          grphcs.setColor(Color.red);
        
        grphcs.fillRect(brickx, bricky, 100, 10);
       
         grphcs.setColor(Color.GREEN);
        grphcs.fillOval(topx, ballposY, 20, 20);
        grphcs.setColor(Color.red);
        
              
            
        
        for(Ates ates:atesler){
            grphcs.fillRect(ates.getX(),ates.getY(), 10, 20);
            
            
        }
       
      blocks.forEach(block -> {
			block.draw(grphcs, this);
		});
    //  paddle.draw(grphcs, this);
    blocks.forEach(block -> {
			if(new Rectangle(topx,ballposY,20,20).intersects(block) && !block.destroyed) {
				topydir= -topydir;
				block.destroyed = true;
				
			}
		});
    kontrolett();
   
    
   
    
       
    
          
             
         
 {
             
         }
    
    if (kontrolet()==true) {
        String message="Kybettiniz tekrar deneyiniz";
             
                 
                 JOptionPane.showMessageDialog(this, message);
            
            
            timer.stop();
            System.exit(0);
            
            
 
           
           
            
        
    }
         if (kazan()==true) {
             String message="Kazandınız tebrikler";
             
                 
                 JOptionPane.showMessageDialog(this, message);
            
             timer.stop();
             System.exit(0);
               
                 
             
             
             
         }
   
      
           
     
        
        
        
     

        repaint();
     }
            
    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    

    public ekran() {
         
        for (int i = 0; i < 13; i++)
			blocks.add(new Block((i*60+2),110,50,15,"blue.png"));
           for (int i = 0; i < 13; i++)
			blocks.add(new Block((i*60+2),50,50,15,"blue.png"));
            for (int i = 0; i < 13; i++)
			blocks.add(new Block((i*60+2),10,50,15,"blue.png"));
             for (int i = 0; i < 13; i++)
			blocks.add(new Block((i*60+2),300,50,15,"blue.png"));
        
       // for (int i = 0; i < 13; i++)
			//blocks.add(new Block((i*60+2),110,60,25,"blue.png"));
        
        timer.start();
    }
    
    
}


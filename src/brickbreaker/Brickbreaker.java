/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author furkan
 */
public class Brickbreaker extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Brickbreaker balık=new Brickbreaker("brick oyunu");
       balık.setResizable(false);
       balık.setFocusable(false);
       balık.setSize(800,600);
       balık.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ekran oyun=new ekran();
       oyun.requestFocus();
       oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        balık.add(oyun);
        balık.setVisible(true);
       
        // TODO code application logic here
    }

    public Brickbreaker(String string) throws HeadlessException {
        super(string);
    }
    
}

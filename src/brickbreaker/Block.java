/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

/**
 *
 * @author furkan
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Rectangle {

	Image pic;
        Image picc;
	boolean destroyed;
	
	int movX,movY;
        
    

	Block(int x, int y, int w, int h,String s ) {
		this.x = x;
		this.y = y;
		
		movX = 3;
		movY = 3;

		this.width = w;
		this.height = h;
		try {
			pic = ImageIO.read(new File("blue.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                
		
	}

	public void draw(Graphics g, Component c) {
		if (!destroyed)
			g.drawImage(pic, x, y, width, height,c);
                
	}

}

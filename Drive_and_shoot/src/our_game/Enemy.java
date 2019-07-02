package our_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	Image img;
	static int x, y;
	static boolean isAlive = true;
	
	public Enemy(int startX, int startY, String location){
		x = startX;
		y = startY;
		ImageIcon l = new ImageIcon(location); 
		img = l.getImage();
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean Alive(){
		return isAlive;
	}
	public Image getImage(){
		return img;
	}
	public void move (int dx){
		x = x - dx - dx;
		
	}
	public void move1 (int dx){
		x = x - dx - dx;
		
	}
	
}

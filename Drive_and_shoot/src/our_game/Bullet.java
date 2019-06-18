package our_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
	int x, y;
	Image img;
	boolean visible = true;
	
	public Bullet(int startX, int startY){
		x = startX;
		y = startY;
		ImageIcon newBullet = new ImageIcon("src/res/bullet_img.gif");
		img = newBullet.getImage();
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean getVisible(){
		return visible;
	}
	public Image getImage(){
		return img;
	}
	public void rightMove (){
		x = x + 5;
		
		if(x>Enemy.x && y>=Enemy.y)
			Enemy.isAlive = false;
		
		if(x>1024) visible = false;
		
	}
	
	public void leftMove (){
		x = x - 5;
		if(x<Enemy.x && y>=Enemy.y)
			Enemy.isAlive = false;
		if(x < 0) visible = false;
	}
}

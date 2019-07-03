package our_game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Dude {
	int x, dx , y, dy, nx2, nx, h, b;
	Image still, rstill, car, rcar, fly;
	static ArrayList bullets;

	ImageIcon i = new ImageIcon("src/res/still.gif");
	ImageIcon m = new ImageIcon("src/res/rcar.png");
	ImageIcon n = new ImageIcon("src/res/rcar.png");
	ImageIcon j = new ImageIcon("src/res/rstill.gif");
	ImageIcon k = new ImageIcon("src/res/fly.gif");

	public Dude(){
		still = m.getImage();//right movement image
		fly = k.getImage();//fly image
		x = 50;
		y = 435;
		nx2 = 1024;//rightmost x coordinate
		nx = 0;//leftmost x coordinate
		dy = 0;
		h = 2;
		bullets = new ArrayList();//arraylist of bullets
		b = 1;
	}

	public void rightFire(){
	    Bullet z = new Bullet(390, y+20);
	    bullets.add(z);//adding bullet object
	}

	public void leftFire(){
	    Bullet z = new Bullet(310, y+20);
	    bullets.add(z);
	    
	}
	public static ArrayList getBullets()
	{
		return bullets;//returning arraylist of bullets

	}

	public void move(){
/*
		as the x indcreases, nx & nx2 also indcreases accordingly
*/
		x = x + dx + dx;
		nx2 = nx2 + dx + dx;
		nx = nx + dx + dx;
		y = y + dy;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getdx(){
		return dx;
	}

	public int getnx2(){
		return nx2;
	}

	public int getnx(){
		return nx;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		
		if (key == KeyEvent.VK_RIGHT)
		{dx = 1; still = i.getImage();b = 1;}
		
		if (key == KeyEvent.VK_UP)
			{dy = -1; h = 1;}
		
		if (key == KeyEvent.VK_SPACE && b == 1){
			rightFire();
		}
		
		if (key == KeyEvent.VK_SPACE && b == -1){
			leftFire();
		}
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
		{dx = 0; still = n.getImage();b = -1;}
		
		if (key == KeyEvent.VK_RIGHT)
		{dx = 0; still = n.getImage();b = 1;}
		
		if (key == KeyEvent.VK_UP)
			{dy = 2; h = 2;}
	}

	public Image getImage(){
		return still;
	}

	public Image getFlyImage(){
		return fly;
	}

}

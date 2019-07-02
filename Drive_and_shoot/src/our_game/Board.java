package our_game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	Dude p;
	Image img;
	Timer time;
	Enemy en1;

	static boolean isRunning = true;
//Enemy en2;
	public Board() {
		p = new Dude();

		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("src/res/background.png");
		img = i.getImage();

		time = new Timer(5, this);
		time.start();
		en1 = new Enemy(1024, 418, "src/res/enemy2.png");
		// en2 = new Enemy(700, 350, "F:\\CSE\\Java practice\\DriveCar\\enemy.gif");
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList bullets = Dude.getBullets();

		for (int w = 0; w < bullets.size(); w++) {
			Bullet m = (Bullet) bullets.get(w);
			if (m.getVisible() == true && p.b == 1)
				m.rightMove();
			else if (m.getVisible() == true && p.b == -1)
				m.leftMove();
			else
				bullets.remove(w);
		}
		p.move();

		if (p.x % 1024 >= 50)
			en1.move(1);
		// if(p.nx > 500)
		// en2.move(p.getdx());
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if ((p.getX() - 20) % 2048 == 0)
			p.nx = 0;
		if ((p.getX() - 1044) % 2048 == 0)
			p.nx2 = 0;

		System.out.println("x = " + p.getX() + "   nx2 = " + p.nx2 + "   nx = " + p.nx + "py = " + p.y + ", ex= "
				+ en1.getX() + " ey= " + en1.getY() + " is " + en1.isAlive);

		g2d.drawImage(img, 1024 - p.nx2, 0, null);
		if (p.getX() >= 20)
			g2d.drawImage(img, 1024 - p.nx, 0, null);
		if (p.getY() > 435)
			p.y = 435;
		if (p.getY() < 20)
			p.y = 20;

		g2d.drawImage(p.getImage(), 300, p.getY(), null);
		if (p.h == 1)
			g2d.drawImage(p.getFlyImage(), 335, p.getY() + 33, null);

		ArrayList bullets = Dude.getBullets();

		for (int w = 0; w < bullets.size(); w++) {
			Bullet m = (Bullet) bullets.get(w);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);
		}
		if (p.x % 1024 >= 50) {
			if (en1.getX() < 0) {
				en1.x = 1024;
				en1.isAlive = true;
			}
			if (en1.Alive() == true) {

				g2d.drawImage(en1.getImage(), en1.getX(), en1.getY(), null);

			}
		}

		ImageIcon img = new ImageIcon("src/res/boom.png");
		if (en1.isAlive && Math.abs(300 - en1.getX()) <= 94 && Math.abs(p.y - en1.getY()) <= 38) {
			System.out.println(p.x + " " + p.y + ", " + en1.getX() + " " + en1.getY());
			System.out.println("Collide");
			
				g2d.drawImage(img.getImage(), 300+70, 435, null);
				en1.isAlive = false;
				isRunning = false;
				time.stop();
		}
		

//			 if(p.getnx() > 500)
//				 if(en2.Alive() == true)
//					 g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);

	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
	}
}

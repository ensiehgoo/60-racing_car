package our_game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Frame {
	
		
		
		public static void main(String[]args) throws Exception{
			JFrame frame = new JFrame("Drive and Shoot");
			
			frame.add(new Board());
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1024,548);
			frame.setVisible(true);
			
			AudioInputStream sample;
			sample = AudioSystem.getAudioInputStream(new File("src/Resources/car.wav"));
			
			Clip clip = AudioSystem.getClip();
			clip.open(sample);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}


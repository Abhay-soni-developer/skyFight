import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.management.timer.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class GameFrame extends JFrame {

	
	private int frameWidth;
	private int frameHeight;
	private String title;
	GamePanel gameplay;
	



	public void Closing(){
		int choice = JOptionPane.showConfirmDialog(this, "are you sure you want to exit", "EXIT SKY FIGHT", JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "thank you for playing sky fight ");
			this.dispose();
		}
		else if (choice == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "You seem to be the choosen one" );
			return;
		}
	}
					
				
	public GameFrame(int width, int height , String title) {
	
		this.frameWidth =width;
		this.frameHeight = height;
		this.title = title;
		
		this.setLocationRelativeTo(null);
		this.setSize(this.frameWidth,this.frameHeight);
		this.setTitle(this.title);
		
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			 public void windowClosing(WindowEvent e) {
				
				Closing();
				
			}
			
			
		});
		
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		gameplay = new GamePanel(this.frameWidth,this.frameHeight,this.title);	
		this.getContentPane().add(gameplay);
		setVisible(true);
		
	
	}
}

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import jaco.mp3.player.MP3Player;

public class Missile {
	private int x;
	private int y;
	
	private int width;
	private int height;
	private Image missileimg;
	private boolean visible = false;
	MP3Player attackSound ;
	
	
	
	public Rectangle getRectangle(){
		Rectangle missilebox = new Rectangle(this.x, this.y, missileimg.getWidth(null), missileimg.getHeight(null));
		return missilebox;
		
	}
	
	public void missileMove(){
		
		
		if(x < Launcher.FrameWidth){
		x=x+3;
		}
		else
		{
			setVisible(false);
			
				
		}
		
		
		
	}
	
	
	
	public Missile() {
		
		
		missileimg = new ImageIcon(Missile.class.getResource("assests/rocket.png")).getImage();
		setVisible(true);
		attackSound = new MP3Player(Missile.class.getResource("assests/missile launch.MP3"));
		attackSound.play();
		
		this.height = missileimg.getHeight(null);
		this.width = missileimg.getWidth(null);
		
		
		
	}






	public boolean isVisible() {
		return visible;
	}






	public void setVisible(boolean visible) {
		this.visible = visible;
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



	public Image getMissileimg() {
		return missileimg;
	}








}

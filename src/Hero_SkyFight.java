import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Hero_SkyFight {
	
	
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int velY;
	private boolean visible = false;
	private ArrayList<Missile> missileList = new ArrayList<>();
	
	
	private Image heroimg ;
	
	
	
	public Rectangle getRectangle(){
		Rectangle missilebox = new Rectangle(this.x, this.y, heroimg.getWidth(null), heroimg.getHeight(null));
		return missilebox;
		
	}
	
	
	
	
	public void dontMove(){
		velX = 0;
		velY = 0;
		
	}

	public void move(){
		
		x = x + velX;
		y = y + velY;
		System.out.println(x);
		if(x<0 || x>Launcher.FrameWidth){
			this.x=0;
		}
		if(y<0 || y>Launcher.FrameHeight){
			this.y=0;
		}
	}
	
	
	public void launchMissile(){
		
		Missile missile = new Missile();
		
		missile.setX(this.getX()+heroimg.getWidth(null));
		missile.setY(this.getY());
		
		
		missileList.add(missile);
		
	
		

	}

	public void direction(KeyEvent e){

		if(visible){
			if(e.getKeyCode()== KeyEvent.VK_UP){
				velY=-4;
			}
			else if(e.getKeyCode()== KeyEvent.VK_DOWN)
			{
				velY=4;
			}
			else if(e.getKeyCode()== KeyEvent.VK_LEFT)
			{
				velX=-4;
			}
			else if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			{
				velX=4;
			}

			move();


		}

	}




	

	public int getX() {
		if(x> Launcher.FrameWidth )
			return Launcher.FrameWidth;
		else if (x<0)
			return 0;
		else
		 return x;
		

		
	}

	public int getY() {
		if(y>Launcher.FrameHeight-100){
		return Launcher.FrameHeight-100;
		}
		else if(y<0){
			return 0;
		}
		else 
			return y;
		

			
		
	}


  public Hero_SkyFight() {
	  
	  heroimg = new ImageIcon(GamePanel.class.getResource("assests/Spaceship.png")).getImage();
	  setVisible(true);
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}

public ArrayList<Missile> getMissileList() {
	return missileList;
}

public void setMissileList(ArrayList<Missile> missileList) {
	this.missileList = missileList;
}





public void attackAction(KeyEvent e) {
//	if(e.getKeyCode()==KeyEvent.VK_SPACE){
	if(isVisible()){
		this.launchMissile();
	}
	
//	System.out.println("key has been typed");
//	}
//	
}

public Image getHeroimg() {
	return heroimg;
}




public void setHeroimg(Image heroimg) {
	this.heroimg = heroimg;
}



}

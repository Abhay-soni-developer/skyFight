import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy_SkyFight {
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible = false;
	private Image enemyImg = new ImageIcon(Enemy_SkyFight.class.getResource("assests/alienship.png")).getImage();
	static Image enemyDead = new ImageIcon(Enemy_SkyFight.class.getResource("assests/blastimage.png")).getImage();
	
	
	
	public Rectangle getRectangle(){
		Rectangle missilebox = new Rectangle(this.x, this.y, enemyImg.getWidth(null), enemyImg.getHeight(null));
		return missilebox;
		
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


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public Enemy_SkyFight(int x , int y ) {
		this.x = x ;
		this.y = y;
		setVisible(true);
		
	}
	public int enemypath(){
		this.x--;
		return x;

	}


	public Image getEnemyImg() {
		return enemyImg;
	}

	public Image getEnemyDead() {
		return enemyDead;
	}



}

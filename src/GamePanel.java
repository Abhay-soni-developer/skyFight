import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import jaco.mp3.player.MP3Player;

public class GamePanel extends JPanel{

	Timer timer;

	private int Width;
	private int Height;
	private String Title;
	private Image background = new ImageIcon(GamePanel.class.getResource("assests/game background .gif")).getImage();
	MP3Player themesong = new MP3Player(GamePanel.class.getResource("assests/space song.mp3"));
	Hero_SkyFight hero ;
	private ArrayList<Enemy_SkyFight> enemyList = new ArrayList<>();
	int DELAY = 15;
	private Image blastImg = new ImageIcon(GamePanel.class.getResource("assests/blastimage.png")).getImage();
	private Image gameOver = new ImageIcon(GamePanel.class.getResource("assests/GameOver.png")).getImage();
	MP3Player explosionsound = new MP3Player(GamePanel.class.getResource("assests/Explosion.mp3"));
	
	
	public void enemycreation(){
		
		
		int enemyPosition[][] = new int[][]
				{
			{800,200},{1000,300},{1200,153},{1500,320},{950,250},{1050,300},
			{1300,153},{1300,300},{1500,200}
			
		};
		
		for(int i=0;i<enemyPosition.length;i++){
			enemyList.add(new Enemy_SkyFight(enemyPosition[i][0], enemyPosition[i][1]));
			
		}
		
		}

	
	private void updateGame(){
			
		
		
		timer = new Timer(DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();	// this function is continuosly calling paint component
				
			}
			
		
		});
		
		timer.start();
	}
	
	



	@Override
	public void paintComponent(Graphics g){
		int w;
		int lm=0;
		
		
		
		super.paintComponent(g);
		Graphics2D twoD = (Graphics2D)g;
		twoD.setColor(Color.YELLOW);
		twoD.setFont(new Font("TimesRoman", Font.PLAIN, 22)); 
		
		
			
		twoD.drawImage(background, 0, 0, this);
		
		twoD.drawString("Enemy Left :"+Integer.toString(enemyList.size()), 30,20);
	
		if(hero.isVisible())
		twoD.drawImage(hero.getHeroimg(), hero.getX(), hero.getY(), this);

		
		
		for(int i =0;i<hero.getMissileList().size();i++)
		{
			Missile missile = hero.getMissileList().get(i);
			if(missile.isVisible()){
				missile.missileMove();
				twoD.drawImage(missile.getMissileimg(), missile.getX(), missile.getY(), this);
				
				
				
				// for deleting missile
				if(missile.getX()>Launcher.FrameWidth){
					missile.setVisible(false);
					hero.getMissileList().remove(i);
				
					
				}
					
			}
			
		}
		
		for(int k=0;k<enemyList.size();k++){
			Enemy_SkyFight enemy = enemyList.get(k);
			
					if(enemy.isVisible()){
						twoD.drawImage(enemy.getEnemyImg(), enemy.getX(), enemy.getY(), this);
						enemy.enemypath();
					}
			
					
		}
		if(enemyList.size()==0){
			twoD.drawImage(new ImageIcon(GamePanel.class.getResource("assests/win logo.png")).getImage(), 100, 100, this);
		}


		// finishing game

		for(int i=0;i<enemyList.size();i++){
			if(hero.getRectangle().intersects(enemyList.get(i).getRectangle())){
				int gy = 0;
				int gx = 0;
				gx = hero.getX();
				gy = hero.getY();
				
				while(hero.isVisible()){
					System.out.println("hero intersection method with enemy running");
					explosionsound.play();hero.setVisible(false);
					enemyList.get(i).setVisible(false);
					themesong.stop();
					
				}
				twoD.drawImage(blastImg,gx,gy, this);
				twoD.drawImage(gameOver, 60, 120, this);



			}

		}
		for(int i=0;i<hero.getMissileList().size();i++){
			Missile missile = hero.getMissileList().get(i);
			for(int k=0;k<enemyList.size();k++){
			if(missile.getRectangle().intersects(enemyList.get(k).getRectangle())){
				twoD.drawImage(Enemy_SkyFight.enemyDead, enemyList.get(k).getX(), enemyList.get(k).getY(), this);
				hero.getMissileList().remove(i);
				enemyList.remove(k);
				
	}
			}
			
	
		}

	}

	

	




public GamePanel(int width , int height ,String title) {
	
	hero = new Hero_SkyFight();
	themesong.play();

	this.Height = height;
	this.Width = width;
	this.Title=title;
	
	this.setSize(Width,Height);
	this.setLocation(0, 0);
	
	setBackground(Color.BLACK);
	
	
	this.setFocusable(true);
	
	this.addKeyListener(new KeyAdapter() {

		
		@Override
		public void keyTyped(KeyEvent e) {
		
			hero.attackAction(e);
		}
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keypressed received");
			hero.direction(e);

		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released called");
			hero.dontMove();
		}
		
	
		
		
	});
	enemycreation();
	updateGame();
}
}

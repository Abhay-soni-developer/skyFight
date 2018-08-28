

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class Menu_SkyFight extends JFrame {

	private JPanel contentPane;
	MP3Player menuScreenSong = new MP3Player(Menu_SkyFight.class.getResource("assests/parade of champions.MP3"));
	MP3Player choosingItemSong = new MP3Player(Menu_SkyFight.class.getResource("assests/choosing item.MP3"));
	MP3Player itemSelectedSong = new MP3Player(Menu_SkyFight.class.getResource("assests/item selected.MP3"));

					
					
			
					
					public void startGame(){
						menuScreenSong.stop();
						setVisible(false);
						GameFrame gameplay = new GameFrame(Launcher.FrameWidth,Launcher.FrameHeight,"                   SKY FIGHT - PROTECTOR OF EARTH");
						
						
					}
					
					public void gameQuit(){
						menuScreenSong.stop();
						this.dispose();
					}
					
					public void settingsPage(){
						
					}
					
					
	public Menu_SkyFight() {
		menuScreenSong.play();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartButton = new JButton("Start Button");
		btnStartButton.setBackground(Color.WHITE);
		btnStartButton.setForeground(Color.RED);
		btnStartButton.setFont(new Font("Showcard Gothic", Font.BOLD, 17));
		btnStartButton.setBounds(253, 103, 195, 41);
		contentPane.add(btnStartButton);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBackground(Color.WHITE);
		btnSettings.setForeground(Color.RED);
		btnSettings.setFont(new Font("Showcard Gothic", Font.BOLD, 17));
		btnSettings.setBounds(253, 169, 195, 41);
		contentPane.add(btnSettings);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.WHITE);
		btnQuit.setForeground(Color.RED);
		btnQuit.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 17));
		btnQuit.setBounds(253, 234, 195, 41);
		contentPane.add(btnQuit);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(Menu_SkyFight.class.getResource("/assests/Menu bg Sky Fight.jpg")));
		lblMenu.setBounds(0, 0, 682, 353);
		contentPane.add(lblMenu);
		
		
		btnStartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
				
			}
		});
		
		btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameQuit();
				
			}
		});
		
		btnSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				settingsPage();
				
			}
		});
		
		btnStartButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				choosingItemSong.play();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				itemSelectedSong.play();
			}
		});
		
		btnSettings.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				choosingItemSong.play();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				itemSelectedSong.play();
			}
		});
		
		
		btnQuit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				choosingItemSong.play();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				itemSelectedSong.play();
			}
		});
		
		setVisible(true);
	}
	
	
}

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class SplashScreen_SkyFight extends JWindow {
	private JPanel contentPane;
	Timer time;
	JProgressBar progressBar;
	int i=0;

	private void pauseOnScreen(){
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				i++;				
				progressBar.setValue(i);
				if(i==100){
				setVisible(false);
				time.stop();
				Menu_SkyFight menuPage = new Menu_SkyFight();
				dispose();
				}
				}
			};
			time = new Timer(20,action);
			time.start();
			
	}
		
	
	
	public SplashScreen_SkyFight() {
		
		setLocationRelativeTo(null);
		this.setSize(461, 292);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 265, 437, 14);
		contentPane.add(progressBar);
		
		JLabel lblSpalshScreen = new JLabel("");
		lblSpalshScreen.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblSpalshScreen);
		lblSpalshScreen.setIcon(new ImageIcon(SplashScreen_SkyFight.class.getResource("assests/Earth defender splash screen .jpg")));
		
		
		
		
		setVisible(true);
		pauseOnScreen();
	}
}

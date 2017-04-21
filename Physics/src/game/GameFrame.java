package game;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class GameFrame extends JFrame implements ActionListener{
	public static final long serialVersionUID = 42L;
	private GamePanel gamepanel;
	private Timer myTimer;  
	private Sound sounds=new Sound();
	private String activescreen;
    public GameFrame() {
    	super("Physics");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(1280,720);
    	
    	gamepanel = new GamePanel(this);
    	add(gamepanel);
		setResizable(false);
		setVisible(true);
		
		sounds.play("/S1.wav", "Sound 1");
		
		myTimer = new Timer(30, this);
		myTimer.start();
		///---------- Variables ----------

		
    }
    public void actionPerformed(ActionEvent evt){
    	
    	gamepanel.update();
    	gamepanel.updateMenus();
    	gamepanel.repaint();
    	gamepanel.postupdate();
    }
    
}
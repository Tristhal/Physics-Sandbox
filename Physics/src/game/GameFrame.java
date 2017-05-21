package game;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import sound.Sounds;
import modules.FPS_Counter;
//Base structure
//Handles execution of different running instances for example an introduction menu will be called from here
public class GameFrame extends JFrame implements ActionListener{
	public static final long serialVersionUID = 42L;
	private GamePanel gamepanel;
	private Timer myTimer;  
	private Sounds sounds = new Sounds();
	private String activescreen;
	//----- Monitor Size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double monitorwidth = screenSize.getWidth();
	double monitorheight = screenSize.getHeight();
	//-----
	public int screenwidth = 16*80;
	public int screenheight = 9*80;
	public FPS_Counter fpscounter;
	
    public GameFrame() {
    	super("Physics Sandbox.py");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(screenwidth,screenheight);
    	
    	gamepanel = new GamePanel(this);
    	add(gamepanel);
		setResizable(false);
		setVisible(true);
		//sounds.play("/S1.wav", "Sound 1");
		
		myTimer = new Timer(16, this);
		myTimer.start();
		///---------- Variables ----------
		fpscounter = new FPS_Counter();
		
    }
    public void actionPerformed(ActionEvent evt){
    	//fpscounter.updateFPS();
    	// --- Game ---
    	gamepanel.preUpdate();
    	gamepanel.update();
    	gamepanel.updateMenus();
    	gamepanel.objectMove();
    	gamepanel.repaint();
    	gamepanel.postupdate();
    }
    public int getScreenWidth(){
    	return screenwidth;
    }
    public int getScreenHeight(){
    	return screenheight;
    }
    
}
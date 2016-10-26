package menus;

//This class creates all the menus
import java.awt.Color;
import java.awt.Graphics2D;

import game.GameFrame;
import game.GamePanel;

public class Menus {
	private GameFrame mainframe;
	private GamePanel gamepanel;
	private MainMenu mainmenu;
	private EscapeMenu escapemenu;
	public Menus(GameFrame f,GamePanel p){
		mainframe=f;
		gamepanel=p;
		mainmenu = new MainMenu(mainframe, gamepanel);
		escapemenu = new EscapeMenu(mainframe, gamepanel);
	}
	
	public void updateMenus(int mx, int my, boolean mousepressed){
		if(mainmenu.getActive()){
    		mainmenu.updatePanel(mx,my,mousepressed);
    	}
    	if(escapemenu.getActive()){
    		escapemenu.updatePanel(mx,my,mousepressed);
    	}
	}
	public void drawMenus(Graphics2D g){
		if(mainmenu.getActive()){
    		mainmenu.drawPanel(g);
    	}
    	if(escapemenu.getActive()){
    		escapemenu.drawPanel(g);
    	}
	}
}

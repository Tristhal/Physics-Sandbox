package menus;

import java.awt.Color;
import java.awt.Graphics2D;

import game.GameFrame;
import game.GamePanel;

public class MainMenu {
	private MenuPanel menu;
	private Menus menus;
	private GameFrame mainframe;
	private GamePanel gamepanel;
	public MainMenu(GameFrame f, GamePanel p){
		mainframe = f;
		gamepanel = p;
		menu = makeMainMenu();
	}
	public MenuPanel makeMainMenu(){
		MenuPanel mainmenu = new MenuPanel(0,
				0,
				gamepanel.getWidth(),
				gamepanel.getHeight(),
				gamepanel);
		mainmenu.setBackColor(new Color(10,10,10));
		mainmenu.setBar(false);
		return mainmenu;
	}
	public void updatePanel(int mx, int my, boolean mousepressed){
		menu.updatePanel();
	}
	public void drawPanel(Graphics2D g){
		menu.drawPanel(g);
	}
	
	public MenuPanel getMenu(){
		return menu;
	}
	public boolean getActive(){
		return menu.getActive();
	}
	public void setActive(boolean b){
		menu.setActive(b);
	}

}

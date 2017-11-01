package menus;

import java.awt.Color;
import java.awt.Graphics2D;

import game.GameFrame;
import game.GamePanel;


public class EscapeMenu {
	private MenuPanel menu;
	private Menus menus;
	private GameFrame mainframe;
	private GamePanel gamepanel;
	
	public EscapeMenu(GameFrame f, GamePanel p){
		mainframe = f;
		gamepanel =p ;
		menu = makeEscapeMenu();
	}
	public MenuPanel makeEscapeMenu(){
		MenuPanel escapemenu = new MenuPanel(0,0,100,200,gamepanel);
		escapemenu.setBackColor(new Color(150,150,150));
		escapemenu.setBarColor(new Color(200,200,200));
		escapemenu.setBackTransparency(.8f);
		escapemenu.setMoveable(true);
		escapemenu.setBarHeight(10);
		
		return escapemenu;
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

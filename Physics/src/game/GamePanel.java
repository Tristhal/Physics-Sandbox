package game;

import modules.paint;
import java.math.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.*; 
import java.util.*;
import javax.swing.Timer;

import menus.*;

public class GamePanel extends JPanel implements MouseMotionListener, MouseListener,KeyListener{
	static final long serialVersionUID=1;
	//----- Hardware -----
	private int mx,my;//Mouse position x and y
	private boolean[]keys;//If the keys are pressed
	private boolean mousepressed=false;//If the mouse is pressed down
	private boolean mouseclicked=false;//If the was clicked
	//----- Classes -------
	private GameFrame mainframe;//The GameFrame that created this GamePanel
	//----- Variables -----
	private int width=1280;
	private int height=720;
	//----- Menus ---------
	private Menus menus = new Menus(mainframe,this);
	
    public GamePanel(GameFrame m) {
    	mainframe = m;
    	keys=new boolean[KeyEvent.KEY_LAST+1];//creates the array for keys
    	//----- Listeners -------
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		//----- Variables -------
		//----- Load Images -----
		//----- Load Music ------
    }
    @Override
    public void paintComponent(Graphics gg){
    	width = getWidth();
    	height = getHeight();
    	Graphics2D g = (Graphics2D) gg;
    	g.setColor(new Color(0,0,0));
    	g.fillRect(0, 0, width, height);
    	menus.drawMenus(g);
    	g.setColor(new Color(255,255,255));
    	g.fillOval(mx-3, my-3, 5, 5);
    }
 // ------------ Updates -------------------------------------------------- 
    public static int windowbarheight=29;
    public void update(){
    	mx= Math.max(0, Math.min(MouseInfo.getPointerInfo().getLocation().x-mainframe.getLocation().x, width-1));
    	my= Math.max(0, Math.min(MouseInfo.getPointerInfo().getLocation().y-mainframe.getLocation().y-windowbarheight, height-1));
    	//System.out.println(mx+" "+my);
    }
    public void updateMenus(){
    	menus.updateMenus(mx, my, mousepressed);    	
    }
    public void postupdate(){
    	mouseclicked=false;
    }
    
 // ------------ MouseListener --------------------------------------------
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
    	mousepressed=false;

    	
    }    
    public void mouseClicked(MouseEvent e){	

    }
    public void mousePressed(MouseEvent e){
    	mousepressed=true;
    	mouseclicked=true;
	}
    // ---------- MouseMotionListener -------------------------------------
    public void mouseDragged(MouseEvent e){
    	//mx=e.getX();
    	//my=e.getY();
    	
    	
    }
    public void mouseMoved(MouseEvent e){
    	//mx=e.getX();
    	//my=e.getY();
    }
   	// ---------- KeyListener ---------------------------------------------
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    // ---------- GetFunctions -----------------------------------------------
    public boolean getMousePressed(){
    	return mousepressed;
    }
    public boolean getMouseClicked(){
    	return mouseclicked;
    }
    public int getMX(){
    	return mx;
    }
    public int getMY(){
    	return my;
    }
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
    }
    public int getDesktopMX(){
    	return MouseInfo.getPointerInfo().getLocation().x;
    }
    public int getDesktopMY(){
    	return MouseInfo.getPointerInfo().getLocation().y;
    }
}

package menus;

import java.awt.Color;
import java.awt.Graphics2D;

import modules.paint;
import javax.swing.*;

import game.GamePanel;

public class MenuPanel {
	private int x;
	private int y;
	private int width;
	private int height;
	private GamePanel rootpanel;
	//---Settings---
	private boolean moveable=false;
	private boolean resizeable=false;
	private Color backcolor=new Color(0,0,0);
	private Color barcolor=new Color(0,0,0);
	private float backtransparency=1.0f;
	private float bartransparency=1.0f;
	private int barheight=20;
	private boolean active=true;
	private boolean barstatus=true;
	private boolean closestatus=true;
	
	public MenuPanel(int x,int y,int width,int height,GamePanel rootpanel){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.rootpanel=rootpanel;
	}
	public void drawPanel(Graphics2D g){
		paint.setAlpha(g, backtransparency);
		g.setColor(backcolor);
		g.fillRect(x, y, width, height);
		
		if(barstatus){
			paint.setAlpha(g, bartransparency);
			g.setColor(barcolor);
			g.fillRect(x, y, width, barheight);
		}
		paint.setAlpha(g, 1.0f);
	}
	public boolean colide(int mx, int my, int x, int y, int width, int height){
		return mx>x && mx<x+width && my>y && my<y+height;
	}
	
	private boolean barwaspressed=false;
	private int lastmx;
	private int lastmy;
	public void updatePanel(){
		if(moveable){//If the window is movable
			dragWindow(rootpanel.getMX(),rootpanel.getMY(),rootpanel.getMousePressed(),
					rootpanel.getMouseClicked());
		}
		///---end---
		lastmx=rootpanel.getMX();
		lastmy=rootpanel.getMY();
	}
	
	public void dragWindow(int mx, int my, boolean mousepressed, boolean mouseclicked){
		if(mx>=0 && my>=0 && mx<=rootpanel.getWidth() && my<=rootpanel.getHeight()){
			
			if(barwaspressed){///Allows for dragging
				
				if(mousepressed==false){//If you stopped clicking then you are no longer dragging the menu
					barwaspressed=false;
					
				}
				else{
					//checks to see if the menu would clip left or right of the frame
					if((x+mx-lastmx)>=-1 && (x+mx-lastmx+width)<(rootpanel.getWidth()+1)){//prevent from moving to far right or left
						x+=mx-lastmx;
						
					}
					else{
						if(x+mx-lastmx<=-1){
							x=0;
							
						}
						else{
							if(x+mx-lastmx+width>rootpanel.getWidth()+1){
								x=rootpanel.getWidth()-width;
								
							}
						}
					}
					if(y+my-lastmy>=-1 && y+my-lastmy+height<rootpanel.getHeight()+1){
						y+=my-lastmy;
						
					}
					else{//If it would go above or below the screen stop it
						if(y+my-lastmy<=-1){
							y=0;
							
						}
						else{
							if(y+my-lastmy+height>rootpanel.getHeight()+1){
								y=rootpanel.getHeight()-height;
								
							}
						}
					}
				}
			}
			else{
				//System.out.println(mouseclicked);
				if(mouseclicked && colide(mx,my,x,y,width,barheight)){
					barwaspressed=true;
					
				}
			}
		}
		else{
			barwaspressed=false;
		}
	}
	public void setBackColor(Color color){
		this.backcolor=color;
	}
	public void setBar(boolean f){
		barstatus=f;
	}
	public void setBarColor(Color color){
		this.barcolor=color;
	}
	public void setBackTransparency(float flt){
		this.backtransparency=flt;
	}
	public void setBarTransparency(float flt){
		this.bartransparency=flt;
	}
	public void setMoveable(boolean b){
		moveable=b;
	}
	public void setResizeable(boolean b){
		resizeable=b;
	}
	public void setActive(boolean b){
		active=b;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setBarHeight(int y){
		barheight=y;
	}
	public boolean getActive(){
		return active;
	}

}

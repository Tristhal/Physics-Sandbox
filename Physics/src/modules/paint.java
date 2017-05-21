package modules;

import java.awt.*;
public class paint{
	
	public paint(){
	}
	public static void setAA(Graphics2D g, Boolean a){//maby make 2
		if(a){
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        		RenderingHints.VALUE_ANTIALIAS_ON);
		}
		else{
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias off
        		RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	}
	public static void setAlpha(Graphics2D g, float alpha){
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
	}
	// ------------ Circles ------------------------------------------------
	public static void drawCircle(Graphics2D g, int posx, int posy, int r, int thickness, Color color){//hollow
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.drawOval(posx-r,posy-r,r*2,r*2);
		
	}
	public static void drawCircle(Graphics2D g, int posx, int posy, int r, int thickness, Color color, float alpha){//Transparent,hollow
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.drawOval(posx-r,posy-r,r*2,r*2);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
  	}
	public static void drawCircle(Graphics2D g, int posx, int posy, int r, Color color){//filled
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.fillOval(posx-r,posy-r,r*2,r*2);
	}
	public static void drawCircle(Graphics2D g, int posx, int posy, int r, Color color, float alpha){//Transparent,filled
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.fillOval(posx-r,posy-r,r*2,r*2);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
	}
	public static void drawAACircle(Graphics2D g, int posx, int posy, int r, int thickness, Color color){//hollow,antia aliased
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(thickness));
		g.drawOval(posx-r,posy-r,r*2,r*2);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias off
        RenderingHints.VALUE_ANTIALIAS_OFF);
		
	}
	public static void drawAACircle(Graphics2D g, int posx, int posy, int r, int thickness, Color color, float alpha){//Transparent,hollow,AA
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.drawOval(posx-r,posy-r,r*2,r*2);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias off
        RenderingHints.VALUE_ANTIALIAS_OFF);
  	}
	public static void drawAACircle(Graphics2D g, int posx, int posy, int r, Color color){//filled,AA
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval(posx-r,posy-r,r*2,r*2);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias off
        RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	public static void drawAACircle(Graphics2D g, int posx, int posy, int r, Color color, float alpha){//Transparent,filled,AA
		//graphics,cx,cy,r,color
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.fillOval(posx-r,posy-r,r*2,r*2);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias off
        RenderingHints.VALUE_ANTIALIAS_OFF);
	}

    // ------------ Rectangles----------------------------------------------             
	public static void drawRect(Graphics2D g,int x,int y,int width, int height, int thickness, Color color){//hollow
		g.setColor(color);
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(thickness));
		g.drawRect(x+thickness/2,y+thickness/2,width-thickness,height-thickness);
		g.setStroke(oldStroke);
	}
	public static void drawRect(Graphics2D g,int x,int y,int width, int height, int thickness, Color color,float alpha){//Transparent,hollow
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.drawRect(x+thickness/2,y+thickness/2,width-thickness,height-thickness);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
	}
	
	public static void drawRect(Graphics2D g,int x,int y,int width, int height, Color color){//Filled
		g.setColor(color);
		g.fillRect(x,y,width,height);
		
	}
	public static void drawRect(Graphics2D g,int x,int y,int width, int height, Color color,float alpha){//Transparent,filled
		g.setColor(color);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.fillRect(x,y,width,height);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
	}
	
	// ------------ Lines --------------------------------------------------
	public static void drawLine(Graphics2D g,int x1,int y1, int x2, int y2,int thickness, Color color){//
		g.setColor(color);
		g.setStroke(new BasicStroke(thickness));
		g.drawLine(x1,y1,x2,y2);
		
	}
	public static void drawLine(Graphics2D g,int x1,int y1, int x2, int y2,int thickness, Color color,float alpha){//Transparent
		g.setColor(color);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.setStroke(new BasicStroke(thickness));
		g.drawLine(x1,y1,x2,y2);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
	}
	public static void drawAALine(Graphics2D g,int x1,int y1, int x2, int y2,int thickness, Color color){//AA
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(thickness));
		g.drawLine(x1,y1,x2,y2);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	public static void drawAALine(Graphics2D g,int x1,int y1, int x2, int y2,int thickness, Color color,float alpha){//AA,transparent
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_ON);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
		g.setStroke(new BasicStroke(thickness));
		g.drawLine(x1,y1,x2,y2);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias on
        RenderingHints.VALUE_ANTIALIAS_OFF);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1.0f));
	}
}
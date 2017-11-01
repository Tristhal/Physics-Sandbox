package game;

import java.awt.Graphics2D;

public abstract class PhysicsObject {
	
	public PhysicsObject(){
		
	}
	abstract boolean collideWith(BaseLine line);
	abstract boolean collideWith(BasePoint point);
	abstract boolean collideWith(PhysicsObject obj);
	abstract void updateCollide();
	abstract void updateMove();
	abstract void updateAccelerate();
	abstract void preUpdate();
	abstract boolean getStationary();
	abstract void drawSelf(Graphics2D g);
	
	//Access other objects
	BaseLine varline = null;
	BasePoint varpoint = null;
	Circle varcircle = null;
	abstract void getSelf(PhysicsObject obj);
	void setVarLine(BaseLine line){
		varline = line;
	}
	void setVarPoint(BasePoint point){
		varpoint = point;
	}
	void setVarCircle(Circle c){
		varcircle = c;
	}
	//Testing
	abstract void printType(BaseLine line);
	abstract void printType(BasePoint point);
	abstract void printType(Circle c);
	abstract void printType(PhysicsObject object);
	
}

package game;

public abstract class PhysicsObject {
	
	public PhysicsObject(){
		
	}
	abstract void collideWith(BaseLine line);
	abstract void collideWith(BasePoint line);
	abstract void collideWith(PhysicsObject obj);
	abstract void updateMove();
	abstract void updateAccelerate();
	abstract void preUpdate();
	
	//Testing
	abstract void printType(BaseLine line);
	abstract void printType(BasePoint point);
	abstract void printType(PhysicsObject object);
}

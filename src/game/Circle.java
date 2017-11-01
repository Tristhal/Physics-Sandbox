package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Circle extends PhysicsObject{
	Point2D.Double position, velocity, acceleration;
	boolean stationary = false;
	int mass = 1;
	public Circle(double px, double py){
		position.x = px;
		position.y = py;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 0;
	}
	@Override
	boolean collideWith(BaseLine line) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean collideWith(BasePoint point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean collideWith(PhysicsObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void updateCollide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void updateMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void updateAccelerate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void preUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void drawSelf(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void getSelf(PhysicsObject obj) {
		// TODO Auto-generated method stub
		obj.setVarCircle(this);
	}
	/// Acceleration ///
	double getAccelX(){
		return acceleration.getX();
	}
	void setAccelX(double x){
		acceleration.x = x;
	}
	void addAccelX(double x){
		acceleration.x += x;
	}
	double getAccelY(){
		return acceleration.getY();
	}
	void setAccelY(double y){
		acceleration.y = y;
	}
	void addAccelY(double y){
		acceleration.y += y;
	}
	int getMass(){
		return mass;
	}
	/// Other ///
	void setStationary(boolean b){
		stationary = b;
	}
	@Override
	boolean getStationary(){
		return stationary;
	}
	/// Debug ///
	@Override
	void printType(BaseLine line) {
		System.out.println("This: Circle, That: Line");
		
	}
	@Override
	void printType(BasePoint point) {
		System.out.println("This: Circle, That: Point");
		
	}
	@Override
	void printType(Circle c){
		System.out.println("This: Circle, That Circle");
	}
	@Override
	void printType(PhysicsObject object) {
		System.out.println("Object call from circle");
		object.printType(this);
		
	}

}

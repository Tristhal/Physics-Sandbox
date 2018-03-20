package game;

import java.awt.Graphics2D;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import modules.utilityfunc;
public class Circle extends PhysicsObject{
	double timeinterval;
	//Position Variables
	Point2D.Double position, velocity, acceleration;
	//Characteristics variables
	boolean stationary = false;
	int mass = 1;
	int radius = 5;
	public Circle(double px, double py){
		position.x = px;
		position.y = py;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 0;
		timeinterval = 1;
	}
	
	//////////////////////////////////////////////////
	/// Collision Functions
	//////////////////////////////////////////////////
	@Override
	boolean collideWith(BaseLine line){
		
		return false;
	}

	@Override
	boolean collideWith(BasePoint point) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	boolean collideWith(Circle circle) {
		
		return false;
	}
	@Override
	boolean collideWith(PhysicsObject obj) {
		return obj.collideWith(this);
	}
	//////////////////////////////////////////////////
	/// Update Functions
	//////////////////////////////////////////////////
	@Override
	void updateCollide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void updateMove() {
		if(!stationary) {
			position = add2D(position, multiply2D(timeinterval,velocity));
		}
		else {
			velocity.x = 0;
			velocity.y = 0;
		}
		
	}

	@Override
	void updateAccelerate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void preUpdate() {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////////////////////////////
	/// Draw Functions
	//////////////////////////////////////////////////
	
	@Override
	void drawSelf(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////////////////////////////
	/// Point Functions
	//////////////////////////////////////////////////
	Double rotate2D(Point2D.Double p, float angle) {
		return new Point2D.Double(p.getX()*utilityfunc.cos(angle)- p.getY()*utilityfunc.sin(angle),
				p.getX()*utilityfunc.sin(angle)- p.getY()*utilityfunc.cos(angle));
	
	}
	Double add2D(Point2D.Double p1, Point2D.Double p2){
		return new Double(p1.x+p2.x,p1.y+p2.y);
	}
	Double subtract2D(Point2D.Double p1, Point2D.Double p2){
		return new Double(p1.x-p2.x,p1.y-p2.y);
	}
	Double divide2D(double d, Point2D.Double p){
		return new Double(p.x/d,p.y/d);
	}
	Double multiply2D(double d, Point2D.Double p){
		return new Double(p.x*d,p.y*d);
	}
	double crossProduct2D(Point2D.Double p1, Point2D.Double p2){
		return p1.getX()*p2.getY()-p1.getY()*p2.getX();
	}
	double dotProduct2D(Point2D.Double p1, Point2D.Double p2){
		return p1.x*p2.x+p1.y*p2.y;
	}
	//////////////////////////////////////////////////
	/// Get/Set Functions
	//////////////////////////////////////////////////
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

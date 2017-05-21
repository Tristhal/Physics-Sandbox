package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.math.*;

import modules.paint;

/* Description:
 * 
 * Functions:
 * 
 */
public class BasePoint extends PhysicsObject{
	double timeinterval;
	Point2D.Double position, velocity, acceleration;
	private boolean stationary;
	Double nextcollision = null;
	double collisionangle = 0;
	
	public BasePoint(){
		stationary = true;
		position = new Point2D.Double(0,0);
		velocity = new Point2D.Double(0, 0);
		acceleration = new Point2D.Double(0, 0);
		timeinterval = 1;
	}
	public BasePoint(double px, double py){
		stationary = true;
		position = new Point2D.Double(px, py);
		velocity = new Point2D.Double(0, 0);
		acceleration = new Point2D.Double(0, 0);
		timeinterval = 1;
	}
	//////////////////////////////////////////////////
	/// Collision Functions
	//////////////////////////////////////////////////
	@Override
	void collideWith(BaseLine line){
		Double s;
		Double q = line.getPoint1().getPosition();
		Double p = line.getPoint2().getPosition();//Line segment qp


		
		
		Double r = (Double) position.clone();
		Double v = subtract2D(velocity,line.getVelocity());
		double time = (crossProduct2D(r,q)-crossProduct2D(r,p)+crossProduct2D(q,p))/(crossProduct2D(v,p)-crossProduct2D(v,q));
		
		System.out.println("time to collision = "+time+" "+(position.x+velocity.x*time)+","+(position.y+velocity.y*time));
		if(time < timeinterval){//collided in this time interval
			nextcollision = new Double((position.x+velocity.x*time),(position.y+velocity.y*time));
			
			//Calculate angle of collision
			s = line.getPoint2().getPosition();//Length of vector 1
			s.x -= q.x;
			s.y -= q.y;
			r = new Double(velocity.x*timeinterval,velocity.y*timeinterval);//Length of vector 2
			double first = crossProduct2D(r,s);//r X s which is 0 if parallel
			collisionangle = Math.asin(first/(length2D(r)*length2D(s)));
		}
		
	}
	//Alternate Collision (between two lines method)
	/*
	void twoLineSegmentsCollide(BaseLine line){
		Double q = line.getPoint1().getPosition();//Position of vector 1
		Double s = line.getPoint2().getPosition();//Length of vector 1
		s.x -= q.x;
		s.y -= q.y;
		Double p = (Double) position.clone();//Position of vector 2 (moving point)
		Double r = new Double(velocity.x*timeinterval,velocity.y*timeinterval);//Length of vector 2
		double first = crossProduct2D(r,s);//r X s which is 0 if parallel
		double second = crossProduct2D(subtract2D(q,p),r);//(q-p) x r
		double t = (crossProduct2D(subtract2D(q,p),s))/crossProduct2D(r,s);
		double u = (crossProduct2D(subtract2D(q,p),r))/crossProduct2D(r,s);
		 
		if(first != 0 && t >= 0 && t <= 1 && u >= 0 && u <= 1){//intersect
			nextcollision = add2D(p,multiply2D(t,r));
			collisionangle = Math.asin(first/(length2D(r)*length2D(s)));
			System.out.println("Intersect at x = "+nextcollision.x+" , y = "+nextcollision.y+" angle = "+collisionangle);
		}
		else{//Do not intersect or are collinear
			//System.out.println("Not Parallel and non intersecting");
		}
	}*/
	@Override
	void collideWith(BasePoint point) {
		//Does nothing
	}
	@Override
	void collideWith(PhysicsObject obj) {
		obj.collideWith(this);
	}
	//////////////////////////////////////////////////
	/// Update Functions
	//////////////////////////////////////////////////
	void preUpdate(){
		nextcollision = null;
	}
	void updateMove(){
		if(!stationary){
			position.x += velocity.x*timeinterval;
			position.y += velocity.y*timeinterval;
		}
		else{
			velocity.y = 0;
			velocity.y = 0;
		}
	}
	void updateAccelerate(){
		velocity.x += acceleration.x;
		velocity.y += acceleration.y;
	}
	//////////////////////////////////////////////////
	/// Draw Functions
	//////////////////////////////////////////////////
	void drawBasePoint(Graphics2D g){
		paint.drawCircle(g, (int)position.x, (int)position.y, 2, Color.red);
	}
	/// Other Functions
	double length2D(Point2D.Double p){
		return Math.sqrt(p.x*p.x+p.y*p.y);
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
	
	/// Position ///
	double getPosX(){
		return position.getX();
	}
	void setPosX(double x){
		position.x = x;
	}
	void addPosX(double x){
		position.x += x;
	}
	double getPosY(){
		return position.getY();
	}
	void setPosY(double x){
		position.y = x;
	}
	void addPosY(double x){
		position.y += x;
	}
	Double getPosition(){
		return (Double)position.clone();
	}
	/// Velocity ///
	double getVelX(){
		return velocity.getX();
	}
	void setVelX(double x){
		velocity.x = x;
	}
	void addVelX(double x){
		velocity.x += x;
	}
	double getVelY(){
		return velocity.getY();
	}
	void setVelY(double y){
		velocity.y = y;
	}
	void addVelY(double y){
		velocity.y += y;
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
	/// Other ///
	void setStationary(boolean b){
		stationary = b;
	}
	/// Debug ///
	@Override
	void printType(BaseLine line) {
		System.out.println("This: Point, That: Line");
		
	}
	@Override
	void printType(BasePoint point) {
		System.out.println("This: Point, That: Point");
		
	}
	@Override
	void printType(PhysicsObject object) {
		System.out.println("Object call from point");
		object.printType(this);
		
	}
	
}

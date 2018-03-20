package game;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
//import java.math.*;

import modules.paint;
import modules.utilityfunc;

/* Description:
 * 
 * Functions:
 * 	boolean collideWith()
 * 	void
 */
public class BasePoint extends PhysicsObject{
	double timeinterval;
	//Position variables
	Double position, velocity, acceleration;
	//Characteristics variables
	private boolean stationary;
	private int mass = 1;
	private float efficiency = .9f;
	//Collision variables
	Double nextcollision = null;
	double timetocollision = 1;
	double collisionangle = 0;
	PhysicsObject collidedwith = null;
	
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
	boolean collideWith(BaseLine line){
		Double s,q,p,r,v,collision;
		//double cross; //Currently Unused
		q = line.getPoint1().getPosition();
		p = line.getPoint2().getPosition();
		//Line segment qp is the line segment that the point is colliding with
		r = (Double) position.clone();//The current position of the point
		v = subtract2D(velocity,line.getVelocity());//Perform calculations relative to the line's velocity
		double time = (crossProduct2D(r,q)-crossProduct2D(r,p)+crossProduct2D(q,p))/(crossProduct2D(v,p)-crossProduct2D(v,q));
		//Formula for the time of the collision between a moving point and stationary line
		if(time <= timetocollision && time >= 0){//if collision in this time interval or before the other detected collision
			//System.out.println(time);
			collision = new Double((position.x+velocity.x*time),(position.y+velocity.y*time));
			if((contained(p.x,q.x,collision.x) || contained(p.y,q.y,collision.y))){
				if(Math.abs(velocity.x) > 9) {
					System.out.println("Hello");
				}
				//Calculate the angle of collision
				//s = line.getPoint2().getPosition();//Length of vector 1
				//s.x -= q.x;
				//s.y -= q.y;
				//r = new Double(velocity.x*time,velocity.y*time);//Length of vector 2
				//cross = crossProduct2D(r,s);//r X s which is 0 if parallel
				//collisionangle = Math.autilityfunc.sin(cross/(length2D(r)*length2D(s)));
				collidedwith = line;
				nextcollision = collision;
				timetocollision = time;
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	@Override
	boolean collideWith(BasePoint point) {
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
	void preUpdate(){
		nextcollision = null;
		timetocollision = timeinterval;//Important used in collision functions
	}
	void updateMove(){
		if(!stationary) {
			if(collidedwith == null || true){
				position = add2D(position, multiply2D(timeinterval,velocity));
			}
			else {
				collidedwith = null;
			}
		}
		else{
			velocity.x = 0;
			velocity.y = 0;
		}
	}
	void updateAccelerate(){
		velocity.x += acceleration.x;
		velocity.y += acceleration.y;
	}
	void updateCollide(){
		if(nextcollision != null){
			//System.out.println("Class "+collidedwith.getClass());
			//Colliding with a Line
			if(collidedwith.getClass() == BaseLine.class){
				BaseLine object2 = (BaseLine)collidedwith;
				if(object2.getStationary()){//Line is static
					float angle = (float)Math.toDegrees(Math.atan2(velocity.y, velocity.x));
					angle = (float)(2 * Math.toDegrees(object2.getNormalAngle()) - 180 - angle);
					double mag = efficiency * Math.hypot(velocity.x, velocity.y);
					velocity.x = utilityfunc.cos((angle)) * mag;
					velocity.y = utilityfunc.sin((angle)) * mag;
					//System.out.println("Vx = "+velocity.x+", Vy = "+velocity.y);
				}
				else{//incorporate the lines velocity
					//try setting velocity of line to 0
					float angle = (float)Math.toDegrees(Math.atan2(velocity.y, velocity.x));
					angle = (float)(2 * Math.toDegrees(object2.getNormalAngle()) - 180 - angle);
					collidedwith.getSelf(this);
					//v1 = (v2(m1-m2)+2*m1v1)/(m1+m2)
					double tempx = (velocity.x*(mass-varline.getMass())+2*varline.getMass()*varline.getVelX())/(mass+varline.getMass());
					double tempy = (velocity.y*(mass-varline.getMass())+2*varline.getMass()*varline.getVelY())/(mass+varline.getMass());
					double mag = efficiency * Math.hypot(tempx, tempy);
					velocity.x = utilityfunc.cos((angle)) * mag;
					velocity.y = utilityfunc.sin((angle)) * mag;
					//varline.setVelX((varline.getVelX()*(varline.getMass()-mass)+2*mass*velocity.x)/(mass+varline.getMass())*utilityfunc.cos((angle)));
					//varline.setVelY((varline.getVelY()*(varline.getMass()-mass)+2*mass*velocity.y)/(mass+varline.getMass())*utilityfunc.sin((angle)));
					//System.out.println("Vx = "+velocity.x+", Vy = "+velocity.y);

				}

			}
		}
		
	}

	//////////////////////////////////////////////////
	/// Draw Functions
	//////////////////////////////////////////////////
	void drawSelf(Graphics2D g){
		paint.drawCircle(g, (int)position.x, (int)position.y, 2, Color.red);
	}
	/// Other Functions
	double length2D(Point2D.Double p){
		return Math.sqrt(p.x*p.x+p.y*p.y);
	}
	boolean contained(double x1, double x2, double x){
		if(x1>x2){
			if(x<x1 && x>x2){
				return true;
			}
		}
		else{
			if(x>x1 && x<x2){
				return true;
			}
		}
		return false;
	}
	//////////////////////////////////////////////////
	/// Point Functions
	//////////////////////////////////////////////////
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
	
	/// Access Functions ///
	void getSelf(PhysicsObject obj){
		obj.setVarPoint(this);
	}
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
		System.out.println("This: Point, That: Line");
		
	}
	@Override
	void printType(BasePoint point) {
		System.out.println("This: Point, That: Point");
		
	}
	@Override
	void printType(Circle c){
		System.out.println("This: Point, That Circle");
	}
	@Override
	void printType(PhysicsObject object) {
		System.out.println("Object call from point");
		object.printType(this);
		
	}
	
}

//Alternate Collision (between two lines method)
//@Override
/*boolean collideWith(BaseLine line){
	Double q = line.getPoint1().getPosition();//Position of vector 1
	Double s = line.getPoint2().getPosition();//Length of vector 1
	s.x -= q.x;
	s.y -= q.y;
	Double p = (Double) position.clone();//Position of vector 2 (moving point)
	Double r = new Double(velocity.x*timeinterval,velocity.y*timeinterval);//Length of vector 2
	double first = crossProduct2D(r,s);//r X s which is 0 if parallel
	//double second = crossProduct2D(subtract2D(q,p),r);//(q-p) x r
	double x = crossProduct2D(r,s);
	Double y = subtract2D(q,p);
	double t = (crossProduct2D(y,s))/x;
	double u = (crossProduct2D(y,r))/x;
	 
	if(first != 0 && t >= 0 && t <= 1 && u >= 0 && u <= 1){//intersect
		nextcollision = add2D(p,multiply2D(t,r));
		collisionangle = Math.autilityfunc.sin(first/(length2D(r)*length2D(s)));
		collidedwith = line;
		//System.out.println("Intersect at x = "+nextcollision.x+" , y = "+nextcollision.y+" angle = "+collisionangle);
		return true;
		
	}
	else{//Do not intersect or are collinear
		//System.out.println("Not Parallel and non intersecting");
		return false;
	}
}*/
//Finds time to collision
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
		collisionangle = Math.autilityfunc.sin(first/(length2D(r)*length2D(s)));
		System.out.println("Intersect at x = "+nextcollision.x+" , y = "+nextcollision.y+" angle = "+collisionangle);
	}
	else{//Do not intersect or are collinear
		//System.out.println("Not Parallel and non intersecting");
	}
}*/

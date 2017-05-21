package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import modules.paint;

public class BaseLine extends PhysicsObject{
	double velx, vely, accelx, accely, timeinterval;
	private BasePoint point1, point2;
	private boolean stationary;
	
	public BaseLine(){
		stationary = true;
		velx = 0;
		vely = 0;
		accely = 0;
		accelx = 0;
		timeinterval = 1;
	}
	public BaseLine(double px1, double py1, double px2, double py2){
		stationary = true;
		/// Variables ///
		point1 = new BasePoint(px1, py2);
		point2 = new BasePoint(px2, py2);
		velx = 0;
		vely = 0;
		accely = 0;
		accelx = 0;
		timeinterval = 1;
	}
	//////////////////////////////////////////////////
	/// Collision Functions
	//////////////////////////////////////////////////
	@Override
	void collideWith(BaseLine line) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void collideWith(BasePoint point) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void collideWith(PhysicsObject obj) {
		obj.collideWith(this);
	}
	//////////////////////////////////////////////////
	/// Update Functions
	//////////////////////////////////////////////////
	void preUpdate(){
		
	}
	void updateMove(){
		if(!stationary){
			point1.updateMove();
			point2.updateMove();
		}
		else{
			velx = 0;
			vely = 0;
		}
	}
	public void updateAccelerate(){
		point1.updateAccelerate();
		point2.updateAccelerate();
	}
	//////////////////////////////////////////////////
	/// Draw Functions
	//////////////////////////////////////////////////
	public void drawBaseLine(Graphics2D g){
		paint.drawAALine(g, (int)point1.getPosX(), (int)point1.getPosY(),
				(int)point2.getPosX(), (int)point2.getPosY(), 1, Color.red);
		point1.drawBasePoint(g);
		point2.drawBasePoint(g);
	}
	//////////////////////////////////////////////////
	/// Get/Set Functions
	//////////////////////////////////////////////////
	
	/// Points ///
	BasePoint getPoint1(){
		return point1;
	}
	BasePoint getPoint2(){
		return point2;
	}
	
	/// Velocity ///
	void syncVelX(){
		point1.setVelX(velx);
		point2.setVelX(velx);
	}
	void syncVelY(){
		point1.setVelY(vely);
		point2.setVelY(vely);
	}
	double getVelX(){
		return velx;
	}
	void setVelX(double x){
		velx = x;
		syncVelX();
	}
	void addVelX(double x){
		velx += x;
		syncVelX();
	}
	double getVelY(){
		return vely;
	}
	void setVelY(double x){
		vely = x;
		syncVelY();
	}
	void addVelY(double x){
		vely += x;
		syncVelY();
	}
	Double getVelocity(){
		return new Double(velx, vely);
	}
	/// Acceleration ///
	void syncAccelX(){
		point1.setAccelX(accelx);
		point2.setAccelX(accelx);
	}
	void syncAccelY(){
		point1.setAccelY(accely);
		point2.setAccelY(accely);		
	}
	double getAccelX(){
		return accelx;
	}
	void setAccelX(double x){
		accelx = x;
		syncAccelX();
	}
	void addAccelX(double x){
		accelx += x;
		syncAccelX();
	}
	double getAccelY(){
		return accely;
	}
	void setAccelY(double x){
		accely = x;
		syncAccelY();
	}
	void addAccelY(double x){
		accely += x;
		syncAccelY();
	}
	/// Other ///
	void setStationary(boolean b){
		stationary = b;
		point1.setStationary(b);
		point2.setStationary(b);
	}
	/// Debug ///
	@Override
	void printType(BaseLine line) {
		System.out.println("This: Line, That: Line");
		
	}
	@Override
	void printType(BasePoint point) {
		System.out.println("This: Line, That: Point");
		
	}
	void printType(PhysicsObject object) {
		System.out.println("Object call from line");
		object.printType(this);
		
	}
}

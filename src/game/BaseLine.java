package game;

import java.awt.Color;


import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import modules.paint;
import modules.utilityfunc;

public class BaseLine extends PhysicsObject{
	//Position variables
	double velx = 0, vely = 0, accelx = 0, accely = 0, timeinterval;
	float w, orientation;
	private BasePoint point1, point2, cm = new BasePoint();
	//Characteristics variables
	private boolean stationary;
	private int mass = 10;
	private double length;
	
	public BaseLine(){
		stationary = true;
		w = -1;
	}
	public BaseLine(double px1, double py1, double px2, double py2){
		stationary = true;
		/// Variables ///
		point1 = new BasePoint(px1, py1);
		point2 = new BasePoint(px2, py2);
		w = -1;
	}
	public BaseLine(double px, double py, float angle, double l, float rotation){
		stationary = true;
		/// Variables ///
		cm = new BasePoint(px,py);
		length = l;
		orientation = angle;
		w = rotation;
		point1 = new BasePoint(px+length/2*utilityfunc.cos(orientation),
				py-length/2*utilityfunc.sin(orientation));		
		point2 = new BasePoint(px-length/2*utilityfunc.cos(orientation),
				py+length/2*utilityfunc.sin(orientation));
	}
	//////////////////////////////////////////////////
	/// Collision Functions
	//////////////////////////////////////////////////
	@Override
	boolean collideWith(BaseLine line) {
		// TODO Auto-generated method stub
		if(point1.collideWith(this)){
			return true;
		}
		else if(point2.collideWith(this)){
			return true;
		}
		return false;
	}
	@Override
	boolean collideWith(BasePoint point) {
		// TODO Auto-generated method stub
		point.collideWith(this);
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
		if(w > 0) {
			
			point1.setPosX(cm.getPosX()+length/2*Math.sin(getNormalAngle()));
			point1.setPosY(cm.getPosY()-length/2*Math.cos(getNormalAngle()));		
			point2.setPosX(cm.getPosX()-length/2*Math.sin(getNormalAngle()));
			point2.setPosY(cm.getPosY()+length/2*Math.cos(getNormalAngle()));
			point1.setVelX(w*length/2*Math.cos(getNormalAngle()));
			velx = w*length/2*Math.cos(getNormalAngle());
			vely = w*length/2*Math.sin(getNormalAngle());
			point2.setVelX(-w*length/2*Math.cos(getNormalAngle()));
			point1.setVelY(w*length/2*Math.sin(getNormalAngle()));
			point2.setVelY(-w*length/2*Math.sin(getNormalAngle()));

		}
	}
	void updateMove(){
		if(!stationary){
			if(w > 0) {
				cm.updateMove();
				point1.updateMove();
				point2.updateMove();
			}
			else {
				point1.updateMove();
				point2.updateMove();
			}
		}
		else{
			velx = 0;
			vely = 0;
		}
	}
	void updateAccelerate(){
		
		point1.updateAccelerate();
		point2.updateAccelerate();
		cm.updateAccelerate();
		
	}
	void updateCollide(){
		
	}
	//////////////////////////////////////////////////
	/// Draw Functions
	//////////////////////////////////////////////////
	public void drawSelf(Graphics2D g){
		paint.drawAALine(g, (int)point1.getPosX(), (int)point1.getPosY(),
				(int)point2.getPosX(), (int)point2.getPosY(), 1, Color.red);
		point1.drawSelf(g);
		point2.drawSelf(g);
	}
	//////////////////////////////////////////////////
	/// Get/Set Functions
	//////////////////////////////////////////////////
	void getSelf(PhysicsObject obj){
		obj.setVarLine(this);
	}
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
		cm.setVelX(velx);
	}
	void syncVelY(){
		point1.setVelY(vely);
		point2.setVelY(vely);
		cm.setVelY(vely);
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
		cm.setAccelX(accelx);
	}
	void syncAccelY(){
		point1.setAccelY(accely);
		point2.setAccelY(accely);
		cm.setAccelY(accely);
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
	int getMass(){
		return mass;
	}
	double getNormalAngle(){
		return Math.atan2(-(point2.getPosX()-point1.getPosX()),(point2.getPosY()-point1.getPosY()));
	}
	/// Other ///
	void setStationary(boolean b){
		stationary = b;
		point1.setStationary(b);
		point2.setStationary(b);
		cm.setStationary(b);
	}
	boolean getStationary(){
		return stationary;
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
	void printType(Circle c){
		System.out.println("This: Line, That: Circle");
	}
	void printType(PhysicsObject object) {
		System.out.println("Object call from line");
		object.printType(this);
		
	}
}

package modules;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class utilityfunc {
	public utilityfunc() {
		
	}
	//Fast Sin/Cos
	static final int precision = 10000; // gradations per degree, adjust to suit

	static final int modulus = 360*precision;
	static final float[] sin = new float[modulus]; // lookup table
	static { 
	    // a static initializer fills the table
	    // in this implementation, units are in degrees
	    for (int i = 0; i<sin.length; i++) {
	        sin[i]=(float)Math.sin((i*Math.PI)/(precision*180));
	    }
	}
	// Private function for table lookup
	private static float sinLookup(int a) {
	    return a>=0 ? sin[a%(modulus)] : -sin[-a%(modulus)];
	}

	// These are your working functions:
	public static double sin(float a) {
	    return (double)sinLookup((int)(a * precision + 0.5f));
	}
	public static double cos(float a) {
	    return (double)sinLookup((int)((a+90f) * precision + 0.5f));
	}
	//---------------------------------------------------------
	public static double min(double a, double b){
		return a<b? a:b;
	}
	public static double max(double a, double b){
		return a>b? a:b;
	}
	public double length2D(Point2D.Double p){
		return Math.sqrt(p.x*p.x+p.y*p.y);
	}
	public Double add2D(Point2D.Double p1, Point2D.Double p2){
		return new Double(p1.x+p2.x,p1.y+p2.y);
	}
	public Double subtract2D(Point2D.Double p1, Point2D.Double p2){
		return new Double(p1.x-p2.x,p1.y-p2.y);
	}
	public Double divide2D(double d, Point2D.Double p){
		return new Double(p.x/d,p.y/d);
	}
	public Double multiply2D(double d, Point2D.Double p){
		return new Double(p.x*d,p.y*d);
	}
	public double crossProduct2D(Point2D.Double p1, Point2D.Double p2){
		return p1.getX()*p2.getY()-p1.getY()*p2.getX();
	}
	public double dotProduct2D(Point2D.Double p1, Point2D.Double p2){
		return p1.x*p2.x+p1.y*p2.y;
	}
}

package modules;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class utilityfunc {
	
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

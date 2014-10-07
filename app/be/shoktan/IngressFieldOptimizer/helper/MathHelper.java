package be.shoktan.IngressFieldOptimizer.helper;

import models.Link;
import models.Portal;

public class MathHelper {
	public static final double ZERO = 0.00001;
	
	public static boolean doSegmentsIntersectEachOther(Link l1, Link l2){
		/*

		 * 
		 * x = (b2 - b1) / (a1 - a2)
		 */
		boolean result = false;
		Line first = new Line(l1);
		Line second = new Line(l2);
		
		double a = second.a - first.a;
		
		if(Math.abs(a) < ZERO){
			// lines don't cross
			result = false;
		}else{
			double x = (second.b - first.b) / a;
			return l1.containsLatitude(x) && l2.containsLatitude(x);
		}
		
		
		return result;
	}
	
	
	static private class Line{
		// y = a.x + b
		double a;
		double b;
		
		/*
		 * a = (y1 - y2 ) / (x1 - x2)
		 * b = y1 - a.x1
		 */
		Line(Link segment){
			Portal p1 = segment.getOrigin();
			Double y1 = p1.getLongitude();
			Double x1 = p1.getLatitude();
			
			Portal p2 = segment.getTarget();
			Double y2 = p2.getLongitude();
			Double x2 = p2.getLatitude();
			
			this.a = (y1 - y2) / (x1 - x2);
			this.b = y1 - a * x1;
		}
	}
}

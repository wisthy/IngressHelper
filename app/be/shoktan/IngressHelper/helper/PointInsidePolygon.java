/**
 * 
 */
package be.shoktan.IngressHelper.helper;

import java.util.ArrayList;

/**
 * @author wisthler
 * Based on algo found at http://stackoverflow.com/questions/4287780/detecting-whether-a-gps-coordinate-falls-within-a-polygon-on-a-map
 */
public class PointInsidePolygon {
	public static double PI = 3.14159265;
    public static double TWOPI = 2*PI;
	
	public static boolean coordinate_is_inside_polygon(
		    double latitude, double longitude, 
		    ArrayList<Double> lat_array, ArrayList<Double> long_array)
		{       
		       int i;
		       double angle=0;
		       double point1_lat;
		       double point1_long;
		       double point2_lat;
		       double point2_long;
		       int n = lat_array.size();

		       for (i=0;i<n;i++) {
		          point1_lat = lat_array.get(i) - latitude;
		          point1_long = long_array.get(i) - longitude;
		          point2_lat = lat_array.get((i+1)%n) - latitude; 
		          //you should have paid more attention in high school geometry.
		          point2_long = long_array.get((i+1)%n) - longitude;
		          angle += Angle2D(point1_lat,point1_long,point2_lat,point2_long);
		       }

		       if (Math.abs(angle) < PI)
		          return false;
		       else
		          return true;
		}

		public static double Angle2D(double y1, double x1, double y2, double x2)
		{
		   double dtheta,theta1,theta2;

		   theta1 = Math.atan2(y1,x1);
		   theta2 = Math.atan2(y2,x2);
		   dtheta = theta2 - theta1;
		   while (dtheta > PI)
		      dtheta -= TWOPI;
		   while (dtheta < -PI)
		      dtheta += TWOPI;

		   return(dtheta);
		}
}

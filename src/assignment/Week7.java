package assignment;

import java.util.Vector;

public class Week7 {
	
	///convex hull week 7 question a
	
	 int x, y;
	 Week7(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }
	}
	class ConvexHull{
	  public static int OrientationMatch(Week7 check1, Week7 check2, Week7 check3) {
	    int val = (check2.y - check1.y) * (check3.x - check2.x) - (check2.x - check1.x) * (check3.y - check2.y);
	    if (val == 0)
	      return 0;
	    return (val > 0) ? 1 : 2;
	  }
	  public static void convex_hull(Week7 points[], int lengths) {
	    if (lengths<3) return;
	    Vector<Week7> result = new Vector<Week7> ();
	    int leftmost = 0;
	    for (int i = 1; i<lengths; i++)
	      if (points[i].x<points[leftmost].x)
	        leftmost = i;
	    int p = leftmost, pointq;
	    do {
	      result.add(points[p]);
	      pointq = (p + 1) % lengths;
	      for (int i = 0; i<lengths; i++) {
	        if (OrientationMatch(points[p], points[i], points[pointq]) == 2) {
	          pointq = i;
	        }
	      }
	      p = pointq;
	    }
	    while (p != leftmost);
	    System.out.print("The points in the convex hull are: ");
	    for (Week7 temp: result)
	      System.out.println("(" + temp.x + ", " + temp.y + ")");
	  }
	  public static void main(String[] args) {
		  Week7 points[] = new Week7[7];
	    points[0] = new Week7(0, 3);
	    points[1] = new Week7(2, 3);
	    points[2] = new Week7(1, 1);
	    points[3] = new Week7(2, 1);
	    points[4] = new Week7(3, 0);
	    points[5] = new Week7(0, 0);
	    points[6] = new Week7(3, 3);
	    int lengths = points.length;
	    convex_hull(points, lengths);
	  }

}

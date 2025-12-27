/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		//curve(Integer.parseInt(args[0]),
		//	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
public static void curve(int n, double x1, double y1, double x5, double y5) {
        // Base case: at depth 0, just draw a straight line
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }
        double x2 = x1 + (x5 - x1) / 3.0;
        double y2 = y1 + (y5 - y1) / 3.0;
        double x4 = x1 + 2 * (x5 - x1) / 3.0;
        double y4 = y1 + 2 * (y5 - y1) / 3.0;
        double x3 = (Math.sqrt(3) / 6.0) * (y1 - y5) + 0.5 * (x1 + x5);
        double y3 = (Math.sqrt(3) / 6.0) * (x5 - x1) + 0.5 * (y1 + y5);
        
        curve(n - 1, x1, y1, x2, y2); 
        curve(n - 1, x2, y2, x3, y3); 
        curve(n - 1, x3, y3, x4, y4); 
        curve(n - 1, x4, y4, x5, y5); 
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        double x1 = 0.2, y1 = 0.2;
        double x2 = 0.8, y2 = 0.2;
        double x3 = 0.5, y3 = 0.2 + (0.6 * Math.sqrt(3) / 2);

        curve(n, x1, y1, x3, y3); 
        curve(n, x3, y3, x2, y2); 
        curve(n, x2, y2, x1, y1); 
	}
}

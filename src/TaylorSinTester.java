import graph2D.Graph2D; // Imports the Graph2D class (from the graph2D package)
import java.awt.Color;  // If you want to change the color of the elements to draw
import java.util.Locale;
/**
 * Class that allows comparing the value returned by TaylorSin.sin(x)
 * with the one provided by Java's Math.sin(x). It also allows graphically representing
 * TaylorSin.sin(x), using the Graph2D library.
 */
public class TaylorSinTester {
    
    private TaylorSinTester() { }

    public static void main(String[] args) {
        table();
        graph();
    }
    /** Writes to the standard output, line by line, the values of
     *  Math.sin(x) and TaylorSin.sin(x), for x from 0 to 20 radians.
     *  Shows the absolute difference between these values.
     */
    public static void table() {  
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("  x           Math.sin(x)             TaylorSin.sin(x)             |dif|");
        System.out.println("-----------------------------------------------------------------------------");
        double xMin = 0.0, xMax = 20.0;  // minimum and maximum values of the angle in radians
        double delta = 1.0;              // increment in each step of x
		// For x from xMin to xMax, in increments of delta, show Math.sin(x), 
		// TaylorSin.sin(x) and the absolute difference between these values.
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = TaylorSin.sin(x);
            double yMath = Math.sin(x);
            double dif = Math.abs(y - yMath);
            System.out.printf(Locale.US, "%4.1f %23.15f %23.15f %23.15f\n", x, yMath, y, dif);   
        }
    }
    
    /** Gets the graph of the TaylorSin.sin(x) function in the interval [-20, 20]. */
    public static void graph() {
        // Define range of values for x and y
        double xMin = -20.0;
        double xMax = 20.0;
        double yMin = -2.0;
        double yMax = 2.0;
        // Create the drawing space with the desired dimensions
        Graph2D gd = new Graph2D(xMin, xMax, yMin, yMax, 800, 250);
        gd.setTitle("TaylorSin");
        // Calculate the increment in each step of x (delta)
        double delta = (xMax - xMin) / Graph2D.INI_WIDTH; 
		// Iterate through each point in x, calculate f(x) and draw (x, f(x))
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = TaylorSin.sin(x) ;
            gd.drawPoint(x, y, Color.BLUE, 2); // represent (x, y)
                                               // in blue color and thickness 2
        }
    }
}

public class TaylorSin {
    private TaylorSin() { }
    
    /** Returns the sine of angle x, with a maximum error of epsilon.
     *  Precondition: x in radians, 0 < epsilon.
     */
    public static double sin(double x, double epsilon) {
        x = reduceFirstCirc(x);
        
        double term = x;
        double sumTerm = term;
        
        for(int k = 1; Math.abs(term) > epsilon; k++){
            term *= -x * x / ((2 * k) * (2 * k + 1));
            sumTerm += term;
        }
        
        return sumTerm;
    }
    
    /** Returns the sine of angle x, with a maximum error of 1e-15.
     *  Precondition: x in radians.
     */
    public static double sin(double x) {
        return sin(x, 1e-15);
    }
    
    /** Returns the reduction of angle x to the first circle (0 to 2π).
     *  Precondition: x in radians.
     */
    private static double reduceFirstCirc(double x) {
        return x % (Math.PI*2);
    }  
}

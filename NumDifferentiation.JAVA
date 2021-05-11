/**
 * This program compares the four numerical differentiation methods:
 * forward difference formula,backward difference formula, Lagrange basis, and
 * undetermined coefficients using f(x) = sin(x) with x0 = 2/3 * pi
 * with h = 0.1, 0.05, 0.025, 0.0125, 0.00625.
 * 
 * CSC 2262 Programming Project No 3
 * 
 * @author Curtis Laborde
 * @since 11/5/2020
 */
package numdifferentiation;

public class NumDifferentiation {
  
    /**
     * This method calculates the undetermined coefficient
     * 
     * Method: UC
     * 
     * return type: double
     * 
     * parameters: 
     *          h       double      value of h
     *          x0      double      value of x0
     * 
     * @author Curtis Laborde
     * @since 11/5/2020
     */
    public static double UC(double h, double x0) {
        double val = (Math.sin(x0 + h) - (2 * Math.sin(x0))) + Math.sin(x0 - h) / (h * h);
        return val;
    }
    /**
     * This method calculates the backward difference formula
     * 
     * Method: BDF
     * 
     * return type: double
     * 
     * parameters: 
     *          h       double      value of h
     *          x0      double      value of x0
     * 
     * @author Curtis Laborde
     * @since 11/5/2020
     */
    public static double BDF(double h, double x0) {
        double val = (Math.sin(x0) - Math.sin(x0 - h)) / h;
        return val;
    }
    /**
     * This method calculates the forward difference formula
     * 
     * Method: FDF    
     * 
     * return type: double
     * 
     * parameters: 
     *          h       double      value of h
     *          x0      double      value of x0
     * 
     * @author Curtis Laborde
     * @since 11/5/2020
     */
    public static double FDF(double h, double x0) {
        double val = (Math.sin(x0 + h) - Math.sin(x0)) / h;
        return val;
    }
    /**
     * This method calculates the Lagrange Basis formula 
     * 
     * Method: LB
     * 
     * return type: double
     * 
     * parameters: 
     *          h       double      value of h
     *          x0      double      value of x0
     * 
     * @author Curtis Laborde
     * @since 11/5/2020
     */

    public static double LB(double h, double x0) {
        double val = (Math.sin(x0 + h) - Math.sin(x0 - h)) / (2 * h);
        return val;
    }
    /**
     * The main function takes the values of h and prints the respected answers to screen
     *  h = 0.1, 0.05, 0.025, 0.0125, 0.00625
     *  f(x) = sin(x) with 𝑥0 = 2/3*pi
     *  
     */
    public static void main(String[] args) {
        double h = 0.1;
        double tmp = 2 * h;
        System.out.printf("%11s%14s%14s%13s%15s%n", "h", "FDF", "BDF", "LB", "UC");
        for (int i = 0; i < 5; i++) {
            tmp = tmp / 2;
            System.out.printf("%.10f  %.10f  %.10f %.10f  %.10f%n", tmp, NumDifferentiation.FDF(tmp, (2 / 3) * Math.PI), NumDifferentiation.BDF(tmp, (2 / 3) * Math.PI), NumDifferentiation.LB(tmp, (2 / 3) * Math.PI), NumDifferentiation.UC(tmp, (2 / 3) * Math.PI));
        }
    }
}

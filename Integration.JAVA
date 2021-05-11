/**
* This program computes the approximation of f(x) = ln(x) using both 
* the Trapezoidal Rule and Simpson Rule on the interval [1,3] using 512 subintervals.
* 
* CSC 2262 Programming project No 3
*
* @author Curtis Laborde
* @since 10/28/2020
*
*/

package integration;



public class Integration {
    
 /**
 * This method computes the approximation using the Trapezoidal Rule Method.
 * 
 * method: trapezoidalMethod
 * 
 * return type: double
 * 
 * parameters: 
 *              a       double      lower bound of integral
 *              b       double      upper bound of integral
 *              N       int         number of subintervals
 * 
 * @author Curtis Laborde 
 * @since 10/28/2020
 */
    public static double trapezoidalMethod(double a, double b, int N){
        
        double h = (b-a)/N;
        double sum = 0;
        
        sum += f(a);
        
        for(int i = 1; i < N; i++)
            sum += 2*f(a+i*h);
        
        sum += f(b);
        
        return h/2*sum;
    }
    
    /**
 * This method computes the approximation using the Simpson Rule Method.
 * 
 * method: simpsonRule
 * 
 * return type: double
 * 
 * parameters: 
 *              a       double      lower bound of integral
 *              b       double      upper bound of integral
 *              N       int         number of subintervals
 * 
 * @author Curtis Laborde 
 * @since 10/28/2020
 */
    public static double simpsonRule(double a, double b, int N){
        
        double h = (b-a)/N;
        double sum = 0;
        
        sum += f(a);
        
        for(int i = 1; i < N; i++)
            sum += (2+2*(i%2))*f(a+i*h);
        
        sum += f(b);
        
        return h/3*sum;
    }
    
    
    /**
     * This method is the driving function f(x)=ln(x)
     * 
     * method: f
     * 
     * return type: double
     * 
     * parameters:
     *              x       double      x of the function
     * 
     * @author Curtis Laborde
     * @since 10/28/2020
     */
    public static double f(double x){
        return Math.log(x);
        //return 1.0/(1.0+x*x);
    }
    
    //Main function calls the two methods and prints out the approximations to screen with the given values a = 1, b = 3, N = 512.
    public static void main(String[] args) {
      System.out.println("Trapezoidal Rule: T512(f) = " + trapezoidalMethod(1, 3, 512));
      System.out.println("Simpson Rule: T512(f) = " + simpsonRule(1, 3, 512));
    }
    
}



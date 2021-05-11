/**
 * This program uses Gaussian Elimination with pivoting to solve
 * a system of linear equations of any size n>1.
 * 
 * CSC 2262 Programming project No 7
 * 
 * @author Curtis Laborde
 * @since 11/13/2020
 */
package gaussian.elimination;

public class GaussianElimination {
    
    /**
     * This method finds the row that has an entity furthest from zero with respect 
     * to the pivot function for matrix A.
     * 
     * method: max
     * 
     * return type: int
     * 
     * parameters:
     *          x       double          matrix A
     *          row     int             row of matrix/array
     * 
     * @author Curtis Laborde
     * @since 11/13/2020
     */
    public static int max(double[][] x, int row){
        int tmp = row;
        for(int i = row + 1; i < x.length; i++){
            if(Math.pow(x[tmp][row],2) < Math.pow(x[i][row],2))
                tmp = i;
        }
        return tmp;
    }
    /**
     * This method carries out the subtraction of 2 rows in both matrix A and b 
     * 
     * method: subtraction
     * 
     * return type: none
     * 
     * parameters: 
     *          x       double      matrix A
     *          y       double      matrix b
     *          row_1   int         row subtracting values
     *          row_2   int         row being subtracted
     * 
     * @author Curtis Laborde
     * @since 11/13/2020
     * 
     */
    public static void subtraction(double[][] x, double[][] y, int row_1, int row_2){
        double tmp = x[row_1][row_1]/x[row_2][row_2];
        for(int i = row_1; i < x.length; i++){
            x[row_2][i] = x[row_2][i] - x[row_1][i]/tmp;
        }
        y[row_2][0] = y[row_2][0] - y[row_1][0]/tmp;
    }
     
    /**
     * This method computes the Gaussian Elimination
     * 
     * method: solver
     * 
     * return type: none
     * 
     * parameters:
     *          x       double      matrix A
     *          y       double      matrix b
     * 
     * @author Curtis Laborde
     * @since 11/13/2020
     */
    public static void solver(double[][] x, double[][] y){
        for(int i = 0; i < x.length - 1; i++){
            GaussianElimination.pivotFunction(max(x, i), x, y, i);
            for(int a = i + 1; a < x.length; a++){
                GaussianElimination.subtraction(x, y, i, a);
            }
            
        }
    }
    
    /**
     * This method carries out the pivot function
     * 
     * method: pivotFunction
     * 
     * return type: none
     * 
     * parameters:
     *          Row_max         int         row that contains number furthest from zero
     *          x               double      matrix A
     *          y               double      matrix b
     *          Row_start       int         row being pivoted
     *          
     * @author Curtis Laborde
     * @since 11/13/2020
     */
    public static void pivotFunction(int Row_max, double[][] x, double[][] y, int Row_start){
        double tmp;
        for(int i = Row_start; i < x.length; i++){
            tmp = x[Row_start][i];
            x[Row_start][i] = x[Row_max][i];
            x[Row_max][i] = tmp;
        }
        tmp = y[Row_start][0];
        y[Row_start][0] = y[Row_max][0];
        y[Row_max][0] = tmp;
    }
    

    /**
     * This method prints the output in the desired format
     * 
     * method printFunction
     * 
     * return type: none
     * 
     * parameters:
     *          arr         double          printed matrix
     *          title       String          name of printed matrix
     * 
     * @author Curtis Laborde
     * @since 11/13/2020
     */
    public static void printFunction(double [][] arr, String title){
        System.out.println(title +" =");
        for (double[] arr1 : arr) {
            for (int a = 0; a < arr1.length; a++) {
                if (arr1[a] < 0 || arr1[a] >= 10) {
                    System.out.printf("| %.3f ", arr1[a]);
                } else {
                    System.out.printf("| %.3f ", arr1[a]);
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[][] x = new double[4][4]; //Matrix A
        double[][] y = new double[4][1]; //Matrix b
        double[][] a = new double[4][1]; //Matrix x
        
        //All the values of the given matrix stored in its respected positions
        //Here 'x' is the values stored in matrix A and 'a' represents x. Sorry for any confusion.
        x[0][0] = 2;
        x[0][1] = 1;
        x[0][2] = -1;
        x[0][3] = -2;
        x[1][0] = 4;
        x[1][1] = 4;
        x[1][2] = 1;
        x[1][3] = 3;
        x[2][0] = -6;
        x[2][1] = -1;
        x[2][2] = 10;
        x[2][3] = 10;
        x[3][0] = -2;
        x[3][1] = 1;
        x[3][2] = 8;
        x[3][3] = 4;
        
        y[0][0] = 2;
        y[1][0] = 4;
        y[2][0] = -5;
        y[3][0] = 1;
        
        System.out.printf("Ax = b\n\n");
        GaussianElimination.printFunction(x, "A");
        
        //Math for matrix x
        a[3][0] = y[3][0]/x[3][3];
        a[2][0] = (y[2][0] - x[2][3]*x[3][0])/x[2][2];
        a[1][0] = (y[1][0] - x[1][3]*x[3][0] - x[1][2]*a[2][0])/x[1][1];
        a[0][0] = (y[0][0] - x[0][3]*x[3][0] - x[0][2]*a[2][0] - x[0][1]*a[1][0])/x[0][0];
        
        //Prints matrix X
        GaussianElimination.printFunction(a, "x");
        
        //Prints matrix b
        GaussianElimination.printFunction(y,"b");
        GaussianElimination.solver(x, y);
        

        
        
    }
    
}

/**
 *
 * The Gauss-Seidel Iteration method
 * 
 * This program uses The Gauss-Seidel Iteration method to solve a system of linear equations of any size n >1. 
 * 
 * @author Curtis Laborde
 * @since 11/21/2020
 */

package gaussseideliteration;

public class GaussSeidelIteration {
    
    /**
     * This method stores the given values as entities for the matrix A.
     * 
     * method: entities_A
     * 
     * return type: none
     * 
     * parameters:
     *          A       double      name of array A that stores i and j array positions.
     * 
     * @author Curtis Laborde
     * @since 11/21/2020
     */
    public static void entities_A(double[][] A) {
        A[0][0] = 4;
        A[0][1] = -1;
        A[0][2] = 0;
        A[0][3] = -1;
        A[0][4] = 0;
        A[0][5] = 0;
        A[1][0] = -1;
        A[1][1] = 4;
        A[1][2] = -1;
        A[1][3] = 0;
        A[1][4] = -1;
        A[1][5] = 0;
        A[2][0] = 0;
        A[2][1] = -1;
        A[2][2] = 4;
        A[2][3] = 0;
        A[2][4] = 0;
        A[2][5] = -1;
        A[3][0] = -1;
        A[3][1] = 0;
        A[3][2] = 0;
        A[3][3] = 4;
        A[3][4] = -1;
        A[3][5] = 0;
        A[4][0] = 0;
        A[4][1] = -1;
        A[4][2] = 0;
        A[4][3] = -1;
        A[4][4] = 4;
        A[4][5] = -1;
        A[5][0] = 0;
        A[5][1] = 0;
        A[5][2] = -1;
        A[5][3] = 0;
        A[5][4] = -1;
        A[5][5] = 4;
    } 
    /**
     * This method stores the given values as entities for the matrix B.
     * 
     * method: entities_B
     * 
     * return type: none
     * 
     * parameters:
     *          b       double      name of array B that stores i positions.
     * 
     * @author Curtis Laborde
     * @since 11/21/2020
     */
    public static void entities_B(double[] b) {
        b[0] = 0;
        b[1] = 5;
        b[2] = 0;
        b[3] = 6;
        b[4] = -2;
        b[5] = 6;
    }
    
    /**
     * This method stores the given values as entities for the matrix X.
     * 
     * method: entities_X
     * 
     * return type: none
     * 
     * parameters:
     *          x       double      name of array A that stores i positions.
     * 
     * @author Curtis Laborde
     * @since 11/21/2020
     */
    public static void entities_X(double[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = 0;
        }
    }
    /**
     * This method is the printFunction for matrix X and B.
     * 
     * method: printFunction
     * 
     * return type: none
     * 
     * parameters:
     *          arr       double      temp array.
     *          alpha     String      name of printed matrix.
     * 
     * @author Curtis Laborde
     * @since 11/22/2020
     */
    public static void printFunction(double[] arr, String alpha) {
        System.out.println(alpha + " =");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] >= 10) {
                System.out.printf("| %.3f  ", arr[i]);
            } else {
                System.out.printf("|  %.3f  ", arr[i]);
            }
        }
        System.out.println("|");
        System.out.println();
    }
    
    /**
     * This method is used to print matrix A.
     * 
     * method: printMatrix_A
     * 
     * return type: none
     * 
     * parameters:
     *          arr       double      name of array.
     *          alpha     String      name of printed matrix.
     * 
     * @author Curtis Laborde
     * @since 11/22/2020
     */
    public static void printMatrix_A(double[][] arr, String alpha) {
        System.out.println(alpha + " =");
        for (double[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] < 0 || arr1[j] >= 10) {
                    System.out.printf("| %.3f  ", arr1[j]);
                } else {
                    System.out.printf("|  %.3f  ", arr1[j]);
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }
    
    /**
     * This method gets the difference of k and its previous entity.
     * 
     * method: getDifference
     * 
     * return type: double
     * 
     * parameters:
     *          previous_k       double      value of previous k.
     *          k                double      value of k.
     * 
     * @author Curtis Laborde
     * @since 11/22/2020
     */
    public static double getDifference(double[] previous_k, double[] k) {
        double maxDifference = 0.0001;
        for (int i = 0; i < k.length; i++) {
            double difference = Math.abs(k[i] - previous_k[i]);
            if (maxDifference < difference) {
                maxDifference = difference;
            }
        }
        return maxDifference;
    }
    
    /**
     * This method stores the given values as entities for the matrix A.
     * 
     * method: timesRan
     * 
     * return type: none
     * 
     * parameters:
     *          A       double      Matrix A
     *          b       double      Matrix b
     *          x       double      Matrix x
     * 
     * @author Curtis Laborde
     * @since 11/22/2020
     */
    public static void timesRan(double[][] A, double[] b, double[] x) {
        double difference = 1;
        int k = 0;
        double[] entity_X = new double[6];
        System.out.printf("k\tx 0\tx 1\tx 2\tx 3\tx 4\tx 5\t    Diff\n");
        while (difference > 0.0001) {
            if (k > 0) {
                difference = getDifference(entity_X, x);
            }

            entity_X[0] = x[0];
            entity_X[1] = x[1];
            entity_X[2] = x[2];
            entity_X[3] = x[3];
            entity_X[4] = x[4];
            entity_X[5] = x[5];
            
            
            x[0] = (1 / A[0][0]) * (b[0] - A[0][1] * x[1] - A[0][2] * x[2] - A[0][3] * x[3] - A[0][4] * x[4] - A[0][5] * x[5]);
            x[1] = (1 / A[1][1]) * (b[1] - A[1][0] * x[0] - A[1][2] * x[2] - A[1][3] * x[3] - A[1][4] * x[4] - A[1][5] * x[5]);
            x[2] = (1 / A[2][2]) * (b[2] - A[2][0] * x[0] - A[2][1] * x[1] - A[2][3] * x[3] - A[2][4] * x[4] - A[2][5] * x[5]);
            x[3] = (1 / A[3][3]) * (b[3] - A[3][0] * x[0] - A[3][1] * x[1] - A[3][2] * x[2] - A[3][4] * x[4] - A[3][5] * x[5]);
            x[4] = (1 / A[4][4]) * (b[4] - A[4][0] * x[0] - A[4][1] * x[1] - A[4][2] * x[2] - A[4][3] * x[3] - A[4][5] * x[5]);
            x[5] = (1 / A[5][5]) * (b[5] - A[5][0] * x[0] - A[5][1] * x[1] - A[5][2] * x[2] - A[5][3] * x[3] - A[5][4] * x[4]);
            if (k == 0) {
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\n", k, entity_X[0], entity_X[1], entity_X[2], entity_X[3], entity_X[4], entity_X[5]);
            } else {
                System.out.printf("%d\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\t  %.4f\n", k, x[0], entity_X[1], entity_X[2], entity_X[3], entity_X[4], entity_X[5], difference);
            }
            k++;

        }
        System.out.println();
    }

    /**
     * The main method passes the values of entities A, X, and B and prints the values.
     * 
     * @author Curtis Laborde
     * @since 11/22/2020
     */
    public static void main(String[] args) {
        double[][] A = new double[6][6];
        double[] x = new double[6];
        double[] b = new double[6];
        

        entities_A(A);
        entities_X(x);
        entities_B(b);
        
        timesRan(A, b, x);
        System.out.printf("Ax = b\n\n");
        printMatrix_A(A, "A");
        printFunction(x, "x");
        printFunction(b, "b");

    }
}

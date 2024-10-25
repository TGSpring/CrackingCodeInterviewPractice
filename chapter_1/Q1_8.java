/**
 * Tyler Spring
 * 10/18/2024
 * Chapter 1 practice questions.
 * 
 * Zero Matrix: Set rows and columns to 0 if an element is 0.
 */

public class Q1_8 {
    public static void main(String[] args) {
        int [][] matrix = {
            {1,2,3},
            {4,0,6},
            {7,8,9}
        };

        System.out.println("Original Matrix: ");
        printMatrix(matrix);

        setZeros(matrix);

        System.out.println("\nMatrix After Setting Zeroes: ");
        printMatrix(matrix);
    }

    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        //Identify which rows and columns need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 ) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Zero out the identified rows.
        for (int i = 0; i < m; i++) {
            if (rows[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the identified columns
        for (int j = 0; j < n; j++) {
            if(cols[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
/**
 * Explanation:
 * 
 * 1. Identify Zero Rows and Columns:
 *      First, traverse the entire matrix to find where the zeros are located.
 *      Use two auxiliary arrays (rows and col) to mark which rows and columns need to be zeroed.
 * 2. Zero out Rows
 * 3. Zero out Columns
 * 4. Time complexity:
 *      O(m * n) we traverse the matrix twice, so it scales with the size of the matrix.
 *      Space complexity is O(m + n) we use two auxiliary arrays for rows and columns.
 */
/**
 * Tyler Spring
 * 10/23/2024
 * Chapter 1 practice questions.
 * 
 * Rotate Matrix: Rotate a matrix by 90 degrees clockwise.
 */
public class Q1_7 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotate(matrix);
        printMatrix(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        //Preform a layer-by-layer rotation, starting from the outermost layer.
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                //save the top element
                int top = matrix[first][i];

                //move left to top
                matrix[first][i] = matrix[last - offset][first];

                //Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                //Move right to bottom
                matrix[last][last - offset] = matrix[i][last];

                //Move top to right
                matrix[i][last] = top;
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
 * 1. In-Place Rotation:
 *      We rotate the matrix layer by layer, starting from the outermost layer 
 * and moving inward.
 *      For each layer, we preform a four-way swap: top to right, right to bottom,
 * bottom to left, and left to top.
 * 
 * 2. Using offsets:
 *      The offset helps us calculate the relative position of elements within the current layer.
 * This makes the swapping straightforward.
 * 
 * 3. Time Complexity:
 *      O(n^2), since we must visit all elements in the matrix.
 *      Space complexity: O(1) (in place rotation, no extra storage is used.)
 */

/**
 * Tyler Spring
 * 11/29/2024
 * Chapter 5 Question 5.1
 * Insertion
 */
public class Q5_1 {

    public static int updateBits(int N,  int M, int i, int j) {
        //Step 1: Create the mask.
        int left = ~0 << (j + 1);  //1's before position j
        int right = (1 << i) - 1;  //1's after position i.
        int mask = left | right;

        //Step 2: Clear the bits from i to j in N
        N = N & mask;

        //Step 3: Shift M into the correct position
        M = M << i;

        //Step 4: Insert M into N
        return N | M;
    }
    public static void main(String[] args) {
        int N = 1024; //Binary: 1000000000
        int M = 19; //Binary: 10011
        int i = 2;
        int j = 6;

        int result = updateBits(N, M, i, j);

        System.out.println("Result: " + result);
        System.out.println("Binary Result: " + Integer.toBinaryString(result));
    }
}
/**
 * Explanation:
 * Create the Mask:
 * Left part ~0 << (j + 1) 
 * ~0 is a binary number with all bits set to 1.
 * Shifting it left by (j + 1) places 1s before position j and 0s after j.
 * 
 * Right Part: (1 << i) - 1
 * 1 << i shifts 1 to the ith position, creating a binary number with a single 
 * 1 at position i.
 * Subtracting 1 gives a number with 1s in all positions below i.
 * 
 * Combine left and right parts: Mask = left | right 
 * The | (bitwise OR) combines the two parts, creating a mask with 1s outside the range [i, j] 
 * and 0s within the range.
 * 
 * Clear the bits in N:
 * N = N & mask 
 * This operation clears the bits of N in the range [i, j] by using the mask.
 * 
 * Insert M into N:
 * return N | M
 * The | combines the cleared N and the shifted M, effectively inserting M 
 * into N at the desired position.
 * 
 * Time Complexity:
 * Bitwise Operations: Operations like &, |, ~, and shifts are O(1) because they operate directly
 * on integers in constant time.
 * 
 * Overall Complexity: O(1) The method involves a fixed number of operations, independent of the size N or M.
 */
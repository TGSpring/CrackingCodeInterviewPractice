/**
 * Tyler Spring
 * 12/4/2024
 * Chapter 5 Question 5.6
 * Conversion.
 */
public class Q5_6 {
    //Function to count the number of bits to flip.
    public static int bitSwapRequired(int A, int B) {
        int diff = A ^ B; //XOR to find differing bits.
        int count = 0;

        //Count the number of 1s using Brian Kernighan's Algorithm.
        while(diff != 0) {
            diff = diff & (diff - 1); //Remove the least significant 1.
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
         // Test cases
         System.out.println(bitSwapRequired(29, 15)); // Example: 29 (11101) -> 15 (01111), Output: 2
         System.out.println(bitSwapRequired(7, 14)); // 7 (0111) -> 14 (1110), Output: 3
         System.out.println(bitSwapRequired(0, 0));  // Both numbers are the same, Output: 0
    }
}
/**
 * Explanation:
 * Compute the XOR of A and B to find the differing bits.
 * Count the 1s in the XOR result using Brian Kernighan's Algorithm.
 *  Subtract 1 and use a bitwise AND to remove the least significant 1 until the number 
 *  becomes 0.
 * Remove the count of 1s, which represents the number of bits to flip.
 * 
 * Time Complexity:
 * XOR operation (A ^ B): O(1), as it operates in constant time for fixed-size integers.
 * Bit counting:
 *  The Brian Kernighan's Algorithm runs in O(k), where k is the number of 1s in the XOR 
 *  result.
 */
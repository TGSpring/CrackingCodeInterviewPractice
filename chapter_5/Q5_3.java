/**
 * Tyler Spring
 * 12/1/2024
 * Chapter 5 Question 5.3
 * Flip Bit to Win.
 */
public class Q5_3 {
    int flipBit(int a) {
        //If all 1s, this is already the longest sequence
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0; //Tracks the length of the current sequence of 1s
        int previousLength = 0; //Tracks the length of the previous sequence of 1s before a 0.
        int maxLength = 1; //We can always have a sequence of at least 1.

        //Process all the bits of the integer.
        while (a != 0) {
            if ((a & 1) == 1) {
            //Current bit is a 1, Increment the current sequence length.
            currentLength++;

            } else if ((a & 1) == 0){
            //Current bit is a 0, update the previous sequence length.
            //If the next bit is 0, reset previousLength to 0
            //Update to 0 (if next bit is 0) or currentLength (if next bit is 1).
            previousLength = (a & 2) == 0 ? 0 : currentLength;
            currentLength = 0;
            }

            //Calculate the maximum length by considering the flipped 0 between sequences
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);

            //Right shift to move to the next bit.
            a >>>= 1;
        }

        //Return the maximum length of 1s after flipping one bit.
        return maxLength;
    }

 public static void main(String[] args) {
    Q5_3 solution = new Q5_3();

    System.out.println(solution.flipBit(1775)); // Binary: 11011101111 -> Output: 8
    System.out.println(solution.flipBit(0));    // Binary: 0 -> Output: 1
    System.out.println(solution.flipBit(-1));   // Binary: All 1s -> Output: 32 (on a 32-bit system)
 }   
}
/**
 * Explanation:
 * To find the longest sequence of 1s after flipping one 0 to 1, you track two sequences:
 * the current sequence of 1s and the previous sequence of 1s before a 0.
 * Use the sum of the current and previous sequences (plus 1 for the flipped bit) to 
 * calculate the maximum length.
 * 
 * Steps in the loop:
 * If the current bit is 1: Extend the current sequence length.
 * If the current bit is 0: Store the current sequence length into previousLength if
 * the next bit is 1, or reset it if the next bit is 0. Reset the current sequence length to 0.
 * Update the maxLength with the combined length of the current and previous sequences 
 * plus one for the flipped bit.
 * 
 * outPut: Return the longest sequence of 1s possible after flipping one bit.
 */
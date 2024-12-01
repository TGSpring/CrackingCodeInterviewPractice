/**
 * Tyler Spring
 * 12/1/2024
 * Chapter 5 Question 5.4
 * Next Number.
 */
public class Q5_4 {

    //Finds the next largest number with the same number of 1s in its binary rep.
        public static int getNext(int n) {
            //Find the rightmost 0 with 1s to its right.
            int c = n;
            int c0 = 0; //Count of trailing 0s
            int c1 = 0; //Count of 1s to the right of the rightmost 0.

            //Count trailing 0s (c0)
            while ((c & 1) == 0 && c != 0) {
                c0++;
                c >>=1; //Shift c to the right.
            }

            //Count 1s (c1) 
            while ((c & 1) == 1) {
                c1++;
                c >>= 1;
            }

            //If there is no '0' to flip, there's no larger number with the same number of 1s.
            if(c0 + c1 == 31 || c0 + c1 == 0) {
                return -1;
            }


            //Flip the rightmost non-trailing 0.
            int pos = c0 + c1; //Position of the rightmost non-trailing 0.
            n |= (1 << pos); //Flip the 0 at position 'pos'

            //Clear all bits to the right of 'pos'
            n &= ~((1 << pos) - 1); //Clear bits from position 0 to pos-1

            //Add back (c1-1) ones to the farthest right positions
            n |= (1 <<(c1 - 1)) - 1;

            return n;
        }



        //Finds the next smallest number with the same number of 1s in its binary rep.
        public static int getPrev(int n) {
            //Count trailing 1s (c1) and trailing 0s (c0) after the rightmost non-trailing 1
            int temp = n;
            int c0 = 0; //Count of trailing 0s
            int c1 = 0; //Count of 1s to the right of the rightmost non-trailing 1.

            //Count trailing 1s (c1)
            while ((temp & 1) == 1) {
                c1++;
                temp >>=1; //Shift temp to the right.
            }

            //If there are no 0s to flip, there's no smaller number with the same number of 1s.
            if (temp == 0) {
                return -1;
            }

            //Count trailing 0s (c0)
            while((temp & 1) == 0 && temp != 0) {
                c0++;
                temp >>=1;
            }

            //Flip the rightmost non-trailing 1
            int pos = c0 + c1; //Position of the rightmost non-trailing 1
            n &= (~0 << (pos +1)); //Clear all bits from pos onward.

            //Add back (c1 + 1) 1s to the rightmost positions.
            int mask = (1 << (c1 + 1)) -1; //Create a sequence of (c1 + 1) 1s
            n |= mask << (c0 - 1); //Position the 1s just after the cleared 0s

            return n;

        }
        public static void main(String[] args) {
        // Test Case 1: Small positive number
    int n1 = 5; // Binary: 101
    System.out.println("Number: " + n1 + " (" + Integer.toBinaryString(n1) + ")");
    int next1 = getNext(n1);
    int prev1 = getPrev(n1);
    System.out.println("Next larger: " + next1 + " (" + Integer.toBinaryString(next1) + ")");
    System.out.println("Next smaller: " + prev1 + " (" + Integer.toBinaryString(prev1) + ")");
    
    // Test Case 2: A number with all bits set to 1
    int n2 = 7; // Binary: 111
    System.out.println("\nNumber: " + n2 + " (" + Integer.toBinaryString(n2) + ")");
    int next2 = getNext(n2);
    int prev2 = getPrev(n2);
    System.out.println("Next larger: " + next2 + " (" + (next2 == -1 ? "N/A" : Integer.toBinaryString(next2)) + ")");
    System.out.println("Next smaller: " + prev2 + " (" + Integer.toBinaryString(prev2) + ")");

    // Test Case 3: A number with a single 1 bit
    int n3 = 8; // Binary: 1000
    System.out.println("\nNumber: " + n3 + " (" + Integer.toBinaryString(n3) + ")");
    int next3 = getNext(n3);
    int prev3 = getPrev(n3);
    System.out.println("Next larger: " + next3 + " (" + Integer.toBinaryString(next3) + ")");
    System.out.println("Next smaller: " + prev3 + " (" + (prev3 == -1 ? "N/A" : Integer.toBinaryString(prev3)) + ")");

    // Test Case 4: A number with alternating bits
    int n4 = 10; // Binary: 1010
    System.out.println("\nNumber: " + n4 + " (" + Integer.toBinaryString(n4) + ")");
    int next4 = getNext(n4);
    int prev4 = getPrev(n4);
    System.out.println("Next larger: " + next4 + " (" + Integer.toBinaryString(next4) + ")");
    System.out.println("Next smaller: " + prev4 + " (" + Integer.toBinaryString(prev4) + ")");
    }
}
/**
 * Explanation:
 * getNext:
 * This method calculates the next larger number by flipping the rightmost 
 * 0 to 1 and adjusting the bits of the right of it.
 *      Count the number of trailing 0s (c0) and the number of 1s (c1) to 
 *      the right of the rightmost 0.
 * 
 *      If the sum of c0 and c1 is 31 or 0, return -1, as there's no valid larger number.
 *      
 *      Flip the rightmost 0 to 1 at position c0 + c1.
 * 
 *      Clear all bits to the right of the flipped bit.
 * 
 *      Set the c1 - 1 ones to the farthest right positions, ensuring the next number 
 *      as small as possible.
 * 
 * getPrev:
 * This method finds the next smaller number with teh same number of 1s by flipping 
 * the rightmost 1 to 0 and adjusting the bits to the right of it:
 *      Count the number of trailing 1s c1 and the number of trailing 0s c0 after 
 *      the rightmost non-trailing 1.
 * 
 *      If no valid smaller number exists return -1.
 * 
 *      Flip the rightmost non-trailing 1 to 0 at position c0 + c1.
 * 
 *      Add c1 + 1 ones to the farthest right positions to create the smallest 
 *      possible smaller number.
 * 
 * Time Complexity:
 * O(k), where k is the number of bits in the integer.
 * This is because both methods perform bit manipulation in a constant 
 * number of steps proportional to the size of the integer's binary representation.
 * Each operation is done a constant number of times, so the time 
 * complexity remains linear with respect to number of bits.
 */
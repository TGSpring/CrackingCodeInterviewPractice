/**
 * Tyler Spring
 * 11/29/2024
 * Chapter 5 Question 5.2
 * Binary to String
 */
public class Q5_2 {

    String printBinary(double num) {
        //Check if the number is outside the valid range (0, 1)
        if (num >= 1 || num <=0) {
            return "ERROR";
        }

        //Using StringBuilder to build the binary string.
        StringBuilder binary = new StringBuilder();
        binary.append(".");

        //Continue processing the number until it becomes 0 or the max length is reached.
        while(num > 0) {
            //Setting a limit on the length: 32 characters
            if (binary.length() >= 32) {
                return "ERROR";
            }

            //Mulitply the number by 2 and get the integer part.
            double r = num * 2;

            //If the integer part is 1, append the '1' to the binary string
            if (r >= 1) {
                binary.append(1);
                num = r - 1; //Subtract the integer part to keep the fractional part.
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
    public static void main(String[] args) {
        Q5_2 q5_2 = new Q5_2();
        
        // Test with some examples
        System.out.println(q5_2.printBinary(0.72)); // Should print something like "0.10111000111001"
        System.out.println(q5_2.printBinary(0.1));  // Should print ERROR
        System.out.println(q5_2.printBinary(0.5));  // Should print 0.1
    }
}

/**
 * Explanation:
 * Edge Case handling:
 * The method starts by checking if the input number num is between 0 and 1. 
 * If it's not, the method returns and ERROR message. This ensures you're only working
 * with valid fractional values.
 * 
 * Binary String Construction:
 * We initialize a StringBuilder to hold the binary string. The string starts with ".", as
 * we're dealing with the fractional part of the number.
 * 
 * Looping: The loop runs while num is greater than 0, meaning there's still a fractional 
 * part to convert.
 * In each iteration, the number is multiplied by 2.
 *  If the result r is greater than or equal to 1, it means the current bit is 1, and we 
 * append 1 to the binary string.
 *  If the result is less than 1, the current bit is 0, so we append 0 and continue to the
 * next step.
 *  The fractional part of num is retained by subtracting the integer part from r, num = r - 1.
 * This new num will be used in the next iteration.
 * 
 * Time complexity:
 * O(n), where n is the number of binary digits you are generating. In this case,
 * the max number of digits is capped at 32, so the time complexity is O(1) due
 * to fixed iteration limit.
 * 
 * Space Complexity:
 * O(n) as you are storing the resulting binary string. The space complexity is
 * linear with respect to the number of bits
 */
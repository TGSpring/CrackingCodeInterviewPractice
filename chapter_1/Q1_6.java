/**
 * Tyler Spring
 * 10/23/2024
 * Chapter 1 practice questions.
 * 
 * String Compression: Compress a string by counting repeated characters.
 */
public class Q1_6 {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("abcd"));
    }

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            //If the next character is different, or we're at the end
            // of the string, append the current character at its count to the compressed string.
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        // Only return the compressed string if it is shorter than the original.
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}

/**
 * Explanation:
 * 
 * 1. StringBuilder for Efficiency:
 *      Instead of using the + operator repeatedly we use StringBuilder to build the compressed string.
 * 
 * 2. Counting Consecutive Characters:
 *      We use a loop to iterate through the string. For each character, we increase a counter.
 *      If the next character is different from the current one, or we've reached the end of 
 * the string: 
 * Append the character and its count to the compressed string.
 * Reset the counter for the next set characters.
 * 
 * 3. Check lengths:
 *      If the compressed string is shorter than the original, we return the compressed version.
 * Otherwise, we return the original string.
 * 
 * 4. Time complexity:
 *      O(n) where n is the length of the input string. We pass through the string exactly once.
 *      
 */
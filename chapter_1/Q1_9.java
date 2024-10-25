/**
 * Tyler Spring
 * 10/18/2024
 * Chapter 1 practice questions.
 * 
 * String Rotation: Check if one string is a rotation of another.
 */
public class Q1_9 {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean res =  isRotation(s1, s2);
        System.out.println("is \"" + s2 + "\" a rotation of \"" + s1 + "\"? " + res);
    }

    public static boolean isRotation(String s1, String s2) {
        // Check if both strings have the same length and not empty
        if (s1.length() ==  s2.length() && s1.length() > 0) {
            // concatenate s1 with itself and check if s2 is a substring/
            String combined = s1 + s1;
            return isSubString(combined, s2);
        }
        return false;
    }
    // Helpler method to check if one string is a substring of another
    public static boolean isSubString(String str, String sub) {
        return str.contains(sub);
    }
}
/**
 * Explanation:
 * 1. Length Check
 *      If s1 and s2 are not the same length, s2 can not be a rotation of s1.
 * 2. Concatenation:
 *      We concatenate s1 with itself, resulting in s1 + s1.
 *      If s2 is a valid rotation, it will appear as a substring in the concatenated string.
 * 3. isSubString method:
 *      We use the String.contains() method in Java as a simple implementation Of
 * isSubString.
 * 4. Edge Cases:
 *      If either string is empty, we return false.
 *      If both strings are teh same and non-empty the method returns true.
 * 5. Time complexity:
 *  O(n) The time complexity of the contains() method, where n is the length of the string.
 * Space complexity is O(n) Due to the concatenation of s1 + s1.
 */
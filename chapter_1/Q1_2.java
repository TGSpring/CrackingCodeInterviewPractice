/**
 * Tyler Spring
 * 10/18/2024
 * Chapter 1 practice questions.
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 */

 public class Q1_2 {

    public static void main(String[] args) {
        // Test cases
        System.out.println(permutation("abc", "cab"));  // true
        System.out.println(permutation("hello", "bello"));  // false
        System.out.println(permutation("racecar", "carrace"));  // true
        System.out.println(permutation("test", "ttew"));  // false
    }

    /**
     * If two strings are permutations, they contain the same characters 
     * but in different orders. Sorting both strings and comparing them
     * will confirm if they are permutations.
     */
    static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }
}

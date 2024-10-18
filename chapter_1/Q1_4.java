import java.util.*;

/** 
 * Tyler Spring
 * 10/18/2024
 * Q1_4
 * 
 * Palindrome Permutation: Check if a string is a permutation of a palindrome.
 */
public class Q1_4 {
    public static void main(String[] args) {
        String input = "Tact Coa";
        boolean res = isPalindromePermutation(input);
        System.out.println(res);
    }

    private static boolean isPalindromePermutation(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        s = s.replaceAll("\\s+","").toLowerCase();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        boolean foundOdd = false;
        for (int count : charCount.values()) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}

/**
 * The function accepts a string and removes spaces, converting all Characters
 * to lower case to ensure valid input.
 * A HashMap is used to count the occurrences of each Character.
 * The put method is used to either add a new character or update the count of an Existing
 * character.
 * The algorithm checks how many characters have an odd count. A valid 
 * palindrome can have at most one character with an odd count.
 */
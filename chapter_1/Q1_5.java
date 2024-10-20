/**
 * Tyler Spring
 * 10/18/2024
 * Chapter 1 practice questions.
 * 
 * One Away: Check if two strings are one edit (or zero edits) away.
 */
public class Q1_5 {
   public static void main(String[] args) {
    System.out.println(oneEditAway("pale", "ple")); 
    System.out.println(oneEditAway("pales", "pale"));  
    System.out.println(oneEditAway("pale", "bale"));  
    System.out.println(oneEditAway("pale", "bake")); 
   }

public static boolean oneEditAway(String first, String second) {
    //If the length difference is more than 1, they can't be one edit away
    if (Math.abs(first.length() - second.length()) > 1) {
        return false;
    }
    //Identify the shorter and longer string
    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    int index1 = 0, index2 = 0;
    boolean foundDifference = false;

    while (index1 < s1.length() && index2 < s2.length()) {
        if (s1.charAt(index1) != s2.length()) {
            //If more than one difference is found, return false.
            if (foundDifference) {
                return false;
            }
            foundDifference = true;

            //If the lengths are the same, move both pointers.
            if (s1.length() == s2.length()) {
                index1++;
            }
        }
        else {
            //If the characters match, move the shorter string's pointer.
            index1++;
        }
        //Always move the pointer for the longer string.
        index2++;
    }
    return true;
} 
}
/**
 * Explanation:
 * 1. Length check:
 *  If the difference in lengths between two strings is greater than 1, they can not be one 
 * edit away.
 * 
 * 2. Two pointers approach:
 *  We use two pointers, one for each string, index1, index2
 *  If the characters at the current pointers do not match:
 *      If a difference has already been found before, return false.
 *      Otherwise, mark foundDifference as true.
 *      If the lengths are equal, move both pointers; 
 * otherwise only move the pointer for the longer string.
 * 
 * 3. Edge Cases:
 *  The loop handles scenarios where one string is longer than the other by always advancing
 * the pointer for the longer string. 
 * 
 * 4. Time complexity:
 *  O(n) where n is the length of the shorter string. This solution is efficient since it completes
 * in a single pass through both strings.
 */

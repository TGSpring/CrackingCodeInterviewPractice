/**
 * Chpt1Questions
 * Q: 1.1
 * Is Unique: Implement an algorithm to determine if all characters in a string are unique.
 * What if you can not use additional data structures?
 */

 /**
  * This has a complexity of O(n), n is the length of the string. The space complexity is O(1).
  */
public class Chpt1Questions {

    public static void main(String[] args) {
        
    }

    boolean isUniqueChars(String str) {
        if (str.length() > 128 ) return false;

    boolean[]char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]){
            return false;
        }
        char_set[val] = true;
    }
    return true;
}

/**
 * Here the space usage is reduced by a factor of eight by using a bit vector.
 * Assume the code uses a string in all lowercase.
 */

    boolean isUniqueChars_(String str) {
            int checker = 0;
            for (int i = 0; i < str.length(); i++) {
                int val = str.charAt(i) - 'a';
                if ((checker & (1 << val)) > 0) {
                    return false;
                }
                checker |= (1 << val);
            }
            return true;
    }
/**
 * If we can not use additional data structures then we can compare every character
 * of the string to every other character of the other string. This will take O(n^2) time and 
 * O(1) space.
 */
}
/**
 * this is a test
 * 
 */
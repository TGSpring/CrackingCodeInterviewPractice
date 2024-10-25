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

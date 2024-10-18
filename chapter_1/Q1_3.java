/** 
 * Tyler Spring
 * 10/18/2024
 * Q1_3
 * 
 * URLify: Replace all spaces in a string with "%20"
 */
public class Q1_3 {

    public static void main(String[] args) {
        String input = "Mr John Smith      ";
        int trueLength = 13; //True length of the string
        String res = urlify(input, trueLength);
        System.out.println(res);
    }

    public static String urlify(String s, int trueLength) {
        char[] chars = s.toCharArray();
        StringBuilder urlified = new StringBuilder();

        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                urlified.append("%20");
            } else { 
                urlified.append(chars[i]);
            }
        }
        return urlified.toString(); 
    }
}
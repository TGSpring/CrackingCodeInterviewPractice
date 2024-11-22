/**
 * Tyler Spring
 * 11/22/2024
 * Chapter 4 Question 4.10
 * Check Subtree - Optimized Approach
 */
public class Q4_10_Optimized {
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // Serializes a tree using pre-order traversal.
    private static String serialize(TreeNode root) {
        if (root == null) return "X"; //X denotes null.
        return root.value + " " + serialize(root.left) + " " + serialize(root.right);
    }

    //Checks if T2 is a subtree of T1 using serialization.
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        String serializedT1 = serialize(t1);
        String serializedT2 = serialize(t2);

        //Check if serialized T2 is a substring of serialized T1.
        return serializedT1.contains(serializedT2);
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);

        System.out.println("Is T2 a subtree of T1? " + isSubtree(t1, t2));
    }
}
/**
 * Explanation:
 * Better for large datasets where substring matching can be done efficiently.
 * Preferred when memory usage for serialized strings is not a concern.
 */
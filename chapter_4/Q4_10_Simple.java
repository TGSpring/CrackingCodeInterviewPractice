/**
 * Tyler Spring
 * 11/22/2024
 * Chapter 4 Question 4.10
 * Check Subtree - Simple Approach
 */
public class Q4_10_Simple {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;    
        }
    }

    // Checks if T2 is a subtree of T1
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true; //An empty tree is always a subtree.
        if (t1 == null) return false; //T1 is empty but T2 is not.

        //Check if T1's subtree starting at this node matches T2.
        if(isIdentical(t1, t2)) {
            return true;
        }

        //Recursively check the left and right subtrees of T1.
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    //Helper function to check if two trees are identical.
    private static boolean isIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; //Both are null.
        if (t1 == null || t2 == null) return false; //One is null, the other is not.
        if (t1.value != t2.value) return false; //Values don't match.

        //Recursively check left and right subtrees.
        return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
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
 * Suitable for smaller trees or when tree traversal methods need to be maintained.
 * Easier to debug due to straightforward logic.
 */
/**
 * Tyler Spring
 * 11/13/2024
 * Chapter 4 Question 4.4
 * Check Balanced
 */


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

public class Q4_4 {
//Helper class to return height and balance status in one object.
    static class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    //Main method to check if a tree is balanced.
    public static boolean isBalanced(TreeNode root){
        return checkBalance(root).isBalanced;
    }

    //Recursive method to determine balance and calculate height.
    private static TreeInfo checkBalance(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, -1); //Base case: null tree is balanced with height.
        }

        //Check balance of left subtree.
        TreeInfo leftInfo = checkBalance(node.left);
        if(!leftInfo.isBalanced) {
            return new TreeInfo(false, 0); // Propagate imbalance up.
        }
        //Check balance of right subtree.
        TreeInfo rightInfo = checkBalance(node.right);
        if (!rightInfo.isBalanced) {
            return new TreeInfo(false, 0); //Propagate imbalance up.
        }

        //Check current node's balance condition.
        boolean isBalanced = Math.abs(leftInfo.height - rightInfo.height) <= 1;
        int currentHeight = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new TreeInfo(isBalanced, currentHeight);
    }

    public static void main(String[] args) {
          // Example 1: Balanced tree.
          TreeNode root1 = new TreeNode(1);
          root1.left = new TreeNode(2);
          root1.right = new TreeNode(3);
          root1.left.left = new TreeNode(4);
          root1.left.right = new TreeNode(5);
          root1.right.left = new TreeNode(6);
          root1.right.right = new TreeNode(7);
  
          System.out.println("Is tree 1 balanced? " + isBalanced(root1)); // Output: true
  
          // Example 2: Unbalanced tree.
          TreeNode root2 = new TreeNode(1);
          root2.left = new TreeNode(2);
          root2.left.left = new TreeNode(3);
          root2.left.left.left = new TreeNode(4);
  
          System.out.println("Is tree 2 balanced? " + isBalanced(root2)); // Output: false
    }
}
/**
 * Explanation:
 * Definition of balance: A tree is balanced if the height difference between its left
 * and right subtrees is no more than 1 at every node.
 * 
 * Efficient Height Propagation: The checkBalance method calculates the height of Each
 * subtree while determining if it is balanced, avoiding redundant height recalculations.
 * 
 * Early Termination: As soon as an imbalance is detected, the recursion propagates the imbalance 
 * up eliminating further checks.
 * 
 * Time Complexity:
 * O(n), where n is the number of nodes in the tree. Each node is visited once, and height is
 * calculated in a bottom-up manner.
 * 
 * Comparison to Naive Solution:
 * A naive approach involves calculating height multiple times for the same node,
 * resulting in O(n^2) complexity. This implementation avoids that by merging balance checks
 * with height calculations.
 */
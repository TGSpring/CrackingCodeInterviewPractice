/**
 * Tyler Spring
 * 11/17/2024
 * Chapter 4 Question 4.5
 * Validate Binary Search Tree -
 */

class TreeNode {
    int value;
    TreeNode left, right;

    //Constructor to initialize a tree node with a value.

    public TreeNode(int value) {
        this.value = value;
    }
}

public class Q4_5 {
//Holds the value of the previously visited node during in-order traversal.
    private static Integer prev = null; 

    //Function to validate BST using in-order traversal.
    public static boolean isValidBST(TreeNode root) {
        //Base case: If the node is null, it is valid BST.
        if (root == null) return true;

        //Recursively check the left subtree.
        if (!isValidBST(root.left)) return false;

        //Check if the current node violates the BST property:
        //The value of the current node must be greater than the previous node's value.
        if (prev != null && root.value <= prev) return false;

        //Update the previous node's value to the current node's value.
        prev = root.value;

        //Recursively check the right subtree.
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        //Example: A valid BST 
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);

        System.out.println("Is the tree a valid BST? " + (isValidBST(root) ? "Yes" : "No"));

        //Reset the 'prev' variable for subsequent calls.
        prev = null;

        //Example: An invalid BST (violates the BST property).
        TreeNode invalidRoot = new TreeNode(10);
        invalidRoot.left = new TreeNode(5);
        invalidRoot.right = new TreeNode(15);
        invalidRoot.right.left = new TreeNode(6); // This violates the BST rule.

        System.out.println("Is the tree a valid BST? " + (isValidBST(invalidRoot) ? "Yes" : "No"));
    }
}
/**
 * Explanation:
 * 
 * Java Approach: Using In-Order Traversal.
 * Logic: Relies on the property that an in-order traversal of a BST visits in a 
 * strictly increasing order.
 * 
 * It verifies the BST property implicitly through the traversal order, without needing 
 * explicit bounds.
 * 
 * This approach is more intuitive but slightly less flexible for customizations 
 * than the C++ bounds-checking method.
 * 
 */
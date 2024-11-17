/**
 * Tyler Spring
 * 11/17/2024
 * Chapter 4 Question 4.6
 * Successor
 */


 class TreeNode {
    int value;
    TreeNode left, right, parent;

    //Constructor to initialize a tree node.
    public TreeNode(int value) {
        this.value = value;
    }
 }

public class Q4_6 {

    /**
     * Function to find the in-order successor of a given node 
     * in a binary search tree.
     * 
     *
     * @param node - the node whose successor is to be found.
     * @param the in-order successor node or null if no successor exists.
     */

     public static TreeNode findSuccessor(TreeNode node) {
        if (node == null) return null;

        //Case 1: Node has a right subtree
        if (node.right != null) {
            return findLeftmost(node.right);
        }

        //Case 2: Node has no right subtree.
        TreeNode current = node;
        TreeNode parent = node.parent;

        //Traverse up the tree until we find a node that is the left child of its parent.
        while(parent != null && parent.right == current) {
            current = parent;
            parent = parent.parent;
        }

        return parent; // This is the in-order successor or null if it doesn't exist.
     }
    /**
     * Helper function to find the leftmost node in a subtree.
     * 
     * @param node - the root of the subtree
     * @return the leftmost node
     */


     private static TreeNode findLeftmost(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
     }


 public static void main(String[] args) {
     // Construct a sample binary search tree
        TreeNode root = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);

        // Set up the tree structure
        root.left = node10;
        root.right = node30;
        node10.parent = root;
        node30.parent = root;

        node10.left = node5;
        node10.right = node15;
        node5.parent = node10;
        node15.parent = node10;

        // Example: Find the successor of the node with value 15
        TreeNode target = node15;
        TreeNode successor = findSuccessor(target);

        if (successor != null) {
            System.out.println("Successor of " + target.value + " is " + successor.value);
        } else {
            System.out.println("No successor found for " + target.value);
        }
 }   
}
/**
 * Explanation:
 * Case 1: Node has a right subtree.
 * The successor is the leftmost node in the right subtree. This is because the leftmost node will 
 * be the smallest node larger than the current node.
 * 
 * Case 2: Node has no right subtree.
 * We move up the tree until we find a node that is the left child of its parent. This 
 * parent will be the successor, as it is the next node in the in-order traversal.
 * 
 * Time Complexity:
 *O(h):
  Best Case: If the successor is found at the first step, the time 
  complexity is O(1).
  Worst Case: In a skewed binary search tree, the height h equals the number 
  of nodes n, so the time complexity is O(n).
  Balanced Case: If the tree is balanced, the height h is approximately O(log n), where n 
  is the number of nodes.

  Space complexity is O(1) additional space, as no auxiliary data structures are used 
  beyond simple pointer traversal.
 */
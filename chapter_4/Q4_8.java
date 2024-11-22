/**
 * Tyler Spring
 * 11/22/2024
 * Chapter 4 Question 4.8
 * First Common Ancestor - Minimal Memory Solution
 */
public class Q4_8 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * Finds the first common ancestor of two nodes in a binary tree.
     * 
     * 
     * @param root The root of the binary tree.
     * @param p First Node
     * @param q Second Node 
     * @return The first common ancestor node, or null if not found.
     */

     public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //Base case: if root is null or matches one of the nodes, return root.
        if (root == null || root == p || root == q) {
            return root;
        }

        //Recursively check the left and right subtrees.
        TreeNode left = findFirstCommonAncestor(root.left, p, q);
        TreeNode right = findFirstCommonAncestor(root.right, p, q);

        //If both left and right are non-null, current node is the common ancestor.
        if (left != null && right != null) {
            return root;
        }

        //Otherwise return the non-null child (if any).
        return left != null ? left : right;
     }



 public static void main(String[] args) {
     // Create a sample binary tree.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode p = root.left.left; // Node 4
        TreeNode q = root.left.right; // Node 5

        TreeNode ancestor = findFirstCommonAncestor(root, p, q);
        if (ancestor != null) {
            System.out.println("First Common Ancestor of " + p.value + " and " + q.value + " is: " + ancestor.value);
        } else {
            System.out.println("No common ancestor found.");
        }
 }   
}
/**
 * Explanation:
 * Recursive Traversal:
 * The algorithm starts at the root and recursively traverses down the tree.
 * For each node, it checks whether p or q exists in the left or right subtrees.
 * 
 * Base Cases:
 * If the current node is null, return null.
 * If the current node is equal to p or q return the current node.
 * 
 * Logic:
 * Recursively call the function for the left and right subtrees.
 * If p and q are found in different subtrees, the current node is their first common ancestor.
 * If both nodes are found in the same subtree, propagate the result upward.
 * 
 * Efficiency:
 * This approach avoid using parent pointers and external data structures.
 * The function only requires a single traversal of the tree, making it efficient.
 * 
 * Time Complexity:
 * O(n): Each node in the tree is visited only once in the worst case.
 * 
 * Space Complexity:
 * O(h): The space is determined by the recursion depth, which depends on the height 
 * of the tree.
 */
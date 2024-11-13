/**
 * Tyler Spring
 * 11/13/2024
 * Chapter 4 Question 4.2
 * Minimal Tree
 */
class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class Q4_2 {

    //Main method to create a BST with minimal height from a sorted array.
    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }
    
    //Recursive helper method to build tree.
    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        //Base case: If start index is greater than end index, no elements to add.
        if (start > end) {
            return null;
        }

        //Find the middle element to use as the root of the subtree.
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);

        //Recursively build the left and right subtrees.
        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);

        return node;
    }

    //Helper function to print the tree in in-order traversal.
    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.value + " ");
            inOrderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createMinimalBST(sortedArray);
        
        System.out.print("In-order traversal of the created BST: ");
        inOrderTraversal(root);
    }
}

/**
 * Explanation:
 * Main method (createMinimalBST): This method takes a sorted array 
 * and initiates the recursive process to create a BST.
 * 
 * Recursive Helper Method (createMinimalBST): It uses the middle element of the current 
 * segment of the array as the root to keep the tree balanced.
 * 
 * In-order Traversal: This traversal helps confirm that the tree is structured correctly 
 * as a binary search tree. It should output the values in ascending order.
 * 
 * Time Complexity:
 * O(N): where n is the number of elements in the array. We visit each element 
 * once to place it in the tree.
 */
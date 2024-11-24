/**
 * Tyler Spring
 * 11/24/2024
 * Chapter 4 Question 4.11
 * Random Node
 */


 import java.util.*;

 class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    int size; //Number of nodes in the subtree rooted at this node.

    public TreeNode(int value) {
        this.value = value;
        this.size = 1;
    }
    //Inserts a new value into the BST

    public void insert(int newValue) {
        if (newValue <= value) {
            if (left == null) {
                left = new TreeNode(newValue);
            } else {
                left.insert(newValue);
            }
            } else {
                if (right == null) {
                    right = new TreeNode(newValue);
                } else {
                    right.insert(newValue);
                }
            } 
            size++;
        }
    
    //Finds a node with a specific value
    public TreeNode find(int target) {
        if (target == value) {
            return this;
        } else if (target < value) {
            return  left != null ? left.find(target) : null;
        } else {
            return right != null ? right.find(target) : null;
        }
    }

    //Returns a random node from the subtree.
    public TreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size;
        Random random = new Random();
        int index = random.nextInt(size); // Random index between 0 and size - 1.

        if (index < leftSize) {
            return left.getRandomNode(); //Go left.
        } else if (index == leftSize) {
            return this; //Current node.
        } else {
            return right.getRandomNode(); // Go right.
        }
    }
}

public class RandomNodeTree {
    TreeNode root;
    
    //Insert a value into the tree.
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    //Finds a node with a specific value.
    public TreeNode find(int value) {
        return root != null ? root.find(value) : null;
    }

    //Returns a random node
    public TreeNode getRandomNode() {
        if (root == null) return null;
        return root.getRandomNode();
    }
    
    public static void main(String[] args) {
        RandomNodeTree tree = new RandomNodeTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        System.out.println("Random nodes from the tree:");
        for (int i = 0; i < 5; i++) {
            TreeNode randomNode = tree.getRandomNode();
            System.out.println(randomNode.value);
        }
    }
}
/**
 * Explanation:
 * Node size: Each treeNode tracks the size of its subtree/
 * The size is updated during each insert.
 * 
 * Random Selection:
 * The random index determines whether to select the current node, go left, 
 * go right based on subtree sizes.
 * 
 * Efficiency: getRandomNode() runs in O(h), where h is the height of the tree.
 * insert runs O(h), making it efficient for balanced trees.
 * 
 * Balanced trees: this approach works best for balanced trees, where h = logN.
 */
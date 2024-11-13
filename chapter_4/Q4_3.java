/**
 * Tyler Spring
 * 11/13/2024
 * Chapter 4 Question 4.3
 * List of Depths
 */
import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class Q4_3 {

    // BFS solution: Uses a queue to process nodes level by level.
    public static List<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<TreeNode> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node);

                // Enqueue left and right children
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(levelList);
        }
        return result;
    }

    // DFS solution: Uses recursion to group nodes by depth.
    public static List<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        dfsHelper(root, result, 0);
        return result;
    }

    private static void dfsHelper(TreeNode node, List<LinkedList<TreeNode>> result, int level) {
        if (node == null) return;

        // Add a new level if it doesn't exist.
        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        // Append node to its corresponding level list.
        result.get(level).add(node);

        // Recurse for left and right children.
        dfsHelper(node.left, result, level + 1);
        dfsHelper(node.right, result, level + 1);
    }

    // Helper function to print the list of depths
    public static void printLevelLinkedLists(List<LinkedList<TreeNode>> lists) {
        int depth = 0;
        for (LinkedList<TreeNode> list : lists) {
            System.out.print("Level " + depth + ": ");
            for (TreeNode node : list) {
                System.out.print(node.value + " ");
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Using BFS:");
        List<LinkedList<TreeNode>> levelListsBFS = createLevelLinkedListBFS(root);
        printLevelLinkedLists(levelListsBFS);

        System.out.println("\nUsing DFS:");
        List<LinkedList<TreeNode>> levelListsDFS = createLevelLinkedListDFS(root);
        printLevelLinkedLists(levelListsDFS);
    }
}

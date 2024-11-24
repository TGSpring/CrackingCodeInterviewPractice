
/**
 * Tyler Spring
 * 11/24/2024
 * Chapter 4 Question 4.12
 * Paths with Sum
 */


import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class PathsWithSum {

    public static int countPathsWithSum(TreeNode root, int targetSum) {
        //HashMap to store the running sum and its frequency
        HashMap<Integer, Integer> runningSumCount = new HashMap<>();
        runningSumCount.put(0, 1); //Default path for sum starting at root.
        return countPaths(root, targetSum, 0, runningSumCount);
    }

    private static int countPaths(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> runningSumCount) {
        if (node == null) {
            return 0;
        }

        //Update running sum
        runningSum += node.value;

        //Calculate the number of valid paths ending at the current node.
        int sum = runningSum - targetSum;
        int totalPaths = runningSumCount.getOrDefault(sum, 0);
        
        //Update the running sum count.
        runningSumCount.put(runningSum, runningSumCount.getOrDefault(runningSum, 0) + 1);

        //Count paths in left and right subtrees.
        totalPaths += countPaths(node.left, targetSum, runningSum, runningSumCount);
        totalPaths += countPaths(node.right, targetSum, runningSum, runningSumCount);

        //Remove the current node's running sum from the map (cleanup)
        runningSumCount.put(runningSum, runningSumCount.get(runningSum) - 1);

        return totalPaths;
    }
 public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = countPathsWithSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result);
 }   
}
/**
 * Explanation:
 * 
 * Running sum: Tracks the cumulative sum of values from the root to the current node.
 * 
 * HashMap: 
 * Key: a running sum value.
 * 
 * Value: The number of times this sum has been seen.
 * The hash map helps quickly calculate how many paths leading to the current node 
 * satisfy the target sum.
 * 
 * Recursive Cleanup: After visiting both child nodes, the current node's running sum 
 * is removed from the map to avoid affecting other parts.
 * 
 * Efficiency: By avoiding redundant calculations, the time complexity if O(n).
 */

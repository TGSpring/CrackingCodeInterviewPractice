/**
 * Tyler Spring
 * 11/24/2024
 * Chapter 4 Question 4.9
 * BST Sequences
 */

 import java.util.*;

public class Q4_9 {
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static List<List<Integer>> allSequences(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new ArrayList<>()); // Add an empty list.
            return result;
        }
        
        List<Integer> prefix = new ArrayList<>();
        prefix.add(node.value);

        //Recursively find sequences for left and right subtrees.
        List<List<Integer>> leftSeq = allSequences(node.left);
        List<List<Integer>> rightSeq = allSequences(node.right);

        //Weave together each combination of left and right sequences.
        for (List<Integer> left : leftSeq) {
            for (List<Integer> right : rightSeq) {
                List<List<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.add(weaved);
            }
        }

        return result;
    }

    private static void weaveLists(List<Integer> first, List<Integer> second,
                                    List<List<Integer>> results, List<Integer> prefix) {
        //Base case: if one list is empty, add the remaining list to the prefix.
        if(first.isEmpty() || second.isEmpty()) {
            List<Integer> result = new ArrayList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
        }

        //Recurse with the head of the first list.
        int headFirst = first.remove(0);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1 );
        first.add(0, headFirst);
      

      //Recurse with the head of the second list.
      int secondHead = second.remove(0);
      prefix.add(secondHead);
      weaveLists(first, second, results, prefix);
      prefix.remove(prefix.size() - 1);
      second.add(0, secondHead);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<List<Integer>> result = allSequences(root);

        System.out.println("All possible sequences that could form the BST:");
        for (List<Integer> sequence : result) {
            System.out.println(sequence);
        }
    }
}
/**
 * Explanation:
 * Base case: if the node is null, return an empty list (no sequence).
 * Recursive Case: Compute all possible sequences for left and right children.
 * 
 * Weaving Lists:
 * Take two lists (left and right subtree sequences) and interleave them while maintaining their 
 * relative orders.
 * This ensures all valid combinations are captured.
 * 
 * Time complexity:
 * O(2^n * n!)
 * 2^n the exponential factor comes from the number of interleaving combinations as we explore all subtree 
 * weavings.
 * n!
 * This represents the cost of generating all the permutations of the n nodes in the worst case.
 */
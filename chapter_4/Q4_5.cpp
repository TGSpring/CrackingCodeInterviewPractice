#include <iostream>
#include <climits>
using namespace std;
 /**
  * Tyler Spring
  * 11/17/2024
  * Chapter 4 4.5
  * Validate Binary Search Tree - C++ Solution
  */

struct TreeNode {
    int value;
    TreeNode* left;
    TreeNode* right;

    //Constructor to initialize a tree node with a value.
    TreeNode(int val) : value(val), left(nullptr), right(nullptr) {}

};

//Helper function to validate the BST while passing bounds by reference.
bool isValidBSTHelper(TreeNode* node, int& min, int& max) {
    //Base case: If the node is null, it is a valid BST.
    if(!node) return true;

    //Check if the current node violates the BST property:
    //It must be greater than 'min' and less than 'max'.
    if (node->value <= min || node->value >= max) return false;

    //Recursively check the left subtree:
    //Update the 'max' bound to the current node's value.
    if(!isValidBSTHelper(node->left, min, node->value)) return false;

    //Recursively check the right subtree:
    //Update the 'min' bound to the current nodes value.
    if(!isValidBSTHelper(node->right, node->value, max)) return false;

    //If both subtrees are valid, the tree is valid.
    return true;
}

//Wrapper function to start validation with initial bounds.
bool isValidBST(TreeNode* root) {
    int min = INT_MIN; // Smallest possible value for integers
    int max = INT_MAX; // Largest possible value for integers
    return isValidBSTHelper(root, min, max);
}

int main() {
    //Example: A valid BST
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(15);
    root->right->left = new TreeNode(11);
    root->right->right = new TreeNode(20);

    cout << "Is the tree a valid BST? " << (isValidBST(root) ? "Yes" : "No") << endl;

    //Example: An invalid BST (violates the BST property)
    TreeNode* invalidRoot = new TreeNode(10);
    invalidRoot->left = new TreeNode(5);
    invalidRoot->right = new TreeNode(15);
    invalidRoot->right->left = new TreeNode(6); //This violates the BST rule;

    cout << "Is the tree a valid BST? " <<(isValidBST(invalidRoot) ? "Yes" : "No") << endl;

    return 0;
}

/**
 * Explanation:
 * C++ Approach: Using Min/Max Bounds.
 * 
 * Logic: Checks whether each node's value lies within a range (min, max) that is dynamically
 * updated as we recurse.
 * The min and max values are passed by reference for efficiency.
 * 
 * Each nodes has a clear upper and lower bounds for its value, derived from its position in
 * the tree.
 * This ensures correctness even for deep and complex trees.
 */
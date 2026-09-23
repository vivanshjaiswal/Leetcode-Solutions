/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /// THE MAIN PROPERTY OF THE BINARY TREES IS IMPLIED IN THIS QUESTION
    /// IF THE RIGHTMOST HEIGHT AND LEFTMOST HEIGHT ARE EQUAL TO EACH OTHER
    ///THAT MEANS IT IS A COMPLETE BINARY TREE>>
    
    ///

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

     
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

      
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    int getRightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}
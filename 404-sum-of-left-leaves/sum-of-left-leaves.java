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
    public int sumOfLeftLeaves(TreeNode root) { 
        return findSum(root,false);
    }
    private int  findSum(TreeNode root, boolean isLeft){
        if(root==null) return 0;

        //checking the node is left and has no child
        if(root.left==null && root.right==null){
            if(isLeft) return root.val;
            else return 0;
        }
        int leftSum=findSum(root.left,true);
        int rightSum=findSum(root.right,false);

        return leftSum+rightSum;
    }
}
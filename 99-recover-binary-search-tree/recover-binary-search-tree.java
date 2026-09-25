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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();

        inorder(root, list);

        TreeNode first = null;
        TreeNode second = null;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).val > list.get(i).val) {
                if (first == null) {
                    first = list.get(i - 1);
                }
                second = list.get(i);
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
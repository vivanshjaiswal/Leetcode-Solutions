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
    class Pair{
        TreeNode Node;
        long index;

        Pair(TreeNode Node,long index){
            this.Node=Node;
            this.index=index;
            }
            }
    public int widthOfBinaryTree(TreeNode root) {
    if(root==null) return 0;
    Queue<Pair>q=new LinkedList<>();

    q.offer(new Pair(root,0));
    long ans=0;
    while(!q.isEmpty()){
       int size=q.size();
       long left=q.peek().index;
       long right=left;
       for(int i=0;i<size;i++){
        Pair curr=q.poll();
        TreeNode node=curr.Node;
        long index=curr.index;
        right=index;

        if(node.left!=null){
            q.offer(new Pair(node.left,2*index+1));

        }
        if(node.right!=null){
            q.offer(new Pair(node.right,2*index+2));
        }
       }
       ans=Math.max(ans,right-left+1);
    }
    return (int) ans;
    }
}
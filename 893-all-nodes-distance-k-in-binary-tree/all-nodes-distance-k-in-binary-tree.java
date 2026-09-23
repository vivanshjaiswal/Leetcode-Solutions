/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        // Step 1: Parent store karna
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }

        // Step 2: Target se BFS
        Queue<TreeNode> bfs = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        bfs.offer(target);
        visited.add(target);

        int distance = 0;

        while (!bfs.isEmpty()) {

            int size = bfs.size();

            // Agar current level ki distance k hai
            if (distance == k) {

                while (!bfs.isEmpty()) {
                    ans.add(bfs.poll().val);
                }

                return ans;
            }

            // Current level ke saare nodes
            for (int i = 0; i < size; i++) {

                TreeNode node = bfs.poll();

                // Left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    bfs.offer(node.left);
                }

                // Right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    bfs.offer(node.right);
                }

                // Parent
                TreeNode par = parent.get(node);

                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    bfs.offer(par);
                }
            }

            distance++;
        }

        return ans;
    }
}
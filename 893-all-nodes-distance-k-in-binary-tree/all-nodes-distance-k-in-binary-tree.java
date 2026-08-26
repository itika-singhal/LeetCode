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

    public List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        List<Integer> ans = new ArrayList<>();

        // Parent mapping
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        makeParentMap(root, parent);

        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k) {

                for (int i = 0; i < size; i++) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.offer(node.left);
                }

                // Right
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.offer(node.right);
                }

                // Parent
                if (parent.containsKey(node)) {

                    TreeNode p = parent.get(node);

                    if (!visited.contains(p)) {

                        visited.add(p);
                        q.offer(p);
                    }
                }
            }

            distance++;
        }

        return ans;
    }

    private void makeParentMap(TreeNode root,
                                HashMap<TreeNode, TreeNode> parent) {

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
    }
}
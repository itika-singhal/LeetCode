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

    int preIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder,
                           int[] preorder,
                           int left,
                           int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = map.get(rootValue);

        // LEFT first
        root.left = build(
            inorder,
            preorder,
            left,
            rootIndex - 1
        );

        // RIGHT second
        root.right = build(
            inorder,
            preorder,
            rootIndex + 1,
            right
        );

        return root;
    }
}
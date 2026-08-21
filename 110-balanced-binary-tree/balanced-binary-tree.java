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
    private boolean ans = true;
    private int calHe(TreeNode root){
        if(root == null) return 0;
        int left = calHe(root.left);
        int right =calHe(root.right);

        if(Math.abs(left -right)>1){
            ans =false;
        }
        return 1+ Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        calHe(root);
        return ans;
    }
}
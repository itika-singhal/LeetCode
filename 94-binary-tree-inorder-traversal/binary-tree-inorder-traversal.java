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
       public void trav(TreeNode curr, List <Integer> ans){
        if(curr == null) return ;
        trav(curr.left,ans);
        ans.add(curr.val);
         trav(curr.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> ans = new ArrayList<>();
        trav(root,ans);
        return ans;
    }
}
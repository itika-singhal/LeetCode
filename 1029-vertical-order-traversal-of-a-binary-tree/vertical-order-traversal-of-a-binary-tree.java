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
    class NodeInfo{
        TreeNode node;
        int row;
        int col;;

        NodeInfo(TreeNode node,int row,int col){
            this.node=node;
            this.row =row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo>list= new ArrayList<>();
            dfs(root,0,0,list);
            
            Collections.sort(list,(a,b)->{
                if(a.col!=b.col) return a.col-b.col;
                if(a.row!=b.row) return a.row-b.row;

                return a.node.val-b.node.val;
            });
        List<List<Integer>> ans =new ArrayList<>();

        int prevCol=Integer.MIN_VALUE;
        for(NodeInfo info:list){
            if(info.col!=prevCol){
                ans.add(new ArrayList<>());
                prevCol =info.col;
            }
            ans.get(ans.size()-1).add(info.node.val);
        }
        return ans;
    }
    private void dfs(TreeNode node,int row,int col,List<NodeInfo>list){
        if(node==null) return;

        list.add(new NodeInfo(node,row,col));

        dfs(node.left,row+1,col-1,list);
        dfs(node.right,row+1,col+1,list);

    }
}
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
    public boolean isCompleteTree(TreeNode root) {
        boolean flag = false;
        boolean rightChild = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            
            for(int i=0; i<n; i++){
                TreeNode r = q.poll();
                // case 2
                if(flag && (r.left != null || r.right != null)){
                    return false;
                }
                if(r.left != null) {
                    if(rightChild) return false;
                    q.offer(r.left);
                    // case 3
                    if(r.right == null){
                        rightChild = true;
                    }
                    
                } 
                else if(r.left == null && r.right!= null) {
                    // case 1
                    return false;
                }


                if(r.right != null) q.offer(r.right);

                if(r.left == null && r.right == null) {
                    flag = true;
                }
            }
        }
        return true;
    }
}










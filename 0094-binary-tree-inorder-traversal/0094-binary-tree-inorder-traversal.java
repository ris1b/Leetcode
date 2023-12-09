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
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // curr is at my root
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null){
                // when we are at the left most child, we will PROCESS LEFT most node
                // and curr would then process the right sub-tree
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                // we need to visit the right most predecessor of our left sub-tree
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }

                if(temp.right == null){
                    // then we have to connect a way back to the root
                    temp.right = curr;
                    curr = curr.left;
                } else{
                    // we have made all the adjustments to go back to root and pivot
                    // now PROCESS ROOT node, then PROCESS RIGHT sub-tree
                    ans.add(curr.val);
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

}
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
    TreeNode min;
    int diff;
    // TreeNode secMin;
    public int getMinimumDifference(TreeNode root) {
        min = null;
        diff = Integer.MAX_VALUE;
        // secMin = null;
        find(root);

        return diff;
    }
    void find(TreeNode root){
        if(root == null) return;

        find(root.left);
        if (min != null) {
            diff = Math.min(diff, root.val - min.val);
        }
        min = root;
        find(root.right);
    }
}









